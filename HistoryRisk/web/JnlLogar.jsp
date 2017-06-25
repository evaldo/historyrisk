<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel='stylesheet' type="text/css" href="css/style.css"/>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>History Risk - Tela de Login</title>
        <link rel="shortcut icon" href="imagens/ImagemLogo.png" type="image/x-png"/>
    </head>
    <body style="background-color: #EEE">

        <form class="form-horizontal" name="form1" action="AuthenticationController" method="POST">
            <input type="hidden" name="opcao" value="autenticar">

            <div class="div-login">
                <div align="center">
                    <img src="imagens/Logo.png"/>
                </div>
                <div class="input-group">
                    <span class="input-group-addon">
                        <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
                    </span>
                    <input name="usrIncs" placeholder="Login" class="form-control input-login" required="" autofocus="" type="text">
                </div>
                <div class="input-group">
                    <span class="input-group-addon">
                        <span class="glyphicon glyphicon-lock" aria-hidden="true"></span>
                    </span>
                    <input name="pswIncs" placeholder="Senha" class="form-control input-login" required="" autofocus="" type="password">
                </div>
                <div class="input-group">
                    <button class="btn btn-md btn-default btn-block" type="submit" name="login" value="Entrar">Entrar<span class="glyphicon glyphicon-send" aria-hidden="true"></span></button>
                </div>
            </div>
        </form>
    </body>
</html>
