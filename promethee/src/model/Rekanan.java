package model;

public class Rekanan {
	private Integer id;
	private String nama;
	private String alamat;
	private String noTelp;
	private String kota;
	private String kodePos;
	private String jenis;
	private char statusDel;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	public String getAlamat() {
		return alamat;
	}
	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}
	public String getNoTelp() {
		return noTelp;
	}
	public void setNoTelp(String noTelp) {
		this.noTelp = noTelp;
	}
	public String getKota() {
		return kota;
	}
	public void setKota(String kota) {
		this.kota = kota;
	}
	public String getKodePos() {
		return kodePos;
	}
	public void setKodePos(String kodePos) {
		this.kodePos = kodePos;
	}
	public char getStatusDel() {
		return statusDel;
	}
	public void setStatusDel(char statusDel) {
		this.statusDel = statusDel;
	}
	public String getJenisLabel() {
		if (jenis.equals("pt"))
			return "Persero";
		else
			return "Commanditer";
	}
	public String getJenis() {
		return jenis; 
	}
	public void setJenis(String jenis) {
		this.jenis = jenis;
	}	
}















