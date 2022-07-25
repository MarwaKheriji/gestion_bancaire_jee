
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<title>Nouveau client</title>
</head>
<body>
<%@ include file ="layout/navbar.jsp"  %>
<div class="container">
	<h4 class="mt-4">Nouveau client</h4>
	
<form method = "post" action = "save-client">
	  <div class="form-group row mb-3">
	    <label class="col-sm-2 col-form-label">Nom : </label>
	    <div class="col-sm-4">
	      <input type="text" class="form-control" name="nom">
	    </div>
	  </div>
	  
	  <div class="form-group row mb-3">
	    <label class="col-sm-2 col-form-label">Pr�nom : </label>
	    <div class="col-sm-4">
	      <input type="text" class="form-control" name="prenom">
	    </div>
	  </div>
	  
	  <div class="form-group row mb-3">
	    <label class="col-sm-2 col-form-label">Date de naissance : </label>
	    <div class="col-sm-4">
	      <input type="text" class="form-control" name="date-naissance">
	    </div>
	  </div>
	  
	  <div class="form-group row mb-3">
	    <label class="col-sm-2 col-form-label">Adresse : </label>
	    <div class="col-sm-4">
	      <input type="text" class="form-control" name="adresse">
	    </div>
	  </div>
	  
	  <div class="form-group row mb-3">
	    <label class="col-sm-2 col-form-label">T�l : </label>
	    <div class="col-sm-4">
	      <input type="text" class="form-control" name="tel">
	    </div>
	  </div>
	  
	  <div class="form-group row mb-3">
	    <label class="col-sm-2 col-form-label">Mail : </label>
	    <div class="col-sm-4">
	      <input type="text" class="form-control" name="mail">
	    </div>
	  </div>
	  
	  <div class="form-group row mb-3">
	    <label class="col-sm-2 col-form-label">Civilit� : </label>
	    <div class="col-sm-4">
	      <input type="text" class="form-control" name="civilite">
	    </div>
	  </div>
	  <button type="submit" class="btn btn-primary mb-2">Enregistrer</button>
	</form>
	  
</div>


</body>
</html>