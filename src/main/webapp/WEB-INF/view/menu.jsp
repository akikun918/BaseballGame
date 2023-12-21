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
	<c:if test="${not empty admin}">
		<p style="text-align: center">
			<c:out value="アカウント：${admin.loginId} 様" />
		</p>
	</c:if>

	<c:if test="${empty admin}">
		<p style="text-align: center">
			<a href="login">ログイン</a>
		</p>
	</c:if>


	<h1>メニュー</h1>
	<p>
		<a href="preGame">試合をする</a>
	</p>
	<p>
		<a href="playerList">選手をみる</a>
	</p>
	<p>
		<a href="showPoint">保有ポイントの確認と購入</a>
	</p>
	<p>
		<a href="trainningChoose">選手をトレーニングする</a>
	</p>
	<p>
		<a href="trade">選手をトレードする</a>
	</p>
	<p>
		<a href="cartIndex">アイテムを購入する</a>
	</p>
	<p>
		<a href="createChara">新しい選手を作る</a>
	</p>

	<p>
		<a href="remodel">選手を魔改造する</a>
	</p>
	<p>
		<a href="save">データをセーブする</a>
	</p>
	<p>
		<a href="reset">ゲームをリセットする</a>
	</p>
	<p>
		<a href="account">アカウント情報</a>
	</p>

</body>
</html>