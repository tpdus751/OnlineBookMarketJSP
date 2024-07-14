package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public abstract class JDBConnection {
	public Connection conn;
	public PreparedStatement pstmt;
	public ResultSet rs;
	
	public void getConnection(String jdbcDriverClassName, String url, String id, String password) {
		try {
			Class.forName(jdbcDriverClassName);
			conn = DriverManager.getConnection(url, id, password);
			System.out.println("DB 연결 성공");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void close() {
		try {
			if (conn != null ) conn.close();
			if (pstmt != null ) pstmt.close();
			if (rs != null ) rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
