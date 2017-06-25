<%@page import="java.text.SimpleDateFormat"%>
<%@page import="br.cesjf.classes.Risco"%>
<%@page import="java.util.List"%>
<%@page import="br.cesjf.util.DAOFactory"%>
<%@page import="br.cesjf.dao.RiscoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    RiscoDAO rsc = DAOFactory.createRiscoDAO();
    List<Risco> riscos = rsc.listar();
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>History Risk - Consulta de Risco </title>
        <link rel="shortcut icon" href="imagens/ImagemLogo.png" type="image/x-png"/>
    </head>
    <body>
        <%@ include file ="Menu.jsp" %>
        <h1>Consulta Risco</h1>

        <form class="navbar-form navbar-left" role="search" name="form1" action="RiscoController" method="POST">
            <input type="hidden" name="opcao" value="pesquisar">
            <div class="form-group">
                <input type="text" class="form-control" placeholder="Pesquisar..." name="cmpPesquisa" size="100">
            </div>
            <button type="submit" class="btn btn-default"><span class="glyphicon glyphicon-search" aria-hidden="true"></span> Pesquisar</button>
        </form>
        <table class="table table-hover">
            <thead>
                <tr>
                    <th></th>
                    <th>Faixa de Probabilidade</th>
                    <th>Categoria Risco</th>
                    <th>Sub Categoria Risco</th>
                    <th>Nivel Impacto</th>
                    <th>Projeto</th>
                    <th>Descrição do Risco</th>
                    <th>Valor do Custo Estimado Risco</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>

            <tbody>
                <% for (Risco risco : riscos) {%>              
                <tr>
                    <td align="center"><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span></td>
                    <td><%=risco.getNuPerctProbRisco() %></td>
                    <td><%=risco.getCategoriaRisco().getDsCategoriaRisco()%></td>
                    <td><%=risco.getSubCategoriaRisco().getDsSubCatgRisco() %></td>
                    <td><%=risco.getNivelImpacto().getNmNivelIpcto() %></td>
                    <td><%=risco.getProjeto().getDsPrjt()%></td>
                    <td><%=risco.getDsRisco()%></td>
                    <td><%=risco.getVlCustoEstmdRisco()%></td>      
                    <td align="right"><a href="JnlAltRisco.jsp?opcao=alterar&idHrskRisco=<%=risco.getIdHrskRisco()%>"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a></td>
                    <td align="right"><a href="javascript:func()" onclick="confirmacao('1')"><span class="glyphicon glyphicon-remove-sign" aria-hidden="true"></span></a></td>
            <script language="Javascript">
                function confirmacao(id) {
                    var resposta = confirm("Deseja realmente excluir este registro?");
                    if (resposta == true) {
                        window.location.href = "RiscoController?opcao=excluir&idHrskRisco=<%=risco.getIdHrskRisco()%>"
                    }
                }
            </script>

        </tr>
        <%}%>
    </tbody>
</table>

<%@ include file ="Rodape.jsp" %>

</body>
</html>