<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<!doctype html>
<html lang="en">
   <head>
      <meta charset="utf-8">
      <link href="css/bootstrap.min.css" rel="stylesheet">
      <link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/sign-in/">
      <style>
         .bd-placeholder-img {
         font-size: 1.125rem;
         text-anchor: middle;
         -webkit-user-select: none;
         -moz-user-select: none;
         user-select: none;
         }
         @media (min-width: 768px) {
         .bd-placeholder-img-lg {
         font-size: 3.5rem;
         }
         }
      </style>
      <!-- Custom styles for this template -->
      <link href="css/signin.css" rel="stylesheet">
   </head>
   <body class="text-center">
      <main class="form-signin text-center">
         <div class="py-5 text-center">
            <img src="img/it-logo.jpg" alt="" class="mb-4" style="border-radius:30%">
            <h2>Registar Conta</h2>
         </div>
         <form class="needs-validation" method="post" action="${pageContext.request.contextPath}/SignUpServlet" novalidate>
         
            <div class="row g-3">
            
               <div class="col-sm-6">
                  <label for="primeiroNome" class="form-label">Primeiro Nome</label>
                  <input type="text" class="form-control" id="primeiroNome"
                     placeholder="" required name="primeiroNome">
                  <div class="invalid-feedback">
                     Campo obrigatório!
                  </div>
               </div>
               ${messagePrimeiroNome}
               
               <div class="col-sm-6">
                  <label for="ultimoNome" class="form-label">Último Nome</label>
                  <input type="text" class="form-control" id="ultimoNome"
                     placeholder="" required name="ultimoNome">
                  <div class="invalid-feedback">
                     Campo obrigatório!
                  </div>
               </div>
               ${messageUltimoNome}
               
               <div class="col-12">
                  <label for="email" class="form-label">E-mail</label>
                  <input type="email" class="form-control" id="email"
                     placeholder="you@example.com" name="email">
                  <div class="invalid-feedback">
                     Por favor introduza um e-mail válido!
                  </div>
               </div>
               ${messageEMail}
               ${messageEmailInvalid}
               
               <div class="col-12">
                  <label for="address" class="form-label">NUC</label>
                  <input type="text" class="form-control" id="address"
                     placeholder="1234" required name="nuc">
                  <div class="invalid-feedback">
                     Campo obrigatório!
                  </div>
               </div>
               ${messageNuc}
               
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
                  </div>
               </div>
               
               <button class="w-100 btn btn-primary btn-lg" type="submit">Registar</button>
            </div>
            <%= request.getAttribute("testeMensagem")%>
         </form>
         
      </main>
      <script src="${pageContext.request.contextPath}/js/form-validation.js"></script>
   </body>
</html>