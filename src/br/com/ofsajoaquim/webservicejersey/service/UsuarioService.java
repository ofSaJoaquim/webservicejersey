package br.com.ofsajoaquim.webservicejersey.service;

import javax.persistence.NoResultException;

import br.com.ofsajoaquim.webservicejersey.dao.UsuarioDAO;
import br.com.ofsajoaquim.webservicejersey.domain.Usuario;

public class UsuarioService {
	private final UsuarioDAO usuarioDAO = new UsuarioDAO();

	public boolean validarUsuario(Usuario usuario) {
	   try {
	      usuarioDAO.obterUsuario(usuario);
	   } catch (NoResultException ex) {
	      return false;
	   }
	   return true;
	}
}
