package br.com.ofsajoaquim.webservicejersey.dao;

import javax.persistence.EntityManager;

import br.com.ofsajoaquim.webservicejersey.domain.Usuario;

public class UsuarioDAO {

	public Usuario obterUsuario(Usuario usuario) {
		   EntityManager em = JPAUtil.getEntityManager();

		   return em.createQuery("SELECT u FROM Usuario u WHERE u.username = :username AND u.password = :password", Usuario.class)
		            .setParameter("username", usuario.getUsername())
		            .setParameter("password", usuario.getPassword())
		            .getSingleResult();
		}
}
