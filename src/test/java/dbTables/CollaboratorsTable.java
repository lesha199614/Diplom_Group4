package dbTables;

import configuration.ReadProperties;
import models.Collaborator;
import models.User;
import services.DataBaseService;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CollaboratorsTable {
    private DataBaseService dbService;

    public CollaboratorsTable(DataBaseService dbService) {
        this.dbService = dbService;
    }

    public void createTable() {

        String createTableSQL = "Create table Collaborators " +
                "(   id                SERIAL PRIMARY KEY," +
                "    login             CHARACTER VARYING(255)," +
                "    type              CHARACTER VARYING(255)," +
                "    roleName          CHARACTER VARYING(255)" +
                ");";
        dbService.executeSQL(createTableSQL);
    }

    public void dropTable() {
        String dropTableSQL = "DROP TABLE if exists " + ReadProperties.database() + ".Collaborators";
        dbService.executeSQL(dropTableSQL);
    }

    public void addCollaborator(Collaborator collaborator) {
        String insertUserSQL = "INSERT INTO " + ReadProperties.database() + ".Collaborators (" +
                "login, type, roleName)" +
                "VALUES ('" + collaborator.getLogin() +"', '"+ collaborator.getType() + "', '" + collaborator.getRoleName() + "');";
        dbService.executeSQL(insertUserSQL);
    }

    public Collaborator getCollaborator(int id) {
        String sql = "SELECT * FROM " + ReadProperties.database() + ".Collaborators " +
                "WHERE id = " + id;
        ResultSet rs = dbService.executeQuery(sql);
        Collaborator collaborator = Collaborator.builder().build();
        try {
            while (rs.next()) {
                collaborator.setLogin(rs.getString("login"));
                collaborator.setId(rs.getInt("id"));
                collaborator.setType(rs.getString("type"));
                collaborator.setRoleName(rs.getString("roleName"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return collaborator;
    }
}
