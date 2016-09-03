package com.xck.blog.service;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

public class DBServiceTest {
	@Test
	public void getGroupingIdByGroupingNameTest(){
		System.out.println(DBService.getGroupingIdByGroupingName("Œﬁ∑÷¿‡"));
	}
	
	@Test
	public void getGroupingAmountByGroupingIdTest(){
		System.out.println(DBService.getGroupingAmountByGroupingId(6));
	}
	
	@Test
	public void setGroupingAmountByGroupingIdTest(){
		//int amount = DBService.getGroupingAmountByGroupingId(6)+1;
		System.out.println(DBService.setGroupingAmountByGroupingId(0, 6));
	}
	
	@Test
	public void getArticleIdByGroupingIdTest(){
		List<Integer> rs = DBService.getArticleIdByGroupingId(4);
		for(int i=0; i<rs.size(); i++){
			System.out.println(rs.get(i));
		}
	}
	
	@Test
	public void setArticleGroupingByArticleIdTest(){
		System.out.println(DBService.setArticleGroupingByArticleId(17, 6));
	}
}
