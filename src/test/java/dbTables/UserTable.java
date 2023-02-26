package dbTables;

import com.google.gson.annotations.SerializedName;
import configuration.ReadProperties;
import lombok.EqualsAndHashCode;
import models.User;
import services.DataBaseService;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserTable {
    private DataBaseService dbService;

    public UserTable(DataBaseService dbService) {
        this.dbService = dbService;
    }

    public void createTable() {

        String createTableSQL = "Create table Users " +
                "(   id                SERIAL PRIMARY KEY," +
                "    login             CHARACTER VARYING(255)," +
                "    type              CHARACTER VARYING(255)," +
                "    name              CHARACTER VARYING(255)," +
                "    company           CHARACTER VARYING(255)," +
                "    location          CHARACTER VARYING(255)," +
                "    email             CHARACTER VARYING(255)," +
                "    bio               CHARACTER VARYING(255)," +
                "    publicRepos       INTEGER" +
                ");";
        dbService.executeSQL(createTableSQL);
    }

    public void dropTable() {
        String dropTableSQL = "DROP TABLE if exists " + ReadProperties.database() + ".Users";
        dbService.executeSQL(dropTableSQL);
    }

    public void addUser(User user) {
        String insertUserSQL = "INSERT INTO " + ReadProperties.database() + ".Users (" +
                "login, type, name, company, location, email, bio, publicRepos)" +
                "VALUES ('" + user.getLogin() +"', '"+ user.getType() + "', '" + user.getName() + "', '"
                + user.getCompany() + "', '" + user.getLocation() + "', '" + user.getEmail() + "', '"
                + user.getBio() + "', '" + user.getPublicRepos() + "');";
        dbService.executeSQL(insertUserSQL);
    }

    public User getUser(int id) {
        String sql = "SELECT * FROM " + ReadProperties.database() + ".Users " +
                "WHERE id = " + id;
        ResultSet rs = dbService.executeQuery(sql);
        User user = User.builder().build();
        try {
            while (rs.next()) {
                user.setLogin(rs.getString("login"));
                user.setId(rs.getInt("id"));
                user.setType(rs.getString("type"));
                user.setName(rs.getString("name"));
                user.setCompany(rs.getString("company"));
                user.setLocation(rs.getString("location"));
                user.setEmail(rs.getString("email"));
                user.setBio(rs.getString("bio"));
                user.setPublicRepos(rs.getInt("publicRepos"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }
}
