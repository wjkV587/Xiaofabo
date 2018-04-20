<%@ page language="java"
    pageEncoding="utf-8"%>
<html><head>
    <title>法律人工智能系统 {LawBot}</title>
<!-- 引入 Bootstrap -->
      <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
      <link rel="shortcut icon" href="images/favicon.ico">
       <script>
	     function open_win()
	     {
	        window.open("http://desk.v5kf.com/desk/kehu.html?site_id=123898","_blank","toolbar=no,scrollbars=yes,left=500px,top=100px,location=no, directories=no, status=no, menubar=yes, resizable=yes, copyhistory=yes, width=800, height=520")
	     }	     
	     </script>
    <style>

* {
	padding: 0;
	margin: 0;
	border: 0;
	font-family: Microsoft YaHei, Helvitica, Verdana, Arial, san-serif;
	-webkit-tap-highlight-color: transparent;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	-ms-box-sizing: border-box;
	-o-box-sizing: border-box;
	box-sizing: border-box;
	font-size: 16px;
}
p {
	margin: 0; padding: 0;
}
ul li {
	list-style: none;
}

#head {
	background-color: #708090;
	height: 70px;
}

.head_box {
	margin: 0 auto;
	max-width: 1096px;
	height: 70px;
}

.logo {
	display: inline-block;
	font-size: 32px;
	color: #fff;
	cursor: pointer;
	font-family: monospace;
	line-height: 35px;
	font-weight: 600;
}

.nav {
    float:right;
	display: inline-block;	
}

.nav_title {
	display: inline-block;
	cursor: pointer;
	float: left;
}

.nav_title a {
	color: #fff;
	display: inline-block;
	line-height: 50px;
	padding: 0px 15px;
}

.nav_title a:hover {
	color: #3399FF;
}

.menu {
	position: absolute;
	left: -2px;
	top: 70px;
	width: 116px;
	display: none;
	z-index: 99999;
}

.menu_title {
	background-color: #3b4348;
	color: #c1cad1;
	border-bottom: 1px solid #555;
	text-align: center;
}

.menu_title a {
	text-decoration: none;
	color: #c1cad1;
	padding: 0;
	line-height: 35px;
}

.menu_title a:hover {
	color: #fff;
}

.tslss {
	
}
.tslss.last {
	border-bottom: 0;
border-bottom-left-radius: 4px;
	border-bottom-right-radius: 4px;
}
.cld {
	font-size: 14px;
}
#experience {
	position: relative;
}
body {  
  background-image: url("images/bg.png");  
  background-position: center 0;  
  background-repeat: no-repeat;  
  background-attachment: fixed;  
  background-size: cover;  
  -webkit-background-size: cover;  
  -o-background-size: cover;  
  -moz-background-size: cover;  
  -ms-background-size: cover; 
}
li .active{color:#87CEFA;}
</style>
    
  </head>
  <body style="overflow: auto;background-color:#F0F0F0;">

<div id="head">
	<div class="head_box">
		<div class="logo" onclick="window.location.href='index.jsp'">{LawBot}<p>&nbsp法律人工智能系统</p></div>
		<ul class="nav">
			<li class="nav_title"><a class="active" href="index.jsp" id="indexId"><span>首页</span></a></li>
			<li class="nav_title"><a href="product.html" id="productId"><span>产品</span></a></li>
			
			<li class="nav_title" id="experience">
				<a href="test.jsp" id="aiId">AI案件分析</a>
				<div class="menu">
					<ul>
						<li class="menu_title tslss">
							<a href="javascript:;"><span class="cld">民间借贷</span></a>
						</li>
						<li class="menu_title tslss">
							<a href="javascript:;"><span class="cld">买卖合同</span></a>
						</li>
						<li class="menu_title tslss">
							<a href="javascript:;"><span class="cld">金融、投资</span></a>
						</li>
						<li class="menu_title tslss">
							<a href="javascript:;"><span class="cld">知识产权</span></a>
						</li>
						<li class="menu_title tslss">
							<a href="javascript:;"><span class="cld">诉讼、仲裁</span></a>
						</li>
						<li class="menu_title tslss last">
							<a href="javascript:;"><span class="cld">房地产</span></a>
						</li>
						<li class="menu_title tslss">
							<a href="javascript:;"><span class="cld">海事物流</span></a>
						</li>
					</ul>
				</div>
			</li>
			<li class="nav_title"><a href="javascript:open_win()"><span>法律Chatbot</span></a></li>
			<li class="nav_title"><a href="adju.html" id="adjuId"><span>AI裁决书</span></a></li>
			<!-- <li class="nav_title"><a href="lab.html" id="labId"><span>法律实验室</span></a></li> -->
			
			
			<li class="nav_title"><a href="about.html" id="aboutId"><span>关于我们</span></a></li>
			
		</ul>
	</div>
</div>
<br><br><br><br><br><br>
<!-- 开始正文部分 -->
<div class="container">
   <div class="row">
       <div  role="form" >

		    <div class="form-group form-horizontal col-md-8 col-xs-8 col-sm-8 col-md-offset-1 col-xs-offset-1 col-sm-offset-1">			
				<input type="text"  class="form-control input-lg"  id="name"  placeholder="请输入搜索关键词">
			</div>
			<button type="submit" class="btn btn-primary col-md-1 col-xs-1 col-sm-1 input-lg">检索</button>
     
       </div><!-- 表单结束 -->
   </div>
</div><!-- container结束 -->
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js">
</script>
<script>

$("#experience").mouseleave(function() {
	$('.menu').hide(200);
}).mouseover(function() {
	$('.menu').show(200);
});

$(".menu").mouseleave(function() {
	$(this).hide(200);
}).mouseover(function() {
	$(this).show(200);
});

var v5_chat_attrs	= "toolbar=0,scrollbars=0,location=0,menubar=0,resizable=1,top=" + (window.screen.availHeight - (window.screen.availHeight/2+275+40)) + ",left=" + (window.screen.availWidth - (window.screen.availWidth/2+365+20)) + ",width=730,height=550";
function openChat(){
    window.open('http://chat.v5kf.com/desk/kehu.html?site_id=123898', '_blank', v5_chat_attrs);
   	// win.resizeTo(800,600);
   	// win.moveTo(100,100);
}

</script>	
<iframe name="footer" scrolling="no" width=1535 height=350 marginwidth=0 marginheight=0 frameborder="no" border="0" src="footer.html" ></iframe>


</body>
</html>