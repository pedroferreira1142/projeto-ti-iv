<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:layout>
	<jsp:body>
		<div class="container">
			<div class="col-md-7 col-lg-8">
				<br>
				<h4 class="mb-3">Editar Informações</h4>
				<form class="needs-validation" method="post" action="${pageContext.request.contextPath}/EditUserServlet" novalidate>
					<div class="row g-3">
						<div class="col-sm-6">
							<label for="firstName" class="form-label">Primeiro Nome</label>
							<input type="text" class="form-control" id="firstName"
								placeholder="" required name="primeiroNome"
								value="${user.primeiroNome}">
							<div class="invalid-feedback">
								Campo obrigatório!
								${messagePrimeiroNome}
							</div>
						</div>
						<div class="col-sm-6">
							<label for="lastName" class="form-label">Último Nome</label>
							<input type="text" class="form-control" id="lastName"
								placeholder="" required name="ultimoNome"
								value="${user.ultimoNome}">
							<div class="invalid-feedback">
								Campo obrigatório!
								${messageUltimoNome}
							</div>
						</div>
						<div class="col-12">
							<label for="email" class="form-label">E-mail</label>
							<input type="email" class="form-control" id="email"
								placeholder="you@example.com" name="eMail" value="${user.eMail}">
							<div class="invalid-feedback">
								Por favor introduza um e-mail válido!
								${messageEMail}
								${messageEmailInvalid}
							</div>
						</div>
						<div class="col-12">
							<label for="address" class="form-label">NUC</label>
							<input type="text" class="form-control" id="address"
								placeholder="1234" required name="nuc" value="${user.nuc}">
							<div class="invalid-feedback">
								Campo obrigatório!
								${messageNuc}
							</div>
						</div>
						<button class="w-100 btn btn-primary btn-lg" type="submit">Atualizar Conta</button>
					</div>
				</form>
			</div>
		</div>
		<script src="${pageContext.request.contextPath}/js/form-validation.js"></script>
	</jsp:body>
</t:layout>