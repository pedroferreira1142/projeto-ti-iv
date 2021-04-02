<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:layout>

	<jsp:body>
		<div class="container">
      <!-- /Breadcrumb -->

      <div class="row gutters-sm">
        <div class="col-md-4 d-none d-md-block">
          <div class="card">
            <div class="card-body">
            
            	<!-- MENU DE NAVEGAÇÃO LATERAL -->
              <nav class="nav flex-column nav-pills nav-gap-y-1">
                <a href="#profile" data-toggle="tab"
									class="nav-item nav-link has-icon nav-link-faded active">
                  <svg xmlns="http://www.w3.org/2000/svg" width="24"
										height="24" viewBox="0 0 24 24" fill="none"
										stroke="currentColor" stroke-width="2" stroke-linecap="round"
										stroke-linejoin="round" class="feather feather-user mr-2">
										<path d="M20 21v-2a4 4 0 0 0-4-4H8a4 4 0 0 0-4 4v2"></path>
										<circle cx="12" cy="7" r="4"></circle></svg>Criar Artigo
                </a>
                <a href="#account" data-toggle="tab"
									class="nav-item nav-link has-icon nav-link-faded">
                  <svg xmlns="http://www.w3.org/2000/svg" width="24"
										height="24" viewBox="0 0 24 24" fill="none"
										stroke="currentColor" stroke-width="2" stroke-linecap="round"
										stroke-linejoin="round" class="feather feather-settings mr-2">
										<circle cx="12" cy="12" r="3"></circle>
										<path
											d="M19.4 15a1.65 1.65 0 0 0 .33 1.82l.06.06a2 2 0 0 1 0 2.83 2 2 0 0 1-2.83 0l-.06-.06a1.65 1.65 0 0 0-1.82-.33 1.65 1.65 0 0 0-1 1.51V21a2 2 0 0 1-2 2 2 2 0 0 1-2-2v-.09A1.65 1.65 0 0 0 9 19.4a1.65 1.65 0 0 0-1.82.33l-.06.06a2 2 0 0 1-2.83 0 2 2 0 0 1 0-2.83l.06-.06a1.65 1.65 0 0 0 .33-1.82 1.65 1.65 0 0 0-1.51-1H3a2 2 0 0 1-2-2 2 2 0 0 1 2-2h.09A1.65 1.65 0 0 0 4.6 9a1.65 1.65 0 0 0-.33-1.82l-.06-.06a2 2 0 0 1 0-2.83 2 2 0 0 1 2.83 0l.06.06a1.65 1.65 0 0 0 1.82.33H9a1.65 1.65 0 0 0 1-1.51V3a2 2 0 0 1 2-2 2 2 0 0 1 2 2v.09a1.65 1.65 0 0 0 1 1.51 1.65 1.65 0 0 0 1.82-.33l.06-.06a2 2 0 0 1 2.83 0 2 2 0 0 1 0 2.83l-.06.06a1.65 1.65 0 0 0-.33 1.82V9a1.65 1.65 0 0 0 1.51 1H21a2 2 0 0 1 2 2 2 2 0 0 1-2 2h-.09a1.65 1.65 0 0 0-1.51 1z"></path></svg>Pesquisar Artigo
                </a>
              </nav>
              
              <!-- /MENU DE NAVEGAÇÃO LATERAL -->
              
            </div>
          </div>
        </div>
        <div class="col-md-8">
        
          <div class="card">
            <div class="card-header border-bottom mb-3 d-flex d-md-none">
              <ul class="nav nav-tabs card-header-tabs nav-gap-x-1"
								role="tablist">
                <li class="nav-item">
                  <a href="#profile" data-toggle="tab"
									class="nav-link has-icon active"><svg
											xmlns="http://www.w3.org/2000/svg" width="24" height="24"
											viewBox="0 0 24 24" fill="none" stroke="currentColor"
											stroke-width="2" stroke-linecap="round"
											stroke-linejoin="round" class="feather feather-user">
											<path d="M20 21v-2a4 4 0 0 0-4-4H8a4 4 0 0 0-4 4v2"></path>
											<circle cx="12" cy="7" r="4"></circle></svg></a>
                </li>
                <li class="nav-item">
                  <a href="#account" data-toggle="tab"
									class="nav-link has-icon"><svg
											xmlns="http://www.w3.org/2000/svg" width="24" height="24"
											viewBox="0 0 24 24" fill="none" stroke="currentColor"
											stroke-width="2" stroke-linecap="round"
											stroke-linejoin="round" class="feather feather-settings">
											<circle cx="12" cy="12" r="3"></circle>
											<path
												d="M19.4 15a1.65 1.65 0 0 0 .33 1.82l.06.06a2 2 0 0 1 0 2.83 2 2 0 0 1-2.83 0l-.06-.06a1.65 1.65 0 0 0-1.82-.33 1.65 1.65 0 0 0-1 1.51V21a2 2 0 0 1-2 2 2 2 0 0 1-2-2v-.09A1.65 1.65 0 0 0 9 19.4a1.65 1.65 0 0 0-1.82.33l-.06.06a2 2 0 0 1-2.83 0 2 2 0 0 1 0-2.83l.06-.06a1.65 1.65 0 0 0 .33-1.82 1.65 1.65 0 0 0-1.51-1H3a2 2 0 0 1-2-2 2 2 0 0 1 2-2h.09A1.65 1.65 0 0 0 4.6 9a1.65 1.65 0 0 0-.33-1.82l-.06-.06a2 2 0 0 1 0-2.83 2 2 0 0 1 2.83 0l.06.06a1.65 1.65 0 0 0 1.82.33H9a1.65 1.65 0 0 0 1-1.51V3a2 2 0 0 1 2-2 2 2 0 0 1 2 2v.09a1.65 1.65 0 0 0 1 1.51 1.65 1.65 0 0 0 1.82-.33l.06-.06a2 2 0 0 1 2.83 0 2 2 0 0 1 0 2.83l-.06.06a1.65 1.65 0 0 0-.33 1.82V9a1.65 1.65 0 0 0 1.51 1H21a2 2 0 0 1 2 2 2 2 0 0 1-2 2h-.09a1.65 1.65 0 0 0-1.51 1z"></path></svg></a>
                </li>
              </ul>
            </div>
            
            <!-- CONTENTOR DOS SEPARADORES -->
            <div class="card-body tab-content">
            
            	<!-- TAB DAS INFORMAÇÕES DE CONTA -->
              <div class="tab-pane active" id="profile">
                <br><br><h6>NOVO ARTIGO</h6>
                <hr>
                
                <!-- FORMULÁRIO DE EDIÇÃO DAS INFORMAÇÕES DE CONTA -->
                <form action="ArtigoCriarServlet" method="post">                
                  <div class="form-group">
                    <label for="descricaoArtigo">Descrição</label>
                    <input type="text" class="form-control"
											aria-describedby="descricaoArtigo"
											placeholder="Introduza a descrição do artigo" 
											name="descricaoArtigo">
                  </div>
                  ${messageDescricao}
                  <div class="form-group">
                    <label for="marcaArtigo">Marca</label>
                    <input type="text" class="form-control"
											aria-describedby="marcaArtigo"
											placeholder="Introduza a marca do artigo" 
											name="marcaArtigo">
                  </div>
                  ${messageMarca}
                  <div class="form-group">
                    <label for="modeloArtigo">Modelo</label>
                    <input type="text" class="form-control" id="url"
											placeholder="Introduza o modelo do artigo"
											name="modeloArtigo">
                  </div>
                  ${messageModelo}
                  <div class="form-group">
                    <label for="numImoblizado">Número Imobilizado</label>
                    <input type="text" class="form-control"
											placeholder="Introduza o número de imobilizado"
											name="numImobilizado">
                  </div>
                  ${messageNumImobilizado}
                  <div class="form-group">
                    <label for="numSerie">Número Série</label>
                    <input type="text" class="form-control"
											name="numSerie">
                  </div>
                  ${messageNumSerie}
                  <div class="form-group">
                    <label for="localStock">Local Stock</label>
                    <input type="text" class="form-control"
											name="localStock">
                  </div>
                  ${messageLocalStock}
                  <button type="submit" class="btn btn-primary">Criar Artigo</button>
                </form>
                <!-- /FORMULÁRIO DE CRIAÇÃO DE UM ARTIGO -->
                
              </div>
              <!-- /TAB DAS INFORMAÇÕES DE CONTA -->
               
              <!-- CONFIGURAÇÕES DE SEGURANÇA -->
              <div class="tab-pane" id="pesquisarArtigo">                          
                <br><br><h6>PESQUISAR ARTIGO</h6>
                <hr>
                <form action="ArtigoPesquisarServlet" method="post">
                  
                </form>
                <hr>
               </div>
              <!-- /CONFIGURAÇÕES DE SEGURANÇA -->
              
            </div>
            <!-- CONTENTOR DOS SEPARADORES -->
            
          </div>
        </div>
      </div>

    </div>                                 
</jsp:body>

</t:layout>