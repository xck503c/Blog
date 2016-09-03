package com.xck.blog.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.xck.blog.util.DB;

public class EDGHandleService {
	//ɾ��
	public static int delete(String tableName, int id, String idName){
		try {
			String delete = "delete from "+ tableName +" where "+ idName +"=?";
			Connection conn = DB.getConn();
			int grouping_id = getGroupingId(conn, id);
			if(grouping_id == -1){
				System.out.println("����id�޼�¼");
			}
			PreparedStatement pStmt = DB.getPreparedStatement(conn, delete);
			pStmt.setInt(1, id);
			int result = DB.executeUpdate(pStmt);
			if(result == 1){
				System.out.println(tableName + "��  ɾ���ɹ�");
				if(tableName.equals("article")){
					//�������е���������-1
					subtractAmountOfGrouping(conn, tableName, grouping_id);
				}else if(tableName.equals("article_group")){
					//�������еķ�����Ϊ�޷���
					setNoGrouping(id);
				}
				return 1;
			}
			return 0;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("EDGHandleService����");
		}
		return 0;
	}
	
	//�༭
	public static void edit(String tableName, int id, String idName){
		String edit = "select article_title,article_content from "+ tableName +" where "+ idName +"=?";
		Connection conn = DB.getConn();
		
	}
	
	//ͨ��articleid��ȡ�����id
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
				System.out.println("û��������¼");
				return -1;
			}
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("EDGHandleService����");
		}
		return grouping_id;
	}
	
	//�������е���������-1
	private static void subtractAmountOfGrouping(Connection conn,String tableName, int id){
		try {
			//ͨ��grouping_id��ȡarticle_group�е�����
			String sql_amount = "select grouping_amount from article_group where grouping_id=?";
			PreparedStatement pStmt = DB.getPreparedStatement(conn, sql_amount);
			pStmt.setInt(1, id);
			ResultSet rs = DB.executeQuery(pStmt);
			int amount = -1;
			if(rs.next()){
				amount = rs.getInt("grouping_amount");
			}
			if(amount == -1){
				System.out.println("article_groupû��������¼");
				return;
			}
			//����-1
			amount -=1;
			String sql_subamount = "update article_group set grouping_amount=? where grouping_id=?";
			pStmt = DB.getPreparedStatement(conn, sql_subamount);
			pStmt.setInt(1, amount);
			pStmt.setInt(2, id);
			int result = DB.executeUpdate(pStmt);
			if(result == 1){
				System.out.println("���·�������-1�ɹ�");
			}else{
				System.out.println("���·�������-1ʧ��");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
	}
	
	//����������Ϊ�޷���
	private static void setNoGrouping(int grouping_id){
		//ͨ������id������������������Ϊ���������
		int noGroupingId = DBService.getGroupingIdByGroupingName("�޷���");
		List<Integer> rs = DBService.getArticleIdByGroupingId(grouping_id);
		DBService.setArticleGroupingByRs(rs, noGroupingId);
	}
}
