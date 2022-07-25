package kheriji.marwa.dao;

import java.util.ArrayList;

import kheriji.marwa.metier.Compte;

public interface ICompteDao {
	
	
	Compte save(Compte c); //definition==signature==prototype==entete
	Compte update (Compte c);
	int delete (Compte c);
	
	ArrayList<Compte> getAll(int idclient);
	
	Compte find (String numero);

}
