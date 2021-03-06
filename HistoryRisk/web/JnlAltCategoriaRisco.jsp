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
        <link rel="shortcut icon" href="imagens/ImagemLogo.png" type="image/x-png"/>
    </head>
    <body>
        <%@ include file ="Menu.jsp" %>
        <h1>Alterar Categoria de Risco</h1>
        <form class="form-horizontal" name="form1" action="CategoriaRiscoController" method="POST">
            <input type="hidden" name="opcao" value="<%=opcao%>">

            <div class="form-group">
                <label class="col-sm-2 control-label">ID</label>
                <div class="col-sm-3">
                    <input type="text" class="form-control" name="idCatgRisco" value="<%=idCatgRisco%>" readonly>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">Descrição</label>
                <div class="col-sm-3">
                    <input type="text" class="form-control" name="dsCatgRisco" value="<%=dsCatgRisco%>" required>
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-3 text-right">
                    <button type="submit" class="btn btn-default" name="salvar">Salvar</button>
                </div>
            </div>

        </form>
        <%@ include file ="Rodape.jsp" %>
    </body>
</html>