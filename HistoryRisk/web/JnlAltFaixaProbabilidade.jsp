<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
        String opcao = request.getParameter("opcao");
        String idFaixaProb = request.getParameter("idFaixaProb");
        String dsFaixaProb = request.getParameter("dsFaixaProb");
        String nuLmteInfr = request.getParameter("nuLmteInfr");
        String nuLmteSupr = request.getParameter("nuLmteSupr");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>History Risk - Alterando Faixa de Probabilidade</title>
    </head>
    <body>
        <%@ include file ="Menu.jsp" %>
        <h1>Alterar Faixa de Probabilidade</h1>
         <form name="form1" action="FaixaProbabilidadeController" method="POST">
             <div><input type="hidden" name="opcao" value="<%=opcao%>">
            <div>ID: <input type="text" name="idFaixaProb" value="<%=idFaixaProb%>" size="3" readonly/></div>
            <div>Descrição: <input type="text" value="<%=dsFaixaProb%>" name="dsFaixaProb"/></div>
            <div>Número Limite Inferior: <input type="text" name="nuLmteInfr" value="<%=nuLmteInfr%>" /> </div>
            <div>Número Limite Superior: <input type="text" name="nuLmteSupr" value="<%=nuLmteSupr%>" /></div>
            <div><input type="submit" value="Salvar" name="salvar" /> <input type="reset" value="Cancelar" name="cancelar" /></div>
        </form>
        <%@ include file ="Rodape.jsp" %>
    </body>
</html>