(function($) {
	$(document).ready(function() {
		$('#articleContent').wysiwyg();
		$('.wysiwyg').css({
			"width":"857px"
		});
		$('#articleContent-wysiwyg-iframe').css({
			"width":"857px"
		});
		getGrouping();
		bindNewGrouping()
	});
})(jQuery);

//ajax
var xmlhttp;
function createXMLHttp(url){
		
	//判断是否支持XMLHttpRequest
	if(window.XMLHttpRequest){	
		xmlhttp = new XMLHttpRequest();
	}else{
		xmlhttp = new ActiveXObject('Microsoft.XMLHTTP');
	}
	//绑定响应函数
	xmlhttp.onreadystatechange = callBack;
	//发送请求
	xmlhttp.open("POST", url, true);
	xmlhttp.send(null);
}
	
//响应函数的回调函数
function callBack(){
	var string = xmlhttp.responseText;
	document.getElementById('option').innerHTML = string;
}

function getGrouping(){
	createXMLHttp('/xckblog/adminIndex_sidebar?flag=grouping');
}

function checkSubmit(flag){
	//alert($('#articleTitle').val()=='');
	if($('#articleTitle').val() == ''){
		alert('标题不能为空');
		return;
	}
	//alert($('#option option:selected') .val());
	var option = $('#option option:selected').val()
	if(option=='' || option==null){
		alert('请选择或添加分类');
		return;
	}
//	alert($('.grouping input').val());
//	alert(option);
	//填写分类
	if(option=='newGrouping' && $('.grouping input').val()==''){
		alert('未填写新分类');
		return;
	}
	
	var pathName = window.document.location.pathname;
	var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
	//alert(projectName+"/postArticle?flag=1");
	//alert(document.getElementById('write').method);
	//document.getElementById('write').method = 'post';
	//alert(document.form.action);
	//document.form.action = '/xckblog/postArticle';
	if(flag == 1){
		document.form.action = 'http://localhost:8080'+projectName+"/postArticle?flag=1";
		//alert(document.getElementById('write').action);
		document.form.submit();
	}else{
		document.form.action = 'http://localhost:8080'+projectName+"/postArticle?flag=2";
		document.form.submit();
	}
}

//控制添加新分类的文本框
function bindNewGrouping(){
	$('#option').change(function(){
		if($(this).children('option:selected').val() == 'newGrouping'){
			$('.grouping input').css({
				"display":""
			});
		} 
	});
}