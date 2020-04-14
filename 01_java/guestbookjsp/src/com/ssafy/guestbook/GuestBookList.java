package com.ssafy.guestbook;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/articlelist.do")
public class GuestBookList extends HttpServlet {
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
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		1. data get
		
		
//		2. logic
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<GuestBookDto> list = new ArrayList<GuestBookDto>();
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3305/ssafyweb?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8", "ssafy", "ssafy");
			StringBuilder sql = new StringBuilder();
			sql.append("select articleno, username, subject, content, regtime \n");
			sql.append("from guestbook \n");
			sql.append("order by articleno desc \n");
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				GuestBookDto gbd = new GuestBookDto();
				gbd.setArticleno(rs.getInt("articleno"));
				gbd.setName(rs.getString("username"));
				gbd.setSubject(rs.getString("subject"));
				gbd.setContent(rs.getString("content"));
				gbd.setRegtime(rs.getString("regtime"));
				
				list.add(gbd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null)
					rs.close();
				if(pstmt != null)
					pstmt.close();
				if(conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		request.setAttribute("articles", list);
		RequestDispatcher dispatcher =request.getRequestDispatcher("/guestbook/list.jsp");
		dispatcher.forward(request, response);
		
	}

}
