<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:layout>
   <jsp:body>
      <div class="container">
         <div class="col-md-7 col-lg-8">
            <br>
            <h4 class="mb-3">Mudar Password</h4>
            <form class="needs-validation" method="post" action="${pageContext.request.contextPath}/EditPasswordServlet" novalidate>
            	<div class="col-12">
                     <label for="passwordAntiga" class="form-label">Password Antiga</label>
                     <input type="password" class="form-control" id="passwordAntiga" name="passwordAntiga">
                     <div class="invalid-feedback">
                        Campo obrigatório!
                     </div>
                  </div><br>
               <div class="row g-3">
                  <div class="col-sm-6">
                     <label for="password" class="form-label">Password</label>
                     <input type="password" class="form-control" id="password"
                        required name="password">
                     <div class="invalid-feedback">
                        Campo obrigatório!
                     </div>
                  </div>
                  <div class="col-sm-6">
                     <label for="confirmarPassword" class="form-label">Confirmar Password</label>
                     <input type="password" class="form-control" id="confirmarPassword"
                        required name="confirmarPassword">
                     <div class="invalid-feedback">
                        Campo obrigatório!
                        ${messageUltimoNome}
                     </div>
                  </div>
                  
                  <button class="w-100 btn btn-primary btn-lg" type="submit">Atualizar Password</button>
               </div>
            </form>
         </div>
      </div>
      <script src="${pageContext.request.contextPath}/js/form-validation.js"></script>
   </jsp:body>
</t:layout>