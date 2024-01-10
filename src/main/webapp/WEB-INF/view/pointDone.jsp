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
	<h1>ご購入ありがとうございます</h1>
	<p>
		保有ポイント合計
		<c:out value="${admin.point}" />
		P
	</p>
	<p>
		<a href="menu">メニューへ</a>
	</p>
</body>
</html>