package br.com.sistema.controller;

import java.util.Arrays;
import java.util.List;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.framework.EntityQuery;

import br.com.sistema.model.Estado;

@Name("estadoList")
@Scope(ScopeType.CONVERSATION)
public class EstadoList extends EntityQuery<Estado>
{
    /**
	 * Serialização
	 */
	private static final long serialVersionUID = 1L;
	
	Estado estado = new Estado();
	
	public EstadoList() {
		setEjbql("select e from Estado e");
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
	}
	

	private static final String[] RESTRICTIONS = { "  e.estado like concat(#{estadoList.estado.estado},'%') " };

	
	
	
	public void pesquisar() {
		this.refresh();
		this.getResultList();		
	}
	
	
	@Override
	public List<Estado> getResultList() {
	    return super.getResultList();
	}
	
	
	@Override
	public String getOrder() {
		String order = " estado  ";
		return order;
	}


	public Estado getEstado() {
		return estado;
	}


	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	
}
