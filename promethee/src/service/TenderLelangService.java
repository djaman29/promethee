package service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;

import model.TenderLelang;

public class TenderLelangService {
	public List<TenderLelang> getAllData() throws ClassNotFoundException, SQLException {
		List<TenderLelang> data = new ArrayList<TenderLelang>();
		TenderLelang obj = null;
		Connection con = null;
		
		try {
			con = ConnectionService.getConnection();
			Statement stat = con.createStatement();
			String query = "select * from tender_lelang as k where k.status_del='N' " +
					"order by k.id desc";
			ResultSet set = stat.executeQuery(query);
			while (set.next()) {
				obj = new TenderLelang();
				obj.setId(set.getInt("id"));
				obj.setDitPemesanan(set.getString("dit_pemesanan"));
				obj.setPengadaanBarang(set.getString("pengadaan_barang"));
				obj.setSumberDana(set.getString("sumber_dana"));
				obj.setTahun(String.valueOf(set.getDate("tahun").getYear()+1900));
				obj.setNo(set.getInt("nomor"));
				obj.setNoSP3(set.getString("no_sp3"));
				java.sql.Date d2 = set.getDate("tgl_sp3");
				obj.setTglSP3(new java.util.Date(d2.getYear(), d2.getMonth(), d2.getDate()+1));
				obj.setTglTerimaSP3(new java.util.Date(set.getDate("tgl_terima_sp3").getTime()));
				obj.setUraianBarang(set.getString("uraian_barang"));
				obj.setNoRBiaya(set.getString("no_rbiaya"));
				obj.setTglRBiaya(new java.util.Date(set.getDate("tgl_rbiaya").getTime()));
				obj.setVolRBiaya(set.getString("vol_rbiaya"));
				obj.setRupRBiaya(set.getInt("rup_rbiaya"));
				obj.setNoRks(set.getString("no_rks"));
				obj.setTglRks(new java.util.Date(set.getDate("tgl_rks").getTime()));
				obj.setProgress(set.getString("progress"));
				obj.setNilaiOE(set.getInt("nilai_oe"));
				obj.setNilaiKontrak(set.getInt("nilai_kontrak"));
				obj.setSavingCost(set.getInt("saving_cost"));
				obj.setLamaProses(set.getShort("lama_proses"));
				
				data.add(obj);
			}
		} finally {
			if (con!=null) con.close();
		}
		return data;
	}

	public List<TenderLelang> getManyData(String value) throws ClassNotFoundException, SQLException {
		List<TenderLelang> data = new ArrayList<TenderLelang>();
		TenderLelang obj = null;
		Connection con = null;
		
		try {
			con = ConnectionService.getConnection();
			Statement stat = con.createStatement();
			String query = "select * from tender_lelang as k where k.status_del='N' and " +
					"(k.dit_pemesanan='"+ value+ "' or k.pengadaan_barang='"+ value+"' or k.sumber_dana='"+ value+
					"' or k.tahun='"+ value+"' or k.no_sp3='"+ value+"') " +
					"order by k.id desc";
			ResultSet set = stat.executeQuery(query);
			while (set.next()) {
				obj = new TenderLelang();
				obj.setId(set.getInt("id"));
				obj.setDitPemesanan(set.getString("dit_pemesanan"));
				obj.setPengadaanBarang(set.getString("pengadaan_barang"));
				obj.setSumberDana(set.getString("sumber_dana"));
				obj.setTahun(String.valueOf(set.getDate("tahun").getYear()+1900));
				obj.setNo(set.getInt("nomor"));
				obj.setNoSP3(set.getString("no_sp3"));
				java.sql.Date d = set.getDate("tgl_sp3");
				obj.setTglSP3(new java.util.Date(d.getYear(), d.getMonth(), d.getDate()+1));
				obj.setTglTerimaSP3(new java.util.Date(set.getDate("tgl_terima_sp3").getTime()));
				obj.setUraianBarang(set.getString("uraian_barang"));
				obj.setNoRBiaya(set.getString("no_rbiaya"));
				obj.setTglRBiaya(new java.util.Date(set.getDate("tgl_rbiaya").getTime()));
				obj.setVolRBiaya(set.getString("vol_rbiaya"));
				obj.setRupRBiaya(set.getInt("rup_rbiaya"));
				obj.setNoRks(set.getString("no_rks"));
				obj.setTglRks(new java.util.Date(set.getDate("tgl_rks").getTime()));
				obj.setProgress(set.getString("progress"));
				obj.setNilaiOE(set.getInt("nilai_oe"));
				obj.setNilaiKontrak(set.getInt("nilai_kontrak"));
				obj.setSavingCost(set.getInt("saving_cost"));
				obj.setLamaProses(set.getShort("lama_proses"));
				
				data.add(obj);
			}
		} finally {
			if (con!=null) con.close();
		}
		return data;
	}
	
