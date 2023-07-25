package br.com.sistema.controller;

import java.util.Arrays;
import java.util.List;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.framework.EntityQuery;

import br.com.sistema.model.Cidade;
import br.com.sistema.model.Estado;

@Name("cidadeList")
@Scope(ScopeType.CONVERSATION)
public class CidadeList extends EntityQuery<Cidade> {
	/**
	 * Serialização
	 */
	private static final long serialVersionUID = 1L;
	Estado estado = new Estado();
	Cidade cidade = new Cidade();

	public CidadeList() {
		setEjbql("select cidade from Cidade cidade");
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
	}	
	
	
	private static final String[] RESTRICTIONS = { "  cidade.estado.id = #{cidadeList.estado.id} " };

	

	public void atualizarEstado(Estado estado) {
		System.out.println("Estado");
		
		this.estado = estado;
		this.pesquisar();
	}

	public void pesquisar() {
		this.refresh();
		this.getResultList();
	}

	@Override
	public List<Cidade> getResultList() {
		return super.getResultList();
	}

	public List<Cidade> listarCidades(Estado estado) {
		atualizarEstado(estado);
		return super.getResultList();
	}

	@Override
	public String getOrder() {
		String order = " cidade  ";
		return order;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

}
