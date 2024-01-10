<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<!-- <style>
 .position {
	display: inline-block;
} 
</style> -->
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>トレード</h1>
	<p>
		<a href="menu">menu</a>
	</p>
	<c:if test="${not empty error}">
		<p>
			<font color="#ff4500"><c:out value="${error}" /></font>
		</p>
	</c:if>
	<p>
		現在の保有ポイントは
		<c:out value="${admin.point}" />
		Pです
	</p>
	<p>
		<a href="showPoint">ポイントを購入する</a>
	</p>
	<h2>獲得する選手を絞り込む</h2>
	<form action="" method="post">
		<p>
			ポジション：<input type="checkbox" name="position" value="1B" /> 1B <input
				type="checkbox" name="position" value="2B" /> 2B <input
				type="checkbox" name="position" value="3B" /> 3B <input
				type="checkbox" name="position" value="C" /> C <input
				type="checkbox" name="position" value="CF" /> CF <input
				type="checkbox" name="position" value="LF" /> LF <input
				type="checkbox" name="position" value="P" /> P <input
				type="checkbox" name="position" value="RF" /> RF <input
				type="checkbox" name="position" value="SS" /> SS
		</p>
		<p>
			移籍金 <select name="moneyB">
				<option value="0" selected="selected">下限なし</option>
				<option value="100">100</option>
				<option value="200">200</option>
				<option value="300">300</option>
				<option value="400">400</option>
				<option value="500">500</option>
				<option value="600">600</option>
				<option value="700">700</option>
				<option value="800">800</option>
				<option value="900">900</option>
				<option value="1000">1000</option>
			</select> <span>〜</span> <select name="moneyT"><option
					value="9999999" selected="selected">上限なし</option>
				<option value="100">100</option>
				<option value="200">200</option>
				<option value="300">300</option>
				<option value="400">400</option>
				<option value="500">500</option>
				<option value="600">600</option>
				<option value="700">700</option>
				<option value="800">800</option>
				<option value="900">900</option>
				<option value="1000">1000</option></select>
		</p>
		<p>
			攻撃力 <select name="battingB">
				<option value="0" selected="selected">下限なし</option>
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="6">6</option>
				<option value="7">7</option>
				<option value="8">8</option>
				<option value="9">9</option>
				<option value="10">10</option>
			</select> <span>〜</span> <select name="battingT"><option
					value="9999999" selected="selected">上限なし</option>
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="6">6</option>
				<option value="7">7</option>
				<option value="8">8</option>
				<option value="9">9</option>
				<option value="10">10</option></select>
		</p>
		<p>
			守備力 <select name="defenseB">
				<option value="0" selected="selected">下限なし</option>
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="6">6</option>
				<option value="7">7</option>
				<option value="8">8</option>
				<option value="9">9</option>
				<option value="10">10</option>
			</select> <span>〜</span> <select name="defenseT"><option
					value="9999999" selected="selected">上限なし</option>
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="6">6</option>
				<option value="7">7</option>
				<option value="8">8</option>
				<option value="9">9</option>
				<option value="10">10</option></select>
		</p>
		<input type="submit" value="絞り込み検索" />
	</form>



	<!-- 	<select name="cb" class="selectitem-select"><option
				value="0.0" selected="selected">下限なし</option>
			<option value="3.0">3万円</option>
			<option value="3.5">3.5万円</option>
			<option value="4.0">4万円</option>
	
			<option value="40.0">40万円</option>
			<option value="50.0">50万円</option>
			<option value="100.0">100万円</option></select>
		<span class="selectitem-label">〜</span>
		<select name="ct" class="selectitem-select"><option
				value="9999999" selected="selected">上限なし</option>
			<option value="3.0">3万円</option>
			<option value="3.5">3.5万円</option>
			<option value="40.0">40万円</option>
			<option value="50.0">50万円</option>
			<option value="100.0">100万円</option></select>
		</div>

 -->




	<!-- 	<form action="" method="post">
			<select name="money">
				<option value="">移籍金 -P 以下</option>
				<option value="800">移籍金 800P 以下</option>
				<option value="600">移籍金 600P 以下</option>
				<option value="400">移籍金 400P 以下</option>
								<option value="2">移籍金 2P 以下</option>
			</select> <select name="batting">
				<option value="2">攻撃力 2 以上</option>
				<option value="4">攻撃力 4 以上</option>
				<option value="6">攻撃力 6 以上</option>
				<option value="8">攻撃力 8 以上</option>
				<option value="10">攻撃力 10 以上</option>
			</select> <select name="defense">
				<option value="2">守備力 2 以上</option>
				<option value="4">守備力 4 以上</option>
				<option value="6">守備力 6 以上</option>
				<option value="8">守備力 8 以上</option>
				<option value="10">守備力 10 以上</option>
			</select> <input type="submit" />
		</form>
 -->

	<h2>獲得する選手を選んでください</h2>
	<form action="" method="post">
		<table border="1">
			<tr>
				<th>選手</th>
				<th>移籍金</th>
				<th>ポジション</th>
				<th>バッティング</th>
				<th>守備</th>
				<th>スタミナ</th>
			</tr>
			<c:forEach items="${players}" var="player" varStatus="vs">
				<tr>
					<td><input type="radio" name="getPlayerId"
						${vs.count == 2 ? "checked" : "" }
						value="<c:out value="${player.id}" />"> <c:out
							value="${player.name}" /></td>
					<td><c:out value="${player.salary}P" /></td>
					<td><c:out value="${player.position}" /></td>
					<td><c:out value="${player.battingAverage}" /></td>
					<td><c:out value="${player.defense}" /></td>
					<c:if test="${not empty player.stamina}">
						<td><c:out value="${player.stamina}" /></td>
					</c:if>
					<c:if test="${empty player.stamina}">
						<td>-</td>
					</c:if>
				</tr>
			</c:forEach>
		</table>

		<h2>放出選手を選んでください</h2>
		<table border="1">
			<tr>
				<th>名前</th>
				<th>移籍金</th>
				<th>ポジション</th>
				<th>バッティング</th>
				<th>守備</th>
				<th>スタミナ</th>
			</tr>
			<c:forEach items="${myPlayers}" var="myPlayer" varStatus="vs">
				<tr>
					<td><input type="radio" name="releasePlayerId"
						${vs.count == 1 ? "checked" : "" }
						value="<c:out value="${myPlayer.id}"/>"> <c:out
							value="${myPlayer.name}" /></td>
					<td><c:out value="${myPlayer.salary}P" /></td>
					<td><c:out value="${myPlayer.position}" /></td>
					<td><c:out value="${myPlayer.battingAverage}" /></td>
					<td><c:out value="${myPlayer.defense}" /></td>
					<c:if test="${not empty myPlayer.stamina}">
						<td><c:out value="${myPlayer.stamina}" /></td>
					</c:if>
					<c:if test="${empty myPlayer.stamina}">
						<td>-</td>
					</c:if>
				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="決定" />
	</form>



