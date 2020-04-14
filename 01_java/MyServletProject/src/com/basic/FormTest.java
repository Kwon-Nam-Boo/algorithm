package com.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/FormTest")
public class FormTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		request.setCharacterEncoding("utf-8");
		
		// 일반적인 파라미터 받기
		String name = request.getParameter("name");
		String ta = request.getParameter("ta");
		// 체크박스 값 받기
		String[] hobbies = request.getParameterValues("hobby");
		
		String season = request.getParameter("season");
		
		
		out.println("<html><body>");
		out.println("<h1>Welcome!!!</h1>");
		out.println("name: " + name + "<br>");
		out.println("textarea: " + ta + "<br>");
		if(hobbies.length > 0) {
			for(String hobby: hobbies) {
				out.println(hobby + " ");
			}
		}
		out.println("<br>");
		out.println("season: " + season + "<br>");
		out.println("</body></html>");
	}

}
