package com.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// url mapping 값
@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	// doGet(): service메소드. 클라이언트로부터 요청이 들어오면 응답을 만들어주는 메소드
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 서버에서 클라이언트로 보낼 content의 타입 지정. text/html:MIME TYPE
		response.setContentType("text/html; charset=utf-8");
		// 클라이언트로 보낼 Content 출력을 위해 출력용 스트림 준비
		PrintWriter out = response.getWriter();
		
		out.println("<html><body>");
		out.println("<h1>Hello Servlet</h1>");
		out.println("<a href= Message >MessageServlet으로 가기</a>");
		out.println("<a href= LoginServlet?id=tommy&pass=1111>LoginServlet으로 가기</a>");
		out.println("</body></html>");
	}

}