	public Integer getLastID() throws ClassNotFoundException, SQLException {
		Integer id = 0;
		Connection con = null;
		
		try {
			con = ConnectionService.getConnection();
			Statement stat = con.createStatement();
			String query = "select max(id) as id from tender_lelang as k where k.status_del='N'";
			ResultSet set = stat.executeQuery(query);
			if (set.next()) {
				id = set.getInt("id");
			}
		} finally {
			if (con!=null) con.close();
		}
		return id;
	}
	
	public void save(TenderLelang k) throws ClassNotFoundException, SQLException {
		Connection con = null;
		
		try {
			con = ConnectionService.getConnection();
			String query = "insert into tender_lelang values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement stat = (PreparedStatement) con.prepareStatement(query);			
			stat.setInt(1, 0);
			stat.setString(2, k.getDitPemesanan());
			stat.setString(3, k.getPengadaanBarang());
			stat.setString(4, k.getSumberDana());
			stat.setString(5, k.getTahun());
			stat.setInt(6, 0);
			stat.setString(7, k.getNoSP3());
			stat.setDate(8, new java.sql.Date(k.getTglSP3().getTime()));
			stat.setDate(9, new java.sql.Date(k.getTglTerimaSP3().getTime()));
			stat.setString(10, k.getUraianBarang());
			stat.setString(11, k.getNoRBiaya());
			stat.setDate(12, new java.sql.Date(k.getTglRBiaya().getTime()));
			stat.setString(13, k.getVolRBiaya());
			stat.setInt(14, k.getRupRBiaya());
			stat.setString(15, k.getNoRks());
			stat.setDate(16, new java.sql.Date(k.getTglRks().getTime()));
			stat.setString(17, k.getProgress());
			stat.setInt(18, k.getNilaiOE());
			stat.setInt(19, k.getNilaiKontrak());
			stat.setInt(20, k.getSavingCost());
			stat.setShort(21, k.getLamaProses());
			stat.setString(22, new Character(k.getStatusDel()).toString());
			stat.execute();		
		} finally {
			if (con!=null) con.close();
		}
	}
	
