package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CustomerSelectOne {

	public static void main(String[] args) {
		// jdbc url
		// jdbc: protocal 이름, mysql: db, localhost: db server 주소, 3305:port , harry: db(schema)이름
		
		String url = "jdbc:mysql://localhost:3305/harry?serverTimezone=UTC&useUnicode=yes&characterEncoding=UTF-8";
		String user = "harry";
		String password = "porter";
		
		String driver = "com.mysql.cj.jdbc.Driver";
		
		// num 이 141인 레코드 
		String q = "select * from customer where num = 141";
		try {
			// 1. Driver 등록
			Class.forName(driver);
			// 2. Connection 생성 (network 연결)
			Connection con = DriverManager.getConnection(url,user,password);
			// 3. Statement 생성 (Query 한개 담을 수 있는 그릇)
			Statement stat = con.createStatement();
			// 4. Query 실행(Statement에 담아서 실행, 결과가 리턴됨)
			ResultSet rs = stat.executeQuery(q);	// select문인 경우 사용
			// 5. 결과 처리
			while(rs.next()) {
				String num = rs.getString(1);
				String name = rs.getString(2);
				String address = rs.getString(3);
				System.out.println(num + "--" + name + "--"+ address);
			}
			// 6. 마무리(자원 반납)
			rs.close();
			stat.close();
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		

	}

}
