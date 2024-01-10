<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>保有ポイント</title>
</head>
<body>
	<h1>保有ポイントと購入</h1>
	<p>
		現在保有ポイントは
		<c:out value="${admin.point}" />
		Pです
	</p>

	<p>
		ポイントを購入する
	</p>

	<c:if test="${not empty error}">
		<font color="#ff4500"><c:out value="${error}" /></font>
	</c:if>

	<form action="" method="post">
		<p><input type="text" name="point" required placeholder="1000"
			minlength="4" />P</p>
		<p>
			<input type="submit" value="購入する" />
		</p>
	</form>

	<p>
		<a href="menu">メニューへ</a>
	</p>


</body>
</html>