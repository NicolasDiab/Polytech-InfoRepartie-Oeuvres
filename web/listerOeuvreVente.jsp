<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<jsp:include page="part/header.jsp" />
<jsp:include page="part/nav.jsp" />
<h1 class="text-center">
    Listing des oeuvres
</h1>

<table class="table table-striped table-hover">
    <thead>
    <tr>
        <th>Id</th>
        <th>Titre</th>
        <th>Prix</th>
        <th>Propriétaire</th>
        <th>Réserver/modifier</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${mesOeuvresVente}" var="item">
        <tr>
            <td>${item.idOeuvrevente}</td>
            <td>${item.titreOeuvrevente}</td>
            <td>${item.prixOeuvrevente}</td>
            <td>
                    ${item.proprietaire.idProprietaire}
                    ${item.proprietaire.prenomProprietaire}
                    ${item.proprietaire.nomProprietaire}
            </td>
            <td>
                <a href="OeuvreController?action=update&idOeuvrevente=${item.idOeuvrevente}"><font
                        face="Arial">Modifier</font></a>
                <a href="OeuvreController?action=delete&idOeuvrevente=${item.idOeuvrevente}">Suppimer</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="OeuvreController?action=add" class="btn btn-danger">Ajouter Oeuvre</a>

<a href="/" class="btn btn-primary">Retour à l'accueil</a>

<jsp:include page="part/footer.jsp" />
