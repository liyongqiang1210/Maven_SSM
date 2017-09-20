package com.maven.dao;

import java.util.List;

import com.maven.entity.Linkage_Three;

/**
 * 三级联动菜单接口
 * @author Li Yongqiang
 *
 */
public interface ILinkageThreeDao {

	/**
	 * 三级菜单查询接口
	 * @return
	 */
	public List<Linkage_Three> selectLinkage_three();
	/**
	 * 添加三级联动菜单
	 * @param lth_name
	 * @param ltw_id
	 * @return
	 */
	public String insertLinkage_three(String lth_name,String ltw_id);
	
	/**
	 * 修改
	 * @param ltw_id
	 * @param lth_name
	 * @param lth_id
	 * @return
	 */
	public String updateLinkage_three(String ltw_id,String lth_name,String lth_id);
	
	/**
	 * 删除
	 * @param lth_id
	 * @return
	 */
	public String deleteLinkage_three(String lth_id);
}
