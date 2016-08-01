package com.nikhil.beatme;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nikhil.beatme.dao.CategoryDAO;
import com.nikhil.beatme.model.Category;

public class CategoryTest {
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		context.scan("com.nikhil.beatme");
		context.refresh();

		CategoryDAO categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
		
		Category category = (Category) context.getBean("category");
		category.setId("CG001");
		category.setName("CGName001");
		category.setDescription("CGDesc001");
		categoryDAO.saveOrUpdate(category);

/*		
		if(categoryDAO.get("CGID000") == null)
		{
			System.out.println("Category does not exist...");
		}
		else
		{
			System.out.println("Category exist... The Details are...");
			System.out.println();
		}

*/

//		categoryDAO.delete("CG002");
		
		
	}

}