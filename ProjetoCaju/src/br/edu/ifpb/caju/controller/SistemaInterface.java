package br.edu.ifpb.caju.controller;

import java.util.Date;
import java.util.List;

import br.edu.ifpb.caju.model.Ata;
import br.edu.ifpb.caju.model.Colegiado;
import br.edu.ifpb.caju.model.Membro;
import br.edu.ifpb.caju.model.Processo;
import br.edu.ifpb.caju.model.Reuniao;
import br.edu.ifpb.caju.model.Voto;

public interface SistemaInterface {
	
	public void alocarProcessoAReunião(Processo p, Reuniao r);
	public List<Date> consultarAgendaDoColegiado(Colegiado c);
	public Ata gerarAtaDeReuniao(Reuniao r);
	public String gerarPautaDaReuniao(Reuniao r);
	public void votarEmProcesso(Voto v, Processo p);
	public void cadastraReuniao(Date data);
	public void cadastraMembro(String nome, String email, String telefone);
	public void cadastraProcesso(String nome, String matricula, String periodo, Date data, String assunto);
	public void cadastrarPresidente(Membro membro, String login, String senha);
	public void cadastraColegiado(Date data);

}
