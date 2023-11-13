<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
    <title>Produto Dados</title>
</head>
<body class="container">
    <h1>Produto Dados</h1>
    <form action="ServletProdutoFC" method="post" class="form">
        <input type="hidden" name="acao" value="${empty entidade ? 'incluir' : 'alterar'}">
        <c:if test="${entidade != null}">
            <input type="hidden" name="id" value="${entidade.iDProduto}">
        </c:if>
        <div class="mb-3">
            <label for="nome" class="form-label">Nome:</label>
            <input class="form-control" type="text" id="nome" name="nome" value="${entidade != null ? entidade.nome : ''}" required><br> 
        </div>
        <div class="mb-3">
            <label for="quantidade" class="form-label">Quantidade:</label>
            <input class="form-control"  type="number" id="quantidade" name="quantidade" value="${entidade != null ? entidade.quantidade : ''}" required><br>
        </div>
        <div class="mb-3">
            <label for="precoVenda" class="form-label">Preço de Venda:</label>
            <input class="form-control"  type="number" id="precoVenda" name="precoVenda" value="${entidade != null ? entidade.precoVenda : ''}" required><br>
        </div>
        <input class="btn btn-primary" type="submit" value="${empty entidade ? 'Incluir Produto' : 'Alterar Produto'}">
    </form>
</body>
</html>