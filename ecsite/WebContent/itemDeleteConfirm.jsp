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
			<p>BuyItem</p>
		</div>
		<div>

			<p>商品を削除します。よろしいですか？</p>
			<div id="box1">
			<s:url id="url" action="ItemDeleteCompleteAction">
	    						<s:param name="delete_request_id"><s:property value="delete_id"/></s:param>
	  							</s:url>
	    						<s:a href="%{url}">OK</s:a>
			<s:url id="url2" action="ItemDetailsAction">
	    						<s:param name="item_request_id"><s:property value="delete_id"/></s:param>
	  							</s:url>
	    						<s:a href="%{url2}">キャンセル</s:a>

			</div>
		</div>
		<div id ="footer"></div>
	</div>
</body>
</html>