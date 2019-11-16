package Daos;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import Models.Usuario;


@Repository
@Transactional
public class UsuarioDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	public void gravar(Usuario usuario) {
		manager.persist(usuario);
		
	}
	public Usuario logar (Usuario usuario) { 
	try {
		
		return manager.createQuery("select u FROM Usuario u where email = :email and senha = :senha ", Usuario.class)
		.setParameter("email", usuario.getEmail())
		.setParameter("senha", usuario.getSenha()).getSingleResult();
	
	} catch(NoResultException e) {
		System.out.println(e);
		
	}
	return null;
	}

 
}
