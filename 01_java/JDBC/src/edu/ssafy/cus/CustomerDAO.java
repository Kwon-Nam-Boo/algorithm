package edu.ssafy.cus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO implements DAO{
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("class loading failure");
		}
	}
	private Connection getConnection() throws SQLException{
		Connection con =
				DriverManager.getConnection("jdbc:mysql://127.0.0.1:3305/scott?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8","ssafy","ssafy");
		return con;
	}
	

	@Override
	public void insertCustomer(int num, String name, String address) {
		Connection conn = null;
		PreparedStatement pstmt= null;
		try {
			conn = getConnection();
			String sql = "insert into customer(num, name, address) values(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, name);
			pstmt.setString(3, address);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void deleteCustomer(int num) {
	
	}

	@Override
	public void updateCustomer(int num, String name, String address) {

	}

	@Override
	public List<Customer> allViewCustomer() {
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Connection conn = null;
		ArrayList<Customer> list = new ArrayList<>();
		try {
			conn = getConnection();
			String sql = "select num, name, address from customer";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new Customer(rs.getInt("num"),rs.getString("name"),rs.getString("address")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public Customer findCustomer() {
		return null;
	}

}
