<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctxStatic" value="${pageContext.request.contextPath}/static" />
<c:set var="path" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>后台登陆</title>
		<link rel="stylesheet" href="${ctxStatic}/bootstrap/3.3.6/css/bootstrap.min.css" />
		<link rel="stylesheet" href="${ctxStatic}/css/admin_login.css"/>
		<script src="${ctxStatic}/bootstrap/3.3.6/js/bootstrap.min.js"></script>
		<script>
			//全登陆不允许iframe嵌入
			if(window.top != window.self){
				window.top.location = window.laction;
			}
		</script>
	</head>
	<body>
		<div class="navbar">
			<nav class="navbar navbar-default" role="navigation">
   				<div class="navbar-header">
      				<a class="navbar-brand" href="#">XCK'S BOLG</a>
   				</div>
   				<div class="home_page">
      				<a class="navbar-brand" href="${path}/index.jsp">首页</a>
   				</div>
			</nav>
		</div>
		<div class="content">
			<div class="login_wrap">
				<div class="login_field">
					<div class="login_title">账户登陆</div>
					<form action="" method="post">
						<div class="admin_username_field">
							<label class="admin_username_icon" for="admin_username"><img src="${ctxStatic}/images/username.png"/></label>
							<input type="text" id="admin_username" name="usename" placeholder="用户名" size="30" style="width:245px;height:33px;"/>
						</div>
						<div class="admin_password_field">
							<label class="admin_password_icon" for="admin_password"><img src="${ctxStatic}/images/password.png"/></label>
							<input type="password" id="admin_password" name="password" size="30" style="width:245px;height:33px;"/>
						</div>
						<div class="admin_submit">
							<button type="submit" class="admin_submit_button btn btn-primary btn-lg">登陆</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</body>
</html>