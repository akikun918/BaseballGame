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
import dao.TeamDao;
import domain.Player;
import domain.Team;

/**
 * Servlet implementation class TeamDetailServlet
 */
@WebServlet("/teamDetail")
public class TeamDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String strId = request.getParameter("id");
		System.out.println(strId);
		if (strId == null) {
			response.sendRedirect(request.getContextPath() + "/playerList");
			return;
		}
		Integer id = Integer.parseInt(strId);

		PlayerDao playerDao = DaoFactory.createMemberDaoImpl();
		TeamDao teamDao = DaoFactory.createTeamDaoImpl();
		List<Team> teams = teamDao.findTeam();
		
		if (id > teams.size()) {
			response.sendRedirect(request.getContextPath() + "/playerList");
			return;
		}

		List<Player> players = playerDao.findPlayersByTeam(id);

		Player player = players.get(0);
		System.out.println(player.getId());
		request.setAttribute("player", player);
		request.setAttribute("players", players);
		request.getRequestDispatcher("/WEB-INF/view/teamDetail.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
