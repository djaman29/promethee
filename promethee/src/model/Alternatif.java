package model;

import java.io.Serializable;

public class Alternatif implements Serializable {
	private Integer id;
	private String kode;
	private Integer idTL;
	private Integer idRekanan;
	private Integer harga;
	private char statusDel;
	
	private String namaRekanan;
		
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getKode() {
		return kode;
	}
	public void setKode(String kode) {
		this.kode = kode;
	}
	public Integer getIdTL() {
		return idTL;
	}
	public void setIdTL(Integer idTL) {
		this.idTL = idTL;
	}
	public Integer getIdRekanan() {
		return idRekanan;
	}
	public void setIdRekanan(Integer idRekanan) {
		this.idRekanan = idRekanan;
	}
	public Integer getHarga() {
		return harga;
	}
	public void setHarga(Integer harga) {
		this.harga = harga;
	}
	public String getNamaRekanan() {
		return namaRekanan;
	}
	public void setNamaRekanan(String namaRekanan) {
		this.namaRekanan = namaRekanan;
	}
	public char getStatusDel() {
		return statusDel;
	}
	public void setStatusDel(char statusDel) {
		this.statusDel = statusDel;
	}
}
