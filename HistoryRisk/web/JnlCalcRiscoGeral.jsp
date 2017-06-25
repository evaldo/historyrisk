<%@page import="br.cesjf.classes.Projeto"%>
<%@page import="java.util.List"%>
<%@page import="br.cesjf.dao.ProjetoDAO"%>
<%@page import="br.cesjf.util.DAOFactory"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    ProjetoDAO prjt = DAOFactory.createProjetoDAO();
    List<Projeto> projetos = prjt.listar();
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>History Risk - Cálculo do Risco Geral</title>
        <link rel="shortcut icon" href="imagens/ImagemLogo.png" type="image/x-png"/>
    </head>
    <body>
        <%@ include file ="Menu.jsp" %>

        <script type="text/javascript" language = "javascript">
            function AjaxCalcRiscoGeralByProject(idProjeto) {
                $.ajax({
                    type: 'POST',
                    dataType: 'html',
                    url: "CalcRiscoGeralByProject",
                    data: {projeto: idProjeto},
                    success: function (data, textStatus, jqXHR) {
                        data;
                    },
                    error: function (jqXHR, textStatus, errorThrown) {
                    },
                    beforeSend: function (xhr) {
                    }
                })
            }
        </script>

        <h1>Calcular Risco Geral</h1>
        <form class="form-horizontal" name="form1" action="CategoriaRiscoController" method="POST">
            <input type="hidden" name="opcao" value="incluir">

            <div class="form-group">
                <label class="col-sm-2 control-label">Projeto</label>
                <div class="col-sm-3">
                    <select type="select" class="form-control" onchange="AjaxCalcRiscoGeralByProject(this.value)" name="projeto" required>
                        <option value="">Selecione...</option>
                        <% for (Projeto projeto : projetos) {%>  
                        <option value="<%=projeto.getIdHrskprjt()%>"><%=projeto.getDsPrjt()%></option>
                        <%}%>
                    </select>
                </div>
            </div>

        </form>

        <%@ include file ="Rodape.jsp" %>
    </body>
</html>
