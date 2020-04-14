package com.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		
	}
	   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		request.setCharacterEncoding("utf-8");
		
		// 클라이언트가 보내오는 파라미터를 받기 (id값이 아닌 name값을 받아오는 것)
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		out.println("<html><body>");
		out.println("<h1>Welcome!!!</h1>");
		out.println("id:" + id + "<br>");
		out.println("pass:" + pass + "<br>");
		
		out.println("</body></html>");
	}

	

}
