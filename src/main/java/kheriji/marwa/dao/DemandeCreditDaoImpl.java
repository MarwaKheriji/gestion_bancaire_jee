package kheriji.marwa.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kheriji.marwa.metier.Client;
import kheriji.marwa.metier.Compte;
import kheriji.marwa.metier.DemandeCredit;

public class DemandeCreditDaoImpl implements IDemandeCreditDao{
	
	Connection cnx = SingletonConnection.getConnection();


	@Override
	public DemandeCredit save(DemandeCredit demande) {

		
	PreparedStatement cps;

		try {
			cps = cnx.prepareStatement ("Insert into demande (num, "
					+ "date,"
					+ "capital,"
					+ "duree,"
					+ "taux,"
					+ "mensualite,"
					+ "etat,"
					+ "idclient) values(?,?,?,?,?,?,?,?)");
			
			cps.setString(1, demande.getNum());
			cps.setDate(2, demande.getDate());
			cps.setDouble(3, demande.getCapital());
			cps.setInt(4, demande.getDuree());
			cps.setDouble(5, demande.getTaux());
			cps.setDouble(6, demande.getMensualite());	
			cps.setString(7, demande.getEtat());
			cps.setInt(8, demande.getClient().getId());
			
			cps.executeUpdate();
			cps.close();
			return demande;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public DemandeCredit update(DemandeCredit demande) {
		try {
			PreparedStatement cps = cnx.prepareStatement("update demande set"		
					+ " date = ?,"
					+ " capital = ?,"
					+ " duree = ?,"
					+ " taux= ?,"
					+ " mensualite= ?,"
					+ " etat = ?"
					+ " where num = ?");
			
		
			cps.setDate(1, demande.getDate());
			cps.setDouble(2, demande.getCapital());
			cps.setInt(3, demande.getDuree());
			cps.setDouble(4, demande.getTaux());
			cps.setDouble(5, demande.getMensualite());
			cps.setString(6, demande.getEtat());
			cps.setString(7, demande.getNum());
			
			cps.executeUpdate();
			cps.close();
			
			return this.find(demande.getNum());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int delete(DemandeCredit demande) {
		try {
			PreparedStatement cps = cnx.prepareStatement("delete from demande where num = ?");

			cps.setString(1, demande.getNum());
			
			return cps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public ArrayList<DemandeCredit> getAll(int idclient) {
		ArrayList<DemandeCredit> listeDemande =  new ArrayList<DemandeCredit>();
		try {
			PreparedStatement cps = cnx.prepareStatement("select * from demande where idclient = ?");
			
			cps.setInt(1, idclient );
			ResultSet crs = cps.executeQuery();
			
			DemandeCredit dc ;
			ClientDaoImpl cdi = new ClientDaoImpl();
			Client cl=cdi.find(idclient);
			while(crs.next()) {
				dc = new DemandeCredit();
				dc.setNum(crs.getString("num"));
				dc.setDate(crs.getDate("date"));
				dc.setCapital(crs.getDouble("capital"));
				dc.setDuree(crs.getInt("duree"));
				dc.setTaux(crs.getDouble("taux"));
				dc.setMensualite(crs.getDouble("mensualite"));
				dc.setEtat(crs.getString("etat"));
				dc.setClient(cl);
				listeDemande.add(dc);	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listeDemande;
	}

	@Override
	public DemandeCredit find(String numero) {

		try {
			PreparedStatement cps = cnx.prepareStatement("select * from demande where num = ?");
			
			cps.setString(1, numero);
			ResultSet crs = cps.executeQuery();
			ClientDaoImpl cdi = new ClientDaoImpl();
			
			
			if (crs.next()) {
				DemandeCredit dc = new DemandeCredit();
				dc.setNum(crs.getString("num"));
				dc.setDate(crs.getDate("date"));
				dc.setCapital(crs.getDouble("capital"));
				dc.setDuree(crs.getInt("duree"));
				dc.setTaux(crs.getDouble("taux"));
				dc.setMensualite(crs.getDouble("mensualite"));
				dc.setEtat(crs.getString("etat"));
				Client cl=cdi.find(crs.getInt("idclient"));
				dc.setClient(cl);
				return dc;				
			}			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}


}
