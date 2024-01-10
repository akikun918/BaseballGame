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

	<h1>新しいプレイヤーを作る</h1>
	<p>1000Pかかります</p>



	<p>
		現在の保有ポイントは
		<c:out value="${admin.point}" />
		Pです
	</p>
	<p>
		<a href="showPoint">ポイントを購入する</a>
	</p>
	<p>ポジションと名前と誕生日を決めてください</p>



	<c:if test="${not empty errorName}">
		<p>
			<font color="#ff4500"> <c:out value="${errorName}" /></font>
		</p>
	</c:if>
	<c:if test="${not empty errorBirthday}">
		<p>
			<font color="#ff4500"> <c:out value="${errorBirthday}" /></font>
		</p>
	</c:if>
	<c:if test="${not empty errorPoint}">
		<p>
			<font color="#ff4500"> <c:out value="${errorPoint}" /></font>
		</p>
	</c:if>

	<form action="" method="post">
		<p>
			名前:<input type="text" name="name" />
		</p>
		<p>
			誕生日： <input type="date" name="birthday" value="1992-09-18" />
		</p>
		
		<p>ポジション：
		<select name="position">
			<option value="1B">一塁</option>
			<option value="2B">二塁</option>
			<option value="3B">三塁</option>
			<option value="SS">ショート</option>
			<option value="CF">センター</option>
			<option value="LF">レフト</option>
			<option value="RF">ライト</option>
			<option value="C">キャッチャー</option>
			<option value="P">ピッチャー</option>
		</select> <input type="submit" />
</p>
	</form>

	<p>
		<a href="menu">メニューへ</a>
	</p>

</body>
</html>