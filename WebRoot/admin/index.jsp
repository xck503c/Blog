<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="ctxStatic" value="${pageContext.request.contextPath}/static" />
<%@ taglib prefix="fns" uri="/WEB-INF/tlds/fns.tld" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>博客管理</title>
		
		<link rel="stylesheet" href="${ctxStatic}/common/javamg.min.css"/>
		
		<link rel="stylesheet" href="${ctxStatic}/bootstrap/2.3.1/css_cerulean/bootstrap.min.css"/> 
		<link rel="stylesheet" href="${ctxStatic}/jerichotab/css/jquery.jerichotab.css"/>
		<link rel="stylesheet" href="${ctxStatic}/css/admin_index.css"/>
		
		<script src="${ctxStatic}/jquery/jquery-1.8.3.min.js"></script>
		<script src="${ctxStatic}/jerichotab/js/jquery.jerichotab.js"></script>
		<script src="${ctxStatic}/common/javamg.min.js"></script>
		<script src="${ctxStatic}/bootstrap/2.3.1/js/bootstrap.min.js"></script>
		<script src="${ctxStatic}/js/admin_index.js"></script>
		
	</head>
	<body onload="isFlash();">
		<div id="header" class="navbar navbar-fixed-top">
			<div class="navbar-inner">
				<div class="brand">XCK'S BLOG</div>
				<ul class="nav pull-right">
					<li><a><i class="icon-home"></i></a></li>
					<li id="themeSwitch" class="dropdown">
						<a class="drop-toggle"><i class="icon-th-large"></i>主题切换</a>
					</li>
					<li><a title="退出登录">退出登录</a></li>
				</ul>
			</div>
	    </div>
		<div class="container">
			<div class="sidebar">
			<!--
				<div class="row">
					<div id="category" class="span2">
						<ul class="nav nav-pills nav-stacked">
							<c:forEach var="item" items="${fns:getSideBar()}">
								<li class="${item.id}"><a href="javascript:" data-href="${item.address}" data-id="${item.id}"><span>${item.name}</a></li>
							</c:forEach>
						</ul>
					</div>
				</div>
				  -->
				 <div class="accordion-group">
				 	<div class="accordion-heading">
				 		<a class="accordion-toggle">
				 			<i class="icon-chevron-down"></i>
				 			菜单
				 		</a>
				 	</div>
				 	<div class="accordion-body">
				 		<div id="category" class="accordion-inner">
				 			<ul class="nav nav-list">
				 				<c:forEach var="item" items="${fns:getSideBar()}">
									<li class="${item.id}">
										<a href="javascript:" data-href="${item.address}" data-id="${item.id}">
											<i class="icon-circle-arrow-right icon-white"></i>
											${item.name}
										</a>
									</li>
								</c:forEach>
				 			</ul>
				 		</div>
				 	</div>
				 </div>
			</div>
			<input id="move" type="hidden" value="true"/>
			<input id="level" type="hidden" value="1"/>
			<div id="rightContent" class="rightContent"></div>
			<div id="divMainLoader">Loading...</div>
			<div id="welcome">
				
			</div>
		</div>
	</body>
</html>