package Clase5MySql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCMySqlConnection {

	private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public void readDataBase() throws Exception {
            try {
                    // This will load the MySQL driver, each DB has its own driver
            	    Class.forName("com.mysql.jdbc.Driver");
                    // Setup the connection with the DB
                    connect = DriverManager
                                    .getConnection("jdbc:mysql://localhost:3306/high-school?"
                                                    + "user=root&password=delfitesina");

                    
                    // Result set get the result of the SQL query
                    preparedStatement = connect.prepareStatement("SELECT CONCAT(`t`.first_name, ' ', `t`.last_name) AS Teacher,CONCAT(`st`.day, ' ', `st`.from_hour,' - ',`st`.to_hour, ': ',`c`.name) AS Schedule FROM `schedule_time` AS `st` RIGHT JOIN `course` AS `c` ON (`st`.course = `c`.idcourse) RIGHT JOIN `teacher` AS `t` ON (`c`.teacher_assigned = `t`.idteacher ) WHERE `t`.last_name = ? ORDER BY `st`.from_hour ASC");
                    preparedStatement.setString(1, "Stewart");
                    resultSet = preparedStatement.executeQuery();
                    displayResults(resultSet);

            } catch (Exception e) {
                    throw e;
            } finally {
                    close();
            }
    }

        private void displayResults(ResultSet resultSet) throws SQLException {
                // ResultSet is initially before the first data set
                while (resultSet.next()) {
                        // It is possible to get the columns via name
                        // also possible to get the columns via the column number
                        // which starts at 1
                        // e.g. resultSet.getSTring(2);
                        String teacher = resultSet.getString("Teacher");
                        String schedule = resultSet.getString("Schedule");
                        System.out.println("Teacher: " + teacher);
                        System.out.println("Schedule: " + schedule);
                }
        }

        // You need to close the resultSet
        private void close() {
                try {
                        if (resultSet != null) {
                                resultSet.close();
                        }

                        if (statement != null) {
                                statement.close();
                        }

                        if (connect != null) {
                                connect.close();
                        }
                } catch (Exception e) {

                }
        

}
}
