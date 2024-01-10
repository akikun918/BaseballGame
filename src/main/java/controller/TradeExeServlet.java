package controller;

import java.io.IOException;

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
 * Servlet implementation class Dotrade
 */
@WebServlet("/tradeExe")
public class TradeExeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("getPlayer") == null) {
			response.sendRedirect(request.getContextPath() + "/trade");
			return;
		}

		Player getPlayer = (Player) session.getAttribute("getPlayer");
		Player releasePlayer = (Player) session.getAttribute("releasePlayer");

		int cost = getPlayer.getSalary() - releasePlayer.getSalary();

		Admin admin = (Admin) session.getAttribute("admin");
		int point = admin.getPoint();

		if (point - cost < 0) {
			int i = Math.abs(point - cost);
			request.setAttribute("error", "ポイントが" + i + "P足りません");
			request.getRequestDispatcher("/WEB-INF/view/tradeExe.jsp").forward(request, response);
			return;
		}

		if (!getPlayer.getPosition().equals(releasePlayer.getPosition())) {
			request.setAttribute("samePosition", "ポジションが違う選手のトレードですがよろしいですか？");
		}

		session.setAttribute("cost", cost);

		request.getRequestDispatcher("/WEB-INF/view/tradeExe.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("cost") == null) {
			response.sendRedirect(request.getContextPath() + "/trade");
			return;
		}
		int cost = (int) session.getAttribute("cost");

		Admin admin = (Admin) session.getAttribute("admin");
		int point = admin.getPoint();
		point = point - cost;
		admin.setPoint(point);
		AdminDao adminDao = DaoFactory.createAdminDaoImpl();
		adminDao.setAll(admin);
		session.setAttribute("admin", admin);

		PlayerDao playerDao = DaoFactory.createMemberDaoImpl();
		Player getPlayer = (Player) session.getAttribute("getPlayer");
		Player releasePlayer = (Player) session.getAttribute("releasePlayer");

		Integer releasePlayerTeamId = releasePlayer.getTeamId();
		Integer getPlayerTeamId = getPlayer.getTeamId();

		playerDao.trade(releasePlayerTeamId, getPlayer.getId());
		playerDao.trade(getPlayerTeamId, releasePlayer.getId());

		response.sendRedirect(request.getContextPath() + "/tradeDone");
	}

}
