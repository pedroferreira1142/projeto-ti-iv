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
				<h4 class="mb-3">Movimento</h4>
				<div class="card-body">
				
					<form class="user needs-validation">
						
						<div class="form-group row">
						
							<div class="col-sm-6 mb-3 mb-sm-0">
								<input type="text" readonly class="form-control form-control-user" id="nomeUtilizador"
									value="${utilizadorMovimento}" name="nomeUtilizador">
							</div>
							
							<div class="col-sm-6">
								<input type="text" readonly class="form-control form-control-user" id="descricaoArtigo"
									value="${artigoMovimento}" name="descricaoArtigo">
							</div>
						</div>
						
						<div class="form-group row">
							<div class="col-sm-6 mb-3 mb-sm-0">
								<input type="text" readonly class="form-control form-control-user" id="colaboradorNome"
									value="${movimento.nomeColaborador}" name="colaboradorNome">
							</div>
							
							<div class="col-sm-6">
								<input type="text" class="form-control form-control-user" id="colaboradorNuc"
									value="${movimento.colaboradorNuc}" name="colaboradorNuc">
							</div>
						</div>
						
						<div class="form-group row">
							<div class="col-sm-6 mb-3 mb-sm-0">
								<input type="text" class="form-control form-control-user" id="localMovimento"
									value="${movimento.localStock}" name="localMovimento">

							</div>
							
							<div class="col-sm-6">
								<input type="text" class="form-control form-control-user" id="tipoMovimento"
									value="${tipoMovimento}" name="tipoMovimento">
							</div>
						</div>
						
						<div class="form-group">
							<input class="form-control form-control-user" id="obs"
								 name="dataMovimento" value="${movimento.dataCriacao}">
						</div>
						
						
						<div class="form-group">
							<textarea class="form-control form-control-user" id="obs"
								 name="obs">${movimento.obs}</textarea>
						</div>
						
					</form>
					<hr>
				</div>
			</div>
		</div>
		<script src="${pageContext.request.contextPath}/js/form-validation.js"></script>
			
	
	
	</jsp:body>
</t:layout>