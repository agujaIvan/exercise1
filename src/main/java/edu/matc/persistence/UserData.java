package edu.matc.persistence;

import edu.matc.entity.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.*;

/**
 * Access users in the user table.
 *
 * @author Ivan Hernandez U.
 */
public class UserData {

    private final Logger logger = Logger.getLogger(this.getClass());
    /**
     *
     * This method return all the user of the database
     *
     * @return a sql query of the users
     */
    public List<User> getAllUsers() {
        //List<User> users = new ArrayList<User>();
        //Database database = Database.getInstance();
        //Connection connection = null;
        String sql = "SELECT * FROM users";
        return executeQuery(sql);
    }

    /**
     *
     * This method return a user of the database by last name
     *
     * @return a sql query of users by last name
     * @param lastName the last name of a user
     */
    public List<User> getUserByLastName(String lastName) {
        String sql = "SELECT * FROM users WHERE last_name like '%" + lastName + "%'";
        return executeQuery(sql);
    }

    /**
     *
     * This method make a connection to the database and it receive a sql statement that it will be execute
     * @param sql the sql statement for the query
     * @return a sql query of the users
     */
    private List<User> executeQuery(String sql) {
        List<User> users = new ArrayList<>();
        Database database = Database.getInstance();
        Connection connection = null;
        try {
            database.connect();
            connection = database.getConnection();
            Statement selectStatement = connection.createStatement();
            ResultSet results = selectStatement.executeQuery(sql);
            creatingListOfUsers(users, results);
            database.disconnect();
        } catch (SQLException e) {
            logger.info("UserData.executeQuery().. Exception: " + e);
            //System.out.println("UserData.executeQuery()...Exception: " + e);
            e.printStackTrace();
        } catch (Exception e) {
            logger.info("UserData.executeQuery()...Exception: " + e);
            //System.out.println("UserData.executeQuery()...Exception: " + e);
            e.printStackTrace();
        }
        return users;
    }

    /**
     *
     * This method will loop through to create the list of users
     * @param users the list of users
     * @param results the resultset of the database
     *
     */
    private void creatingListOfUsers(List<User> users, ResultSet results) throws SQLException {
        while (results.next()) {
            User employee = createUserFromResults(results);
            users.add(employee);
        }
    }

    /**
     *
     * This method add the data to the user class
     * @param results the resultset of the database
     * @return a user object with the data
     */
    private User createUserFromResults(ResultSet results) throws SQLException {
        User user = new User();
        user.setLastName(results.getString("last_name"));
        user.setFirstName(results.getString("first_name"));
        user.setUserid(results.getString("id"));
        user.setDateOfBirth(results.getDate("date_of_birth").toLocalDate());

        return user;
    }
}