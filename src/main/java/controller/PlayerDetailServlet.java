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
 * Servlet implementation class PlayerDetail
 */
@WebServlet("/playerDetail")
public class PlayerDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String strId = request.getParameter("id");

		PlayerDao playerDao = DaoFactory.createMemberDaoImpl();
		List<Player> players = playerDao.findAll();

		if (strId == null) {
			response.sendRedirect(request.getContextPath() + "/playerList");
			return;
		}
		Integer id = Integer.parseInt(strId);
		
		if (id > players.size() +10 ) {
			response.sendRedirect(request.getContextPath() + "/playerList");
			return;
		}
		
		Player player = playerDao.findPlayerById(id);
		request.setAttribute("player", player);
		request.getRequestDispatcher("/WEB-INF/view/playerDetail.jsp").forward(request, response);

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
