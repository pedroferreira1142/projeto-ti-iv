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
            <form class="needs-validation" method="post" action="${pageContext.request.contextPath}/SignUpServlet" novalidate>
               <div class="row g-3">
                  <div class="col-sm-12">
                     <label for="descricaoArtigo" class="form-label">Descrição</label>
                     <input type="text" class="form-control" id="descricaoArtigo"
                        placeholder="Descrição do artigo" required name="descricaoArtigo">
                     <div class="invalid-feedback">
                        Campo obrigatório!
                     </div>
                  </div>
                  ${messageDescricao}
                  <div class="col-sm-12">
                     <label for="marcaArtigo" class="form-label">Marca</label>
                     <input type="text" class="form-control" id="marcaArtigo"
                        placeholder="ex: Lenovo" required name="marcaArtigo">
                     <div class="invalid-feedback">
                        Campo obrigatório!
                     </div>
                  </div>
                  ${messageMarca}
                  <div class="col-12">
                     <label for="modelo" class="form-label">Modelo</label>
                     <input type="text" class="form-control" id="modelo"
                        placeholder="ex: Thinkpad..." name="modelo">
                     <div class="invalid-feedback">
                        Campo obrigatório!
                     </div>
                  </div>
                  ${messageModelo}
                  <div class="col-12">
                     <label for="numImobilizado" class="form-label">Número Imobilizado</label>
                     <input type="text" class="form-control" id="numImobilizado"
                        placeholder="1234" required name="numImobilizado">
                     <div class="invalid-feedback">
                        Campo obrigatório!
                     </div>
                  </div>
                  ${messageNumImobilizado}
                  <div class="col-sm-6">
                     <label for="numSerie" class="form-label">Número Série</label>
                     <input type="text" class="form-control" id="numSerie"
                        required name="numSerie">
                     <div class="invalid-feedback">
                        Campo obrigatório!
                     </div>
                  </div>
                  ${messageNumSerie}
                  <div class="col-sm-6">
                     <label for="localStock" class="form-label">Local Stock</label>
                     <input type="text" class="form-control" id="localStock"
                        required name="localStock">
                     <div class="invalid-feedback">
                        Campo obrigatório!
                     </div>
                  </div>
                  ${messageLocalStock}
                  <div class="col-sm-12">
                     <label for="obs" class="form-label">Observações</label>
                     <textarea  class="form-control" id="obs"
                        name="obs"></textarea>
                  </div>
                  ${testeMensagem}
                  ${messageObs}
                  <div class="col-sm-12">
                     <label for="obs" class="form-label">Observações</label>
                     <select name="category">
						<c:forEach items="${listaEstados}" var="estado">
					        <option value="${estado.uid}">${estado.item}</option>
					    </c:forEach>
					</select>
                  </div>
                  
                  <button class="w-100 btn btn-primary btn-lg" type="submit">Criar</button>
               </div>
            </form>
         </div>
      </div>
      <script src="${pageContext.request.contextPath}/js/form-validation.js"></script>
   </jsp:body>
</t:layout>