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
public class JDBCTemplate_bokeyuan {

	Connection conn = null;
	PreparedStatement ps = null;
	private final String URL = "jdbc:mysql://localhost:3306/maven";
	private final String USER = "root";
	private final String PASSWORD = "root";
	private Log log = LogFactory.getLog(JDBCTemplate_bokeyuan.class);

	/**
	 * 向数据库添加数据
	 * 
	 * @param type
	 * @param title
	 * @param web_url
	 * @param release_time
	 * @param source
	 * @param text
	 */
	public void insertNews(String type, String title, String url) {
		// 获取UUID
		String bky_id = UUID.randomUUID().toString();
		// 加载JDBC驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");

			try {
				// 获得数据库连接
				conn = DriverManager.getConnection(URL, USER, PASSWORD);
				// 所要执行的sql语句
				String sql_bokeyuan = "insert into news (id,type,title,url) value (?,?,?,?)";
				// 设置事务提交方式为手动提交
				conn.setAutoCommit(true);
				// 实现插入操作
				ps = conn.prepareStatement(sql_bokeyuan);
				ps.setString(1, bky_id);
				ps.setString(2, type);
				ps.setString(3, title);
				ps.setString(4, url);
				int executeUpdate = ps.executeUpdate();

				if (executeUpdate < 1) {
					log.debug("信息添加失败！");
				} else {

					log.debug("信息添加成功！");
				}
			} catch (SQLException e) {

				log.debug("sql异常：" + e.getMessage());
			}

		} catch (ClassNotFoundException e) {

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
	 * 判断是否存在此条文章
	 * 
	 * @param title
	 * @return
	 */
	public int getTitle(String url) {
		int i = 0;
		String select_sql = "select bky_id from bokeyuan_text_url where bky_url = ?";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				conn = DriverManager.getConnection(URL, USER, PASSWORD);
				ps = conn.prepareStatement(select_sql);
				ps.setString(1, url);
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
