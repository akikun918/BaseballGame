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

	<p style="text-align: center">
		<c:out value="アカウント：${loginId} 様" />
	</p>

	<c:if test="${not empty error}">
		<p>
			<font color="#ff4500"><c:out value="${error}" /></font>
		</p>
	</c:if>

		<p>ピッチャーを選ぶ</p>
		<p>
			現在のピッチャー:
			<c:out value="${pitcher.name}" />
		</p>
		<form action="" method="post">
			<select name="changePitcherId">
				<c:forEach items="${pitchersInTheTeam}" var="pitcher" varStatus="vs">
					<option value="<c:out value="${pitcher.id}" />">
						<c:out
							value="${pitcher.name}  ピッチング：${pitcher.defense}　体力：${pitcher.stamina}" />
				</c:forEach>
			</select> <input type="submit" value="ピッチャーを交換" />
		</form>
		<form action="game" >
			<input type="submit" value="ピッチャーを交換せずに試合再開" />
		</form>


</body>
</html>