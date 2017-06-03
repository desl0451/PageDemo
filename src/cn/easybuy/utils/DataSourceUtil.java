package cn.easybuy.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataSourceUtil {
	private static String DRIVER = "";
	private static String URL = "";
	private static String USERNAME = "";
	private static String PASSWORD = "";
	static {
		initial();
	}

	public static void initial() {
		Properties properites = new Properties();
		String configFile = "database.properties";
		InputStream is = DataSourceUtil.class.getClassLoader().getResourceAsStream(configFile);
		try {
			properites.load(is);
		} catch (Exception e) {
			e.printStackTrace();
		}
		DRIVER = properites.getProperty("driver");
		URL = properites.getProperty("url");
		USERNAME = properites.getProperty("username");
		PASSWORD = properites.getProperty("password");
	}

	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}

	// πÿ±’¡¨Ω”
	public static void closeConnection(Connection connection) {
		try {
			if (connection != null)
				connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
