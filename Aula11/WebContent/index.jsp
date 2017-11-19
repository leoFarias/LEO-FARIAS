<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de Conjuntos</title>
</head>
<body>
<h3>Cadastro de Conjuntos</h3>
<form action="ManterConjunto.do" method="get">

id: <input type="text" name="identificador"/><br>
cNome: <input type="text" name="nome"/><br>
cAndar: <input type="text" name="andar"/><br>
<input type="submit"  value="Inserir" name ="ação"/>
<input type="submit"  value="Apagar" name ="ação"/>
<input type="submit"  value="Alterar" name ="ação"/>
<input type="submit"  value="Consultar" name ="ação"/>
<input type= "reset" value = "Limpar"/>



</form>
</body>
</html>