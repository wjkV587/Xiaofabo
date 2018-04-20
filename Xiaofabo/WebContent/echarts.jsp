<%@ page language="java" 
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Echarts 测试页面</title>
<script src="echarts/echarts.js" type="text/javascript"></script>
<!-- 引入 Bootstrap -->
      <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
      <link rel="shortcut icon" href="images/favicon.ico">
</head>
<body>
<center><h2>法律案件每年发生量展示</h2></center>
          <div class="col-sm-12 col-md-6 col-lg-6">
           <!-- 做表图渲染的DOM容器 -->
          <div id="main" style="width: 600px;height: 500px;"></div>
         <script>
         //echarts.init(dom容器)。dom容器必须是html的节点
           var myChart = echarts.init(document.getElementById("main"));
           var option = {
                title:{
                    text:"条形图展示"
                },
                backgroundColor:"#EEEFF4",
                itemStyle:{
                    emphasis:{
                        shadowBlur:200,
                        shadowColor:"rgba(0,0,0,0.8)"
                    }
                },
                tooltip:{
                    text:"this is tool tip"
                },
                legend:{
                    data:['案件量']
                },
                xAxis:{
                    data:["2007","2008","2009","2010","2011","2012","2013","2014","2015","2016"]
                },
                yAxis:{},
                series:[{
                            name:["案件量"],
                            type:"bar",
                            data:["${requestScope.number[0]}","${requestScope.number[1]}",
                            	"${requestScope.number[2]}","${requestScope.number[3]}",
                            	"${requestScope.number[4]}","${requestScope.number[5]}",
                            	"${requestScope.number[6]}","${requestScope.number[7]}",
                            	"${requestScope.number[8]}","${requestScope.number[9]}"]
                        }]
            };

            myChart.setOption(option);       
            </script>
            </div>
            
            <!-- 饼状图表示 -->
            <div class="col-sm-12 col-md-6 col-lg-6">
                <div id="second" style="width:600px;height:500px;"></div>
                <script type="text/javascript">
                   var second=echarts.init(document.getElementById("second"));
                   var second_option={
                		   title:{text:"饼状图表示"},
                		   backgroundColor:"#EEEFF4",
                           itemStyle:{
                               emphasis:{
                                   shadowBlur:200,
                                   shadowColor:"rgba(0,0,0,0.8)"
                               }
                           },
                		   series:[
                			   {
                				   name:["案件量"],
                				   type:'pie',
                				   radius:'55%',
                				   data:[
                					   {value:"${requestScope.number[0]}",name:'2007('+${requestScope.bi[0]}+'%)'},
                					   {value:"${requestScope.number[1]}",name:'2008('+${requestScope.bi[1]}+'%)'},
                					   {value:"${requestScope.number[2]}",name:'2009('+${requestScope.bi[2]}+'%)'},
                					   {value:"${requestScope.number[3]}",name:'2010('+${requestScope.bi[3]}+'%)'},
                					   {value:"${requestScope.number[4]}",name:'2011('+${requestScope.bi[4]}+'%)'},
                					   {value:"${requestScope.number[5]}",name:'2012('+${requestScope.bi[5]}+'%)'},
                					   {value:"${requestScope.number[6]}",name:'2013('+${requestScope.bi[6]}+'%)'},
                					   {value:"${requestScope.number[7]}",name:'2014('+${requestScope.bi[7]}+'%)'},
                					   {value:"${requestScope.number[8]}",name:'2015('+${requestScope.bi[8]}+'%)'},
                					   {value:"${requestScope.number[9]}",name:'2016('+${requestScope.bi[9]}+'%)'}
                				   ]
                			   }
                		   ]
                   };
                   second.setOption(second_option);
                </script>
            </div>
</body>
</html>