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
			<h2>Página de Administração de conteúdos</h2>
			<br>
			<ul class="nav nav-tabs mb-3" id="pills-tab" role="tablist">
				<li class="nav-item" role="presentation">
					<button class="nav-link active" id="pills-home-tab" data-bs-toggle="pill" data-bs-target="#pills-home" 
						type="button" role="tab" aria-controls="pills-home" aria-selected="true">Estados</button>
				</li>
				<li class="nav-item" role="presentation">
					<button class="nav-link" id="pills-profile-tab" data-bs-toggle="pill" data-bs-target="#pills-profile" 
						type="button" role="tab" aria-controls="pills-profile" aria-selected="false">Tipos de Artigo</button>
				</li>
				<li class="nav-item" role="presentation">
					<button class="nav-link" id="pills-contact-tab" data-bs-toggle="pill" data-bs-target="#pills-contact" 
						type="button" role="tab" aria-controls="pills-contact" aria-selected="false">Tipos de Movimento</button>
				</li>
			</ul>
			<!-- ESTADO -->
			<div class="tab-content" id="pills-tabContent">
				<!-- LISTAGEM DE ESTADOS -->
				<div class="tab-pane fade show active" id="pills-home" role="tabpanel" aria-labelledby="pills-home-tab">
					<small id="emailHelp" class="form-text text-muted">Selecione um item da lista clicando por cima do nome</small>
					<form class="row row-cols-lg-auto g-3 align-items-center needs-validation"
						method="post" action="${pageContext.request.contextPath}/BOEditSelectEstadoServlet" novalidate>
						<div class="form-group row">
							<div class="col-sm-8">
								<input type="text" class="form-control" required name="item"
									placeholder="Introduza o novo nome" id="estadoOld">
								<input type="hidden" id="uidEstado" required name="uid">
								<div class="invalid-feedback">
									Campo obrigatório!
								</div>
							</div>
							${messageIsNull}
							<input type="submit" class="btn btn-primary" value="Atualizar">
						</div>
					</form>
					<small id="emailHelp" class="form-text text-muted">Criação de um novo item</small>
					<form class="row row-cols-lg-auto g-3 align-items-center needs-validation"
						method="post" action="${pageContext.request.contextPath}/BOCreateSelectEstadoServlet" novalidate>
						<div class="form-group row">
							<div class="col-sm-8">
								<input type="text" class="form-control" required name="item"
									placeholder="Introduza o novo nome">
								<div class="invalid-feedback">
									Campo obrigatório!
								</div>
							</div>
							${messageIsNull}
							<input type="submit" class="btn btn-primary" value="Criar">
						</div>
					</form>
					<br>
					<div class="card shadow mb-4">
						<div class="card-header py-3">
							<h6 class="m-0 font-weight-bold text-primary">Estados</h6>
						</div>
						<div class="card-body">
							<div class="table-responsive">
								<table id="dtListarConteudo" class="dtListarConteudo table table-striped " >
									<thead>
										<tr>
											<th >Item da Lista</th>
											<th></th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${listaEstado}" var="estado">
											<tr>
												<td><a onClick="funcSelectItemEstado(this);" data-uid="${estado.uid}">${estado.item}</a></td>
												<td>
													<form  method="post">
														<button value="${estado.uid}"type="submit" value="Apagar" onClick="confirmDeleleEstado(this);"
															class="btn btn-primary btn-sm">Apagar</button>
													</form>
												</td>
											</tr>
										</c:forEach>
									</tbody>
									<tfoot>
										<tr>
											<th >Item da Lista</th>
											<th></th>
										</tr>
									</tfoot>
								</table>
							</div>
						</div>
					</div>
				</div>
				<!-- TIPOS DE ARTIGO -->
				<div class="tab-pane fade" id="pills-profile" role="tabpanel" aria-labelledby="pills-profile-tab">
					<small id="emailHelp" class="form-text text-muted">Selecione um item da lista clicando por cima do nome</small>
					<form class="row row-cols-lg-auto g-3 align-items-center needs-validation"
						method="post" action="${pageContext.request.contextPath}/BOEditSelectTipoArtigoServlet" novalidate>
						<div class="form-group row">
							<div class="col-sm-8">
								<input type="text" class="form-control" required name="item"
									placeholder="Introduza o novo nome" id="tipoArtigoOld">
								<input type="hidden" id="uidTipoArtigo" required name="uid">
								<div class="invalid-feedback">
									Campo obrigatório!
								</div>
							</div>
							${messageIsNull}
							<input type="submit" class="btn btn-primary" value="Atualizar">
						</div>
					</form>
					<small id="emailHelp" class="form-text text-muted">Criação de um novo item</small>
					<form class="row row-cols-lg-auto g-3 align-items-center needs-validation"
						method="post" action="${pageContext.request.contextPath}/BOCreateSelectTipoArtigoServlet" novalidate>
						<div class="form-group row">
							<div class="col-sm-8">
								<input type="text" class="form-control" required name="item"
									placeholder="Introduza o novo nome">
								<div class="invalid-feedback">
									Campo obrigatório!
								</div>
							</div>
							${messageIsNull}
							<input type="submit" class="btn btn-primary" value="Criar">
						</div>
					</form>
					<br>
					<div class="card shadow mb-4">
						<div class="card-header py-3">
							<h6 class="m-0 font-weight-bold text-primary">Tipos de Artigo</h6>
						</div>
						<div class="card-body">
							<div class="table-responsive">
								<table id="dtListarConteudo" class="dtListarConteudo table table-striped" width="100%">
									<thead>
										<tr>
											<th >Item da Lista</th>
											<th></th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${listaTipoArtigo}" var="tipoArtigo">
											<tr>
												<td><a onClick="funcSelectItemTipoArtigo(this);" data-uid="${tipoArtigo.uid}">${tipoArtigo.item}</a></td>
												<td>
													<form  method="post">
														<button value="${tipoArtigo.uid}"type="submit" value="Apagar" onClick="confirmDeleleTipoArtigo(this);"
															class="btn btn-primary btn-sm">Apagar</button>
													</form>
												</td>
											</tr>
										</c:forEach>
									</tbody>
									<tfoot>
										<tr>
											<th >Item da Lista</th>
											<th></th>
										</tr>
									</tfoot>
								</table>
							</div>
						</div>
					</div>
				</div>
				<!-- TIPOS DE MOVIMENTO -->
				<div class="tab-pane fade" id="pills-contact" role="tabpanel" aria-labelledby="pills-contact-tab">
					<small id="emailHelp" class="form-text text-muted">Selecione um item da lista clicando por cima do nome</small>
					<form class="row row-cols-lg-auto g-3 align-items-center needs-validation"
						method="post" action="${pageContext.request.contextPath}/BOEditSelectTipoMovimentoServlet" novalidate>
						<div class="form-group row">
							<div class="col-sm-8">
								<input type="text" class="form-control" required name="item"
									placeholder="Introduza o novo nome" id="tipoMovimentoOld">
								<input type="hidden" id="uidTipoMovimento" required name="uid">
								<div class="invalid-feedback">
									Campo obrigatório!
								</div>
							</div>
							${messageIsNull}
							<input type="submit" class="btn btn-primary" value="Atualizar">
						</div>
					</form>
					<small id="emailHelp" class="form-text text-muted">Criação de um novo item</small>
					<form class="row row-cols-lg-auto g-3 align-items-center needs-validation"
						method="post" action="${pageContext.request.contextPath}/BOCreateSelectTipoMovimentoServlet" novalidate>
						<div class="form-group row">
							<div class="col-sm-8">
								<input type="text" class="form-control" required name="item"
									placeholder="Introduza o novo nome">
								<div class="invalid-feedback">
									Campo obrigatório!
								</div>
							</div>
							${messageIsNull}
							<input type="submit" class="btn btn-primary" value="Criar">
						</div>
					</form>
					<br>
					<div class="card shadow mb-4">
						<div class="card-header py-3">
							<h6 class="m-0 font-weight-bold text-primary">Tipos de Movimento</h6>
						</div>
						<div class="card-body">
							<div class="table-responsive">
								<table id="dtListarConteudo" class="dtListarConteudo table table-striped" width="100%">
									<thead>
										<tr>
											<th >Item da Lista</th>
											<th></th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${listaTipoMovimento}" var="tipoMovimento">
											<tr>
												<td><a onClick="funcSelectItemTipoMovimento(this);" data-uid="${tipoMovimento.uid}">${tipoMovimento.item}</a></td>
												<td>
													<form  method="post">
														<button value="${tipoMovimento.uid}"type="submit" value="Apagar" onClick="confirmDeleleTipoMovimento(this);"
															class="btn btn-primary btn-sm">Apagar</button>
													</form>
												</td>
											</tr>
										</c:forEach>
									</tbody>
									<tfoot>
										<tr>
											<th >Item da Lista</th>
											<th></th>
										</tr>
									</tfoot>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</jsp:body>
</t:layout>