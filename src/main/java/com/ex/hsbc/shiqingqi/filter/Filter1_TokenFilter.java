package com.ex.hsbc.shiqingqi.filter;

import com.ex.hsbc.shiqingqi.entity.Token;
import com.ex.hsbc.shiqingqi.util.TokenUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Cliff
 */
@WebFilter(filterName = "Filter1_TokenFilter", urlPatterns = "/*")
public class Filter1_TokenFilter implements Filter {
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


        Token token = (Token) req.getSession().getAttribute("token");
        if (token == null) {
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        } else {
            if (TokenUtil.verifyToken(token)) {
                chain.doFilter(req, resp);
            } else {
                req.getRequestDispatcher("index.jsp").forward(req, resp);
            }
        }
    }

    @Override
    public void destroy() {

    }
}
