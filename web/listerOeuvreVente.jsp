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
        oeuvres </STRONG></U></FONT>
</P>

<TABLE BORDER="1">
    <CAPTION>Tableau des Oeuvres</CAPTION>
    <TR>
        <TH>Id</TH>
        <TH>Titre</TH>
        <TH>Prix</TH>
        <TH>Propriétaire</TH>
        <TH>Réserver/modifier</TH>
    </TR>

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
        </tr>
    </c:forEach>
</TABLE>
<jsp:include page="part/footer.jsp" />
