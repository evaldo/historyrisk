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

    NivelImpactoDAO nvlipcto = DAOFactory.createNivelImpactoDAO();
    List<NivelImpacto> niveisImpacto = nvlipcto.listar();

    ProjetoDAO prjt = DAOFactory.createProjetoDAO();
    List<Projeto> projetos = prjt.listar();

%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>History Risk - Novo Risco</title>
        <link rel="stylesheet" href="http://code.jquery.com/ui/1.9.0/themes/base/jquery-ui.css" />
        <script src="http://code.jquery.com/jquery-1.8.2.js"></script>
        <script src="http://code.jquery.com/ui/1.9.0/jquery-ui.js"></script>
        <script>
            $(function () {
                $("#dtIncsRgstRisco").datepicker({
                    showOn: "button",
                    buttonImage: "imagens/calendario.png",
                    buttonImageOnly: true,
                    dateFormat: 'dd/mm/yy'

                });
            });
        </script>
        <script>
            $(function () {
                $("#dtAltrRgstRisco").datepicker({
                    showOn: "button",
                    buttonImage: "imagens/calendario.png",
                    buttonImageOnly: true,
                    dateFormat: 'dd/mm/yy'
                });
            });
        </script>

    </head>
    <body>
        <%@ include file ="Menu.jsp" %>
        <h1>Cadastro de Risco</h1>
        <form name="form1" action="RiscoController" method="POST">
            <div><input type="hidden" name="opcao" value="incluir">
            <div>ID: <input type="text" name="idHrskRisco" value="" size="3"/></div>
            <div>Faixa de Probabilidade: <select name="faixaProbabilidade">
                    <% for (FaixaProbabilidade faixaProbabilidade : faixasProbabilidade) {%>  
                    <option value="<%=faixaProbabilidade.getIdFaixaProb()%>"><%=faixaProbabilidade.getDsFaixaProb()%></option>
                    <%} %>
                </select>
            </div>

            <div>Categoria do Risco: <select name="categoriaRisco">
                    <% for (CategoriaRisco categoriaRisco : categoriasRisco) {%>  
                    <option value="<%=categoriaRisco.getIdCategoriaRisco()%>"><%=categoriaRisco.getDsCategoriaRisco()%></option>
                    <%} %>
                </select>
            </div>

            <div>Nivel do Impacto: <select name="nivelImpacto">
                    <% for (NivelImpacto nivelImpacto : niveisImpacto) {%>  
                    <option value="<%=nivelImpacto.getIdNivelIpcto()%>"><%=nivelImpacto.getDsNivelIpcto()%></option>
                    <%} %>
                </select>
            </div>

            <div>Projeto: <select name="projeto">
                    <% for (Projeto projeto : projetos) {%>  
                    <option value="<%=projeto.getIdHrskprjt()%>"><%=projeto.getDsPrjt()%></option>
                    <%}%>
                </select>
            </div>

            <div>Valor do Custo Esperado Risco Negativo: <input type="text" name="vlCustoEsprdRiscoNgtv" value="0,00"/></div>
            <div>Descrição do Risco: <input type="text" name="dsRisco" value=""/></div>
            <div>Valor do Custo Estimado do Risco: <input type="text" name="vlCustoEstmdRisco" value="0,00"/></div>
            <div>Valor do Custo Esperado Risco Positivo: <input type="text" name="vlCustoEsprdRiscoPstv" value="0,00"/></div>
            <div>Data de Inscrição do Risco : <input type="text" id="dtIncsRgstRisco" name="dtIncsRgstRisco" value=""/></div>    
            <div>Data de Alteração do Risco : <input type="text" id="dtAltrRgstRisco" name="dtAltrRgstRisco" value=""/></div>


            <div><input type="submit" value="Salvar" name="salvar" /> <input type="reset" value="Cancelar" name="cancelar" /></div>
            <%@ include file ="Rodape.jsp" %>
    </body>
</html>
