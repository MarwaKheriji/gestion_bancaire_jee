package kheriji.marwa.metier;

import java.sql.Date;

public class DemandeCredit {
	
	private String num;
	private Date date;
	private double capital;
	private int duree;
	private double taux;
	private Double mensualite;
	private String etat;
	private Client client;
	
	
	
	public DemandeCredit() {
	}



	public DemandeCredit(String num, Date date, double capital, int duree, double taux, Double mensualite, String etat,
			Client client) {
		this.num = num;
		this.date = date;
		this.capital = capital;
		this.duree = duree;
		this.taux = taux;
		this.mensualite = mensualite;
		this.etat = etat;
		this.client = client;
	}



	public String getNum() {
		return num;
	}



	public void setNum(String num) {
		this.num = num;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	public double getCapital() {
		return capital;
	}



	public void setCapital(double capital) {
		this.capital = capital;
	}



	public int getDuree() {
		return duree;
	}



	public void setDuree(int duree) {
		this.duree = duree;
	}



	public double getTaux() {
		return taux;
	}



	public void setTaux(double taux) {
		this.taux = taux;
	}



	public Double getMensualite() {
		return mensualite;
	}



	public void setMensualite(Double mensualite) {
		this.mensualite = mensualite;
	}



	public String getEtat() {
		return etat;
	}



	public void setEtat(String etat) {
		this.etat = etat;
	}



	public Client getClient() {
		return client;
	}



	public void setClient(Client client) {
		this.client = client;
	}



	@Override
	public String toString() {
		return "DemandeCredit [num=" + num + ", date=" + date + ", capital=" + capital + ", duree=" + duree + ", taux="
				+ taux + ", mensualite=" + mensualite + ", etat=" + etat + ", client=" + client + "]";
	}

	
	
	
	
	
	
	
}




