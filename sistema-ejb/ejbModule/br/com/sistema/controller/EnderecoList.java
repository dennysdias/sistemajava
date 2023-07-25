package br.com.sistema.controller;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.framework.EntityQuery;

import br.com.sistema.model.Endereco;

@Name("enderecoList")
@Scope(ScopeType.CONVERSATION)
public class EnderecoList extends EntityQuery<Endereco>
{
    /**
	 * Serialização
	 */
	private static final long serialVersionUID = 1L;

	public EnderecoList()
    {
        setEjbql("select endereco from Endereco endereco");
    }
}
