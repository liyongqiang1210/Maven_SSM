package com.webcollector.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.webcollector.util.DateUtil;


public class JDBCTemplate {

	//创建Statement\PreparedStatement对象
	Connection conn = null;
	PreparedStatement ps = null;
	private final String URL = "jdbc:mysql://localhost:3306/maven";
	private final String USER = "root";
	private final String PASSWORD = "root";
	private Log log = LogFactory.getLog(JDBCTemplate.class);
	public void jdbc(String type,String title, String web_url, String release_time, String source, String text) {
		//获取UUID
		String news_id = UUID.randomUUID().toString();
		String text_id = UUID.randomUUID().toString();
		//加载JDBC驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//获得数据库连接
			try {
				conn = DriverManager.getConnection(URL, USER, PASSWORD);
				//所要执行的sql语句
				String sql_news = "insert into news (id,type,title,source,web_url,release_time,create_time) value (?,?,?,?,?,?,?)";
				String sql_text = "insert into news_text (id,text,news_id,create_time) value (?,?,?,?)";
				//设置事务提交方式为手动提交
				conn.setAutoCommit(false);
				
				ps = conn.prepareStatement(sql_news);
				ps.setString(1, news_id);
				ps.setString(2, type);
				ps.setString(3, title);
				ps.setString(4, source);
				ps.setString(5, web_url);
				ps.setString(6, release_time);
				ps.setString(7, new DateUtil().getToday());
				int executeUpdate = ps.executeUpdate();
				
				ps = conn.prepareStatement(sql_text);
				ps.setString(1, text_id);
				ps.setString(2, text);
				ps.setString(3, news_id);
				ps.setString(4, new DateUtil().getToday());
				int executeUpdate2 = ps.executeUpdate();
				
				if(!(executeUpdate == 1&&executeUpdate2 ==1)){
					conn.rollback();
					log.debug("信息添加失败！");
				}else if(executeUpdate == 1&&executeUpdate2 ==1){
					//提交事务
					conn.commit();
					log.debug("信息添加成功！");
				}
			} catch (SQLException e) {
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				log.debug("sql异常："+e.getMessage());
			}
			
		} catch (ClassNotFoundException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			log.debug("类找不到异常："+e.getMessage());
		}finally{
			
		
			try {
				//关闭连接
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	/*
	
		public void jdbc_website_two(String name, String url, String create_time, String creater,String sql) {
			JdbcTemplate jdbcTemplate = null;
			try {
				jdbcTemplate = JDBCHelper.createMysqlTemplate("maven",
						"jdbc:mysql://localhost:3306/maven", "root", "root",
						0, 20);
				if (jdbcTemplate != null) {
					int updates = jdbcTemplate.update(
							sql,
							UUID.randomUUID().toString(), name, url, create_time, creater
							);
					if (updates == 1) {
						log.debug(name+"  插入成功");
					}
				}
			} catch (Exception ex) {
				jdbcTemplate = null;
				log.error("错误信息："+ex);
				//System.out.println("mysql未开启或JDBCHelper.createMysqlTemplate中参数配置不正确!");
			}
	}*/
	
	
}
