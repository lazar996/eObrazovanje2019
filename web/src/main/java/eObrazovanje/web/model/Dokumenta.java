package eObrazovanje.web.model;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity(name="dokumenta")
public class Dokumenta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dokumenti_id")
	private Integer dokumentId;
	
	@Column(nullable = false)
	private String naziv;
	
	@Column(nullable = false, name = "tip_dokumenta")
	private String tipDokumenta;
	
	
	  @Column(nullable = false,name = "download_uri")
	    private String downloadUri;

	  
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="jmbg", referencedColumnName = "jmbg", nullable = true)
	private Ucenik ucenik;
	
	
	
	public Dokumenta() {
		
	}






	public Integer getDokumentId() {
		return dokumentId;
	}



	public void setDokumentId(Integer dokumentId) {
		this.dokumentId = dokumentId;
	}



	public String getNaziv() {
		return naziv;
	}



	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}



	public String getTipDokumenta() {
		return tipDokumenta;
	}



	public void setTipDokumenta(String tipDokumenta) {
		this.tipDokumenta = tipDokumenta;
	}



	public Ucenik getUcenik() {
		return ucenik;
	}



	public void setUcenik(Ucenik ucenik) {
		this.ucenik = ucenik;
	}



	public String getDownloadUri() {
		return downloadUri;
	}



	public void setDownloadUri(String downloadUri) {
		this.downloadUri = downloadUri;
	}



    @Override
    public String toString() {
        return "Dokument{" +
                "dokumentId=" + dokumentId +
                ", naziv='" + naziv + '\'' +
                ", tipDokumenta='" + tipDokumenta + '\'' +
                ", downloadUri= '" + downloadUri +'\''+
                ", ucenik=" + ucenik +
                '}';
    }
	



}
