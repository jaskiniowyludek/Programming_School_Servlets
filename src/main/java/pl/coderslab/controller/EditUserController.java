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

@WebServlet(name = "EditUserController", urlPatterns = "/panelAdmin/editUser")
public class EditUserController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        try {
            User user = User.loadUserById(id);
            user.setUsername(request.getParameter("userName"));
            user.setEmail(request.getParameter("email"));
            user.setPassword(request.getParameter("password"));
            user.setUser_group(Integer.parseInt(request.getParameter("userGroup")));
            user.saveToDB();
        }catch (SQLException e){
            e.printStackTrace();
        }
        response.sendRedirect("/panelAdmin/allUsers");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        User user = null;
        ArrayList<Group> groups = new ArrayList<>();
        try {
            user = User.loadUserById(id);
            groups = Group.loadAllGroups();
        }catch (SQLException e){
            e.printStackTrace();
        }
        request.setAttribute("user",user);
        request.setAttribute("groups", groups);
        getServletContext().getRequestDispatcher("/WEB-INF/admin/userFormEdit.jsp").forward(request,response);
    }
}
