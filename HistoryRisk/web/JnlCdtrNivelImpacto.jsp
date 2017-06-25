<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>History Risk - Novo Nivel de Impacto</title>
        <link rel="shortcut icon" href="imagens/ImagemLogo.png" type="image/x-png"/>
    </head>
    <body>
        <%@ include file ="Menu.jsp" %>
        <h1>Cadastro de Nivel de Impacto</h1>
        <form class="form-horizontal" name="form1" action="NivelImpactoController" method="POST">
            <input type="hidden" name="opcao" value="incluir">

            <div class="form-group">
                <label class="col-sm-2 control-label">Nome Nivel Impacto</label>
                <div class="col-sm-3">
                    <input type="text" class="form-control" name="nmNivelIpcto" required>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">Descrição Nivel Impacto</label>
                <div class="col-sm-3">
                    <input type="text" class="form-control" name="dsNivelIpcto">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">Incremento Nivel Impacto</label>
                <div class="col-sm-3">
                    <input type="text" class="form-control" name="icNivelIpcto" required>
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-2 control-label">Valor Associado Nível Impacto</label>
                <div class="col-sm-3">
                    <input type="text" class="form-control" name="vlAsscNivelIpcto" required>
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
