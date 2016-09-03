package com.xck.blog.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xck.blog.model.ArticleGrouping;
import com.xck.blog.model.SideBar;
import com.xck.blog.service.CategoryService;

public class AdminIndexServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response){
		try {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			String flag = request.getParameter("flag");
			if(flag.equals("1")){
				out.println(managerArticle_genSecond());
			}else if(flag.equals("return") || flag.equals("init")){
				out.println(generatorFirst());
			}else if(flag.equals("grouping")){
				out.println(getGrouping());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//管理博文  中的二级菜单
	private String managerArticle_genSecond(){
		String category = "<ul class='nav nav-list'>"
				+"<li class='newArticle'><a href='#'><i class='icon-circle-arrow-right icon-white'></i>新文章</a></li>"
				+"<li class='articleCategory'><a href='#'><i class='icon-circle-arrow-right icon-white'></i>文章列表</a>"
				+"<li class='return'><a href='#'><i class='icon-circle-arrow-right icon-white'></i>后退</a>"
				+"</ul>";
		return category;
	}
	
	//一级菜单
	private String generatorFirst(){
		List<SideBar> list = CategoryService.getSideBar();
		String returnString = "<ul class='nav nav-list'>";
		for(int i=0; i<list.size(); i++){
			returnString += "<li class='"+list.get(i).getId()+"'><a href='javascript:' data-href='"+list.get(i).getAddress()
					+"' data-id='"+list.get(i).getId()+"'><i class='icon-circle-arrow-right icon-white'></i>"+
					list.get(i).getName()+"</a></li>";
		}
		returnString += "</ul>";
		System.out.println(returnString);
		return returnString;
	}
	
	//获取编辑文章中的分类
	public String getGrouping(){
		List<ArticleGrouping> listgrouping = CategoryService.getArticleGrouping();
		String grouping = "";
		for(int i=0; i<listgrouping.size(); i++){
			grouping += "<option value='"+listgrouping.get(i).getName()+"'>";
			grouping += listgrouping.get(i).getName();
			grouping += "</option>";
		}
		grouping += "<option value='newGrouping'>添加新分类</option>";
		System.out.println(grouping);
		return grouping;
	}
}
