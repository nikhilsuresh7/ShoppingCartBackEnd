package com.nikhil.beatme;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nikhil.beatme.dao.ProductDAO;
import com.nikhil.beatme.model.Product;

public class ProductTest {
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		context.scan("com.nikhil.beatme");
		context.refresh();

		ProductDAO productDAO = (ProductDAO) context.getBean("productDAO");
		
		Product product = (Product) context.getBean("product");
		product.setId("PD001");
		product.setName("PDName001");
		product.setDescription("PDDesc001");
		product.setPrice("10000");
		productDAO.saveOrUpdate(product);

/*		
		if(productDAO.get("PDID000") == null)
		{
			System.out.println("Product does not exist...");
		}
		else
		{
			System.out.println("Product exist... The Details are...");
			System.out.println();
		}

*/

//		productDAO.delete("PD002");
		
		
	}

}