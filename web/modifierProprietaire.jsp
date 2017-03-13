<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<jsp:include page="part/header.jsp"/>
<jsp:include page="part/nav.jsp"/>

<h1 class="text-center"> Modifier un propriétaire</h1>

<form name='identification' method="post" action="ProprietaireController?action=update"
      onsubmit="return teste()">
    <div class="form-group">
        <label for="nom">Nom du propriétaire </label>
        <input type="text" name="txtNom" class="form-control" value="${proprietaire.nomProprietaire}" id="nom" placeholder="Entrer le nom du propriétaire">
    </div>
    <div class="form-group">
        <label for="prenom">Prenom du propriétaire </label>
        <input type="text" name="txtPrenom" class="form-control" value="${proprietaire.prenomProprietaire}" id="prenom" placeholder="Entrer le Prenom du propriétaire">
    </div>

    <input type="hidden" name="txtId" value="${proprietaire.idProprietaire}">

    <button type="submit" class="btn btn-primary">Valider</button>
</form>


<a href="/" class="btn btn-danger">Retour à l'accueil</a>

<jsp:include page="part/footer.jsp"/>
