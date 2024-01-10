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
	<header>
		<h1>
			<img src="https://picsum.photos/400/300"
				alt="<c:out value="${player.name}" />"> <img
				src="upload/cha.jpg" width="412"
				alt="<c:out value="${player.name}" />">
		</h1>
	</header>
	<main>
		<table border="1">
			<tr>
				<th>選手</th>
				<th>チーム</th>
				<th>誕生日</th>
				<th>ポジション</th>
				<th>バッティング</th>
				<th>守備</th>
				<th>スタミナ</th>
				<th>移籍金</th>
			</tr>
			<tr>
				<td><c:out value="${player.name}" /></td>
				<td><a href="teamDetail?id=<c:out value="${player.team.id}" />"><c:out
							value="${player.team.name}" /></a></td>
				<td><fmt:formatDate value="${player.birthday}"
						pattern="y 年M 月d 日" /></td>
				<td><c:out value="${player.position}" /></td>
				<td><c:out value="${player.battingAverage}" /></td>
				<td><c:out value="${player.defense}" /></td>
				<c:if test="${not empty player.stamina}">
					<td><c:out value="${player.stamina}" /></td>
				</c:if>
				<c:if test="${empty player.stamina}">
					<td>-</td>
				</c:if>
				<td><c:out value="${player.salary}" /></td>
			</tr>
		</table>
	</main>
	<nav>
		<ul>
			<li><a href="playerList">選手一覧に戻る</a></li>
			<li><a href="menu">メニューに戻る</a></li>
		</ul>
	</nav>
</body>
</html>