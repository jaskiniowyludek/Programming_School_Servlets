package pl.coderslab.controller;

import pl.coderslab.model.Solution;
import pl.coderslab.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "UserController", urlPatterns = "/userDetails")
public class UserController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        User user = null;
        ArrayList<Solution> solutions = new ArrayList<>();
        try {
            user= User.loadUserById(id);
            solutions = Solution.loadAllByUserId(id);
        }catch (SQLException e){
            e.printStackTrace();
        }
        request.setAttribute("user", user);
        request.setAttribute("solutions", solutions);
        getServletContext().getRequestDispatcher("/WEB-INF/user.jsp").forward(request,response);
    }
}
