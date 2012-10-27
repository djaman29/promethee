package bean;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import model.Kriteria;

import service.KriteriaService;

@ManagedBean(name="kriteria")
@RequestScoped
public class KriteriaBean implements Serializable {
	
	private String kode;
	private String kodeHidden;
	private String nama;
	private Byte nilaiMin;
	private Byte nilaiMax;
	private Float bobot;
	private String tipePref;
	private String minmax;
	private Byte p;
	private Byte q;
	private Byte g;
	private char statusDel;
	
	private KriteriaService service;
	private boolean status;
	
	
	public KriteriaBean() {
		service = new KriteriaService();
	}
	
	public void createNilaiKompetensi(ActionEvent e) {
	
	}

	public List<Kriteria> getListKriteria() {
		List<Kriteria> listKriteria = new ArrayList<Kriteria>();
		
		try {
			listKriteria = service.getAllData();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listKriteria;
	}
	
	public String getOneKriteria(String kd) {
		Kriteria k = null;
		status = true;
		
		try {
			k = service.getOneData(kd);
			this.setKode(k.getKode());
			this.setKodeHidden(k.getKode());
			this.setNama(k.getNama());
			this.setNilaiMin(k.getNilaiMin());
			this.setNilaiMax(k.getNilaiMax());
			this.setBobot(k.getBobot());
			this.setTipePref(k.getTipePref());
			this.setMinmax(k.getMinmax());
			this.setP(k.getP());
			this.setQ(k.getQ());
			this.setG(k.getG());
		} catch (ClassNotFoundException e) {
			status = false;
			e.printStackTrace();
		} catch (SQLException e) {
			status = false;
			e.printStackTrace();
		}
		
		if (status)
			return "updateKriteria";
		else
			return null;
	}
	
	public String generateKode() {
		status = true;
		try {
			String lastKode = service.getLastKode();
			if (lastKode == null) lastKode="";
			String newKode = "K01";
			if (!lastKode.isEmpty()) {
				int newNumberKode = Integer.valueOf(lastKode.substring(1))+1;
				
				if (newNumberKode < 10) {
					newKode= "K0"+ newNumberKode;
				}
				else if (newNumberKode < 100) {
					newKode= "K"+ newNumberKode;
				}
			}			
			kode = newKode;			
		} catch (ClassNotFoundException e) {
			status=false;
			e.printStackTrace();
		} catch (SQLException e) {
			status=false;
			e.printStackTrace();
		}
		
		if (status)
			return "saveKriteria";
		else
			return null;
	}
	
	public String save() {	
		status=true;
		try {
			Kriteria k = new Kriteria();
			k.setKode(this.getKode());
			k.setNama(this.getNama());
			k.setNilaiMin(this.getNilaiMin());
			k.setNilaiMax(this.getNilaiMax());
			k.setBobot(this.getBobot());
			k.setTipePref(this.getTipePref());
			k.setMinmax(this.getMinmax());
			k.setP(this.getP());
			k.setQ(this.getQ());
			k.setG(this.getG());
			k.setStatusDel('N');
			
			service.save(k);
		} catch (ClassNotFoundException e) {
			status=false;
			e.printStackTrace();
		} catch (SQLException e) {
			status=false;
			e.printStackTrace();
		}
		
		if (status)
			return "viewKriteria?faces-redirect=true";
		else
			return null;
	}
	
	public String update() {	
		status=true;
		try {
			Kriteria k = new Kriteria();
			k.setKode(this.getKodeHidden());
			k.setNama(this.getNama());
			k.setNilaiMin(this.getNilaiMin());
			k.setNilaiMax(this.getNilaiMax());
			k.setBobot(this.getBobot());
			k.setTipePref(this.getTipePref());
			k.setMinmax(this.getMinmax());
			k.setP(this.getP());
			k.setQ(this.getQ());
			k.setG(this.getG());
			
			service.update(k);
		} catch (ClassNotFoundException e) {
			status=false;
			e.printStackTrace();
		} catch (SQLException e) {
			status=false;
			e.printStackTrace();
		}		
		
		if (status)
			return "viewKriteria?faces-redirect=true";
		else
			return null;
	}
	
	public String delete(String kd) {	
		status=true;
		try {			
			service.delete(kd);
		} catch (ClassNotFoundException e) {
			status=false;
			e.printStackTrace();
		} catch (SQLException e) {
			status=false;
			e.printStackTrace();
		}		
		
		if (status)
			return "viewKriteria?faces-redirect=true";
		else
			return null;
	}
	
	// set & get
	public String getKode() {
		return kode;
	}
	public void setKode(String kode) {
		this.kode = kode;
	}
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	public Byte getNilaiMin() {
		return nilaiMin;
	}
	public void setNilaiMin(Byte nilaiMin) {
		this.nilaiMin = nilaiMin;
	}
	public Byte getNilaiMax() {
		return nilaiMax;
	}
	public void setNilaiMax(Byte nilaiMax) {
		this.nilaiMax = nilaiMax;
	}
	public Float getBobot() {
		return bobot;
	}
	public void setBobot(Float bobot) {
		this.bobot = bobot;
	}
	public String getTipePref() {
		return tipePref;
	}
	public void setTipePref(String tipePref) {
		this.tipePref = tipePref;
	}
	public String getMinmax() {
		return minmax;
	}
	public void setMinmax(String minmax) {
		this.minmax = minmax;
	}
	public Byte getP() {
		return p;
	}
	public void setP(Byte p) {
		this.p = p;
	}
	public Byte getQ() {
		return q;
	}
	public void setQ(Byte q) {
		this.q = q;
	}
	public Byte getG() {
		return g;
	}
	public void setG(Byte g) {
		this.g = g;
	}
	public char getStatusDel() {
		return statusDel;
	}
	public void setStatusDel(char statusDel) {
		this.statusDel = statusDel;
	}

	public String getKodeHidden() {
		return kodeHidden;
	}

	public void setKodeHidden(String kodeHidden) {
		this.kodeHidden = kodeHidden;
	}
}
