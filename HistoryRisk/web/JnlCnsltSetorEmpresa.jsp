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
                <% for (SetorEmpresa setorEmpresa : setoresEmpresa){ %>              
                <tr>
                    <td><%=setorEmpresa.getIdSetorEmpr() %></td>
                    <td><%=setorEmpresa.getNmSetorEmpr() %></td>
                    <td>Alterar</td>
                    <td>Excluir</td>
                </tr>
                <%} %>
            </tbody>
        </table>
            
<%@ include file ="Rodape.jsp" %>