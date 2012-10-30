package bean;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.Alternatif;
import service.AlternatifService;

@ManagedBean(name="alternatif")
@SessionScoped
public class AlternatifBean implements Serializable{
	private Integer id;
	private String kode;
	private int idTL;
	private Integer idRekanan;
	private Integer harga;
	private String namaRekanan;
	
	private AlternatifService service;
	private boolean status;
	
	public AlternatifBean() {
		service = new AlternatifService();
	}

	public String toViewAlt(int value) {
		idTL = value;
		return "viewAlt";
	}
	
	public List<Alternatif> getListAlternatif() {
		List<Alternatif> listAlternatif = new ArrayList<Alternatif>();
		
		try {
			listAlternatif = service.getManyData(idTL);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listAlternatif;
	}
	
//	public String getOneAlt(int idValue) {
//		Alternatif k = null;
//		status = true;
//		
//		try {
//			k = service.getOneData(idValue);
//			this.setId(k.getId());
//			this.setKode(k.getKode());
//			this.setNamaRekanan(k.getNamaRekanan());
//			this.setHarga(k.getHarga());
//			
//		} catch (ClassNotFoundException e) {
//			status = false;
//			e.printStackTrace();
//		} catch (SQLException e) {
//			status = false;
//			e.printStackTrace();
//		}
//		
//		if (status)
//			return "updateAlternatif";
//		else
//			return null;
//	}
	
	public void generateKode(Integer idValue) throws NumberFormatException {
		status = true;
		try {
			String lastKode = service.getLastKode(idValue);
			if (lastKode == null) lastKode="";
			String newKode = "A1";
			if (!lastKode.isEmpty()) {
				int newNumberKode = Integer.valueOf(lastKode.substring(1))+1;
				newKode= "A"+ newNumberKode;
			}			
			kode = newKode;	
		} catch (ClassNotFoundException e) {
			status=false;
			e.printStackTrace();
		} catch (SQLException e) {
			status=false;
			e.printStackTrace();
		} catch (NumberFormatException e) {
			throw new NumberFormatException();
		}
	}
	
	public String save() {	
		status=true;
		try {
			generateKode(idTL);
			Alternatif k = new Alternatif();
			k.setKode(this.getKode());
			k.setHarga(this.getHarga());
			k.setIdRekanan(this.getIdRekanan());
			k.setIdTL(this.getIdTL());
			k.setStatusDel('N');
			
			service.save(k);
		} catch (ClassNotFoundException e) {
			status=false;
			e.printStackTrace();
		} catch (SQLException e) {
			status=false;
			e.printStackTrace();
		}
		
		harga = 0;
		if (status)
			return "viewAlt";
		else
			return null;
	}
	
//	public String update() {	
//		status=true;
//		try {
//			Alternatif k = new Alternatif();
//			k.setId(this.getId());
//			k.setHarga(this.getHarga());
//			
//			service.update(k);
//		} catch (ClassNotFoundException e) {
//			status=false;
//			e.printStackTrace();
//		} catch (SQLException e) {
//			status=false;
//			e.printStackTrace();
//		}		
//		
//		if (status)
//			return "addAlternatif?faces-redirect=true";
//		else
//			return null;
//	}
	
	public String delete(int idValue) {	
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
		
//		if (status)
//			return "addAlternatif?faces-redirect=true";
//		else
			return null;
	}
	
	// set & get
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
	public int getIdTL() {
		return idTL;
	}
	public void setIdTL(int idTL) {
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
}
