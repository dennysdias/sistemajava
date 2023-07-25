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
@Table(name="estado")
public class Estado implements Serializable
{
	/**
	 * Serialização
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Construtor da Classe.
	 * instância Cidades
	 */
	public Estado() {		
		this.cidades = new ArrayList<Cidade>();		
	}
	
	
	/**
	 * id chave de auto incremento.
	 */
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
		
	/**
	 * uf.
	 */	
	@Column(name="uf")	
	private String uf;
	
	/**
	 * Nome do estado.
	 */	
	@Column(name="estado",length=100,nullable = false)	
	private String estado;
			
	
	/**
	 * Lista de Cidades .
	 */	
	@OneToMany(mappedBy = "estado", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Cidade> cidades;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getUf() {
		return uf;
	}


	public void setUf(String uf) {
		this.uf = uf;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public List<Cidade> getCidades() {
		return cidades;
	}


	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}
		
	
}
