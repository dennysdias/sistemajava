package br.com.sistema.controller;


import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.log.Log;
import org.jboss.seam.security.Credentials;
import org.jboss.seam.security.Identity;

import br.com.sistema.model.Usuario;

@Name("authenticator")
public class Authenticator {
	@Logger
	private Log log;

	@In
	Identity identity;
	@In
	Credentials credentials;

	@In
	EntityManager entityManager;

	
	@Out(required = false, scope = ScopeType.SESSION)
	Usuario usuario;
	
	
    
	public boolean authenticate() {
		log.info("authenticating {0}", credentials.getUsername());
		return this.logarUsuario(credentials.getUsername(), credentials
				.getPassword());
	}

	public boolean logarUsuario(String login, String senha) {
		
		if (entityManager.isOpen()) {
            String ejbQuery = " select u from Usuario u "
					+ " where u.login = :usuariologin  " + " and u.senha = :usuariosenha  "
					+ " and u.ativo = TRUE  ";
			Query queryUsuario = entityManager.createQuery(ejbQuery);
		    
			queryUsuario.setParameter("usuariologin", login);
			queryUsuario.setParameter("usuariosenha", senha);
			
			if (queryUsuario.getResultList().size() > 0) {
				this.usuario = (Usuario) queryUsuario.getSingleResult();
				identity.addRole("admin");
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
		
	}
	
	 	

}
