<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<jsp:include page="part/header.jsp"/>
<jsp:include page="part/nav.jsp"/>
<h1 class="text-center"> Ajout d'un adhérent</h1>

<form name='identification' method="post" action="AdherentController?action=insererAdherent"">

    <div class="form-group">
        <label for="nom">Nom de l'adherent </label>
        <input type="text" name="txtnom" class="form-control" value="" id="nom" placeholder="Entrer le nom de l'adherent">
    </div>
    <div class="form-group">
        <label for="prenom">Prenom de l'adherent </label>
        <input type="text" name="txtprenom" class="form-control" value="" id="prenom" placeholder="Entrer le Prenom de l'adherent">
    </div>
    <div class="form-group">
        <label for="ville">Ville de l'adherent </label>
        <input type="text" name="txtville" class="form-control" value="" id="ville" placeholder="Entrer la ville de l'adherent">
    </div>
    <button type="submit" class="btn btn-primary">Ajouter</button>
</form>
<a href="/" class="btn btn-danger">Retour à l'accueil</a>


<jsp:include page="part/footer.jsp"/>
