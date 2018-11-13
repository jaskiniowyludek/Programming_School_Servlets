package pl.coderslab.controller;

import pl.coderslab.model.Group;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AddGroupController", urlPatterns = "/panelAdmin/addGroup")
public class AddGroupController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String idS = request.getParameter("id");
        int id = 0;
        if (idS.equals("")){
            id = 0;
        }else {
            id=Integer.parseInt(idS);
        }
        try {
        if (id!=0){
            Group group = Group.loadGroupById(id);
            group.setName(request.getParameter("groupName"));
            group.saveToDB();
        }else {
            Group group = new Group();
            group.setName(request.getParameter("groupName"));
            group.saveToDB();
        }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/panelAdmin");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/WEB-INF/admin/groupForm.jsp").forward(request,response);
    }
}
