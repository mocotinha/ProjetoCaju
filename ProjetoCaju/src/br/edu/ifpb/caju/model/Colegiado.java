package br.edu.ifpb.caju.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Colegiado {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private LocalDate dataIni;
	private LocalDate dataFim;
	@ManyToMany
	private List<Membro> membros = new ArrayList<Membro>();
	private boolean ativo;
	@OneToMany
	private List<Reuniao> reunioes = new ArrayList<Reuniao>();
	
	public Colegiado(){}

	
	public void addReuniao(Reuniao reuniao){
		reuniao.setColegiado(this);
		reunioes.add(reuniao);
	}
	
	public List<Reuniao> getReunioes() {
		return reunioes;
	}


	public void setReunioes(List<Reuniao> reunioes) {
		this.reunioes = reunioes;
	}


	public LocalDate getDataIni() {
		return dataIni;
	}
	
	public String getDataFormatada(LocalDate data){
		
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return data.format(formatador);
	}

	public void setDataIni(LocalDate dataIni) {
		this.dataIni = dataIni;
	}

	public LocalDate getDataFim() {
		return dataFim;
	}

	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}

	public List<Membro> getMembros() {
		return membros;
	}

	public void setMembros(List<Membro> membros) {
		this.membros = membros;
	}
	
	public void addMembro(Membro membro){
		this.membros.add(membro);
	
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
