<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
        String opcao = request.getParameter("opcao");
        String idCatgRisco = request.getParameter("idCategoriaRisco");
        String dsCatgRisco = request.getParameter("dsCategoriaRisco");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>History Risk - Alterando Categoria de Risco</title>
    </head>
    <body>
        <%@ include file ="Menu.jsp" %>
        <h1>Alterar Categoria de Risco</h1>
        <form name="form1" action="CategoriaRiscoController" method="POST">
            <div><input type="hidden" name="opcao" value="<%=opcao%>">
            <div>ID: <input type="text" name="idCatgRisco" value="<%=idCatgRisco%>" size="3" readonly/></div>
            <div>Descrição<font color='red'>*</font>: <input type="text" name="dsCatgRisco" value="<%=dsCatgRisco%>" /></div>
            <div><input type="submit" value="Salvar" name="salvar" /> <input type="reset" value="Cancelar" name="cancelar" /></div>
        </form>
        <%@ include file ="Rodape.jsp" %>
    </body>
</html>