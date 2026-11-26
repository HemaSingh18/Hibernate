package com.rays.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.rays.dto.UserDTO;

public class TestInsert {

	public static void main(String[] args) {
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
		Session s = sf.openSession();
		
		Transaction t = s.beginTransaction();
	
		UserDTO dto = new UserDTO();
		dto.setFirstName("Rahul");
		dto.setLastName("Singh");
		dto.setLogin("rahul@gmail.com");
		dto.setPassword("123");
		//dto.setId(2);
		s.save(dto);
		//s.update(dto);
		//s.delete(dto);
		
		t.commit();
	}
}
