package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import service.ScoresServise;

/**
 * Servlet Filter implementation class NoGameFilter
 */
@WebFilter("/*")
public class NoGameFilter extends HttpFilter implements Filter {

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		// HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession();

		String uri = req.getRequestURI();
		// 試合の途中で他のページに行った場合に試合のデータを全部消す
		if (!uri.endsWith("/game") && !uri.endsWith("/gameChangePitcher"))
		//			&& !uri.endsWith("/doping"))
		{
			session.removeAttribute("comTeam");
			ScoresServise.scores.clear();
			ScoresServise.comScores.clear();
			session.removeAttribute("pitcher");
			session.removeAttribute("pitchersInTheTeam");
			ScoresServise.pitchers.clear();
		}

		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
