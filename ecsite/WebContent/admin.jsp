<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<title>Home画面</title>
<script type="text/javascript">
	function submitAction(url){
		$('form').attr('action',url);//formタグのaction属性に引数urlの値を設定する
		$('form').submit();//submitイベントを実行する
	}
</script>
</head>
<body>
	<div id="header">
	</div>
	<div id="main">
		<div id="top">
			<p>Admin画面</p>
		</div>
		<div id="text-center">
			<div id="box1">
			<!-- 横に並べる！ -->
			<s:form>
			<p>商品</p>
				<input type="button" value="商品登録" onclick="submitAction('ItemCreateAction')"/>
			</s:form>
			<s:form>
				<input type="button" value="一覧" onclick="submitAction('ItemListAction')"/>
			</s:form>
			</div>
			<div id="box2">
			<s:form>
			<p>ユーザー</p>
				<input type="button" value="新規登録" onclick="submitAction('UserCreateAction')"/>
			</s:form>
			<s:form>
				<input type="button" value="一覧" onclick="submitAction('UserListAction')"/>
			</s:form>
			</div>
			<p>Homeへ戻る場合は<a href='<s:url action="GoHomeAction"/>'>こちら</a><p>
		</div>
	</div>

	<div id="footer"></div>
</body>
</html>