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
	<p>以下の内容で登録しました</p>
	<table border="1">
		<tr>
			<th>ログインID</th>
			<td><c:out value="${admin.loginId}" /></td>
		</tr>
		<tr>
			<th>ログインパスワード</th>
			<td><input type="password"
				value=<c:out value="${admin.loginPass}" /> /></td>
		</tr>
	</table>
	<p>ボーナスポイント100Pとアイテムをゲットしました</p>
	<a href="menu">メニューヘ</a>
</body>
</html>