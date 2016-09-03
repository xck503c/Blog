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
				System.out.println("�ύֵ����");
				return;
			}
			
			String article_title = request.getParameter("articleTitle");  //����
			String article_content = request.getParameter("articleContent"); //����
			Date article_time = new Date();  //ʱ��
			String article_grouping = request.getParameter("grouping");  //��Ҫ��ѯ
			//System.out.println(article_grouping);
			
			//�Ƿ�Ϊ���ı�������ӵķ���
			if(article_grouping.equals("newGrouping")){
				System.out.println("�����ı���");
				article_grouping = request.getParameter("add");
			}
			
			//����flagΪ1˵�����ύ�����ǲݸ�
			if(flag == 1){
				int article_click = 0; //�����
				int article_comment = 0; //������
				int article_up = 0; //�Ƿ��ö� 0 ���ö� �� 1 �ö�
				int article_type = 0; //���²鿴ģʽ 0���� 1˽�� 
				int article_isComment = 0; //����Ȩ�� 0����ֹ 1 ��ֹ
				Article article = new Article(article_title, article_time, article_click, 
						article_comment, article_up, article_type, article_isComment, article_content,
						article_grouping);
				int result = PostArticleService.postArticle(article);
				if(result == 1){
					System.out.println("�ύ�ɹ�");
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
