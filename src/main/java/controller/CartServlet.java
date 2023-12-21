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
import domain.Admin;
import domain.Item;
import service.ItemService;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
//
//		ItemDao itemDao = DaoFactory.createItemDaoImpl();
//		List<Item> items = itemDao.findAllItems();
//		
		if (session.getAttribute("items") == null) {
			session.setAttribute("error", "カートは空です");
			response.sendRedirect(request.getContextPath() + "/cartIndex");
			return;
		}
		
		request.getRequestDispatcher("/WEB-INF/view/cart.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		//戻るボタン対策
		if(session.getAttribute("items") == null) {
		response.sendRedirect(request.getContextPath() + "/menu");
		return ;
		}
		
		AdminDao adminDao = DaoFactory.createAdminDaoImpl();

		List<Item> items = (List<Item>) session.getAttribute("items");

		Admin admin = (Admin) session.getAttribute("admin");

		String strTotal = request.getParameter("total");
		int total = Integer.parseInt(strTotal);

		if ((admin.getPoint() - total) < 0) {
			request.setAttribute("error", "ポイントが足りません。ポイントを購入してください。");
			request.getRequestDispatcher("/WEB-INF/view/cart.jsp").forward(request, response);
			return;
		}
		admin.setPoint(admin.getPoint() - total);
		//adminデータベースに残った保有ポイントを入力する
		adminDao.setAll(admin);
		
		//adminデータベースにそれぞれのItemクラスの購入した個数を入れる
		for (Item item : items) {
			adminDao.setUnit(admin.getLoginId(), item );
		}
		//最終的なadminデータベース呼びたし、セッションに入れる
		admin = adminDao.findByLoginIdAndLoginPass(admin.getLoginId(), admin.getLoginPass());
		session.setAttribute("admin", admin);
		//カートをクリアする
		session.removeAttribute("items");
		ItemService.items.clear();

		response.sendRedirect(request.getContextPath() + "/cartDone");

	}

}
