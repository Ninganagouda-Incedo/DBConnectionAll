package com.hibernate;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ConnectionCheck {
	
	private static SessionFactory factory; 
	public static void main(String[] args) {
		System.out.println("---------------------- Hibernate Connection Started For MYSQL ------------------");
		try
		{
	        factory = new Configuration().configure().buildSessionFactory();
	        Session session = factory.openSession();
	        Transaction tx = session.beginTransaction();
	        List<NetworkSystem> list = session.createQuery("from NetworkSystem").list();
	        for(NetworkSystem system:list)
	        {
	        	System.out.println(system.getSystemId()+"\t"+system.getSystemName());
	        }
	        
	    }
		catch (Throwable ex)
		{ 
	         System.out.println(""+ex.getMessage());
	         throw new ExceptionInInitializerError(ex); 
	    }
		
		System.out.println("---------------------- Hibernate Connection Ended For MYSQL ------------------");
	}
}
