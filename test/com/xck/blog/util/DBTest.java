package com.xck.blog.util;

import java.sql.Connection;

import org.junit.Test;

import com.xck.blog.util.DB;

public class DBTest {
	
	@Test
	public void getConnTest(){
		if(DB.getConn() == null){
			System.out.println("yes");
		}else{
			System.out.println("no");
		}
	}
}
