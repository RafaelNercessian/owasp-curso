package br.com.alura.owasp.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

import br.com.alura.owasp.model.Usuario;
import br.com.alura.owasp.util.ConnectionFactory;

@Repository
public class UsuarioDaoImpl implements UsuarioDao {

	Connection connection = new ConnectionFactory().getConnection();

	@Override
	public String adiciona(Usuario usuario) {
		String query = "insert into usuarios (email,senha,role) values ('"
				+ usuario.getEmail() + "','" + usuario.getSenha() + "','" +usuario.getRole()+"');";
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate(query);
			return "usuarioAdicionado";
		} catch (SQLException e) {
			return e.toString();

		}
	}

	@Override
	public String procuraUsuario(Usuario usuario) {
		String query = "SELECT * FROM usuarios WHERE email=" + "'"
				+ usuario.getEmail() + "'" + " and senha=" + "'"
				+ usuario.getSenha() + "';";
		try {
			Statement statement = connection.createStatement();
			ResultSet results = statement.executeQuery(query);
			Usuario usuarioRetorno = new Usuario();
			while (results.next()) {
				usuarioRetorno.setEmail(results.getString("email"));
				usuarioRetorno.setSenha(results.getString("senha"));
			}
			if(usuarioRetorno.getEmail()==null && usuarioRetorno.getSenha()==null){
				return "usuarioNaoExiste";
			}else{
				return "usuarioExiste";
			}
		} catch (SQLException e) {
			return e.toString();
		}
	}
	

}
