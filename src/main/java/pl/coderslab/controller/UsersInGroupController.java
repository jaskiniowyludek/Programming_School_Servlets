package pl.coderslab.controller;

import pl.coderslab.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "UsersInGroupController", urlPatterns = "/users")
public class UsersInGroupController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ArrayList<User> users = new ArrayList<>();
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            users = User.loadAllByGroupId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("users", users);
        getServletContext().getRequestDispatcher("/WEB-INF/usersInGroup.jsp").forward(request,response);
    }
}
