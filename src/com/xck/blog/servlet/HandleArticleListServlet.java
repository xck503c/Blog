package com.xck.blog.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xck.blog.service.EDGHandleService;

public class HandleArticleListServlet extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response){
		try {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			System.out.println("post提交方法");
			String flag = request.getParameter("flag");
			int id = Integer.valueOf(request.getParameter("id"));
			String handle = request.getParameter("handle");
			if(flag.equals("articlelist")){
				System.out.println("文章列表");
				if(handle.equals("delete")){
					int result = EDGHandleService.delete("article", id, "article_id");
					if(result == 1){
						System.out.println("文章列表删除成功");
						response.sendRedirect("/xckblog/admin/article_list.jsp");
					}
				}else if(handle.equals("edit")){
					
				}
			}
			if(flag.equals("groupinglist")){
				System.out.println("分类列表");
				int result = EDGHandleService.delete("article_group", id, "grouping_id");
				if(result == 1){
					System.out.println("分类列表删除成功");
					response.sendRedirect("/xckblog/admin/article_grouping_manager.jsp");
				}
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			System.out.println("操作Servlet出错");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response){
		System.out.println("get提交方法");
		doPost(request, response);
	}
}
