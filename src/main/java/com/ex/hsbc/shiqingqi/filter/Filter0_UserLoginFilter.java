package com.ex.hsbc.shiqingqi.filter;

import com.ex.hsbc.shiqingqi.entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Cliff
 */
@WebFilter(filterName = "Filter0_UserLoginFilter", urlPatterns = "/*")
public class Filter0_UserLoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        String servletPath = req.getServletPath();
        if (servletPath.contains(".jsp") || servletPath.contains("/login") || servletPath.contains("/register")) {
            chain.doFilter(req, resp);
        }

        User user = (User) req.getSession().getAttribute("user");
        if (user == null) {
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        } else {
            chain.doFilter(req, resp);
        }

    }

    @Override
    public void destroy() {

    }
}
