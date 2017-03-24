<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ include file ="Menu.jsp" %>
        <h1>Cadastro de Setores da Empresa</h1>
        <form name="form1" action="SetorEmpresaController" method="POST">
            <div>ID: <input type="text" name="idSetorEmpr" value="" readonly="readonly" /></div>
            <div>Nome do Setor<font color='red'>*</font>: <input type="text" name="nmSetorEmpr" value="" /></div>
            <div><input type="submit" value="Salvar" name="salvar" /> <input type="reset" value="Cancelar" name="cancelar" /></div>
        </form>
        
<%@ include file ="Rodape.jsp" %>