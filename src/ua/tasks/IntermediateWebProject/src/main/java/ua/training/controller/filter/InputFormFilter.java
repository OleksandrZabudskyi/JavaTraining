package ua.training.controller.filter;

import javax.servlet.*;
import java.io.IOException;

import static ua.training.Constants.*;
import static ua.training.StringUtils.concatenate;
import static ua.training.controller.filter.RegexContainer.REGEX_DOUBLE;

public class InputFormFilter implements Filter{
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
        String action = servletRequest.getParameter("act");

        if (!active || !FIND.equals(action)) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            String price = servletRequest.getParameter("price");
            String  risk = servletRequest.getParameter("risk");
            if (price == null || risk == null ||
                    !(price.matches(REGEX_DOUBLE) && price.matches(REGEX_DOUBLE))) {
                servletRequest.setAttribute(MESSAGE, concatenate(INVALID_MESSAGE, REGEX_DOUBLE));

                servletRequest.getRequestDispatcher(INDEX_PAGE).forward(servletRequest, servletResponse);
            } else {
                filterChain.doFilter(servletRequest, servletResponse);
            }
        }


    }

    @Override
    public void destroy() {
    }
}
