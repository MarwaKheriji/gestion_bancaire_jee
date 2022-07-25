
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<title>Confirmation compte</title>
</head>
<body>
	<div class="card" style="width: 18rem;">
  <div class="card-body">
    <h5 class="card-title">Confirmation du compte</h5>
    <p class="card-text">Numero de compte : ${compte.getNum()}</p>
    <p class="card-text">Date de creation : ${compte.getCreation()}</p>
    <p class="card-text">Solde : ${compte.getSolde()}</p>
    <p class="card-text">Type du compte : ${compte.getType()}</p>
    <p class="card-text">Taux : ${compte.getTaux()}</p>
    <p class="card-text">Découvert : ${compte.getDecouvert()}</p>
    <p class="card-text">Id client : ${compte.getClient().getId()}</p>
    <p class="card-text">Nom : ${compte.getClient().getNom()}</p>
    <p class="card-text">Prénom : ${compte.getClient().getPrenom()}</p>
    <a href="liste-compte?idclient=${compte.getClient().getId()}" class="btn btn-primary">Liste des comptes</a>
  </div>
</div>


</body>
</html>