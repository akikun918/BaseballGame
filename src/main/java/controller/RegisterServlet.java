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
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("admin") != null) {
			response.sendRedirect(request.getContextPath() + "/menu");
			return ;
		}
		
		request.getRequestDispatcher("/WEB-INF/view/register.jsp").forward(request, response);
	}
	 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();	
		//戻るボタン対策
		if(session.getAttribute("admin") != null) {
			response.sendRedirect(request.getContextPath() + "/menu");
			return ;
		}
		 
		String loginId = request.getParameter("loginId");
		String loginPass = request.getParameter("loginPass");
		Admin admin = new Admin(loginId, loginPass, 100, 2, 2);
		AdminDao adminDao = DaoFactory.createAdminDaoImpl();
		
		// すでに登録されているIDかブランクの場合発動
		if (!adminDao.register(admin)) {
			request.setAttribute("error", "別のIDとパスワードを試してください");
			request.getRequestDispatcher("/WEB-INF/view/register.jsp").forward(request, response);
			return;
		}
		
		session.setAttribute("admin", admin);
		session.setAttribute("loginId", loginId);

		// 登録したアカウント専用のテーブルを作成
		adminDao.createData(loginId);
		adminDao.load(loginId);

		response.sendRedirect(request.getContextPath() + "/registerDone");

	}

}
