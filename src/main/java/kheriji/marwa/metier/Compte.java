package kheriji.marwa.metier;
import java.sql.Date;
import java.util.ArrayList;


public class Compte {
	
	private String num;
	private Date creation;
	private double solde;
	private String type;
	private float taux;
	private float decouvert;
	private Client client;
	
	
	
	
	public Compte() {

	}


	public Compte(String num, Date creation, double solde, String type, float taux, float decouvert, Client client) {
		this.num = num;
		this.creation = creation;
		this.solde = solde;
		this.type = type;
		this.taux = taux;
		this.decouvert = decouvert;
		this.client=client;
	}

	
	

	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	public String getNum() {
		return num;
	}


	public void setNum(String num) {
		this.num = num;
	}


	public Date getCreation() {
		return creation;
	}


	public void setCreation(Date creation) {
		this.creation = creation;
	}


	public double getSolde() {
		return solde;
	}


	public void setSolde(double solde) {
		this.solde = solde;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public float getTaux() {
		return taux;
	}


	public void setTaux(float taux) {
		this.taux = taux;
	}


	public float getDecouvert() {
		return decouvert;
	}


	public void setDecouvert(float decouvert) {
		this.decouvert = decouvert;
	}


	@Override
	public String toString() {
		return "Compte [num=" + num + ", creation=" + creation + ", solde=" + solde + ", type=" + type + ", taux="
				+ taux + ", decouvert=" + decouvert + ", client=" + client + "]";
	}

	
	


}


