package service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import model.Rekanan;

public class RekananService {
	public List<Rekanan> getAllData() throws ClassNotFoundException, SQLException {
		List<Rekanan> data = new ArrayList<Rekanan>();
		Rekanan obj = null;
		Connection con = null;
		
		try {
			con = ConnectionService.getConnection();
			Statement stat = con.createStatement();
			String query = "select * from Rekanan as k where k.status_del='N'";
			ResultSet set = stat.executeQuery(query);
			while (set.next()) {
				obj = new Rekanan();
				obj.setId(set.getInt("id"));
				obj.setNama(set.getString("nama"));
				obj.setAlamat(set.getString("alamat"));
				obj.setNoTelp(set.getString("no_telp"));
				obj.setKota(set.getString("kota"));
				obj.setKodePos(set.getString("kodepos"));
				obj.setJenis(set.getString("jenis"));
				
				data.add(obj);
			}
		} finally {
			if (con!=null) con.close();
		}
		return data;
	}

	public void save(Rekanan k) throws ClassNotFoundException, SQLException {
		Connection con = null;
		
		try {
			con = ConnectionService.getConnection();
			String query = "insert into Rekanan values(?,?,?,?,?,?,?,?)";
			PreparedStatement stat = (PreparedStatement) con.prepareStatement(query);			
			stat.setInt(1, 0);
			stat.setString(2, k.getNama());
			stat.setString(3, k.getAlamat());
			stat.setString(4, k.getNoTelp());
			stat.setString(5,  k.getKota());
			stat.setString(6, k.getKodePos());
			stat.setString(7, new Character(k.getStatusDel()).toString());
			stat.setString(8, k.getJenis());
			stat.execute();
		} finally {
			if (con!=null) con.close();
		}
	}
	
	public void update(Rekanan k) throws ClassNotFoundException, SQLException {
		Connection con = null;
		
		try {
			con = ConnectionService.getConnection();
			String query = "update rekanan set nama=?,alamat=?,no_telp=?," +
					"kota=?,kodepos=?,jenis=? where id=?";
			PreparedStatement stat = (PreparedStatement) con.prepareStatement(query);			
			stat.setString(1, k.getNama());
			stat.setString(2, k.getAlamat());
			stat.setString(3, k.getNoTelp());
			stat.setString(4,  k.getKota());
			stat.setString(5, k.getKodePos());
			stat.setString(6, k.getJenis());
			stat.setInt(7, k.getId());
			stat.execute();
		} finally {
			if (con!=null) con.close();
		}
	}

	public void delete(Integer id) throws ClassNotFoundException, SQLException {
		Connection con = null;
		
		try {
			con = ConnectionService.getConnection();
			String query = "update rekanan set status_del='Y' where id=?";
			PreparedStatement stat = (PreparedStatement) con.prepareStatement(query);			
			stat.setInt(1, id);
			stat.execute();
		} finally {
			if (con!=null) con.close();
		}
	}
	
	public Rekanan getOneData(Integer id) throws ClassNotFoundException, SQLException {
		Rekanan obj = null;
		Connection con = null;
		
		try {
			con = ConnectionService.getConnection();
			Statement stat = con.createStatement();
			String query = "select * from Rekanan as k " +
					"where k.status_del='N' and k.id='"+ id+"'";
			ResultSet set = stat.executeQuery(query);
			while (set.next()) {
				obj = new Rekanan();
				obj.setId(set.getInt("id"));
				obj.setNama(set.getString("nama"));
				obj.setAlamat(set.getString("alamat"));
				obj.setNoTelp(set.getString("no_telp"));
				obj.setKota(set.getString("kota"));
				obj.setKodePos(set.getString("kodepos"));
				obj.setJenis(set.getString("jenis"));
			}
		} finally {
			if (con!=null) con.close();
		}
		return obj;
	}
}
