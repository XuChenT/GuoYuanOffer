package com.lmonkey.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;



//import com.sun.jndi.ldap.Connection;

public class Basedao {
	static{
		//加载驱动
		try {
			Class.forName("com/mysql/jdbc/Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Connection getconn(){
		//创建一个链接对象
		//java.sql.Connection conn =null;
		Connection conn =null;
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lmonkeyshop?useSSL=false&serverTimezone=UTC","root","123456");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	 
	public static int exectuIUD(String sql, Object[] params){
		int count =0;
		
		Connection conn= Basedao.getconn();
		
		//准备sql
		PreparedStatement ps =null;
		
		try {
			ps=conn.prepareStatement(sql);
			
			for(int i=0;i<params.length;i++){
				ps.setObject(i+1, params[i]);
			}
			count=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}
	public static void closeall(ResultSet rs, PreparedStatement ps, Connection conn){
		try {
			if(rs!=null)
				rs.close();
			if(ps!=null)
				ps.close();
			if(conn!=null)
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				Basedao.closeall(rs, ps, conn);
			}
	}
}
