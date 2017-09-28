package br.com.alura.owasp.dao;

import br.com.alura.owasp.model.Usuario;

public interface UsuarioDao {

	public String adiciona(Usuario usuario);
	public Usuario procuraUsuario(Usuario usuario);
	public boolean verificaSeUsuarioEhAdmin(Usuario usuario);
}
