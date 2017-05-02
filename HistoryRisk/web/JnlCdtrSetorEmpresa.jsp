<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>History Risk - Novo Setor Empresa</title>
    </head>
    <body>

        <%@ include file ="Menu.jsp" %>
        <h1>Cadastro de Setores da Empresa</h1>
        <form name="form1" action="SetorEmpresaController" method="POST">
            <div><input type="hidden" name="opcao" value="incluir">
            <div>ID: <input type="text" name="idSetorEmpr" value="" size="3"/></div>
            <div>Nome do Setor<font color='red'>*</font>: <input type="text" name="nmSetorEmpr" value="" size="50" /></div>
            <div><input type="submit" value="Salvar" name="salvar" /> <input type="reset" value="Cancelar" name="cancelar" /></div>
        </form>
        
<%@ include file ="Rodape.jsp" %>