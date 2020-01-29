<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>ItemDeleteConfirm画面</title>
</head>
<body>
	<div id="header"></div>
	<div id="main">
		<div id="top">
			<p>UserListDeleteConfirm</p>
		</div>
		<div>

			<p>すべてのユーザーを削除します。よろしいですか？</p>
			<div id="box1">
			<s:form action="UserListDeleteCompleteAction">

				<s:submit value="OK"/>
			</s:form>
			</div>
			<div id="box2">
			<s:form action="UserListAction">
				<s:submit value="キャンセル"/>
			</s:form>
			</div>
		</div>
		<div id ="footer"></div>
	</div>
</body>
</html>