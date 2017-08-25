package com.webcollector.jdbc;

import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import com.webcollector.util.DateUtil;

public class JDBCTemplate {

	private Log log = LogFactory.getLog(JDBCTemplate.class);
	public void jdbc(String type,String title, String web_url, String release_time, String source, String text,String sql) {
		JdbcTemplate jdbcTemplate = null;
		try {
			jdbcTemplate = JDBCHelper.createMysqlTemplate("maven",
					"jdbc:mysql://localhost:3306/maven", "root", "root",
					0, 20);
			if (jdbcTemplate != null) {
				int updates = jdbcTemplate.update(
						sql,
						UUID.randomUUID().toString(), type, title, text, source, web_url, release_time,new DateUtil().getToday()
						);
				if (updates == 1) {
					log.debug(title+"  插入成功");
				}
			}
		} catch (Exception ex) {
			jdbcTemplate = null;
			log.error("错误信息："+ex);
			//System.out.println("mysql未开启或JDBCHelper.createMysqlTemplate中参数配置不正确!");
		}
	}
}
