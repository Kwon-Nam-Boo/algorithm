package com.basic;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LifeCycleTest")
public class LifeCycleTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init method ...");
	}

	public void destroy() {
		System.out.println("destroy method ... ");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet method ...");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost method ...");
	}

}
