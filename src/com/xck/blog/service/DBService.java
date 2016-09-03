package com.xck.blog.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xck.blog.util.DB;

public class DBService {
	
	//获取分类的grouping_id
	public static int getGroupingIdByGroupingName(String grouping_name){
		int grouping_id = -1;
		Connection conn = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		try {
			String sql_getNoGrouping = "select grouping_id from article_group where grouping_name=?";
			conn = DB.getConn();
			pStmt = DB.getPreparedStatement(conn, sql_getNoGrouping);
			pStmt.setString(1, grouping_name);
			rs = DB.executeQuery(pStmt);
			if(rs.next()){
				grouping_id = rs.getInt("grouping_id");
				System.out.println("获取的分类id为: " + grouping_id);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DB.closeResultSet(rs);
			DB.closePStmt(pStmt);
			DB.closeConn(conn);
		}
		return grouping_id;
	}
	
	//通过分类id获取分类名字
	public static String getGroupingNameByGroupingId(int grouping_id){
		String grouping_name = null;
		Connection conn = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		try {
			String sql = "select grouping_name from article_group where grouping_id=?";
			conn = DB.getConn();
			pStmt = DB.getPreparedStatement(conn, sql);
			pStmt.setInt(1, grouping_id);
			rs = DB.executeQuery(pStmt);
			if(rs.next()){
				grouping_name = rs.getString("grouping_name");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return grouping_name;
	}
	
	//获取分类的数量
	public static int getGroupingAmountByGroupingId(int grouping_id){
		int grouping_amount = -1;
		Connection conn = null;
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		try {
			String sql = "select grouping_amount from article_group where grouping_id=?";
			conn = DB.getConn();
			pStmt = DB.getPreparedStatement(conn, sql);
			pStmt.setInt(1, grouping_id);
			rs = DB.executeQuery(pStmt);
			if(rs.next()){
				grouping_amount = rs.getInt("grouping_amount");
				System.out.println("获取的分类数量为: " + grouping_amount);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DB.closeResultSet(rs);
			DB.closePStmt(pStmt);
			DB.closeConn(conn);
		}
		return grouping_amount;
	}
	
	//若无分类不存在自动加上
	
	//设置分类数量
	public static int setGroupingAmountByGroupingId(int groupingAmount,int grouping_id){
		String sql = "update article_group set grouping_amount=? where grouping_id=?";
		Connection conn = null;
		PreparedStatement pStmt = null;
		int result = -1;
		try {
			conn = DB.getConn();
			pStmt = DB.getPreparedStatement(conn, sql);
			pStmt.setInt(1, groupingAmount);
			pStmt.setInt(2, grouping_id);
			result = DB.executeUpdate(pStmt);
			if(result == 1){
				System.out.println("分类数量设置成功");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DB.closePStmt(pStmt);
			DB.closeConn(conn);
		}
		return result;
	}
	
	//通过分类id查找所属文章
	public static List<Integer> getArticleIdByGroupingId(int grouping_id){
		Connection conn = null;
		ResultSet rs = null;
		List<Integer> list = null;
		PreparedStatement pStmt = null;
		try {
			String sql = "select article_id from article where article_grouping=?";
			conn = DB.getConn();
			pStmt = DB.getPreparedStatement(conn, sql);
			pStmt.setInt(1, grouping_id);
			rs = DB.executeQuery(pStmt);
			list = new ArrayList<Integer>();
			while(rs.next()){
				list.add(rs.getInt("article_id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DB.closeResultSet(rs);
			DB.closePStmt(pStmt);
			DB.closeConn(conn);
		}
		return list;
	}
	
	//通过结果集中的article_id设置文章中的分类id
	public static void setArticleGroupingByRs(List<Integer> rs, int article_grouping){
		for(int i=0; i<rs.size(); i++){
			int article_id = rs.get(i);
			setArticleGroupingByArticleId(article_id, article_grouping);
		}
	}
	
	//通过文章id设置分类id
	public static int setArticleGroupingByArticleId(int article_id, int article_grouping){
		Connection conn = null;
		PreparedStatement pStmt = null;
		int result = -1;
		try {
			String sql = "update article set article_grouping=? where article_id=?";
			conn = DB.getConn();
			pStmt = DB.getPreparedStatement(conn, sql);
			pStmt.setInt(1, article_grouping);
			pStmt.setInt(2, article_id);
			result = DB.executeUpdate(pStmt);
			if(result == 1){
				System.out.println("通过文章id设置分类id成功");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
