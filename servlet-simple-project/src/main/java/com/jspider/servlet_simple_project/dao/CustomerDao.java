package com.jspider.servlet_simple_project.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jspider.servlet_simple_project.connection.CustomerConnection;
import com.jspider.servlet_simple_project.dto.Customer;

/**
 * 
 * @author
 */
public class CustomerDao {

	Connection connection = CustomerConnection.getCustomerConnection();

	final String INSERT_CUSTOMER_QUERY = "insert into customer(id,name,email,phone,password) values(?,?,?,?,?)";
	final String DISPLAY_CUSTOMER_BY_ID_QUERY = "SELECT * FROM CUSTOMER WHERE id=?";
	final String DISPLAY_ALL_CUSTOMER_QUERY = "SELECT * FROM CUSTOMER";
	
	final String SELECTEMAILPASSWORDQUERY = "select email,password from customer where email=?";

	public int saveCustomerDao(Customer customer) {
		try {

			PreparedStatement ps = connection.prepareStatement(INSERT_CUSTOMER_QUERY);
			ps.setInt(1, customer.getId());
			ps.setString(2, customer.getName());
			ps.setString(3, customer.getEmail());
			ps.setLong(4, customer.getPhone());
			ps.setString(5, customer.getPassword());
			return ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public Customer getCustomerByIdDao(int id) {
		try {
			PreparedStatement ps = connection.prepareStatement(DISPLAY_CUSTOMER_BY_ID_QUERY);
			ps.setInt(1, id);
			ResultSet set=ps.executeQuery();
			if(set.next()) {
				
				int id1 = set.getInt("id");
				String name = set.getString("name");
				String email = set.getString("email");
				long phone = set.getLong("phone");
				
				
				Customer customer=new Customer();
				customer.setId(id1);
				customer.setName(name);
				customer.setEmail(email);
				customer.setPhone(phone);
				return customer;
			}else {
				System.out.println("given id not found");
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * this method will fetch email and password by customer email
	 * @param customerEmail
	 * @return Customer Object which holds email and password only
	 */
	public Customer getCustomerByEmailDao(String email) {
		try {
			PreparedStatement ps = connection.prepareStatement(SELECTEMAILPASSWORDQUERY);
			ps.setString(1, email);
			ResultSet set=ps.executeQuery();
			if(set.next()) {
				
				
				String email1 = set.getString("email");
				String password = set.getString("password");
				
				
				Customer customer=new Customer();
				
				customer.setEmail(email1);
				customer.setPassword(password);
				return 
;
			}else {
				System.out.println("given email not found");
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public int deleteCustomerByIdDao(int cusId) {
		
		try {
			
			CallableStatement call=connection.prepareCall("call deleteCustomerById(?)");
			
			call.setInt(1, cusId);
			
			return call.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	
	public List<Customer> displayAllCustomerDao() {
		try {
			PreparedStatement ps = connection.prepareStatement(DISPLAY_ALL_CUSTOMER_QUERY);
			
			ResultSet set=ps.executeQuery();
			
			List<Customer> customers = new ArrayList<Customer>();
			
			while(set.next()) {
				
				int id1 = set.getInt("id");
				String name = set.getString("name");
				String email = set.getString("email");
				long phone = set.getLong("phone");
				
				Customer customer=new Customer();
				customer.setId(id1);
				customer.setName(name);
				customer.setEmail(email);
				customer.setPhone(phone);
				
				customers.add(customer);
			}
			
			return  customers;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
