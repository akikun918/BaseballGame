package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.Scores;

/**
 * Servlet implementation class GameServlet
 */
@WebServlet("/game")
public class GameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		
		
		
		
		request.getRequestDispatcher("/WEB-INF/view/game.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		int score = Scores.getScore();
		Scores.addScore(score);
		List<Integer> scores = Scores.scores;

		int comScore = Scores.getScore();
		Scores.addComScore(comScore);
		List<Integer> comScores = Scores.comScores;

		session.setAttribute("scores", scores);
		session.setAttribute("comScores", comScores);
		
		if (scores.size() > 8) {
			int total = Scores.getTotal();
			int comTotal = Scores.getComTotal();
			session.setAttribute("total", total);
			session.setAttribute("comTotal", comTotal);
			if(total > comTotal) {
				session.setAttribute("result", "You Win!!");
			}else {
				session.setAttribute("result", "You lose!!");
			}
		}

		if (scores.size() > 9) {
			session.invalidate();
			response.sendRedirect("game");
			return;
		}
		
	request.getRequestDispatcher("/WEB-INF/view/game.jsp").forward(request, response);
	}

}
