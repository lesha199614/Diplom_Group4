package tests;

import configuration.ReadProperties;
import org.testng.annotations.Test;
import services.DataBaseService;

public class SimpleDbTest {

    @Test
    public void createCaseTable() {
        DataBaseService dbService = new DataBaseService();

        String createTableSQL = "Create table Milestones " +
                "(   id                SERIAL PRIMARY KEY," +
                "    name              CHARACTER VARYING(255)," +
                "    refs              CHARACTER VARYING(255)," +
                "    description       CHARACTER VARYING(255)," +
                "    completed         BOOLEAN" +
                ");";
        dbService.executeSQL(createTableSQL);
        dbService.closeConnection();
    }


    @Test
    public void addMilestone() {
        DataBaseService dbService = new DataBaseService();
        String insertTableSQL = "INSERT INTO "+ ReadProperties.database() +".Milestones(" +
                "name, refs, description, completed)" +
                "VALUES ('Name1', 'refs', 'description', false);";
        dbService.executeSQL(insertTableSQL);
        dbService.closeConnection();
    }


}
