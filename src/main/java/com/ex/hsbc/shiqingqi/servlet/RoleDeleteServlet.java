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
@WebServlet("/deleteRole")
public class RoleDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取request域中共享的user对象

        User user = (User) req.getSession().getAttribute("user");
        String roleVal = req.getParameter("roleVal");

        UserRoleRepo userRoleRepo = new UserRoleRepo();
        if (userRoleRepo.delete(user, roleVal)) {
            req.setAttribute("roles", userRoleRepo.roles(user));
            req.getRequestDispatcher("user.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
