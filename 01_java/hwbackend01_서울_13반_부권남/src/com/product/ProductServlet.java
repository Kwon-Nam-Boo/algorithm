package com.product;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("utf-8");
		
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		String manual = request.getParameter("manual");
		
		out.println("<html><body>");
		out.println("<h1>상품이 저장되었습니다!!</h1>");
		out.println("상품명: " + name + "<br>");
		out.println("상품 가격: " +  price + "<br>");
		out.println("상품 설명: " +  manual + "<br>");
		
		out.println("</body></html>");
		
	}

}
