<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Cadastro de Categoria de Risco</h1>
        <form name="form1" action="CategoriaRiscoProcessa.jsp" method="POST">
            <div>ID: <input type="text" name="idCatgRisco" value="" readonly="readonly" /></div>
            <div>Descrição<font color='red'>*</font>: <input type="text" name="dsCatgRisco" value="" /></div>
            <div><input type="submit" value="Salvar" name="salvar" /> <input type="reset" value="Cancelar" name="cancelar" /></div>
        </form>
    </body>
</html>
