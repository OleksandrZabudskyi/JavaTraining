package ua.training.controller.filter;

import ua.training.util.AttributeConstant;
import ua.training.util.PageConstant;

import javax.servlet.*;
import java.io.IOException;

import static ua.training.util.MassageConstant.*;
import static ua.training.controller.filter.RegexContainer.REGEX_DOUBLE;

public class SearchFormFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        String action = servletRequest.getParameter(AttributeConstant.ACT);
        String price = servletRequest.getParameter(AttributeConstant.PRICE);
        boolean invalidData = (price == null || !(price.matches(REGEX_DOUBLE)));

        if (FIND.equals(action) && invalidData) {
            servletRequest.setAttribute(MESSAGE, INVALID_MESSAGE);
            servletRequest.getRequestDispatcher(PageConstant.INDEX_PAGE).forward(servletRequest, servletResponse);
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {
    }
}
