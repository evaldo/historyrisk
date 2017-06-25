<%
    HttpSession sessao = request.getSession();

%>
<link rel='stylesheet' type="text/css" href="css/style.css"/>
<script src="js/jquery/jquery-3.2.1.min.js" type="text/javascript"></script>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

<div class='topo-site'>
    <img src="imagens/Logo.png"/>
    <div class="information">Olá, <%=sessao.getAttribute("nmIncs")%>. | <a href="AuthenticationController?opcao=sair">Sair</a></div>
</div>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->


        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="Index.jsp"><span class="glyphicon glyphicon-home" aria-hidden="true"></span></a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Setor Empresa <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Home</a></li>
                        <li><a href="JnlCdtrSetorEmpresa.jsp">Cadastrar</a></li>
                        <li><a href="JnlCnsltSetorEmpresa.jsp">Pesquisar</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Categoria do Risco <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Home</a></li>
                        <li><a href="JnlCdtrCategoriaRisco.jsp">Cadastrar Categoria de Risco</a></li>
                        <li><a href="JnlCdtrSubCategoriaRisco.jsp">Cadastrar Sub Categoria de Risco</a></li>
                        <li><a href="JnlCnsltCategoriaRisco.jsp">Pesquisar Categoria de Risco </a></li>                        
                        <li><a href="JnlCnsltSubCategoriaRisco.jsp">Pesquisar Sub Categoria de Risco </a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Faixa de Probabilidade <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Home</a></li>
                        <li><a href="JnlCdtrFaixaProbabilidade.jsp">Cadastrar</a></li>
                        <li><a href="JnlCnsltFaixaProbabilidade.jsp">Pesquisar</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Nivel de Impacto <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Home</a></li>
                        <li><a href="JnlCdtrNivelImpacto.jsp">Cadastrar</a></li>
                        <li><a href="JnlCnsltNivelImpacto.jsp">Pesquisar</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Projeto <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Home</a></li>
                        <li><a href="JnlCdtrProjeto.jsp">Cadastrar</a></li>
                        <li><a href="JnlCnsltProjeto.jsp">Pesquisar</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Risco <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Home</a></li>
                        <li><a href="JnlCdtrRisco.jsp">Cadastrar</a></li>
                        <li><a href="JnlCnsltRisco.jsp">Pesquisar</a></li>
                    </ul>
                </li>
                                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Calculo Exposição de Risco <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Home</a></li>                      
                        <li><a href="JnlCalcVlrMontEsprd.jsp">Calcular Valor Monetário Esperado</a></li>
                        <li><a href="JnlCalcRiscoGeral.jsp">Calcular Risco Geral</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Manutenção <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Home</a></li>
                        <li><a href="JnlCdtrUsuario.jsp">Cadastrar Usuários</a></li>
                        <li><a href="JnlCnsltUsuario.jsp">Pesquisar Usuários</a></li>
                        <li><a href="Sobre.jsp">Sobre</a></li>
                    </ul>
                </li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
<div class="conteudo">