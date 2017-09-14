package com.webcollector.tianmao;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Connection.Method;
import org.jsoup.Jsoup;

public class Login {
	private static final String URL = "https://login.taobao.com/member/login.jhtml?from=taobaoindex&f=top&style=&sub=true&redirect_url=https%3A%2F%2Fi.taobao.com%2Fmy_taobao.htm%3Fspm%3Da2156.1676643.a2226mz.7.6d6d1d2b0IWBBX";

	// 获取用户登录的cookies
	public Map<String, String> getCookies(String username, String password) throws IOException {
		Map<String, String> map = new HashMap<String, String>();
		map.put("TPL_username", username);
		map.put("TPL_password", password);
		Map<String, String> cookies = Jsoup.connect(URL).data(map).method(Method.POST).execute().cookies();
		return cookies;
	}
}