package controller;

import java.io.IOException;
import java.util.Date;

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
 * Servlet implementation class CreateCharaExecuteServlet
 */
@WebServlet("/createCharaExecute")
public class CreateCharaExecuteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("name") == null) {
			response.sendRedirect(request.getContextPath() + "/createChara");
			return;
		}

		request.getRequestDispatcher("/WEB-INF/view/createCharaExecute.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		//もどるボタン対策
		if (session.getAttribute("name") == null) {
			response.sendRedirect(request.getContextPath() + "/menu");
			return;
		}

		String name = (String) session.getAttribute("name");
		String position = (String) session.getAttribute("position");
		Date date = (Date) session.getAttribute("date");

		//		Date date = null;
		//		SimpleDateFormat sdf = new SimpleDateFormat("y-MM-dd");
		//		try {
		//			date = sdf.parse(birthday);
		//		} catch (ParseException e) {
		//			e.printStackTrace();
		//		}

		Admin admin = (Admin) session.getAttribute("admin");

		double ofense = Math.random();
		if (ofense < 0.5) {
			ofense = 5;
		} else if (ofense < 0.7) {
			ofense = 6;
		} else if (ofense < 0.9) {
			ofense = 4;
		} else if (ofense < 0.95) {
			ofense = 7;
		} else {
			ofense = 3;
		}

		double defense = Math.random();
		if (defense < 0.5) {
			defense = 5;
		} else if (defense < 0.7) {
			defense = 6;
		} else if (defense < 0.9) {
			defense = 4;
		} else if (defense < 0.95) {
			defense = 7;
		} else {
			defense = 3;
		}

		double stamina = Math.random();
		if (stamina < 0.5) {
			stamina = 5;
		} else if (stamina < 0.7) {
			stamina = 6;
		} else if (stamina < 0.9) {
			stamina = 4;
		} else if (stamina < 0.95) {
			stamina = 7;
		} else {
			stamina = 3;
		}

		Player createdPlayer = Player.builder().name(name).birthday(date).position(position)
				.battingAverage((int) ofense).defense((int) defense).stamina((int) stamina).build();

		PlayerDao playerDao = DaoFactory.createMemberDaoImpl();

		if (!playerDao.createPlayer(createdPlayer)) {
			//	request.setAttribute("errorBirthday", "誕生日の入力に不備があります");
			session.setAttribute("errorBirthday", "申し訳ありませんが再度入力をお願いいたします。");
			response.sendRedirect(request.getContextPath() + "/createChara");
			return;
		}

		// データベースからポイントを引く
		AdminDao adminDao = DaoFactory.createAdminDaoImpl();
		admin.setPoint(admin.getPoint() - 1000);
		adminDao.setAll(admin);
		session.setAttribute("admin", admin);

		session.setAttribute("createdPlayer", createdPlayer);

		session.removeAttribute("name");
		session.removeAttribute("position");
		session.removeAttribute("date");

		response.sendRedirect(request.getContextPath() + "/createDone");
	}
}
