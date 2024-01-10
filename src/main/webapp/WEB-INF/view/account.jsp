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

	<h1>アカウント情報</h1>
	<p>
		アカウント名:
		<c:out value="${admin.loginId}" />
	</p>
	<p>
		保有ポイント:
		<c:out value="${admin.point}" />
	</p>

	<h2>保有アイテム</h2>
	<p>
		エナジードリンク:
		<c:out value="${admin.drink}" />
	</p>
	<p>
		ドーピング:
		<c:out value="${admin.dope}" />
	</p>
	<p>
		<a href="showPoint">ポイントを購入する</a>
	</p>
	<p>
		<a href="cartIndex">アイテムを購入する</a>
	</p>
	<p>
		<a href="menu">メニューへ</a>
	</p>
	<p>
		<a href="logout">ログアウト</a>
	</p>



</body>
</html>