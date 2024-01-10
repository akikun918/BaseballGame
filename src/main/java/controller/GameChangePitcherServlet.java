package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoFactory;
import dao.PlayerDao;
import domain.Player;
import service.ScoresServise;

/**
 * Servlet implementation class ChangePitcherServlet
 */
@WebServlet("/gameChangePitcher")
public class GameChangePitcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("comTeam") == null) {
			response.sendRedirect(request.getContextPath() + "/preGame");
			return;
		}
		request.getRequestDispatcher("/WEB-INF/view/gameChangePitcher.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PlayerDao playerDao = DaoFactory.createMemberDaoImpl();

		String strChangePitcherId = request.getParameter("changePitcherId");
		Integer changePitcherId = Integer.parseInt(strChangePitcherId);
		Player pitcher = playerDao.findPlayerById(changePitcherId);

		// 交代したいピッチャーがすでにプレーした選手か確認
		if (!ScoresServise.playedPitcher(pitcher)) {
			request.setAttribute("error", "同じ選手は交代できません");
			request.getRequestDispatcher("/WEB-INF/view/gameChangePitcher.jsp").forward(request, response);
			return;
		}

		HttpSession session = request.getSession();
		session.setAttribute("pitcher", pitcher);

		ScoresServise.totalBatting(pitcher);

		// ピッチャーのstaminaを設定
		ScoresServise.minusStamina = pitcher.getStamina();
		ScoresServise.leftStamina = 11;

		response.sendRedirect(request.getContextPath() + "/game");
	}

}
