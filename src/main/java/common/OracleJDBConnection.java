package common;

public class OracleJDBConnection extends JDBConnection {
	
	public OracleJDBConnection() {
		final String jdbcDriverClassName = "oracle.jdbc.OracleDriver";
		final String url= "jdbc:oracle:thin:@localhost:1521:xe";
		final String id = "c##java";
		final String password = "1234";
		
		getConnection(jdbcDriverClassName, url, id, password);
	}
}
