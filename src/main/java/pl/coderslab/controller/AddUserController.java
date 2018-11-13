package pl.coderslab.controller;

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

@WebServlet(name = "AddUserController", urlPatterns = "/panelAdmin/addUser")
public class AddUserController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = new User();
        user.setUsername(request.getParameter("userName"));
        user.setPassword(request.getParameter("password"));
        user.setEmail(request.getParameter("email"));
        user.setUser_group(Integer.parseInt(request.getParameter("userGroup")));
        try {
            user.saveToDB();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/panelAdmin/allUsers");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ArrayList<Group> groups = new ArrayList<>();
        try {
            groups = Group.loadAllGroups();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("groups", groups);
        getServletContext().getRequestDispatcher("/WEB-INF/admin/userFormAdd.jsp").forward(request,response);
    }
}
