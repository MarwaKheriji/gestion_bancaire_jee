
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<title>Confirmation crédit</title>
</head>
<body>
	<div class="card" style="width: 18rem;">
  <div class="card-body">
    <h5 class="card-title">Confirmation de la demande de crédit</h5>
    <p class="card-text">Numero de compte : ${credits.getNum()}</p>
    <p class="card-text">Date de demande : ${credits.getDate()}</p>
    <p class="card-text">Capital : ${credits.getCapital()}</p>
    <p class="card-text">Durée : ${credits.getDuree()}</p>
    <p class="card-text">Taux : ${credits.getTaux()}</p>
    <p class="card-text">Mensualité : ${credits.getMensualite()}</p>
    <p class="card-text">Etat : ${credits.getEtat()}</p>
    <p class="card-text">Id client : ${credits.getClient().getId()}</p>
    <p class="card-text">Nom : ${credits.getClient().getNom()}</p>
    <p class="card-text">Prénom : ${credits.getClient().getPrenom()}</p>
    <a href="liste-credit?idclient=${credits.getClient().getId()}" class="btn btn-primary">Liste des credits</a>
  </div>
</div>


</body>
</html>