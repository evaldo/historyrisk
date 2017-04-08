<%@page import="br.cesjf.classes.Projeto"%>
<%@page import="java.util.List"%>
<%@page import="br.cesjf.dao.ProjetoDAO"%>
<%@page import="br.cesjf.util.DAOFactory"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    ProjetoDAO prjt = DAOFactory.createProjetoDAO();
    List<Projeto> projetos = prjt.listar();
%>
<%@ include file ="Menu.jsp" %>
        <h1>Consulta Projeto</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Setor da Empresa</th>
                    <th>Descrição do Projeto</th>
                    <th>Data</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
  
            <tbody>
                <% for (Projeto projeto : projetos){ %>              
                <tr>
                    <td><%=projeto.getIdHrskprjt()%></td>
                    <td><%=projeto.getSetorEmpresa().getNmSetorEmpr() %></td>
                    <td><%=projeto.getDsPrjt()%></td>
                    <td><%=projeto.getDtRgstPrjt() %></td>
                    <td>Alterar</td>
                    <td>Excluir</td>
                </tr>
                <%} %>
            </tbody>
        </table>
            
<%@ include file ="Rodape.jsp" %>