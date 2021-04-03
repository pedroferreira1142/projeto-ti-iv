<%@ tag language="java" pageEncoding="UTF-8"%>
<%@attribute name="header" fragment="true"%>
<%@attribute name="footer" fragment="true"%>
<!doctype html>
<html lang="en">
   <head>
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <!-- Bootstrap core CSS -->
      <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
      <link href="${pageContext.request.contextPath}/css/form-validation.css" rel="stylesheet">
      <!-- Font Awesome -->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
	<!-- Google Fonts -->
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap">
	<!-- Bootstrap core CSS -->
	<link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet">
	<!-- Material Design Bootstrap -->
	<link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.19.1/css/mdb.min.css" rel="stylesheet">
      <style>
         .bd-placeholder-img {
         font-size: 1.125rem;
         text-anchor: middle;
         -webkit-user-select: none;
         -moz-user-select: none;
         user-select: none;
         }
         @media ( min-width : 768px) {
         .bd-placeholder-img-lg {
         font-size: 3.5rem;
         }
         }
      </style>
      <!-- Custom styles for this template -->
      <link href="${pageContext.request.contextPath}/css/dashboard.css" rel="stylesheet">
   </head>
   <body>
      <header
         class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow navbar-expand-lg">
         <jsp:invoke fragment="header" />
         <a class="navbar-brand col-md-3 col-lg-2 me-0 px-3" href="#">Imobilizados</a>
         <button class="navbar-toggler position-absolute d-md-none collapsed"
            type="button" data-bs-toggle="collapse" data-bs-target="#sidebarMenu"
            aria-controls="sidebarMenu" aria-expanded="false"
            aria-label="Toggle navigation">
         <span class="navbar-toggler-icon"></span>
         </button>
         <input class="form-control form-control-dark w-100" type="text"
            placeholder="Pesquisar um artigo" aria-label="Search">
         <ul class="navbar-nav px-3">
            <li class="nav-item">
               <% 
                  if(session.getAttribute("user") == null)
                  {
                  	// Utilizador não fez login
                  	%><a class="nav-link" href="/RegistoAtivos001/login.jsp">Login</a>
            </li>
            <%
               }
               else
               {
               	// Utilizador está logado
               	%>
            <a class="nav-link" href="${pageContext.request.contextPath}/EditUserServlet">${user.primeiroNome}</a>
            <%
               }			
               %>
         </ul>
      </header>
      <div class="container-fluid">
         <div class="row">
            <nav id="sidebarMenu"
               class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
               <div class="position-sticky pt-3">
                  <ul class="nav flex-column">
                     <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/index.jsp"> <span
                        data-feather="home"></span> Página Inicial
                        </a>
                     </li>
                     <li class="nav-item collapse show">
                        <a
                           class="btn-toggle collapsed nav-link" data-bs-toggle="collapse"
                           data-bs-target="#home-collapse" aria-expanded="false"> <span
                           data-feather="layers"></span> Artigo
                        </a>
                        <div class="collapse hide" id="home-collapse">
                           <ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
                              <li><a href="${pageContext.request.contextPath}/ItemCreateServlet" class="link-dark rounded nav-link"> 
                              <span data-feather="chevron-right"></span> Criar Artigo
                                 </a>
                              </li>
                              <li><a href="${pageContext.request.contextPath}/ItemListServlet" class="link-dark rounded nav-link"> <span
                                 data-feather="chevron-right"></span> Listar Artigos
                                 </a>
                              </li>
                              <li><a href="#" class="link-dark rounded nav-link"> <span
                                 data-feather="chevron-right"></span> Pesquisar
                                 </a>
                              </li>
                           </ul>
                        </div>
                     </li>
                     <li class="nav-item"><a class="nav-link" href="#"> <span
                        data-feather="file-text"></span> Movimentos
                        </a>
                     </li>
                     <li class="nav-item collapse show">
                        <a
                           class="btn-toggle collapsed nav-link" data-bs-toggle="collapse"
                           data-bs-target="#conta-collapse" aria-expanded="false"> <span
                           data-feather="user"></span> Conta
                        </a>
                        <div class="collapse hide" id="conta-collapse">
                           <ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
                              <li><a href="${pageContext.request.contextPath}/EditUserServlet"
                                 class="link-dark rounded nav-link"> <span
                                 data-feather="settings"></span> Atualizar Informações
                                 </a>
                              </li>
                              <li><a href="${pageContext.request.contextPath}/EditPasswordServlet" 
                                 class="link-dark rounded nav-link"> <span
                                 data-feather="lock"></span> Mudar Password
                                 </a>
                              </li>
                              <li><a href="#" class="link-dark rounded nav-link"> <span
                                 data-feather="user-minus"></span> Apagar Conta
                                 </a>
                              </li>
                              <li><a href="${pageContext.request.contextPath}/LogoutServlet"
                                 class="link-dark rounded nav-link"> <span
                                 data-feather="log-out"></span> Terminar Sessão
                                 </a>
                              </li>
                           </ul>
                        </div>
                     </li>
                  </ul>
               </div>
            </nav>
            <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
               <jsp:doBody />
            </main>
         </div>
      </div>
      <script src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js"></script>
      <script
         src="https://cdn.jsdelivr.net/npm/feather-icons@4.28.0/dist/feather.min.js"
         integrity="sha384-uO3SXW5IuS1ZpFPKugNNWqTZRRglnUJK6UAZ/gxOX80nxEkN9NcGZTftn6RzhGWE"
         crossorigin="anonymous"></script>
      <script
         src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.js"
         integrity="sha384-zNy6FEbO50N+Cg5wap8IKA4M/ZnLJgzc6w2NqACZaK0u0FXfOWRRJOnQtpZun8ha"
         crossorigin="anonymous"></script>
      <script src="${pageContext.request.contextPath}/js/dashboard.js"></script>
      <!-- JQuery -->
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<!-- Bootstrap tooltips -->
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.4/umd/popper.min.js"></script>
	<!-- Bootstrap core JavaScript -->
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/js/bootstrap.min.js"></script>
	<!-- MDB core JavaScript -->
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.19.1/js/mdb.min.js"></script>
   </body>
</html>