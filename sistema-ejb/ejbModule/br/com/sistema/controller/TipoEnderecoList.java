package br.com.sistema.controller;

import java.util.Arrays;
import java.util.List;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.framework.EntityQuery;

import br.com.sistema.model.TipoEndereco;

@Name("tipoEnderecoList")
@Scope(ScopeType.CONVERSATION)
public class TipoEnderecoList extends EntityQuery<TipoEndereco>
{
    /**
	 * Serialização
	 */
	private static final long serialVersionUID = 1L;

	TipoEndereco tipoEndereco = new TipoEndereco();
	
	public TipoEnderecoList()
    {
        setEjbql("select tipoEndereco from TipoEndereco tipoEndereco");
        setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
    }
	
	 private static final String[] RESTRICTIONS = {	
			" tipoEndereco.tipoEndereco like concat(#{tipoEnderecoList.tipoEndereco.tipoEndereco},'%') "	
		};
	 
	 
		public void pesquisar() {
			this.refresh();
			this.getResultList();		
		}
		
		
		@Override
		public List<TipoEndereco> getResultList() {
		    return super.getResultList();
		}
		
		
		@Override
		public String getOrder() {
			String order = " tipoEndereco  ";
			return order;
		}


		public TipoEndereco getTipoEndereco() {
			return tipoEndereco;
		}


		public void setTipoEndereco(TipoEndereco tipoEndereco) {
			this.tipoEndereco = tipoEndereco;
		}
		
		
	
}
