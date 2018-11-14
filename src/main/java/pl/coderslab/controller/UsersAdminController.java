package pl.coderslab.controller;

import pl.coderslab.dao.UserDao;
import pl.coderslab.model.Group;
import pl.coderslab.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "UsersAdminController", urlPatterns = "/panelAdmin/allUsers")
public class UsersAdminController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ArrayList<User> users = new ArrayList<>();
        try {
            users = UserDao.loadAllUsers();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("users", users);
        getServletContext().getRequestDispatcher("/WEB-INF/admin/showUsers.jsp").forward(request,response);
    }
}
