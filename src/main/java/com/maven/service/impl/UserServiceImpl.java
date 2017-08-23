package com.maven.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maven.dao.IUserDao;
import com.maven.entity.User;
import com.maven.service.IUserService;

@Service("UserService")
public class UserServiceImpl implements IUserService {

	@Resource
	private IUserDao userDao;

	public List<User> getAllUser() {
		return userDao.getAllUser();
	}

	public int deleteUser(int id) {
		// TODO Auto-generated method stub
		return userDao.deleteUser(id);
	}

	public User login(Map<String, String> map) {
		// TODO Auto-generated method stub
		return userDao.login(map);
	}

	public int insertUser(Map<String, String> map) {
		// TODO Auto-generated method stub
		return userDao.insertUser(map);
	}

	public int updateUser(Map<String, String> map) {
		// TODO Auto-generated method stub
		return userDao.updateUser(map);
	}
	@Transactional(rollbackFor=Exception.class)
	public String transferMoney(String sourceUserName, String targetUserName, BigDecimal account) {
		// 查询转出账户
		User sourceUser = userDao.selectUser(sourceUserName);
		// 转出账户的余额
		BigDecimal sourceMoney = sourceUser.getAccount();

		Map<String, Object> subtractMap = new HashMap<String, Object>();
		subtractMap.put("username", sourceUserName);
		subtractMap.put("account", account);
		Map<String, Object> addMap = new HashMap<String, Object>();
		addMap.put("username", targetUserName);
		addMap.put("account", account);
		// 判断账户余额是否有那么多钱
		try {
			if (sourceMoney.compareTo(account) != -1) {
				//此处回滚
				userDao.subtractMoney(subtractMap);
				userDao.addMoney(addMap);
				return "success";
			}else{
				return "error";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
		

	}

	public User selectUser(String userName) {
		// TODO Auto-generated method stub
		return userDao.selectUser(userName);
	}
}
