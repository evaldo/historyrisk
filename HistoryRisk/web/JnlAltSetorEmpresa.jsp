<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<% 
    String opcao = request.getParameter("opcao");
    String idSetorEmpr = request.getParameter("idSetorEmpr");
    String nmSetorEmpr = request.getParameter("nmSetorEmpr");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>History Risk - Alterar Setor Empresa</title>
    </head>
    <body>

        <%@ include file ="Menu.jsp" %>
        <h1>Alterando Setor Empresa</h1>
        <form name="form1" action="SetorEmpresaController" method="POST">
            <div><input type="hidden" name="opcao" value="<%=opcao %>">
            <div>ID: <input type="text" name="idSetorEmpr" value="<%=idSetorEmpr %>" size="3" readonly/></div>
            <div>Nome do Setor<font color='red'>*</font>: <input type="text" name="nmSetorEmpr" value="<%=nmSetorEmpr %>" size="50" /></div>
            <div><input type="submit" value="Salvar" name="salvar" /> <input type="reset" value="Cancelar" name="cancelar" /></div>
        </form>
        
<%@ include file ="Rodape.jsp" %>