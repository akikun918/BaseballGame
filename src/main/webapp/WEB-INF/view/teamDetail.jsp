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
			<img src="upload/dog.jpg" width="412"
				alt="<c:out value="${player.team.name}" />"> <img
				src="https://picsum.photos/400/300"
				alt="<c:out value="${player.team.name}" />">
		</h1>
	</header>
	<main>
		<table border="1">
			<tr>
				<th>チーム名</th>
				<th>本拠地</th>
				<th>設立日</th>
				<th>優勝回数</th>
				<th>勝利数</th>
			</tr>
			<tr>
				<td><c:out value="${player.team.name}" /></td>
				<td><c:out value="${player.team.place}" /></td>
				<td><fmt:formatDate value="${player.team.established}"
						pattern="y 年M 月d 日" /></td>
				<td><c:out value="${player.team.victory}" /></td>
				<td><c:out value="${player.team.win}" /></td>
			</tr>
		</table>
		<p>所属選手</p>
		<table border="1">
			<tr>
				<th>選手</th>
				<th>ポジション</th>
				<th>バッティング</th>
				<th>守備</th>
				<th>スタミナ</th>
				<th>移籍金</th>
			</tr>
			<c:forEach items="${players}" var="player" varStatus="vs">
				<tr>

					<td><a href="playerDetail?id=<c:out value="${player.id}" />"><c:out
								value="${player.name}" /></a></td>
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
			</c:forEach>

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