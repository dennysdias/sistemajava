package br.com.sistema.controller;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Begin;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.web.RequestParameter;
import org.jboss.seam.framework.EntityHome;

import br.com.sistema.model.Usuario;

@Name("usuarioHome")
@Scope(ScopeType.CONVERSATION)
public class UsuarioHome extends EntityHome<Usuario>
{
    /**
	 * Serialização
	 */
	private static final long serialVersionUID = 1L;
	
	@RequestParameter Integer usuarioId;
	
	@In(scope=ScopeType.SESSION)
	Usuario usuario;
	
	
    @Override
    public Object getId()
    {
        if (usuarioId == null)
        {
            return super.getId();
        }
        else
        {
            return usuarioId;
        }
    }

    @Override 
    @Begin(join=true)
    public void create() {
        super.create();
    }
    
    @Override
    public String persist() {
    	return super.persist();
    }
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
}






