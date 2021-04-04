<%@ tag language="java" pageEncoding="UTF-8"%>
<%@attribute name="header" fragment="true"%>
<%@attribute name="footer" fragment="true"%>
<%@attribute name="css" fragment="true" %>
<%@attribute name="js" fragment="true" %>
<!doctype html>
<html lang="en">
   <head>
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      
      <link href="${pageContext.request.contextPath}/css/form-validation.css" rel="stylesheet">
      <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
      <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap">
      <link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.19.1/css/mdb.min.css" rel="stylesheet">
      <link href="https://cdn.datatables.net/1.10.24/css/dataTables.bootstrap5.min.css" rel="stylesheet">
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
      <link href="${pageContext.request.contextPath}/css/dashboard.css" rel="stylesheet">
      <link href="https://cdn.datatables.net/searchpanes/1.2.1/css/searchPanes.dataTables.min.css" rel="stylesheet">
      <link href="https://cdn.datatables.net/select/1.3.3/css/select.dataTables.min.css" rel="stylesheet">
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
   </head>
   <body>
      <div id ="pageHeader"
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
      </div>
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
		<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.js"></script>
		<script type="text/javascript" src="https://cdn.datatables.net/1.10.24/js/jquery.dataTables.min.js"></script>
		<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.4/umd/popper.min.js"></script>
		<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.19.1/js/mdb.min.js"></script>
		<script type="text/javascript" src="https://cdn.datatables.net/1.10.24/js/dataTables.bootstrap5.min.js"></script>
		<script type="text/javascript" src="https://cdn.datatables.net/searchpanes/1.2.1/js/dataTables.searchPanes.min.js"></script>
		<script type="text/javascript" src="//code.highcharts.com/highcharts.js"></script>
		<script type="text/javascript" src="https://cdn.datatables.net/select/1.3.3/js/dataTables.select.min.js"></script>		
		
		<script>
		$(document).ready(function () {
		    // Create DataTable
		    var table = $('#dtBasicExample').DataTable({
		        dom: 'Pfrtip',
		    });
		 
		    // Create the chart with initial data
		    var container = $('<div/>').insertBefore(table.table().container());
		 
		    var chart = Highcharts.chart(container[0], {
		        chart: {
		            type: 'pie',
		        },
		        title: {
		            text: 'Staff Count Per Position',
		        },
		        series: [
		            {
		                data: chartData(table),
		            },
		        ],
		    });
		 
		    // On each draw, update the data in the chart
		    table.on('draw', function () {
		        chart.series[0].setData(chartData(table));
		    });
		});
		 
		function chartData(table) {
		    var counts = {};
		 
		    // Count the number of entries for each position
		    table
		        .column(1, { search: 'applied' })
		        .data()
		        .each(function (val) {
		            if (counts[val]) {
		                counts[val] += 1;
		            } else {
		                counts[val] = 1;
		            }
		        });
		 
		    // And map it to the format highcharts uses
		    return $.map(counts, function (val, key) {
		        return {
		            name: key,
		            y: val,
		        };
		    });
		}
		</script>
   </body>
</html>