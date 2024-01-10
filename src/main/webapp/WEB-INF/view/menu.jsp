<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<style>
h1{
text-align: center;
}
ul {
width: 590px;
 margin: 0 auto; 
}
li {
	display: inline-block;
	background: #cfe3f0;
	width: 130px;
 	margin: 5pt;
 	font-size: 10pt;
}

li img {
	width: 100%;
	height: auto;
}

li div {
	text-align: center;
}

a {
	text-decoration: none;
	color: #000;
}

.flex {
	display: flex;
	align-items: center;
}

.flex img {
	width: 15%;
}

.right {
float :right;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%-- 	<c:if test="${not empty admin}">
		<p style="text-align: center">
			<c:out value="アカウント：${admin.loginId} 様" />
		</p>
	</c:if>

	<c:if test="${empty admin}">
		<p style="text-align: center">
			<a href="login">ログイン</a>
		</p>
	</c:if>
 --%>
	<header>
		<h1>実況ウルトラプロ野球</h1>
		<nav>
			<ul style="list-style: none;">
				<li><a href="preGame"><img src="upload/a.png" alt="試合">
						<div>試合をする</div></a></li>

				<!-- 	<li><a href="showPoint"><img src="upload/c0166_7_0.jpg"
							alt="ポイントの購入">
							<div>ポイントの購入</div></a></li> -->
				<li><a href="trainningChoose"><img src="upload/b.png"
						alt="選手をトレーニングする">
						<div>選手をトレーニング</div></a></li>
				<li><a href="trade"><img src="upload/c.png" alt="選手をトレードする">
						<div>選手をトレード</div></a></li>
				<li><a href="cartIndex"><img src="upload/k.jpg"
						alt="アイテムを購入する">
						<div>アイテムを購入する</div></a></li><br>
				<li><a href="createChara"><img src="upload/f.jpg"
						alt="新しい選手を作る">
						<div>新しい選手を作る</div></a></li>

				<li><a href="remodel"><img src="upload/d.png"
						alt="選手を魔改造する">
						<div>選手を魔改造する</div></a></li>

				<li><a href="playerList"><img src="upload/i.png"
						alt="選手データ">
						<div>選手データ</div></a></li>

				<li><a href="save"><img src="upload/g.jpg" alt="データセーブ">
						<div>データセーブ</div></a></li><br>

				<li class="right"><a href="reset" class="flex"><img src="upload/h.png"
						alt="ゲームをリセット">
						<div>ゲームリセット</div></a></li>
				<li class="right"><a href="account" class="flex"><img src="upload/j.png"
						alt="アカウント情報">
						<div>アカウント情報</div></a></li>



			</ul>
		</nav>
	</header>

</body>
</html>