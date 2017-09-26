package br.com.alura.owasp.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.alura.owasp.model.Usuario;
import br.com.alura.owasp.util.ConnectionFactory;

@Repository
@Transactional
public class UsuarioDaoImpl implements UsuarioDao {

	Connection connection = new ConnectionFactory().getConnection();

	@Override
	public String adiciona(Usuario usuario) {
		Usuario chamaUsuarioNoBanco = chamaUsuarioNoBanco(usuario);
		if(chamaUsuarioNoBanco.getEmail()!=null && chamaUsuarioNoBanco.getSenha()!=null){
			return "usuarioJaExiste";
		}
		String query = "insert into usuarios (email,senha) values ('"
				+ usuario.getEmail() + "','" + usuario.getSenha() + "');";
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate(query);
			return "usuarioAdicionado";
		} catch (SQLException e) {
			return e.toString();

		}
	}

	@Override
	public Usuario retornaUsuario(Usuario usuario) {
		return chamaUsuarioNoBanco(usuario);
	}

	private Usuario chamaUsuarioNoBanco(Usuario usuario) {
		String query = "SELECT * FROM usuarios WHERE email="
				+"'"+usuario.getEmail()+"'"+" and senha="+"'"+usuario.getSenha()+"';";
		try {
			Statement statement = connection.createStatement();
			ResultSet results = statement.executeQuery(query);
			Usuario usuarioRetorno = new Usuario();
			while(results.next()){
				usuarioRetorno.setEmail(results.getString("email"));
				usuarioRetorno.setSenha(results.getString("senha"));
			}
			return usuarioRetorno;
		} catch (SQLException e) {
			return null;
		}
	}

}
