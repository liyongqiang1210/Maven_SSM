package com.webcollector.taobao.nanzhuang;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jsoup.Connection.Method;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.webcollector.jdbc.JDBCTemplate_taobao;
import com.webcollector.sina.domestic.Crawler_gdxw;
import com.webcollector.util.DateUtil;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;

public class Crawler_chenshan extends BreadthCrawler {
	private String URL = "https://jingxuan.tmall.com/sem/tmsearch?spm=a2e1o.8267851.07626516003.2.54f025dbuyFYKu&keyword=%E8%A1%AC%E8%A1%AB%E7%94%B7&refpid=mm_10011550_0_0&clk1=3fd27aa72174ff10a37d79e217d156e3&page=1&_input_charset=utf-8";
	private Log log = LogFactory.getLog(Crawler_gdxw.class);

	public Crawler_chenshan(String crawlPath, boolean autoParse) {
		super(crawlPath, autoParse);
		this.addSeed(URL);
		for (int i = 1; i < 101; i++) {
			this.addSeed(
					"https://jingxuan.tmall.com/sem/tmsearch?spm=a2e1o.8267851.07626516003.2.54f025dbuyFYKu&keyword=%E8%A1%AC%E8%A1%AB%E7%94%B7&refpid=mm_10011550_0_0&clk1=3fd27aa72174ff10a37d79e217d156e3&page="+i+"&_input_charset=utf-8");
		}

	}

	public void visit(Page page, CrawlDatums next) {
		JDBCTemplate_taobao jdbc = new JDBCTemplate_taobao();
		int tb_goods_payment = 0;
		int tb_goods_is_free_shipping = 0;
		String creater = "liyongqiang";
		String tb_goods_title = null;
		String tb_shop_name = null;
		String tb_shop_url = null;
		String tb_goods_url = null;
		String tb_goods_price = null;
		try {
			@SuppressWarnings("deprecation")
			Document doc = page.getDoc();
			Elements els = doc.select("div.item");
			int i = 1;
			for (Element el : els) {
				String regex = "[\u4e00-\u9fa5]";
				Pattern pa = Pattern.compile(regex);
				Matcher ma = pa.matcher(el.select("span.payNum").text());
				if (ma.replaceAll("") != null && !ma.replaceAll("").equals("")) {
					tb_goods_payment = Integer.parseInt(ma.replaceAll(""));
				}

				tb_goods_title = el.select("span.title").text();
				tb_shop_name = el.select("span.shopNick").text();
				tb_goods_price = el.select("span.pricedetail > strong").text();
				if (el.select("span.postalicon").text() == null || el.select("span.postalicon").text().equals("")) {
					tb_goods_is_free_shipping = 1;
				}
				Elements els_href = el.select("div.item > a");
				for (Element el_href : els_href) {
					tb_goods_url = el_href.absUrl("href");
				}
				Document els_doc = Jsoup.connect(tb_goods_url).method(Method.GET).execute().parse();
				Elements els_shop = els_doc.select("div.slogo > a");
				for (Element el_shop : els_shop) {
					tb_shop_url = el_shop.absUrl("href");
				}
				int j = jdbc.selectGoods(tb_goods_url);
				int h = jdbc.selectShop(tb_shop_url);
				if (j < 1 && h < 1) {
					log.debug("#####################第" + i + "条#########################");
					log.debug("###########付款人数：" + tb_goods_payment);
					log.debug("###########商品标题：" + tb_goods_title);
					log.debug("###########商品价格：" + tb_goods_price);
					log.debug("###########店铺名：" + tb_shop_name);
					log.debug("###########是否包邮：" + tb_goods_is_free_shipping);
					log.debug("###########商品URL：" + tb_goods_url);
					log.debug("###########店铺URL：" + tb_shop_url);
					log.debug("###########创建人：" + creater);
					log.debug("###########创建时间：" + new DateUtil().getYMDHMS());
					log.debug("##############################################");

					jdbc.insertShopAndGoods(creater, tb_shop_name, tb_shop_url, tb_goods_price, tb_goods_url,
							tb_goods_title, tb_goods_payment, tb_goods_is_free_shipping);

					i++;
				} else {
					log.debug("###############################################");
					log.debug("数据库已经存在这条商品信息：" + tb_goods_title);
					log.debug("###############################################");
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		Crawler_chenshan cw = new Crawler_chenshan("crawl", true);
		cw.setThreads(50);
		cw.setTopN(1000);
		cw.start(10);

	}

}
