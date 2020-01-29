<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<title>UserCreate画面</title>
</head>
<body>

		<div id="header"></div>
		<div id="main">
			<div id="top">
				<p>UserCreate</p>
			</div>
			<div>
				<s:if test="errorMessage !=''"><!-- エラーメッセージがnullなら -->
					<s:property value="errorMessage" escape="false"/>
				</s:if>
				<table>
					<s:form action="ItemCreateConfirmAction">
						<tr>
							<td>
								<label>商品名:</label>
							</td>
							<td>
								<input type="text" name="itemName" value=""/>
							</td>
						</tr>
						<tr>
							<td>
								<label>価格:</label>
							</td>
							<td>
								<input type="text" name="itemPrice" value=""/>
							</td>
						</tr>
						<tr>
							<td>
								<label>個数:</label>
							</td>
							<td>
								<input type="text" name="itemStock" value=""/>
							</td>
						</tr>
						<s:submit value="登録"/>
					</s:form>
				</table>
				<div>
					<span>管理画面topに戻る場合は</span>
					<a href='<s:url action="AdminAction"/>'>こちら</a>
				</div>
			</div>

		</div>
		<div id="footer">
		</div>



</body>
</html>