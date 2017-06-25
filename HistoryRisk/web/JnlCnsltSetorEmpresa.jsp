<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="br.cesjf.util.DAOFactory"%>
<%@page import="br.cesjf.classes.SetorEmpresa"%>
<%@page import="br.cesjf.dao.SetorEmpresaDAO"%>
<%@page import="br.cesjf.util.ConnectionFactory"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<%
    SetorEmpresaDAO se = DAOFactory.createSetorEmpresaDAO();
    List<SetorEmpresa> setoresEmpresa = se.listar();
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>History Risk - Setor Empresa</title>
        <link rel="shortcut icon" href="imagens/ImagemLogo.png" type="image/x-png"/>
    </head>
    <body>

        <%@ include file ="Menu.jsp" %>
        <h1>Consulta Setor Empresa</h1>
        
        <form class="navbar-form navbar-left" role="search" name="form1" action="SetorEmpresaController" method="POST">
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
                    <th>Nome do Setor</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>

            <tbody>
                <% for (SetorEmpresa setorEmpresa : setoresEmpresa) {%>              
                <tr>
                    <td align="center"><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span></a></td>
                    <td><%=setorEmpresa.getNmSetorEmpr()%></td>
                    <td align="right"><a href="JnlAltSetorEmpresa.jsp?opcao=alterar&idSetorEmpr=<%=setorEmpresa.getIdSetorEmpr()%>&nmSetorEmpr=<%=setorEmpresa.getNmSetorEmpr()%>"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a></td>
                    <td align="right"><a href="javascript:func()" onclick="confirmacao('1')"><span class="glyphicon glyphicon-remove-sign" aria-hidden="true"></span></a></td>
            <script language="Javascript">
                function confirmacao(id) {
                    var resposta = confirm("Deseja realmente excluir este registro?");

                    if (resposta == true) {
                        window.location.href = "SetorEmpresaController?opcao=excluir&idSetorEmpr=<%=setorEmpresa.getIdSetorEmpr()%>"
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