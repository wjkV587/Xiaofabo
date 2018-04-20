<%@ page language="java" 
    pageEncoding="utf-8"
    isELIgnored="false"   %>
<%@taglib prefix="s" uri="/struts-tags" %><!-- 引入struts2标签库 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>基于SolrJ服务的简单查询</title>
<!-- 引入 Bootstrap -->
      <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
      <link rel="shortcut icon" href="images/favicon.ico">
    <style>
#test{
animation:change 10s linear 0s infinite;
font-size:30px;
font-weight:700;}
@keyframes change{0%{color:red;}25%{color:#00ff00;}50%{color:blue;}75%{color:yellow;}100% {color:#f00;}
}

#one{
   color:black;
}

</style>
</head>
<body>

<div class="container">
	
	<!-- 页头提示语句 -->
	<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<div class="page-header">
				<h2 id="test">
					基于SolrJ服务的简单查询         <sub id="one">Simple query based on SolrJ service</sub>
				</h2>
			</div>
		</div>
	</div>
</div>
	
	<!-- 查询表单的设计 -->
	<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<form class="form-horizontal" role="form" action="/SolrJWeb/solr_find.action" method="post">
				<div class="form-group">
					 <label for="inputEmail3" class="col-sm-3 control-label">模糊查询(q)</label>
					<div class="col-sm-4">
						<input type="text" class="form-control" name="fq" value="${requestScope.q}"/>
					</div>
				</div>
				<!--  
				<div class="form-group">
					 <label for="inputPassword3" class="col-sm-3 control-label">过滤显示(fl)</label>
					<div class="col-sm-4">
						<input type="text" class="form-control" name="fl" />
					</div>
					<label for="inputPassword3" class="col-sm-3 control-label">(以空格符号隔开)</label>
				</div>
				-->
				<div class="form-group">
					<div class="col-sm-offset-3 col-sm-9">
						 <button type="submit" class="btn btn-primary">查询</button>
						 <a href="export_exportExcel.action?fq=${requestScope.q }" class="btn btn-success">导出Excel</a>
					     <a href="echarts_echartsshow.action" target="_blank" class="btn btn-info">Echarts Demo</a>
					     <a href="solrgroup_find.action?fq=${requestScope.q }" class="btn btn-link">分组查询</a>
					</div>

				</div>
				
				<c:if test="${requestScope.fenzu }">
					    <!-- 如果点击了分组查询按钮，就显示下列可供用户选择的分组条件 -->
					    <div class="form-group">
					        <label class="col-sm-3 control-label">时间分组(年)</label>
					        <div class="col-sm-offset-3 col-sm-9">
					             <a>2007</a>&nbsp
					             <a>2008</a>&nbsp
					             <a>2009</a>&nbsp
					             <a>2010</a>&nbsp
					             <a>2011</a>&nbsp
					             <a>2012</a>&nbsp
					             <a>2013</a>&nbsp
					             <a>2014</a>&nbsp
					             <a>2015</a>&nbsp
					             <a>2016</a>&nbsp
					        </div>
					    </div>
					</c:if>
			</form>
			
		</div>
		
	</div>
</div>
<!-- 不属表单范围的div，以下为表格内容，可用jsp标签控制是否显示 -->

<table class="table table-hover">
    <c:choose>
    <c:when test="${empty requestScope.num}">
       	<caption>搜索结果(共0条)</caption>
	</c:when>
	
	<c:otherwise>
     	<caption>搜索结果(共${requestScope.num}条)</caption>
	</c:otherwise>
	</c:choose>
	<thead>
		<tr>
			<th>id</th>
			<th>原告</th>
			<th>被告</th>
			<th>原告诉称</th>
			<th>法院判决</th>
			<th>裁判日期</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${requestScope.list}" var="solrdoc" varStatus="status">
		<tr>
			<td>${solrdoc.getFieldValue("id") }</td>
			<td>${solrdoc.getFieldValue("原告") }</td>
			<td>${solrdoc.getFieldValue("被告") }</td>
			<td>${solrdoc.getFieldValue("原告诉称")}</td>
			<td>${solrdoc.getFieldValue("法院判决") }</td>
			<td>${solrdoc.getFieldValue("裁判日期") }</td>
		</tr>
	</c:forEach>	
	</tbody>
</table>
<c:choose>
<c:when test="${ empty requestScope.num}">

</c:when>
<c:otherwise>
<center>
            <ul class="pagination">
				<li>
					 <a href="solr_find.action?fq=${requestScope.q }&&pagenow=0">首页</a>
				</li>			
				
				<!-- 此处选择性显示上一页 -->
				<c:choose>
				<c:when test="${pagenow==0}"></c:when>
				<c:otherwise>
				    <li>
					 <a href="solr_find.action?fq=${requestScope.q }&&pagenow=${pagenow-1}">上一页</a>
				    </li>
				</c:otherwise>
				</c:choose>
				
			    <!-- 此处选择性显示下一页 , pages为最后一页-->
			    <c:choose>
				<c:when test="${pagenow>=pages}">
				</c:when>
				<c:otherwise>
				     <li>
					 <a href="solr_find.action?fq=${requestScope.q }&&pagenow=${pagenow+1}">下一页</a>
				     </li>
				
				</c:otherwise>
				</c:choose>
				
				<li>
					 <a href="solr_find.action?fq=${requestScope.q }&&pagenow=${pages}">尾页</a>
				</li>
			</ul>

</center>
</c:otherwise>
</c:choose>
</div>
</body>
</html>