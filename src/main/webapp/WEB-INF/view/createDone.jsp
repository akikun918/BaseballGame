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
	<h1>新しい選手を作成しました</h1>
	<p>こんなん出ましたけど</p>

	<table border="1">
		<tr>
			<th>名前</th>
			<th>誕生日</th>
			<th>ポジション</th>
			<th>バッティング</th>
			<th>守備</th>
			<th>スタミナ</th>
		</tr>
		<tr>
			<td><c:out value="${createdPlayer.name}" /></td>
			<td><fmt:formatDate value="${createdPlayer.birthday}"
					pattern="y 年M 月d 日" /></td>
			<td><c:out value="${createdPlayer.position}" /></td>
			<td><c:out value="${createdPlayer.battingAverage}" /></td>
			<td><c:out value="${createdPlayer.defense}" /></td>
			<td><c:out value="${createdPlayer.stamina}" /></td>
		</tr>
	</table>

	<p>
		残り
		<c:out value="${admin.point}" />
		P
	</p>

	<p>
		<a href="menu">メニューへ</a>
	</p>
</body>
</html>