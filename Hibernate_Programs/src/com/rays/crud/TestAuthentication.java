package com.rays.crud;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.rays.dto.UserDTO;

public class TestAuthentication {

	public static void main(String[] args) {
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
		Session s = sf.openSession();
		
		Criteria criteria = s.createCriteria(UserDTO.class);
		
		criteria.add(Restrictions.eq("login", "richa@gmail.com"));
		criteria.add(Restrictions.eq("password", "1234"));
		
		List<UserDTO> list = criteria.list();
		
		UserDTO dto = null;
		
		if(list.size()==1) {
			
			dto = new UserDTO();
			dto = list.get(0);
			System.out.println(dto.getId());
			System.out.println(dto.getFirstName());
			System.out.println(dto.getLastName());
			System.out.println(dto.getLogin());
			System.out.println(dto.getPassword());
		}else {
			System.out.println("something is wrong");
		}
		
	}
}
