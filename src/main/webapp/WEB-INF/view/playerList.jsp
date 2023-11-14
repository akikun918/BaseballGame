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

	<p>https://medianews77.com/landers/crm/jp_m/</p>

	<p>
		<a href="playerList">全選手を見る</a>
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
				<td><a href="playerDetail"><c:out value="${player.name}" /></a>
				</td>
				<%-- 		<p>
			<c:out value="${player.teamId}" />
		</p> --%>
				<td><a href="teamDetail"><c:out value="${player.team.name}" /></a>
				</td>
				<td><c:out value="${player.birthday}" /></td>
				<td><c:out value="${player.position}" /></td>
			</tr>
			<%-- 	<p>
		<c:out value="${player.battingAverage}" />
		</p>
 --%>
		</c:forEach>
		<c:forEach items="${playersByTeam}" var="playersByTeam" varStatus="vs">

			<tr>
				<td><a href="playerDetail"><c:out
							value="${playersByTeam.name}" /></a></td>
				<%-- 		<p>
			<c:out value="${playersByTeam.teamId}" />
		</p> --%>
				<td><a href="teamDetail"><c:out
							value="${playersByTeam.team.name}" /></a></td>
				<td><c:out value="${playersByTeam.birthday}" /></td>
				<td><c:out value="${playersByTeam.position}" /></td>
			</tr>
			<%-- 	<p>
		<c:out value="${playersByTeam.battingAverage}" />
		</p>
 --%>
		</c:forEach>
		<c:forEach items="${playersByPosition}" var="playersByPosition"
			varStatus="vs">

			<tr>
				<td><a href="playerDetail"><c:out
							value="${playersByPosition.name}" /></a></td>
				<%-- 		<p>
			<c:out value="${playersByTeam.teamId}" />
		</p> --%>
				<td><a href="teamDetail"><c:out
							value="${playersByPosition.team.name}" /></a></td>
				<td><c:out value="${playersByPosition.birthday}" /></td>
				<td><c:out value="${playersByPosition.position}" /></td>
			</tr>
			<%-- 	<p>
		<c:out value="${playersByTeam.battingAverage}" />
		</p>
 --%>
		</c:forEach>
	</table>


	<p>
		<a href="menu">メニューに戻る</a>
	</p>

</body>
</html>