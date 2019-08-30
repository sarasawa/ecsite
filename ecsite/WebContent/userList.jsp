<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css"/>
<meta http-equiv="Content-script-Type" content="text/javascript"/>
<meta http-equiv="imagetoolbar" content="no"/>
<meta name="description" content=""/>
<meta name="keywords" content=""/>
<title>UserList画面</title>
<style type="text/css">

body{
margin:0;
padding:0;
line-height:1.6;
letter-spacing:1px;
font-family:Verdana,Helvetica,sans-serif;
font-size:12px;
color:#333;
background:#fff;
}
table{
text-align:center;
margin:0 auto;
}
#top{
width:780px;
margin:30px auto;
border:1px solid #333;
}
#header{
width:100%;
height:80px;
background-color:black;
}
#main{
width:100%;
height:500px;
text-align:center;
}
#footer{
width:100%;
height:80px;
background-color:black;
clear:both;
}
#text-center{
display: inline-black;
text-align: center;
}
</style>
</head>
<body>

	<div id = "header">
		<div id = "pr">
		</div>
	</div>
	<div id = "main">
		<div id = "top">
			<p>UserList</p>
		</div>
		<div>
			<h3>ユーザー一覧</h3>
			<table border = "1">
			<tr>
				<th>id</th>
				<th>ユーザー名</th>
				<th>ログインID</th>
				<th>ログインPASS</th>
				<th>登録日</th>
				<th>詳細</th>
			</tr>
			<s:iterator value = "userList">
				<tr>
					<td><s:property value = "id"/></td>
					<td><s:property value = "user_name"/></td>
					<td><s:property value = "login_id"/></td>
					<td><s:property value = "login_pass"/></td>
					<td><s:property value = "insert_date"/></td>
					<td><a href='<s:url action="UserDetailsAction">
									<s:param name="login_id" value="%{login_id}"/>
									</s:url>'>詳細</a>
					</td>
			</s:iterator>
			</table> 
			<div>
				<s:form action = "UserListDeleteConfirmAction">
					<s:submit value = "削除"/>
				</s:form>
			</div>
				<div id="text-right">
					<p>管理者TOP画面へ戻る場合は<a href='<s:url action="AdminAction" />'>こちら</a></p>
				</div>
		</div>
	</div>
</body>
</html>