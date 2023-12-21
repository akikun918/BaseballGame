package controller;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoFactory;
import dao.PlayerDao;
import domain.Player;
import service.TrainningServise;

/**
 * Servlet implementation class TrainningServlet
 */
@WebServlet("/trainning")
public class TrainningServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		if (session.getAttribute("trainning") == null || session.getAttribute("trainningKind") == null) {
			response.sendRedirect(request.getContextPath() + "/menu");
			return;
		}

		// トレーニングは一試合毎にしか行えないため
		session.removeAttribute("trainning");

		request.getRequestDispatcher("/WEB-INF/view/trainning.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		//戻る対策
		if (session.getAttribute("trainningPlayer") == null ) {
			response.sendRedirect(request.getContextPath() + "/menu");
			return;
		}
		
		List<String> results = TrainningServise.returnResults();

		if (results.size() > 5) {
			String trainningKind = (String) session.getAttribute("trainningKind");
			Player trainningPlayer = (Player) session.getAttribute("trainningPlayer");
			PlayerDao playerDao = DaoFactory.createMemberDaoImpl();

			results = results.stream().filter(e -> e.equals("成功")).collect(Collectors.toList());

			if (trainningKind.equals("1")) {
				if (results.size() >= trainningPlayer.getBattingAverage() - 4) {
					trainningPlayer.setBattingAverage(trainningPlayer.getBattingAverage() + 1);
					session.setAttribute("result", "バッティングが1上がりました！");
				} else {
					session.setAttribute("result", "特にトレーニングの成果はありませんでした");
				}
			} else {
				if (results.size() >= trainningPlayer.getDefense() - 4) {
					trainningPlayer.setDefense(trainningPlayer.getDefense() + 1);
					session.setAttribute("result", "守備が1上がりました！");
				} else {
					session.setAttribute("result", "特にトレーニングの成果はありませんでした");
				}
			}
			playerDao.setPlayer(trainningPlayer);
			TrainningServise.results.clear();
			response.sendRedirect(request.getContextPath() + "/trainningDone");
			return;
		}		

		request.setAttribute("results", results);
		request.getRequestDispatcher("/WEB-INF/view/trainning.jsp").forward(request, response);

	}

}
