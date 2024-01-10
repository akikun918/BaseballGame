package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoFactory;
import dao.PlayerDao;
import domain.Player;
import service.TrainningServise;

/**
 * Servlet implementation class TrainningChooseServlet
 */
@WebServlet("/trainningChoose")
public class TrainningChooseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		if (session.getAttribute("trainning") == null) {
			request.setAttribute("errorTrainning", "トレーニングは一試合毎にしか行えません");
			request.getRequestDispatcher("/WEB-INF/view/trainningChoose.jsp").forward(request, response);
			return;
		}

		PlayerDao playerDao = DaoFactory.createMemberDaoImpl();
		List<Player> players = playerDao.findPlayersByTeam(5);

		request.setAttribute("players", players);

		request.getRequestDispatcher("/WEB-INF/view/trainningChoose.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		PlayerDao playerDao = DaoFactory.createMemberDaoImpl();

		TrainningServise.results.clear();

		String trainningKind = request.getParameter("trainningKind");
		String strPlayerId = request.getParameter("playerId");
		int playerId = Integer.parseInt(strPlayerId);

		Player player = playerDao.findPlayerById(playerId);

		if (trainningKind.equals("1")) {
			if (player.getBattingAverage() >= 10 ) {
				request.setAttribute("error", "選手のトレーニングのパラメーターが10以下のものを選んでください");
				session.removeAttribute("condition");
				doGet(request, response);
				return;
			}
			int i = player.getBattingAverage() - 4;
			if (i < 1) {
				i = 1;
			}
			session.setAttribute("condition", "この選手のバッティングを上げるにはには5回中" + i + "回以上の成功が必要です");
		} else {
			if (player.getDefense() >= 10 ) {
				request.setAttribute("error", "選手のトレーニングのパラメーターが10以下のものを選んでください");
				session.removeAttribute("condition");
				doGet(request, response);
				return;
			}
			int i = player.getDefense() - 4;
			if (i < 1) {
				i = 1;
			}
			session.setAttribute("condition", "この選手の守備力を上げるには5回中" + i + "回以上の成功が必要です");
		}

		session.setAttribute("trainningKind", trainningKind);
		session.setAttribute("trainningPlayer", player);

		doGet(request, response);
	}

}
