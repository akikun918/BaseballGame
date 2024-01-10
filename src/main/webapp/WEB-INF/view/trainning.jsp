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
	<p>
		<c:out value="${condition}" />
	</p>
	<c:if test="${empty results}">
		<form action="" method="post">
			<input type="submit" value="開始" />
		</form>
	</c:if>
	<c:forEach items="${results}" var="result" varStatus="vs">
		<tr>
			<td><c:out value="${result}" /></td>
		</tr>
	</c:forEach>
	<c:if test="${not empty results}">
		<form action="" method="post">
			<input type="submit" value="次へ" />
		</form>
	</c:if>

</body>
</html>