<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>实现分页效果</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="css/pagination.css">
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="js/jquery.pagination.js"></script>
</head>

<body>
	<form action="<%=path%>/NewsServlet" method="get" name="form1">
		<div>
			<input type="submit" name="btnSubmit" value="查询" />
		</div>
		<c:if test="${fn:length(result.dataList) eq 0 }">
			<span>没有新闻信息</span>
		</c:if>
		<c:if test="${fn:length(result.dataList) gt 0}">
			<table border="1" cellspacing="0px" style="border-collapse:collapse">
				<tr>
					<td>新闻标题</td>
					<td>新闻内容</td>
					<td>新闻时间</td>
				</tr>
				<c:forEach var="news" items="${result.dataList}">
					<td>${news.title }</td>
					<td>${news.content }</td>
					<td>${news.createTime }</td>
				</c:forEach>
			</table>
		</c:if>
	</form>

</body>
</html>
