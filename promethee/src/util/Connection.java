package util;

public class Connection {
	private String driver;
	private String localhost;
	private String user;
	private String password;
	private String database;
	
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getLocalhost() {
		return localhost;
	}
	public void setLocalhost(String localhost) {
		this.localhost = localhost;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDatabase() {
		return database;
	}
	public void setDatabase(String database) {
		this.database = database;
	}
	public String getUrl() {
		StringBuilder builder = new StringBuilder();
		if (driver.indexOf("mysql") != -1) {
			builder.append("jdbc:mysql://");
		}
		builder.append(getLocalhost()+"/"+ getDatabase());
		return builder.toString();
	}
}
