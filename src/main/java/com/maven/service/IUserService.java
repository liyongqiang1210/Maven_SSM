package com.maven.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.maven.entity.User;

public interface IUserService {

	public List<User> getAllUser();

	/**
	 * 登录
	 * 
	 * @param map
	 * @return
	 */
	public User login(Map<String, String> map);

	/**
	 * 添加用户
	 * 
	 * @param map
	 * @return
	 */
	public int insertUser(Map<String, String> map);

	/**
	 * 删除用户
	 * 
	 * @param id
	 * @return
	 */
	public int deleteUser(int id);

	/**
	 * 更新用户
	 * 
	 * @param map
	 * @return
	 */
	public int updateUser(Map<String, String> map);

	/**
	 * 转账操作模拟事务 源账户
	 * 
	 * @param sourceUserName
	 *            目标账户
	 * @param targetUserName
	 *            转账金额
	 * @param account
	 */
	public String transferMoney(String sourceUserName, String targetUserName, BigDecimal account);

	/**
	 * 根据用户名查询用户
	 * 
	 * @return
	 */
	public User selectUser(String userName);
}
