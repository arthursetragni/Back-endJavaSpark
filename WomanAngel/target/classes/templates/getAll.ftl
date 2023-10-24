<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Detalhes da Denúncia</title>
</head>
<body id = "destacados" onload = "carregaDados()">
    <h1>Detalhes da Denúncia</h1>
    <a href="../produto">
        <button>Ir para menu</button>
    </a>
</body>
<script>
function carregaDados(){
	var denuncias = ${denuncias};
	console.log(denuncias);
	let tela = document.getElementById('destacados');
	let strHTML = '';
	let i = 1;
	for(i; i < denuncias.length - 1; i++){
		strHTML += `<h1>Detalhes da Denúncia</h1>
    <p>ID: ${denuncias[i].id}</p>
    <p>Localização: ${denuncias[i].localizacao}</p>
    <p>Descrição: ${denuncias[i].descricao}</p>
    <p>Categoria: ${denuncias[i].categoria}</p>
    <p>Data: ${denuncias[i].data}</p>
    <p>ID do Usuário: ${denuncias[i].idUsuario}</p>`;
	}
	
	tela.innerHTML = strHTML;
}
</script>
</html>