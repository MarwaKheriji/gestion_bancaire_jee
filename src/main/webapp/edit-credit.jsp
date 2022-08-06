
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<title>Modfication Crédit</title>
</head>
<body>
	<%@ include file="layout/credit-navbar.jsp"%>
	<div class="container">
		<h4 class="mt-4">Modification crédit</h4>
	
			<h1>${credit.getNum() }</h1>
		<form method="post" action="save-credit">
			<div class="form-group row mb-3">
				<label class="col-sm-2 col-form-label">Numéro de crédit : </label>
				<div class="col-sm-4">
					<input type="text" class="form-control" name="num" value="${credit.getNum() }">
				</div>
			</div>

			<div class="form-group row mb-3">
				<label class="col-sm-2 col-form-label">Date de demande : </label>
				<div class="col-sm-4">
					<input type="text" class="form-control" name="date">
				</div>
			</div>

			<div class="form-group row mb-3">
				<label class="col-sm-2 col-form-label">Capital : </label>
				<div class="col-sm-4">
					<input type="text" class="form-control" name="capital">
				</div>
			</div>

			<div class="form-group row mb-3">
				<label class="col-sm-2 col-form-label">Durée : </label>
				<div class="col-sm-4">
					<input type="text" class="form-control" name="duree">
				</div>
			</div>

			<div class="form-group row mb-3">
				<label class="col-sm-2 col-form-label">Taux : </label>
				<div class="col-sm-4">
					<input type="text" class="form-control" name="taux">
				</div>
			</div>

			<div class="form-group row mb-3">
				<label class="col-sm-2 col-form-label">Mensualité : </label>
				<div class="col-sm-4">
					<input readOnly="readonly" type="text" class="form-control"
						name="mensualite">
				</div>
			</div>

			<!-- 			<div class="form-group row mb-3"> -->
			<!-- 				<label class="col-sm-2 col-form-label">Etat : </label> -->
			<!-- 				<div class="col-sm-4"> -->
			<!-- 					<input type="text" class="form-control" name="etat"> -->
			<!-- 				</div> -->
			<!-- 			</div> -->

			<div class="form-group row mb-3">
				<label class="col-sm-2 col-form-label">Etat : </label>
				<div class="col-sm-4">
					<select class="form-select" name="etat"
						aria-label="Default select example">
						<option selected></option>
						<option value="en attente">En attente</option>
						<option value="acceptee">Acceptée</option>
						<option value="refusee">Refusée</option>
					</select>
				</div>

			</div>
			
			
			<div class="form-group row mb-3">
				<label class="col-sm-2 col-form-label">Id du client :  </label>
				
				<div class="col-sm-4">
					<input type="text" class="form-control " readOnly="readonly" name="idclient" value= "${credit.getClient().getId() }" >
					
				</div>
				
			</div> 
			<button type="submit" class="btn btn-primary mb-2">Enregistrer</button>
		</form>

	</div>


</body>
</html>