<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<jsp:include page="part/header.jsp" />
<jsp:include page="part/nav.jsp" />
<h1> Ajout d'une réservation </h1>

<A href="index.jsp">Retour Accueil</A>

<div align="center">
    <form  name='identification' method="post" action="ReservationController?action=insererReservation" onsubmit="return teste()">
        <P align="left">
            <label>Adhérent :
                <select name="adherentNum">
                    <c:forEach items="${mesAdherents}" var="item">
                        <option value="${item.idAdherent}">
                            ${item.nomAdherent} ${item.prenomAdherent}
                            - ${item.villeAdherent}
                        </option>
                    </c:forEach>
                </select>
            </label>

            <label>Oeuvre vente :
                <select name="oeuvreVenteNum">
                    <c:forEach items="${mesOeuvresVente}" var="item">
                        <option value="${item.idOeuvrevente}">
                            ${item.titreOeuvrevente} ${item.prixOeuvrevente}€
                        </option>
                    </c:forEach>
                </select>
            </label>

            <label>
                Date :
                <input type="date" name="date" />
            </label>
            <input type="submit"  value="Ajouter" >
        </P>
    </form>
    <jsp:include page="part/footer.jsp" />
