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
      
    <script type="text/javascript" src="echarts/echarts.js"></script> 
     <script type="text/javascript" src="echarts/china.js"></script> 
        <script type="text/javascript" src="echarts/shine.js"></script> 
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
	             <!-- 胜率+法条 -->
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
											     <c:if test="${status1.count%4==1 }">  
											        <h5  class="alert alert-info">${str}</h5>
											     </c:if>
											      <c:if test="${status1.count%4==2 }">  
											        <h5  class="alert alert-info">${str}</h5>
											     </c:if>
											      <c:if test="${status1.count%4==3 }">  
											        <h5  class="alert alert-info">${str}</h5>
											     </c:if>
											      <c:if test="${status1.count%4==0 }">  
											        <h5  class="alert alert-info">${str}</h5>
											     </c:if>
											    
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
								<h5>80%（固定数据）</h5>
							</div>
						   </div>
					</div>         			  
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
		<div class="panel-group" id="accordion">
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
					<div id="div1" class="panel-body" style="display:block;">
						<c:forEach items="${key }" var="li" varStatus="status">
								<c:if test="${status.count==1 }">
									<c:forEach items="${key[li.key] }" var="str" varStatus="status1">
									    <h4><span style="display:block;float:left;margin:0 15px 10px 0;" class="label label-info">${str}</span><h4>
									    
									</c:forEach>
								</c:if>	    
						</c:forEach>
					</div>
				   </div>
			</div>
			<!--  
			<div class="panel panel-info">
				<div class="panel-heading">
			          <h4 class="panel-title">
				       <a data-toggle="collapse" data-parent="#accordion" 
				            href="#collapseOne1" id="btn1">
					          关键因子
				       </a>
				       
				        <a data-toggle="collapse" data-parent="#accordion" 
				            href="#collapseOne11" id="btn11" style="float:right;">
					          引用规则
				       </a>
			         </h4>
			         
		         </div>
				   <div id="collapseOne1" class="panel-collapse collapse in" >
					<div id="div1" class="panel-body" style="display:block;">
					
						<c:forEach items="${key }" var="li" varStatus="status">
								<c:if test="${status.count==1 }">
									<c:forEach items="${key[li.key] }" var="str" varStatus="status1">
									    <c:if test="${status1.count%4==1 }">
             									    <h3><span style="display:block;float:left;margin:0 15px 10px 0;" class="label label-info">${str}</span></h3>
			                            </c:if>	
			                            <c:if test="${status1.count%4==2 }">
             									    <h3><span style="display:block;float:left;margin:0 15px 10px 0;" class="label label-info">${str}</span></h3>
			                            </c:if>	
			                            <c:if test="${status1.count%4==3 }">
             									    <h3><span style="display:block;float:left;margin:0 15px 10px 0;" class="label label-info">${str}</span></h3>
			                            </c:if>	
			                            <c:if test="${status1.count%4==0 }">
             									    <h3><span style="display:block;float:left;margin:0 15px 10px 0;" class="label label-info">${str}</span></h3>
			                            </c:if>						  
									    
									</c:forEach>
								</c:if>	
								
								    
						</c:forEach>
					</div>
				   </div>
				   <!-- 引用规则的div块 
				   <div id="collapseOne11" class="panel-collapse collapse">
					<div id="div2" class="panel-body"  style="display:block;">
					
						<c:forEach items="${rules }" var="li" varStatus="status">
								<c:if test="${status.count==1 }">
									<c:forEach items="${rules[li.key] }" var="str" varStatus="status1">
									    <!--  <h3><span style="white-space:normal;word-wrap:break-word;" class="label label-info">${str}</span></h3>
									     
									     <c:if test="${status1.count%4==1 }">
             									    <h3><span style="white-space:normal;word-wrap:break-word;" class="label label-info">${str}</span></h3>
			                            </c:if>	
			                            <c:if test="${status1.count%4==2 }">
             									    <h3><span style="white-space:normal;word-wrap:break-word;" class="label label-info">${str}</span></h3>
			                            </c:if>	
			                            <c:if test="${status1.count%4==3 }">
             									    <h3><span style="white-space:normal;word-wrap:break-word;" class="label label-info">${str}</span></h3>
			                            </c:if>	
			                            <c:if test="${status1.count%4==0 }">
             									    <h3><span style="white-space:normal;word-wrap:break-word;" class="label label-info">${str}</span></h3>
			                            </c:if>	
									</c:forEach>
								</c:if>	
								
								    
						</c:forEach>
					</div>
				   </div>
				   <!-- 控制隐藏与显示的js 
				    <script>
					       var oBtn1 = document.getElementById('btn1');
					       var oBtn11 = document.getElementById('btn11');
					       
					        var oDiv1 = document.getElementById('div1');
					        var oDiv2 = document.getElementById('div2');
					        oBtn1.onclick = function(){   
					        	//alert(oDiv1.className);
					        	//alert("你点击了关键因子");
					        	//oDiv1.setAttribute("className", "panel-collapse collapse in");
					        	//oDiv2.className="panel-collapse collapse";
					        	
					        	if(oDiv1.style.display=='none'){
					        	oDiv1.style.display='block';}
					        	
					        	oDiv2.style.display='none';
					        	
					        	//
					        	//oDiv2.class='panel-collapse collapse';
				                
				                
				             
					        };
					        oBtn11.onclick = function(){       
					        	//alert("你点击了引用法则");
					        	
					        	//oDiv2.setAttribute("className", "panel-collapse collapse in");
					        	
					        	oDiv1.style.display='none';
					        	if(oDiv2.style.display=='none'){
					        	oDiv2.style.display='block';}
					        	//oDiv1.className="panel-collapse collapse";
					        	//alert(oDiv1.className);
				                
					        };
					        
                   </script>
				   
			</div>-->
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
					<div id="div2" class="panel-body"  style="display:block;">
						<c:forEach items="${rules }" var="li" varStatus="status">
								<c:if test="${status.count==1 }">
									<c:forEach items="${rules[li.key] }" var="str" varStatus="status1">
									    <h4><span style="white-space:normal;word-wrap:break-word;" class="label label-info">${str}</span></h4>
									</c:forEach>
								</c:if>	
								
								    
						</c:forEach>
					</div>
				   </div>
			</div>
			
			
		</div>
	</div>

