$(document).ready(function(){
	init();
});

function init(){
	//绑定右边 
	jericho.showLoader();
    var w = $(document).width();
    var h = $(document).height();
    $('.sidebar').css({ width: 190, height: h - 120, 'display': 'block' });
    $('.rightContent').css({ width: w - 250, height: h - 120, 'display': 'block', 'margin-left': 7 });
    //jericho.buildTree();
    jericho.buildTabpanel();
    jericho.removeLoader();
	
	//绑定一级菜单
	bindClickFirst();
	
	$('.tabs').css({
		"width":"890px"
	});
	$('.rightContent').css("width","890");
//	$('#jerichotab_contentholder').css("height", "461");
	$('.sidebar').css({
		"position":"absolute",
		"top":"130px",
		"left":"30px",
		"width":"190px",
		"height":"450px"
	});
	
	//绑定菜单点击事件
	$('.accordion-toggle').click(function(){
		if($('.accordion-toggle i').attr('class') == 'icon-chevron-down'){
			$('.accordion-body').css({
				"display":"none"
			});
			$('.accordion-toggle i').removeClass('icon-chevron-down');
			$('.accordion-toggle i').addClass('icon-chevron-right');
		}else{
			$('.accordion-body').css({
				"display":""
			});
			$('.accordion-toggle i').removeClass('icon-chevron-right');
			$('.accordion-toggle i').addClass('icon-chevron-down');
		}
		
	});
}

var jericho = {
	showLoader : function(){
		$('#divMainLoader').css('display', 'block');
	},
	removeLoader : function(){
		$('#divMainLoader').css('display', 'none');
	},
	buildTabpanel : function(){
		$.fn.initJerichoTab({
			renderTo : ".rightContent",
			uniqueId : "myJerichoTab",
			contentCss: { 'height': $('.rightContent').height() - 50 },
            tabs: [{
                title: 'JeirchoTab',
                closeable: false,
                data: { dataType: 'formtag', dataLink: '#welcome' },
            }],
            activeTabIndex: 0,
            loadOnce: true
		});
	}
};

//ajax
var xmlhttp;
function createXMLHttp(flag){
		
	//判断是否支持XMLHttpRequest
	if(window.XMLHttpRequest){	
		xmlhttp = new XMLHttpRequest();
	}else{
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	//绑定响应函数
	xmlhttp.onreadystatechange = callBack;
	//发送请求
	xmlhttp.open("POST", "/xckblog/adminIndex_sidebar?flag="+flag, true);
	xmlhttp.send(null);
}
	
//响应函数的回调函数
function callBack(){
	document.getElementById("category").innerHTML = xmlhttp.responseText;
//	if(xmlhttp.readyState==4 && xmlhttp.status==200){
//	}
	if($('#level').val() == '2'){
		bindClickSecond();
	}
	if($('#level').val() == '1'){
		bindClickFirst();
	}
}
	
//判断页面是否刷新
function isFlash(){
	//alert('111');
	$('#listTab li').length;
}
	
	//绑定一级菜单
function bindClickFirst(){
	$(".nav li").click(function(){
		$(".nav li").removeClass("active");
		$(this).addClass("active");
		$this = $(this);
		//向左滑动	
		if($('#move').val()){
			$('#move').val(false);
//			$(".sidebar").animate({left:'-210px'}, 2000, function(){
//				$('.sidebar').fadeOut(2000, "swing", function(){	
					if($this.attr("class") == '1 active'){
						//var url = "/xckblog/adminIndex_sidebar?flag=1";
						var flag = 1;
						createXMLHttp(flag);
						$('#level').val('2');
					}
					if($this.attr("class") == '2 active'){
						addTab($this.children('a'));
					}
//				});
//			});
		}
	});
}

function addTab($this){
	$.fn.jerichoTab.addTab({
        tabFirer: $this,
        title: $this.text(),
        closeable: true,
        data: {
            dataType: 'iframe',
            dataLink: $this.attr('data-href')
        }
    }).loadData();
	//重新指定标签页上面宽度 待改
	$('.tabs').width({
		"width":"890px"
	});
}

	
//绑定二级菜单
function bindClickSecond(){
	//再次绑定 有待改进
	if(!$('#move').val() || $('#move').val() == 'false'){	
		//$(".sidebar").animate({left:'30px'}, 2000, function(){
			$('#move').val(true);
//			$('.sidebar').fadeIn(100, "swing", function(){	
//			});
		//});
	}
	$(".nav li").click(function(){
		$(".nav li").removeClass("active");
		$(this).addClass("active");
		//alert($(this).attr('class'));
		
		//绑定返回事件
		if($(this).attr('class') == 'return active'){
			returnFirst();
		}
		//绑定编辑文章
		if($(this).attr('class') == 'newArticle active'){
			$.fn.jerichoTab.addTab({
		        tabFirer: $(this),
		        title: $(this).text(),
		        closeable: true,
		        data: {
		        	dataType: 'iframe',
		            dataLink: '/xckblog/admin/edit_article.jsp'
		        }
		    }).showLoader().loadData();
			//newArticle();
		}
		//绑定查看文章列表
		if($(this).attr('class') == 'articleCategory active'){
			$.fn.jerichoTab.addTab({
		        tabFirer: $(this),
		        title: $(this).text(),
		        closeable: true,
		        data: {
		        	dataType: 'iframe',
		            dataLink: '/xckblog/admin/article_list.jsp'
		        }
		    }).showLoader().loadData();
		}
		//重新指定标签页上面宽度 待改
		$('.tabs').css({
			"width":"890px"
		});
	});
}
	
//返回一级菜单
function returnFirst(){
	createXMLHttp('return');
	$('#level').val('1');
}