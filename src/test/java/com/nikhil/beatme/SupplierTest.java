package com.nikhil.beatme;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nikhil.beatme.dao.SupplierDAO;
import com.nikhil.beatme.model.Supplier;

public class SupplierTest {
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		context.scan("com.nikhil.beatme");
		context.refresh();
		
		SupplierDAO supplierDAO = (SupplierDAO) context.getBean("supplierDAO");
		
		Supplier supplier = (Supplier) context.getBean("supplier");
		supplier.setId("SUP001");
		supplier.setName("SUPName001");
		supplier.setAddress("SUPAddress001");
		supplierDAO.saveOrUpdate(supplier);

//		System.out.println("No. of suppliers"+ supplierDAO.list().size());
		
/*		
		if(supplierDAO.get("SUP000") == null)
		{
			System.out.println("Supplier does not exist..");
		}
		else
		{
			System.out.println("Supplier exist... The Details are...");
			System.out.println();
		}
*/
		
//		supplierDAO.delete("SUP002");
		
		
	}

}