<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<title>Liste des crédits</title>
</head>
<body>
<%@ include file ="layout/credit-navbar.jsp"  %>

<div class="container">

<h4 class="mt-4">Liste des demandes de crédits</h4>


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
      <th scope="col">Numéro</th>
		<th scope="col">Date</th>      
		<th scope="col">Capital</th>
		<th scope="col">Durée</th>
		<th scope="col">Taux</th>
		<th scope="col">Mensualité</th>
		<th scope="col">Etat</th>
		<th scope="col">Id client</th>
		<th></th>
		<th></th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var ="c" items="${credits}">
	   <tr>
	      <td>${c.getNum()}</td>
	      <td>${c.getDate()}</td>
	      <td>${c.getCapital()}</td>
	      <td>${c.getDuree()}</td>
	      <td>${c.getTaux()}</td>
	      <td>${c.getMensualite()}</td>
	      <td style= color:blue >${c.getEtat()}</td>
	      <td>${c.getClient().getId() }</td>
	      <td><a href="delete-credit?num=${c.getNum() }">Supprimer</a></td>
	      <td><a href="edit-credit?num=${c.getNum() }">Modifier</a></td>
	      
    </tr>  
  
  </c:forEach>

    
  </tbody>
</table>
</div>


</body>
</html>
