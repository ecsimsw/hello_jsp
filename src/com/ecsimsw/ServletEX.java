package com.ecsimsw;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletEX
 */
@WebServlet("/hello1")
public class ServletEX extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	@PostConstruct
	public void funcA() {
		System.out.println("PostConstruct");
	}
	@Override
	public void init() throws ServletException{
		System.out.println("init");
	}
	@Override
	public void destroy() {
		System.out.println("destroy");

	}
	
	@PreDestroy
	public void funcB() {
		System.out.println("PreDestroy");
	}
	
    public ServletEX() {
        super();
        System.out.println("construct");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("doGet");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
