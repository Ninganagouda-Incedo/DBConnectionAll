package com.spring;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class ConnectionCheck {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		JDBCTemplate template = (JDBCTemplate) context.getBean("JDBCTemplate");
		List<NetworkSystem> networks = template.listNetworks();
		
		for(NetworkSystem network: networks)
		{
			System.out.println(network.getSystemId()+"\t"+network.getSystemName());
		}
	}
}
