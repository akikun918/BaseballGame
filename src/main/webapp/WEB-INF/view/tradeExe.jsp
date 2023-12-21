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
		<c:out value="現在保有ポイント：${admin.point}P" />
	</p>

	<c:if test="${not empty error}">
		<p>
			<c:out value="${error}" />
		</p>
		<p>
			<a href="showPoint">ポイントを購入する</a>
		</p>
		<p>
			<a href="trade">選手を選びなおす</a>
		</p>
	</c:if>
	<c:if test="${empty error}">
		<p>
			<c:out value="${releasePlayer.name}を放出し" />
			<c:out value="${getPlayer.name}を獲得します" />
		</p>

		<c:if test="${cost < 0}">
			<p>
				<c:out value="${cost * (-1)} Pを獲得できます" />
			</p>
		</c:if>
		<c:if test="${cost >= 1}">
			<p>
				<c:out value="${cost} Pかかります" />
			</p>
		</c:if>
		<c:if test="${cost == 0}">
			<p>無償トレードが可能です</p>
		</c:if>
		<%-- 	<p>
		<c:out value="${costDetail}" />
	</p> --%>
		<p>トレードしますか？</p>
		<c:if test="${not empty samePosition}">
			<p>
				<font color="#ff4500"><c:out value="${samePosition}" /></font>
			</p>
		</c:if>

		<form action="" method=post>
			<input type="hidden" name="releasePlayer"
				value="<c:out value="${releasePlayer.id}" />" /> <input
				type="hidden" name="getPlayerId"
				value="<c:out value="${getPlayer.id}" />" /> <input type="hidden"
				name="cost" value="<c:out value="${cost}" />" /> <input
				type="submit" value="トレードする" />
		</form>
		<p>
			<a href="trade">やっぱやめた</a>
		</p>

	</c:if>
</body>
</html>