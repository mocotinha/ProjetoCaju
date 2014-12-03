package br.edu.ifpb.caju.model;

import java.util.Date;
import java.util.List;

public class Reuniao {

	private Date dataAgenda;
	private Date dataRealizacao;
	private List<Membro> menbros;
	private String pauta;
	private StatusReuniao status;
	private String periodo;
	private Ata ata;
	private List<Processo> processo;
}
