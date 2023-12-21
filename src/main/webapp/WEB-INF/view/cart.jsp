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
	<h1>商品の決済</h1>

	<c:if test="${not empty error}">
		<font color="#ff4500"><c:out value="${error}" /></font>
	</c:if>
	<p>
		現在
		<c:out value="${admin.point}" />
		P保有しています
	</p>
	<table>
		<c:forEach items="${items}" var="item" varStatus="vs">
			<tr>
				<c:if test="${item.unit != 0}">
					<td><c:out value="${item.name}" /></td>
					<td><c:out value="${item.unit }" />個</td>
					<td><c:out value="${item.price * item.unit }" />P</td>
					<c:set var="total" value="${total + item.price * item.unit}" />
				</c:if>
			</tr>
		</c:forEach>
	</table>
	<p>
		合計:
		<c:out value="${total}" />
		P
	</p>
	<form action="" method="post">
		<input type="hidden" name="total" value="${total}" /> <input
			type="submit" value="購入する" />
	</form>
	<p>
		<a href="showPoint">ポイントを購入する</a>
	</p>
	<p>
		<a href="cartIndex">個数を変更する</a>
	</p>
	<p>
		<a href="cartIndex">商品一覧に戻る</a>
	</p>
	<p>
		<a href="menu">メニューへ</a>
	</p>
</body>
</html>