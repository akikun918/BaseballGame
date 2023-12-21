package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AdminDao;
import dao.DaoFactory;
import domain.Admin;

/**
 * Servlet implementation class BuyPointServlet
 */
@WebServlet("/pointBuy")
public class PointBuyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("buyPoint") == null) {
			response.sendRedirect(request.getContextPath() + "/showPoint");
			return;
		}

		request.getRequestDispatcher("/WEB-INF/view/pointBuy.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		// ブラウザの戻るボタン対策
		if (session.getAttribute("buyPoint") == null) {
			response.sendRedirect(request.getContextPath() + "/showPoint");
			return;
		}

		String strNumber1 = request.getParameter("number1");
		String strNumber2 = request.getParameter("number2");
		String strNumber3 = request.getParameter("number3");
		String strNumber4 = request.getParameter("number4");
		try {
			int number1 = Integer.parseInt(strNumber1);
			int number2 = Integer.parseInt(strNumber2);
			int number3 = Integer.parseInt(strNumber3);
			int number4 = Integer.parseInt(strNumber4);

		} catch (Exception e) {
			request.setAttribute("error", "4桁の数字を入力してください");
			request.getRequestDispatcher("/WEB-INF/view/pointBuy.jsp").forward(request, response);
			return;
		}

		int buyPoint = (int) session.getAttribute("buyPoint");
		Admin admin = (Admin) session.getAttribute("admin");
		admin.setPoint(admin.getPoint() + buyPoint);
		session.setAttribute("admin", admin);

		AdminDao adminDao = DaoFactory.createAdminDaoImpl();
		// データベースへ保有するポイントを入れる
		adminDao.setAll(admin);

		session.setAttribute("noIllegalAccess", "");
		response.sendRedirect(request.getContextPath() + "/pointDone");

	}

}
