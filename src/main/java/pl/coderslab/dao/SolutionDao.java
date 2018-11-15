package pl.coderslab.dao;

import pl.coderslab.model.Solution;
import pl.coderslab.services.DbUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class SolutionDao {

    public static void addSolution(Solution solution)throws SQLException {
        try (Connection conn = DbUtil.getConn()) {
            String sql = "INSERT INTO Solution(created, updated, description, exercise_id, user_id) " +
                    "VALUES(?,?,?,?,?)";
            PreparedStatement preparedStatement;
            String GeneretedColumns[] = {"ID"};
            preparedStatement = conn.prepareStatement(sql, GeneretedColumns);
            preparedStatement.setTimestamp(1, new Timestamp(solution.getCreated().getTime()));
            if (solution.getUpdated()==null) {
                preparedStatement.setTimestamp(2, null);
            } else {
                preparedStatement.setTimestamp(2, new Timestamp(solution.getUpdated().getTime()));
            }
            //  preparedStatement.setObject(2,new Timestamp(this.updated.getTime()));
            preparedStatement.setString(3, solution.getDescription());
            preparedStatement.setInt(4, solution.getExercise_id());
            preparedStatement.setInt(5, solution.getUser_id());
            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                solution.setId(rs.getInt(1));
            }
        }
    }
     public static void updateSolution(Solution solution) throws  SQLException {
         try (Connection conn = DbUtil.getConn()) {
             String sql = "UPDATE	Solution	SET	created=?, updated=?, description=?" +
                     ", exercise_id=?, user_id=?	where	id	=	?";
             PreparedStatement preparedStatement;
             preparedStatement = conn.prepareStatement(sql);
             preparedStatement.setTimestamp(1, new Timestamp(solution.getCreated().getTime()));
             if (solution.getUpdated()==null) {
                 solution.setUpdated(new Date());
                 preparedStatement.setTimestamp(2, new Timestamp(solution.getUpdated().getTime()));
             }
             preparedStatement.setString(3, solution.getDescription());
             preparedStatement.setInt(4, solution.getExercise_id());
             preparedStatement.setInt(5, solution.getUser_id());
             preparedStatement.setInt(6, solution.getId());
             preparedStatement.executeUpdate();
         }
     }

    public static ArrayList<Solution> loadAllSolutions() throws SQLException {
        try (Connection conn = DbUtil.getConn()) {
            String sql = "SELECT * from Solution";
            ArrayList<Solution> solutions = new ArrayList<Solution>();
            PreparedStatement preparedStatement;
            preparedStatement = conn.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Solution loadedSOL = new Solution();
                loadedSOL.setId(resultSet.getInt("id"));
                loadedSOL.setCreated(resultSet.getTimestamp("created"));
                loadedSOL.setUpdated(resultSet.getTimestamp("updated"));
                loadedSOL.setDescription(resultSet.getString("description"));
                loadedSOL.setUser_id(resultSet.getInt("user_id"));
                loadedSOL.setExercise_id(resultSet.getInt("exercise_id"));
                solutions.add(loadedSOL);
            }
            return solutions;
        }
    }
    public static ArrayList<Solution> loadAllSolutionsWithUserAndTitle()throws SQLException{
        try (Connection conn = DbUtil.getConn()){
            String sql = "SELECT Solution.id, Exercise.title, Solution.exercise_id, User.username, Solution.created," +
                    "Solution.description, Solution.updated from Solution JOIN Exercise ON Solution.exercise_id=Exercise.id JOIN" +
                    " User On Solution.user_id=User.id WHERE Solution.description IS not null";
            ArrayList<Solution> solutions = new ArrayList<Solution>();
            PreparedStatement preparedStatement;
            preparedStatement = conn.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Solution loadedSOL = new Solution();
                loadedSOL.setId(resultSet.getInt("id"));
                loadedSOL.setCreated(resultSet.getTimestamp("created"));
                loadedSOL.setUpdated(resultSet.getTimestamp("updated"));
                loadedSOL.setExerciseTitle(resultSet.getString("title"));
                loadedSOL.setDescription(resultSet.getString("description"));
                loadedSOL.setUsername(resultSet.getString("username"));
                loadedSOL.setExercise_id(resultSet.getInt("exercise_id"));
                solutions.add(loadedSOL);
            }
            return solutions;
        }
    }

    public static ArrayList<Solution> loadAllSolutions(int limit) throws SQLException{
        try (Connection conn = DbUtil.getConn()) {
            String sql = "SELECT * from Solution ORDER BY created LIMIT=?";
            ArrayList<Solution> solutions = new ArrayList<Solution>();
            PreparedStatement preparedStatement;
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, limit);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Solution loadedSOL = new Solution();
                loadedSOL.setId(resultSet.getInt("id"));
                loadedSOL.setCreated(resultSet.getTimestamp("created"));
                loadedSOL.setUpdated(resultSet.getTimestamp("updated"));
                loadedSOL.setDescription(resultSet.getString("description"));
                loadedSOL.setUser_id(resultSet.getInt("user_id"));
                loadedSOL.setExercise_id(resultSet.getInt("exercise_id"));
                solutions.add(loadedSOL);
            }
            return solutions;
        }
    }

    public static Solution loadById(int id) throws SQLException {
        try (Connection conn = DbUtil.getConn()) {
            String sql = "SELECT * from Solution WHERE id=?";
            PreparedStatement preparedStatement;
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Solution loadedSOL = new Solution();
                loadedSOL.setId(resultSet.getInt("id"));
                loadedSOL.setCreated(resultSet.getTimestamp("created"));
                loadedSOL.setUpdated(resultSet.getTimestamp("updated"));
                loadedSOL.setDescription(resultSet.getString("description"));
                loadedSOL.setUser_id(resultSet.getInt("user_id"));
                loadedSOL.setExercise_id(resultSet.getInt("exercise_id"));
                return loadedSOL;
            }
            return null;
        }
    }

    public static void delete(Solution solution) throws SQLException{
        try (Connection conn = DbUtil.getConn()) {
            if (solution.getId() != 0) {
                String sql = "DELETE FROM Solution WHERE id=?";
                PreparedStatement preparedStatement;
                preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setInt(1, solution.getId());
                preparedStatement.executeUpdate();
                solution.setId(0);
            }
        }
    }

    public static ArrayList<Solution> loadAllByUserId(int userID) throws SQLException {
        try (Connection conn = DbUtil.getConn()) {
            ArrayList<Solution> solutions = new ArrayList<Solution>();
            String sql = "SELECT * FROM Solution JOIN Exercise ON Solution.exercise_id=Exercise.id " +
                    "WHERE Solution.user_id=?";
            PreparedStatement preparedStatement;
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, userID);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Solution loadedSOL = new Solution();
                loadedSOL.setId(rs.getInt("id"));
                loadedSOL.setCreated(rs.getTimestamp("created"));
                loadedSOL.setUpdated(rs.getTimestamp("updated"));
                loadedSOL.setDescription(rs.getString("description"));
                loadedSOL.setExerciseTitle(rs.getString("title"));
                loadedSOL.setDescription(rs.getString("description"));
                loadedSOL.setUser_id(rs.getInt("user_id"));
                loadedSOL.setExercise_id(rs.getInt("exercise_id"));
                solutions.add(loadedSOL);
            }
            return solutions;
        }
    }
    public static ArrayList<Solution> loadAllByExerciseId(int exerciseID) throws SQLException {
        try (Connection conn = DbUtil.getConn()) {
            ArrayList<Solution> solutions = new ArrayList<Solution>();
            String sql = "SELECT Solution.id, " +
                    "Solution.created, Solution.updated, Solution.description, Solution.user_id, " +
                    "User.username FROM Solution " +
                    "JOIN User On Solution.user_id=User.id WHERE exercise_id=?";
            PreparedStatement preparedStatement;
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, exerciseID);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Solution foundS = new Solution();
                foundS.setId(rs.getInt("id"));
                foundS.setCreated(rs.getTimestamp("created"));
                foundS.setUpdated(rs.getTimestamp("updated"));
                foundS.setDescription(rs.getString("description"));
                foundS.setUsername(rs.getString("username"));
                foundS.setUser_id(rs.getInt("user_id"));
                solutions.add(foundS);
            }
            return solutions;
        }
    }
}
