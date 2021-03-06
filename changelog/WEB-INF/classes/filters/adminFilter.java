package filters;

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

import changelog.User;

public class adminFilter implements Filter{
	private final String edit = "edit";
	public void destroy() {		
	}
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpReq =(HttpServletRequest)request;
		HttpServletResponse httpRes = (HttpServletResponse)response;
		HttpSession session = httpReq.getSession();
		//get the user
		User user = (User)session.getAttribute("user");
		//the use title is edit
		if(user.getTitle().equals(edit)){
			chain.doFilter(request, response);
		} else{
			request.getRequestDispatcher("/func/error_edit_user.jsp").forward(request, response);
			
		}
	}
	public void init(FilterConfig arg0) throws ServletException {
	}

}
