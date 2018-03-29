package ua.training.filter;

import ua.training.StringUtils;

import javax.servlet.*;
import java.io.IOException;

import static ua.training.Constants.*;
import static ua.training.filter.RegexContainer.REGEX_EMAIL;
import static ua.training.filter.RegexContainer.REGEX_NAME_LAT;

public class InputFormFilter implements Filter {
    private FilterConfig filterConfig;
    private boolean active = false;

    @Override
    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
        String act = filterConfig.getInitParameter(ACTIVE);
        if (act != null)
            active = (act.toUpperCase().equals(TRUE));
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        if (!active) {
            filterChain.doFilter(servletRequest, servletResponse);
        }
        String userName = servletRequest.getParameter(LOGIN_PARAMETER);
        String email = servletRequest.getParameter(EMAIL_PARAMETER);

        if (userName == null || email == null || !(userName.matches(REGEX_NAME_LAT) && email.matches(REGEX_EMAIL))) {
            servletRequest.setAttribute(MESSAGE, StringUtils.concatenate(INVALID_MESSAGE,
                    userName, UNEQUAL_SIGN, REGEX_NAME_LAT, SPACE_SIGN,
                    email, UNEQUAL_SIGN, REGEX_EMAIL));

            servletRequest.getRequestDispatcher(INDEX_PAGE).forward(servletRequest, servletResponse);
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }

    }

    @Override
    public void destroy() {
        filterConfig = null;
    }
}
