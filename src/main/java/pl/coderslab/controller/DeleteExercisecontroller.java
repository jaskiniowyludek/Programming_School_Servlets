package pl.coderslab.controller;

import pl.coderslab.dao.ExerciseDao;
import pl.coderslab.model.Exercise;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "DeleteExercisecontroller", urlPatterns = "/panelAdmin/deleteExercise")
public class DeleteExercisecontroller extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Exercise exercise = null;
        try {
            exercise = ExerciseDao.loadById(id);
            ExerciseDao.deleteExercise(exercise);
        }catch (SQLException e){
            e.printStackTrace();
        }
        response.sendRedirect("/panelAdmin/exercises");
    }
}
