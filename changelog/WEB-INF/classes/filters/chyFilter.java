package filters;

import java.io.IOException;
import changelog.User;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class chyFilter implements Filter {

	public chyFilter() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpReq =(HttpServletRequest)request;
		HttpSession session = httpReq.getSession();
		User user = (User)session.getAttribute("user");
		if(user.getTitle().equals("edit") || user.getTitle().equals("make"))
			chain.doFilter(request, response);
		else
			request.getRequestDispatcher("/func/error_edit_user.jsp").forward(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
