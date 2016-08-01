package com.nikhil.beatme;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nikhil.beatme.dao.UserDAO;
import com.nikhil.beatme.model.User;

public class UserTest {
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		context.scan("com.nikhil.beatme");
		context.refresh();
		
		UserDAO userDAO = (UserDAO) context.getBean("userDAO");
		
		User user = (User) context.getBean("user");
		user.setId("USR002");
		user.setName("USRName001");
		user.setPassword("******");
		user.setMobile("8891XXXXXX");
		user.setEmail("user1@niit.com");
		user.setAddress("USRAddress001");
		userDAO.saveOrUpdate(user);

//		System.out.println("No. of users"+ userDAO.list().size());
		
/*		
		if(userDAO.get("USR000") == null)
		{
			System.out.println("User does not exist..");
		}
		else
		{
			System.out.println("User exist... The Details are...");
			System.out.println();
		}
*/
		
//		userDAO.delete("USR002");
		
		
	}

}