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
	public void insertShopAndGoods(String creater, String tb_shop_name, String tb_shop_url, String tb_goods_price,String tb_goods_url,
			String tb_goods_title, int tb_goods_payment, int tb_goods_is_free_shipping) {
		// 获取UUID
		String tb_goods_id = UUID.randomUUID().toString();
		String tb_shop_id = UUID.randomUUID().toString();
		// 加载JDBC驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");

			try {
				// 获得数据库连接
				conn = DriverManager.getConnection(URL, USER, PASSWORD);
				// 插入店铺信息
				String sql_shop = "insert into taobao_shop (tb_shop_id,tb_shop_name,tb_shop_url,tb_shop_create_time,tb_shop_creater) value (?,?,?,?,?)";
				// 插入商品信息
				String sql_goods = "insert into taobao_goods (tb_goods_id,tb_goods_title,tb_goods_price,tb_goods_shop_id,tb_goods_is_free_shipping,tb_goods_create_time,tb_goods_creater,tb_goods_url,tb_goods_payment) value (?,?,?,?,?,?,?,?,?)";

				// 设置事务提交方式为手动提交
				conn.setAutoCommit(false);
				// 实现插入操作

				ps = conn.prepareStatement(sql_shop);
				ps.setString(1, tb_shop_id);
				ps.setString(2, tb_shop_name);
				ps.setString(3, tb_shop_url);
				ps.setString(4, new DateUtil().getYMDHMS());
				ps.setString(5, creater);
				int executeUpdate2 = ps.executeUpdate();

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
				int executeUpdate = ps.executeUpdate();

				if (!(executeUpdate == 1 && executeUpdate2 == 1)) {
					conn.rollback();
					log.debug("信息添加失败！");
				} else if (executeUpdate == 1 && executeUpdate2 == 1) {
					// 提交事务
					conn.commit();
					log.debug("信息添加成功！");
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

	/**
	 * 根据商品URL判断是否存在此条商品的信息
	 * 
	 * @param title
	 * @return
	 */
	public int selectGoods(String tb_goods_url) {
		int i = 0;
		String select_sql = "select tb_goods_id from taobao_goods where tb_goods_url = ?";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				conn = DriverManager.getConnection(URL, USER, PASSWORD);
				ps = conn.prepareStatement(select_sql);
				ps.setString(1, tb_goods_url);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					i = 1;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return i;
	}

	/**
	 * 查询此店铺信息是否存在
	 * 
	 * @param tb_shop_name
	 * @return
	 */
	public int selectShop(String tb_shop_url) {
		int i = 0;
		String select_sql = "select tb_shop_id from taobao_shop where tb_shop_url = ?";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				conn = DriverManager.getConnection(URL, USER, PASSWORD);
				ps = conn.prepareStatement(select_sql);
				ps.setString(1, tb_shop_url);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					i = 1;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return i;
	}

}
