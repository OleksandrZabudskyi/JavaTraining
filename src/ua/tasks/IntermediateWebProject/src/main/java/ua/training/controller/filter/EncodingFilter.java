package ua.training.controller.filter;


import javax.servlet.*;
import java.io.IOException;

import static ua.training.Constants.*;

public class EncodingFilter implements Filter {
    private boolean active = false;

    @Override
    public void init(FilterConfig filterConfig) {
        String act = filterConfig.getInitParameter(ACTIVE);
        if (act != null)
            active = (act.toUpperCase().equals(TRUE));
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        if (!active) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            servletResponse.setContentType("text/html");
            servletResponse.setCharacterEncoding("UTF-8");
            servletRequest.setCharacterEncoding("UTF-8");
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {
    }
}
