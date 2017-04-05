package Clase5MySql;

public class JDBCMySqlConnectionTest {

	public static void main(String[] args) throws Exception {
        JDBCMySqlConnection jdbcMySQLConnectionDAO = new JDBCMySqlConnection();
        jdbcMySQLConnectionDAO.readDataBase();
}
}
