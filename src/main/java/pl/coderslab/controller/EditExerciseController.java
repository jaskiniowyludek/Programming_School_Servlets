package pl.coderslab.controller;

import pl.coderslab.model.Exercise;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "EditExerciseController", urlPatterns = "/panelAdmin/editExercise")
public class EditExerciseController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        try {
            Exercise exercise = Exercise.loadById(id);
            exercise.setTitle(request.getParameter("title"));
            exercise.setDescription(request.getParameter("description"));
            exercise.saveToDB();
        }catch (SQLException e){
            e.printStackTrace();
        }
        response.sendRedirect("/panelAdmin/exercises");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Exercise exercise = null;
        try {
            exercise = Exercise.loadById(id);
        }catch (SQLException e){
            e.printStackTrace();
        }
        request.setAttribute("exercise", exercise);
        getServletContext().getRequestDispatcher("/WEB-INF/admin/exerciseFormEdit.jsp").forward(request,response);
    }
}
