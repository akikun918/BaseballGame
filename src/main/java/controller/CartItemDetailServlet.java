package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoFactory;
import dao.ItemDao;
import domain.Item;
import service.ItemService;

/**
 * Servlet implementation class ItemServlet
 */
@WebServlet("/cartItemDetail")
public class CartItemDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ItemDao itemDao = DaoFactory.createItemDaoImpl();
		String strId = request.getParameter("id");
		if (strId == null || strId.isBlank()) {
			response.sendRedirect(request.getContextPath() + "/cartIndex");
			return;
		}
		int id = 0;
		try {
			id = Integer.parseInt(strId);
		} catch (Exception e) {
			response.sendRedirect(request.getContextPath() + "/cartIndex");
			return;
		}
		if (id > itemDao.findAllItems().size()) {
			response.sendRedirect(request.getContextPath() + "/cartIndex");
			return;
		}

		ItemDao ItemDao = DaoFactory.createItemDaoImpl();
		Item item = ItemDao.findItemById(id);

		request.setAttribute("item", item);

		request.getRequestDispatcher("/WEB-INF/view/cartItemDetail.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		String strUnit = request.getParameter("unit");
		if (strUnit.isBlank()) {
			request.setAttribute("error", "正しい数量を入力してください");
			doGet(request, response);
			return ;
		}
		int unit = Integer.parseInt(strUnit);
		if (unit == 0 ) {
			request.setAttribute("error", "正しい数量を入力してください");
			doGet(request, response);
			return ;
		}
		
		String strId = request.getParameter("id");
		int id = Integer.parseInt(strId);

		ItemDao ItemDao = DaoFactory.createItemDaoImpl();
		Item item = ItemDao.findItemById(id);
		item.setUnit(unit);

		// 個数を入力したアイテムのリストを作成し、セッション（カート）に入れる
		List<Item> items = ItemService.getItemList(item);
		session.setAttribute("items", items);

		int total = item.getPrice() * unit;
		request.setAttribute("unit", unit);
		request.setAttribute("item", item);
		request.setAttribute("total", total);

		request.getRequestDispatcher("/WEB-INF/view/cartItemDetail.jsp").forward(request, response);
	}

}
