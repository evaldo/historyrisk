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
        <title>History Risk - Cálculo do valor monetário Esperado</title>
        <link rel="shortcut icon" href="imagens/ImagemLogo.png" type="image/x-png"/>
    </head>
    <body>
        <%@ include file ="Menu.jsp" %>

        <script type="text/javascript" language = "javascript">
            function AjaxTeste(idProjeto) {
                $.ajax({
                    type: 'POST',
                    dataType: 'html',
                    url: "RiscoByProjectFailure",
                    data: {projeto: idProjeto},
                    success: function (data, textStatus, jqXHR) {
                        $("#tbodyListaRiscosFalha").empty();
                        $("#tbodyListaRiscosFalha").append(data);
                    },
                    error: function (jqXHR, textStatus, errorThrown) {
                    },
                    beforeSend: function (xhr) {
                    }
                })

                $.ajax({
                    type: 'POST',
                    dataType: 'html',
                    url: "RiscoByProjectSucess",
                    data: {projeto: idProjeto},
                    success: function (data, textStatus, jqXHR) {
                        $("#tbodyListaRiscosSucesso").empty();
                        $("#tbodyListaRiscosSucesso").append(data);
                    },
                    error: function (jqXHR, textStatus, errorThrown) {
                    },
                    beforeSend: function (xhr) {
                    }
                })
            }
        </script>

        <h1>Calcular do Valor Monetário Esperado</h1>
        <form class="form-horizontal" name="form1" action="CategoriaRiscoController" method="POST">
            <input type="hidden" name="opcao" value="incluir">

            <div class="form-group">
                <label class="col-sm-2 control-label">Projeto</label>
                <div class="col-sm-3">
                    <select type="select" class="form-control" onchange="AjaxTeste(this.value)" name="projeto" id="testeId" required>
                        <option value="">Selecione...</option>
                        <% for (Projeto projeto : projetos) {%>  
                        <option value="<%=projeto.getIdHrskprjt()%>"><%=projeto.getDsPrjt()%></option>
                        <%}%>
                    </select>
                </div>
            </div>

            <div class="bs-example bs-example-tabs col-md-offset-1" style="max-width:90%;" role="tablist" data-example-id="togglable-tabs">
                <ul id="myTab" class="nav nav-tabs" role="tablist">
                    <li role="presentation" class="active" id="tabDetalhesDescricao">
                        <a href="#descricao" id="descricao-tab" role="tab" data-toggle="tab" aria-controls="home" aria-expanded="true">Valor Monetário Esperado em Caso de Falha</a>
                    </li>
                    <li role="presentation" class="">
                        <a href="#erro" role="tab" id="erro-tab" data-toggle="tab" aria-controls="profile" aria-expanded="false"> Valor Monetário Esperado em Caso de Sucesso</a>
                    </li>
                </ul>
                <div id="myTabContent" class="tab-content">
                    <div role="tabpanel" class="tab-pane fade active in" id="descricao" aria-labelledby="descricao-tab">
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>Risco</th>
                                    <th>Probabilidade</th>
                                    <th>Descrição do Impacto Caso de falha</th>
                                    <th>Valor em caso de falha</th>
                                    <th>Valor Monetário Esperado</th>
                                </tr>
                            </thead>

                            <tbody id="tbodyListaRiscosFalha">
                                <tr>
                                    <td></td>
                                    <td></td>
                                    <td>
                                        <div>
                                            <input type="text" class="form-control" name="descImpactoCasoFalha">
                                        </div>
                                    </td>
                                    <td>
                                        <div>
                                            <input type="text" class="form-control" name="vlCustoEsprdRiscoNgtv">
                                        </div>
                                    </td>
                                    <td>
                                        <div>
                                            <input type="text" class="form-control" name="vlrMonetarioEsperado" readonly>
                                        </div>
                                    </td>
                                </tr>
                            <td colspan="4">
                                <b>Valor Total:</b>
                            </td>
                            <td>
                                <input type="text" class="form-control" name="vlrTotalMonetarioEsperadoFalha" id="vlrTotalMonetarioEsperadoFalha" onload="somaValores()"/>
                            </td>
                            </tbody>
                        </table>
                    </div>
                    <div role="tabpanel" class="tab-pane fade" id="erro" aria-labelledby="erro-tab">
                        <div class="form-group">
                            <table class="table table-hover">
                                <thead>
                                    <tr>
                                        <th>Risco</th>
                                        <th>Probabilidade</th>
                                        <th>Descrição do Impacto Caso de Sucesso</th>
                                        <th>Valor em caso de Sucesso</th>
                                        <th>Valor Monetário Esperado</th>
                                    </tr>
                                </thead>

                                <tbody id="tbodyListaRiscosSucesso">
                                    <tr>
                                        <td></td>
                                        <td>
                                            <div>
                                                <input type="text" class="form-control" name="descImpactoCasoSucesso">
                                            </div>
                                        </td>
                                        <td>
                                            <div>
                                                <input type="text" class="form-control" name="vlCustoEsprdRiscoPstv">
                                            </div>
                                        </td>
                                        <td>
                                            <div>
                                                <input type="text" class="form-control" name="vlrMonetarioEsperado">
                                            </div>
                                        </td>
                                    </tr>
                                <td colspan="4">
                                    <b>Valor Total:</b>
                                </td>
                                <td>
                                    <input type="text" class="form-control" name="vlrTotalMonetarioEsperadoFalha" id="vlrTotalMonetarioEsperadoFalha" onfocus="somaValores()"/>
                                </td>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>

            <script type="text/javascript">
                function somaValores() {
                    var vlrTotalMonetarioEsperadoFalha = parseFloat(document.getElementById('vlrTotalMonetarioEsperadoFalha').value, 10);
                    var vlrTotalMonetarioEsperadoSucess = parseFloat(document.getElementById('vlrTotalMonetarioEsperadoSucess').value, 10);
                    document.getElementById('resultado').innerHTML = vlrTotalMonetarioEsperadoFalha + vlrTotalMonetarioEsperadoSucess;
                }

                function multiplicarValores(campo1, campo2, resultado) {
                    var nuPerctProbRisco1 = parseFloat(document.getElementById(campo1).value, 10);
                    var vlCustoEsprdRiscoNgtv1 = parseFloat(document.getElementById(campo2).value, 10);
                    document.getElementById(resultado).innerHTML = nuPerctProbRisco1 * vlCustoEsprdRiscoNgtv1;

                }
            </script>
            <div class="form-group">
                <label class="col-sm-2 control-label">VME Geral do Projeto: R$</label>
                <div class="col-sm-3">
                    <input type="text" class="form-control" name="total" id="resultado" readonly>
                </div>
            </div>
        </form>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-3 text-right">
                <button type="submit" class="btn btn-default" name="salvar">Salvar</button>
            </div>
        </div>

        <%@ include file ="Rodape.jsp" %>
    </body>
</html>
