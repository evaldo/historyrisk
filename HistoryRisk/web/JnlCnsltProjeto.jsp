<%@page import="java.text.SimpleDateFormat"%>
<%@page import="br.cesjf.classes.Projeto"%>
<%@page import="br.cesjf.dao.ProjetoDAO"%>
<%@page import="java.util.List"%>
<%@page import="br.cesjf.util.DAOFactory"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    ProjetoDAO prjt = DAOFactory.createProjetoDAO();
    List<Projeto> projetos = prjt.listar();
    SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>History Risk - Consulta de Projetos</title>
    </head>
    <body>
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
                <% for (Projeto projeto : projetos) {%>              
                <tr>
                    <td><%=projeto.getIdHrskprjt()%></td>
                    <td><%=projeto.getSetorEmpresa().getNmSetorEmpr()%></td>
                    <td><%=projeto.getDsPrjt()%></td>
                    <td><%=fmt.format(projeto.getDtRgstPrjt())%></td>
                    <td><a href="JnlAltProjeto.jsp?opcao=alterar&idHrskPrjt=<%=projeto.getIdHrskprjt()%>&NumsetorEmpresa=<%=projeto.getSetorEmpresa().getNmSetorEmpr()%>&dsPrjt=<%=projeto.getDsPrjt()%>&dtRgstPrjt=<%=fmt.format(projeto.getDtRgstPrjt())%>"> Alterar</a></td>
                    <td><a href="ProjetoController?opcao=excluir&idHrskprjt=<%=projeto.getIdHrskprjt()%>">Excluir</a></td>
                </tr>
                <%}%>
            </tbody>
        </table>

        <%@ include file ="Rodape.jsp" %>