	public void update(TenderLelang k) throws ClassNotFoundException, SQLException {
		Connection con = null;
		
		try {
			con = ConnectionService.getConnection();
			String query = "update tender_lelang set dit_pemesanan=?," +
					"pengadaan_barang=?,sumber_dana=?,tahun=?," +
					"nomor=?,no_sp3=?,tgl_sp3=?,tgl_terima_sp3=?," +
					"uraian_barang=?,no_rbiaya=?,tgl_rbiaya=?," +
					"vol_rbiaya=?,rup_rbiaya=?,no_rks=?,tgl_rks=?," +
					"progress=?,nilai_oe=?,nilai_kontrak=?,saving_cost=?," +
					"lama_proses=? where id=?";
			PreparedStatement stat = (PreparedStatement) con.prepareStatement(query);			
					
			stat.setString(1, k.getDitPemesanan());
			stat.setString(2, k.getPengadaanBarang());
			stat.setString(3, k.getSumberDana());
			stat.setString(4, k.getTahun());
			stat.setInt(5, 0);
			stat.setString(6, k.getNoSP3());
			stat.setDate(7, new java.sql.Date(k.getTglSP3().getTime()));
			stat.setDate(8, new java.sql.Date(k.getTglTerimaSP3().getTime()));
			stat.setString(9, k.getUraianBarang());
			stat.setString(10, k.getNoRBiaya());
			stat.setDate(11, new java.sql.Date(k.getTglRBiaya().getTime()));
			stat.setString(12, k.getVolRBiaya());
			stat.setInt(13, k.getRupRBiaya());
			stat.setString(14, k.getNoRks());
			stat.setDate(15, new java.sql.Date(k.getTglRks().getTime()));
			stat.setString(16, k.getProgress());
			stat.setInt(17, k.getNilaiOE());
			stat.setInt(18, k.getNilaiKontrak());
			stat.setInt(19, k.getSavingCost());
			stat.setShort(20, k.getLamaProses());
			stat.setInt(21, k.getId());
			
			stat.execute();
		} finally {
			if (con!=null) con.close();
		}
	}

	public void delete(Integer id) throws ClassNotFoundException, SQLException {
		Connection con = null;
		
		try {
			con = ConnectionService.getConnection();
			String query = "update tender_lelang set status_del='Y' where id=?";
			PreparedStatement stat = (PreparedStatement) con.prepareStatement(query);			
			stat.setInt(1, id);
			stat.execute();
		} finally {
			if (con!=null) con.close();
		}
	}
	
	public TenderLelang getOneData(Integer id) throws ClassNotFoundException, SQLException {
		TenderLelang obj = null;
		Connection con = null;
		
		try {
			con = ConnectionService.getConnection();
			Statement stat = con.createStatement();
			String query = "select * from tender_lelang as k " +
					"where k.status_del='N' and k.id='"+ id+"'";
			ResultSet set = stat.executeQuery(query);
			while (set.next()) {
				obj = new TenderLelang();
				obj.setId(set.getInt("id"));
				obj.setDitPemesanan(set.getString("dit_pemesanan"));
				obj.setPengadaanBarang(set.getString("pengadaan_barang"));
				obj.setSumberDana(set.getString("sumber_dana"));
				obj.setTahun(String.valueOf(set.getDate("tahun").getYear()+1900));
				obj.setNo(set.getInt("nomor"));
				obj.setNoSP3(set.getString("no_sp3"));
				java.sql.Date d1 = set.getDate("tgl_sp3");
				obj.setTglSP3(new java.util.Date(d1.getYear(), d1.getMonth(), d1.getDate()+1));
				java.sql.Date d2 = set.getDate("tgl_terima_sp3");
				obj.setTglTerimaSP3(new java.util.Date(d2.getYear(), d2.getMonth(), d2.getDate()+1));
				obj.setUraianBarang(set.getString("uraian_barang"));
				obj.setNoRBiaya(set.getString("no_rbiaya"));
				java.sql.Date d3 = set.getDate("tgl_rbiaya");
				obj.setTglRBiaya(new java.util.Date(d3.getYear(), d3.getMonth(), d3.getDate()+1));
				obj.setVolRBiaya(set.getString("vol_rbiaya"));
				obj.setRupRBiaya(set.getInt("rup_rbiaya"));
				obj.setNoRks(set.getString("no_rks"));
				java.sql.Date d4 = set.getDate("tgl_rks");
				obj.setTglRks(new java.util.Date(d4.getYear(), d4.getMonth(), d4.getDate()+1));
				obj.setProgress(set.getString("progress"));
				obj.setNilaiOE(set.getInt("nilai_oe"));
				obj.setNilaiKontrak(set.getInt("nilai_kontrak"));
				obj.setSavingCost(set.getInt("saving_cost"));
				obj.setLamaProses(set.getShort("lama_proses"));
			}
		} finally {
			if (con!=null) con.close();
		}
		return obj;
	}
}
