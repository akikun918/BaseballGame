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
	<p>チーム別で見る</p>
	<form action="" method="post">
		<select name="teamId">
			<option value="1">読切巨人</option>
			<option value="2">半神ジャガーズ</option>
			<option value="3">カルピススワローズ</option>
			<option value="4">北海道日本スパムズ</option>
			<option value="5">新大久保ジードライブズ</option>
		</select> <input type="submit" />
	</form>
	<p>ポジション別で見る</p>
	<form action="" method="post">
		<select name="position">
			<option value="P">ピッチャー</option>
			<option value="C">キャッチャー</option>
			<option value="1B">ファースト</option>
			<option value="2B">セカンド</option>
			<option value="3B">サード</option>
			<option value="SS">ショート</option>
			<option value="LF">レフト</option>
			<option value="CF">センター</option>
			<option value="RF">ライト</option>
		</select> <input type="submit" />
	</form>


	<p>名前で検索する</p>
	<form action="" method="post">
		<input type="text" name="name" /> <input type="submit" value="検索" />
	</form>

	<c:if
		test="${not empty playersByTeam || not empty playersByPosition || not empty findPlayersByName}">
		<p>
			<a href="playerList">全選手を見る</a>
		</p>
	</c:if>
	<p>
		<a href="menu">メニューに戻る</a>
	</p>

	<table border="1">
		<tr>
			<th>選手</th>
			<th>チーム</th>
			<th>誕生日</th>
			<th>ポジション</th>
		</tr>
		<c:forEach items="${players}" var="player" varStatus="vs">
			<tr>
				<td><a href="playerDetail?id=<c:out value="${player.id}" />"><c:out
							value="${player.name}" /></a></td>
				<td><a href="teamDetail?id=<c:out value="${player.team.id}" />"><c:out
							value="${player.team.name}" /></a></td>
				<td><fmt:formatDate value="${player.birthday}"
						pattern="y/MM/dd " /></td>
				<td><c:out value="${player.position}" /></td>
			</tr>
		</c:forEach>
		<c:forEach items="${playersByTeam}" var="playersByTeam" varStatus="vs">
			<tr>
				<td><a
					href="playerDetail?id=<c:out value="${playersByTeam.id}" />"><c:out
							value="${playersByTeam.name}" /></a></td>
				<td><a
					href="teamDetail?id=<c:out value="${playersByTeam.team.id}" />"><c:out
							value="${playersByTeam.team.name}" /></a></td>
				<%-- <p><fmt:formatDate value="${now}" pattern="y/MM/dd (E)" /></p>
 --%>
				<td><fmt:formatDate value="${playersByTeam.birthday}"
						pattern="y/MM/dd " /></td>
				<%-- <p><fmt:formatDate value="${now}" pattern="y 年M 月d 日 HH 時mm 分" /></p>
 --%>
				<td><c:out value="${playersByTeam.position}" /></td>
			</tr>
		</c:forEach>
		<c:forEach items="${playersByPosition}" var="playersByPosition"
			varStatus="vs">
			<tr>
				<td><a
					href="playerDetail?id=<c:out value="${playersByPosition.id}" />"><c:out
							value="${playersByPosition.name}" /></a></td>
				<td><a
					href="teamDetail?id=<c:out value="${playersByPosition.team.id}" />"><c:out
							value="${playersByPosition.team.name}" /></a></td>
				<td><fmt:formatDate value="${playersByPosition.birthday}"
						pattern="y/MM/dd " /></td>
				<%-- <td><c:out value="${playersByPosition.birthday}" /></td> --%>
				<td><c:out value="${playersByPosition.position}" /></td>
			</tr>
			<%-- 	<p>
		<c:out value="${playersByTeam.battingAverage}" />
		</p>
 --%>
		</c:forEach>

		<c:forEach items="${findPlayersByName}" var="player" varStatus="vs">
			<tr>
				<td><a href="playerDetail?id=<c:out value="${player.id}" />"><c:out
							value="${player.name}" /></a></td>
				<td><a href="teamDetail?id=<c:out value="${player.team.id}" />"><c:out
							value="${player.team.name}" /></a></td>
				<td><fmt:formatDate value="${player.birthday}"
						pattern="y/MM/dd " /></td>
				<%-- <td><c:out value="${player.birthday}" /></td> --%>
				<td><c:out value="${player.position}" /></td>
			</tr>
		</c:forEach>


	</table>

</body>
</html>