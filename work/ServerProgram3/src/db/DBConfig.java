package db;

public interface DBConfig {
	
	public final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	public final String URL = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	public final String USER = "SERVER_USER";
	public final String PASSWORD = "1111";
}
