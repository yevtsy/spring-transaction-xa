package pti.jta.xa.config;

import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by yevhen.tsyba on 13.04.2015.
 */
public class DBCreator {

    /**
     *
     * Example, DBCreator.populateDB("sql/ddl-posgre-hotel.sql", "flies", "admin", "admin")
     * runs script to populate database 'flies' with credentials admin\admin
     *
     * @param scriptPath - Path to script witch populates data
     * @param dbName - Database of Postgres
     * @param login - Login to Postgres
     * @param pswd - Password to Postgres
     * @throws ClassNotFoundException
     */
    public static void populateDB(String scriptPath, String dbName, String login, String pswd) throws ClassNotFoundException {
        ResourceDatabasePopulator rdp = new ResourceDatabasePopulator();
        rdp.addScript(new ClassPathResource(scriptPath));

        Class.forName("org.postgresql.Driver");

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://127.0.0.1:5432/" + dbName, login,
                    pswd);
            rdp.populate(connection);
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
        }
    }
}
