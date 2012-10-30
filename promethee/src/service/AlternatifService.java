package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Alternatif;

public class AlternatifService {
	public List<Alternatif> getManyData(Integer idTL) throws ClassNotFoundException, SQLException {
		List<Alternatif> data = new ArrayList<Alternatif>();
		Alternatif alt = null;
		Connection con = null;
		
		try {
			con = ConnectionService.getConnection();
			Statement stat = con.createStatement();
			String query = "select a.id as id,a.id_rekanan as id_rekanan,a.kode as kode,a.harga as harga," +
					"r.nama as nama from alternatif as a, rekanan as r " +
					"where a.status_del='N' and a.id_tl='"+ idTL+ "' and a.id_rekanan=r.id " +
					"order by a.kode asc";
			ResultSet set = stat.executeQuery(query);
			while (set.next()) {
				alt = new Alternatif();
				alt.setId(set.getInt("id"));
				alt.setKode(set.getString("kode"));
				alt.setIdRekanan(set.getInt("id_rekanan"));
				alt.setHarga(set.getInt("harga"));
				alt.setNamaRekanan(set.getString("nama"));
		
				data.add(alt);
			}
		} finally {
			if (con!=null) con.close();
		}
		return data;
	}
	
	public String getLastKode(Integer idTL) throws ClassNotFoundException, SQLException {
		String kode = "";
		Connection con = null;
		
		try {
			con = ConnectionService.getConnection();
			Statement stat = con.createStatement();
			String query = "select max(kode) as kode from alternatif as k where k.id_tl='"+ 
					idTL +"' and status_del='N'";
			ResultSet set = stat.executeQuery(query);
			if (set.next()) {
				kode = set.getString("kode");
			}
		} finally {
			if (con!=null) con.close();
		}
		return kode;
	}

	public void save(Alternatif k) throws ClassNotFoundException, SQLException {
		Connection con = null;
		
		try {
			con = ConnectionService.getConnection();
			String query1 = "select * from alternatif as k where k.id_tl='"+ k.getIdTL()
					+"' and k.id_rekanan='"+k.getIdRekanan()+"' and status_del='N'";
			Statement stat1 = con.createStatement();			
			ResultSet set = stat1.executeQuery(query1);
			if (!set.next()) {
				String query2 = "insert into alternatif values(?,?,?,?,?,?)";
				PreparedStatement stat2 = (PreparedStatement) con.prepareStatement(query2);
				stat2.setInt(1, 0);
				stat2.setString(2, k.getKode());
				stat2.setInt(3, k.getIdTL());
				stat2.setInt(4, k.getIdRekanan());
				stat2.setInt(5,  k.getHarga());
				stat2.setString(6, new Character(k.getStatusDel()).toString());
				stat2.execute();
			}			
		} finally {
			if (con!=null) con.close();
		}
	}
	
	public void update(Alternatif k) throws ClassNotFoundException, SQLException {
		Connection con = null;
		
		try {
			con = ConnectionService.getConnection();
			String query = "update alternatif set harga=? where id=? and status_del='N'";
			PreparedStatement stat = (PreparedStatement) con.prepareStatement(query);			
			stat.setInt(1, k.getHarga());
			stat.setInt(2, k.getId());
			stat.execute();
		} finally {
			if (con!=null) con.close();
		}
	}

	public void delete(Integer id) throws ClassNotFoundException, SQLException {
		Connection con = null;
		
		try {
			con = ConnectionService.getConnection();
			String query = "update alternatif set status_del='Y' where id=?";
			PreparedStatement stat = (PreparedStatement) con.prepareStatement(query);			
			stat.setInt(1, id);
			stat.execute();
		} finally {
			if (con!=null) con.close();
		}
	}
	
	public Alternatif getOneData(int id) throws ClassNotFoundException, SQLException {
		Alternatif alt = null;
		Connection con = null;
		
		try {
			con = ConnectionService.getConnection();
			Statement stat = con.createStatement();
			String query = "select a.id as id,a.kode as kode,a.harga as harga,r.nama as nama from alternatif as a, rekanan as r " +
					"where a.status_del='N' and a.id='"+ id+ "' and a.id_rekanan=r.id";
			ResultSet set = stat.executeQuery(query);
			if (set.next()) {
				alt = new Alternatif();
				alt.setId(set.getInt("id"));
				alt.setKode(set.getString("kode"));
				alt.setNamaRekanan(set.getString("nama"));
				alt.setHarga(set.getInt("harga"));
			}
		} finally {
			if (con!=null) con.close();
		}
		return alt;
	}
}
