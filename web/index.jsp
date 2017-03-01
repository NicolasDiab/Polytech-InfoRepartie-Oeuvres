<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="part/header.jsp" />
<jsp:include page="part/nav.jsp" />
<section class="container-fluid">
	<div class="card text-center mt-3">
		<div class="card-header">
			TP : Gestion des oeuvres
		</div>
		<div class="card-block">
			<h4 class="card-title">Bienvenue</h4>
			<div class="card-text">
				<p>
					Voici le client du travaux pratiques : Oeuvres.
				<p>
				<p>
					Il s'agit d'un client développé avec bootstrap 4
				</p>
				<p>
					Ce client est la partie front-end d'un projet avec un serveur sous J2EE.
				</p>
			</div>
		</div>
		<div class="card-footer text-muted">
			some days ago
		</div>
	</div>
	<div class="row mt-3">
		<div class="col-md-3">
			<div class="card text-center">
				<div class="card-block">
					<h4 class="card-title">Gestion des adhérents</h4>
					<a href="/AdherentController?action=listerAdherent" class="btn btn-primary">Voir la liste</a>
				</div>
			</div>
		</div>
		<div class="col-sm-3">
			<div class="card text-center">
				<div class="card-block">
					<h4 class="card-title">Gestion des proprietaires</h4>
					<a href="/ProprietaireController?action=listerProprietaire" class="btn btn-primary">Voir la liste</a>
				</div>
			</div>
		</div>
		<div class="col-sm-3">
			<div class="card text-center">
				<div class="card-block">
					<h4 class="card-title">Gestion des Vente d'oeuvre</h4>
					<a href="/OeuvreController?action=listerOeuvreVente" class="btn btn-primary">Voir la liste</a>
				</div>
			</div>
		</div>
		<div class="col-sm-3">
			<div class="card text-center">
				<div class="card-block">
					<h4 class="card-title">Gestion des réservations</h4>
					<a href="/ReservationController?action=listerReservation" class="btn btn-primary">Voir la liste</a>
				</div>
			</div>
		</div>
	</div>
</section>

<jsp:include page="part/footer.jsp" />
