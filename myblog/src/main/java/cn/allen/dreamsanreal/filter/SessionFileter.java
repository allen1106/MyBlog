package cn.allen.dreamsanreal.filter;

import cn.allen.dreamsanreal.common.Constants;
import cn.allen.dreamsanreal.model.User;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@WebFilter(filterName = "sessionFilter", urlPatterns = {"/*"})
public class SessionFileter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest hrequest = (HttpServletRequest) servletRequest;
        HttpServletResponse hresp = (HttpServletResponse) servletResponse;

        String uri = hrequest.getRequestURI();
        if ("".equals(uri)
                || uri.indexOf("/admin/login") != -1
                || uri.endsWith("png")
                || uri.endsWith("css")
                || uri.endsWith("js")
                || uri.endsWith("ico")
                || uri.endsWith("html")
                || uri.endsWith("ttf")
                || uri.endsWith("woff")) {
            filterChain.doFilter(hrequest, hresp);
        } else {
            User user = (User) hrequest.getSession().getAttribute(Constants.USER);
            if (user != null) {
                filterChain.doFilter(hrequest, hresp);
            } else {
                String requestMethod = hrequest.getMethod().toUpperCase();
                if (requestMethod.equals(Constants.RequestMethod.GET)) {
                    String go = uri;
                    String queryString = hrequest.getQueryString();

                    if (!StringUtils.isEmpty(queryString)) {
                        go = go + "#" + queryString;
                    }
                    hresp.sendRedirect(hrequest.getContextPath() + "/admin/login?go=" + go);
                } else {
                    hresp.sendRedirect(hrequest.getContextPath() + "/admin/login");
                }
            }
        }
    }

    @Override
    public void destroy() {

    }
}
