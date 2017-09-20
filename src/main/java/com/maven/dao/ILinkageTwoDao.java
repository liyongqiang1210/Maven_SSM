package com.maven.dao;

import java.util.List;

import com.maven.entity.Linkage_Two;

/**
 * 二级联动菜单
 * @author Li Yongqiang
 *
 */
public interface ILinkageTwoDao {

	/**
	 * 二级菜单查询接口
	 * @return
	 */
	public List<Linkage_Two> selectLinkage_two();
	
	/**
	 * 添加二级菜单接口
	 * @param lo_name
	 * @return
	 */
	public String insertLinkage_two(String lo_name);
	
	/**
	 * 修改二级菜单接口
	 * @param lo_id
	 * @param ltw_name
	 * @param ltw_id
	 * @return
	 */
	public String updateLinkage_two(String lo_id,String ltw_name,String ltw_id);
	
	/**
	 * 删除二级菜单接口
	 * @param ltw_id
	 * @return
	 */
	public String deleteLinkage_two(String ltw_id);
}
