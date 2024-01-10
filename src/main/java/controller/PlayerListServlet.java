package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFactory;
import dao.PlayerDao;
import domain.Player;

/**
 * Servlet implementation class PlayerListServlet
 */
@WebServlet("/playerList")
public class PlayerListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PlayerDao playerDao = DaoFactory.createMemberDaoImpl();
		List<Player> players = playerDao.findAll();

		request.setAttribute("players", players);

		request.getRequestDispatcher("/WEB-INF/view/playerList.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String strTeamId = request.getParameter("teamId");
		String position = request.getParameter("position");
		String name = request.getParameter("name");
		PlayerDao playerDao = DaoFactory.createMemberDaoImpl();

		if (strTeamId != null) {
			Integer teamId = Integer.parseInt(strTeamId);
			List<Player> playersByTeam = playerDao.findPlayersByTeam(teamId);
			request.setAttribute("playersByTeam", playersByTeam);
		} else if (position != null) {
			List<Player> playersByPosition = playerDao.findPlayersByPosition(position);
			request.setAttribute("playersByPosition", playersByPosition);
		} else {
			List<Player> findPlayersByName = playerDao.findPlayersByName(name);
			request.setAttribute("findPlayersByName", findPlayersByName);
		}
		request.getRequestDispatcher("/WEB-INF/view/playerList.jsp").forward(request, response);

	}
}