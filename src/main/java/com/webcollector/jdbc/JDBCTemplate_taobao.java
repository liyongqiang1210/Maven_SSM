package com.webcollector.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.webcollector.util.DateUtil;

/**
 * 
 * @author Li Yongqiang
 *
 */
public class JDBCTemplate_taobao {

	Connection conn = null;
	PreparedStatement ps = null;
	private final String URL = "jdbc:mysql://localhost:3306/maven";
	private final String USER = "root";
	private final String PASSWORD = "root";
	private Log log = LogFactory.getLog(JDBCTemplate_taobao.class);

	/**
	 * 插入商品与店铺信息
	 * 
	 * @param creater
	 * @param tb_shop_name
	 * @param tb_shop_url
	 * @param tb_shop_creater
	 * @param tb_goods_title
	 * @param tb_goods_payment
	 * @param tb_goods_is_free_shipping
	 */
	public void insertShopAndGoods(String creater, String tb_shop_name, String tb_goods_price, String tb_shop_url,
			String tb_goods_url, String tb_goods_title, int tb_goods_payment, int tb_goods_is_free_shipping) {
		// 获取UUID
		String tb_goods_id = UUID.randomUUID().toString();
		String tb_shop_id = UUID.randomUUID().toString();
		// 加载JDBC驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");

			try {
				// 获得数据库连接
				conn = DriverManager.getConnection(URL, USER, PASSWORD);
				int i = 0;
				int j = 0;
				// 查询店铺信息的sql
				String selectShop_sql = "select tb_shop_id from taobao_shop where tb_shop_name = ?";
				// 查询商品信息sql
				String selectGoods_sql = "select tb_goods_id from taobao_goods where tb_goods_title = ?";
				// 插入店铺信息sql
				String sql_shop = "insert into taobao_shop (tb_shop_id,tb_shop_name,tb_shop_url,tb_shop_create_time,tb_shop_creater) value (?,?,?,?,?)";
				// 插入商品信息sql
				String sql_goods = "insert into taobao_goods (tb_goods_id,tb_goods_title,tb_goods_price,tb_goods_shop_id,tb_goods_is_free_shipping,tb_goods_create_time,tb_goods_creater,tb_goods_url,tb_goods_payment) value (?,?,?,?,?,?,?,?,?)";

				// 设置事务提交方式为手动提交
				conn.setAutoCommit(false);

				// 查询是否存在此条商品信息
				ps = conn.prepareStatement(selectGoods_sql);
				ps.setString(1, tb_goods_title);
				ResultSet rs_goods = ps.executeQuery();
				if (rs_goods.next()) {
					i = 1;
				}

				// 查看是否存在此条店铺信息如果存在获取其id
				ps = conn.prepareStatement(selectShop_sql);
				ps.setString(1, tb_shop_name);
				ResultSet rs_shop = ps.executeQuery();
				while (rs_shop.next()) {
					if (rs_shop.getString(1) != "") {
						tb_shop_id = rs_shop.getString(1);
					}
					log.debug("-----------------------------------------------------------------");
					log.debug("店铺id:(" + tb_shop_id + ")");
					log.debug("-----------------------------------------------------------------");
					j = 1;
				}

				// 只有当前商品不存在数据库时才进行插入操作

				// 当商品与店铺信息都不存在时进入此方法
				if (i != 1 && j != 1) {
					// 插入店铺信息
					int executeUpdate_shop = insertShop(creater, tb_shop_name, tb_shop_url, tb_shop_id, sql_shop);

					// 插入商品信息
					int executeUpdate_goods = insertGoods(creater, tb_goods_price, tb_goods_url, tb_goods_title,
							tb_goods_payment, tb_goods_is_free_shipping, tb_goods_id, tb_shop_id, sql_goods);

					if (!(executeUpdate_goods == 1 && executeUpdate_shop == 1)) {
						// 事务回滚
						conn.rollback();
						log.debug("信息添加失败！");
					} else if (executeUpdate_goods == 1 && executeUpdate_shop == 1) {
						// 提交事务
						conn.commit();
						log.debug("-----------------------------------------------------------------");
						log.debug(tb_goods_title + "商品信息添加成功！");
						log.debug(tb_shop_name + "店铺信息添加成功！");
						log.debug("-----------------------------------------------------------------");
					}
				}

				// 当商品信息不存在店铺信息存在时进入此方法
				else if (i != 1 && j == 1) {

					int executeUpdate_goods = insertGoods(creater, tb_goods_price, tb_goods_url, tb_goods_title,
							tb_goods_payment, tb_goods_is_free_shipping, tb_goods_id, tb_shop_id, sql_goods);
					if (executeUpdate_goods == 1) {
						conn.commit();
						log.debug("-----------------------------------------------------------------");
						log.debug(tb_goods_title + "此商品信息添加成功！");
						log.debug(tb_shop_name + "此店铺信息已经存在，请勿重复添加！");
						log.debug("-----------------------------------------------------------------");
					} else {
						conn.rollback();
						log.debug("-----------------------------------------------------------------");
						log.debug("************************" + tb_goods_title + "此商品信息添加失败！");
						log.debug("-----------------------------------------------------------------");
					}

				}

				// 商品信息与店铺信息都存在时进入
				else {
					log.debug("-----------------------------------------------------------------");
					log.debug("" + tb_goods_title + "此条商品信息已经存在，请勿重复添加！");
					log.debug("-----------------------------------------------------------------");
				}

			} catch (SQLException e) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				log.debug("sql异常：" + e.getMessage());
			}

		} catch (ClassNotFoundException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			log.debug("类找不到异常：" + e.getMessage());
		} finally {

			try {
				// 关闭连接
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	// 插入商品信息的方法
	private int insertGoods(String creater, String tb_goods_price, String tb_goods_url, String tb_goods_title,
			int tb_goods_payment, int tb_goods_is_free_shipping, String tb_goods_id, String tb_shop_id,
			String sql_goods) throws SQLException {
		ps = conn.prepareStatement(sql_goods);
		ps.setString(1, tb_goods_id);
		ps.setString(2, tb_goods_title);
		ps.setString(3, tb_goods_price);
		ps.setString(4, tb_shop_id);
		ps.setInt(5, tb_goods_is_free_shipping);
		ps.setString(6, new DateUtil().getYMDHMS());
		ps.setString(7, creater);
		ps.setString(8, tb_goods_url);
		ps.setInt(9, tb_goods_payment);
		int executeUpdate_goods = ps.executeUpdate();
		return executeUpdate_goods;
	}

	// 插入店铺信息的方法
	private int insertShop(String creater, String tb_shop_name, String tb_shop_url, String tb_shop_id, String sql_shop)
			throws SQLException {
		ps = conn.prepareStatement(sql_shop);
		ps.setString(1, tb_shop_id);
		ps.setString(2, tb_shop_name);
		ps.setString(3, tb_shop_url);
		ps.setString(4, new DateUtil().getYMDHMS());
		ps.setString(5, creater);
		int executeUpdate_shop = ps.executeUpdate();
		return executeUpdate_shop;
	}

}
