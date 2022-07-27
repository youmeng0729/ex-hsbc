package com.ex.hsbc.shiqingqi.servlet;

import com.ex.hsbc.shiqingqi.data.UserRoleRepo;
import com.ex.hsbc.shiqingqi.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Cliff
 */
@WebServlet("/user")
public class UserServlet  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取request域中共享的user对象

        User user = (User) req.getSession().getAttribute("user");


        UserRoleRepo userRoleRepo = new UserRoleRepo();
        req.setAttribute("roles", userRoleRepo.roles(user));
        req.getRequestDispatcher("user.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
