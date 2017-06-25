<%@page import="br.cesjf.classes.SetorEmpresa"%>
<%@page import="br.cesjf.dao.SetorEmpresaDAO"%>
<%@page import="java.util.List"%>
<%@page import="br.cesjf.dao.ProjetoDAO"%>
<%@page import="br.cesjf.util.DAOFactory"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    SetorEmpresaDAO stre = DAOFactory.createSetorEmpresaDAO();
    List<SetorEmpresa> setoresEmpresa = stre.listar();
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>History Risk - Novo Projeto</title>
        <link rel="shortcut icon" href="imagens/ImagemLogo.png" type="image/x-png"/>
    </head>
    <body>
        <%@ include file ="Menu.jsp" %>
        <h1>Cadastro de Novo Projeto</h1>
        <form class="form-horizontal" name="form1" action="ProjetoController" method="POST">
            <input type="hidden" name="opcao" value="incluir">

            <div class="form-group">
                <label class="col-sm-2 control-label">Setor Empresa</label>
                <div class="col-sm-3">
                    <select type="select" class="form-control" name="setorEmpresa" required>
                        <option value="">Selecione...</option>
                        <% for (SetorEmpresa setorEmpresa : setoresEmpresa) {%>  
                        <option value="<%=setorEmpresa.getIdSetorEmpr()%>"><%=setorEmpresa.getNmSetorEmpr()%></option>
                        <%}%>
                    </select>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">Descrição do Projeto</label>
                <div class="col-sm-3">
                    <input type="text" class="form-control" name="dsPrjt" required>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">Data do Projeto</label>
                <div class="col-sm-3">
                    <input type="date" class="form-control" name="dtRgstPrjt" required>
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
