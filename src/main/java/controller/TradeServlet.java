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

/**
 * Servlet implementation class TradeServlet
 */
@WebServlet("/trade")
public class TradeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PlayerDao playerDao = DaoFactory.createMemberDaoImpl();

		List<Player> myPlayers = playerDao.findMyTeamPlayers();
		request.setAttribute("myPlayers", myPlayers);

		List<Player> players = playerDao.findAllExceptMyTeam();

		// String strMoney = request.getParameter("money");
		// String strBatting = request.getParameter("batting");
		// String strDefense = request.getParameter("defense");
		//
		//// if (StringUtils.isBlank(strMoney) ) {
		// if (strMoney != null && !strMoney.isBlank()) {
		// int money = Integer.parseInt(strMoney);
		// players = players.stream().filter(e -> e.getSalary() <
		// money).collect(Collectors.toList());
		// }
		// if (strBatting != null && !strBatting.isBlank()) {
		// int batting = Integer.parseInt(strBatting);
		// players = players.stream().filter(e -> e.getSalary() >
		// batting).collect(Collectors.toList());
		// }
		// if (strDefense != null && !strDefense.isBlank()) {
		// int defense = Integer.parseInt(strDefense);
		// players = players.stream().filter(e -> e.getDefense() >
		// defense).collect(Collectors.toList());
		// }

		request.setAttribute("players", players);
		request.getRequestDispatcher("/WEB-INF/view/trade.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		PlayerDao playerDao = DaoFactory.createMemberDaoImpl();
		// うまくいかなかったやつ↓
//		String position;
//		if (arrayPosition == null) {
//			position = "%%";
//		} else {
//			position =  "%" + arrayPosition[0] + "%"  ;
//			for (int i = 1; i < arrayPosition.length; i++) {
//				position += (" OR players.position LIKE " + "%" + arrayPosition[i] + "%" );
//			}
//		}	
		String strMoneyB = request.getParameter("moneyB");

		if (strMoneyB != null) {

			String strMoneyT = request.getParameter("moneyT");
			int moneyB = Integer.parseInt(strMoneyB);
			int moneyT = Integer.parseInt(strMoneyT);

			String strBattingB = request.getParameter("battingB");
			String strBattingT = request.getParameter("battingT");
			int battingB = Integer.parseInt(strBattingB);
			int battingT = Integer.parseInt(strBattingT);

			String strDefenseB = request.getParameter("defenseB");
			String strDefenseT = request.getParameter("defenseT");
			int defenseB = Integer.parseInt(strDefenseB);
			int defenseT = Integer.parseInt(strDefenseT);

			String[] arrayPosition = request.getParameterValues("position");

			List<Player> players = playerDao.findTradePlayers(arrayPosition, moneyB, moneyT, battingB, battingT,
					defenseB, defenseT);
			request.setAttribute("players", players);

			List<Player> myPlayers = playerDao.findMyTeamPlayers();
			request.setAttribute("myPlayers", myPlayers);

			request.getRequestDispatcher("/WEB-INF/view/trade.jsp").forward(request, response);
			return;
		}
		
		String strGetPlayerId = request.getParameter("getPlayerId");
		String strReleasePlayerId = request.getParameter("releasePlayerId");

		int getPlayerId = Integer.parseInt(strGetPlayerId);
		int releasePlayerId = Integer.parseInt(strReleasePlayerId);

		Player getPlayer = playerDao.findPlayerById(getPlayerId);
		Player releasePlayer = playerDao.findPlayerById(releasePlayerId);

		session.setAttribute("getPlayer", getPlayer);
		session.setAttribute("releasePlayer", releasePlayer);

		response.sendRedirect(request.getContextPath() + "/tradeExe");

//		Integer myPlayerId = Integer.parseInt(strMyPlayerId);
//		Player releasePlayer = playerDao.findPlayerById(myPlayerId);
//		request.setAttribute("releasePlayer", releasePlayer);
//		//同じポジションの相手チームの選手を探す
//		List<Player> getPlayersByPosition = playerDao.findPlayersByPosition(releasePlayer.getPosition());
//		getPlayersByPosition = getPlayersByPosition.stream().filter(e -> e.getTeamId() != 5)
//				.collect(Collectors.toList());
//
//		request.setAttribute("getComPlayersByPosition", getPlayersByPosition);
//		request.getRequestDispatcher("/WEB-INF/view/trade.jsp").forward(request, response);
	}
}
