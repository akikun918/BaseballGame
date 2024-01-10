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
	<c:if test="${empty reset}">
		<p>選手を初期状態にもどしますか？</p>
		<p>購入したポイントとアイテムはそのままです</p>

		<form action="" method="post">
			<input type="submit" value="はい" />
		</form>
		<p>
			<a href="menu">メニューにもどる</a>
		</p>
	</c:if>
	<c:if test="${not empty reset}">
		<c:out value="${reset}" />
		<p>
			<a href="menu">メニューにもどる</a>
		</p>
	</c:if>
</body>
</html>