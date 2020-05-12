package com.ecsimsw;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletEX
 */
@WebServlet("/login")
public class ServletEX extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServletEX() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		System.out.println("id : " + id + "  pw : "+pw);
		
		ServletContext context = this.getServletContext();
		System.out.println("default DIR : "+ context.getInitParameter("defaultDIR"));
	
ServletConfig config = this.getServletConfig();
System.out.println("id : " + config.getInitParameter("d") + "  pw : "+pw);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
