<%@include file="/WEB-INF/paginas/cabecalho.jsp"%>
<div class="container formulario-cadastro-usuario">


	<form:form action="${s:mvcUrl('BC#enviaMensagem').build()}"
		commandName="blog" method="post">
		<div class="form-group">
			<label for="titulo">T�tulo:</label> <input type="text"
				class="form-control" id="titulo" name="titulo" placeholder="T�tulo">
		</div>
		<div class="form-group">
			<label for="textarea">Mensagem:</label>
			<textarea class="form-control" id="textarea" name="mensagem"
				placeholder="Mensagem para o blog" rows="8"></textarea>
		</div>

		<button type="submit" class="btn btn-success">Enviar</button>
	</form:form>

	<c:if test="${not empty lista}">
		<table class="table">
			<thead>
				<tr>
					<th>T�tulo</th>
					<th>Mensagem</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="blog" items="${lista}">
					<tr>
						<td>${blog.titulo}</td>
						<td>${blog.mensagem}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
</div>

<%@include file="/WEB-INF/paginas/rodape.jsp"%>
