<%@page import="br.cesjf.classes.FaixaProbabilidade"%>
<%@page import="br.cesjf.dao.FaixaProbabilidadeDAO"%>
<%@page import="br.cesjf.util.DAOFactory"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    String opcao = request.getParameter("opcao");
    int idFaixaProb = Integer.parseInt(request.getParameter("idFaixaProb"));
    
    FaixaProbabilidadeDAO prjt = DAOFactory.createFaixaProbabilidadeDAO();
    FaixaProbabilidade fxProbabilidade = prjt.buscar(idFaixaProb);
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>History Risk - Alterando Faixa de Probabilidade</title>
        <link rel="shortcut icon" href="imagens/ImagemLogo.png" type="image/x-png"/>
    </head>
    <body>
        <%@ include file ="Menu.jsp" %>
        <h1>Alterar Faixa de Probabilidade</h1>
        <form class="form-horizontal" name="form1" action="FaixaProbabilidadeController" method="POST">
            <input type="hidden" name="opcao" value="<%=opcao%>">

            <div class="form-group">
                <label class="col-sm-2 control-label">ID</label>
                <div class="col-sm-3">
                    <input type="text" class="form-control" name="idFaixaProb" value="<%=idFaixaProb%>" readonly>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">Descrição</label>
                <div class="col-sm-3">
                    <input type="text" class="form-control" name="dsFaixaProb" value="<%=fxProbabilidade.getDsFaixaProb() %>" required>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">Número Limite Inferior</label>
                <div class="col-sm-3">
                    <input type="number" class="form-control" name="nuLmteInfr" value="<%=fxProbabilidade.getNuLmteInfr() %>" required>
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-2 control-label">Número Limite Superior</label>
                <div class="col-sm-3">
                    <input type="number" class="form-control" name="nuLmteSupr" value="<%=fxProbabilidade.getNuLmteSupr() %>" required>
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