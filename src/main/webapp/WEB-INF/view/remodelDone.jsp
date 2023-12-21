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

	<h1>改造完了</h1>

	<table border="1">
		<tr>
			<th>名前</th>
			<th>ポジション</th>
			<th>バッティング</th>
			<th>守備</th>
		</tr>
		<tr>
			<td><c:out value="${player.name}" /></td>
			<td><c:out value="${player.position}" /></td>
			<td><c:out value="${player.battingAverage}" /></td>
			<td><c:out value="${player.defense}" /></td>
		</tr>
	</table>

	<p>
		<c:out value="${result}" />
	</p>
<p><a href="menu">menu</a></p>

</body>
</html>