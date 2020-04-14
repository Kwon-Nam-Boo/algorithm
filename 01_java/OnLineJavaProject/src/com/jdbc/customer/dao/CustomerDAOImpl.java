package com.jdbc.customer.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.jdbc.customer.vo.Customer;

// dao(data access object:Create(inset),Read(Select), Update ,Delete)

public class CustomerDAOImpl implements CustomerDAO{
	
	String url = "jdbc:mysql://localhost:3305/harry?serverTimezone=UTC&useUnicode=yes&characterEncoding=UTF-8";
	String user = "harry";
	String password = "porter";
	
	String driver = "com.mysql.cj.jdbc.Driver";
	
	public CustomerDAOImpl() {
		// 1. Driver 등록
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} // 객체 생성
	}
	public Connection getConnection() { // Connection 생성해서 리턴
		// 2. Connection 생성 (network 연결)
		Connection con = null;
		try {
			con = DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public void close(Connection con, PreparedStatement pstat,ResultSet rs) { // Connection close
		try {
			if(pstat!=null) pstat.close();
			if(con!=null) con.close();
			if(rs!=null) rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public ArrayList<Customer> findAll() {
		
		String q ="select * from customer";
		ArrayList<Customer> list = new ArrayList<>();
		Connection con = getConnection();
		PreparedStatement pstat = null;
		ResultSet  rs =null;
		try {
			// 3. Statement 생성 (Query 한개 담을 수 있는 그릇)
			pstat = con.prepareStatement(q); 
			// 4. Query 실행(Statement에 담아서 실행, 결과가 리턴됨)
			rs = pstat.executeQuery(q);	// select문인 경우 사용
			// 5. 결과 처리
			while(rs.next()) {
				String num = rs.getString(1);
				String name = rs.getString(2);
				String address = rs.getString(3);
				list.add(new Customer(num, name, address));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			close(con,pstat,rs);
		}
		return list;
	}

	@Override
	public Customer findByNum(String num) {
		String q ="select * from customer where num = ?";
		Connection con = getConnection();
		PreparedStatement pstat = null;
		ResultSet rs =null;
		Customer c = null;
		
		try {
			pstat = con.prepareStatement(q);
			pstat.setString(1, num);
			rs =  pstat.executeQuery();
			
			// num 은 기본키이므로 오직 한개의 값
			while(rs.next()) {
				num = rs.getString(1);
				String name = rs.getString(2);
				String address = rs.getString(3);
				c = new Customer(num, name, address);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			close(con,pstat,rs);
		}
		return c;
	}

	@Override
	public ArrayList<Customer> findByAddress(String address) {
		String q ="select * from customer where address = ?";
		Connection con = getConnection();
		PreparedStatement pstat = null;
		ResultSet rs =null;
		ArrayList<Customer> list = new ArrayList<>();
		
		try {
			pstat = con.prepareStatement(q);
			pstat.setString(1, address);
			rs =  pstat.executeQuery();
			
			// address는 중복 될 수 있다
			while(rs.next()) {
				String num = rs.getString(1);
				String name = rs.getString(2);
				address = rs.getString(3);
				list.add(new Customer(num, name, address));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			close(con,pstat,rs);
		}
		return list;
	}

	@Override
	public int insert(Customer c) {
		// ignore: 기본키 중복시 삽입 안함
		String q = "insert ignore into customer values(?,?,?)";
		Connection con = getConnection();
		
		PreparedStatement pstat = null;
		int count = 0;
	
		try {
			pstat = con.prepareStatement(q);
			pstat.setString(1, c.getNum());
			pstat.setString(2, c.getName());
			pstat.setString(3, c.getAddress());
			
			count = pstat.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			close(con,pstat,null);
		}
		return count;
	}

	@Override
	public int delete(String num) {
		String q = "delete from customer where num = ?";
		Connection con = getConnection();
		
		PreparedStatement pstat = null;
		int count = 0;
	
		try {
			pstat = con.prepareStatement(q);
			pstat.setString(1, num);
			count = pstat.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			close(con,pstat,null);
		}
		return count;
	}

	@Override
	public int update(Customer c) {
		String q = "update customer set name = ?, address = ? where num = ?";
		Connection con = getConnection();
		
		PreparedStatement pstat = null;
		int count = 0;
	
		try {
			pstat = con.prepareStatement(q);
			pstat.setString(1, c.getName());
			pstat.setString(2, c.getAddress());
			pstat.setString(3, c.getNum());
			count = pstat.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			close(con,pstat,null);
		}
		return count;
	}
}
