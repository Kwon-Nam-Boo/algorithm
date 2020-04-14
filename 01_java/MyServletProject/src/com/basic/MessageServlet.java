package com.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Message")
public class MessageServlet extends HttpServlet {
	   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=utf-8");
		// 클라이언트로 보낼 Content 출력을 위해 출력용 스트림 준비
		PrintWriter out = response.getWriter();
		
		out.println("<html><body>");
		out.println("<h1>Message Servlet</h1>");
		out.println("<a href= HelloServlet >HelloServlet으로 가기</a>");
		out.println("</body></html>");
	}

	

}
