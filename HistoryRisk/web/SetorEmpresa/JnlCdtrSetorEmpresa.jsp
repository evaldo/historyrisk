<%-- 
    Document   : JnlSetorEmpresa
    Created on : 23/03/2017, 11:26:24
    Author     : George
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Cadastro de Setores da Empresa</h1>
        <form name="form1" action="SetorEmpresaProcessa.jsp" method="POST">
            <div>ID: <input type="text" name="idSetorEmpr" value="" readonly="readonly" /></div>
            <div>Nome do Setor<font color='red'>*</font>: <input type="text" name="nmSetorEmpr" value="" /></div>
            <div><input type="submit" value="Salvar" name="salvar" /> <input type="reset" value="Cancelar" name="cancelar" /></div>
        </form>
        
    </body>
</html>
