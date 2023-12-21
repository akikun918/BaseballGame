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
import dao.TeamDao;
import domain.Admin;
import domain.Team;
import service.ScoresServise;

/**
 * Servlet implementation class GameServlet
 */
@WebServlet("/game")
public class GameServlet extends HttpServlet {
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

		float leftStamina = (float) (((int) (ScoresServise.leftStamina * 10)) / 10.0);
		request.setAttribute("leftStamina", "残りの体力 " + leftStamina);

		request.setAttribute("scores", ScoresServise.scores);
		request.setAttribute("comScores", ScoresServise.comScores);
		
		
		System.out.println(ScoresServise.myOffense);
		System.out.println(ScoresServise.comOffense);
		System.out.println(ScoresServise.myDefense);
		System.out.println(ScoresServise.comDefense);
		
		request.getRequestDispatcher("/WEB-INF/view/game.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		//戻るボタン対策
		if (session.getAttribute("comTeam") == null) {
			response.sendRedirect(request.getContextPath() + "/preGame");
			return;
		}
		// PlayerDao playerDao = DaoFactory.createMemberDaoImpl();
		AdminDao adminDao = DaoFactory.createAdminDaoImpl();
		TeamDao teamDao = DaoFactory.createTeamDaoImpl();
		Admin admin = (Admin) session.getAttribute("admin");

		// エナジードリンクを使った場合
		if (request.getParameter("drink") != null) {

			ScoresServise.leftStamina += 5;
			
			admin.setDrink(admin.getDrink() - 1);
			adminDao.setAll(admin);
			session.setAttribute("admin", admin);
		}

		// ピッチャーの残りのstaminaを取り出す
		float leftStamina = ScoresServise.getLeftStamina();
		leftStamina = (float) (((int) (leftStamina * 10)) / 10.0);

		request.setAttribute("leftStamina", "残りの体力 " + leftStamina);

		// 自分のすべての回の得点を格納しているList
		List<Integer> scores = ScoresServise.setScore();
		// 試合終了後のF5対策
		if (scores.size() > 9) {
			if (request.getParameter("drink") != null) {
				admin.setDrink(admin.getDrink() + 1);
				adminDao.setAll(admin);
				session.setAttribute("admin", admin);
			}
			response.sendRedirect(request.getContextPath() + "/menu");
			return;
		}
		// 相手のすべての回の得点を格納しているList
		List<Integer> comScores = ScoresServise.setComScore();

		request.setAttribute("scores", scores);
		request.setAttribute("comScores", comScores);

		// 9回終了時の合計得点と勝ち負けをセッションに入れる
		if (scores.size() == 9) {
			int total = ScoresServise.getTotal();
			int comTotal = ScoresServise.getComTotal();
			request.setAttribute("total", ScoresServise.getTotal());
			request.setAttribute("comTotal", ScoresServise.getComTotal());
			if (total > comTotal) {				
				admin.setPoint(admin.getPoint() + 100);
				session.setAttribute("admin", admin);
				adminDao.setAll(admin);
				teamDao.addWin(5);
				request.setAttribute("result", "You Win!! 100Pゲット! " + "合計" + admin.getPoint() + "P");
			} else if (total == comTotal) {
				request.setAttribute("result", "Draw");
			} else {
				request.setAttribute("result", "You lose!!");
				Team comTeam = (Team) session.getAttribute("comTeam");
				teamDao.addWin(comTeam.getId());
			}
			
			//トレーニングサーブレットで使う
			session.setAttribute("trainning","1" );
		}

		request.getRequestDispatcher("/WEB-INF/view/game.jsp").forward(request, response);

	}
}