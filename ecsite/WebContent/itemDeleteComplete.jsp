<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">

<title>ItemDeleteComplete画面</title>
</head>
<body>
	<div id="header">
		<div id="pr">
		</div>
	</div>
	<div id="main">
		<div id="top">
		</div>
		<div>
			<s:if test="message !=null">

				<h3><s:property value="message"/></h3>
			</s:if>
				<div id="text-right">
					<p>管理画面へ戻る場合は<a href='<s:url action="AdminAction"/>'>こちら</a><p>
				</div>
		</div>
	</div>
	<div id="footer">
	<div id="pr"></div>
	</div>
</body>
</html>