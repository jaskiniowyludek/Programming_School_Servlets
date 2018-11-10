package pl.coderslab.controller;

import pl.coderslab.model.Group;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "GroupController", urlPatterns = "/group")
public class GroupController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ArrayList<Group> groups = new ArrayList<>();
        try {
            groups = Group.loadAllGroups();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("groups", groups);
        getServletContext().getRequestDispatcher("/WEB-INF/groups.jsp").forward(request,response);
    }
}
