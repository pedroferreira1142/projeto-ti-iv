<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="models.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:layout>
	<jsp:body>
		<div class="container">
			<div class="col-md-7 col-lg-8">
				<br>
				<h4 class="mb-3">Criar um Movimento</h4>
				<div class="card-body">
				
					<form class="user needs-validation" method="post" action="${pageContext.request.contextPath}/TransactionCreateServlet" novalidate>
						
						<div class="form-group row">
							<div class="col-sm-6 mb-3 mb-sm-0">
								<input type="text" readonly class="form-control form-control-user" id="nomeUtilizador"
									value="${user.primeiroNome} ${user.ultimoNome}" name="nomeUtilizador">
								<input type="hidden" id="idUtilizador"
									value="${user.uid}" name="idUtilizador">
							</div>
							
							<div class="col-sm-6">
								<input type="text" readonly class="form-control form-control-user" id="descricaoArtigo"
									value="${artigo.descricao}" name="descricaoArtigo">
								<input type="hidden" id="artigoUid"
									value="${artigo.uid}" name="artigoUid">	
							</div>
						</div>
						
						<div class="form-group row">
							<div class="col-sm-6 mb-3 mb-sm-0">
								<input type="text" class="form-control form-control-user" id="colaboradorNome"
									placeholder="Nome do Colaborador" name="colaboradorNome">
								<div class="invalid-feedback">
									Campo obrigatório!
								</div>
							</div>
							
							<div class="col-sm-6">
								<input type="text" class="form-control form-control-user" id="colaboradorNuc"
									placeholder="Nuc Colaborador" name="colaboradorNuc">
								<div class="invalid-feedback">
									Campo obrigatório!
								</div>
							</div>
						</div>
						
						<div class="form-group row">
							<div class="col-sm-6 mb-3 mb-sm-0">
								<input type="text" class="form-control form-control-user" id="localMovimento"
									placeholder="Local Movimento" name="localMovimento">
								<div class="invalid-feedback">
									Campo obrigatório!
								</div>
							</div>
							
							<div class="col-sm-6">
								<select name="tipoMovimento" class="form-control form-control-user" >
									<option value="">Tipo de Movimento</option>
									<c:forEach items="${listaTipoMovimento}" var="tipoMovimento">
										<option value="${tipoMovimento.uid}">${tipoMovimento.item}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						
						<div class="form-group">
							<textarea class="form-control form-control-user" id="obs"
								placeholder="Observações" name="obs"></textarea>
							<div class="invalid-feedback">
								Campo obrigatório!
							</div>
						</div>
						
						${messageIsNull}
						<input type="submit"  class="btn btn-primary btn-user btn-block" value="Atribuir Movimento">
					</form>
					<hr>
				</div>
			</div>
		</div>
		<script src="${pageContext.request.contextPath}/js/form-validation.js"></script>
	</jsp:body>
</t:layout>