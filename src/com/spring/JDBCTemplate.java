package com.spring;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class JDBCTemplate {

	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	public void setDataSource(DataSource dataSource) {
	      this.dataSource = dataSource;
	      this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	   }
	public List<NetworkSystem> listNetworks() {
	      String SQL = "select * from NetworkSytem";
	      List <NetworkSystem> students = jdbcTemplateObject.query(SQL, new NetworkRowMapper());
	      return students;
	   }
}
