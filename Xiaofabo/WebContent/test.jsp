<%@ page language="java"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 4.01 Transitional//EN">
<html><head>

    <title>案件分析 {LawBot}</title>
    
<!-- 引入 Bootstrap -->
      <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
      <link rel="shortcut icon" href="images/favicon.ico">
      <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
      <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
	text-decoration: none;
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
.lawbot{
cursor: pointer;

}
img
{
  opacity:0.4;
  filter:alpha(opacity=40); /*  IE8 及其更早版本 */
  
}
img:hover
{
  opacity:1.0;
  filter:alpha(opacity=100); /* IE8 及其更早版本 */
}
li .active{color:#87CEFA;}

      
.ignore {
  position: absolute;
  right: 125px;
  opacity: 0;
  z-index: 999;
  cursor: pointer;
  width: 10px;
  line-height: 2.0;
}

</style>
    
  </head>
  <body style="overflow: auto;background-color:#F0F0F0;">

<div id="head">
	<div class="head_box">
		<div class="logo" onclick="window.location.href='index.jsp'">{LawBot}<p>&nbsp法律人工智能系统</p></div>
		<ul class="nav">
			<li class="nav_title"><a href="index.jsp" id="indexId"><span>首页</span></a></li>
			<li class="nav_title"><a href="product.html" id="productId"><span>产品</span></a></li>
			
			<li class="nav_title" id="experience">
				<a class="active" href="test.jsp" id="aiId">AI案件分析</a>
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
			<li class="nav_title"><a href="javascript: open_win();"><span>法律Chatbot</span></a></li>
			<li class="nav_title"><a href="adju.html" id="adjuId"><span>AI裁决书</span></a></li>
			<!-- <li class="nav_title"><a href="lab.html" id="labId"><span>法律实验室</span></a></li> -->
			
			
			<li class="nav_title"><a href="about.html" id="aboutId"><span>关于我们</span></a></li>
			
		</ul>
	</div>
</div>

<br>
<!-- 标题栏下 ，左右面板-->
<div class="container">
	<div class="row clearfix">
		 <div class="panel panel-info col-md-5 col-xs-12 col-sm-5">
				<form role="form" action="analyse_analysecase" method="post">
			           <div class="form-group">
			              <label for="name"><h4>案例分析</h4></label>
			              <textarea id="textarea_id" name="textarea_id" class="form-control" rows="10" >${casetext }</textarea>
			              <div class="btn-group col-md-offset-9 col-xs-offset-9 col-sm-offset-9">
							    
							    <input type="file" onchange="uploadfile()" id="txt" name="uplodfile" class="ignore" style="cursor: pointer;">
					             <div class="row clearfix">
					              <span class="btn btn-primary col-md-6 col-xs-6 col-sm-6">上传</span>    
							    <button type="submit" class="btn btn-primary col-md-6 col-xs-6 col-sm-6">分析</button>
					            </div>
					      </div>
					      
			            </div>                       
	             </form>           			  
			</div>
	     <!-- 小法博图标 -->
	    
	     <div class="col-md-1 col-xs-1 col-sm-1">
	       <a class="lawbot" onclick="open_win()">
	       <img src="images/law.jpg" class="img-circle navbar navbar-inner navbar-fixed-top" width="8%"></img></a>
	     </div>
	    <!-- 关键因子
                                   引用法条
                                    引用规则
                                     胜负概率 -->
	    
		<div class="col-md-6 col-xs-12 col-sm-6 column">
			<div class="panel panel-info">
				<div class="panel-heading">
			          <h4 class="panel-title">
				       <a data-toggle="collapse" data-parent="#accordion" 
				            href="#collapseOne1">
					          关键因子
				       </a>
			         </h4>
		         </div>
				   <div id="collapseOne1" class="panel-collapse collapse in">
					<div class="panel-body">
						<c:forEach items="${key }" var="li" varStatus="status">
								<c:if test="${status.count==1 }">
									<c:forEach items="${key[li.key] }" var="str" varStatus="status1">
									    ${str}
									    <br>
									</c:forEach>
								</c:if>	
								
								    
						</c:forEach>
					</div>
				   </div>
			</div>
			
			<div class="panel panel-info">
				<div class="panel-heading">
			          <h4 class="panel-title">
				       <a data-toggle="collapse" data-parent="#accordion" 
				            href="#collapseOne2">
					          引用法条
				       </a>
			         </h4>
		         </div>
				   <div id="collapseOne2" class="panel-collapse collapse in">
					<div class="panel-body">
							<c:forEach items="${law }" var="li" varStatus="status">
								<c:if test="${status.count==1 }">
									<c:forEach items="${law[li.key] }" var="str" varStatus="status1">
									    ${str}
									    <br>
									</c:forEach>
								</c:if>	
								
								    
						</c:forEach>
					</div>
				   </div>
			</div>
			
			
			<div class="panel panel-info">
				<div class="panel-heading">
			          <h4 class="panel-title">
				       <a data-toggle="collapse" data-parent="#accordion" 
				            href="#collapseOne3">
					          引用规则
				       </a>
			         </h4>
		         </div>
				   <div id="collapseOne3" class="panel-collapse collapse in">
					<div class="panel-body">
						<c:forEach items="${rules }" var="li" varStatus="status">
								<c:if test="${status.count==1 }">
									<c:forEach items="${rules[li.key] }" var="str" varStatus="status1">
									    ${str}
									    <br>
									</c:forEach>
								</c:if>	
								
								    
						</c:forEach>
					</div>
				   </div>
			</div>
			
			<div class="panel panel-info">
				<div class="panel-heading">
			          <h4 class="panel-title">
				       <a data-toggle="collapse" data-parent="#accordion" 
				            href="#collapseOne4">
					        胜负概率
				       </a>
			         </h4>
		         </div>
				   <div id="collapseOne4" class="panel-collapse collapse in">
					<div class="panel-body">
						80%（固定数据）
					</div>
				   </div>
			</div>
		</div>
	</div>

<!-- 典型案例表格 -->
<div class="row clearfix">
		<div class="col-md-12 col-xs-12 col-sm-12 column">
		<h4>典型案例推送(Top 10)</h4>
			<table class="table table-hover table-condensed table-striped">
				<thead>
					<tr>
						<th style="width:5%"><center>排名</center></th>
						<th style="width:10%"><center>案名</center></th>
						<th style="width:25%"><center>法条</center></th>
						<th style="width:25%"><center>关键因子</center></th>
						<th style="width:10%"><center>时间</center></th>
						<th style="width:25%"><center>明细</center></th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${list }" var="solrdoc" varStatus="status">
					<tr>
						<td>
							${status.count}
						</td>
						<td>
							${solrdoc.getFieldValue("案件名称") }
						</td>
						<td>
							<center>
							<button class="btn btn-primary" data-toggle="modal" data-target="#myModal1${status.count}">引用法条</button>
							</center>
							
							<!-- 模态框（Modal） -->
							<div class="modal fade" id="myModal1${status.count}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
												&times;
											</button>
											<h4 class="modal-title" id="myModalLabel">
												法条law
											</h4>
										</div>
										<div class="modal-body">
												<c:forEach items="${law }" var="li" varStatus="sta">
														<c:if test="${sta.count==status.count }">
															<c:forEach items="${law[li.key] }" var="str" varStatus="status1">
															    ${str}
															    <br>
															</c:forEach>
														</c:if>				    
												</c:forEach>
										</div>
										
									</div><!-- /.modal-content -->
								</div><!-- /.modal -->
							</div>
							
							
							
						</td>
						<td>
						
							<!-- 关键因子 -->
							<c:forEach items="${key }" var="li" varStatus="status1">						
								<c:if test="${li.key==(status.count-1) }">
									<c:forEach items="${key[li.key] }" var="str" varStatus="status2">
									    ${str}
									    <br>
									</c:forEach>
								</c:if>																	    
						     </c:forEach>
							
						</td>
						<td>
							${solrdoc.getFieldValue("裁判日期") }
						</td>
						<td>
						    <center>
							<button class="btn btn-danger" data-toggle="modal" data-target="#myModal2${status.count}">案例明细</button>
							</center>
							
							<!-- 模态框（Modal） -->
							<div class="modal fade" id="myModal2${status.count}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
												&times;
											</button>
											<h4 class="modal-title" id="myModalLabel">
												 案例明细  
											</h4>
										</div>
										<div class="modal-body">
											${solrdoc.getFieldValue("原告诉称") }
										</div>
										
									</div><!-- /.modal-content -->
								</div><!-- /.modal -->
							</div>				
							<!--  ${solrdoc.getFieldValue("原告诉称") }-->
						</td>
					</tr>
					
				</c:forEach>	
					
					
				</tbody>
			</table>
		</div>
	</div>
	
<!-- 典型案例表格 -->
<div class="row clearfix">
		<div class="col-md-12 col-xs-12 col-sm-12 column">
		<h4>基层法院推送(Top 10)</h4>
			<table class="table table-hover table-condensed table-striped">
				<thead>
					<tr>
						<th style="width:5%"><center>排名</center></th>
						<th style="width:10%"><center>案名</center></th>
						<th style="width:25%"><center>法条</center></th>
						<th style="width:25%"><center>关键因子</center></th>
						<th style="width:10%"><center>时间</center></th>
						<th style="width:25%"><center>明细</center></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>
							
						</td>
						<td>
							
						</td>
						<td>
							
						</td>
						<td>
							
						</td>
						<td>
							
						</td>
						<td>
						</td>
					</tr>
					
				</tbody>
			</table>
		</div>
	</div>
	</div>
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

//此处为txt文件上传预览的js代码
function uploadfile(){
	var file=$("#txt")[0].files[0];
	//判断上传文件是不是txt格式,判断后缀是不是.txt
	if(file.name.substr(-4).toLocaleLowerCase() != '.txt'){
		alert("请上传格式为txt的文件！");
		windows.location="test.jsp";//重新定位到上传txt文件页面
	}
	else//如果上传文件是txt文件，则显示文件的预览
	{
		var reader=new FileReader;
		reader.readAsText(file,'gb2312');
		//reader.readAsDataURL(file);
		reader.onload=function(evt){
			var data=evt.target.result;		
			$('#textarea_id').val(data);	
		}	
	}	
}
</script>	
</body>
</html>