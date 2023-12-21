package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.Admin;

/**
 * Servlet implementation class CreateCharaServlet
 */
@WebServlet("/createChara")
public class CreateCharaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		//年に99999年などを入力した場合、createCharaExecuteServretのpostの
		//playerDao.createPlayer(createdPlayer)からここに跳ね返ってくる
		request.setAttribute("errorBirthday", session.getAttribute("errorBirthday"));
		session.removeAttribute("errorBirthday");

		request.getRequestDispatcher("/WEB-INF/view/createChara.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		String name = request.getParameter("name");
		String position = request.getParameter("position");
		String birthday = request.getParameter("birthday");
		boolean isValid = true;

		if (name.isBlank() || name.length() > 15) {
			request.setAttribute("errorName", "名前は1～15文字以内の文字で入力してください");
			isValid = false;
		}

		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat("y-MM-dd");
		try {
			date = sdf.parse(birthday);
		} catch (ParseException e) {
			isValid = false;
			request.setAttribute("errorBirthday", "誕生日の入力に不備があります");
			System.out.println(1231653);
			e.printStackTrace();
		}

		Admin admin = (Admin) session.getAttribute("admin");
		if (admin.getPoint() - 1000 < 0) {
			request.setAttribute("errorPoint", "ポイントが足りません");
			isValid = false;
		}
		if (!isValid) {
			request.getRequestDispatcher("/WEB-INF/view/createChara.jsp").forward(request, response);
			return;
		}

		session.setAttribute("name", name);
		session.setAttribute("position", position);
		session.setAttribute("date", date);
		
		response.sendRedirect(request.getContextPath() + "/createCharaExecute");
		
	}

}
