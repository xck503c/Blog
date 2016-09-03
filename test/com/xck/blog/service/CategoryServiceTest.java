package com.xck.blog.service;

import java.util.List;

import org.junit.Test;

import com.xck.blog.model.Article;
import com.xck.blog.model.ArticleGrouping;
import com.xck.blog.model.SideBar;

public class CategoryServiceTest {
	@Test
	public void getSideBarTest(){
		List<SideBar> list = CategoryService.getSideBar();
		for(int i=0; i<list.size(); i++)
			System.out.println(list.get(i).getName());
	}
	
	@Test
	public void getArticleListTest(){
		List<Article> list = CategoryService.getArticleList();
		for(int i=0; i<list.size(); i++){
			System.out.println(list.get(i).getArticle_title());
			System.out.println(list.get(i).getArticle_time());
			System.out.println(list.get(i).getArticle_id());
		}
	}
	
	@Test
	public void getGroupingListTest(){
		List<ArticleGrouping> list = CategoryService.getArticleGrouping();
		for(int i=0; i<list.size(); i++){
			System.out.println(list.get(i).getName());
			System.out.println(list.get(i).getSort_id());
			System.out.println(list.get(i).getAmount());
			System.out.println(list.get(i).getImage());
			System.out.println(list.get(i).getId());
		}
	}
}
