package pl.coderslab.dao;

import pl.coderslab.model.Exercise;
import pl.coderslab.services.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExerciseDao {

    public static void addExercise(Exercise exercise) throws SQLException {
        try (Connection conn = DbUtil.getConn()) {
            String sql = "INSERT INTO Exercise(title, description) VALUES (?,?)";
            String generatedColumns[] = {"ID"};
            PreparedStatement preparedStatement;
            preparedStatement = conn.prepareStatement(sql, generatedColumns);
            preparedStatement.setString(1, exercise.getTitle());
            preparedStatement.setString(2, exercise.getDescription());
            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                exercise.setId(rs.getInt(1));
            }
        }
    }

    public static void updateExercise(Exercise exercise) throws SQLException {
        try (Connection conn = DbUtil.getConn()) {
            String sql = "UPDATE	Exercise	SET	title=?, description=?	where	id	=	?";
            PreparedStatement preparedStatement;
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, exercise.getTitle());
            preparedStatement.setString(2, exercise.getDescription());
            preparedStatement.setInt(3, exercise.getId());
            preparedStatement.executeUpdate();
        }
    }

    public static void deleteExercise(Exercise exercise) throws SQLException {
        try (Connection conn = DbUtil.getConn()) {
            if (exercise.getId() != 0) {
                String sql = "DELETE FROM Exercise WHERE id=?";
                PreparedStatement preparedStatement;
                preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setInt(1, exercise.getId());
                preparedStatement.executeUpdate();
                exercise.setId(0);
            }
        }
    }
        public static ArrayList<Exercise> loadAllExercise() throws SQLException {
            try (Connection conn = DbUtil.getConn()) {
                String sql = "SELECT * from Exercise";
                ArrayList<Exercise> exercises = new ArrayList<Exercise>();
                PreparedStatement preparedStatement;
                preparedStatement = conn.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    Exercise loadedExc = new Exercise();
                    loadedExc.setId(resultSet.getInt("id"));
                    loadedExc.setTitle(resultSet.getString("title"));
                    loadedExc.setDescription(resultSet.getString("description"));
                    exercises.add(loadedExc);
                }
                return exercises;
            }
        }

        public static Exercise loadById ( int id) throws SQLException {
            try (Connection conn = DbUtil.getConn()) {
                String sql = "SELECT * from Exercise WHERE id=?";
                PreparedStatement preparedStatement;
                preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setInt(1, id);
                ResultSet rs = preparedStatement.executeQuery();
                if (rs.next()) {
                    Exercise loadedEx = new Exercise();
                    loadedEx.setTitle(rs.getString("title"));
                    loadedEx.setDescription(rs.getString("description"));
                    loadedEx.setId(rs.getInt("id"));
                    return loadedEx;
                }
                return null;
            }
        }

    }
