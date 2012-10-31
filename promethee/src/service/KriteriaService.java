package service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;

import model.Kriteria;

public class KriteriaService {
	public List<Kriteria> getAllData() throws ClassNotFoundException, SQLException {
		List<Kriteria> data = new ArrayList<Kriteria>();
		Kriteria kriteria = null;
		Connection con = null;
		
		try {
			con = ConnectionService.getConnection();
			Statement stat = con.createStatement();
			String query = "select * from kriteria as k where k.status_del='N'";
			ResultSet set = stat.executeQuery(query);
			while (set.next()) {
				kriteria = new Kriteria();
				kriteria.setKode(set.getString("kode"));
				kriteria.setNama(set.getString("nama"));
				kriteria.setNilaiMin(set.getByte("nilai_min"));
				kriteria.setNilaiMax(set.getByte("nilai_max"));
				kriteria.setBobot(set.getFloat("bobot"));
				kriteria.setTipePref(set.getString("tipe_preferensi"));
				kriteria.setMinmax(set.getString("minmax"));
				kriteria.setP(set.getByte("p"));
				kriteria.setQ(set.getByte("q"));
				kriteria.setG(set.getByte("g"));

				data.add(kriteria);
			}
		} finally {
			if (con!=null) con.close();
		}
		return data;
	}
	
	public String getLastKode() throws ClassNotFoundException, SQLException {
		String kode = "";
		Connection con = null;
		
		try {
			con = ConnectionService.getConnection();
			Statement stat = con.createStatement();
			String query = "select max(kode) as kode from kriteria as k where k.status_del='N'";
			ResultSet set = stat.executeQuery(query);
			if (set.next()) {
				kode = set.getString("kode");
			}
		} finally {
			if (con!=null) con.close();
		}
		return kode;
	}

	public void save(Kriteria k) throws ClassNotFoundException, SQLException {
		Connection con = null;
		
		try {
			con = ConnectionService.getConnection();
			String query = "insert into kriteria values(?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement stat = (PreparedStatement) con.prepareStatement(query);			
			stat.setString(1, k.getKode());
			stat.setString(2, k.getNama());
			stat.setByte(3, k.getNilaiMin());
			stat.setByte(4, k.getNilaiMax());
			stat.setFloat(5,  k.getBobot());
			stat.setString(6, k.getTipePref());
			stat.setString(7, k.getMinmax());
			stat.setByte(8, k.getP());
			stat.setByte(9, k.getQ());
			stat.setByte(10, k.getG());
			stat.setString(11, new Character(k.getStatusDel()).toString());
			stat.execute();
		} finally {
			if (con!=null) con.close();
		}
	}
	
	public void update(Kriteria k) throws ClassNotFoundException, SQLException {
		Connection con = null;
		
		try {
			con = ConnectionService.getConnection();
			String query = "update kriteria set nama=?,nilai_min=?,nilai_max=?," +
					"bobot=?,tipe_preferensi=?,minmax=?,p=?,q=?,G=? where kode=?";
			PreparedStatement stat = (PreparedStatement) con.prepareStatement(query);			
			stat.setString(1, k.getNama());
			stat.setByte(2, k.getNilaiMin());
			stat.setByte(3, k.getNilaiMax());
			stat.setFloat(4,  k.getBobot());
			stat.setString(5, k.getTipePref());
			stat.setString(6, k.getMinmax());
			stat.setByte(7, k.getP());
			stat.setByte(8, k.getQ());
			stat.setByte(9, k.getG());
			stat.setString(10, k.getKode());
			stat.execute();
		} finally {
			if (con!=null) con.close();
		}
	}

	public void delete(String kode) throws ClassNotFoundException, SQLException {
		Connection con = null;
		
		try {
			con = ConnectionService.getConnection();
			String query = "update kriteria set status_del='Y' where kode=?";
			PreparedStatement stat = (PreparedStatement) con.prepareStatement(query);			
			stat.setString(1, kode);
			stat.execute();
		} finally {
			if (con!=null) con.close();
		}
	}
	
	public Kriteria getOneData(String kode) throws ClassNotFoundException, SQLException {
		Kriteria kriteria = null;
		Connection con = null;
		
		try {
			con = ConnectionService.getConnection();
			Statement stat = con.createStatement();
			String query = "select * from kriteria as k " +
					"where k.status_del='N' and k.kode='"+ kode+"'";
			ResultSet set = stat.executeQuery(query);
			while (set.next()) {
				kriteria = new Kriteria();
				kriteria.setKode(set.getString("kode"));
				kriteria.setNama(set.getString("nama"));
				kriteria.setNilaiMin(set.getByte("nilai_min"));
				kriteria.setNilaiMax(set.getByte("nilai_max"));
				kriteria.setBobot(set.getFloat("bobot"));
				kriteria.setTipePref(set.getString("tipe_preferensi"));
				kriteria.setMinmax(set.getString("minmax"));
				kriteria.setP(set.getByte("p"));
				kriteria.setQ(set.getByte("q"));
				kriteria.setG(set.getByte("g"));
			}
		} finally {
			if (con!=null) con.close();
		}
		return kriteria;
	}
}
