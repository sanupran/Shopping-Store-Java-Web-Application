package com.anupran.controller;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.map.HashedMap;
import org.apache.xerces.parsers.IntegratedParserConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.anupran.bo.Service;
import com.anupran.model.Admin;
import com.anupran.model.LoginTo;
import com.anupran.model.Product;
import com.anupran.model.Product_Category;
import com.anupran.model.Product_Inventory;

@Controller
public class MasterController {
	@Autowired
	Service service;
@RequestMapping("registration")
public ModelAndView insertCustomerDetails(HttpServletRequest request,HttpServletResponse response) throws SQLException, NamingException
{
	
	int c=0;
	String name=request.getParameter("name");
	String email=request.getParameter("email");
	String dob=request.getParameter("dob");
	Long mob=Long.parseLong(request.getParameter("mob"));
	String raddr=request.getParameter("raddr");
	String caddr=request.getParameter("caddr");
	String username=request.getParameter("username");
	String password=request.getParameter("pwd");
	LoginTo loginTo=new LoginTo();
	loginTo.setName(name);
	loginTo.setEmail(email);
	loginTo.setDob(dob);
	loginTo.setMob(mob);
	loginTo.setRaddr(raddr);
	loginTo.setCaddr(caddr);
	loginTo.setUsername(username);
	loginTo.setPassword(password);
	c=service.customerRegistration(loginTo);
	if(c==1)
	{
		return new ModelAndView("customerRegistered","message",username);
	}
	else
	{
		return new ModelAndView("errorView", "message", "Customer Not Registered");
	}
}
@RequestMapping("customerLogin")
public ModelAndView customerLogin(HttpServletRequest request,HttpServletResponse response)
{
	String username=request.getParameter("username");
	String password=request.getParameter("pwd");
	LoginTo loginTo=new LoginTo();
	loginTo.setUsername(username);
	loginTo.setPassword(password);
	List<LoginTo> al=service.customerLogin();
	if(al.get(0).getUsername().equals(loginTo.getUsername()))
	{
		return new ModelAndView("customerView", "message", username);
	}
	else
	{
		return new ModelAndView("errorView","message","Wrong Credentials try again");
	}
}
@RequestMapping("adminLogin")
public ModelAndView adminLogin(HttpServletRequest request,HttpServletResponse response)
{
	String username=request.getParameter("username");
	String password=request.getParameter("pwd");
	Admin admin=new Admin();
	admin.setUsername(username);
	admin.setPassword(password);
	
	List<Admin> al=service.list(); 
	if(al.get(0).getUsername().equals(admin.getUsername()))
	{
		return new ModelAndView("adminView", "message", username);
	}
	else
	{
		return new ModelAndView("errorView","message","Wrong Credentials try again");
	}
}
@RequestMapping("productCategory")
public ModelAndView insertProductCategory(HttpServletRequest request,HttpServletResponse response) throws SQLException, NamingException
{
	int prod_c_id=Integer.parseInt(request.getParameter("productCategoryID"));
	String prod_c_name=request.getParameter("productCategoryName");
	String prod_c_desc=request.getParameter("productCategoryDescription");
	Product_Category category=new Product_Category();
	category.setProd_c_id(prod_c_id);
	category.setProd_c_name(prod_c_name);
	category.setProd_c_desc(prod_c_desc);
	int c=service.productCategoryInsertion(category);
	if(c==1)
	{
		return new ModelAndView("productCategoryInserted");
	}
	else
	{
		return new ModelAndView("errorView","message","Some error please try again");
	}
}
@RequestMapping("productInventory")
public ModelAndView insertProductInventory(HttpServletRequest request,HttpServletResponse response)
{
	int prod_id,prod_avail_qty,prod_thresh_qty,prod_rate,prod_curr;
	prod_id=Integer.parseInt(request.getParameter("productID"));
	prod_avail_qty=Integer.parseInt(request.getParameter("productAvailableQuantity"));
	prod_thresh_qty=Integer.parseInt(request.getParameter("productThreshholdQuantity"));
	prod_rate=Integer.parseInt(request.getParameter("productRate"));
	prod_curr=Integer.parseInt(request.getParameter("productCurrencyCode"));
	Product_Inventory inventory=new Product_Inventory();
	inventory.setProd_id(prod_id);
	inventory.setProd_avail_qty(prod_avail_qty);
	inventory.setProd_thresh_qty(prod_thresh_qty);
	inventory.setProd_rate(prod_rate);
	inventory.setProd_curr(prod_curr);
	int c=service.insertProductInventory(inventory);
	if(c==1)
	{
		return new ModelAndView("productInventoryInserted");
	}
	else
	{
		return new ModelAndView("errorView", "message", "Some error please try again");
	}
}
@RequestMapping("product")
public ModelAndView insertProduct(HttpServletRequest request,HttpServletResponse response)
{
	int prod_c_id,prod_id;
	String prod_name,prod_desc;
	String image;
	/*for image declaration*/
	prod_c_id=Integer.parseInt(request.getParameter("productCategoryID"));
	prod_id=Integer.parseInt(request.getParameter("productID"));
	prod_name=request.getParameter("productName");
	prod_desc=request.getParameter("productDescription");
	/*for image retrieving*/
	image=request.getParameter("image");
	Product product=new Product();
	product.setProd_c_id(prod_c_id);
	product.setProd_id(prod_id);
	product.setProd_name(prod_name);
	product.setProd_desc(prod_desc);
	/*for image setter*/
	product.setImage(image);
	System.out.println(image);
	int c=service.insertProduct(product);
	if(c==1){
		return new ModelAndView("productInserted");
	}
	else
	{
		return new ModelAndView("errorView", "message", "Somethin went wrong please try again");
	}
}
@RequestMapping("productDisplay")
public ModelAndView viewPrdoucts(HttpServletRequest request,HttpServletResponse response)
{
ArrayList<Product> arrayList=new ArrayList<Product>();
List<List<Product>> list=service.getProduct();
Iterator<List<Product>> iterator=list.iterator();
while(iterator.hasNext())
{
	List<com.anupran.model.Product> list2=(List<com.anupran.model.Product>)iterator.next();
	Iterator<Product> iterator2=list2.iterator();
	while(iterator2.hasNext())
	{
		Product product=iterator2.next();
		arrayList.add(product);
	}
}

	return new ModelAndView("sample1","productList",arrayList);
}
}
