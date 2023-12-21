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

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/cartIndex")
public class CartIndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		HttpSession session = request.getSession();
		ItemDao itemDao = DaoFactory.createItemDaoImpl();
		List<Item> items = itemDao.findAllItems();
		request.setAttribute("items", items);

		HttpSession session = request.getSession();
		
		//カートが空の時にカートを見ようとした場合ここに帰ってくる
		if(session.getAttribute("error") != null) {
			String error = (String) session.getAttribute("error");
			request.setAttribute("error", error);
			session.removeAttribute("error");
		}
		
		request.getRequestDispatcher("/WEB-INF/view/cartIndex.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
