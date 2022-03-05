package com.anupran.dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.anupran.model.Admin;
import com.anupran.model.LoginTo;
import com.anupran.model.Product;
import com.anupran.model.Product_Category;
import com.anupran.model.Product_Inventory;

public class DaoImplementation {
	private DataSource dataSource;

	public DaoImplementation(DataSource dataSource) {
		this.dataSource = dataSource;
	}



	

	public List<Admin> list() {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "select admn_usr_id,admn_passwd from admin_registration";
		List<Admin> al=jdbcTemplate.query(sql, new RowMapper<Admin>()
				{
			@Override
			public Admin mapRow(ResultSet rs,int rownumber) throws SQLException
			{
				Admin admin=new Admin();
				admin.setUsername(rs.getString(1));
				admin.setPassword(rs.getString(2));
				return admin;
			}
				});
				
				
		
		return al;
	}

	public List<LoginTo> customerLogin() {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql="select cust_usr_id,cust_passwd from customer_registration";
		List<LoginTo> al=jdbcTemplate.query(sql, new RowMapper<LoginTo>()
				{
			@Override
			public LoginTo mapRow(ResultSet rs,int rownumber) throws SQLException
			{
				LoginTo loginTo=new LoginTo();
				loginTo.setUsername(rs.getString(1));
				loginTo.setPassword(rs.getString(2));
				return loginTo;
			}
				});
				
				
		
		return al;
		
	}

	public int customerRegistration(LoginTo loginTo) throws SQLException, NamingException {
		// TODO Auto-generated method stub
		int c=0;
		Context context=new InitialContext();
		Context context2=(Context) context.lookup("java:comp/env");
		DataSource ds=(DataSource) context2.lookup("jdbc/xe");
		Connection connection=ds.getConnection();
		String sql="insert into customer_registration values(?,?,?,?,?,?,?,?)";
		PreparedStatement statement=connection.prepareStatement(sql);
		statement.setString(1, loginTo.getName());
		statement.setString(2, loginTo.getEmail());
		statement.setString(3,loginTo.getDob());
		statement.setLong(4, loginTo.getMob());
		statement.setString(5, loginTo.getCaddr());
		statement.setString(6, loginTo.getRaddr());
		statement.setString(7, loginTo.getUsername());
		statement.setString(8, loginTo.getPassword());
		 c=statement.executeUpdate();
		return c;
	}

	public int productCategoryInsertion(Product_Category category) throws SQLException, NamingException {
		// TODO Auto-generated method stub
		int c=0;
		Context context=new InitialContext();
		Context context2=(Context) context.lookup("java:comp/env");
		DataSource ds=(DataSource) context2.lookup("jdbc/xe");
		Connection connection=ds.getConnection();
		String sql="insert into product_catelog values(?,?,?)";
		PreparedStatement statement=connection.prepareStatement(sql);
		statement.setInt(1, category.getProd_c_id());
		statement.setString(2, category.getProd_c_name());
		statement.setString(3, category.getProd_c_desc());
		c=statement.executeUpdate();
		return c;
		
		
	}


	public int insertProductInventory(Product_Inventory inventory) {
		// TODO Auto-generated method stub
	int c=0;
	try{
	Context context=new InitialContext();
	Context context2=(Context) context.lookup("java:comp/env");
	DataSource ds=(DataSource) context2.lookup("jdbc/xe");
	Connection connection=ds.getConnection();
	String sql="insert into product_inventory values(?,?,?,?,?)";
	PreparedStatement statement=connection.prepareStatement(sql);
	statement.setInt(1, inventory.getProd_id());
	statement.setInt(2, inventory.getProd_avail_qty());
	statement.setInt(3, inventory.getProd_thresh_qty());
	statement.setInt(4, inventory.getProd_rate());
	statement.setInt(5, inventory.getProd_curr());
	c=statement.executeUpdate();
	}catch(Exception ex)
	{
		System.out.println(ex.getMessage());
	}
	return c;
	}
	public int insertProduct(Product product) {
		// TODO Auto-generated method stub
		int c=0;
		try{
		Context context=new InitialContext();
		Context context2=(Context) context.lookup("java:comp/env");
		DataSource ds=(DataSource) context2.lookup("jdbc/xe");
		Connection connection=ds.getConnection();
		String sql="insert into product values(?,?,?,?,?)";
		PreparedStatement statement=connection.prepareStatement(sql);
		statement.setInt(1, product.getProd_c_id());
		statement.setInt(2, product.getProd_id());
		statement.setString(3, product.getProd_name());
		statement.setString(4, product.getProd_desc());
		FileInputStream fis=new FileInputStream(product.getImage());
		statement.setBinaryStream(5, fis, fis.available());
		c=statement.executeUpdate();
		}
		catch(Exception exception)
		{
			
		}
		return c;
	}





	public HashMap<Product, Product_Inventory> viewProduct(Product product, Product_Inventory inventory) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql="select p.prod_name,p.prod_img,i.prod_rate,i.prod_avail_qty from product p join product_inventory on p.prod_id=i.prod_id";
		
	
/*		List<Admin> al=jdbcTemplate.query(sql, new RowMapper<Admin>()
				{
			@Override
			public Admin mapRow(ResultSet rs,int rownumber) throws SQLException
			{
				Admin admin=new Admin();
				admin.setUsername(rs.getString(1));
				admin.setPassword(rs.getString(2));
				return admin;
			}
				});
				
				
		
		return al;*/
		return null;
		
	}





	public List<List<Product>> getProduct() {
		// TODO Ato-generated method stub
	JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	return jdbcTemplate.query("select * from product", new RowMapper<List<Product>>(){
		@Override
		public List<Product> mapRow(ResultSet rs,int rownmuber) throws SQLException
		{
			int i=1;
			List<Product> list=new ArrayList<Product>();
			while(rs.next())
			{
				Product product=new Product();
				Blob blob=rs.getBlob(5);
				byte b[]=blob.getBytes(5, (int) blob.length());
				FileOutputStream fout;
				try{
					String url="D:\\dingtest"+i+".jpg";
					fout=new FileOutputStream(url);
					fout.write(b);
					product.setImage(url);
					fout.close();
				}catch(Exception ex)
				{
					
				}
				i++;
				product.setProd_c_id(rs.getInt(1));
				product.setProd_id(rs.getInt(2));
				product.setProd_name(rs.getString(3));
				product.setProd_desc(rs.getString(4));
				list.add(product);
			}
			return list;
		}
	});
		
	
	}


}
