<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String opcao = request.getParameter("opcao");
    String idNivelIpcto = request.getParameter("idNivelIpcto");
    String nmNivelIpcto = request.getParameter("nmNivelIpcto");
    String dsNivelIpcto = request.getParameter("dsNivelIpcto");
    String icNivelIpcto = request.getParameter("icNivelIpcto");    
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>History Risk - Alterando Nivel de Impacto</title>
    </head>
    <body>
        <%@ include file ="Menu.jsp" %>
        <h1>Alteração de Nivel de Impacto</h1>
        <form name="form1" action="NivelImpactoController" method="POST">
            <div><input type="hidden" name="opcao" value="<%=opcao%>">
            <div>ID: <input type="text" name="idNivelIpcto" value="<%=idNivelIpcto%>" size="3"/></div>
            <div>Nome Nivel Impacto: <input type="text" name="nmNivelIpcto" value="<%=nmNivelIpcto%>"/></div>
            <div>Descrição Nivel Impacto: <input type="text" name="dsNivelIpcto" value="<%=dsNivelIpcto%>"/> </div>
            <div>Incremento Nivel Impacto: <input type="text" name="icNivelIpcto" size="3" value="<%=icNivelIpcto%>"/></div>
            <div><input type="submit" value="Salvar" name="salvar" /> <input type="reset" value="Cancelar" name="cancelar" /></div>
        </form>
        <%@ include file ="Rodape.jsp" %>
        
    </body>
</html>