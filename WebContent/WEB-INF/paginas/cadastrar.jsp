<%@include file="/WEB-INF/paginas/cabecalho.jsp"%>
<div class="container formulario-cadastro-usuario">

	<c:if test="${not empty mensagem}">
		<p>${mensagem}</p>
	</c:if>

	<form:form action="${s:mvcUrl('CUC#adicionaUsuario').build()}"
		commandName="usuario" method="post" enctype="multipart/form-data">
		<div class="form-group">
			<label for="exampleInputEmail1">Email:</label> <input type="email"
				class="form-control" id="email" name="email" placeholder="Email">
		</div>
		<div class="form-group">
			<label for="exampleInputPassword1">Senha:</label> <input
				type="password" class="form-control" id="senha" name="senha"
				placeholder="Senha">
		</div>

		<div>
			<label for="imagem">Imagem: </label> <input type="file"
				name="imagem" multiple="multiple" />
		</div>

		<button type="submit" class="btn btn-success">Cadastrar</button>
	</form:form>
</div>
<%@include file="/WEB-INF/paginas/rodape.jsp"%>