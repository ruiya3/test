<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<meta http-equiv="Content-Style-Type" content="text/css"/>
<meta http-equiv="Content-Script-Type" content="text/javascript"/>
<meta http-equiv="imagetoolbar" content="no"/>
<meta name="description" content=""/>
<meta name="keywords" content=""/>
<title>管理者画面</title>

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
td{
	padding:40px;
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
#text-right{
	display:inline-block;
	float:right;
	border:1px solid black;
	margin-right:360px;

}

#text-left{
	display:inline-block;
	float:right;
	border:1px solid black;
	margin-right:100px;
}

#text-link{
	clear: both;
	padding:30px;
}
</style>

</head>
<body>
	<div id="header">
		<div id="pr">
		</div>
	</div>
	<div id="main">
		<div id="top">
			<p>管理者画面</p>
		</div>
		<div id="text-right">
			<h1>商品情報管理</h1>
			<s:form>
				<tr>
					<td><a href='<s:url action="AdminItemAddAction"/>'>商品追加画面</a>
					</td>
				</tr>
				<tr>
					<td><a href='<s:url action="AdminItemListAction"/>'>商品一覧画面</a></td>

				</tr>
			</s:form>
			</div>
			<div id="text-left">
			<h1>ユーザー情報管理</h1>
			<s:form>
				<tr>
					<td><a href='<s:url action="AdminUserAddAction"/>'>ユーザー追加画面</a>
					</td>
				</tr>
				<tr>
					<td><a href='<s:url action="AdminUserListAction"/>'>ユーザー情報一覧画面</a></td>

				</tr>
			</s:form>
			</div>

			<div id="text-link">

				<p>
					ログアウトする場合は<a href='<s:url action="LogoutAction" />'>こちら</a>
				</p>
				</div>
		</div>
	<div id="footer">
		<div id="pr">
		</div>
	</div>
</body>
</html>