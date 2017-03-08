package metier;

import utils.FonctionsUtiles;

import java.io.Serializable;
import java.util.Date;


/**
 * The persistent class for the reservation database table.
 * 
 */
public class Reservation implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Date date;
	private String dateString;
	private String statut;
	private Adherent adherent;
	private OeuvreVente oeuvreVente;

	public Reservation() {
	}



	public Reservation(Date date, String statut, Adherent adherent, OeuvreVente oeuvreVente) {
		super();
		this.date = date;
        try {
            this.dateString = FonctionsUtiles.conversionDateenChaine(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.setStatut(statut);
		this.adherent = adherent;
		this.oeuvreVente = oeuvreVente;
	}



	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
	    this.date = date;
        try {
            this.dateString = FonctionsUtiles.conversionDateenChaine(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	public Adherent getAdherent() {
		return this.adherent;
	}

	public void setAdherent(Adherent adherent) {
		this.adherent = adherent;
	}

	public OeuvreVente getOeuvreVente() {
		return this.oeuvreVente;
	}

	public void setOeuvreVente(OeuvreVente oeuvreVente) {
		this.oeuvreVente = oeuvreVente;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}
}