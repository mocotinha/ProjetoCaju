package br.edu.ifpb.caju.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifpb.caju.model.Ata;
import br.edu.ifpb.caju.model.Colegiado;
import br.edu.ifpb.caju.model.Processo;
import br.edu.ifpb.caju.model.Reuniao;
import br.edu.ifpb.caju.model.Voto;

public class Sistema implements SistemaInterface{

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

}
