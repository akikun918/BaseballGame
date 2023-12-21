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
	<h1>選手のピッチングフォーム・バッティングフォームを改造</h1>
	<p>1000Pかかります</p>
	<p>成功する可能性もありますが、失敗して引退する可能性もあります</p>
	<p>
		現在の保有ポイントは
		<c:out value="${admin.point}" />
		Pです
	</p>
	<p>
		<a href="showPoint">ポイントを購入する</a>
	</p>

	<form action="" method="post">
		<p>改造する選手を選んでください</p>
		<c:if test="${not empty errorPoint}">
			<p>
				<font color="#ff4500"> <c:out value="${errorPoint}" /></font>
			</p>
		</c:if>

		<table border="1">
			<tr>
				<th>名前</th>
				<th>ポジション</th>
				<th>バッティング</th>
				<th>守備</th>
				<th>スタミナ</th>
			</tr>
			<c:forEach items="${players}" var="myPlayer" varStatus="vs">
				<tr>
					<td><input type="radio" name="playerId"
						${vs.count == 1 ? "checked" : "" }
						value="<c:out value="${myPlayer.id}"/>"> <c:out
							value="${myPlayer.name}" /></td>
					<td><c:out value="${myPlayer.position}" /></td>
					<td><c:out value="${myPlayer.battingAverage}" /></td>
					<td><c:out value="${myPlayer.defense}" /></td>
					<c:if test="${not empty myPlayer.stamina}">
						<td><c:out value="${myPlayer.stamina}" /></td>
					</c:if>
					<c:if test="${empty myPlayer.stamina}">
						<td>-</td>
					</c:if>
				</tr>
			</c:forEach>
		</table>
		<input type="submit" />
	</form>
	<p>
		<a href="menu">メニューへ</a>
	</p>
</body>
</html>