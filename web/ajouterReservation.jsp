<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Ajouter une réservation</title>
</head>
<script type="text/javascript" src="js/foncControle.js"></script>


<body>
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
</div>

</body>
</html>