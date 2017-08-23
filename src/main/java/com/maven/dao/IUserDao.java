package com.maven.dao;

import java.util.List;
import java.util.Map;

import com.maven.entity.User;

/**
 * 
 * @author liyongqiang
 *
 */
public interface IUserDao {

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
	 * 加钱 账户
	 * 
	 * @param userName
	 *            转账金额
	 * @param account
	 */
	public void addMoney(Map<String, Object> map);

	/**
	 * 减钱
	 * 
	 * @param userName
	 * @param account
	 */
	public void subtractMoney(Map<String, Object> map);

	/**
	 * 根据用户名查找用户
	 * 
	 * @param sourceUserName
	 * @return
	 */
	public User selectUser(String userName);
}
