package com.xck.blog.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xck.blog.model.Article;
import com.xck.blog.model.ArticleGrouping;
import com.xck.blog.model.SideBar;
import com.xck.blog.util.DB;

public class CategoryService {
	
	//获取菜单栏
	@SuppressWarnings("null")
	public static List<SideBar> getSideBar(){
		List<SideBar> sidebar = null;
		try {
			sidebar = new ArrayList<SideBar>();
			Connection conn = DB.getConn();
			String sql = "select * from admin_sidebar";
			PreparedStatement pStmt = DB.getPreparedStatement(conn, sql);
			ResultSet rs = DB.executeQuery(pStmt);
			while(rs.next()){
				sidebar.add(new SideBar(rs.getInt("id"), rs.getString("name"), rs.getString("address")));
				//System.out.println(rs.getInt("id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sidebar;
	}
	
	//获取文章列表数据
	public static List<Article> getArticleList(){
		List<Article> articleList = null;
		try {
			articleList = new ArrayList<Article>();
			Connection conn = DB.getConn();
			String sql = "select * from article";
			PreparedStatement pStmt = DB.getPreparedStatement(conn, sql);
			ResultSet rs = DB.executeQuery(pStmt);
			while(rs.next()){
				int grouping_id = rs.getInt("article_grouping");
				String grouping_name = DBService.getGroupingNameByGroupingId(grouping_id);
				articleList.add(new Article(rs.getInt("article_id"), rs.getString("article_title"), rs.getDate("article_time"),
						rs.getInt("article_click"), rs.getInt("article_comment"), rs.getInt("article_up"), 
						rs.getInt("article_type"), rs.getInt("article_isComment"), grouping_name));
				//System.out.println(rs.getInt("id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return articleList;
	}
	
	//获取文章分类数据
	public static List<ArticleGrouping> getArticleGrouping(){
		List<ArticleGrouping> groupingList = null;
		try {
			groupingList = new ArrayList<ArticleGrouping>();
			Connection conn = DB.getConn();
			String sql = "select * from article_group";
			PreparedStatement pStmt = DB.getPreparedStatement(conn, sql);
			ResultSet rs = DB.executeQuery(pStmt);
			while(rs.next()){
				groupingList.add(new ArticleGrouping(rs.getInt("grouping_id"), rs.getString("grouping_name"),
						rs.getInt("grouping_amount"), rs.getString("grouping_image"), rs.getInt("grouping_sort_id")));
				//System.out.println(rs.getInt("id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return groupingList;
	}
}
