<%@page import="br.cesjf.classes.Projeto"%>
<%@page import="java.text.SimpleDateFormat"%>
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
    String opcao = request.getParameter("opcao");
    int idHrskPrjt = Integer.parseInt(request.getParameter("idHrskPrjt"));
    
    ProjetoDAO prjt = DAOFactory.createProjetoDAO();
    Projeto projeto = prjt.buscar(idHrskPrjt);
    SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>History Risk - Alterando Projeto</title>
        <link rel="shortcut icon" href="imagens/ImagemLogo.png" type="image/x-png"/>
    </head>
    <body>
        <%@ include file ="Menu.jsp" %>
        <h1>Alteração de Projeto</h1>
        <form class="form-horizontal" name="form1" action="ProjetoController" method="POST">
            <input type="hidden" name="opcao" value="<%=opcao%>">

            <div class="form-group">
                <label class="col-sm-2 control-label">ID</label>
                <div class="col-sm-3">
                    <input type="text" class="form-control" name="idHrskPrjt" value="<%=projeto.getIdHrskprjt()%>" readonly>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">Setor Empresa</label>
                <div class="col-sm-3">
                    <select type="select" class="form-control" name="setorEmpresa" required>
                        <option value="">Selecione...</option>
                        <% for (SetorEmpresa setorEmpresa : setoresEmpresa) {
                            if(projeto.getSetorEmpresa().getIdSetorEmpr() == setorEmpresa.getIdSetorEmpr()){
                        %>  
                        <option value="<%=setorEmpresa.getIdSetorEmpr()%>" selected="selected"><%=setorEmpresa.getNmSetorEmpr()%></option>
                        <%} else{%>
                        <option value="<%=setorEmpresa.getIdSetorEmpr()%>"><%=setorEmpresa.getNmSetorEmpr()%></option>
                        <%}} %>
                    </select>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">Descrição do Projeto</label>
                <div class="col-sm-3">
                    <input type="text" class="form-control" name="dsPrjt" value="<%=projeto.getDsPrjt()%>" required>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">Data do Projeto</label>
                <div class="col-sm-3">
                    <input type="date" class="form-control" name="dtRgstPrjt" value="<%=fmt.format(projeto.getDtRgstPrjt())%>" required>
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