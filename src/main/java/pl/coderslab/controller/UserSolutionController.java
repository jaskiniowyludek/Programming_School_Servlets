package pl.coderslab.controller;

import pl.coderslab.dao.SolutionDao;
import pl.coderslab.model.Solution;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "UserSolutionController", urlPatterns = "/addSolutionToExercise")
public class UserSolutionController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Solution solution = null;
        try{
            solution= SolutionDao.loadById(id);
            solution.setDescription(request.getParameter("description"));
            SolutionDao.updateSolution(solution);
        }catch (SQLException e){
            e.printStackTrace();
        }
        response.sendRedirect("/group");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Solution solution = null;
        try{
            solution= SolutionDao.loadById(id);
        }catch (SQLException e){
            e.printStackTrace();
        }
        request.setAttribute("solution", solution);
        getServletContext().getRequestDispatcher("/WEB-INF/addSolutionForm.jsp").forward(request,response);
    }
}
