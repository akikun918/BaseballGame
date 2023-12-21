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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("dontRepeatSetFeel");
		request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String loginId = request.getParameter("loginId");
		String loginPass = request.getParameter("loginPass");
		AdminDao adminDao = DaoFactory.createAdminDaoImpl();
		Admin admin = adminDao.findByLoginIdAndLoginPass(loginId, loginPass);
		if (admin != null) {
			session.setAttribute("admin", admin);
			session.setAttribute("loginId", loginId);
			adminDao.load(loginId);
			
			response.sendRedirect("menu");
		} else {
			request.setAttribute("error", "ログイン ID かパスワードが正しくありません");
			request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
		}
	}

}
