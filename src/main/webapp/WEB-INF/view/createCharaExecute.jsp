<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>プレイヤー作成</h1>
	<p>各パラメーターはランダムに決まります</p>

	<p>下記内容でよろしいでしょうか？</p>
	<table border="1">
		<tr>
			<th>名前</th>
			<th>誕生日</th>
			<th>ポジション</th>
		</tr>
		<tr>
			<td><c:out value="${name}" /></td>
			<td><fmt:formatDate value="${date}" pattern="y 年M 月d 日" /></td>
			<td><c:out value="${position}" /></td>
		</tr>
	</table>
	<form action="" method="post">
		<input type="submit" value="決定" />
	</form>
	<p>
		<a href="createChara">内容を変更する</a>
	</p>
	<p>
		<a href="menu">メニューへ</a>
	</p>
</body>
</html>