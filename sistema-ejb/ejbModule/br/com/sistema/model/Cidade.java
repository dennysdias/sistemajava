package br.com.sistema.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="cidade")
public class Cidade implements Serializable
{
	
	/**
	 * Serialização
	 */
	private static final long serialVersionUID = 1L;
   
	/**
	 * id chave de auto incremento.
	 */
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	
	/**
	 * Nome da cidade.
	 */	
	@Column(name="cidade",length=100,nullable = false)	
	private String cidade;

	/**
	 * Mapeamento relacional entre cidade e estado.
	 */		
	@ManyToOne
	@JoinColumn(name = "id_estado", referencedColumnName = "id")
	private Estado estado;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
   
}
