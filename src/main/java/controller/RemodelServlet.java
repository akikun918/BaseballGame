package controller;

import java.io.IOException;
import java.util.List;

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

/**
 * Servlet implementation class RemodelServlet
 */
@WebServlet("/remodel")
public class RemodelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PlayerDao playerDao = DaoFactory.createMemberDaoImpl();
		List<Player> players = playerDao.findPlayersByTeam(5);

		request.setAttribute("players", players);
		request.getRequestDispatcher("/WEB-INF/view/remodel.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		AdminDao adminDao = DaoFactory.createAdminDaoImpl();
		Admin admin = (Admin) session.getAttribute("admin");
		if (admin.getPoint() - 1000 < 0) {
			request.setAttribute("errorPoint", "ポイントが足りません");
			doGet(request, response);
			return;
		}
		// データベースからポイントを引く
		admin.setPoint(admin.getPoint() - 1000);
		adminDao.setAll(admin);
		session.setAttribute("admin", admin);

		String strPlayerId = request.getParameter("playerId");
		int playerId = Integer.parseInt(strPlayerId);
		PlayerDao playerDao = DaoFactory.createMemberDaoImpl();
		Player player = playerDao.findPlayerById(playerId);

		double result = Math.random();
		if (result < 0.07) {

			session.setAttribute("result", "改造に大失敗し引退しました");

			player.setBattingAverage(0);
			player.setDefense(0);
			player.setStamina(0);
			session.setAttribute("player", player);
			playerDao.deletePlayer(player);
			response.sendRedirect(request.getContextPath() + "/remodelDone");
			return;
		} else if (result < 0.20) {
			session.setAttribute("result", "改造に失敗しました");

			if (player.getPosition().equals("P")) {
				player.setDefense(0);
			} else {
				player.setBattingAverage(0);
			}
			playerDao.setPlayer(player);
			session.setAttribute("player", player);
			response.sendRedirect(request.getContextPath() + "/remodelDone");
			return;
		} else if (result < 0.28) {
			result = 4;
		} else if (result < 0.40) {
			result = 3;
		} else if (result < 0.55) {
			result = 2;
		} else if (result < 0.70) {
			result = 1;
		} else if (result < 0.82) {
			session.setAttribute("result", "特に変化はありませんでした");
			session.setAttribute("player", player);
			response.sendRedirect(request.getContextPath() + "/remodelDone");
			return;
		} else if (result < 0.90) {
			result = -1;
		} else if (result < 0.95) {
			result = -2;
		} else {
			result = -3;
		}

		System.out.println(result);

		int resultResult = 0;
		if (player.getPosition().equals("P")) {
			int preDefense = player.getDefense();
			player.setDefense((int) (player.getDefense() + result));
			if (player.getDefense() < 0) {
				player.setDefense(0);

			}
			resultResult = player.getDefense() - preDefense;
			if (resultResult == 0) {
				session.setAttribute("result", "特に変化はありませんでした");
			} else {
				session.setAttribute("result", resultResult + "変化しました");
			}

		} else {
			int preBattingAverage = player.getBattingAverage();
			player.setBattingAverage((int) (player.getBattingAverage() + result));
			if (player.getBattingAverage() < 0) {
				player.setBattingAverage(0);
			}
			resultResult = player.getBattingAverage() - preBattingAverage;
			if (resultResult == 0) {
				session.setAttribute("result", "特に変化はありませんでした");
			} else {
				session.setAttribute("result", resultResult + "変化しました");
			}

		}
		playerDao.setPlayer(player);
		session.setAttribute("player", player);

		response.sendRedirect(request.getContextPath() + "/remodelDone");

	}

}
