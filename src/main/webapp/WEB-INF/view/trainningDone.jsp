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
	<h1>トレーニング終了</h1>
	<p>
		<c:out value="${result}" />
	</p>
	<table border="1">
		<tr>
			<th>名前</th>
			<th>ポジション</th>
			<th>バッティング</th>
			<th>守備</th>
			<th>スタミナ</th>
		</tr>

		<tr>
			<td><c:out value="${trainningPlayer.name}" /></td>
			<td><c:out value="${trainningPlayer.position}" /></td>
			<td><c:out value="${trainningPlayer.battingAverage}" /></td>
			<td><c:out value="${trainningPlayer.defense}" /></td>
			<c:if test="${not empty trainningPlayer.stamina}">
				<td><c:out value="${trainningPlayer.stamina}" /></td>
			</c:if>
			<c:if test="${empty trainningPlayer.stamina}">
				<td>-</td>
			</c:if>
		</tr>
	</table>

	<p>
		<a href="menu">メニューへ</a>
	</p>

</body>
</html>