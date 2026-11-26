package com.rays.crud;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.rays.dto.UserDTO;

public class TestFindByLogin {

	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
		Session s = sf.openSession();
		
		Criteria criteria = s.createCriteria(UserDTO.class); //select * from UserDTO where 1=1
		
		criteria.add(Restrictions.eq("login", "richa@gmail.com")); // and login='neha@gmail.com'
	
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
