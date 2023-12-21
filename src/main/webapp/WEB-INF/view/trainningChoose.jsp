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
	<h1>トレーニングをする</h1>
	<c:if test="${not empty errorTrainning}">
		<font color="#ff4500"> <c:out value="${errorTrainning}" /></font>
	</c:if>
	<c:if test="${not empty error}">
		<font color="#ff4500"> <c:out value="${error}" /></font>
	</c:if>
	<c:if test="${empty errorTrainning}">
		<c:if test="${not empty condition}">
			<c:if test="${empty error}">
				<c:out value="${condition}" />
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
					<a href="trainning">この選手で決定</a>
				</p>

				<p>選手とトレーニングを変更する</p>
			</c:if>
		</c:if>
	</c:if>


	<c:if test="${empty errorTrainning}">
		<c:if test="${empty condition}">
			<p>選手とトレーニングを選んでください</p>
		</c:if>
		<form action="" method="post">
			<input type="radio" name="trainningKind" value="1" checked />バッティング練習
			<input type="radio" name="trainningKind" value="2" />守備練習
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
	</c:if>



	<p>
		<a href="menu">メニューへ戻る</a>
	</p>
</body>
</html>