<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>History Risk - Nova Categoria de Risco</title>
    </head>
    <body>
        <%@ include file ="Menu.jsp" %>
        <h1>Cadastro de Categoria de Risco</h1>
        <form name="form1" action="CategoriaRiscoController" method="POST">
            <div><input type="hidden" name="opcao" value="incluir">
            <div>ID: <input type="text" name="idCatgRisco" value="" size="3"/></div>
            <div>Descrição<font color='red'>*</font>: <input type="text" name="dsCatgRisco" value="" /></div>
            <div><input type="submit" value="Salvar" name="salvar" /> <input type="reset" value="Cancelar" name="cancelar" /></div>
        </form>
        <%@ include file ="Rodape.jsp" %>
    </body>
</html>