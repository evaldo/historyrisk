<%-- 
    Document   : JnlCdtrFaixaProbabilidade
    Created on : 23/03/2017, 11:37:42
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
        <h1>Cadastro de Faixa de Probabilidade</h1>
        <form name="form1" action="FaixaProbabilidadeProcessa.jsp" method="POST">
            <div>ID: <input type="text" name="idFaixaProb" value="" readonly="readonly" /></div>
            <div>Descrição: <input type="text" name="dsFaixaProb"/></div>
            <div>Número Limite Inferior: <input type="text" name="nuLmteInfr" value="0" /> </div>
            <div>Número Limite Superior: <input type="text" name="nuLmteSupr" value="0" /></div>
            <div><input type="submit" value="Salvar" name="salvar" /> <input type="reset" value="Cancelar" name="cancelar" /></div>
        </form>
        
    </body>
</html>
