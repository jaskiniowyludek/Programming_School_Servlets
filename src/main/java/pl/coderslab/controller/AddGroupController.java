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

        try {
            Group group = new Group();
            group.setName(request.getParameter("groupName"));
            group.saveToDB();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/panelAdmin/groups");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/WEB-INF/admin/groupFormAdd.jsp").forward(request,response);
    }
}
