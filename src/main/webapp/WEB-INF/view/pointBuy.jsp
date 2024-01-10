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
	<h1>ポイント購入</h1>
	<p>
		<c:out value="${buyPoint}" />
		P購入します
	</p>
	<p>
		<c:out value="${buyPoint}" />
		円かかります
	</p>

	<form action="" method="post">
		<p>お支払い方法</p>
		<p>
			<input type="radio" name="payment" value="credit" checked>クレジットカード
		</p>
		<c:if test="${not empty error}">
			<p>
				<font color="#ff4500"> <c:out value="${error}" /></font>
			</p>
		</c:if>
		<p>
			<input type="text" name="number1" size="4" minlength="4"
				maxlength="4" required placeholder="1234"> &nbsp;-&nbsp; <input
				type="text" name="number2" size="4" minlength="4" maxlength="4"
				required placeholder="5678"> &nbsp;-&nbsp; <input
				type="text" name="number3" size="4" minlength="4" maxlength="4"
				required placeholder="1234"> &nbsp;-&nbsp; <input
				type="text" name="number4" size="4" minlength="4" maxlength="4"
				required placeholder="5678">
		</p>
		<p>
			<input type="submit" value="購入する" />
		</p>
	</form>
	<p>
		<a href="showPoint">購入ポイントを変更する</a>
	</p>
	<p>
		<a href="menu">メニューへ</a>
	</p>

</body>
</html>