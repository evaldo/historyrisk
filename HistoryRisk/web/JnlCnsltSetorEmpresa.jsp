<%@page import="java.util.List"%>
<%@page import="br.cesjf.util.DAOFactory"%>
<%@page import="br.cesjf.classes.SetorEmpresa"%>
<%@page import="br.cesjf.dao.SetorEmpresaDAO"%>
<%@page import="br.cesjf.util.ConnectionFactory"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

        <%
            SetorEmpresaDAO se = DAOFactory.createSetorEmpresaDAO();
            List<SetorEmpresa> setoresEmpresa = se.listar();
        %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>History Risk - Setor Empresa</title>
    </head>
    <body>
        
        <%@ include file ="Menu.jsp" %>
        <h1>Consulta Setor Empresa</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nome do Setor</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>

            <tbody>
                <% for (SetorEmpresa setorEmpresa : setoresEmpresa) {%>              
                <tr>
                    <td><%=setorEmpresa.getIdSetorEmpr()%></a></td>
                    <td><%=setorEmpresa.getNmSetorEmpr()%></td>
                    <td><a href="JnlAltSetorEmpresa.jsp?opcao=alterar&idSetorEmpr=<%=setorEmpresa.getIdSetorEmpr()%>&nmSetorEmpr=<%=setorEmpresa.getNmSetorEmpr()%>">Alterar</a></td>
                    <td><a href="SetorEmpresaController?opcao=excluir&idSetorEmpr=<%=setorEmpresa.getIdSetorEmpr()%>&nmSetorEmpr=<%=setorEmpresa.getNmSetorEmpr()%>">Excluir</a></td>
                </tr>
                <%}%>
            </tbody>
        </table>

        <%@ include file ="Rodape.jsp" %>

    </body>
</html>