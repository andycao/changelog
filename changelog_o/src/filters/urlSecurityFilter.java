package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import changelog.User;
import com.opensymphony.xwork2.ActionContext;


public class urlSecurityFilter implements Filter{

	public void destroy() {
		
	}
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpReq =(HttpServletRequest)request;
		HttpServletResponse httpRes = (HttpServletResponse)response;
		HttpSession session = httpReq.getSession();
		//get the user
		User user = (User)session.getAttribute("user");
		if(user == null){
			//request.getRequestDispatcher("/index.jsp").forward(request, response);
			//frame page redirect
			java.io.PrintWriter out = response.getWriter();  
		    out.println("<html>");
		    out.println("<script>");  
		    out.println("window.open ('/changelog/index.jsp','_top')");  
		    out.println("</script>");  
		    out.println("</html>"); 
			return;
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig arg0) throws ServletException {
		
	}
}
