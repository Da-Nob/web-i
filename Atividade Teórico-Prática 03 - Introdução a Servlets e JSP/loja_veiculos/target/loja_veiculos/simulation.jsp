<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Simulação de Veiculos</title>
</head>
<body>
    <h1>Simulacao de Veiculos para Comprar</h1>

    <form action="cadastro_loja" method="post">

        <label for="valor"> Valor do veiculo</label> <br>
        <input type="number" name="valor" id="cxValor"> <br>

        <label for="entrada"> Valor da entrada</label> <br>
        <input type="number" name="entrada" id="cxEntrada"> <br>

        <label for="juros"> Valor do juros</label> <br>
        <input type="number" name="juros" id="cxJuros" step="0.01" min="0.0" max="10.0"> <br>

        <label for="prazo"> Valor do prazo</label> <br>
        <input type="number" name="prazo" id="cxPrazo">

        <button type="submit">Calcular</button>
    </form>
</body>
</html>