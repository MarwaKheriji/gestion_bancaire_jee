package kheriji.marwa.dao;

import java.util.ArrayList;

import kheriji.marwa.metier.Client;

public interface IClientDao {
	
	
	Client save(Client c); //definition==signature==prototype==entete
	Client update (Client c);
	int delete (Client c);
	
	ArrayList<Client> getAll();
	ArrayList<Client> getAll(String nom);
	ArrayList<Client> getAll(String nom, String prenom);

	
	
	Client find (int id);
	Client find (String nom);
	Client find (String nom, String prenom);
	
	int count();
}



