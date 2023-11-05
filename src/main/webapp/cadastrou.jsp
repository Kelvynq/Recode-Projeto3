<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de Usuário</title>
  <link rel="shortcut icon" href="./assets/duffle.svg" type="image/x-icon">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa"
	crossorigin="anonymous"></script>
	  <link rel="stylesheet" href="./index.css">
	
</head>

<body>

 <!--Início da navbar-->
  <header>
    <nav class="navbar navbar-expand-lg text-white " style="background:linear-gradient(90deg, #de6060 20%, #ab0f0f 100%);">
      <a class="navbar-brand text-white p-2 pt-2" href="./index.html">
       <!-- <img src="" alt="logo" width="45" height="40" class="d-inline-block align-text-top">-->
       - SuperViagem - 
      </a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
        aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
          <li class="nav-items">
            <a class="nav-link active text-white p-3" aria-current="page" href="./cadastrou.jsp">Cadastro</a>
          </li>
           <li class="nav-item ">
            <a class="nav-link text-white p-3" href="home">Usuários</a>
          </li>
          <li class="nav-item ">
            <a class="nav-link text-white p-3" href="#">Login</a>
          </li>
          <li class="nav-item">
            <a class="nav-link text-white p-3" href="#">Destino</a>
          </li>
          <li class="nav-item">
            <a class="nav-link text-white p-3" href="#">Promoções</a>
          </li>
          <li class="nav-item">
            <a class="nav-link text-white p-3" href="#">Contato</a>
          </li>
        </ul>
      </div>

    </nav>
  </header>
  <!--Fim da navbar-->

	<div class="container  pt-5">
		<h3 class="pt-5">Cadastro de usuário</h3>
		<form action="Inserir" method="post" class="form-control">
			<fieldset>
				<legend>Dados do usuário</legend>
				<p>
					<label for="nome">Nome Completo:</label> <input type="text" id="nome"
						name="nome" size="40" class="form-control" required>
				</p>
				<p>
					<label for="email">E-mail:</label> <input type="email"
						id="email" name="email" size="15" class="form-control" required>
				</p>
				<p>
					<label for="senha">Senha:</label> <input type="password"
						id="senha" name="senha" size="15" class="form-control" required>
				</p>
				<p>
					<input class="btn btn-danger" type="submit" value="Cadastrar Usuário">
				</p>
			</fieldset>
		</form>
	</div>
	
	<!--Início do footer-->
  <footer class="pt-4">
    <p class="text-center">&copy; 2023 SuperViagem. Todos os direitos reservados.</p>
  </footer>
  <!--Fim do footer-->
</body>
</html>