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

<%-- 	<c:if test="${not empty error}">
		<p>
			<c:out value="現在保有ポイント：${point}P" />
		</p>
		<p>
			<c:out value="${error}" />
		</p>
		<p>
			<a href="showPoint">ポイントを購入へ</a>
		</p>
		<p>
			<a href="trade">他の選手を選ぶ</a>
		</p>
		<p>
			<a href="menu">メニューヘ</a>
		</p>
	</c:if>

	<c:if test="${not empty cost}">
		<c:if test="${empty error}">
			<p>
				<c:out value="${player.name}を放出し" />
				<c:out value="${comPlayer.name}を獲得します" />
			</p>

			<c:if test="${not empty point}">
				<p>
					<c:out value="現在保有ポイント：${point}P" />
				</p>
			</c:if>
			<p>
				<c:out value="${costDetail}" />
			</p>
			<p>トレードしますか？</p>
			<form action="" method="post">
				<input type="submit" value="トレードする" />
			</form>
		</c:if>
		
	</c:if> --%>

<%-- 	<c:if test="${empty cost}"> --%>
		<p>トレードしました</p>
		<c:out value="ポイント残高は${admin.point}です" />

		<p>
			<a href="menu">メニューに戻る</a>
		</p>
<%-- 	</c:if> --%>


</body>
</html>