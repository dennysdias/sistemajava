package br.com.sistema.controller;

import javax.persistence.EntityManager;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.faces.FacesMessages;

import br.com.sistema.model.Usuario;

@Name("alterarSenhaHome")
@Scope(ScopeType.CONVERSATION)
public class AlterarSenhaHome 
{
    
	/**
	 * Serialização
	 */
	private static final long serialVersionUID = 1L;
	
	@In
	EntityManager entityManager;
	
    String senhaAtual;
    
    
    String novaSenha;
    
    
    String novaSenhaConfirmacao;
	
	@In(scope=ScopeType.SESSION)
	Usuario usuario;
	
    
    
	 public void alterarSenhaUsuario() {
	    	try {
	    		if(this.usuario.getSenha().equals(getSenhaAtual())){ 
	    		   if(getNovaSenha().equals(getNovaSenhaConfirmacao())){
	    			   this.usuario.setSenha(getNovaSenha());
	    			   this.entityManager.merge(this.usuario);
	    				FacesMessages.instance().add("Senha do usuário alterada com sucesso!");
	    		   }else{
	    				FacesMessages.instance().add("Nova senha e senha de confirmação não conferem!");
	    		   }	    		
	    		}else{
	    		   FacesMessages.instance().add("Senha atual não conferem!");	
	    		}
			
			} catch (Exception e) {
				e.printStackTrace();
				FacesMessages.instance().add("Erro inesperado ao tentar alterar os dados do usuário!");
			} finally {
				setSenhaAtual(null);
				setNovaSenha(null);
				setNovaSenhaConfirmacao(null);
			}
	    }



	public String getSenhaAtual() {
		return senhaAtual;
	}



	public void setSenhaAtual(String senhaAtual) {
		this.senhaAtual = senhaAtual;
	}



	public String getNovaSenha() {
		return novaSenha;
	}



	public void setNovaSenha(String novaSenha) {
		this.novaSenha = novaSenha;
	}



	public String getNovaSenhaConfirmacao() {
		return novaSenhaConfirmacao;
	}



	public void setNovaSenhaConfirmacao(String novaSenhaConfirmacao) {
		this.novaSenhaConfirmacao = novaSenhaConfirmacao;
	}



	public Usuario getUsuario() {
		return usuario;
	}



	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
    
    
}
