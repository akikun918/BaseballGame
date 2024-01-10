package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoFactory;
import dao.PlayerDao;
import dao.TeamDao;
import domain.Player;
import domain.Team;
import service.ScoresServise;

/**
 * Servlet implementation class PreGameServlet
 */
@WebServlet("/preGame")
public class GamePreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		PlayerDao playerDao = DaoFactory.createMemberDaoImpl();
		TeamDao teamDao = DaoFactory.createTeamDaoImpl();

		// 対戦相手チーム
		List<Team> teams = teamDao.findTeam();
		request.setAttribute("teams", teams);

		// 自分のチームのピッチャーを取り出す
		List<Player> findPitchersInTheTeam = playerDao.findPitchersInTheTeam(5);
		request.setAttribute("pitchers", findPitchersInTheTeam);

		// 自分のチームのピッチャー以外の選手を取り出す
		List<Player> myPlayers = playerDao.findFieldplayersByTeam(5);

		// 自分の選手の体調をセットする
		if (session.getAttribute("dontRepeat") == null) {
			myPlayers.stream().forEach(s -> playerDao.setFeel(s.getId()));
			//上のラムダ式を使う前
			//			for (Player player : myPlayers) {
			//				int id = player.getId();
			//				playerDao.setFeel(id);
			//			}
			myPlayers = playerDao.findFieldplayersByTeam(5);
			//F5対策
			session.setAttribute("dontRepeatSetFeel", "a");
		}

		// ドーピングを使った選手の攻撃力と守備力を上げた値で表示する
		if (ScoresServise.dopingFieldPlayers.size() != 0) {
			for (Player dopingFieldPlayer : ScoresServise.dopingFieldPlayers) {
				for (Player myPlayer : myPlayers) {
					if (myPlayer.getId() == dopingFieldPlayer.getId()) {
						myPlayer.setBattingAverage(myPlayer.getBattingAverage() + 7);
						myPlayer.setDefense(myPlayer.getDefense() + 7);
					}
				}
			}
		}
		
		request.setAttribute("myPlayers", myPlayers);
		request.getRequestDispatcher("/WEB-INF/view/gamePre.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		PlayerDao playerDao = DaoFactory.createMemberDaoImpl();

		String[] strFieldPlayerIds = request.getParameterValues("fieldPlayerId");

		boolean isValid = true;

		if (strFieldPlayerIds == null) {
			request.setAttribute("error", "※選手を選んでください");
			doGet(request, response);
			return;
		}

		if (strFieldPlayerIds.length > 8) {
			request.setAttribute("error", "※選手を9人以上選べません");
			isValid = false;
		}

		// 選択したフィールドプレイヤーのList作成
		List<Player> fieldPlayers = new ArrayList<>();
		for (String strFieldPlayerId : strFieldPlayerIds) {
			Integer fieldPlayerId = Integer.parseInt(strFieldPlayerId);
			Player fieldPlayer = playerDao.findPlayerById(fieldPlayerId);
			fieldPlayers.add(fieldPlayer);
		}

		for (int i = 0; i < fieldPlayers.size() - 1; i++) {
			if (fieldPlayers.get(i).getPosition().equals(fieldPlayers.get(i + 1).getPosition())) {
				request.setAttribute("positionError", "※同じポジションの選手を選ばないでください");
				isValid = false;
			}
		}

		if (!isValid) {
			doGet(request, response);
			return;
		}

		String strComTeamId = request.getParameter("teamId");
		String strPitcherId = request.getParameter("pitcherId");

		Integer comTeamId = Integer.parseInt(strComTeamId);
		Integer pitcherId = Integer.parseInt(strPitcherId);

		// 相手チームが勝ったら相手チームのデータベースに勝利数を入れるため。
		// ゲームから離れたら自動で消去するようにフィルターをかけてある
		TeamDao teamDao = DaoFactory.createTeamDaoImpl();
		Team comTeam = teamDao.findTeamByTeamId(comTeamId);
		session.setAttribute("comTeam", comTeam);
		// session.setAttribute("comTeamId", comTeamId);

		// 自分のチームの先発ピッチャーを探す
		Player pitcher = playerDao.findPlayerById(pitcherId);
		// ゲームから離れたら自動で消去するようにフィルターをかけてある
		session.setAttribute("pitcher", pitcher);

		// 先発ピッチャーをstatic fieldへ
		ScoresServise.playedPitcher(pitcher);

		// ピッチャーのstaminaを設定
		ScoresServise.minusStamina = pitcher.getStamina();
		ScoresServise.leftStamina = 11;

		// ドーピングを使った選手の攻撃力と守備力を上げる
		if (ScoresServise.dopingFieldPlayers.size() != 0) {
			for (Player dopingFieldPlayer : ScoresServise.dopingFieldPlayers) {
				for (Player fieldPlayer : fieldPlayers) {
					if (fieldPlayer.getId() == dopingFieldPlayer.getId()) {
						fieldPlayer.setBattingAverage(fieldPlayer.getBattingAverage() + 7);
						fieldPlayer.setDefense(fieldPlayer.getDefense() + 7);
					}
				}
			}
			ScoresServise.dopingFieldPlayers.clear();
		}

		// 相手のチームのピッチャーを取り出す
		List<Player> comPitchers = playerDao.findPitchersInTheTeam(comTeamId);
		Player comPitcher = null;
		for (Player player : comPitchers) {
			comPitcher = player;
		}
		
		// 相手チームと自分のチームの選手を取り出し打撃力の合計値を決める
		List<Player> comFieldplayersByTeam = playerDao.findFieldplayersByTeam(comTeamId);
		ScoresServise.totalBatting(fieldPlayers, pitcher, comFieldplayersByTeam, comPitcher);
		
		// ピッチャーを交換する時に使う。ゲームから離れたら自動で消去するようにフィルターをかけてある
		List<Player> findPitchersInTheTeam = playerDao.findPitchersInTheTeam(5);
		session.setAttribute("pitchersInTheTeam", findPitchersInTheTeam);

		//F5対策のセッションの削除
		session.removeAttribute("dontRepeatSetFeel");
		response.sendRedirect(request.getContextPath() + "/game");
	}

}
