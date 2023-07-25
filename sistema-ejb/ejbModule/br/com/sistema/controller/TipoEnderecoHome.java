package br.com.sistema.controller;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Begin;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.web.RequestParameter;
import org.jboss.seam.framework.EntityHome;

import br.com.sistema.model.TipoEndereco;

@Name("tipoEnderecoHome")
@Scope(ScopeType.CONVERSATION)
public class TipoEnderecoHome extends EntityHome<TipoEndereco>
{
    /**
	 * Serialização
	 */
	private static final long serialVersionUID = 1L;
	@RequestParameter Long tipoEnderecoId;

    @Override
    public Object getId()
    {
        if (tipoEnderecoId == null)
        {
            return super.getId();
        }
        else
        {
            return tipoEnderecoId;
        }
    }

    @Override 
    @Begin(join=true)
    public void create() {
        super.create();
    }

}
