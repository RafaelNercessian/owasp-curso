package br.com.alura.owasp.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.alura.owasp.model.Usuario;

@Repository
@Transactional
public class UsuarioDaoImpl implements UsuarioDao{
	
	@PersistenceContext
	private EntityManager manager;
			
	@Override
	public void adiciona(Usuario usuario) {
		this.manager.persist(usuario);
	}

}
