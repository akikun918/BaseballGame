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

	<h1>購入完了</h1>
	<p>ご購入ありがとうございました。</p>
	<%-- <p>現在の保有数</p>
	<table>
		<tr>
			<td>エナジードリンク</td>
			<td>：<c:out value="${admin.drink}" />個
			</td>
		</tr>
		<tr>
			<td>ドーピング</td>
			<td>：<c:out value="${admin.dope }" />個
			</td>
		</tr>
	</table> --%>
	<p>
		<a href="menu">メニューへ</a>
	</p>
	<p>
		<a href="preGame">試合へ</a>
	</p>



</body>
</html>