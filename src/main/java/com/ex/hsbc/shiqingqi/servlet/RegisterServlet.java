package com.ex.hsbc.shiqingqi.servlet;

import com.ex.hsbc.shiqingqi.data.UserRepo;
import com.ex.hsbc.shiqingqi.entity.Token;
import com.ex.hsbc.shiqingqi.entity.User;
import com.ex.hsbc.shiqingqi.util.TokenUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

/**
 * @author Cliff
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    UserRepo userRepo = new UserRepo();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        User user = userRepo.getUser(userName);
        if (user != null) {
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        } else {
            user = new User();
            user.setPassword(password).setUserName(userName);
            if (userRepo.create(user)) {
                req.getSession().setAttribute("user", user);
                req.setAttribute("roles", Collections.emptySet());
                ServletContext servletContext = getServletContext();
                Token token = TokenUtil.create(servletContext, user);
                req.getSession().setAttribute("token", token);
                req.getRequestDispatcher("user.jsp").forward(req, resp);
            } else {
                req.getRequestDispatcher("error.jsp").forward(req, resp);
            }
        }


    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}

