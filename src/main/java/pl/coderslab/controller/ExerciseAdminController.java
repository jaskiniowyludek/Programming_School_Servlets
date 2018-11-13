package pl.coderslab.controller;

import pl.coderslab.model.Exercise;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "ExerciseAdminController", urlPatterns = "/panelAdmin/exercises")
public class ExerciseAdminController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ArrayList<Exercise> exercises = new ArrayList<>();
        try {
            exercises = Exercise.loadAllExercise();
        }catch (SQLException e){
            e.printStackTrace();
        }
        request.setAttribute("exercises", exercises);
     getServletContext().getRequestDispatcher("/WEB-INF/admin/showExercises.jsp").forward(request,response);
    }
}
