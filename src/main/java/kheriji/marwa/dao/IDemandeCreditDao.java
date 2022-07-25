package kheriji.marwa.dao;

import java.util.ArrayList;

import kheriji.marwa.metier.Compte;
import kheriji.marwa.metier.DemandeCredit;

public interface IDemandeCreditDao {
	
	
	DemandeCredit save(DemandeCredit demande); //definition==signature==prototype==entete
	DemandeCredit update (DemandeCredit demande);
	int delete (DemandeCredit demande);
	
	ArrayList<DemandeCredit> getAll(int idclient);
	
	DemandeCredit find (String numero);

}
