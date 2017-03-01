<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<jsp:include page="part/header.jsp" />
<jsp:include page="part/nav.jsp" />
<P>
    <A href="index.jsp"><FONT face="Arial" color="#004080">Retour
        Accueil</FONT></A>
</P>
<P align="center">
    <FONT face="Arial" size="5" color="#004080"><U> <STRONG>Listing&nbsp;des
        réservations </STRONG></U></FONT>
</P>

<TABLE BORDER="1">
    <CAPTION>Tableau des Réservations</CAPTION>
    <TR>
        <TH>Oeuvre</TH>
        <TH>Adhérent</TH>
        <TH>Date</TH>
    </TR>

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
</TABLE>
<jsp:include page="part/footer.jsp" />
