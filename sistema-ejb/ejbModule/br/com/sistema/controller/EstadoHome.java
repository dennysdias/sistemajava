package br.com.sistema.controller;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Begin;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.web.RequestParameter;
import org.jboss.seam.framework.EntityHome;

import br.com.sistema.model.Estado;

@Name("estadoHome")
@Scope(ScopeType.CONVERSATION)
public class EstadoHome extends EntityHome<Estado>
{
    /**
	 * Serialização
	 */
	private static final long serialVersionUID = 1L;
	@RequestParameter Integer estadoId;

    @Override
    public Object getId()
    {
        if (estadoId == null)
        {
            return super.getId();
        }
        else
        {
            return estadoId;
        }
    }

    @Override 
    @Begin(join=true)
    public void create() {
        super.create();
    }

}
