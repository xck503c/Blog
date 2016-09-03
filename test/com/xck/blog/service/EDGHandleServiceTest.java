package com.xck.blog.service;

import org.junit.Test;

public class EDGHandleServiceTest {
	@Test
	public void deleteTest(){
		EDGHandleService.delete("article", 8, "article_id");
	}
}
