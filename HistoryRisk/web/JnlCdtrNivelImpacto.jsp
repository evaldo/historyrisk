<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>History Risk - Novo Nivel de Impacto</title>
    </head>
    <body>
        <%@ include file ="Menu.jsp" %>
        <h1>Cadastro de Nivel de Impacto</h1>
        <form name="form1" action="NivelImpactoController" method="POST">
            <div>ID: <input type="text" name="idNivelIpcto" value=""/></div>
            <div>Nome Nivel Impacto: <input type="text" name="nmNivelIpcto"/></div>
            <div>Descrição Nivel Impacto: <input type="text" name="dsNivelIpcto"/> </div>
            <div>Incremento Nivel Impacto: <input type="text" name="icNivelIpcto"/></div>
            <div><input type="submit" value="Salvar" name="salvar" /> <input type="reset" value="Cancelar" name="cancelar" /></div>
        </form>
        <%@ include file ="Rodape.jsp" %>
        
    </body>
</html>
