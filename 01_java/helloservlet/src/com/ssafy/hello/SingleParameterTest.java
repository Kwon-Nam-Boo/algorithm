package com.ssafy.hello;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/singleparam.do")
public class SingleParameterTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		1. data get
		String userid = request.getParameter("userid");
		String username = request.getParameter("username");
		int area = Integer.parseInt(request.getParameter("area")); 
		
//		2. logic
		String colors[] = {"naviblue","orange","blue","red"};
		
//		3. response page
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("	<body>");
		out.println(username + "(<font color =\"" + colors[area] + "\">"+ userid +"</font>)님 안녕하세요");
		out.println("	</body>");
		out.println("</html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		1. data get
		request.setCharacterEncoding("utf-8");
		String userid = request.getParameter("userid");
		String username = request.getParameter("username");
		int area = Integer.parseInt(request.getParameter("area")); 
		
//		2. logic
		String colors[] = {"naviblue","orange","blue","red"};
		
//		3. response page
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("	<body>");
		out.println(username + "(<font color =\"" + colors[area] + "\">"+ userid +"</font>)님 안녕하세요");
		out.println("	</body>");
		out.println("</html>");
	}

}
