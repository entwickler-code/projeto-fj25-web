package br.com.caelum.financas.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;

@Entity
public class Tag {
	@Id
	@GeneratedValue	
	private Integer id;
	@Field(index = Index.TOKENIZED)
	private String nome;
	
	
	public Integer getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String toString(){
		
		return nome;
	}

}
