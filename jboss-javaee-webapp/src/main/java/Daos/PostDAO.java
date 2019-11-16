package Daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import Models.Post;


@Repository
@Transactional
public class PostDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	public void gravar(Post post) {
		manager.persist(post);
		
	}

}
