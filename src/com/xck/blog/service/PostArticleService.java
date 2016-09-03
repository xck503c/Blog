package com.xck.blog.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.xck.blog.model.Article;
import com.xck.blog.util.DB;

public class PostArticleService {
	
	@SuppressWarnings({ "resource" })
	public static int postArticle(Article article){
		try {
			//�������id�ӷ�����в����
			String sql_grouping = "select grouping_id from article_group where grouping_name=?";
			Connection conn = DB.getConn();
			PreparedStatement pStmt = DB.getPreparedStatement(conn, sql_grouping);
			pStmt.setString(1, article.getArticle_grouping());
			ResultSet rs = DB.executeQuery(pStmt);
			int id = -1;
			while(rs.next()){
				id = rs.getInt("grouping_id");
			}
			//���id����-1��˵������Ϊ�µ�
			if(id == -1){
				//������article_group����
				String sql_insertgrouping = "insert into article_group(grouping_name,grouping_amount) values(?,?)";
				pStmt = DB.getPreparedStatement(conn, sql_insertgrouping);
				pStmt.setString(1, article.getArticle_grouping());
				pStmt.setInt(2, 1);
				//��ȡ�¼�¼��id
				id = DB.executeUpdate(pStmt);
				if(id!=-1 && id!=0){
					System.out.println("grouping����ɹ�");
					System.out.println("grouping��id : " + id);
				}else{
					System.out.println("postArticle��sql_insertgrouping���û��ִ�гɹ�");
					return 0;
				}
			}else{
				System.out.println("id: " + id);
				//���������Ϊ�µľͽ�������������1
				String sql_getamount = "select grouping_amount from article_group where grouping_id=?";
				pStmt = DB.getPreparedStatement(conn, sql_getamount);
				pStmt.setInt(1, id);
				rs = DB.executeQuery(pStmt);
				int amount;
				if(rs.next()){
					amount = rs.getInt("grouping_amount")+1;
					System.out.println("��������Ϊ" + amount);
					String sql_update = "update article_group set grouping_amount=? where grouping_id=?";
					pStmt = DB.getPreparedStatement(conn, sql_update);
					pStmt.setInt(1, amount);
					pStmt.setInt(2, id);
					int result = DB.executeUpdate(pStmt);
					if(result == 1){
						System.out.println("grouping��������1�ɹ�");
					}else{
						System.out.println("grouping��������1ʧ��");
					}
				}else{
					System.out.println("û��������¼");
				}
			}
			//���������ݿ� 
			String insert_sql_article = "insert into article(article_title,article_content,"
					+ "article_time,article_click,article_comment,article_grouping,article_up,"
					+ "article_type,article_isComment) values(?,?,?,?,?,?,?,?,?)";
			pStmt = DB.getPreparedStatement(conn, insert_sql_article);
			pStmt.setString(1, article.getArticle_title());
			pStmt.setString(2, article.getArticle_content());
			pStmt.setTimestamp(3, new Timestamp(article.getArticle_time().getTime()));
			pStmt.setInt(4, article.getArticle_click());
			pStmt.setInt(5, article.getArticle_comment());
			pStmt.setInt(6, id);
			pStmt.setInt(7, article.getArticle_up());
			pStmt.setInt(8, article.getArticle_type());
			pStmt.setInt(9, article.getArticle_isComment());
			int result = DB.executeUpdate(pStmt);
			if(result!=-1 && result!=0){
				System.out.println("article����ɹ�");
				return 1;
			}else{
				System.out.println("postArticle��insert_sql_article���û��ִ�гɹ�");
				return 0;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("postArticle����");
		}
		return 0;
	}
}
