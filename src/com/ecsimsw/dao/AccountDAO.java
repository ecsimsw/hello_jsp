package com.ecsimsw.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ecsimsw.dto.AccountDTO;

public class AccountDAO {

	Connection conn = null;
	
	public AccountDAO(){
		try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url ="jdbc:mysql://localhost:3306/hellojdbc?serverTimezone=UTC";
            conn = DriverManager.getConnection(url, "root", "root");
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}
	
	public int insertAccount(AccountDTO accountDTO) {
		String sql = "insert into logininfo (id, pw) values (?,?)";
        PreparedStatement pstat = null;
		int result = 0;
        
        try {
			pstat = conn.prepareStatement(sql);
			pstat.setString(1,accountDTO.getId());
	        pstat.setString(2,accountDTO.getPw());

	        result = pstat.executeUpdate();
		}
        catch (SQLException e) {
			e.printStackTrace();
		}
        finally {
			try {
				if( conn != null) conn.close();
				if( pstat != null) pstat.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
        
        return result;
	}
	
	public ArrayList<AccountDTO> selectAccount(){
		ArrayList<AccountDTO> resultSet = new ArrayList<>();
		
		String sql = "select * FROM logininfo";
        PreparedStatement pstat = null;
        ResultSet rs = null;
        
		try {
			pstat = conn.prepareStatement(sql);
		    rs =pstat.executeQuery();
		        
	        while(rs.next()) {
	        	int no = rs.getInt("no");
	            String id =rs.getString("id");
	            String pw =rs.getString("pw");
	            
	            resultSet.add(new AccountDTO(no,id,pw));
	        }
		    
		} 
		catch (SQLException e) {
			e.printStackTrace();
		} 
		finally {
			try {
				if( rs != null) rs.close();
				if( conn != null) conn.close();
				if( pstat != null) pstat.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
     
		return resultSet;
	}
}
