<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    String opcao = request.getParameter("opcao");
    String idSetorEmpr = request.getParameter("idSetorEmpr");
    String nmSetorEmpr = request.getParameter("nmSetorEmpr");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>History Risk - Alterar Setor Empresa</title>
        <link rel="shortcut icon" href="imagens/ImagemLogo.png" type="image/x-png"/>
    </head>
    <body>

        <%@ include file ="Menu.jsp" %>
        <h1>Alterando Setor Empresa</h1>
        <form class="form-horizontal" name="form1" action="SetorEmpresaController" method="POST">
            <input type="hidden" name="opcao" value="<%=opcao%>">
        
                <div class="form-group">
                <label class="col-sm-2 control-label">ID</label>
                <div class="col-sm-3">
                    <input type="text" class="form-control" name="idSetorEmpr" value="<%=idSetorEmpr%>" readonly>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">Nome do Setor</label>
                <div class="col-sm-3">
                    <input type="text" class="form-control" name="nmSetorEmpr" value="<%=nmSetorEmpr%>" required>
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