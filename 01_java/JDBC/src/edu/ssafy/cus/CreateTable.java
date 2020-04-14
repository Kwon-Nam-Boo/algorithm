package edu.ssafy.cus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
				//1. Driver loading
				Class.forName("com.mysql.cj.jdbc.Driver");
				//2. Connection
				Connection con =
				DriverManager.getConnection("jdbc:mysql://127.0.0.1:3305/scott?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8","ssafy","ssafy");
				// 3. Statement create
				Statement st = con.createStatement();
				// 4. SQL Execute
				String sql = "create table customer(num int primary key, name varchar(20), address varchar(100))";
				st.execute(sql);
				// 5. close
				st.close();
				con.close();
				System.out.println("sql 실행 완료");
	}
	

}

