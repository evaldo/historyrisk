<%@page import="java.text.SimpleDateFormat"%>
<%@page import="br.cesjf.classes.FaixaProbabilidade"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="br.cesjf.dao.FaixaProbabilidadeDAO"%>
<%@page import="br.cesjf.util.DAOFactory"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    FaixaProbabilidadeDAO se = DAOFactory.createFaixaProbabilidadeDAO();
    List<FaixaProbabilidade> faixasProbabilidade = se.listar();
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>History Risk - Faixa Probabilidade</title>
        <link rel="shortcut icon" href="imagens/ImagemLogo.png" type="image/x-png"/>
    </head>
    <body>
        <%@ include file ="Menu.jsp" %>
        <h1>Consulta Faixa Probabilidade</h1>

        <form class="navbar-form navbar-left" role="search" name="form1" action="FaixaProbabilidadeController" method="POST">
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
                    <th>Descrição</th>
                    <th>Limite Inferior</th>
                    <th>Limite Superior</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>

            <tbody>
                <% for (FaixaProbabilidade faixaProbabilidade : faixasProbabilidade) {%>              
                <tr>
                    <td align="center"><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span></td>
                    <td><%=faixaProbabilidade.getDsFaixaProb()%></td>
                    <td><%=faixaProbabilidade.getNuLmteInfr()%></td>
                    <td><%=faixaProbabilidade.getNuLmteSupr()%></td>
                    <td align="right"><a href="JnlAltFaixaProbabilidade.jsp?opcao=alterar&idFaixaProb=<%=faixaProbabilidade.getIdFaixaProb()%>"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a></td>
                    <td align="right"><a href="javascript:func()" onclick="confirmacao('1')"><span class="glyphicon glyphicon-remove-sign" aria-hidden="true"></span></a></td>
            <script language="Javascript">
                function confirmacao(id) {
                    var resposta = confirm("Deseja realmente excluir este registro?");
                    if (resposta == true) {
                        window.location.href = "FaixaProbabilidadeController?opcao=excluir&idFaixaProb=<%=faixaProbabilidade.getIdFaixaProb()%>"
                    }
                }
            </script>

        </tr>
        <%}%>
    </tbody>
</table>

<%@ include file ="Rodape.jsp" %>
