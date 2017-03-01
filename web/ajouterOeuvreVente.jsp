<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<jsp:include page="part/header.jsp"/>
<jsp:include page="part/nav.jsp"/>
<h1 class="text-center"> Ajout d'une oeuvre vente </h1>

<form name='identification' method="post" action="OeuvreController?action=insererOeuvreVente" onsubmit="return teste()">
    <div class="form-group">
        <label for="titre">Titre de l'oeuvre </label>
        <input type="text" name="titre" class="form-control" value="" id="titre"
               placeholder="Entrer le titre de l'oeuvre">
    </div>
    <div class="form-group">
        <label for="prix">Prix de l'oeuvre</label>
        <input type="number" name="prix" class="form-control" value="" id="prix"
               placeholder="Entrer le prix de l'oeuvre">
    </div>
    <div class="form-group">
        <label for="proprietaireNum">Ville de l'adherent </label>
        <select class="form-control" name="proprietaireNum" id="proprietaireNum">
            <c:forEach items="${mesProprietaires}" var="item">
                <option value="${item.idProprietaire}">${item.nomProprietaire} ${item.prenomProprietaire}</option>
            </c:forEach>
        </select>
    </div>
    <button type="submit" class="btn btn-primary">Ajouter</button>


</form>

<a href="/" class="btn btn-danger">Retour à l'accueil</a>

<jsp:include page="part/footer.jsp"/>
