<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<jsp:include page="part/header.jsp"/>
<jsp:include page="part/nav.jsp"/>
<h1 class="text-center"> Ajout d'un propriétaire</h1>

<form name='identification' method="post" action="ProprietaireController?action=add">

    <div class="form-group">
        <label for="nom">Nom du propriétaire </label>
        <input type="text" name="txtnom" class="form-control" value="" id="nom" placeholder="Entrer le nom du propriétaire">
    </div>
    <div class="form-group">
        <label for="prenom">Prénom du propriétaire </label>
        <input type="text" name="txtprenom" class="form-control" value="" id="prenom" placeholder="Entrer le Prenom du propriétaire">
    </div>
    <button type="submit" class="btn btn-primary">Ajouter</button>
</form>
<a href="/" class="btn btn-danger">Retour à l'accueil</a>


<jsp:include page="part/footer.jsp"/>
