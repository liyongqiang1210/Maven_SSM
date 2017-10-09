package com.maven.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.maven.entity.User;
import com.maven.service.IUserService;

/**
 * 测试git是否提交
 * @author liyongqiang
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@Resource
	private IUserService userService;
	/**
	 * 用户登录
	 * 
	 * @param req
	 * @param mv
	 * @return
	 */
	@RequestMapping("/login")
	public String login(HttpServletRequest req, Model model) {

		Map<String, String> map = new HashMap<String, String>();
		map.put("username", req.getParameter("username"));
		map.put("password", req.getParameter("password"));
		User user = userService.login(map);
		String str;
		if (user != null) {
			str = "jsp/main";
		} else {

			model.addAttribute("message", "用户名或密码输入错误");
			str = "jsp/login";
		}
		return str;

	}

	/**
	 * 获取user的json数据
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/getUserList")
	@ResponseBody
	public JSONArray userList(HttpServletRequest request) {
		// 返回的是List集合
		List<User> uList = userService.getAllUser();
		// 创建一个JSONArray
		JSONArray json = new JSONArray();
		// 遍历List集合然后放到JSONArray中
		for (User user : uList) {
			// 这里需要创建一个JSONObject对象，然后我们将遍历的List集合中的数据放到JSONObject中
			JSONObject js = new JSONObject();
			js.put("id", user.getId());
			js.put("username", user.getUsername());
			js.put("password", user.getPassword());
			// 最后将json对象放到JSONArray中
			json.add(js);
		}
		return json;
	}

	/**
	 * 跳转到userList页面的方法
	 * 
	 * @return
	 */
	@RequestMapping("/toUserList")
	public String toUserList() {

		return "jsp/userList";

	}

	/**
	 * 添加user
	 * 
	 * @param req
	 * @param model
	 * @return
	 */
	@RequestMapping("/insertUser")
	public String insertUser(HttpServletRequest req, ModelMap modelMap) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("username", req.getParameter("username"));
		map.put("password", req.getParameter("password"));
		int i = userService.insertUser(map);
		if (i == 1) {
			modelMap.put("status", "success");
		} else {
			modelMap.put("status", "fail");
		}
		return null;

	}

	@RequestMapping("/deleteUser")
	public String deleteUser(HttpServletRequest req, ModelMap modelMap) {
		int i = userService.deleteUser(Integer.parseInt(req.getParameter("id")));
		if (i == 1) {
			modelMap.put("status", "success");
		} else {
			modelMap.put("status", "fail");
		}
		return null;

	}
	
	@RequestMapping("/selectUser")
	public void selectUser(HttpServletRequest req){
		User user = userService.selectUser(req.getParameter("userName"));
		System.out.println(user.getAccount());
	}

	/**
	 * 转账
	 * @param req
	 */
	@RequestMapping("/transfer")
	public String transfer(HttpServletRequest req) {

		String sourceUserName = "zhangsan";
		String targetUserName = "liyongqiang";
		String money = "1000";

		System.out.println("转账前账户余额：");
		System.out.println("a账户：" + userService.selectUser(sourceUserName).getAccount());
		System.out.println("b账户：" + userService.selectUser(targetUserName).getAccount());

		BigDecimal bd = new BigDecimal(money);
		// 开始转账
		String str = userService.transferMoney(sourceUserName, targetUserName, bd);

		System.out.println("转账后账户余额：");
		System.out.println("a账户：" + userService.selectUser(sourceUserName).getAccount());
		System.out.println("b账户：" + userService.selectUser(targetUserName).getAccount());
		if(str.equals("success")){
			return "success";
		}else {
			return "error";
		}
		
	}

}
