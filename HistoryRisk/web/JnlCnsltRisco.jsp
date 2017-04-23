<%@page import="java.text.SimpleDateFormat"%>
<%@page import="br.cesjf.classes.Risco"%>
<%@page import="java.util.List"%>
<%@page import="br.cesjf.util.DAOFactory"%>
<%@page import="br.cesjf.dao.RiscoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    RiscoDAO rsc = DAOFactory.createRiscoDAO();
    List<Risco> riscos = rsc.listar();
    SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
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
                    <td><%=fmt.format(risco.getDtlncsRgstRisco()) %></td>
                    <td><%=fmt.format(risco.getDtAltrRgstRisco()) %></td>
                    <td><a href="JnlAltRisco.jsp?opcao=alterar&idHrskRisco=<%=risco.getIdHrskRisco() %>&idFaixaProbabilidade=<%=risco.getFaixaProbabilidade().getDsFaixaProb() %>&idCategoriaRisco=<%=risco.getCategoriaRisco().getDsCategoriaRisco() %>&idNivelImpacto=<%=risco.getNivelImpacto().getDsNivelIpcto() %>&idProjeto=<%=risco.getProjeto().getDsPrjt() %>&vlCustoEsprdRiscoNgtv=<%=risco.getVlCustoEsprdRiscoNgtv() %>&dsRisco=<%=risco.getDsRisco() %>&vlCustoEstmdRisco=<%=risco.getVlCustoEstmdRisco() %>&vlCustoEsprdRiscoPstv=<%=risco.getVlCustoEsprdRiscoPstv() %>&FormDtIncsRgstRisco=<%=fmt.format(risco.getDtlncsRgstRisco()) %>&FormDdtAltrRgstRisco=<%=fmt.format(risco.getDtAltrRgstRisco()) %>">Alterar</a></td>
                    <td><a href="RiscoController?opcao=excluir&idHrskRisco=<%=risco.getIdHrskRisco() %>">Excluir</a></td>
                </tr>
                <%} %>
            </tbody>
        </table>
            
<%@ include file ="Rodape.jsp" %>