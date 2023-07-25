package br.com.sistema.controller;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Begin;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.web.RequestParameter;
import org.jboss.seam.framework.EntityHome;

import br.com.sistema.model.Endereco;
import br.com.sistema.model.Pessoa;
import br.com.sistema.utils.MessageUtil;

@Name("pessoaHome")
@Scope(ScopeType.CONVERSATION)
public class PessoaHome extends EntityHome<Pessoa>
{
    /**
	 * Serialização
	 */
	private static final long serialVersionUID = 1L;
	
	@RequestParameter Integer pessoaId;
	
    @Override
    public Object getId()
    {
        if (pessoaId == null)
        {
            return super.getId();
        }
        else
        {
            return pessoaId;
        }
    }

    @Override 
    @Begin(join=true)
    public void create() {
        super.create();
    }
    
    @Override
    public String persist() {
    	return super.persist();
    }
	
    public void limparCampos() {
    	this.instance.setRazaoSocial("");
		this.instance.setCnpj("");
		this.instance.setNome("");
		this.instance.setCpf("");
	}
    
    
    public void adicionarItem(EnderecoHome enderecoHome) {
		Endereco endereco = enderecoHome.getInstance();
		if(endereco.getEndereco()==null || endereco.getEndereco().equals("")){
			MessageUtil.warnMessage("Informe o logradouro!");
		}if(endereco.getNumero()==null || endereco.getNumero().equals("")){
			MessageUtil.warnMessage("Informe o número!");
		}if(endereco.getBairro()==null || endereco.getBairro().equals("")){
			MessageUtil.warnMessage("Informe o bairro!");
		}if(endereco.getCep()==null || endereco.getCep().equals("")){
			MessageUtil.warnMessage("Informe o cep!");	
		}else{			
			endereco.setPessoa(getInstance());
			this.instance.getEndereco().add(endereco);
			enderecoHome.clearInstance();
		}
	}
   
    
	public void removerItem(Endereco endereco) {
		this.instance.getEndereco().remove(endereco);
		getEntityManager().remove(endereco);
	}

	
}






