<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<title>Liste des comptes</title>
</head>
<body>
<%@ include file ="layout/compte-navbar.jsp"  %>

<div class="container">

<h4 class="mt-4">Liste des comptes</h4>

<!-- <form method = "post" action="find">
	 <div class="form-group row mb-3">
	    
	    <div class="col-sm-3">
	      <input type="text" class="form-control" name="nom" placeholder="Nom">
	    </div>
	    
	    <div class="col-sm-3">
	      <input type="text" class="form-control" name="prenom" placeholder="Prénom">
	    </div>
	    
	    <button type="submit" class="btn btn-primary col-sm-2 mb-2">Chercher</button>
	  </div>
	  
	 </form>
 -->	

	<div class="form-group row mb-3 col-sm-6">
	
	<label class="col-sm-4 col-form-label"> Identifiant client : ${client.getId() }</label>
	<label class="col-sm-4 col-form-label"> Nom : ${client.getNom() }</label>
	<label class="col-sm-4 col-form-label"> Prénom: ${client.getPrenom() }</label>
	<div>
		<input hidden type="text" class="form-control" name="idclient" value=${client.getId() }>
	</div>
	
	</div>

<table class="table">
  <thead>
    <tr>
      <th scope="col">Numéro de compte</th>
		<th scope="col">Date de création</th>
		<th scope="col">Solde</th>
		<th scope="col">Type du compte</th>
		<th scope="col">Taux</th>
		<th scope="col">Découvert</th>
		<th scope="col">Id client</th>
		<th></th>
		<th></th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var ="c" items="${ comptes}">
	   <tr>
	      <td>${c.getNum() }</td>
	      <td>${c.getCreation() }</td>
	      <td>${c.getSolde() }</td>
	      <td>${c.getType() }</td>
	      <td>${c.getTaux() }</td>
	      <td>${c.getDecouvert() }</td>
	      <td>${c.getClient().getId() }</td>
	      <td><a href="delete-compte?num=${c.getNum() }">Supprimer</a></td>
	      <td><a href="edit-compte?num=${c.getNum() }">Modifier</a></td>
	      
    </tr>  
  
  </c:forEach>

    
  </tbody>
</table>
</div>


</body>
</html>
