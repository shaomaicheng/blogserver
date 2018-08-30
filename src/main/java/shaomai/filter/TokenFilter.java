package shaomai.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import shaomai.Log;

import javax.servlet.*;
import java.io.IOException;


public class TokenFilter implements Filter {

    @Autowired
    private Log logger;

    @Override
    public void init(javax.servlet.FilterConfig filterConfig) {

        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, filterConfig.getServletContext());
        logger.debug("TokenFilter init");

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
