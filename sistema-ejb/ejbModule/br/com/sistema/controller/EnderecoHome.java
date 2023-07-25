package br.com.sistema.controller;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Begin;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.web.RequestParameter;
import org.jboss.seam.framework.EntityHome;

import br.com.sistema.model.Endereco;

@Name("enderecoHome")
@Scope(ScopeType.CONVERSATION)
public class EnderecoHome extends EntityHome<Endereco>
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@RequestParameter Long enderecoId;

    @Override
    public Object getId()
    {
        if (enderecoId == null)
        {
            return super.getId();
        }
        else
        {
            return enderecoId;
        }
    }

    @Override 
    @Begin(join=true)
    public void create() {
        super.create();
    }

}
