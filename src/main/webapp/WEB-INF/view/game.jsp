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
	<%-- 
	<c:if test="${empty scores}">
		<form action="" method="post">
			<p>対戦チームを選ぶ</p>
			<select name="teamId">
				<c:forEach items="${teams}" var="team" varStatus="vs">
					<option value="<c:out value="${team.id}" />"><c:out
							value="${team.name}　優勝回数：${team.victory}　勝利数${team.win}" /></option>
				</c:forEach>
			</select> 
				<p>ピッチャーを選ぶ</p>
			<select name="pitcherId">
				<c:forEach items="${selectPitchers}" var="pitcher" varStatus="vs">
					<option value="<c:out value="${pitcher.id}" />">
						<c:out value="${pitcher.name} 体力：${pitcher.stamina}" /></option>
				</c:forEach>
			</select> 
			<input type="submit" value="試合開始" />
		</form>
	</c:if> --%>

	<table border="1">
		<tr>
			<th>回</th>
			<td>1</td>
			<td>2</td>
			<td>3</td>
			<td>4</td>
			<td>5</td>
			<td>6</td>
			<td>7</td>
			<td>8</td>
			<td>9</td>
			<td>計</td>
		</tr>
		<tr>
			<th>新大久保ジードライヴス</th>
			<c:forEach items="${scores}" var="score" varStatus="vs">
				<td><c:out value="${score}" /></td>
			</c:forEach>
			<c:if test="${not empty total}">
				<td><c:out value="${total}" /></td>
			</c:if>
		</tr>
		<tr>
			<th><c:out value="${comTeam.name}" /></th>
			<c:forEach items="${comScores}" var="comScore" varStatus="vs">
				<td><c:out value="${comScore}" /></td>
			</c:forEach>
			<c:if test="${not empty comTotal}">
				<td><c:out value="${comTotal}" /></td>
			</c:if>
		</tr>
	</table>
	<c:if test="${empty total}">

		<form action="" method="post">
			<p>
				<input type="submit" value="次のイニングへ" />
			</p>
		</form>

	</c:if>
	<c:if test="${empty total}">
		<form action="" method="post">
			<p>
				<c:out value="ピッチャー：${pitcher.name}" />
				<c:out value="${leftStamina}" />

				<c:if test="${admin.drink > 0}">
					<input type="hidden" name="drink" value="1" />
					<input type="submit"
						value="エナジードリンクを使う　<c:out value="${admin.drink} 個保有" />" />
				</c:if>
			</p>
		</form>

		<form action="gameChangePitcher">
			<p>
				<input type="submit" value="ピッチャー交代" />
			</p>
		</form>

	</c:if>

	<c:if test="${not empty result}">
		<p>
			<c:out value="${result}" />
		</p>
		<p>
			<a href="preGame">もう一度試合をする</a>
		</p>
		<p>
			<a href="menu">メニューへ</a>
		</p>
	</c:if>


</body>
</html>