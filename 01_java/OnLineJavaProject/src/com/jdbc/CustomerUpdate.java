package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CustomerUpdate {

	public static void main(String[] args) {
		// jdbc url
		// jdbc: protocal 이름, mysql: db, localhost: db server 주소, 3305:port , harry: db(schema)이름
		
		String url = "jdbc:mysql://localhost:3305/harry?serverTimezone=UTC&useUnicode=yes&characterEncoding=UTF-8";
		String user = "harry";
		String password = "porter";
		
		String driver = "com.mysql.cj.jdbc.Driver";
		
		// 729의 레코드 주소 ->singapore로 변경
		String q = "update customer set address = 'singapore' where num = 729";
		try {
			// 1. Driver 등록
			Class.forName(driver);
			// 2. Connection 생성 (network 연결)
			Connection con = DriverManager.getConnection(url,user,password);
			// 3. Statement 생성 (Query 한개 담을 수 있는 그릇)
			Statement stat = con.createStatement();
			// 4. Query 실행(Statement에 담아서 실행, 결과가 리턴됨)
			int c = stat.executeUpdate(q);	// select문이 아닌경우
			// 5. 결과 처리
			System.out.println(c + "개의 레코드 수정");
			// 6. 마무리(자원 반납)
			stat.close();
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		

	}

}
