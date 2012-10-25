package bean;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import model.Rekanan;
import service.RekananService;

@ManagedBean(name="rekanan")
@RequestScoped
public class RekananBean implements Serializable {
	private Integer id;
	private String nama;
	private String alamat;
	private String noTelp;
	private String kota;
	private String kodePos;
	private char statusDel;
	private Integer idHidden;
	private String jenis;
	
	private RekananService service;
	private boolean status;
	
	
	public RekananBean() {
		service = new RekananService();
	}

	public List<Rekanan> getListRekanan() {
		List<Rekanan> listRekanan = new ArrayList<Rekanan>();
		
		try {
			listRekanan = service.getAllData();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listRekanan;
	}
	
	public String getOneRekanan(Integer idValue) {
		Rekanan k = null;
		status = true;
		
		try {
			k = service.getOneData(idValue);
			this.setId(idValue);
			this.setIdHidden(idValue);
			this.setNama(k.getNama());
			this.setAlamat(k.getAlamat());
			this.setNoTelp(k.getNoTelp());
			this.setKota(k.getKota());
			this.setKodePos(k.getKodePos());
			this.setJenis(k.getJenis());
		} catch (ClassNotFoundException e) {
			status = false;
			e.printStackTrace();
		} catch (SQLException e) {
			status = false;
			e.printStackTrace();
		}
		
		if (status)
			return "updateRekanan";
		else
			return null;
	}
	
	public String save() {	
		status=true;
		try {
			Rekanan k = new Rekanan();
			k.setNama(this.getNama());
			k.setAlamat(this.getAlamat());
			k.setNoTelp(this.getNoTelp());
			k.setKota(this.getKota());
			k.setKodePos(this.getKodePos());
			k.setStatusDel('N');
			k.setJenis(this.getJenis());
			service.save(k);
		} catch (ClassNotFoundException e) {
			status=false;
			e.printStackTrace();
		} catch (SQLException e) {
			status=false;
			e.printStackTrace();
		}
		
		if (status)
			return "viewRekanan?faces-redirect=true";
		else
			return null;
	}
	
	public String update() {	
		status=true;
		try {
			Rekanan k = new Rekanan();
			k.setId(this.getIdHidden());
			k.setNama(this.getNama());
			k.setAlamat(this.getAlamat());
			k.setNoTelp(this.getNoTelp());
			k.setKota(this.getKota());
			k.setKodePos(this.getKodePos());
			k.setJenis(this.getJenis());
			service.update(k);
		} catch (ClassNotFoundException e) {
			status=false;
			e.printStackTrace();
		} catch (SQLException e) {
			status=false;
			e.printStackTrace();
		}		
		
		if (status)
			return "viewRekanan?faces-redirect=true";
		else
			return null;
	}
	
	public String delete(Integer idValue) {	
		status=true;
		try {			
			service.delete(idValue);
		} catch (ClassNotFoundException e) {
			status=false;
			e.printStackTrace();
		} catch (SQLException e) {
			status=false;
			e.printStackTrace();
		}		
		
		if (status)
			return "viewRekanan?faces-redirect=true";
		else
			return null;
	}
	
	
	//set & get
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

	public Integer getIdHidden() {
		return idHidden;
	}

	public void setIdHidden(Integer idHidden) {
		this.idHidden = idHidden;
	}

	public String getJenis() {
		return jenis;
	}

	public void setJenis(String jenis) {
		this.jenis = jenis;
	}	
}
