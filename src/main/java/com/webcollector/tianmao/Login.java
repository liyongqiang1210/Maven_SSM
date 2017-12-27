package com.webcollector.tianmao;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Connection.Method;
import org.jsoup.Jsoup;

public class Login {
	private static final String URL = "https://login.taobao.com/member/login.jhtml?redirectURL=https%3A%2F%2Flist.tmall.hk%2Fsearch_product.htm%3Fspm%3Da2231.7718719.2014120102.3.502d25e7lYjRLn%26acm%3Dlb-zebra-34359-425786.1003.4.536907%26q%3D%25C3%25E6%25B2%25BF%25BB%25A4%25C0%25ED%26from%3Dtmallhk.list.pc_1_searchbutton%26type%3Dp%26scm%3D1003.4.lb-zebra-34359-425786.OTHER_3_536907";

	// 获取天猫用户登录的cookies
	public static final Map<String, String> getCookies_Tmall(String username, String password) throws IOException {
		Map<String, String> map = new HashMap<String, String>();
		map.put("TPL_username", username);
		map.put("TPL_password", password);
		Map<String, String> cookies = Jsoup.connect(URL).data(map).method(Method.POST).execute().cookies();
		System.out.println(Jsoup.connect(URL).data(map).method(Method.GET).execute().body());
		return cookies;
	}
}