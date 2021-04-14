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
			<h2>Artigo</h2>
			<!-- MENU DE NAVEGAÇÃO -->
			<ul class="nav nav-tabs mb-3" id="pills-tab" role="tablist">
				<li class="nav-item" role="presentation">
					<button class="nav-link active" id="pills-home-tab" data-bs-toggle="pill" data-bs-target="#pills-home" 
						type="button" role="tab" aria-controls="pills-home" aria-selected="true">Características</button>
				</li>
				<li class="nav-item" role="presentation">
					<button class="nav-link" id="pills-profile-tab" data-bs-toggle="pill" data-bs-target="#pills-profile" 
						type="button" role="tab" aria-controls="pills-profile" aria-selected="false">Movimentos</button>
				</li>
			</ul>
			<!-- CONTAINER DE TABS -->
			<div class="tab-content" id="pills-tabContent">
				<!-- INFO DO ARTIGO -->
				<div class="tab-pane fade show active" id="pills-home" role="tabpanel" aria-labelledby="pills-home-tab">
					<div class="card-body">
						<form class="user needs-validation" method="post" action="${pageContext.request.contextPath}/ItemViewServlet" novalidate>
							<!-- Uid Hidden -->
							<input name="uid" type="hidden" value="${artigoByUid.uid}">
							<div class="form-group">
								<input type="text" class="form-control form-control-user" id="descrição"
									placeholder="Descrição do Artigo" name="descricaoArtigo" value="${artigoByUid.descricao}">
								<div class="invalid-feedback">
									Campo obrigatório!
								</div>
							</div>
							${messageDescricao}
							<div class="form-group row">
								<div class="col-sm-6 mb-3 mb-sm-0">
									<input type="text" class="form-control form-control-user" id="marca"
										placeholder="Marca" name="marcaArtigo" value="${artigoByUid.marca}">
									<div class="invalid-feedback">
										Campo obrigatório!
									</div>
								</div>
								${messageMarca}
								<div class="col-sm-6">
									<input type="text" class="form-control form-control-user" id="modelo"
										placeholder="Modelo" name="modelo" value="${artigoByUid.modelo}">
									<div class="invalid-feedback">
										Campo obrigatório!
									</div>
								</div>
							</div>
							${messageModelo}
							<div class="form-group row">
								<div class="col-sm-6 mb-3 mb-sm-0">
									<input type="text" class="form-control form-control-user" id="numImobilizado"
										placeholder="Núm Imobilizado" name="numImobilizado" value="${artigoByUid.numImobilizado}">
									<div class="invalid-feedback">
										Campo obrigatório!
									</div>
								</div>
								${messageNumImobilizado}
								<div class="col-sm-6">
									<input type="text" class="form-control form-control-user" id="numSerie"
										placeholder="Núm Série" name="numSerie" value="${artigoByUid.numSerie}">
									<div class="invalid-feedback">
										Campo obrigatório!
									</div>
								</div>
								${messageNumSerie}
							</div>
							<div class="form-group">
								<input type="text" class="form-control form-control-user" id="localSotck"
									placeholder="Local de Stock" name="localStock" value="${artigoByUid.localStock}">
								<div class="invalid-feedback">
									Campo obrigatório!
								</div>
								${messageLocalStock}
							</div>
							<div class="form-group">
								<textarea class="form-control form-control-user" id="obs"
									placeholder="Observações" name="obs">${artigoByUid.obs}</textarea>
								<div class="invalid-feedback">
									Campo obrigatório!
								</div>
								${messageObs}
							</div>
							<div class="form-group row">
								<div class="col-sm-6 mb-3 mb-sm-0">
									<select name="estado" class="form-control">
										<c:forEach items="${listaEstados}" var="estado">
											<c:choose>
												<c:when test ="${estadoArtigo.uid == estado.uid}">
													<option selected value="${estado.uid}">${estado.item}</option>
												</c:when>
												<c:when test ="${estadoArtigo.uid != estado.uid}">
													<option value="${estado.uid}">${estado.item}</option>
												</c:when>
											</c:choose>
										</c:forEach>
									</select>
								</div>
								<div class="col-sm-6">
									<select name="tipoArtigo" class="form-control">
										<c:forEach items="${listaTipoArtigos}" var="tipoArtigoItem">
											<c:choose>
												<c:when test ="${tipoArtigo.uid == tipoArtigoItem.uid}">
													<option selected value="${tipoArtigoItem.uid}">${tipoArtigoItem.item}</option>
												</c:when>
												<c:when test ="${tipoArtigo.uid != tipoArtigoItem.uid}">
													<option value="${tipoArtigoItem.uid}">${tipoArtigoItem.item}</option>
												</c:when>
											</c:choose>
										</c:forEach>
									</select>
								</div>
							</div>
							<input type="submit"  class="btn btn-primary btn-user btn-block" value="Editar Artigo">
						</form>
						<hr>
					</div>
				</div>
				<!-- MOVIMENTOS -->
				<div class="tab-pane fade" id="pills-profile" role="tabpanel" aria-labelledby="pills-profile-tab">
					<br>
					<!-- Page Heading -->
					<h1 class="h3 mb-2 text-gray-800">Listagem de Artigos</h1>
					<br>
					<!-- DataTale lista de artigos -->
					<div class="card shadow mb-4">
						<div class="card-body">
							<div class="table-responsive">
								<form class="needs-validation"
									method="get" action="${pageContext.request.contextPath}/TransactionCreateServlet" novalidate>
									<input type="hidden" name="uidArtigo" value="${artigoByUid.uid}">
									<input type="submit" class="btn btn-primary" value="Atribuir uma transação">
								</form>
								<hr>
							</div>
						</div>
					</div>
					<br>
					<!-- DataTale lista de artigos -->
					<div class="card shadow mb-4">
						<div class="card-header py-3">
							<h6 class="m-0 font-weight-bold text-primary">Listagem de Movimentos</h6>
						</div>
						<div class="card-body">
							<div class="table-responsive">
								<table class="table table-striped" id="dtMovimentos" width="100%" cellspacing="0">
									<thead>
										<tr>
											<th>Data Movimento</th>
											<th>Tipo Movimento</th>
											<th>Colaborador</th>
											<th>NUC</th>
											<th>Local</th>
											<th>Utilizador</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${listaMovimento}" var="movimento">
											<tr>
												<td><a  
													href="${pageContext.request.contextPath}/TransactionViewServlet?idMovimento=${movimento.uid}" >
													${movimento.dataCriacao}</a>
												</td>
												<td>
													<c:forEach items="${listaTipoMovimento}" var="tipoMovimento">
														<c:if test = "${movimento.uidTipoMovimento == tipoMovimento.uid}">
															${tipoMovimento.item}
														</c:if>
													</c:forEach>
												</td>
												<td>${movimento.nomeColaborador}</td>
												<td>${movimento.colaboradorNuc}</td>
												<td>${movimento.localStock}</td>
												<td>
													<c:forEach items="${listaUtilizador}" var="utilizador">
														<c:if test = "${movimento.uidUtilizador == utilizador.uid}">
															${utilizador.primeiroNome} ${utilizador.ultimoNome}
														</c:if>
													</c:forEach>
												</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
				
			</div>
		</div>
	</jsp:body>
</t:layout>