package br.com.alura.owasp.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.alura.owasp.model.BlogPost;

@Repository
public class BlogDaoImpl implements BlogDao {
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public void salvaBlogPost(BlogPost post) {
		manager.persist(post);
	}

	
}
