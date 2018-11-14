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
import java.util.List;

@WebServlet(name = "HomepageController", urlPatterns = "/")
public class HomepageController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    @Override
    public void init() throws ServletException {
        super.init();
        String initParameter = getServletContext().getInitParameter("number-solutions");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Solution> solutions = SolutionDao.loadAllSolutionsWithUserAndTitle();
            request.setAttribute("solutions", solutions);
            getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
//W	metodzie	doGet	utwórz	obiekt	klasy	Solution.
//Utwórz	w	deskryptorze	wdrożenia	parametr	dla	całej	aplikacji	o
// nazwie	number-solutions	oraz
//wartości	5.
