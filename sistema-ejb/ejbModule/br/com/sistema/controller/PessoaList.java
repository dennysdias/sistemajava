package br.com.sistema.controller;

import java.util.Arrays;
import java.util.List;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.framework.EntityQuery;

import br.com.sistema.model.Pessoa;
import br.com.sistema.model.Usuario;

@Name("pessoaList")
@Scope(ScopeType.CONVERSATION)
public class PessoaList extends EntityQuery<Pessoa>
{
    /**
	 * Serialização
	 */
	private static final long serialVersionUID = 1L;

	
	Pessoa pessoaPesquisa = new Pessoa();
	
	
	public PessoaList() {
		setEjbql("select p from Pessoa p");
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
	}
		
		
	
	private static final String[] RESTRICTIONS = {	
		" p.nome like concat(#{pessoaList.pessoaPesquisa.nome},'%') "	
	};
	
	
	
	@SuppressWarnings("unchecked")
	public List<Pessoa> listarPessoas() {
		String query = "select p from Pessoa p ";		    	
		       query +=" where 1=1 ";
		       if(this.pessoaPesquisa.getNome()!=null && !this.pessoaPesquisa.getNome().equals("")){
		    	   query +=" and p.nome like concat(#{pessoaList.pessoaPesquisa.nome},'%') ";
		       }
		       query +=" order by p.nome ";
		       List<Pessoa> pessoas = getEntityManager().createQuery(query).getResultList();
		return pessoas;
	}
	
	
	public void pesquisar() {
		this.refresh();
		this.getResultList();		
	}
	
	
	@Override
	public List<Pessoa> getResultList() {
	    return super.getResultList();
	}
	
	
	@Override
	public String getOrder() {
		String order = " nome  ";
		return order;
	}


	public Pessoa getPessoaPesquisa() {
		return pessoaPesquisa;
	}


	public void setPessoaPesquisa(Pessoa pessoaPesquisa) {
		this.pessoaPesquisa = pessoaPesquisa;
	}

	
	
}
