package controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AdminDao;
import dao.DaoFactory;
import dao.PlayerDao;
import domain.Admin;
import domain.Player;
import service.ScoresServise;

/**
 * Servlet implementation class DopingServlret
 */
@WebServlet("/doping")
public class DopingServlret extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		PlayerDao playerDao = DaoFactory.createMemberDaoImpl();
		List<Player> myPlayers = playerDao.findFieldplayersByTeam(5);

		// ドーピングを使った選手の攻撃力を上げた値で表示する
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
		request.getRequestDispatcher("/WEB-INF/view/doping.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		PlayerDao playerDao = DaoFactory.createMemberDaoImpl();

		String[] strDopingFieldPlayerIds = request.getParameterValues("fieldPlayerId");

		if (strDopingFieldPlayerIds == null) {
			request.setAttribute("error", "※選手を選んでください");
			doGet(request, response);
			return;
		}

		Admin admin = (Admin) session.getAttribute("admin");
		if (admin.getDope() < strDopingFieldPlayerIds.length) {
			request.setAttribute("error", "ドーピングの数が足りません");
			doGet(request, response);
			return;
		}

		// ドーピングしたフィールドプレイヤーのList作成
		List<Integer> dopingFieldPlayerIds = Arrays.stream(strDopingFieldPlayerIds).map(s -> Integer.parseInt(s))
				.collect(Collectors.toList());
		List<Player> dopingFieldPlayers = dopingFieldPlayerIds.stream().map(s -> playerDao.findPlayerById(s))
				.collect(Collectors.toList());
		//		 上のラムダ式を使う前
		//		List<Player> dopingFieldPlayers = new ArrayList<>();
		//		for (String strDopingFieldPlayerId : strDopingFieldPlayerIds) {
		//			Integer dopingFieldPlayerId = Integer.parseInt(strDopingFieldPlayerId);
		//			Player dopingFieldPlayer = playerDao.findPlayerById(dopingFieldPlayerId);
		//			dopingFieldPlayers.add(dopingFieldPlayer);
		//		}	
		
		for (Player player : dopingFieldPlayers) {
			if (player.getBattingAverage() < 2 || player.getDefense() < 2) {
				request.setAttribute("error", "試合後の各パラメーターが0以上になる選手を選んでください");
				doGet(request, response);
				return;
			}
		}
		
		// データベースのドーピングの数を減らす
		admin.setDope(admin.getDope() - dopingFieldPlayers.size());
		AdminDao adminDao = DaoFactory.createAdminDaoImpl();
		adminDao.setAll(admin);
		session.setAttribute("admin", admin);

		// データベースのドーピングを使った選手のバッティングを下げる
		dopingFieldPlayers.stream().forEach(s -> playerDao.useDoping(s));
		//		上のラムダ式を使う前
		//		for (Player player : dopingFieldPlayers) {
		//			playerDao.useDoping(player);
		//		}

		//ScoresServiseのstatic fieldにドーピングした選手を入れておく。試合開始後にclear()で削除
		dopingFieldPlayers.stream().forEach(s -> ScoresServise.dopingFieldPlayers.add(s));
		response.sendRedirect(request.getContextPath() + "/preGame");
	}

}
