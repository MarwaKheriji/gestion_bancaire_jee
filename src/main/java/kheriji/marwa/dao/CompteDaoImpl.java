package kheriji.marwa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kheriji.marwa.metier.Client;
import kheriji.marwa.metier.Compte;

public class CompteDaoImpl implements ICompteDao {

	Connection cnx = SingletonConnection.getConnection();

	@Override
	public Compte save(Compte c) {
				
		PreparedStatement cps;

			try {
				cps = cnx.prepareStatement ("Insert into compte (num, "
						+ "creation,"
						+ "solde,"
						+ "type,"
						+ "taux,"
						+ "decouvert,"
						+ "idclient) values(?,?,?,?,?,?,?)");
				
				cps.setString(1, c.getNum());
				cps.setDate(2, c.getCreation());
				cps.setDouble(3, c.getSolde());
				cps.setString(4, c.getType());
				cps.setFloat(5, c.getTaux());
				cps.setFloat(6, c.getDecouvert());
				cps.setInt(7, c.getClient().getId());
				
				cps.executeUpdate();
				cps.close();
				return c;

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
					
	}

	@Override
	public Compte update(Compte c) {
		try {
			PreparedStatement cps = cnx.prepareStatement("update compte set"				
					+ " creation = ?,"
					+ " solde = ?,"
					+ " type= ?,"
					+ " taux = ?,"
					+ " decouvert = ?"
					+ " where num = ?");
			
			
			cps.setDate(1, c.getCreation());
			cps.setDouble(2, c.getSolde());
			cps.setString(3, c.getType());
			cps.setFloat(4, c.getTaux());
			cps.setFloat(5, c.getDecouvert());
			cps.setString(6, c.getNum());
			
			cps.executeUpdate();
			cps.close();
			
			return this.find(c.getNum());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int delete(Compte c) {
		try {
			PreparedStatement cps = cnx.prepareStatement("delete from compte where num = ?");

			cps.setString(1, c.getNum());
			
			return cps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public ArrayList<Compte> getAll(int idclient) {
		ArrayList<Compte> listeCompte =  new ArrayList<Compte>();
		try {
			PreparedStatement cps = cnx.prepareStatement("select * from compte where idclient = ?");
			
			cps.setInt(1, idclient );
			ResultSet crs = cps.executeQuery();
			
			Compte c ;
			ClientDaoImpl cdi = new ClientDaoImpl();
			Client cl=cdi.find(idclient);
			while(crs.next()) {
				c = new Compte();
				c.setNum(crs.getString("num"));
				c.setCreation(crs.getDate("creation"));
				c.setSolde(crs.getDouble("solde"));
				c.setType(crs.getString("type"));
				c.setTaux(crs.getFloat("taux"));
				c.setDecouvert(crs.getFloat("decouvert"));
				c.setClient(cl);
				listeCompte.add(c);	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listeCompte;
	}

	@Override
	public Compte find(String numero) {
		
		try {
			PreparedStatement cps = cnx.prepareStatement("select * from compte where num = ?");
			
			cps.setString(1, numero);
			ResultSet crs = cps.executeQuery();
			ClientDaoImpl cdi = new ClientDaoImpl();
			
			
			if (crs.next()) {
				Compte c = new Compte();
				c.setNum(crs.getString("num"));
				c.setCreation(crs.getDate("creation"));
				c.setSolde(crs.getDouble("solde"));
				c.setType(crs.getString("type"));
				c.setTaux(crs.getFloat("taux"));
				c.setDecouvert(crs.getFloat("decouvert"));
				Client cl=cdi.find(crs.getInt("idclient"));
				c.setClient(cl);
				return c;				
			}			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}


}
