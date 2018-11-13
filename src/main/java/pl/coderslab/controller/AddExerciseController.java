package pl.coderslab.controller;

import pl.coderslab.model.Exercise;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AddExerciseController", urlPatterns = "/panelAdmin/addExercise")
public class AddExerciseController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Exercise exercise = new Exercise();
            exercise.setTitle(request.getParameter("title"));
            exercise.setDescription(request.getParameter("description"));
            exercise.saveToDB();
        }catch (SQLException e){
            e.printStackTrace();
        }
        response.sendRedirect("/panelAdmin/exercises");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/WEB-INF/admin/exerciseFormAdd.jsp").forward(request,response);
    }
}
