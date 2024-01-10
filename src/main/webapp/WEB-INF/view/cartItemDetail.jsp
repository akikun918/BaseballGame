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
	<h1>アイテムの購入</h1>
	<p>
		現在
		<c:out value="${admin.point}" />
		P保有しています
	</p>
	<c:if test="${not empty error}">
		<font color="#ff4500"><c:out value="${error}" /></font>
	</c:if>
	<form action="" method="post">
		<table border="1">
			<tr>
				<th>名前</th>
				<th>価格</th>
				<th>商品詳細</th>
				<th>購入個数</th>
				<th>小計</th>
			</tr>
			<tr>
				<td><c:out value="${item.name}" /></td>
				<td><c:out value="${item.price}" />P</td>
				<td><c:out value="${item.detail}" /></td>
				<td><input type="number" name="unit"
					value="<c:out value="${item.unit}" />" min="0" max="100" /></td>
				<td><c:out value="${total}" /></td>
			</tr>
		</table>
		<input type="submit" value="カートに入れる" />
	</form>
	<p>
		<a href="cart">カートを見る</a>
	</p>

	<p>
		<a href="showPoint">ポイントを購入する</a>
	</p>
	<p>
		<a href="cartIndex">商品一覧に戻る</a>
	</p>

	<p>
		<a href="account">保有アイテムを確認する</a>
	</p>
	<p>
		<a href="menu">メニューへ</a>
	</p>

</body>
</html>