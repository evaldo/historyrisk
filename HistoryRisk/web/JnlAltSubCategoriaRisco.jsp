<%@page import="br.cesjf.classes.SubCategoriaRisco"%>
<%@page import="br.cesjf.dao.SubCategoriaRiscoDAO"%>
<%@page import="br.cesjf.classes.CategoriaRisco"%>
<%@page import="java.util.List"%>
<%@page import="br.cesjf.dao.CategoriaRiscoDAO"%>
<%@page import="br.cesjf.util.DAOFactory"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    CategoriaRiscoDAO ctgr = DAOFactory.createCategoraiRiscoDAO();
    List<CategoriaRisco> categoriasRisco = ctgr.listar();

    String opcao = request.getParameter("opcao");
    int idSubCatgRisco = Integer.parseInt(request.getParameter("idSubCatgRisco"));

    SubCategoriaRiscoDAO subctgr = DAOFactory.createSubCategoriaRiscoDAO();
    SubCategoriaRisco subCategoriaRisco = subctgr.buscar(idSubCatgRisco);

%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>History Risk - Alterando Sub Categoria de Risco</title>
         <link rel="shortcut icon" href="imagens/ImagemLogo.png" type="image/x-png"/>
    </head>
    <body>
        <%@ include file ="Menu.jsp" %>
        <h1>Alterar Sub Categoria de Risco</h1>
        <form class="form-horizontal" name="form1" action="SubCategoriaRiscoController" method="POST">
            <input type="hidden" name="opcao" value="<%=opcao%>">
            
            <div class="form-group">
                <label class="col-sm-2 control-label">ID:</label>
                <div class="col-sm-3">
                    <input type="text" class="form-control" name="idSubCatgRisco" value="<%=subCategoriaRisco.getIdSubCatgRisco() %>" readonly>
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-2 control-label">Categoria do Risco</label>
                <div class="col-sm-3">
                    <select type="select" class="form-control" name="categoriaRisco" required>
                        <option value="">Selecione...</option>
                        <% for (CategoriaRisco categoriaRisco : categoriasRisco){
                            if (subCategoriaRisco.getIdCategoriaRisco().getIdCategoriaRisco() == categoriaRisco.getIdCategoriaRisco()){
                        %>
                        <option value="<%=categoriaRisco.getIdCategoriaRisco()%>" selected="selected"><%=categoriaRisco.getDsCategoriaRisco()%></option>
                        <%}else{%>
                        <option value="<%=categoriaRisco.getIdCategoriaRisco()%>"><%=categoriaRisco.getDsCategoriaRisco()%></option>
                        <%}}%>
                    </select>
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-2 control-label">Descrição</label>
                <div class="col-sm-3">
                    <input type="text" class="form-control" name="dsSubCatgRisco" value="<%=subCategoriaRisco.getDsSubCatgRisco() %>" required>
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
