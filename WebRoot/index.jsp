<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctxStatic" value="${pageContext.request.contextPath}/static"/>
<c:set var="path" value="${pageContext.request.contextPath}"/>

<html>
	<head>
		<title>xck's blog</title>
		<link rel="stylesheet" href="${ctxStatic}/bootstrap/2.3.1/css_cerulean/bootstrap.min.css"/>
		<link rel="stylesheet" href="${ctxStatic}/css/index.css"/>
		<link rel="stylesheet" href="${ctxStatic}/wow/css/animate.css">
		<script src="${ctxStatic}/jquery/jquery-2.2.0.js"></script>
		<script src="${ctxStatic}/bootstrap/2.3.1/js/bootstrap.min.js"></script>
		<script src="${ctxStatic}/wow/js/wow.min.js"></script>
	</head>
	<body>
		<div id="header" class="navbar navbar-fixed-top">
			<div class="navbar-inner">
				<div class="brand">XCK'S BLOG</div>
				<ul class="nav pull-right">
					<li><a title="退出登录" href="${path}/admin/login.jsp">后台登录</a></li>
				</ul>
			</div>
		</div>
		<div class="container">
			<div id="myCarousel" class="carousel slide">
			   <!-- 轮播（Carousel）指标 -->
			   <ol class="carousel-indicators">
			      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			      <li data-target="#myCarousel" data-slide-to="1"></li>
			      <li data-target="#myCarousel" data-slide-to="2"></li>
			   </ol>   
			   <!-- 轮播（Carousel）项目 -->
			   <div class="carousel-inner">
			      <div class="item active">
			         <img src="${ctxStatic}/images/admin_qsmy.jpg" alt="First slide">
			      </div>
			      <div class="item">
			         <img src="${ctxStatic}/images/admin_qsmy.jpg" alt="Second slide">
			      </div>
			      <div class="item">
			         <img src="${ctxStatic}/images/admin_qsmy.jpg" alt="Third slide">
			      </div>
			   </div>
			   <!-- 轮播（Carousel）导航 -->
			   <a class="carousel-control left" href="#myCarousel" data-slide="prev">&lsaquo;</a>
			   <a class="carousel-control right" href="#myCarousel" data-slide="next">&rsaquo;</a>
			</div>
			<div class="content">
				<div class="row">
					<div id="blog_type">
						<h3>文章分类</h3>
					</div>
					<div id="data_sys">
						<h3>数据分析</h3>
					</div>
					<div id="comment">
						<h3>评论板块</h3>
					</div>
				</div>
				<div class="draw">
					<canvas id="myCanvas" width="760" height="200"></canvas>
				</div>
			</div>			
		</div>
		<div class="tail">
			CopyRight &copy;  2005 - 2016 东莞市永盛通信科技有限公司 版权所有 粤ICP备08130115号-1 联系方式：4001-666-888
		</div>
		<script type="text/javascript">
			var c=document.getElementById("myCanvas");
			var cxt=c.getContext("2d");
			cxt.fillStyle="#FF0000";
			cxt.fillRect(0,0,760,760);
		</script>
	</body>
</html>