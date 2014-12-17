package br.edu.ifpb.caju.controller;

import java.time.LocalDate;
import java.util.List;

import br.edu.ifpb.caju.model.Ata;
import br.edu.ifpb.caju.model.Colegiado;
import br.edu.ifpb.caju.model.Processo;
import br.edu.ifpb.caju.model.Reuniao;
import br.edu.ifpb.caju.model.Voto;

public interface SistemaInterface {
	
	public void alocarProcessoAReunião(Processo p, Reuniao r);
	public List<LocalDate> consultarAgendaDoColegiado(Colegiado c);
	public Ata gerarAtaDeReuniao(Reuniao r);
	public String gerarPautaDaReuniao(Reuniao r);
	public void votarEmProcesso(Voto v, Processo p);

}
