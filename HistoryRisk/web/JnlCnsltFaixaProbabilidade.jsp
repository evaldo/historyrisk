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
<%@ include file ="Menu.jsp" %>
        <h1>Consulta Faixa Probabilidade</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Descrição</th>
                    <th>Limite Inferior</th>
                    <th>Limite Superior</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
  
            <tbody>
                <% for (FaixaProbabilidade faixaProbabilidade : faixasProbabilidade){ %>              
                <tr>
                    <td><%=faixaProbabilidade.getIdFaixaProb()%></td>
                    <td><%=faixaProbabilidade.getDsFaixaProb()%></td>
                    <td><%=faixaProbabilidade.getNuLmteInfr()%></td>
                    <td><%=faixaProbabilidade.getNuLmteSupr()%></td>
                    <td>Alterar</td>
                    <td>Excluir</td>
                </tr>
                <%} %>
            </tbody>
        </table>
            
<%@ include file ="Rodape.jsp" %>
