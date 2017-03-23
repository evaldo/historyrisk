<%@page import="java.util.List"%>
<%@page import="br.cesjf.util.DAOFactory"%>
<%@page import="br.cesjf.classes.SetorEmpresa"%>
<%@page import="br.cesjf.dao.SetorEmpresaDAO"%>
<%@page import="br.cesjf.util.ConnectionFactory"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    int idSetorEmpr;
    String nmSetorEmpr;
    SetorEmpresaDAO se = DAOFactory.createSetorEmpresaDAO();
    List<SetorEmpresa> setoresEmpresa = se.listar();
            
%>  
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Consulta Setor Empresa</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nome do Setor</th>
                </tr>
            </thead>
  
            <tbody>
                <% for (SetorEmpresa setorEmpresa : setoresEmpresa){ %>              
                <tr>
                    <td><%=setorEmpresa.getIdSetorEmpr() %></td>
                    <td><%=setorEmpresa.getNmSetorEmpr() %></td>
                </tr>
                <%} %>
            </tbody>
        </table>

    </body>
</html>
