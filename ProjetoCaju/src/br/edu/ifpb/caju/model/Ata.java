package br.edu.ifpb.caju.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity()
public class Ata {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private long texto;
	
	public Ata(){
		
	}
	
	public Ata(Long texto){
		this.texto = texto;
	}
	
	
	public long getTexto() {
		return texto;
	}
	public void setTexto(long texto) {
		this.texto = texto;
	}
	
	
	
	
}
