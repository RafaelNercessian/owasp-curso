<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Owasp</title>
<link href="<c:url value="/resources/css/bootstrap.css" />"
	rel="stylesheet">
</head>
<body>
	<div class="container">

		<form action="cadastrar" method="post">
			<div class="form-group">
				<label for="exampleInputEmail1">Email:</label> <input
					type="email" class="form-control" id="email"
					placeholder="Email">
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">Senha:</label> <input
					type="password" class="form-control" id="senha"
					placeholder="Senha">
			</div>
			
			<button type="submit" class="btn btn-success">Cadastrar</button>
		</form>
	</div>
</body>
</html>