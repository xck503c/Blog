package com.xck.blog.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.xck.blog.util.DB;

public class EDGHandleService {
	//删除
	public static int delete(String tableName, int id, String idName){
		try {
			String delete = "delete from "+ tableName +" where "+ idName +"=?";
			Connection conn = DB.getConn();
			int grouping_id = getGroupingId(conn, id);
			if(grouping_id == -1){
				System.out.println("分组id无记录");
			}
			PreparedStatement pStmt = DB.getPreparedStatement(conn, delete);
			pStmt.setInt(1, id);
			int result = DB.executeUpdate(pStmt);
			if(result == 1){
				System.out.println(tableName + "表  删除成功");
				if(tableName.equals("article")){
					//将分类中的文章数量-1
					subtractAmountOfGrouping(conn, tableName, grouping_id);
				}else if(tableName.equals("article_group")){
					//将文章中的分类置为无分类
					setNoGrouping(id);
				}
				return 1;
			}
			return 0;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("EDGHandleService出错");
		}
		return 0;
	}
	
	//编辑
	public static void edit(String tableName, int id, String idName){
		String edit = "select article_title,article_content from "+ tableName +" where "+ idName +"=?";
		Connection conn = DB.getConn();
		
	}
	
	//通过articleid获取其分组id
	private static int getGroupingId(Connection conn, int id){
		int grouping_id = -1;
		try{
			String sql_getGroupingId = "select article_grouping from article where article_id=?";
			PreparedStatement pStmt = DB.getPreparedStatement(conn, sql_getGroupingId);
			pStmt.setInt(1, id);
			ResultSet rs = DB.executeQuery(pStmt);
			if(rs.next()){
				grouping_id = rs.getInt("article_grouping");
			}
			if(id == -1){
				System.out.println("没有这条记录");
				return -1;
			}
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("EDGHandleService出错");
		}
		return grouping_id;
	}
	
	//将分类中的文章数量-1
	private static void subtractAmountOfGrouping(Connection conn,String tableName, int id){
		try {
			//通过grouping_id获取article_group中的数量
			String sql_amount = "select grouping_amount from article_group where grouping_id=?";
			PreparedStatement pStmt = DB.getPreparedStatement(conn, sql_amount);
			pStmt.setInt(1, id);
			ResultSet rs = DB.executeQuery(pStmt);
			int amount = -1;
			if(rs.next()){
				amount = rs.getInt("grouping_amount");
			}
			if(amount == -1){
				System.out.println("article_group没有这条记录");
				return;
			}
			//将其-1
			amount -=1;
			String sql_subamount = "update article_group set grouping_amount=? where grouping_id=?";
			pStmt = DB.getPreparedStatement(conn, sql_subamount);
			pStmt.setInt(1, amount);
			pStmt.setInt(2, id);
			int result = DB.executeUpdate(pStmt);
			if(result == 1){
				System.out.println("文章分组数量-1成功");
			}else{
				System.out.println("文章分组数量-1失败");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
	}
	
	//将文章设置为无分类
	private static void setNoGrouping(int grouping_id){
		//通过分类id查找文章中所有以它为分类的文章
		int noGroupingId = DBService.getGroupingIdByGroupingName("无分类");
		List<Integer> rs = DBService.getArticleIdByGroupingId(grouping_id);
		DBService.setArticleGroupingByRs(rs, noGroupingId);
	}
}
