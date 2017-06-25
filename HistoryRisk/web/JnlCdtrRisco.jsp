<%@page import="br.cesjf.classes.SubCategoriaRisco"%>
<%@page import="br.cesjf.dao.SubCategoriaRiscoDAO"%>
<%@page import="br.cesjf.classes.Projeto"%>
<%@page import="br.cesjf.dao.ProjetoDAO"%>
<%@page import="br.cesjf.classes.NivelImpacto"%>
<%@page import="br.cesjf.dao.NivelImpactoDAO"%>
<%@page import="br.cesjf.classes.CategoriaRisco"%>
<%@page import="br.cesjf.dao.CategoriaRiscoDAO"%>
<%@page import="br.cesjf.classes.FaixaProbabilidade"%>
<%@page import="java.util.List"%>
<%@page import="br.cesjf.dao.FaixaProbabilidadeDAO"%>
<%@page import="br.cesjf.util.DAOFactory"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    FaixaProbabilidadeDAO fxpb = DAOFactory.createFaixaProbabilidadeDAO();
    List<FaixaProbabilidade> faixasProbabilidade = fxpb.listar();

    CategoriaRiscoDAO ctgr = DAOFactory.createCategoraiRiscoDAO();
    List<CategoriaRisco> categoriasRisco = ctgr.listar();

    SubCategoriaRiscoDAO subctgr = DAOFactory.createSubCategoriaRiscoDAO();
    List<SubCategoriaRisco> subCategoriasRisco = subctgr.listar();

    NivelImpactoDAO nvlipcto = DAOFactory.createNivelImpactoDAO();
    List<NivelImpacto> niveisImpacto = nvlipcto.listar();

    ProjetoDAO prjt = DAOFactory.createProjetoDAO();
    List<Projeto> projetos = prjt.listar();

%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>History Risk - Novo Risco</title>
        <link rel="shortcut icon" href="imagens/ImagemLogo.png" type="image/x-png"/>
    </head>
    <body>
        <%@ include file ="Menu.jsp" %>

        <script type="text/javascript" language = "javascript">
            function AjaxSubCategoriaRiscoByCategoriaRisco(idCategoriaRisco) {
                $.ajax({
                    type: 'POST',
                    dataType: 'html',
                    url: "SubCategoriaRiscoByCategoriaRisco",
                    data: {categoriaRisco: idCategoriaRisco},
                    success: function (data, textStatus, jqXHR) {
                        $("#subCategoriaRisco").empty();
                        $("#subCategoriaRisco").append(data);
                    },
                    error: function (jqXHR, textStatus, errorThrown) {
                    },
                    beforeSend: function (xhr) {
                    }
                })
            }

            function AjaxGetByFaixaProbabilidadeRisco(nuPerctProbRisco) {
                $.ajax({
                    type: 'POST',
                    dataType: 'html',
                    url: "GetByFaixaProbabilidadeRisco",
                    data: {faixaProbabilidade: nuPerctProbRisco},
                    success: function (data, textStatus, jqXHR) {
                        $("#faixaProbabilidade").empty();
                        $("#faixaProbabilidade").append(data);
                    },
                    error: function (jqXHR, textStatus, errorThrown) {
                    },
                    beforeSend: function (xhr) {
                    }
                })
            }
        </script>
        <h1>Cadastro de Risco</h1>
        <form  class="form-horizontal" name="form1" action="RiscoController" method="POST">
            <input type="hidden" name="opcao" value="incluir">

            <div class="form-group">
                <label class="col-sm-2 control-label">Valor do Número Percentual do Risco</label>
                <div class="col-sm-3">
                    <input type="number" class="form-control" name="nuPerctProbRisco" onblur="AjaxGetByFaixaProbabilidadeRisco(this.value)" required>
                </div>
                <label class="col-sm-2 control-label">Faixa de Probabilidade</label>
                <div class="col-sm-3">
                    <select type="select" id="faixaProbabilidade" class="form-control" name="faixaProbabilidade" required>
                        <option value="">Selecione...</option>
                        <% for (FaixaProbabilidade faixaProbabilidade : faixasProbabilidade) {%>  
                        <option value="<%=faixaProbabilidade.getIdFaixaProb()%>"><%=faixaProbabilidade.getDsFaixaProb()%></option>
                        <%}%>
                    </select>
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-2 control-label">Categoria do Risco</label>
                <div class="col-sm-3">
                    <select type="select" class="form-control" onchange="AjaxSubCategoriaRiscoByCategoriaRisco(this.value)" name="categoriaRisco" required>
                        <option value="">Selecione...</option>
                        <% for (CategoriaRisco categoriaRisco : categoriasRisco) {%>  
                        <option value="<%=categoriaRisco.getIdCategoriaRisco()%>"><%=categoriaRisco.getDsCategoriaRisco()%></option>
                        <%}%>
                    </select>
                </div>
                <label class="col-sm-2 control-label">Sub Categoria do Risco</label>
                <div class="col-sm-3">
                    <select type="select" id="subCategoriaRisco" class="form-control" name="subCategoriaRisco" required>
                        <option value="">Selecione...</option>
                        <% for (SubCategoriaRisco subCategoriaRisco : subCategoriasRisco) {%>  
                        <option value="<%=subCategoriaRisco.getIdSubCatgRisco()%>"><%=subCategoriaRisco.getDsSubCatgRisco()%></option>
                        <%}%>
                    </select>
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-2 control-label">Nivel do Impacto</label>
                <div class="col-sm-3">
                    <select type="select" class="form-control" name="nivelImpacto" required>
                        <option value="">Selecione...</option>
                        <% for (NivelImpacto nivelImpacto : niveisImpacto) {%>  
                        <option value="<%=nivelImpacto.getIdNivelIpcto()%>"><%=nivelImpacto.getNmNivelIpcto() %></option>
                        <%}%>
                    </select>
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-2 control-label">Projeto</label>
                <div class="col-sm-3">
                    <select type="select" class="form-control" name="projeto" required>
                        <option value="">Selecione...</option>
                        <% for (Projeto projeto : projetos) {%>  
                        <option value="<%=projeto.getIdHrskprjt()%>"><%=projeto.getDsPrjt()%></option>
                        <%}%>
                    </select>
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-2 control-label">Descrição do Risco</label>
                <div class="col-sm-3">
                    <input type="text" class="form-control" name="dsRisco" required>
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-2 control-label">Valor do Custo Estimado do Risco</label>
                <div class="col-sm-3">
                    <input type="text" class="form-control" name="vlCustoEstmdRisco" required>
                </div>
            </div>

            <div class="checkbox">
                <label>
                    <input type="checkbox" name="icRiscoOcrrdPrjt" value="s" checked> Risco Ocorrido
                </label>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">
                    Observação
                </label>
                <div class="col-sm-3">
                    <textarea class="form-control" rows="4" name="obRiscoOcrrdPrjt"></textarea>
                </div>

            </div>

            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-3 text-right">
                    <button type="submit" class="btn btn-default" name="salvar">Salvar</button>
                </div>
            </div>

            <%@ include file ="Rodape.jsp" %>
    </body>
</html>
