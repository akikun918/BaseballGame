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

	<h1>商品の選択</h1>
	<c:if test="${not empty error}">
		<font color="#ff4500"><c:out value="${error}" /></font>
	</c:if>
	<p>
		現在
		<c:out value="${admin.point}" />
		P保有しています
	</p>
	<c:forEach items="${items}" var="item" varStatus="vs">
		<ul>
			<li><a href="cartItemDetail?id=<c:out value="${item.id}" />"><c:out
						value="${item.name}" /></a></li>
		</ul>
	</c:forEach>

	<p>
		<a href="cart">カートを見る</a>
	</p>
	<p>
		<a href="account">保有アイテムを確認する</a>
	</p>
	<p>
		<a href="showPoint">ポイントを購入する</a>
	</p>
	<p>
		<a href="menu">メニューへ</a>
	</p>


</body>
</html></html>