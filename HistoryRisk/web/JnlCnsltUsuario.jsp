<%@page import="java.text.SimpleDateFormat"%>
<%@page import="br.cesjf.classes.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="br.cesjf.dao.UsuarioDAO"%>
<%@page import="br.cesjf.util.DAOFactory"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    UsuarioDAO usr = DAOFactory.createUsuarioDAO();
    List<Usuario> usuarios = usr.listar();
    SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>History Risk - Consulta de Usuário</title>
        <link rel="shortcut icon" href="imagens/ImagemLogo.png" type="image/x-png"/>
    </head>
    <body>
        <%@ include file ="Menu.jsp" %>
        <h1>Consulta de Usuário</h1>
        <table  class="table table-hover">
            <thead>
                <tr>
                    <th></th>
                    <th>Nome</th>
                    <th>E-mail</th>
                    <th>Nome de Usuario</th>
                    <th>Senha do Usuario</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <% for (Usuario usuario : usuarios) {%>              
                <tr>
                    <td align="center"><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span></td>
                    <td><%=usuario.getNmIncs()%></td>
                    <td><%=usuario.getEmailIncs()%></td>
                    <td><%=usuario.getUsrIncs()%></td>
                    <td><%=usuario.getPswIncs()%></td>                    
                    <td align="right"><a href="JnlAltUsuario.jsp?opcao=alterar&nuMatrIncs=<%=usuario.getNuMatrIncs()%>&nmIncs=<%=usuario.getNmIncs()%>&emailIncs=<%=usuario.getEmailIncs()%>&usrIncs=<%=usuario.getUsrIncs()%>&pswIncs=<%=usuario.getPswIncs()%>"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a></td>
                    <td align="right"><a href="javascript:func()" onclick="confirmacao()"><span class="glyphicon glyphicon-lock" aria-hidden="true"></span></a></td>
                    <script language="Javascript">
                        function confirmacao() {
                            var resposta = alert("Não é possível excluir este registro.");
                        }
                    </script>
                </tr>
                <%}%>
            </tbody>


        </table>
        <%@ include file ="Rodape.jsp" %>
    </body>
</html>
