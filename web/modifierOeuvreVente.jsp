<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<jsp:include page="part/header.jsp"/>
<jsp:include page="part/nav.jsp"/>

<h1 class="text-center">Modifier une réservation</h1>

<form name='identification' method="post" action="OeuvreController?action=update"
      onsubmit="return teste()">
    <div class="form-group">
        <label for="titre">Titre </label>
        <input type="text" name="titre" class="form-control" value="${oeuvreVente.titreOeuvrevente}" id="titre" placeholder="Entrer le titre de l'oeuvre">
    </div>
    <div class="form-group">
        <label for="prix">Prix </label>
        <input type="text" name="prix" class="form-control" value="${oeuvreVente.prixOeuvrevente}" id="prix" placeholder="Entrer le prix de l'oeuvre">
    </div>
    <div class="form-group">
        <label for="etat">Etat </label>
        <input type="text" name="etat" class="form-control" value="${oeuvreVente.etatOeuvrevente}" id="etat" placeholder="Entrer l'état de l'oeuvre">
    </div>
    <div class="form-group">
        <label for="proprietaire">Proprietaire </label>
        <input type="text" name="proprietaire" class="form-control" value="${oeuvreVente.proprietaire.nomProprietaire}" id="proprietaire" placeholder="Entrer le proprietaire de l'oeuvre">
    </div>

    <input type="hidden" name="oeuvreVenteNum" id="oeuvreVenteNum" value="${oeuvreVente.idOeuvrevente}">
    <input type="hidden" name="proprietaireNum" id="proprietaireNum" value="${oeuvreVente.proprietaire.idProprietaire}">

    <button type="submit" class="btn btn-primary">Valider</button>
</form>


<a href="/" class="btn btn-danger">Retour à l'accueil</a>

<jsp:include page="part/footer.jsp"/>
