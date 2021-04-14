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
				<h4 class="mb-3">Criar um Artigo</h4>
				<div class="card-body">
					<form class="user needs-validation" method="post" action="${pageContext.request.contextPath}/ItemCreateServlet" novalidate>
						<div class="form-group">
							<input type="text" class="form-control form-control-user" id="descrição"
								placeholder="Descrição do Artigo" name="descricaoArtigo">
							<div class="invalid-feedback">
								Campo obrigatório!
							</div>
						</div>
						${messageDescricao}
						<div class="form-group row">
							<div class="col-sm-6 mb-3 mb-sm-0">
								<input type="text" class="form-control form-control-user" id="marca"
									placeholder="Marca" name="marcaArtigo">
								<div class="invalid-feedback">
									Campo obrigatório!
								</div>
							</div>
							${messageMarca}
							<div class="col-sm-6">
								<input type="text" class="form-control form-control-user" id="modelo"
									placeholder="Modelo" name="modelo">
								<div class="invalid-feedback">
									Campo obrigatório!
								</div>
							</div>
							${messageModelo}
						</div>
						<div class="form-group row">
							<div class="col-sm-6 mb-3 mb-sm-0">
								<input type="text" class="form-control form-control-user" id="numImobilizado"
									placeholder="Núm Imobilizado" name="numImobilizado">
								<div class="invalid-feedback">
									Campo obrigatório!
								</div>
							</div>
							${messageNumImobilizado}
							<div class="col-sm-6">
								<input type="text" class="form-control form-control-user" id="numSerie"
									placeholder="Núm Série" name="numSerie">
								<div class="invalid-feedback">
									Campo obrigatório!
								</div>
							</div>
							${messageNumSerie}
						</div>
						<div class="form-group">
							<input type="text" class="form-control form-control-user" id="localSotck"
								placeholder="Local de Stock" name="localStock">
							<div class="invalid-feedback">
								Campo obrigatório!
							</div>
							${messageLocalStock}
						</div>
						<div class="form-group">
							<textarea class="form-control form-control-user" id="obs"
								placeholder="Observações" name="obs"></textarea>
							<div class="invalid-feedback">
								Campo obrigatório!
							</div>
							${messageObs}
						</div>
						<div class="form-group row">
							<div class="col-sm-6 mb-3 mb-sm-0">
								<select name="estado" class="form-control">
									<option value="">Estado do Artigo</option>
									<c:forEach items="${listaEstados}" var="estado">
										<option value="${estado.uid}">${estado.item}</option>
									</c:forEach>
								</select>
							</div>
							<div class="col-sm-6">
								<select name="tipoArtigo" class="form-control">
									<option value="">Tipo de Artigo</option>
									<c:forEach items="${listaTipoArtigos}" var="tipoArtigo">
										<option value="${tipoArtigo.uid}">${tipoArtigo.item}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<input type="submit"  class="btn btn-primary btn-user btn-block" value="Registar Artigo">
					</form>
					<hr>
				</div>
			</div>
		</div>
		<script src="${pageContext.request.contextPath}/js/form-validation.js"></script>
	</jsp:body>
</t:layout>