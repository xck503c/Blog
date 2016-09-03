<%@ page contentType="text/html; charset=UTF-8"%>
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
	<script src="${ctxStatic}/bootstrap/2.3.1/js/bootstrap.min.js"></script>
</head>
<body>
	<table class="table table-bordered table-hover table-condensed table-responsive">
		<caption>类别管理</caption>
		<thead>
			<tr>
				<th>id</th>
				<th>类别</th>
				<th>文章</th>
				<th>缩略图</th>
				<th>操作</th>
				<th>排序</th>
			</tr>
			<tbody>
				<c:forEach var="item" items="${fns:getArticleGrouping()}">
					<tr>
						<td>${item.id}</td>
						<td>${item.name}</td>
						<td>${item.amount}</td>
						<td><img src="${item.image}"/></td>
						<td>
							<a href="${rootpath}/EDGArticleList?handle=edit&id=${item.id}&flag=groupinglist">编辑</a>|
							<a href="${rootpath}/EDGArticleList?handle=delete&id=${item.id}&flag=groupinglist">删除</a>
						</td>
						<td>${item.sort_id}</td>
					</tr>
				</c:forEach>
			</tbody>
		</thead>
	</table>
</body>
</html>