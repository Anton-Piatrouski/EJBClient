package by.epam.controller.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.epam.model.bean.User;

public class LoginFilter implements Filter {
	@Override
	public void init(FilterConfig config) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession();
		User user = (User) session.getAttribute("user");
		
		if (user == null) {
			session.invalidate();
			HttpServletResponse httpResponse = (HttpServletResponse) response;
			httpResponse.sendRedirect("HomePage.do");
			return;
		}
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		
	}
}
