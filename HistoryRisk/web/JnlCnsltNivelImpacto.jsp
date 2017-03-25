<%@page import="br.cesjf.classes.NivelImpacto"%>
<%@page import="java.util.List"%>
<%@page import="br.cesjf.dao.NivelImpactoDAO"%>
<%@page import="br.cesjf.util.DAOFactory"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    NivelImpactoDAO se = DAOFactory.createNivelImpactoDAO();
    List<NivelImpacto> niveisImpacto = se.listar();
%>
<%@ include file ="Menu.jsp" %>
        <h1>Consulta Nivel Impacto</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Descrição</th>
                    <th>Nivel Impacto</th>
                    <th>Incremento Nivel Impacto</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
  
            <tbody>
                <% for (NivelImpacto nivelImpacto : niveisImpacto){ %>              
                <tr>
                    <td><%=nivelImpacto.getIdNivelIpcto()%></td>
                    <td><%=nivelImpacto.getNmNivelIpcto()%></td>
                    <td><%=nivelImpacto.getDsNivelIpcto()%></td>
                    <td><%=nivelImpacto.getIcNivelIpcto()%></td>
                    <td>Alterar</td>
                    <td>Excluir</td>
                </tr>
                <%} %>
            </tbody>
        </table>
            
<%@ include file ="Rodape.jsp" %>
