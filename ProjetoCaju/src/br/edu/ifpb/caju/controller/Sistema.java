package br.edu.ifpb.caju.controller;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.edu.ifpb.caju.model.Ata;
import br.edu.ifpb.caju.model.Colegiado;
import br.edu.ifpb.caju.model.Membro;
import br.edu.ifpb.caju.model.Processo;
import br.edu.ifpb.caju.model.Reuniao;
import br.edu.ifpb.caju.model.Voto;

public class Sistema implements SistemaInterface{
	
	private static SistemaReuniao sr = new SistemaReuniao();
	private static SistemaMembro sm = new SistemaMembro();

	@Override
	public void alocarProcessoAReunião(Processo p, Reuniao r) {
		r.addProcesso(p);
		
	}

	@Override
	public List<LocalDate> consultarAgendaDoColegiado(Colegiado c) {
		List<LocalDate> datas = new ArrayList<LocalDate>();
		for (Reuniao r : c.getReunioes()) {
			datas.add(r.getDataAgenda());
		}
		return datas;
		
	}

	@Override
	public Ata gerarAtaDeReuniao(Reuniao r) {
		//TODO Seguir modelo
		return null;
	}

	@Override
	public String gerarPautaDaReuniao(Reuniao r) {
		String pauta = "Pauta da Reunião à ser realizada dia: "+r.getDataAgenda();
		pauta += "\nProcessos:";
		for (Processo p : r.getProcessos()) {
			pauta+= "\nRequerente: "+p.getNomeRequerente() +" Relator: "+p.getRelator().getNome()+" Assunto: "+p.getAssunto();
		}
		
		return pauta;
	}

	@Override
	public void votarEmProcesso(Voto v, Processo p) {
		p.setVoto(v);
		
	}

	@Override
	public void cadastraReuniao(LocalDate data) {
		Reuniao reuniao = new Reuniao();
		reuniao.setDataAgenda(data);
		sr.cadastraReuniao(reuniao);
		
	}

	public void cadastraMembro(String nome, String email, String telefone) {
		Membro membro = new Membro();
		membro.setNome(nome);
		membro.setEmail(email);
		membro.setTelefone(telefone);
		sm.cadastraMembro(membro);
		
	}

	public void cadastraProcesso(String nome, String matricula, String periodo,
			Date data, String assunto) {
		Processo processo = new Processo();
		processo.setNomeRequerente(nome);
		processo.setMatRequerente(Integer.parseInt(matricula));
		processo.setPeriodo(periodo);
		Instant instant = Instant.ofEpochMilli(data.getTime());
		LocalDate res = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).toLocalDate();
		processo.setDataDoc(res);
		processo.setAssunto(assunto);
		
	}

}
