package dbTables;

import configuration.ReadProperties;
import models.Repository;
import services.DataBaseService;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RepositoryTable {
    private DataBaseService dbService;

    public RepositoryTable(DataBaseService dbService) {
        this.dbService = dbService;
    }

    public void createTable() {

        String createTableSQL = "Create table Repository " +
                "(   id                SERIAL PRIMARY KEY," +
                "    name              CHARACTER VARYING(255)," +
                "    description       CHARACTER VARYING(255)," +
                "    isPrivate         BOOLEAN" +
                ");";
        dbService.executeSQL(createTableSQL);
    }

    public void dropTable() {
        String dropTableSQL = "DROP TABLE if exists " + ReadProperties.database() + ".Repository";
        dbService.executeSQL(dropTableSQL);
    }

    public void addRepository(Repository repository) {
        String insertUserSQL = "INSERT INTO " + ReadProperties.database() + ".Repository (" +
                "name, description, isPrivate)" +
                "VALUES ('" + repository.getName() + "', '" + repository.getDescription() + "', " +
                repository.isIsPrivate() + ");";
        dbService.executeSQL(insertUserSQL);
    }

    public Repository getRepository(int id) {
        String sql = "SELECT * FROM " + ReadProperties.database() + ".Repository " +
                "WHERE id = " + id;
        ResultSet rs = dbService.executeQuery(sql);
        Repository repository = Repository.builder().build();
        try {
            while (rs.next()) {
                repository.setName(rs.getString("name"));
                repository.setDescription(rs.getString("description"));
                repository.setIsPrivate(rs.getBoolean("isPrivate"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return repository;
    }
}
