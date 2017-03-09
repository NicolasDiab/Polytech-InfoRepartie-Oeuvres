<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<jsp:include page="part/header.jsp"/>
<jsp:include page="part/nav.jsp"/>

<h1 class="text-center">Modifier une réservation</h1>

<form name='identification' method="post" action="ReservationController?action=modifierActionReservation"
      onsubmit="return teste()">
    <div class="form-group">
        <label for="date">Date </label>
        <input type="date" name="date" class="form-control" value="${reservation.dateString}" id="date" placeholder="Entrer la date de réservation">
    </div>
    <div class="form-group">
        <label for="statut">Statut </label>
        <input type="text" name="statut" class="form-control" value="${reservation.statut}" id="statut" placeholder="Entrer le statut de la réservation">
    </div>
    <div class="row">
        <div class="col-md-6">
            <strong>Adhérent</strong>
            <p>${reservation.adherent.nomAdherent} ${reservation.adherent.prenomAdherent}</p>
        </div>
        <div class="col-md-6">
            <strong>Oeuvre vente</strong>
            <p>${reservation.oeuvreVente.titreOeuvrevente} ${reservation.oeuvreVente.prixOeuvrevente}€</p>
        </div>
    </div>

    <input type="hidden" name="oeuvreVenteNum" id="oeuvreVenteNum" value="${reservation.adherent.idAdherent}">
    <input type="hidden" name="adherentNum" id="adherentNum" value="${reservation.oeuvreVente.idOeuvrevente}">

    <button type="submit" class="btn btn-primary">Valider</button>
</form>


<a href="/" class="btn btn-danger">Retour à l'accueil</a>

<jsp:include page="part/footer.jsp"/>
