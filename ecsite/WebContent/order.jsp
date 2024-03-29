<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>


<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
 	<meta http-equiv="content-Style-type" content="text/css"/>
 	<meta http-equiv="content-script-type" content="text/javascript"/>
 	<meta http-equiv="imagetoolbar" content="no"/>
 	<meta name="description" content=""/>
 	<meta name="keywords" content=""/>

	<style type="text/css">
	body {
  	margin: 0;
	padding: 0;
	line-height: 1.6;
	letter-spacing: 1px;
	font-family: Verdana, Helvetica, sans-serif;
	font-size: 12px;
	color: #333;
	background: #fff;
	}
	table {
	text-align: center;
	margin: 0 auto;
	}

	#top {
	width: 780px;
	margin: 30px auto;
	border: solid #333;
	}
	#header {
	width: 100%;
	height: 80px;
	background-color: black;
	}
	#main {
	width: 100%;
	height: 500px;
	text-align: center;
	}
	#footer {
	width: 100%;
	height: 80px;
	background-color: black;
	clear: both;
	}
	#text-center {
	display: inline-block;
	text-align: center;
	}
	#text-link {
	display: inline-block;
	text-align: right;
	}
		#text-right {
			display: inline-block;
			text-align: right;
		}
	</style>

	<script type="text/javascript">
		function submitAction(url){
			$('form').attr('action',url);
			$('form').submit();
		}

	</script>
	<title>ItemList画面</title>
</head>

<body>

<div id="header">
	<div id="pr"></div>
</div>

<div id="main">
	<div id="top">
		<p>ItemList</p>
  	</div>

	<div>
	<s:form action="OrderingCompleteAction">
		<h3>商品情報は以下になります。</h3>
		<table border="1">
			<tr>
				<th>商品ID</th>
				<th>商品名</th>
				<th>値段</th>
				<th>在庫</th>
				<th>挿入日</th>
				<th>受注</th>
			</tr>
			<s:iterator value="session.itemList" status="st">
			<tr>
				<td><s:property value="Id"/></td>
				<td><s:property value="item_name"/></td>
				<td><s:property value="item_price"/><span>円</span></td>
				<td><s:property value="item_stock"/><span>個</span></td>
				<td><s:property value="insert_date"/></td>
				<td><s:property value="orderCount"/></td>
			</tr>
			</s:iterator>
			</table>
			<s:submit value="受注"/>
		</s:form>
  	</div>

  	<div id="text-right">
  		<p>
  			管理者画面に戻る場合には
  			<a href='<s:url action="AdminAction"/>'>こちら</a>
  		</p>
  	</div>
</div>

<div id="footer">
  	<div id="pr"></div>
</div>
</body>

</html>