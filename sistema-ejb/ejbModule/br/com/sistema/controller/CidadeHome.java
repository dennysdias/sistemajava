package br.com.sistema.controller;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Begin;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.web.RequestParameter;
import org.jboss.seam.framework.EntityHome;

import br.com.sistema.model.Cidade;

@Name("cidadeHome")
@Scope(ScopeType.CONVERSATION)
public class CidadeHome extends EntityHome<Cidade>
{
    /**
	 * Serialização
	 */
	private static final long serialVersionUID = 1L;
	@RequestParameter Long cidadeId;

    @Override
    public Object getId()
    {
        if (cidadeId == null)
        {
            return super.getId();
        }
        else
        {
            return cidadeId;
        }
    }

    @Override 
    @Begin(join=true)
    public void create() {
        super.create();
    }

}
