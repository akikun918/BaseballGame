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
	<h1>ユーザー登録</h1>
	<c:out value="${error}" />
	<c:if test="${not empty error}">
		<p>
			<font color="#ff4500"> <c:out value="${error}" /></font>
		</p>
	</c:if>


	<form action="" method="post">
		<p>
			ログインID： <input type="text" name="loginId"
				value="<c:out value="${admin.loginId}" />" />
		</p>
		<p>
			ログインPASS： <input type="password" name="loginPass"
				value="<c:out value="${admin.loginPass}" />" />
		</p>
		<p>
			<input type="submit" value="登録">
		</p>
	</form>

	<p>
		<a href="login">ログイン画面へ</a>
	</p>
</body>
</html>