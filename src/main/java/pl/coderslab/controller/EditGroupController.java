package pl.coderslab.controller;

import pl.coderslab.model.Group;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "EditGroupController", urlPatterns = "/panelAdmin/editGroup")
public class EditGroupController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Group group = null;
        try {
            group = Group.loadGroupById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("group", group);
        getServletContext().getRequestDispatcher("/WEB-INF/admin/groupForm.jsp").forward(request,response);
    }
}
