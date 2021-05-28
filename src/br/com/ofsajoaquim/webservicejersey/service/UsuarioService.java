package br.com.ofsajoaquim.webservicejersey.service;

import javax.persistence.NoResultException;

import br.com.ofsajoaquim.webservicejersey.dao.UsuarioDAO;
import br.com.ofsajoaquim.webservicejersey.domain.Usuario;
import br.com.ofsajoaquim.webservicejersey.dto.LoginDTO;

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
	
	public boolean validarUsuario(LoginDTO login) {
		Usuario usuario = new Usuario();
		usuario.setUsername(login.getLogin());
		usuario.setPassword(login.getSenha());
		return this.validarUsuario(usuario);
	}
}
