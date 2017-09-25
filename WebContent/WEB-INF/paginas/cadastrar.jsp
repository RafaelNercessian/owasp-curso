<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
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

		<form:form action="${s:mvcUrl('LC#adicionaUsuario').build()}" method="POST" commandName="usuario" >
			<div class="form-group">
				<label for="exampleInputEmail1">Email:</label> <input
					type="email" class="form-control" id="email" name="email"
					placeholder="Email">
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">Senha:</label> <input
					type="password" class="form-control" id="senha" name="senha"
					placeholder="Senha">
			</div>
			
			<button type="submit" class="btn btn-success">Cadastrar</button>
		</form:form>
	</div>
</body>
</html>