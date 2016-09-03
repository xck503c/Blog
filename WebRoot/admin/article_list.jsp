<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="ctxStatic" value="${pageContext.request.contextPath}/static" />
<c:set var="rootpath" value="${pageContext.request.contextPath}" />
<%@ taglib prefix="fns" uri="/WEB-INF/tlds/fns.tld" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<link href="${ctxStatic}/bootstrap/2.3.1/css_cerulean/bootstrap.min.css" rel="stylesheet"/>
	<script src="${ctxStatic}/jquery/jquery-1.8.3.min.js"></script> 
	<script src="${ctxStatic}/bootstrap/2.3.1/js/bootstrap.min.js"></script>
	<script>$(function () 
      { $("[data-toggle='popover']").popover();
      });
   </script>
</head>
<body>
	<table class="table table-bordered table-hover table-condensed table-responsive">
		<caption>文章列表</caption>
		<thead>
			<tr>
				<th>id</th>
				<th>标题</th>
				<th>发布时间</th>
				<th>点击数</th>
				<th>评论数</th>
				<th>评论权限</th>
				<th>操作</th>
			</tr>
			<tbody>
				<c:forEach var="item" items="${fns:getArticleList()}">
					<tr>
						<td>${item.article_id}</td>
						<td>${item.article_title}</td>
						<td>${item.article_time}</td>
						<td>${item.article_click}</td>
						<td>${item.article_comment}</td>
						<td>${item.article_isComment}</td>
						<td>
							<a href="${rootpath}/EDGArticleList?handle=edit&id=${item.article_id}&flag=articlelist">编辑</a>|
							<a href="${rootpath}/EDGArticleList?handle=delete&id=${item.article_id}&flag=articlelist">删除</a>|
							<a title="分类"  data-container="body" data-toggle="popover" data-placement="bottom" data-content="${item.article_grouping}">分类</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</thead>
	</table>
</body>
</html>