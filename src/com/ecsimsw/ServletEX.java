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
import java.sql.*;

@WebServlet("/login")
public class ServletEX extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String id = request.getParameter("id");
		//String pw = request.getParameter("pw");

		PrintWriter out = response.getWriter();
		
		//out.print(id);
		
        Connection conn = null;

        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url ="jdbc:mysql://localhost:3306/hellojdbc?serverTimezone=UTC";
            conn = DriverManager.getConnection(url, "root", "root");
            System.out.println("연결 성공");

            Statement stat=conn.createStatement();
            
            String sql = "insert into logininfo(id,pw) values"
                    + "('admin1','admin')";

            int result = stat.executeUpdate(sql); 
            System.out.println(result);
            
            sql = "insert into logininfo (id, pw) values (?,?)";
            PreparedStatement pstat = conn.prepareStatement(sql);
            pstat.setString(1,"admin3");
            pstat.setString(2,"admin4");
            pstat.executeUpdate();
            
            sql = "select * FROM logininfo";
            ResultSet rs = null;
            rs=stat.executeQuery(sql);
            
            while(rs.next()) {
                String id =rs.getString("id");
                String pw =rs.getString("pw");
                System.out.println(id+" "+pw);
            }
            rs.close();
            
            sql = "select * FROM logininfo WHERE id= (?)";
            pstat = conn.prepareStatement(sql);
            pstat.setString(1, "admin");
            rs =pstat.executeQuery();
            
            while(rs.next()) {
                String id =rs.getString("id");
                String pw =rs.getString("pw");
                System.out.println(id+" "+pw);
            }
            rs.close();
           
        }
        catch(ClassNotFoundException e){
            System.out.println(e+"드라이버 로딩 실패");
        }
        catch(SQLException e){
            System.out.println("에러: " + e);
        }
        finally{
            try{
                if( conn != null && !conn.isClosed()){
                    conn.close();
                }
            }
            catch( SQLException e){
                e.printStackTrace();
            }
        }
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
