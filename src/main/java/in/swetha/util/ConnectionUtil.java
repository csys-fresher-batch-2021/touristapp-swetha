package in.swetha.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import in.swetha.exception.DBException;

public class ConnectionUtil {
	private ConnectionUtil() {

	}


	public static Connection getConnection() throws DBException {

		Connection connection = null;
		String driverClass =System.getenv("spring.datasource.driver-class-name");
		String url =System.getenv("spring.datasource.url");
		String username =System.getenv("spring.datasource.username");
		String password =System.getenv("spring.datasource.password");
		try {
			Class.forName(driverClass);
			connection = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new DBException("Unable to connect");
		}
		return connection;
	}



	
	public static void close(Connection conn,Statement stmt) throws SQLException, DBException {

		try {
			
			if (conn != null) {
				conn.close();
			}
			if (stmt != null) {
				stmt.close();
			}
		} catch (SQLException e) {
			throw new DBException("Unable to close");
		}
	}
public static void main(String[] args) throws DBException
{
	try {
		ConnectionUtil.getConnection();
	} catch (DBException e) {
		e.printStackTrace();
		throw new DBException("Unable to connect");
		
	}
}
}


