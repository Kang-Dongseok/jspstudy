package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnector {

	private static DBConnector instance = new DBConnector();
	
	private Connection con;
	private DBConnector() {
		try {
			Class.forName(DBConfig.DRIVER);
			con = DriverManager.getConnection(DBConfig.URL, DBConfig.USER, DBConfig.PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static DBConnector getInstance() {
		if(instance == null) {
			instance = new DBConnector();
		}
		return instance;
	}
	
	public Connection getConnection() {
		return con;
	}
	
	public void close(PreparedStatement ps, ResultSet rs) {
		try {
			if (ps !=null ) {ps.close();}
			if (rs !=null ) {rs.close();}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
