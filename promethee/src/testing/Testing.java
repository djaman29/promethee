package testing;

import java.sql.SQLException;

import service.ConnectionService;

public class Testing {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ConnectionService con = new ConnectionService();
		try {
			con.getConnection();
			System.out.println("Koneksi OK");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
