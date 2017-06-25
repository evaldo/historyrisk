<%@page import="java.text.SimpleDateFormat"%>
<%@page import="br.cesjf.classes.Projeto"%>
<%@page import="br.cesjf.dao.ProjetoDAO"%>
<%@page import="java.util.List"%>
<%@page import="br.cesjf.util.DAOFactory"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    String cmpPesquisa = request.getParameter("cmpPesquisa");
    ProjetoDAO prjt = DAOFactory.createProjetoDAO();
    List<Projeto> projetos = prjt.pesquisar(cmpPesquisa);
    SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>History Risk - Consulta de Projetos</title>
        <link rel="shortcut icon" href="imagens/ImagemLogo.png" type="image/x-png"/>
    </head>
    <body>
        <%@ include file ="Menu.jsp" %>
        <h1>Consulta Projeto</h1>
        <form class="navbar-form navbar-left" role="search" name="form1" action="ProjetoController" method="POST">
            <input type="hidden" name="opcao" value="pesquisar">
            <div class="form-group">
                <input type="text" class="form-control" placeholder="Pesquisar..." name="cmpPesquisa" value="<%=cmpPesquisa%>" size="100">
            </div>
            <button type="submit" class="btn btn-default"><span class="glyphicon glyphicon-search" aria-hidden="true"></span> Pesquisar</button>
        </form>
        <table class="table table-hover">
            <thead>
                <tr>
                    <th></th>
                    <th>Setor da Empresa</th>
                    <th>Descrição do Projeto</th>
                    <th>Data do Projeto</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>

            <tbody>
                <% for (Projeto projeto : projetos) {%>              
                <tr>
                    <td align="center"><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span></td>
                    <td><%=projeto.getSetorEmpresa().getNmSetorEmpr()%></td>
                    <td><%=projeto.getDsPrjt()%></td>
                    <td><%=fmt.format(projeto.getDtRgstPrjt())%></td>
                    <td align="right"><a href="JnlAltProjeto.jsp?opcao=alterar&idHrskPrjt=<%=projeto.getIdHrskprjt()%>"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a></td>
                    <td align="right"><a href="javascript:func()" onclick="confirmacao('1')"><span class="glyphicon glyphicon-remove-sign" aria-hidden="true"></span></a></td>
            <script language="Javascript">
                function confirmacao(id) {
                    var resposta = confirm("Deseja realmente excluir este registro?");
                    if (resposta == true) {
                        window.location.href = "ProjetoController?opcao=excluir&idHrskprjt=<%=projeto.getIdHrskprjt()%>"
                    }
                }
            </script>

        </tr>
        <%}%>
    </tbody>
</table>

<%@ include file ="Rodape.jsp" %>

</body>
</html>