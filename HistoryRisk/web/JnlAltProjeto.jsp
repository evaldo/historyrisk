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
    String idHrskPrjt = request.getParameter("idHrskPrjt");
    String NumsetorEmpresa = request.getParameter("setorEmpresa");
    String dsPrjt = request.getParameter("dsPrjt");
    String dtRgstPrjt = request.getParameter("dtRgstPrjt");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>History Risk - Alterando Projeto</title>
                <link rel="stylesheet" href="http://code.jquery.com/ui/1.9.0/themes/base/jquery-ui.css" />
        <script src="http://code.jquery.com/jquery-1.8.2.js"></script>
        <script src="http://code.jquery.com/ui/1.9.0/jquery-ui.js"></script>
        <script>
            $(function() {
                $( "#dtIncsRgstRisco" ).datepicker({
                    showOn: "button",
                    buttonImage: "imagens/calendario.png",
                    buttonImageOnly: true,
                    dateFormat: 'dd/mm/yy'
                   
                });
            });
        </script>
        <script>
            $(function() {
                $( "#dtRgstPrjt" ).datepicker({
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
        <h1>Alteração de Projeto</h1>
        <form name="form1" action="ProjetoController" method="POST">
            <div><input type="hidden" name="opcao" value="<%=opcao%>">
            <div>ID: <input type="text" name="idHrskPrjt" value="<%=idHrskPrjt%>" size="3" readonly/></div>
            <div>Setor da Empresa: <select name="setorEmpresa">
                    <% for (SetorEmpresa setorEmpresa : setoresEmpresa){ %>  
                        <option value="<%=setorEmpresa.getIdSetorEmpr()%>"><%=setorEmpresa.getNmSetorEmpr() %></option>
                        <%} %>
                    </select>
            <div>Descrição do Projeto: <input type="text" name="dsPrjt" value="<%=dsPrjt%>"/> </div>
            <div>Data do Projeto: <input type="text" id="dtRgstPrjt" name="dtRgstPrjt" value="<%=dtRgstPrjt%>"/></div>
            <div><input type="submit" value="Salvar" name="salvar" /> <input type="reset" value="Cancelar" name="cancelar" /></div>
        </form>
        <%@ include file ="Rodape.jsp" %>
    </body>
</html>