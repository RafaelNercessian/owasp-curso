package br.com.alura.owasp.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.alura.owasp.controller.ConnectionFactory;
import br.com.alura.owasp.model.Usuario;

@Repository
@Transactional
public class UsuarioDaoImpl implements UsuarioDao {

	Connection connection = new ConnectionFactory().getConnection();

	@Override
	public String adiciona(Usuario usuario) {
		String query = "insert into usuarios (email,senha) values ('"
				+ usuario.getEmail() + "','" + usuario.getSenha() + "');";
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate(query);
			return "";
		} catch (SQLException e) {
			return e.toString();
			
		}
	}

}
