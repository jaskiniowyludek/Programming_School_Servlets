package pl.coderslab.dao;

import pl.coderslab.model.User;
import pl.coderslab.services.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDao {

    public	static void	addUser(User user)	throws SQLException {
        try (Connection conn = DbUtil.getConn()) {
            String sql = "INSERT	INTO User(username,	email,	password, user_group_id)	VALUES	(?,	?,	?, ?)";
            String generatedColumns[] = {"ID"};
            PreparedStatement preparedStatement;
            preparedStatement = conn.prepareStatement(sql, generatedColumns);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setInt(4, user.getUser_group());
            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                user.setId(rs.getInt(1));
            }
        }
    }
    public static void updateUser(User user)throws SQLException {
        try (Connection conn = DbUtil.getConn()) {
            String sql = "UPDATE	User	SET	username=?,	email=?,	password=?, user_group_id=?	where	id	=	?";
            PreparedStatement preparedStatement;
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setInt(4, user.getUser_group());
            preparedStatement.setInt(5, user.getId());
            preparedStatement.executeUpdate();
        }
    }

    static	public	User	loadUserById(int	id)	throws	SQLException {
        try (Connection conn = DbUtil.getConn()) {
            String sql = "SELECT	*	FROM	User	where	id=?";
            PreparedStatement preparedStatement;
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                User loadedUser = new User();
                loadedUser.setId(resultSet.getInt("id"));
                loadedUser.setUsername(resultSet.getString("username"));
                loadedUser.setPassword(resultSet.getString("password"));
                loadedUser.setEmail(resultSet.getString("email"));
                loadedUser.setUser_group(resultSet.getInt("user_group_id"));
                return loadedUser;
            }
            return null;
        }
    }
    static	public	ArrayList<User>	loadAllUsers()	throws	SQLException {
        try (Connection conn = DbUtil.getConn()) {
            ArrayList<User> users = new ArrayList<User>();
            String sql = "SELECT	*	FROM	User";
            PreparedStatement preparedStatement;
            preparedStatement = conn.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User loadedUser = new User();
                loadedUser.setId(resultSet.getInt("id"));
                loadedUser.setUsername(resultSet.getString("username"));
                loadedUser.setPassword(resultSet.getString("password"));
                loadedUser.setEmail(resultSet.getString("email"));
                loadedUser.setUser_group(resultSet.getInt("user_group_id"));
                users.add(loadedUser);
            }
            return users;
        }
    }
    public	static void	delete(User user)	throws	SQLException {
        try (Connection conn = DbUtil.getConn()) {
            if (user.getId() != 0) {
                String sql = "DELETE	FROM	User	WHERE	id=	?";
                PreparedStatement preparedStatement;
                preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setInt(1, user.getId());
                preparedStatement.executeUpdate();
                user.setId(0);
            }
        }
    }

    public static ArrayList<User> loadAllByGroupId(int user_group)throws SQLException {
        try (Connection conn = DbUtil.getConn()) {
            ArrayList<User> usersInGroup = new ArrayList<User>();
            String sql = "SELECT * FROM User WHERE user_group_id=?";
            PreparedStatement preparedStatement;
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, user_group);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                User foundUser = new User();
                foundUser.setId(rs.getInt("id"));
                foundUser.setUsername(rs.getString("username"));
                foundUser.setEmail(rs.getString("email"));
                foundUser.setUser_group(rs.getInt("user_group_id"));
                usersInGroup.add(foundUser);
            }
            return usersInGroup;
        }
    }
}
