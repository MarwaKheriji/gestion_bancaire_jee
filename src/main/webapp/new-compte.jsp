
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<title>Nouveau compte</title>
</head>
<body>
	<%@ include file="layout/compte-navbar.jsp"%>
	<div class="container">
		<h4 class="mt-4">Nouveau compte</h4>

		<form method="post" action="save-compte">
			<div class="form-group row mb-3">
				<label class="col-sm-2 col-form-label">Numéro de comtpe : </label>
				<div class="col-sm-4">
					<input type="text" class="form-control" name="num">
				</div>
			</div>

			<div class="form-group row mb-3">
				<label class="col-sm-2 col-form-label">Date de création : </label>
				<div class="col-sm-4">
					<input type="text" class="form-control" name="creation">
				</div>
			</div>

			<div class="form-group row mb-3">
				<label class="col-sm-2 col-form-label">Solde : </label>
				<div class="col-sm-4">
					<input type="text" class="form-control" name="solde">
				</div>
			</div>

			<div class="form-group row mb-3">
				<label class="col-sm-2 col-form-label">Type du compte : </label>
				<div class="col-sm-4">
					<input type="text" class="form-control" name="type">
				</div>
			</div>

			<div class="form-group row mb-3">
				<label class="col-sm-2 col-form-label">Taux : </label>
				<div class="col-sm-4">
					<input type="text" class="form-control" name="taux">
				</div>
			</div>

			<div class="form-group row mb-3">
				<label class="col-sm-2 col-form-label">Découvert : </label>
				<div class="col-sm-4">
					<input type="text" class="form-control" name="decouvert">
				</div>
			</div>


			<div class="form-group row mb-3">
				<label class="col-sm-2 col-form-label">Id du client : </label>

				<div class="col-sm-4">
					<input type="text" class="form-control " readOnly="readonly"
						name="idclient" value="<%=request.getParameter("idclient")%>">

				</div>

				<button type="submit" class="btn btn-primary mb-2">Enregistrer</button>
		</form>

	</div>


</body>
</html>