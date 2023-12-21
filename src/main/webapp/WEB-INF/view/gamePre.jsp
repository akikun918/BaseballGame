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
	<h1>試合をする</h1>
	<form action="" method="post">
		<p>対戦チームを選ぶ</p>
		<select name="teamId">
			<c:forEach items="${teams}" var="team" varStatus="vs">
				<option value="<c:out value="${team.id}" />">
					<c:out value="${team.name}　優勝回数：${team.victory}　勝利数${team.win}" />
				</option>
			</c:forEach>
		</select>
		<p>先発ピッチャーを選ぶ</p>
		<select name="pitcherId">
			<c:forEach items="${pitchers}" var="pitcher" varStatus="vs">
				<option value="<c:out value="${pitcher.id}" />">
					<c:out
						value="${pitcher.name}  ピッチング：${pitcher.defense}　体力：${pitcher.stamina}" />
				</option>
			</c:forEach>
		</select>
		<p>先発選手を8人選んでください</p>

		<p>
			<a href="doping">ドーピングを使う</a>
			<c:out value="${admin.dope}" />
			個保有
		</p>

		<c:if test="${not empty error}">
			<p>
				<font color="#ff4500"> <c:out value="${error}" /></font>
			</p>
		</c:if>
		<c:if test="${not empty positionError}">
			<p>
				<font color="#ff4500"> <c:out value="${positionError}" /></font>
			</p>
		</c:if>

		<table border="1">
			<tr>
				<th>選手</th>
				<th>ポジション</th>
				<th>打撃力</th>
				<th>守備力</th>
				<th>今日の調子</th>
			</tr>
			<c:forEach items="${myPlayers}" var="player" varStatus="vs">
				<tr>
					<td><input type="checkbox" name="fieldPlayerId"
						value="<c:out value="${player.id}" />" /> <c:out
							value="${player.name}" /></td>
					<td><c:out value="${player.position}" /></td>
					<td><c:out value="${player.battingAverage}" /></td>
					<td><c:out value="${player.defense}" /></td>
					<td><c:out value="${player.feel}" /></td>
				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="試合開始" />
	</form>














	<p>
		<a href="menu">メニューに戻る</a>
	</p>
</body>
</html>