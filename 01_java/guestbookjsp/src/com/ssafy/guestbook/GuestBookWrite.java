package com.ssafy.guestbook;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/articlewrite.do")
public class GuestBookWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() throws ServletException {
		super.init();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		1. data get
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
//		2. logic
		Connection conn = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3305/ssafyweb?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8", "ssafy", "ssafy");
			StringBuilder insertMember = new StringBuilder();
			insertMember.append("insert into guestbook (username, subject, content, regtime) \n");
			insertMember.append("values (?, ?, ?, now())");
			pstmt = conn.prepareStatement(insertMember.toString());
			pstmt.setString(1, name);
			pstmt.setString(2, subject);
			pstmt.setString(3, content);
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null)
					pstmt.close();
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(cnt != 0) {
			response.sendRedirect("/guestbookjsp/gusetbook/writesucess.jsp");
		} else {
			response.sendRedirect("/guestbookjsp/gusetbook/writefail.jsp");
		}
		
	}

}
