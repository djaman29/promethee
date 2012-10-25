package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionService {
	private static Connection con;
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		if (con == null || con.isClosed()) {
			util.Connection conBean = new util.Connection();
			conBean.setDatabase("promethee");
			conBean.setDriver("com.mysql.jdbc.Driver");
			conBean.setLocalhost("localhost");
			conBean.setUser("root");
			conBean.setPassword("3204");
			
			Class.forName(conBean.getDriver());
			con = DriverManager.getConnection(conBean.getUrl(), 
					conBean.getUser(), conBean.getPassword());
		}
		return con;
	}
}
