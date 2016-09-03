package com.xck.blog.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DB {
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("ClassForName����");
		}
	}
	
	//�������ݿ�����
	public static Connection getConn(){
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blog?user=root&password=xck123");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("DriverManager.getConnection����");
		}
		return conn;
	}
	
	public static PreparedStatement getPreparedStatement(Connection conn, String sql){
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			//ps.setString(1, "���¹���");//shiyan
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("preparedStatement����");
		}
		return ps;
	}
	
	//��ѯ
	public static ResultSet executeQuery(PreparedStatement pStmt){
		ResultSet rs = null;
		try {
			rs = pStmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("���ݿ��ѯ����");
		}
		return rs;
	}
	
	//����
	public static int executeUpdate(PreparedStatement pStmt){
		int state = -1;
		try {
			state = pStmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("���ݿ���³���");
		}
		return state;
	}
	
	public static void closeConn(Connection conn){
		try {
			if(conn != null){
				conn.close();
				conn = null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void closePStmt(PreparedStatement pStmt){
		try {
			if(pStmt != null){
				pStmt.close();
				pStmt = null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void closeResultSet(ResultSet rs){
		
		try {
			if(rs != null){
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
