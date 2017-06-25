<%@page import="java.text.SimpleDateFormat"%>
<%@page import="br.cesjf.classes.NivelImpacto"%>
<%@page import="java.util.List"%>
<%@page import="br.cesjf.dao.NivelImpactoDAO"%>
<%@page import="br.cesjf.util.DAOFactory"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    NivelImpactoDAO se = DAOFactory.createNivelImpactoDAO();
    List<NivelImpacto> niveisImpacto = se.listar();
    SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>History Risk - Nivel de Impacto</title>
        <link rel="shortcut icon" href="imagens/ImagemLogo.png" type="image/x-png"/>
    </head>
    <body>
        <%@ include file ="Menu.jsp" %>
        <h1>Consulta Nivel Impacto</h1>
        <form class="navbar-form navbar-left" role="search" name="form1" action="NivelImpactoController" method="POST">
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
                    <th>Nivel Impacto</th>
                    <th>Descrição</th>                    
                    <th>Incremento Nivel Impacto</th>
                    <th>Valor Associado ao Nivel de Impacto</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>

            <tbody>
                <% for (NivelImpacto nivelImpacto : niveisImpacto) {%>              
                <tr>
                    <td align="center"><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span></td>
                    <td><%=nivelImpacto.getNmNivelIpcto()%></td>
                    <td><%=nivelImpacto.getDsNivelIpcto()%></td>
                    <td><%=nivelImpacto.getIcNivelIpcto()%></td>
                    <td><%=nivelImpacto.getVlAsscNivelIpcto()%></td>
                    <td align="right"><a href="JnlAltNivelImpacto.jsp?opcao=alterar&idNivelIpcto=<%=nivelImpacto.getIdNivelIpcto()%>&nmNivelIpcto=<%=nivelImpacto.getNmNivelIpcto()%>&dsNivelIpcto=<%=nivelImpacto.getDsNivelIpcto()%>&icNivelIpcto=<%=nivelImpacto.getIcNivelIpcto()%>&vlAsscNivelIpcto=<%=nivelImpacto.getVlAsscNivelIpcto()%>"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a></td>
                    <td align="right"><a href="javascript:func()" onclick="confirmacao('1')"><span class="glyphicon glyphicon-remove-sign" aria-hidden="true"></span></a></td>
            <script language="Javascript">
                function confirmacao(id) {
                    var resposta = confirm("Deseja realmente excluir este registro?");
                    if (resposta == true) {
                        window.location.href = "NivelImpactoController?opcao=excluir&idNivelIpcto=<%=nivelImpacto.getIdNivelIpcto()%>"
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