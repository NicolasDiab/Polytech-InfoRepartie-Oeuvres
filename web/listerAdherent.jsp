<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<jsp:include page="part/header.jsp"/>
<jsp:include page="part/nav.jsp"/>
<h1 class="text-center">
    Listing des Adhérents
</h1>

<table class="table table-striped table-hover">
    <thead>
    <tr>
        <th>Numero</th>
        <th>Nom</th>
        <th>Prénom</th>
        <th>Ville</th>
        <th>Modifier</th>
    </tr>
    </thead>

    <tbody>
    <c:forEach items="${mesAdherents}" var="item">
        <tr>
            <td>${item.idAdherent}</td>
            <td>${item.nomAdherent}</td>
            <td>${item.prenomAdherent}</td>
            <td>${item.villeAdherent}</td>
            <td>
                <a href="AdherentController?action=update&adherentNum=${item.idAdherent}">Modifier</a>
                <a href="AdherentController?action=delete&adherentNum=${item.idAdherent}">Suppimer</a>
            </td>
        </tr>
    </c:forEach>
    <tbody>
</table>
<a href="/AdherentController?action=add" class="btn btn-danger">Ajouter adherent</a>
<a href="/" class="btn btn-primary">Retour à l'accueil</a>
<jsp:include page="part/footer.jsp"/>
