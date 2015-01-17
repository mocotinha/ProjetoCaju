package br.edu.ifpb.caju.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.edu.ifpb.caju.model.Ata;
import br.edu.ifpb.caju.model.Colegiado;
import br.edu.ifpb.caju.model.Membro;
import br.edu.ifpb.caju.model.Presidente;
import br.edu.ifpb.caju.model.Processo;
import br.edu.ifpb.caju.model.Reuniao;
import br.edu.ifpb.caju.model.Voto;

public class Sistema implements SistemaInterface{
	
	private static SistemaReuniao sr = new SistemaReuniao();
	private static SistemaMembro sm = new SistemaMembro();
	private static SistemaColegiado sc = new SistemaColegiado();
	private static SistemaProcesso sp = new SistemaProcesso();

	@Override
	public void alocarProcessoAReunião(Processo p, Reuniao r) {
		r.addProcesso(p);
		
	}

	@Override
	public List<Date> consultarAgendaDoColegiado(Colegiado c) {
		List<Date> datas = new ArrayList<Date>();
		for (Reuniao r : c.getReunioes()) {
			datas.add(r.getDataAgenda());
		}
		return datas;
		
	}

	@Override
	public Ata gerarAtaDeReuniao(Reuniao r) {
		//TODO Seguir Algum modelo de Ata
		return null;
	}

	@Override
	public String gerarPautaDaReuniao(Reuniao r) {
		String pauta = "Pauta da Reuni�o � ser realizada dia: "+r.getDataAgenda();
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
	public void cadastraReuniao(Date data) {
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
		processo.setDataDoc(data);
		processo.setAssunto(assunto);
		sp.cadastraProcesso(processo);
		
		
	}

	@Override
	public void cadastrarPresidente(Membro membro, String login, String senha) {
		Presidente p = new Presidente();
		p.setNome(membro.getNome());
		p.setEmail(membro.getEmail());
		p.setTelefone(membro.getTelefone());
		p.setAtivo(true);
		p.setLogin(login);
		p.setSenha(senha);
		sm.cadastraMembro(p);
		
	}

	@Override
	public void cadastraColegiado(Date data) {
		Colegiado c = new Colegiado();
		c.setDataIni(data);
		sc.cadastraColegiado(c);
		
	}

}
