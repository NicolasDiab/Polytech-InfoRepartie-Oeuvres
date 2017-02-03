package metier;

import java.io.Serializable;
import java.util.Date;


/**
 * The persistent class for the reservation database table.
 * 
 */
public class Reservation implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Date date;
	private Adherent adherent;
	private OeuvreVente oeuvreVente;

	public Reservation() {
	}



	public Reservation(Date date, Adherent adherent, OeuvreVente oeuvreVente) {
		super();
		this.date = date;
		this.adherent = adherent;
		this.oeuvreVente = oeuvreVente;
	}



	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
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

}