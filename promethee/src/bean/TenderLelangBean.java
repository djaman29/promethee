package bean;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.html.HtmlOutcomeTargetLink;
import javax.faces.event.ActionEvent;

import model.TenderLelang;
import service.TenderLelangService;

@ManagedBean(name="tender")
@RequestScoped
public class TenderLelangBean implements Serializable {
	
	private Integer id;
	private String ditPemesanan;
	private String pengadaanBarang;
	private String sumberDana;
	private String tahun;
	private Integer no;
	private String noSP3;
	private Date tglSP3;
	private Date tglTerimaSP3;
	private String uraianBarang;
	private String noRBiaya;
	private Date tglRBiaya;
	private String volRBiaya;
	private Integer rupRBiaya;
	private String noRks;
	private Date tglRks;
	private String progress;
	private Integer nilaiOE;
	private Integer nilaiKontrak;
	private Integer savingCost;
	private Short lamaProses;
	private char statusDel;
	
	private Integer idHidden;
	private String cari;
	private List<TenderLelang> listTenderLelang;
	private boolean onSearch = false;
	
	private TenderLelangService service;
	private boolean status;
	
	
	
	public TenderLelangBean() {
		service = new TenderLelangService();
	}

	public List<TenderLelang> getListTender() {
		if (!onSearch) {
			listTenderLelang = new ArrayList<TenderLelang>();
			
			try {
				listTenderLelang = service.getAllData();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		status = false;
		return listTenderLelang;
	}
	
	public String getOneTender(Integer id) {
		TenderLelang k = null;
		status = true;
		
		try {
			k = service.getOneData(id);
			this.setId(id);
			this.setIdHidden(id);
			this.setDitPemesanan(k.getDitPemesanan());
			this.setPengadaanBarang(k.getPengadaanBarang());
			this.setSumberDana(k.getSumberDana());
			this.setTahun(k.getTahun());
			this.setNo(k.getNo());
			this.setNoSP3(k.getNoSP3());
			this.setTglSP3(k.getTglSP3());
			this.setTglTerimaSP3(k.getTglTerimaSP3());
			this.setUraianBarang(k.getUraianBarang());
			this.setNoRBiaya(k.getNoRBiaya());
			this.setTglRBiaya(k.getTglRBiaya());
			this.setVolRBiaya(k.getVolRBiaya());
			this.setRupRBiaya(k.getRupRBiaya());
			this.setNoRks(k.getNoRks());
			this.setTglRks(k.getTglRks());
			this.setProgress(k.getProgress());
			this.setNilaiOE(k.getNilaiOE());
			this.setNilaiKontrak(k.getNilaiKontrak());
			this.setSavingCost(k.getSavingCost());
			this.setLamaProses(k.getLamaProses());
		} catch (ClassNotFoundException e) {
			status = false;
			e.printStackTrace();
		} catch (SQLException e) {
			status = false;
			e.printStackTrace();
		}
		
		if (status)
			return "updateTender";
		else
			return null;
	}
	
	public String save() {	
		status=true;
		try {
			TenderLelang k = new TenderLelang();
			
			k.setDitPemesanan(this.getDitPemesanan());
			k.setPengadaanBarang(this.getPengadaanBarang());
			k.setSumberDana(this.getSumberDana());
			k.setTahun(this.getTahun());
			k.setNo(this.getNo());
			k.setNoSP3(this.getNoSP3());
			k.setTglSP3(this.getTglSP3());
			k.setTglTerimaSP3(this.getTglTerimaSP3());
			k.setUraianBarang(this.getUraianBarang());
			k.setNoRBiaya(this.getNoRBiaya());
			k.setTglRBiaya(this.getTglRBiaya());
			k.setVolRBiaya(this.getVolRBiaya());
			k.setRupRBiaya(this.getRupRBiaya());
			k.setNoRks(this.getNoRks());
			k.setTglRks(this.getTglRks());
			k.setProgress(this.getProgress());
			k.setNilaiOE(this.getNilaiOE());
			k.setNilaiKontrak(this.getNilaiKontrak());
			k.setSavingCost(this.getSavingCost());
			k.setLamaProses(this.getLamaProses());
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
			return "viewTender?faces-redirect=true";
		else
			return null;
	}
	
	public String update() {	
		status=true;
		try {
			TenderLelang k = new TenderLelang();
			
			k.setId(this.getIdHidden());
			k.setDitPemesanan(this.getDitPemesanan());
			k.setPengadaanBarang(this.getPengadaanBarang());
			k.setSumberDana(this.getSumberDana());
			k.setTahun(this.getTahun());
			k.setNo(this.getNo());
			k.setNoSP3(this.getNoSP3());
			k.setTglSP3(this.getTglSP3());
			k.setTglTerimaSP3(this.getTglTerimaSP3());
			k.setUraianBarang(this.getUraianBarang());
			k.setNoRBiaya(this.getNoRBiaya());
			k.setTglRBiaya(this.getTglRBiaya());
			k.setVolRBiaya(this.getVolRBiaya());
			k.setRupRBiaya(this.getRupRBiaya());
			k.setNoRks(this.getNoRks());
			k.setTglRks(this.getTglRks());
			k.setProgress(this.getProgress());
			k.setNilaiOE(this.getNilaiOE());
			k.setNilaiKontrak(this.getNilaiKontrak());
			k.setSavingCost(this.getSavingCost());
			k.setLamaProses(this.getLamaProses());
			
			service.update(k);
		} catch (ClassNotFoundException e) {
			status=false;
			e.printStackTrace();
		} catch (SQLException e) {
			status=false;
			e.printStackTrace();
		}		
		
		if (status)
			return "viewTender?faces-redirect=true";
		else
			return null;
	}
	
	public String delete(Integer id) {	
		status=true;
		try {			
			service.delete(id);
		} catch (ClassNotFoundException e) {
			status=false;
			e.printStackTrace();
		} catch (SQLException e) {
			status=false;
			e.printStackTrace();
		}		
		
		if (status)
			return "viewTender?faces-redirect=true";
		else
			return null;
	}
	
	public String search() {
		onSearch = true;
		listTenderLelang = new ArrayList<TenderLelang>();
		
		try {
			listTenderLelang = service.getManyData(cari);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	// set & get
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDitPemesanan() {
		return ditPemesanan;
	}
	public void setDitPemesanan(String ditPemesanan) {
		this.ditPemesanan = ditPemesanan;
	}
	public String getPengadaanBarang() {
		return pengadaanBarang;
	}
	public void setPengadaanBarang(String pengadaanBarang) {
		this.pengadaanBarang = pengadaanBarang;
	}
	public String getSumberDana() {
		return sumberDana;
	}
	public void setSumberDana(String sumberDana) {
		this.sumberDana = sumberDana;
	}
	public String getTahun() {
		return tahun;
	}
	public void setTahun(String tahun) {
		this.tahun = tahun;
	}
	public Integer getNo() {
		return no;
	}
	public void setNo(Integer no) {
		this.no = no;
	}
	public String getNoSP3() {
		return noSP3;
	}
	public void setNoSP3(String noSP3) {
		this.noSP3 = noSP3;
	}
	public Date getTglSP3() {
		return tglSP3;
	}
	public void setTglSP3(Date tglSP3) {
		this.tglSP3 = tglSP3;
	}
	public Date getTglTerimaSP3() {
		return tglTerimaSP3;
	}
	public void setTglTerimaSP3(Date tglTerimaSP3) {
		this.tglTerimaSP3 = tglTerimaSP3;
	}
	public String getUraianBarang() {
		return uraianBarang;
	}
	public void setUraianBarang(String uraianBarang) {
		this.uraianBarang = uraianBarang;
	}
	public String getNoRBiaya() {
		return noRBiaya;
	}
	public void setNoRBiaya(String noRBiaya) {
		this.noRBiaya = noRBiaya;
	}
	public Date getTglRBiaya() {
		return tglRBiaya;
	}
	public void setTglRBiaya(Date tglRBiaya) {
		this.tglRBiaya = tglRBiaya;
	}
	public String getVolRBiaya() {
		return volRBiaya;
	}
	public void setVolRBiaya(String volRBiaya) {
		this.volRBiaya = volRBiaya;
	}
	public Integer getRupRBiaya() {
		return rupRBiaya;
	}
	public void setRupRBiaya(Integer rupRBiaya) {
		this.rupRBiaya = rupRBiaya;
	}
	public String getNoRks() {
		return noRks;
	}
	public void setNoRks(String noRks) {
		this.noRks = noRks;
	}
	public Date getTglRks() {
		return tglRks;
	}
	public void setTglRks(Date tglRks) {
		this.tglRks = tglRks;
	}
	public String getProgress() {
		return progress;
	}
	public void setProgress(String progress) {
		this.progress = progress;
	}
	public Integer getNilaiOE() {
		return nilaiOE;
	}
	public void setNilaiOE(Integer nilaiOE) {
		this.nilaiOE = nilaiOE;
	}
	public Integer getNilaiKontrak() {
		return nilaiKontrak;
	}
	public void setNilaiKontrak(Integer nilaiKontrak) {
		this.nilaiKontrak = nilaiKontrak;
	}
	public Integer getSavingCost() {
		return savingCost;
	}
	public void setSavingCost(Integer savingCost) {
		this.savingCost = savingCost;
	}
	public Short getLamaProses() {
		return lamaProses;
	}
	public void setLamaProses(Short lamaProses) {
		this.lamaProses = lamaProses;
	}
	public char getStatusDel() {
		return statusDel;
	}
	public void setStatusDel(char statusDel) {
		this.statusDel = statusDel;
	}
	public String getCari() {
		return cari;
	}
	public void setCari(String cari) {
		this.cari = cari;
	}

	public Integer getIdHidden() {
		return idHidden;
	}

	public void setIdHidden(Integer idHidden) {
		this.idHidden = idHidden;
	}
}
