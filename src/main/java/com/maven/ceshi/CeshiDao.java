package com.maven.ceshi;

import java.io.Reader;
import java.util.Date;
import java.util.UUID;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.maven.dao.IDictionaryDao;

public class CeshiDao {
	private static SqlSessionFactory sqlSessionFactory;
	private static Reader reader;
	static {
		try {
			reader = Resources.getResourceAsReader("spring-db.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			sqlSessionFactory.getConfiguration().addMapper(IDictionaryDao.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static SqlSessionFactory getSession() {
		return sqlSessionFactory;
	}

	public static void main(String[] args) {
		/* SqlSession session = sqlSessionFactory.openSession();
	        try {
	            IDictionaryDao dictDao = session.getMapper(IDictionaryDao.class);
	            System.out.println(dictDao.selectAllDictionary());
	        } finally {
	            session.close();
	        }*/
		UUID uuid = UUID.randomUUID();
		System.out.println(uuid.toString());
		System.out.println(new Date().getYear());
	}
}
