package com.ecsimsw;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class ServletEX extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		Cookie[] cookies = request.getCookies();
		Cookie loginCookie = null;
		
		if(cookies != null) {
			for(Cookie c : cookies) {
				System.out.println(c.getName()+ " "+c.getValue());
				
				if(c.getName().equals("loginInfo")) {
					loginCookie = c; 
				}
			}
		}
		if(loginCookie == null) {
			System.out.println("new login");
	        loginCookie = new Cookie("loginInfo",id);
		}
		
		response.addCookie(loginCookie);
		loginCookie.setMaxAge(60*60);
		
		HttpSession sesson = request.getSession();
		
		sesson.setAttribute("loginID", id);
		
		response.sendRedirect("testJSP.jsp");
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
