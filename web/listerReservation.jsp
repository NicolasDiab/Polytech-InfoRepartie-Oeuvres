<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<jsp:include page="part/header.jsp" />
<jsp:include page="part/nav.jsp" />

<h1 class="text-center">
    Listing des réservations
</h1>

<table class="table table-striped table-hover">
    <thead>
    <tr>
        <th>Oeuvre</th>
        <th>Adhérent</th>
        <th>Date</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${mesReservations}" var="item">
        <tr>
            <td>
                    ${item.oeuvreVente.idOeuvrevente}
                    ${item.oeuvreVente.titreOeuvrevente}
                    ${item.oeuvreVente.prixOeuvrevente}€
                propriétaire :
                    ${item.oeuvreVente.proprietaire.prenomProprietaire}
                    ${item.oeuvreVente.proprietaire.nomProprietaire}
            </td>
            <td>
                    ${item.adherent.idAdherent}
                    ${item.adherent.nomAdherent}
                    ${item.adherent.prenomAdherent}
                    ${item.adherent.villeAdherent}
            </td>
            <td>${item.date}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<a href="/ReservationController?action=ajouterReservation" class="btn btn-danger">Ajouter réservation</a>

<a href="/" class="btn btn-primary">Retour à l'accueil</a>

<jsp:include page="part/footer.jsp" />
