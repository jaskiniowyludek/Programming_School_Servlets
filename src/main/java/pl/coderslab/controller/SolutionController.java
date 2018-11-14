package pl.coderslab.controller;

import pl.coderslab.dao.ExerciseDao;
import pl.coderslab.dao.SolutionDao;
import pl.coderslab.model.Exercise;
import pl.coderslab.model.Solution;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "SolutionController", urlPatterns = "/solution")
public class SolutionController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        ArrayList<Solution> solutions = new ArrayList<>();
        Exercise exercise = null;
        try {
            solutions = SolutionDao.loadAllByExerciseId(id);
            exercise = ExerciseDao.loadById(id);
            request.setAttribute("solutions", solutions);
            request.setAttribute("exercise", exercise);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        getServletContext().getRequestDispatcher("/WEB-INF/solution.jsp").forward(request,response);
    }
}
