<%@page import="br.cesjf.classes.Risco"%>
<%@page import="java.util.List"%>
<%@page import="br.cesjf.util.DAOFactory"%>
<%@page import="br.cesjf.dao.RiscoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    RiscoDAO rsc = DAOFactory.createRiscoDAO();
    List<Risco> riscos = rsc.listar();
%>

<%@ include file ="Menu.jsp" %>
        <h1>Consulta Risco</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Faixa de Probabilidade</th>
                    <th>Categoria Risco</th>
                    <th>Nivel Impacto</th>
                    <th>Projeto</th>
                    <th>Valor Custo Esperado Risco Negativo</th>
                    <th>Descrição do Risco</th>
                    <th>Valor do Custo Estimado Risco</th>
                    <th>Valor do Custo Esperado Risco Positivo</th>
                    <th>Data Inicio Registro do Risco</th>
                    <th>Data Alteração Registro do Risco</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
  
            <tbody>
                <% for (Risco risco : riscos){ %>              
                <tr>
                    <td><%=risco.getIdHrskRisco() %></td>
                    <td><%=risco.getFaixaProbabilidade().getDsFaixaProb() %></td>
                    <td><%=risco.getCategoriaRisco().getDsCategoriaRisco() %></td>
                    <td><%=risco.getNivelImpacto().getDsNivelIpcto() %></td>
                    <td><%=risco.getProjeto().getDsPrjt() %></td>
                    <td><%=risco.getVlCustoEsprdRiscoNgtv() %></td>
                    <td><%=risco.getDsRisco() %></td>
                    <td><%=risco.getVlCustoEstmdRisco() %></td>
                    <td><%=risco.getVlCustoEsprdRiscoPstv() %></td>
                    <td><%=risco.getDtlncsRgstRisco() %></td>
                    <td><%=risco.getDtAltrRgstRisco() %></td>
                    <td>Alterar</td>
                    <td>Excluir</td>
                </tr>
                <%} %>
            </tbody>
        </table>
            
<%@ include file ="Rodape.jsp" %>