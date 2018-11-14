package pl.coderslab.dao;

import pl.coderslab.model.Group;
import pl.coderslab.services.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GroupDao {
    public static void addGroup( Group group) throws SQLException {
        try (Connection conn = DbUtil.getConn()) {
            String sql = "INSERT INTO User_group(name) VALUES (?)";
            String generatedColumns[] = {"ID"};
            PreparedStatement preparedStatement;
            preparedStatement = conn.prepareStatement(sql, generatedColumns);
            preparedStatement.setString(1, group.getName());
            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                group.setId(rs.getInt(1));
            }
        }
    }
            public static void updateGroup(Group group) throws SQLException{
                try (Connection conn = DbUtil.getConn()) {
                    String sql = "UPDATE	User_group	SET	name=?	where	id	=	?";
                    PreparedStatement preparedStatement;
                    preparedStatement = conn.prepareStatement(sql);
                    preparedStatement.setString(1, group.getName());
                    preparedStatement.setInt(2,group.getId());
                    preparedStatement.executeUpdate();
        }
    }

    static public Group loadGroupById(int id) throws SQLException{
        try (Connection conn = DbUtil.getConn()) {
            String sql = "SELECT * FROM User_group WHERE id=?";
            PreparedStatement preparedStatement;
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                Group foundGrounp = new Group();
                foundGrounp.setId(rs.getInt("id"));
                foundGrounp.setName(rs.getString("name"));
                return foundGrounp;
            }
            return null;
        }
    }
    static public ArrayList<Group> loadAllGroups() throws SQLException {
        try (Connection conn = DbUtil.getConn()) {
            String sql = "SELECT * FROM User_group";
            PreparedStatement preparedStatemnet;
            preparedStatemnet = conn.prepareStatement(sql);
            ArrayList<Group> groups = new ArrayList<Group>();
            ResultSet rs = preparedStatemnet.executeQuery();
            while (rs.next()) {
                Group foundGroup = new Group();
                foundGroup.setName(rs.getString("name"));
                foundGroup.setId(rs.getInt("id"));
                groups.add(foundGroup);
            }
            return groups;
        }
    }
    public	static void	delete(Group group)	throws	SQLException {
        try (Connection conn = DbUtil.getConn()) {
            if (group.getId() != 0) {
                String sql = "DELETE	FROM	User_group	WHERE	id=	?";
                PreparedStatement preparedStatement;
                preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setInt(1, group.getId());
                preparedStatement.executeUpdate();
                group.setId(0);
            }
        }
    }
}
