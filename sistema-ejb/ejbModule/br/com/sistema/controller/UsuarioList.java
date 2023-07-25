package br.com.sistema.controller;

import java.util.Arrays;
import java.util.List;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.framework.EntityQuery;

import br.com.sistema.model.Usuario;

@Name("usuarioList")
@Scope(ScopeType.CONVERSATION)
public class UsuarioList extends EntityQuery<Usuario>
{
    /**
	 * Serialização
	 */
	private static final long serialVersionUID = 1L;

	
	Usuario usuarioPesquisa = new Usuario();
	
	@In(scope=ScopeType.SESSION)
	Usuario usuario;
	
	public UsuarioList() {
		setEjbql("select usuario from Usuario usuario");
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
	}
		
		
	
	private static final String[] RESTRICTIONS = {	
		" usuario.nome like concat(#{usuarioList.usuarioPesquisa.nome},'%') "	
	};
	
	
	
	@SuppressWarnings("unchecked")
	public List<Usuario> listarUsuarios() {
		String query = "select u from Usuario u ";		    	
		       query +=" where 1=1 ";
		       if(this.usuarioPesquisa.getNome()!=null && !this.usuarioPesquisa.getNome().equals("")){
		    	   query +=" and u.nome like concat(#{usuarioList.usuarioPesquisa.nome},'%') ";
		       }
		       query +=" order by u.nome ";
		       List<Usuario> usuarios = getEntityManager().createQuery(query).getResultList();
		return usuarios;
	}
	
	
	public void pesquisar() {
		this.refresh();
		this.getResultList();		
	}
	
	
	@Override
	public List<Usuario> getResultList() {
	    return super.getResultList();
	}
	
	
	@Override
	public String getOrder() {
		String order = " nome  ";
		return order;
	}


	public Usuario getUsuarioPesquisa() {
		return usuarioPesquisa;
	}


	public void setUsuarioPesquisa(Usuario usuarioPesquisa) {
		this.usuarioPesquisa = usuarioPesquisa;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
	
}
