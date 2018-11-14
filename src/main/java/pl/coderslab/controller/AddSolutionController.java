package pl.coderslab.controller;

import pl.coderslab.dao.ExerciseDao;
import pl.coderslab.dao.SolutionDao;
import pl.coderslab.dao.UserDao;
import pl.coderslab.model.Exercise;
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
import java.util.Date;

@WebServlet(name = "AddSolutionController", urlPatterns = "/panelAdmin/addSolution")
public class AddSolutionController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("userId"));
        int eID = Integer.parseInt(request.getParameter("solution"));
        try {
            User user =  UserDao.loadUserById(id);
            Exercise exercise = ExerciseDao.loadById(eID);
            Solution solution = new Solution();
            solution.setUser_id(id);
            solution.setUsername(user.getUsername());
            solution.setExerciseTitle(exercise.getTitle());
            solution.setExercise(exercise.getId());
            SolutionDao.addSolution(solution);
        }catch (SQLException e){
            e.printStackTrace();
        }
    response.sendRedirect("/panelAdmin/allUsers");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        User user = null;
        ArrayList<Exercise> exercises = new ArrayList<>();
        try {
            exercises=ExerciseDao.loadAllExercise();
            user = UserDao.loadUserById(id);
        }catch (SQLException e){
            e.printStackTrace();
        }
        request.setAttribute("exercises", exercises);
        request.setAttribute("user", user);
        getServletContext().getRequestDispatcher("/WEB-INF/admin/solutionFrom.jsp").forward(request,response);
    }
}
