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
			<th>あなた</th>
			<c:forEach items="${scores}" var="score" varStatus="vs">
				<td><c:out value="${score}" /></td>
			</c:forEach>
			<c:if test="${not empty total}">
				<td><c:out value="${total}" /></td>
			</c:if>
		</tr>
		<tr>
			<th>コンピュータ</th>
			<c:forEach items="${comScores}" var="comScore" varStatus="vs">
				<td><c:out value="${comScore}" /></td>
			</c:forEach>
			<c:if test="${not empty comTotal}">
				<td><c:out value="${comTotal}" /></td>
			</c:if>
		</tr>
	</table>


	<c:if test="${not empty result}">
		<p>
			<c:out value="${result}" />
		</p>

		<form action="" method="post">
			<p>
				<input type="submit" value="もう一度試合をする" />
			</p>
		</form>
		<p>
			<a href="menu">メニューヘ</a>
		</p>
	</c:if>


	<form action="" method="post">
		<c:if test="${empty scores}">
			<input type="submit" value="試合開始" />
		</c:if>
		<c:if test="${not empty scores}">
			<c:if test="${empty total}">
				<input type="submit" value="次のイニングへ" />
			</c:if>
		</c:if>
	</form>
</body>
</html>