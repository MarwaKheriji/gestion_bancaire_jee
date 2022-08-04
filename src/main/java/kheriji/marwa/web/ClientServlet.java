package kheriji.marwa.web;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kheriji.marwa.dao.ClientDaoImpl;
import kheriji.marwa.dao.CompteDaoImpl;
import kheriji.marwa.dao.DemandeCreditDaoImpl;
import kheriji.marwa.metier.Client;
import kheriji.marwa.metier.Compte;
import kheriji.marwa.metier.DemandeCredit;

@WebServlet("/")
public class ClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ClientDaoImpl cdi = new ClientDaoImpl();
	private CompteDaoImpl compteImpl = new CompteDaoImpl();
	private DemandeCreditDaoImpl creditImpl = new DemandeCreditDaoImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
       
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		System.out.println(path);
		ArrayList<Client> clients;
		ArrayList<Compte> comptes;
		ArrayList<DemandeCredit> credits;
		Client c = new Client();
		Compte cpte = new Compte();
		DemandeCredit credit= new DemandeCredit();
		switch(path) {
		
			case "/liste-client":
			clients = cdi.getAll();
				request.setAttribute("clients", clients);
			request.getRequestDispatcher("liste-client.jsp").forward(request,response);
			break;
			
			case "/new-client":
				request.getRequestDispatcher("new-client.jsp").forward(request,response);
			break;
			case "/save-client":
				String nom = request.getParameter("nom");
				String prenom = request.getParameter("prenom");
				String dateNaissance = request.getParameter("date-naissance");
				String tel = request.getParameter("tel");
				String mail = request.getParameter("mail");
				String civilite = request.getParameter("civilite");
				String adresse = request.getParameter("adresse");
				
				c = new Client(nom, prenom, Date.valueOf(dateNaissance), adresse, tel, mail, civilite);
				c = cdi.save(c);
				
				request.setAttribute("client", c);
				request.getRequestDispatcher("confirmation.jsp").forward(request, response);		
				break;

			case "/delete-client":
				int id = Integer.parseInt(request.getParameter("idclient"));
				c = new Client();
				c.setId(id);
				cdi.delete(c);
				response.sendRedirect("liste-client");
				/*
				clients = cdi.getAll();
				request.setAttribute("clients", clients);
			request.getRequestDispatcher("liste-client.jsp").forward(request,response);
				
				*/
				break;
				
			case "/detail-client":
				int idclient = Integer.parseInt(request.getParameter("idclient"));
				c=cdi.find(idclient);
				request.setAttribute("client" , c);
				request.getRequestDispatcher("detail-client.jsp").forward(request, response);

				break;
			case "/find":
				nom = request.getParameter("nom");
				prenom = request.getParameter("prenom");
				
				clients = cdi.getAll(nom, prenom);
				
				//Passer le tableau des clients a la vue (list-client.jsp)
				request.setAttribute("clients", clients);
				//afficher une page jsp
				request.getRequestDispatcher("liste-client.jsp").forward(request, response);
				
				break;
				
				/*********************COMPTE**************************/
				
			case "/liste-compte":
				idclient = Integer.parseInt(request.getParameter("idclient"));
				comptes=compteImpl.getAll(idclient);
				request.setAttribute("comptes", comptes);//mise a disponibilité la liste des comptes dans la page jsp
				c=cdi.find(idclient);
				request.setAttribute("client", c);
				request.getRequestDispatcher("liste-compte.jsp").forward(request, response);
			break;
			
			case "/save-compte":
				String num = request.getParameter("num");
				String creation = request.getParameter("creation");
				double solde = Double.parseDouble( request.getParameter("solde"));
				String type = request.getParameter("type");
				float taux =  Float.parseFloat(request.getParameter("taux"));
				float decouvert =  Float.parseFloat(request.getParameter("decouvert"));
				int idClient = Integer.parseInt(request.getParameter("idclient")) ;
				c = cdi.find(idClient);
				cpte= new Compte(num, Date.valueOf(creation), solde, type, taux, decouvert, c);
				cpte=compteImpl.save(cpte);
				System.out.println(cpte);
				
				request.setAttribute("compte", cpte);
				request.getRequestDispatcher("confirmation-compte.jsp").forward(request, response);		
				break;
				
			case "/new-compte":
				request.getRequestDispatcher("new-compte.jsp").forward(request,response);
			break;

			
			case "/edit-compte":
				
				
			break;
			
			case "/delete-compte":
				num = request.getParameter("num");
				cpte = compteImpl.find(num) ;		
				compteImpl.delete(cpte);
				response.sendRedirect("liste-compte?idclient="+cpte.getClient().getId());
				
			break;
			
			/********************CREDIT***********************/
			
			case "/liste-credit":
				idclient = Integer.parseInt(request.getParameter("idclient"));
				System.out.println(idclient);
				credits=creditImpl.getAll(idclient);
				for (DemandeCredit credit1 : credits) {
				System.out.println(credit1);
			}
				request.setAttribute("credits", credits);//mise a disponibilité la liste des demandes credit dans la page jsp
				c=cdi.find(idclient);
				request.setAttribute("client", c);
				request.getRequestDispatcher("liste-credit.jsp").forward(request, response);
			break;
			
			case "/save-credit":
				String numero = request.getParameter("num");
				String dateCredit = request.getParameter("date");
				double capital = Double.parseDouble( request.getParameter("capital"));
				int duree = Integer.parseInt( request.getParameter("duree"));
				double tauxCredit = Double.parseDouble( request.getParameter("taux"));
				//double mensualite =  Double.parseDouble(request.getParameter("mensualite"));
				String etat =  request.getParameter("etat");
				int idcl = Integer.parseInt(request.getParameter("idclient")) ;
				c = cdi.find(idcl);		
				double m=( ((capital*tauxCredit)/12) / (1-Math.pow(1+(tauxCredit/12), -duree)) );
				credit= new DemandeCredit(numero, Date.valueOf(dateCredit), capital, duree, tauxCredit, m, etat, c);
				credit.setMensualite(m);
				System.out.println("mensualite : " + m);
				System.out.println("client " + credit);
				credit=creditImpl.save(credit);
				System.out.println(credit);
				
				request.setAttribute("credits", credit);
				request.getRequestDispatcher("confirmation-credit.jsp").forward(request, response);		
				break;

		
			case "/new-credit":
				request.getRequestDispatcher("new-credit.jsp").forward(request,response);
			break;
			
			case "/delete-credit":
				numero = request.getParameter("num");
				credit = creditImpl.find(numero) ;		
				creditImpl.delete(credit);
				response.sendRedirect("liste-credit?idclient="+credit.getClient().getId());
			break;

			
			case"/update-Demande":
				 numero = request.getParameter("num");
				 dateCredit = request.getParameter("date");
				 capital = Double.parseDouble( request.getParameter("capital"));
				 duree = Integer.parseInt( request.getParameter("duree"));
				 tauxCredit = Double.parseDouble( request.getParameter("taux"));
				 //mensualite =  Double.parseDouble(request.getParameter("mensualite"));
				 etat =  request.getParameter("etat");
				 idcl = Integer.parseInt(request.getParameter("idclient")) ;
				
				c=cdi.find(idcl);
				credit = creditImpl.find(numero);
				
				
				credit= creditImpl.update(credit);
				request.setAttribute("credits", credit);
				request.getRequestDispatcher("confirmation-Demande.jsp").forward(request, response);
				break;	
			
		default:
			request.getRequestDispatcher("index.jsp").forward(request, response);
			break;
		}
		
		
		
		
	}

	




}
