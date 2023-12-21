package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.Player;

/**
 * Servlet implementation class CreateDoneServlet
 */
@WebServlet("/createDone")
public class CreateDoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("createdPlayer") == null) {
			response.sendRedirect(request.getContextPath() + "/menu");
			return;
		}
		Player createdPlayer = (Player) session.getAttribute("createdPlayer");
		request.setAttribute("createdPlayer", createdPlayer);
		session.removeAttribute("createdPlayer");

		request.getRequestDispatcher("/WEB-INF/view/createDone.jsp").forward(request, response);
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
