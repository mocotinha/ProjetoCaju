package br.edu.ifpb.caju.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Reuniao {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataAgenda;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataReunicao;
	@ManyToMany
	private List<Membro> membrosPresentes = new ArrayList<Membro>();
	private String pauta;
	@OneToOne(cascade=CascadeType.ALL)
	private Ata ata;
	@ManyToOne
	private Colegiado colegiado;
	@OneToMany
	private List<Processo> processos = new ArrayList<Processo>();
	
	public Reuniao(){}
	
	
	
	public List<Processo> getProcessos() {
		return processos;
	}

	public void addProcesso(Processo processo){
		processo.setReuniao(this);
		this.processos.add(processo);
	}

	public void setProcessos(List<Processo> processos) {
		for (Processo processo : processos) {
			addProcesso(processo);
		}
	}



	public Date getDataAgenda() {
		return dataAgenda;
	}
	public void setDataAgenda(Date dataAgenda) {
		this.dataAgenda = dataAgenda;
	}
	public Date getDataReunicao() {
		return dataReunicao;
	}
	public void setDataReunicao(Date dataReunicao) {
		this.dataReunicao = dataReunicao;
	}

	public void addMembrosPresentes(Membro membro){
		this.membrosPresentes.add(membro);
		membro.addReuniao(this);
	}
	
	public List<Membro> getMembrosPresentes() {
		return membrosPresentes;
	}

	public void setMembrosPresentes(List<Membro> membrosPresentes) {
		this.membrosPresentes = membrosPresentes;
	}

	public Colegiado getColegiado() {
		return colegiado;
	}

	public void setColegiado(Colegiado colegiado) {
		this.colegiado = colegiado;
	}

	public List<Membro> getMembros() {
		return membrosPresentes;
	}
	public void addMembro(Membro membro){
		membro.addReuniao(this);
		this.membrosPresentes.add(membro);
	}
	
	public void setMembros(List<Membro> membros) {
		for (Membro membro : membros) {
			addMembro(membro);
		}
		this.membrosPresentes = membros;
	}

	public String getPauta() {
		return pauta;
	}
	public void setPauta(String pauta) {
		this.pauta = pauta;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Ata getAta() {
		return ata;
	}
	public void setAta(Ata ata) {
		ata.setReuniao(this);
		this.ata = ata;
	}
	
	
	
}
