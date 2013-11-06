package filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import changelog.User;

public class userTitleFilter implements Filter{
	private final String edit = "�༭";
	private final String make = "ʵʩ";
	public void destroy() {		
	}
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpReq =(HttpServletRequest)request;
		HttpSession session = httpReq.getSession();
		//get the user
		User user = (User)session.getAttribute("user");
		//the use title is
		if(user.getTitle().equals(edit) || user.getTitle().equals(make)){
			chain.doFilter(request, response);
		} else{
			
			request.getRequestDispatcher("/func/titleError.jsp").forward(request, response);
			return;
		}
	}
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
