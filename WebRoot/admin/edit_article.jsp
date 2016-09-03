<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctxStatic" value="${pageContext.request.contextPath}/static"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<style type="text/css">
			#articleTitle{
				width:854px;
				height:20px;
			}
		</style>
		<link rel="stylesheet" href="${ctxStatic}/bootstrap/2.3.1/css_cerulean/bootstrap.css"/> 
		<link rel="stylesheet" href="${ctxStatic}/editor/jwysiwyg/jquery.wysiwyg.css" type="text/css"/>
		<script type="text/javascript" src="${ctxStatic}/editor/jwysiwyg/lib/jquery.js"></script>
		<script type="text/javascript" src="${ctxStatic}/editor/jwysiwyg/jquery.wysiwyg.js"></script>
		<script type="text/javascript" src="${ctxStatic}/js/edit_article.js"></script>
	</head>
	<body>
		<form name="form" method="post" action="/xckblog/postArticle">
			<input type="text" name="articleTitle" id="articleTitle" placeholder="标题"/>
			<textarea name="articleContent" id="articleContent" cols="105" rows="17"></textarea>
      		<div class="grouping">
      			<select id="option" name="grouping"></select>
      			<input type="text" name="add" placeholder="新添加分类" style="display:none"/>
			</div>
			<button class="btn btn-default" onclick="checkSubmit(1)">提交</button>
			<button class="btn btn-default" onclick="checkSubmit(2)">存为草稿</button>
		</form>
	</body>
</html>