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
	<h1>ドー〇ング接種</h1>

	<form action="" method="post">

		<p>ドーピングする選手を選んでください</p>
		<p>
			<font color="#ff4500"> ※打撃力、守備力が一時的に5上がりますが、試合後2下がります</font>
		</p>
		<p>各パラメーターが2以上の選手を選んでください</p>
		<p>
			<c:out value="ドーピングの保有数:${admin.dope}" />
		</p>

		<p>
			<a href="cartIndex">アイテムを購入する</a>
		</p>



		<c:if test="${not empty error}">
			<p>
				<font color="#ff4500"> <c:out value="${error}" /></font>
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
		<input type="submit" value="打つ" />
	</form>

	<p>
		<a href="preGame">やっぱり正々堂々戦う</a>
	</p>

	<p>
		<a href="menu">メニューに戻る</a>
	</p>


</body>
</html>