package br.edu.ifpb.caju.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Membro {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nome;
	private String email;
	private String telefone;
	private String perfil;
	private boolean ativo;
	@ManyToMany
	private List<Reuniao> reunioes = new ArrayList<Reuniao>();
	
	@ManyToMany(mappedBy="membros")
	private List<Colegiado> colegiados =  new ArrayList<Colegiado>();
	@OneToMany
	private List<Voto> votos = new ArrayList<Voto>();
	
	@OneToMany(mappedBy="relator")
	private List<Processo> processos = new ArrayList<Processo>();
	
	public Membro(){}
	
	
	
	public List<Processo> getProcessos() {
		return processos;
	}



	public void setProcessos(List<Processo> processos) {
		for (Processo processo : processos) {
			addProcesso(processo);
		}
	}



	private void addProcesso(Processo processo) {
		processo.setRelator(this);
		this.processos.add(processo);
		
	}



	public List<Voto> getVotos() {
		return votos;
	}

	public void addVoto(Voto voto){
		this.votos.add(voto);
	}

	public void setVotos(List<Voto> votos) {
		for (Voto voto : votos) {
			addVoto(voto);
		}
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Colegiado> getColegiados() {
		return colegiados;
	}

	public void setColegiados(List<Colegiado> colegiados) {
		for (Colegiado colegiado : colegiados) {
			this.colegiados.add(colegiado);
		}
	}

	public void addColegiado(Colegiado colegiado){
		this.colegiados.add(colegiado);
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
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

	public void addReuniao(Reuniao reuniao){
		this.reunioes.add(reuniao);
	}
	
	public List<Reuniao> getReunioes() {
		return reunioes;
	}

	public void setReunioes(List<Reuniao> reunioes) {
		this.reunioes = reunioes;
	}
	
	
	
	
	
	

}
