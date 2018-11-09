package pl.coderslab.model;

import pl.coderslab.services.DbUtil;

import java.sql.*;
import java.util.ArrayList;

public class Group {
    private int id;
    private String name;

    public Group(){}
    public Group(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId(){
        return id;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void saveToDB() throws SQLException {
        try (Connection conn = DbUtil.getConn()) {
            if (this.id == 0) {
                String sql = "INSERT INTO User_group(name) VALUES (?)";
                String generatedColumns[] = {"ID"};
                PreparedStatement preparedStatement;
                preparedStatement = conn.prepareStatement(sql, generatedColumns);
                preparedStatement.setString(1, this.name);
                preparedStatement.executeUpdate();
                ResultSet rs = preparedStatement.getGeneratedKeys();
                if (rs.next()) {
                    this.id = rs.getInt(1);
                }
            } else {
                String sql = "UPDATE	User_group	SET	name=?	where	id	=	?";
                PreparedStatement preparedStatement;
                preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setString(1, this.name);
                preparedStatement.executeUpdate();
            }
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
                foundGrounp.id = rs.getInt("id");
                foundGrounp.name = rs.getString("name");
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
                foundGroup.name = rs.getString("name");
                foundGroup.id = rs.getInt("id");
                groups.add(foundGroup);
            }
            return groups;
        }
    }
    public	void	delete()	throws	SQLException {
        try (Connection conn = DbUtil.getConn()) {
            if (this.id != 0) {
                String sql = "DELETE	FROM	User_group	WHERE	id=	?";
                PreparedStatement preparedStatement;
                preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setInt(1, this.id);
                preparedStatement.executeUpdate();
                this.id = 0;
            }
        }
    }
}
