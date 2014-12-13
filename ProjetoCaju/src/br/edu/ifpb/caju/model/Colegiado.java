package br.edu.ifpb.caju.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Colegiado {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private Date dataIni;
	private Date dataFim;
	private List<Membro> membros;
	private Membro presidente;
	private boolean ativo;
	
	public Colegiado() {
		// TODO Auto-generated constructor stub
	}

	public Colegiado(Date dataIni, Date dataFim, List<Membro> membros,
			Membro presidente, boolean ativo) {
		super();
		this.dataIni = dataIni;
		this.dataFim = dataFim;
		this.membros = membros;
		this.presidente = presidente;
		this.ativo = ativo;
	}

	public Date getDataIni() {
		return dataIni;
	}

	public void setDataIni(Date dataIni) {
		this.dataIni = dataIni;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public List<Membro> getMembros() {
		return membros;
	}

	public void setMembros(List<Membro> membros) {
		this.membros = membros;
	}

	public Membro getPresidente() {
		return presidente;
	}

	public void setPresidente(Membro presidente) {
		this.presidente = presidente;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
