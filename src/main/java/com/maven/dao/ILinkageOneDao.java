package com.maven.dao;

import java.util.List;
import java.util.Map;

import com.maven.entity.Linkage_One;

/**
 * 一级联动菜单接口
 * 
 * @author Li Yongqiang
 *
 */
public interface ILinkageOneDao {

	/**
	 * 一级联动菜单查询接口
	 * 
	 * @return
	 */
	public List<Linkage_One> selectLinkage_one(int page);

	/**
	 * 添加一级联动菜单接口
	 * @param lo
	 * @return
	 */
	public int insertLinkage_one(Linkage_One lo);

	/**
	 * 修改
	 * 
	 * @param lo_id
	 * @param lo_name
	 * @return
	 */
	public int updateLinkage_one(Linkage_One lo);

	/**
	 * 删除
	 * 
	 * @param lo_id
	 * @return
	 */
	public String deleteLinkage_one(String lo_id);
	
	/**
	 * 查询数据总条数
	 * @return
	 */
	public Integer selectDataTotal();
	
	/**
	 * 获取当前页数据
	 * @param start
	 * @return
	 */
	public List<Linkage_One> getCurrentData(Map<String,Integer> map);
}
