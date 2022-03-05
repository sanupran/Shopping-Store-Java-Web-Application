package com.anupran.bo;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.beans.factory.annotation.Autowired;

import com.anupran.dao.DaoImplementation;
import com.anupran.model.Admin;
import com.anupran.model.LoginTo;
import com.anupran.model.Product;
import com.anupran.model.Product_Category;
import com.anupran.model.Product_Inventory;

public class Service {
	@Autowired
	DaoImplementation dao;
	public List<Admin> list() {
		// TODO Auto-generated method stub
		return dao.list();
	}

	public List<LoginTo> customerLogin() {
		// TODO Auto-generated method stub
		return dao.customerLogin();
	}




	public int customerRegistration(LoginTo loginTo) throws SQLException, NamingException {
		// TODO Auto-generated method stub
		return dao.customerRegistration(loginTo);
	}




	public int productCategoryInsertion(Product_Category category) throws SQLException, NamingException {
		// TODO Auto-generated method stub
		return dao.productCategoryInsertion(category);
	}
	public int insertProductInventory(Product_Inventory inventory) {
		// TODO Auto-generated method stub
		return dao.insertProductInventory(inventory);
	}

	public int insertProduct(Product product) {
		// TODO Auto-generated method stub
		return dao.insertProduct(product);
	}

	public HashMap<Product, Product_Inventory> viewPrdouct(Product product, Product_Inventory inventory) {
		// TODO Auto-generated method stub
		
		return dao.viewProduct(product,inventory);
	}

	public List<List<Product>> getProduct() {
		// TODO Auto-generated method stub
		return dao.getProduct();
	}




}
