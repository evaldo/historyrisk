<%@page import="br.cesjf.classes.CategoriaRisco"%>
<%@page import="br.cesjf.dao.CategoriaRiscoDAO"%>
<%@page import="java.util.List"%>
<%@page import="br.cesjf.util.DAOFactory"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    CategoriaRiscoDAO se = DAOFactory.createCategoraiRiscoDAO();
    List<CategoriaRisco> categoriasRisco = se.listar();
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>History Risk - Nova Categoria de Risco</title>
    </head>
    <body>
        
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
                    <td><a href="JnlAltCategoriaRisco.jsp?opcao=alterar&idCategoriaRisco=<%=categoriaRisco.getIdCategoriaRisco()%>&dsCategoriaRisco=<%=categoriaRisco.getDsCategoriaRisco()%>">Alterar</a></td>
                    <td><a href="CategoriaRiscoController?opcao=excluir&idCategoriaRisco=<%=categoriaRisco.getIdCategoriaRisco()%>&dsCategoriaRisco=<%=categoriaRisco.getDsCategoriaRisco()%>">Excluir</a></td>
                </tr>
                <%} %>
            </tbody>
        </table>
            
<%@ include file ="Rodape.jsp" %>

    </body>
</html>
