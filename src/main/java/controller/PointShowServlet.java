package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.Admin;

/**
 * Servlet implementation class ShowPointServlet
 */
@WebServlet("/showPoint")
public class PointShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/view/pointShow.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		Admin admin = (Admin) session.getAttribute("admin");
		if (admin.getPoint() > 10000000) {
			request.setAttribute("error", "これ以上ポイントを購入できません");
			request.getRequestDispatcher("/WEB-INF/view/pointShow.jsp").forward(request, response);
			return;
		}

		String strBuyPoint = request.getParameter("point");
		try {
			int buyPoint = Integer.parseInt(strBuyPoint);
			if (buyPoint < 0) {
				request.setAttribute("error", "数値が範囲外です");
				request.getRequestDispatcher("/WEB-INF/view/pointShow.jsp").forward(request, response);
			} else if (buyPoint < 1000) {
				request.setAttribute("error", "1000ポイント以上から購入してください");
				request.getRequestDispatcher("/WEB-INF/view/pointShow.jsp").forward(request, response);
			} else {
				session.setAttribute("buyPoint", buyPoint);
				response.sendRedirect(request.getContextPath() + "/pointBuy");
			}
		} catch (NumberFormatException e) {
			request.setAttribute("error", "数値で入力してください");
			request.getRequestDispatcher("/WEB-INF/view/pointShow.jsp").forward(request, response);

		}

	}

}