<!-- 典型案例表格 -->
<div class="row clearfix">
		<div class="col-md-12 col-xs-12 col-sm-12 column">
		<div class="tabbable">
			<ul class="nav nav-tabs" style="float:left;">
				<li class="active" id="li1">
					 <a id="t1"><h5>最高法院案例推送(Top 10)</h5></a>
				</li>
				<li id="li2">
					 <a  id="t2"><h5>高院、中院案例推送(Top 10)</h5></a>
				</li>
		    </ul>
		   <br>
		   <div class="tab-content">
					<div class="tab-pane active" id="p1">
		
							<table class="table table-hover table-condensed table-striped">
								<thead>
									<tr>
										<th style="width:5%"><center>排名</center></th>
										<th style="width:25%"><center>案名</center></th>
										<th style="width:10%"><center>法条</center></th>
										<th style="width:40%"><center>关键因子</center></th>
										<th style="width:10%"><center>时间</center></th>
										<th style="width:10%"><center>操作</center></th>
									</tr>
								</thead>
								<tbody>
								<c:forEach items="${list }" var="solrdoc" varStatus="status">
									<tr>
										<td>
											<center>${status.count}</center>
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
				                           
													                                 <c:if test="${status1.count%4==1 }">  
																				        <h5 class="alert alert-info">${str}</h5>
																				     </c:if>
																				      <c:if test="${status1.count%4==2 }">  
																				        <h5 class="alert alert-info">${str}</h5>
																				     </c:if>
																				      <c:if test="${status1.count%4==3 }">  
																				        <h5 class="alert alert-info">${str}</h5>
																				     </c:if>
																				      <c:if test="${status1.count%4==0 }">  
																				        <h5 class="alert alert-info">${str}</h5>
																				     </c:if>
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
													    <h5><span style="display:block;float:left;margin:0 20px 10px 0">${str}</span>
							                           </h5>
													    
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
											<div class="modal fade"  id="myModal2${status.count}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
													<div class="modal-dialog" style="width: 1250px;height:1250px;" >
													<div class="modal-content">
														<div class="modal-header">
															<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
																&times;
															</button>
															<center><h4 class="modal-title" id="myModalLabel">
																案例详细展示
															</h4>
															</center>
														</div>
														<!-- 左上 -->
														<div class="modal-body" style="width: 1250px;height:1250px;" >
																<div style="width: 400px;height: 500px;float: left;">
																      <h2><span style="white-space:normal;word-wrap:break-word;" >原告诉称</span></h2>	
																         ${solrdoc.getFieldValue("原告诉称") }														
															    </div>
															    <!-- 右上 -->
																<div  id="echarts${status.count}" style="width: 800px;height: 1200px;float: right;" >
																	<!--  <h3><span style="white-space:normal;word-wrap:break-word;" >可视化</span></h3>	-->														
																		 <script>
																					//基于准备好的dom，初始化ECharts实例
																					var myChart = echarts.init(document.getElementById('echarts${status.count}'));
																					// 指定图表的配置项和数据
																					var option = {
																					    /*title: {
																					        text: '关键因子 TO 对应法条'
																					    },*/
																					    tooltip: {},
																					    animationDurationUpdate: 1500,
																					    animationEasingUpdate: 'quinticInOut',
																					    series : [
																					        {
																					            type: 'graph',
																					            layout: 'none',
																					            legendHoverLink : true,//是否启用图例 hover(悬停) 时的联动高亮。
																					            symbolSize: 50,
																					            roam: true,
																					            label: {
																					                normal: {
																					                    show: true
																					                }
																					            },
																					            draggable : true,//节点是否可拖拽，只在使用力引导布局的时候有用。
																					            focusNodeAdjacency : true,//是否在鼠标移到节点上的时候突出显示节点以及节点的边和邻接节点。
																					            symbol:'roundRect',								            
																					            //color:'#6699FF',
																					            symbolSize:[150,110],
																					            edgeSymbol: ['circle', 'arrow'],
																					            edgeSymbolSize: [4, 20],
																					            edgeLabel: {
																					                normal: {
																					                    textStyle: {
																					                        fontSize: 20
																					                    }
																					                }
																					            },
																					            data: [],
																					            // links: [],
																					            links: [],
																					            lineStyle: {
																					                normal: {
																					                    opacity: 0.5,
																					                    width: 2,
																					                    curveness: 0
																					                }
																					            },
																					            label : { //=============图形上的文本标签
																					                normal : {
																					                    show : true,//是否显示标签。
																					                    position : 'inside',//标签的位置。['50%', '50%'] [x,y]
																					                    textStyle : { //标签的字体样式
																					                        color : '#ffffff', //字体颜色
																					                        fontStyle : 'normal',//文字字体的风格 'normal'标准 'italic'斜体 'oblique' 倾斜
																					                        fontWeight : 'bolder',//'normal'标准'bold'粗的'bolder'更粗的'lighter'更细的或100 | 200 | 300 | 400...
																					                        fontFamily : 'sans-serif', //文字的字体系列
																					                        fontSize :10, //字体大小
																					                    }
																					                },
																					                emphasis : {//高亮状态
																					
																					                }
																					            }
																					        }
																					    ]
																					};
																					
																					
																					//获取json文件的图表数据
																					myChart.setOption(option);
																					var path='jsonfile/'+${status.count}+'.json';
																					$.get(path).done(function (data) {

																					    myChart.setOption({
																					        series : [{
																					            data: data.data,
																					            links:data.links
																					        }
																					        ]
																					    })
																					})

																					</script>
																</div>
																<!-- 左下 -->
																<div  style="width: 400px;height: 300px;float:left;">
																	<h3><span style="white-space:normal;word-wrap:break-word;" >关键因子</span></h3>	
																	<c:forEach items="${key }" var="li" varStatus="status1">						
																		<c:if test="${li.key==(status.count-1) }">
																			<c:forEach items="${key[li.key] }" var="str" varStatus="status2">
																			    <h5><span style="display:block;float:left;margin:0 20px 10px 0">${str}</span>
													                           </h5>
																			    
																			</c:forEach>
																		</c:if>																	    
																     </c:forEach>														
																</div>
																
																<div  style="width: 400px;height: 200px;float: left;">
																	<h3><span style="white-space:normal;word-wrap:break-word;" >引用法则</span></h3>	
																	<c:forEach items="${law }" var="li" varStatus="status4">
																			<c:if test="${status4.count==status.count }">
																				<c:forEach items="${law[li.key] }" var="str" varStatus="status1">
																				     
																				        <h5  class="alert alert-info">${str}</h5>
																				     
																				      
																				    
																				</c:forEach>
																			</c:if>	
																			
																			    
																	</c:forEach>														
																</div>
																<!-- 右下 -->
																<div  id="echarts1${status.count}" style="width: 400px;height: 200px;float: left;">
																	<h3><span style="white-space:normal;word-wrap:break-word;" >胜率</span></h3>	
																	<!-- 胜率可视化 -->
																	<script>
																	var myChart1 = echarts.init(document.getElementById('echarts1${status.count}'));
																	   var option1 = {
																		    title : {
																		        x:'center'
																		    },
																		    tooltip : {
																		        trigger: 'item',
																		        formatter: "{a} <br/>{b} : {c} ({d}%)"
																		    },
																		    legend: {
																		        orient: 'vertical',
																		        left: 'left',
																		        data: ['胜诉','败诉']
																		    },
																		    series : [
																		        {
															
																		            type: 'pie',
																		            radius : '55%',
																		            center: ['50%', '60%'],
																		            data:[
																		                {value:80, name:'胜诉概率'},
																		                {value:20, name:'败诉概率'}
																		            ],
																		            itemStyle: {
																		                emphasis: {
																		                    shadowBlur: 10,
																		                    shadowOffsetX: 0,
																		                    shadowColor: 'rgba(0, 0, 0, 0.5)'
																		                }
																		            }
																		        }
																		    ]
																		};
																	   myChart1.setOption(option1);
																	   </script>

																															
																</div>
																
																
														</div>
														
														
														
														<div class="modal-footer">  
															  <center>
														        <button type="button" class="btn btn-primary" data-dismiss="modal">确定</button>  
														        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>  
														      </center>
													      </div>
													</div><!-- /.modal-content -->
												</div><!-- /.modal -->
											
												</div><!-- /.modal -->
												
											</div>				
											<!--  ${solrdoc.getFieldValue("原告诉称") }-->
										</td>
									</tr>
									
								</c:forEach>	
									
									
								</tbody>
							</table>
			</div>
			<!-- 第二个tab -->
			<div class="tab-pane" id="p2">
					<table class="table table-hover table-condensed table-striped">
						<thead>
							<tr>
								<th style="width:5%"><center>排名</center></th>
								<th style="width:25%"><center>案名</center></th>
								<th style="width:10%"><center>法条</center></th>
								<th style="width:40%"><center>关键因子</center></th>
								<th style="width:10%"><center>时间</center></th>
								<th style="width:10%"><center>操作</center></th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>
									1
								</td>
								<td>
									倪××与汪××民间借贷纠纷一审民事判决书
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
				                           
													                                 <c:if test="${status1.count%4==1 }">  
																				        <h5 class="alert alert-info">${str}</h5>
																				     </c:if>
																				      <c:if test="${status1.count%4==2 }">  
																				        <h5 class="alert alert-success">${str}</h5>
																				     </c:if>
																				      <c:if test="${status1.count%4==3 }">  
																				        <h5 class="alert alert-danger">${str}</h5>
																				     </c:if>
																				      <c:if test="${status1.count%4==0 }">  
																				        <h5 class="alert alert-warning">${str}</h5>
																				     </c:if>
																			</c:forEach>
																		</c:if>				    
																</c:forEach>
														</div>
														
													</div><!-- /.modal-content -->
												</div><!-- /.modal -->
											</div>
											
								</td>
								<td>
									被告向原告借款
									被告出具借条
									双方约定借款期限
									被告拖欠借款
									原告起诉要求判令
									被告向原告还款
									支付利息
								</td>
								<td>
									2009-01-04
								</td>
								<td>
								         <center>
											<button class="btn btn-danger" data-toggle="modal" data-target="#myModal2${status.count}">案例明细</button>
											</center>
											
											<!-- 模态框（Modal） -->
											<div class="modal fade" id="myModal2${status.count}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" >
												<div class="modal-dialog" style="width: 1200px;height:800px;" >
													<div class="modal-content">
														<div class="modal-header">
															<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
																&times;
															</button>
															<center><h4 class="modal-title" id="myModalLabel">
																案例详细展示
															</h4>
															</center>
														</div>
														<!-- 左上 -->
														<div class="modal-body" style="width: 1250px;height:1000px;" >
																<div style="width: 400px;height: 400px;float: left;">
																      <h3><span style="white-space:normal;word-wrap:break-word;" class="bg-info">原告诉称</span></h3>															
															    </div>
															    <!-- 右上 -->
																<div  style="width: 800px;height: 800px;float: right;">
																	<h3><span style="white-space:normal;word-wrap:break-word;" class="bg-info">关键因子——法则</span></h3>															
																</div>
																<!-- 左下 -->
																<div  style="width: 400px;height: 150px;float:left;">
																	<h3><span style="white-space:normal;word-wrap:break-word;" class="bg-info">关键</span></h3>															
																</div>
																<!-- 右下 -->
																<div  style="width: 400px;height: 200px;float: left;">
																	<h3><span style="white-space:normal;word-wrap:break-word;" class="bg-info">法条</span></h3>															
																</div>
																
																<div  style="width: 400px;height: 200px;float: left;">
																	<h3><span style="white-space:normal;word-wrap:break-word;" class="bg-info">胜率</span></h3>															
																</div>
														</div>
														
													</div><!-- /.modal-content -->
												</div><!-- /.modal -->
											</div>				
								</td>
							</tr>
							
						</tbody>
					</table>
			
			
			</div><!-- 第二个tab结束 -->
			</div>
		</div>
		<script>
			    var obtn1=document.getElementById("t1");
			    var obtn2=document.getElementById("t2");
			    
			    var div1=document.getElementById("p1");
			    var div2=document.getElementById("p2");
			    
			    var li1=document.getElementById("li1");
			    var li2=document.getElementById("li2");
			    
			    obtn1.onclick = function(){
			    	li1.className="active";
			    	li2.className="";
			    	div1.className="tab-pane active";
			    	div2.className="tab-pane";
			    	
			    };
			    obtn2.onclick = function(){
			    	li2.className="active";
			    	li1.className="";
			    	div2.className="tab-pane active";
			    	div1.className="tab-pane";
			    };
			    
			
			</script>
	</div>
	
	</div><!-- 对应典型案例表格 -->
	<br><br>
	<c:if test="${list!=null }">
	
	<!-- 分割线，以下展示推荐案件的年份分布和地区分布Echarts图 -->
	<div class="row clearfix">
	     <div class="col-md-6 column">
              <div id="year" style="height:500px;">
					
					
					</div>
					<script>
					var myChart = echarts.init(document.getElementById('year'));
					//指定图表的配置项和数据
					
					var option = {
						    title : {
						        text: '推荐案件年份分布',
						        subtext: '                      ——小法博',
						        textStyle:{
						        	color:'#000000',//0066FF淡蓝色
						        	fontFamily:'Arial,宋体,sans-serif',
						        	fontStyle:'oblique',
						        	fontWeight:'bold'
						        }
						    },
						    tooltip : {
						        trigger: 'axis'
						    },
						    legend: {
						        data:['案件数量']
						    },
						    toolbox: {
						        show : true,
						        feature : {
						           
						            dataView : {show: true, readOnly: false},
						            magicType : {show: true, type: ['line', 'bar']},
						            saveAsImage: {//保存图片
					                    show: true
					                },
						        }
						    },
						    calculable : true,
						    xAxis : [
						        {
						            type : 'category',
						            data : ['2007','2008','2009','2010','2011','2012','2013','2014','2015','2016']
						       
						        }
						    ],
						    yAxis : [
						        {
						            type : 'value'
						        }
						    ],
						    series : [
						        {
						            name:'案件数量',
						            type:'bar',
						            data:[13,2,32,34,5,15,73,18,29,20],
						            markPoint : {
						                data : [
						                    {type : 'max', name: '最大值'},
						                    {type : 'min', name: '最小值'}
						                ]
						            },
						       
						        }
						    ]
						};
						                    
					myChart.setOption(option);
					
					</script>
	     </div>
	     <div class="col-md-6 column">
	             <div id="map" style="height:500px;">

				</div>
				<script>
				var myChart = echarts.init(document.getElementById('map'),'shine');
				var option = {
					    title : {
					        text: '推荐案件地区分布',
					        subtext: '                      ——小法博',
					        textStyle:{
					        	color:'#000000',//0066FF淡蓝色
					        	fontFamily:'Arial,宋体,sans-serif',
					        	fontStyle:'oblique',
					        	fontWeight:'bold'
					        }
					    },
					    tooltip : {
					        trigger: 'item'
					    },
					    dataRange: {
					        orient: 'horizontal',
					        min: 0,
					        max: 550,
					        text:['高','低'],           // 文本，默认为数值文本
					        splitNumber:0
					    },
					   
					    series : [
					        {
					            name: '推荐案件地区分布',
					            type: 'map',
					            mapType: 'china',
					            mapLocation: {
					                x: 'left'
					            },
					            selectedMode : 'multiple',
					            itemStyle:{
					                normal:{label:{show:true}},
					                emphasis:{label:{show:true}}
					            },
					            //共31个省市
					            data:[
					                {name:'西藏', value:10},
					                {name:'青海', value:24},
					                {name:'宁夏', value:12},
					                {name:'海南', value:36},
					                {name:'甘肃', value:48},
					                {name:'贵州', value:60},
					                {name:'新疆', value:72},
					                {name:'云南', value:84},
					                {name:'重庆', value:96},
					                {name:'吉林', value:22},
					                {name:'山西', value:11},
					                {name:'天津', value:17},
					                {name:'江西', value:11},
					                {name:'广西', value:213},
					                {name:'陕西', value:123},
					                {name:'黑龙江', value:23},
					                {name:'内蒙古', value:34},
					                {name:'安徽', value:34},
					                {name:'北京', value:5, selected:true},
					                {name:'福建', value:23},
					                {name:'上海', value:23},
					                {name:'湖北', value:34},
					                {name:'湖南', value:23},
					                {name:'四川', value:343},
					                {name:'辽宁', value:324},
					                {name:'河北', value:234},
					                {name:'河南', value:32},
					                {name:'浙江', value:243},
					                {name:'山东', value:34},
					                {name:'江苏', value:53},
					                {name:'广东', value:533, selected:true}
					            ]
					        }
					    ],
					    
					    animation: false
					};
					                    
					                    
				myChart.setOption(option);
				</script>
	            
	     </div><!-- echarts图展示结束 -->
	
	</c:if>
	</div>
	</div><!-- 对应container的div -->
	
	
	
	
	<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
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