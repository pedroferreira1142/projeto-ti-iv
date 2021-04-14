<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="models.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:layout>
	<jsp:body>
		<br>
		<div class="container">
			<!-- MENU DE NAVEGAÇÃO DOS TABS-->
			<h2>Página de Administração do Utilizador</h2>
			<br>
			<ul class="nav nav-tabs mb-3" id="pills-tab" role="tablist">
				<li class="nav-item" role="presentation">
					<button class="nav-link active" id="pills-home-tab" data-bs-toggle="pill" data-bs-target="#pills-home" 
						type="button" role="tab" aria-controls="pills-home" aria-selected="true">Informações</button>
				</li>
				<li class="nav-item" role="presentation">
					<button class="nav-link" id="pills-profile-tab" data-bs-toggle="pill" data-bs-target="#pills-profile" 
						type="button" role="tab" aria-controls="pills-profile" aria-selected="false">Premissões</button>
				</li>
				<li class="nav-item" role="presentation">
					<button class="nav-link" id="pills-contact-tab" data-bs-toggle="pill" data-bs-target="#pills-contact" 
						type="button" role="tab" aria-controls="pills-contact" aria-selected="false">Segurança</button>
				</li>
			</ul>
			<!-- CONTAINER DOS TABS -->
			<div class="tab-content" id="pills-tabContent">
				<!-- Editar Premissões -->
				<div class="tab-pane fade show active" id="pills-home" role="tabpanel" aria-labelledby="pills-home-tab">
					<div class="col-md-7 col-lg-8">
						<br>
						<h4 class="mb-3">Editar Informações do Utilizador</h4>
						<div class="card-body">
							<form class="user needs-validation" method="post" 
								action="${pageContext.request.contextPath}/BOUserEditServlet" novalidate>
								
								<div class="form-group row">
									<div class="col-sm-6 mb-3 mb-sm-0">
										<input type="text" class="form-control form-control-user" id="primeiroNome"
											placeholder="Último Nome" name="primeiroNome" value="${utilizador.primeiroNome}">
										<div class="invalid-feedback">
											Campo obrigatório!
										</div>
									</div>
									${messageIsNull}
									
									<div class="col-sm-6 mb-3 mb-sm-0">
										<input type="text" class="form-control form-control-user" id="ultimoNome"
											placeholder="Último Nome" name="ultimoNome" value="${utilizador.ultimoNome}">
										<div class="invalid-feedback">
											Campo obrigatório!
										</div>
									</div>
									${messageIsNull}
								</div>
								
								<div class="form-group row">
									<div class="col-sm-6">
										<input type="text" class="form-control form-control-user" id="eMail"
											placeholder="Endereço de e-mail" name="eMail" value="${utilizador.eMail}">
										<div class="invalid-feedback">
											Campo obrigatório!
										</div>
									</div>
									${messageIsNull}
									<div class="col-sm-6">
										<input type="text" class="form-control form-control-user" id="nuc"
											placeholder="Número de colaborador" name="nuc" value="${utilizador.nuc}">
										<div class="invalid-feedback">
											Campo obrigatório!
										</div>
									</div>
									${messageIsNull}
								</div>
								
								<input type="submit"  class="btn btn-primary btn-user btn-block" value="Atualizar Conta">
							</form>
							<hr>
						</div>
					</div>
				</div>
				<!-- INFORMAÇÕES DO UTILIZADOR -->
				<div class="tab-pane fade" id="pills-profile" role="tabpanel" aria-labelledby="pills-profile-tab">
					<br>
					<h4 class="mb-3">Editar premissões da conta</h4>
					<div class="card-body">
						<form class="user needs-validation" method="post" 
							action="${pageContext.request.contextPath}/BOEditUserPremissionServlet" novalidate>
							<input type="hidden" value="${utilizador.eMail}" name="utilizadorEMail">
							<div class="form-group">
								<br>
								<select name="tipoConta" class="form-control">
									<c:choose>
										<c:when test="${utilizador.tipo == 1}">
											<option value=1 selected>Administrador</option>
											<option value=0 >Regular</option>
											<option value=0 >Bloqueada</option>
										</c:when>
										<c:when test="${utilizador.tipo == 0}">
											<option value=1 >Administrador</option>
											<option value=0 selected>Regular</option>
											<option value=0 >Bloqueada</option>
										</c:when>
									</c:choose>
								</select>
							</div>
							<input type="submit" class="btn btn-primary" type="submit" value="Atualizar Premissões">	
						</form>
					</div>
				</div>
				<!-- CONFIGURAÇÕES DE SEGURANÇA -->
				<div class="tab-pane fade" id="pills-contact" role="tabpanel" aria-labelledby="pills-contact-tab">
				</div>
			</div>
		</div>
	</jsp:body>
</t:layout>