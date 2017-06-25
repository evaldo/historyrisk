<%@page import="java.text.SimpleDateFormat"%>
<%@page import="br.cesjf.classes.CategoriaRisco"%>
<%@page import="br.cesjf.dao.CategoriaRiscoDAO"%>
<%@page import="java.util.List"%>
<%@page import="br.cesjf.util.DAOFactory"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    CategoriaRiscoDAO se = DAOFactory.createCategoraiRiscoDAO();
    List<CategoriaRisco> categoriasRisco = se.listar();
    SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>History Risk - Categoria de Risco</title>
        <link rel="shortcut icon" href="imagens/ImagemLogo.png" type="image/x-png"/>
    </head>
    <body>

        <%@ include file ="Menu.jsp" %>
        <h1>Consulta Categoria do Risco</h1>
        
        <form class="navbar-form navbar-left" role="search" name="form1" action="CategoriaRiscoController" method="POST">
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
                    <th>Categoria do Risco</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>

            <tbody>
                <% for (CategoriaRisco categoriaRisco : categoriasRisco) {%>              
                <tr>
                    <td align="center"><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span></td>
                    <td><%=categoriaRisco.getDsCategoriaRisco()%></td>
                    <td align="right"><a href="JnlAltCategoriaRisco.jsp?opcao=alterar&idCategoriaRisco=<%=categoriaRisco.getIdCategoriaRisco()%>&dsCategoriaRisco=<%=categoriaRisco.getDsCategoriaRisco()%>"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a></td>
                    <td align="right"><a href="javascript:func()" onclick="confirmacao('1')"><span class="glyphicon glyphicon-remove-sign" aria-hidden="true"></span></a></td>
            <script language="Javascript">
                function confirmacao(id) {
                    var resposta = confirm("Deseja realmente excluir este registro?");
                    if (resposta == true) {
                        window.location.href = "CategoriaRiscoController?opcao=excluir&idCategoriaRisco=<%=categoriaRisco.getIdCategoriaRisco()%>"
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
