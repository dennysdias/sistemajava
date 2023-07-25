package br.com.sistema.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.Pattern;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

	/**
	 * Serialização
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * id chave de auto incremento.
	 */
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/**
	 * Nome do Usuário.
	 */
	@Column(name = "nome")
	private String nome;

	/**
	 * Login do Usuário.
	 */
	@Column(name = "login")
	@Pattern(regex = "^\\w*$", message = "Login invalido não poderá ser utilizado caracteres especiais!!")
	private String login;

	/**
	 * Senha do Usuário.
	 */
	@Column(name = "senha")
	private String senha;
	
	/**
	 * Usuário ativo.
	 */
	@Column(name="ativo")
	private Boolean ativo;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
