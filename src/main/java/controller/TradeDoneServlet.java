package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TradeDoneServlet
 */
@WebServlet("/tradeDone")
public class TradeDoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
		request.getRequestDispatcher("/WEB-INF/view/tradeDone.jsp").forward(request, response);

		
		
		
		
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		if (request.getParameter("cost") == null) {
//			response.sendRedirect(request.getContextPath() + "/menu");
//			return;
//		}
//		HttpSession session = request.getSession();
//
//		String strCost = request.getParameter("cost");
//		int point = (int) session.getAttribute("point");
//		int cost = Integer.parseInt(strCost);
//		point = point - cost;
//		String loginId = (String) session.getAttribute("loginId");
//		AdminDao adminDao = DaoFactory.createAdminDaoImpl();
//		adminDao.setPoint(loginId, point);
//		session.setAttribute("point", point);
//
//		String PlayerId = request.getParameter("playerId");
//		String strComPlayerId = request.getParameter("comPlayerId");
//		int playerId = Integer.parseInt(PlayerId);
//		int comPlayerId = Integer.parseInt(strComPlayerId);
//		PlayerDao playerDao = DaoFactory.createMemberDaoImpl();
//		Player comPlayer = playerDao.findPlayerById(comPlayerId);
//		Player player = playerDao.findPlayerById(playerId);
//
//		Integer teamId = player.getTeamId();
//		Integer id = player.getId();
//		Integer comTeamId = comPlayer.getTeamId();
//		Integer comId = comPlayer.getId();
//
//		playerDao.trade(teamId, comId);
//		playerDao.trade(comTeamId, id);

	//	request.getRequestDispatcher("/WEB-INF/view/tradeDone.jsp").forward(request, response);

	}

}
