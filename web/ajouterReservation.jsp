<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<jsp:include page="part/header.jsp"/>
<jsp:include page="part/nav.jsp"/>
<h1> Ajout d'une réservation </h1>


<form name='identification' method="post" action="ReservationController?action=insererReservation"
      onsubmit="return teste()">
    <div class="form-group">
        <label for="adherentNum">Adhérent </label>
        <select name="adherentNum" class="form-control" id="adherentNum">
            <c:forEach items="${mesAdherents}" var="item">
                <option value="${item.idAdherent}">
                        ${item.nomAdherent} ${item.prenomAdherent}
                    - ${item.villeAdherent}
                </option>
            </c:forEach>
        </select>
    </div>
    <div class="form-group">
        <label for="oeuvreVenteNum">Oeuvre vente </label>
        <select name="oeuvreVenteNum" class="form-control" id="oeuvreVenteNum">
            <c:forEach items="${mesOeuvresVente}" var="item">
                <option value="${item.idOeuvrevente}">
                        ${item.titreOeuvrevente} ${item.prixOeuvrevente}€
                </option>
            </c:forEach>
        </select>
    </div>

    <div class="form-group">
        <label for="date">Date </label>
        <input class="form-control"  type="date" name="date" id="date"/>
    </div>

    <button type="submit" class="btn btn-primary">Ajouter</button>
</form>
<a href="/" class="btn btn-danger">Retour à l'accueil</a>

<jsp:include page="part/footer.jsp"/>
