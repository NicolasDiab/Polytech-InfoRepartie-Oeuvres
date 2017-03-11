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
        <th>Statut</th>
        <th>Modifier</th>
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
            <td>${item.statut}</td>
            <td>
                <a href="ReservationController?action=modifierPageReservation&adherentNum=${item.adherent.idAdherent}&oeuvreVenteNum=${item.oeuvreVente.idOeuvrevente}"><i class="glyphicon glyphicon-edit"></i>Modifier</a>

                <a href="ReservationController?action=supprimerReservation&adherentNum=${item.adherent.idAdherent}&oeuvreVenteNum=${item.oeuvreVente.idOeuvrevente}"><i class="glyphicon glyphicon-trash"></i>Supprimer</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<a href="/ReservationController?action=ajouterReservation" class="btn btn-danger">Ajouter réservation</a>

<a href="/" class="btn btn-primary">Retour à l'accueil</a>

<jsp:include page="part/footer.jsp" />
