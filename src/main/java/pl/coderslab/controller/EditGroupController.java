package pl.coderslab.controller;

import pl.coderslab.dao.GroupDao;
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

        int id = Integer.parseInt(request.getParameter("id"));
        try {
            Group group = GroupDao.loadGroupById(id);
            group.setName(request.getParameter("groupName"));
            GroupDao.updateGroup(group);
        }catch (SQLException e){
            e.printStackTrace();
        }
        response.sendRedirect("/panelAdmin/groups");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Group group = null;
        try {
            group = GroupDao.loadGroupById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("group", group);
        getServletContext().getRequestDispatcher("/WEB-INF/admin/groupFromEdit.jsp").forward(request,response);
    }
}
