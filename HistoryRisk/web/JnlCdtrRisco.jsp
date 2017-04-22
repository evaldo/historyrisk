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
                    dateFormat: 'yy/mm/dd'

                });
            });
        </script>
        <script>
            $(function () {
                $("#dtAltrRgstRisco").datepicker({
                    showOn: "button",
                    buttonImage: "imagens/calendario.png",
                    buttonImageOnly: true,
                    dateFormat: 'yy/mm/dd'
                });
            });
        </script>

        <script language="javascript">
            function MascaraMoeda(objTextBox, SeparadorMilesimo, SeparadorDecimal, e) {
                var sep = 0;
                var key = '';
                var i = j = 0;
                var len = len2 = 0;
                var strCheck = '0123456789';
                var aux = aux2 = '';
                var whichCode = (window.Event) ? e.which : e.keyCode;
                if (whichCode == 13)
                    return true;
                key = String.fromCharCode(whichCode); // Valor para o código da Chave
                if (strCheck.indexOf(key) == -1)
                    return false; // Chave inválida
                len = objTextBox.value.length;
                for (i = 0; i < len; i++)
                    if ((objTextBox.value.charAt(i) != '0') && (objTextBox.value.charAt(i) != SeparadorDecimal))
                        break;
                aux = '';
                for (; i < len; i++)
                    if (strCheck.indexOf(objTextBox.value.charAt(i)) != -1)
                        aux += objTextBox.value.charAt(i);
                aux += key;
                len = aux.length;
                if (len == 0)
                    objTextBox.value = '';
                if (len == 1)
                    objTextBox.value = '0' + SeparadorDecimal + '0' + aux;
                if (len == 2)
                    objTextBox.value = '0' + SeparadorDecimal + aux;
                if (len > 2) {
                    aux2 = '';
                    for (j = 0, i = len - 3; i >= 0; i--) {
                        if (j == 3) {
                            aux2 += SeparadorMilesimo;
                            j = 0;
                        }
                        aux2 += aux.charAt(i);
                        j++;
                    }
                    objTextBox.value = '';
                    len2 = aux2.length;
                    for (i = len2 - 1; i >= 0; i--)
                        objTextBox.value += aux2.charAt(i);
                    objTextBox.value += SeparadorDecimal + aux.substr(len - 2, len);
                }
                return false;
            }
        </script>


    </head>
    <body>
        <%@ include file ="Menu.jsp" %>
        <h1>Cadastro de Novo Projeto</h1>
        <form name="form1" action="ProjetoController" method="POST">
            <div>ID: <input type="text" name="idHrskPrjt" value="" size="3"/></div>
            <div>Faixa de Probabilidade: <select name="faixaProbabilidade">
                    <% for (FaixaProbabilidade faixaProbabilidade : faixasProbabilidade) {%>  
                    <option valuer="<%=faixaProbabilidade.getIdFaixaProb()%>"><%=faixaProbabilidade.getDsFaixaProb()%></option>
                    <%} %>
                </select>
            </div>

            <div>Categoria do Risco: <select name="categoriaRisco">
                    <% for (CategoriaRisco categoriaRisco : categoriasRisco) {%>  
                    <option valuer="<%=categoriaRisco.getIdCategoriaRisco()%>"><%=categoriaRisco.getDsCategoriaRisco()%></option>
                    <%} %>
                </select>
            </div>

            <div>Nivel do Impacto: <select name="nivelImpacto">
                    <% for (NivelImpacto nivelImpacto : niveisImpacto) {%>  
                    <option valuer="<%=nivelImpacto.getIdNivelIpcto()%>"><%=nivelImpacto.getDsNivelIpcto()%></option>
                    <%} %>
                </select>
            </div>

            <div>Projeto: <select name="projeto">
                    <% for (Projeto projeto : projetos) {%>  
                    <option valuer="<%=projeto.getIdHrskprjt()%>"><%=projeto.getDsPrjt()%></option>
                    <%}%>
                </select>
            </div>

            <div>Valor do Custo Esperado Risco Negativo: <input type="text" name="vlCustoEsprdRiscoNgtv" value="0,00" onKeyPress="return(MascaraMoeda(this,'.',',',event))"/></div>
            <div>Descrição do Risco: <input type="text" name="dsRisco" value=""/></div>
            <div>Valor do Custo Estimado do Risco: <input type="text" name="vlCustoEstmdRisco" value="0,00" onKeyPress="return(MascaraMoeda(this,'.',',',event))"/></div>
            <div>Valor do Custo Esperado Risco Positivo: <input type="text" name="vlCustoEsprdRiscoPstv" value="0,00" onKeyPress="return(MascaraMoeda(this,'.',',',event))"/></div>
            <div>Data de Inscrição do Risco : <input type="text" id="dtIncsRgstRisco" name="dtIncsRgstRisco" value=""/></div>    
            <div>Data de Alteração do Risco : <input type="text" id="dtAltrRgstRisco" name="dtAltrRgstRisco" value=""/></div>


            <div><input type="submit" value="Salvar" name="salvar" /> <input type="reset" value="Cancelar" name="cancelar" /></div>
                <%@ include file ="Rodape.jsp" %>
    </body>
</html>