<%-- 
	<c:if test="${not empty getComPlayersByPosition}">
		<p>
			放出選手：
			<c:out
				value="${releasePlayer.name} 移籍金:${releasePlayer.salary} P  打撃力:${releasePlayer.battingAverage}" />
		</p>
		<p>獲得する選手を選んでください</p>
		<form action="doTrade">
			<table border="1">
				<tr>
					<th>名前</th>
					<th>移籍金</th>
					<th>ポジション</th>
					<th>打撃力</th>
				</tr>
				<c:forEach items="${getComPlayersByPosition}" var="playerByPosition"
					varStatus="vs">
					<tr>

						<td><input type="radio" name="getPlayerId"
							${vs.count == 2 ? "checked" : "" }
							value="<c:out value="${playerByPosition.id}" />"> <c:out
								value="${playerByPosition.name}" /></td>
						<td><c:out value="${playerByPosition.salary}P" /></td>
						<td><c:out value="${playerByPosition.position}" /></td>
						<td><c:out value="${playerByPosition.battingAverage}" /></td>
					</tr>
				</c:forEach>
			</table>
			<input type="hidden" name="releasePlayerId"
				value="<c:out value="${releasePlayer.id}" />" /> <input
				type="submit" />
		</form>
		<p>
			<a href="trade">もう一度放出する選手を選ぶ</a>
		</p>
	</c:if>
 --%>

</body>
</html>