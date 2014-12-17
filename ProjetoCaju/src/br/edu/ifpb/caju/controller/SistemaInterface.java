package br.edu.ifpb.caju.controller;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import br.edu.ifpb.caju.model.Ata;
import br.edu.ifpb.caju.model.Colegiado;
import br.edu.ifpb.caju.model.Processo;
import br.edu.ifpb.caju.model.Reuniao;
import br.edu.ifpb.caju.model.Voto;

public interface SistemaInterface {
	
	public void alocarProcessoAReuni�o(Processo p, Reuniao r);
	public List<LocalDate> consultarAgendaDoColegiado(Colegiado c);
	public Ata gerarAtaDeReuniao(Reuniao r);
	public String gerarPautaDaReuniao(Reuniao r);
	public void votarEmProcesso(Voto v, Processo p);
	public void cadastraReuniao(LocalDate data);
	public void cadastraMembro(String nome, String email, String telefone);
	public void cadastraProcesso(String nome, String matricula, String periodo, Date data, String assunto);

}
