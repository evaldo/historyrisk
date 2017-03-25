<%@page import="br.cesjf.classes.CategoriaRisco"%>
<%@page import="br.cesjf.dao.CategoriaRiscoDAO"%>
<%@page import="java.util.List"%>
<%@page import="br.cesjf.util.DAOFactory"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%
    CategoriaRiscoDAO se = DAOFactory.createCategoraiRiscoDAO();
    List<CategoriaRisco> categoriasRisco = se.listar();
%>
<%@ include file ="Menu.jsp" %>
        <h1>Consulta Categoria do Risco</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Categoria do Risco</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
  
            <tbody>
                <% for (CategoriaRisco categoriaRisco : categoriasRisco){ %>              
                <tr>
                    <td><%=categoriaRisco.getIdCategoriaRisco()%></td>
                    <td><%=categoriaRisco.getDsCategoriaRisco()%></td>
                    <td>Alterar</td>
                    <td>Excluir</td>
                </tr>
                <%} %>
            </tbody>
        </table>
            
<%@ include file ="Rodape.jsp" %>
