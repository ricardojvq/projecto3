package projecto3.grupo3.rafaelaricardo;

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

public class LoginRedirect implements Filter
{
	private FilterConfig customedFilterConfig;

	public void init(FilterConfig customedFilterConfig) throws ServletException {
		this.customedFilterConfig = customedFilterConfig;
	}

	public void doFilter(ServletRequest req, ServletResponse resp,FilterChain chain) throws IOException, ServletException
	{

		if (((HttpServletRequest)req).getSession().getAttribute(LoggedUser.AUTH_KEY) != null) {
			((HttpServletResponse)resp).sendRedirect("/Projecto3/Authorized/calc1.xhtml");
		} else {
			chain.doFilter(req, resp);
		}
	}

	public void destroy()
	{
		customedFilterConfig = null;
	}
}