package com.xck.blog.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xck.blog.model.Article;
import com.xck.blog.service.PostArticleService;

public class EditArticleServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response){
		try {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			//int flag = 1;
			int flag = Integer.valueOf(request.getParameter("flag"));
			//System.out.println("21");
			if(flag != 1 && flag !=2){
				System.out.println("提交值错误");
				return;
			}
			
			String article_title = request.getParameter("articleTitle");  //标题
			String article_content = request.getParameter("articleContent"); //内容
			Date article_time = new Date();  //时间
			String article_grouping = request.getParameter("grouping");  //需要查询
			//System.out.println(article_grouping);
			
			//是否为在文本框中添加的分类
			if(article_grouping.equals("newGrouping")){
				System.out.println("激活文本框");
				article_grouping = request.getParameter("add");
			}
			
			//保存flag为1说明是提交而不是草稿
			if(flag == 1){
				int article_click = 0; //点击数
				int article_comment = 0; //评论数
				int article_up = 0; //是否置顶 0 不置顶 或 1 置顶
				int article_type = 0; //文章查看模式 0公有 1私有 
				int article_isComment = 0; //评论权限 0不禁止 1 禁止
				Article article = new Article(article_title, article_time, article_click, 
						article_comment, article_up, article_type, article_isComment, article_content,
						article_grouping);
				int result = PostArticleService.postArticle(article);
				if(result == 1){
					System.out.println("提交成功");
					response.sendRedirect("/xckblog/admin/article_list.jsp");
					return;
				}
				response.sendRedirect("/xckblog/admin/edit_article.jsp");
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response){
		doPost(request, response);
		System.out.println("get");
	}
}
