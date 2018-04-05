package ua.training.controller.filter;

import javax.servlet.*;
import java.io.IOException;

import static ua.training.Constants.*;
import static ua.training.controller.filter.RegexContainer.REGEX_DOUBLE;

public class SearchFormFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        String action = servletRequest.getParameter(ACT);
        String price = servletRequest.getParameter(PRICE);
        String risk = servletRequest.getParameter(RISK);
        boolean invalidData = (price == null || risk == null
                || !(price.matches(REGEX_DOUBLE) && price.matches(REGEX_DOUBLE)));

        if (FIND.equals(action) && invalidData) {
            servletRequest.setAttribute(MESSAGE, INVALID_MESSAGE);
            servletRequest.getRequestDispatcher(INDEX_PAGE).forward(servletRequest, servletResponse);
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {
    }
}
