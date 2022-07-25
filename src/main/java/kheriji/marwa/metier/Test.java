package kheriji.marwa.metier;

import java.sql.Date;
import java.util.ArrayList;

import kheriji.marwa.dao.ClientDaoImpl;
import kheriji.marwa.dao.CompteDaoImpl;

public class Test {

	public static void main(String[] args) {
		
		CompteDaoImpl cptd = new CompteDaoImpl();
		
		ClientDaoImpl cdi = new ClientDaoImpl();
		ArrayList<Compte> comptes;
		Client c1= cdi.find(14);
		Compte cpte = new Compte("2473358L34", Date.valueOf("2005-06-07"), 3000, "courant", 0, 0, c1);
		Compte cpte2 = new Compte("2983358K56", Date.valueOf("2020-06-07"), 3000, "epargne", 0, 0, c1);
		Compte compte;
		//compte=cptd.save(cpte2);
		//compte=cptd.save(cpte);
		//cpte2.setSolde(7899);
		//compte=cptd.update(cpte2);
		
		//compte=cptd.delete(cpte2);
		//comptes=cptd.getAll(14);
		//System.out.println(comptes.size());
		System.out.println(cptd.find("2473358L34"));
		
		
		

	}

}
