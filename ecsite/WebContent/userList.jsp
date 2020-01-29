<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
<meta http-equiv="Content-Style-Type" content="text/css"/>
<meta http-equiv="Content-Script-Type" content="text/jacascript">
<meta http-equiv="imagetoolvar" content="no">
<meta name="description" content="">
<meta name="keywords" content="">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<style type="text/css">
/*TAGLAYOUT*/
body{
	margin:0; padding: 0;
	line-height: 1.6; letter-spacing: 1px;
	font-family: Verdana,Helvetica,sans-serif;font-size:12px;
	color: #333;
	background: #fff;
}
table{
	text-align: center;
	margin: 0 auto;
}
/*IDLayout*/
#top{
	 width: 780px; margin: 30px auto;
	 border:1px solid #333;
 }

 #header{
	 width: 100%; height:80px;
	 background-color: black;
 }

 #main{
 	width: 100%; height: 500px; text-align: center;
 }

 #footer{
	 width: 100%; height: 80px;
	 background-color: black;
	 clear: both;
 }

 #text-right{
 	 display: inline-block;
 	 text-align: right;
 	}


</style>
<title>UserList画面</title>
</head>
<body>
	<div id="header">
		<div id="pr">
		</div>
	</div>
	<div id="main">
		<div id="top">
			<p>ItemList</p>
		</div>
		<div>
			<s:if test ="Userlistsize==0">
				<h3>商品情報はありません</h3>
			</s:if>
			<s:elseif test="message==null">
				<h3>ユーザー情報は以下になります。</h3>
				<table border="1">
					<tr>
						<th>ID</th>
						<th>ログインID</th>
						<th>ログインパスワード</th>
						<th>ユーザー名</th>
						<th>登録日</th>
						<th>管理者権限</th>
					</tr>
					<s:iterator value="userList">
						<tr>
							<td><s:property value="id"/></td>
							<td><s:property value="login_id"/></td>
							<td><s:property value="login_pass"/></td>
							<td><s:property value="user_name"/></td>
							<td><s:property value="insert_date"/></td>
							<td><s:property value="admin_flg"/></td>
						</tr>
					</s:iterator>
				</table>
				<s:form action="UserListDeleteConfirmAction">
					<s:submit value="削除"/>
				</s:form>
			</s:elseif>
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