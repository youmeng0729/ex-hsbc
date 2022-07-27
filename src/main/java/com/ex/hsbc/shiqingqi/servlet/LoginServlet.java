package com.ex.hsbc.shiqingqi.servlet;

import com.ex.hsbc.shiqingqi.data.UserRepo;
import com.ex.hsbc.shiqingqi.data.UserRoleRepo;
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

/**
 * @author Cliff
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        UserRepo userRepo = new UserRepo();
        User user = userRepo.getUser(userName);
        if (user == null || (!user.getPassword().equals(password))) {
            req.getSession().setAttribute("token", null);

            req.getSession().setAttribute("user", null);
            if (user == null) {
                // user not in the list, need register
                req.getRequestDispatcher("register.jsp").forward(req, resp);
            } else {
                // user not in the list, need register
                req.getRequestDispatcher("login.jsp").forward(req, resp);
            }

        } else {
            User loginUser = new User();
            loginUser.setUserName(userName).setPassword(password);

            ServletContext servletContext = getServletContext();

            Token token = TokenUtil.create(servletContext, loginUser);
            req.getSession().setAttribute("token", token);

            req.getSession().setAttribute("user", loginUser);

            UserRoleRepo userRoleRepo = new UserRoleRepo();
            req.setAttribute("roles", userRoleRepo.roles(loginUser));

            req.getRequestDispatcher("user.jsp").forward(req, resp);
        }


    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}

