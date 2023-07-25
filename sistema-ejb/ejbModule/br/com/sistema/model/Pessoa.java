package br.com.sistema.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pessoa")
public class Pessoa implements Serializable {

	/**
	 * Serialização
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Construtor da Classe. 
	 */
	public Pessoa() {
		this.tipoPessoa = "pf";
		this.endereco = new ArrayList<Endereco>();
	}
	
	/**
	 * id chave de auto incremento.
	 */
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/**
	 * Tipo de pessoa.
	 */
	@Column(name="tipo_pessoa")
	private String tipoPessoa;

	
	/**
	 * Nome do Pessoa.
	 */
	@Column(name = "nome")
	private String nome;

	/**
	 * Cpf.
	 */
	@Column(name = "cpf")
	private String cpf;

	/**
	 * Razão social.
	 */
	@Column(name = "razaosocial")
	private String razaoSocial;

	/**
	 * Cnpj.
	 */
	@Column(name = "cnpj")
	private String cnpj;
	
	/**
	 * Telefone.
	 */
	@Column(name = "telefone")
	private String telefone;
	
	/**
	 * Email.
	 */
	@Column(name = "email")
	private String email;
	
	/**
	 * Lista de endereços.
	 */
	@OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Endereco> endereco;
	
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Endereco> getEndereco() {
		return endereco;
	}

	public void setEndereco(List<Endereco> endereco) {
		this.endereco = endereco;
	}

	public String getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(String tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

}
