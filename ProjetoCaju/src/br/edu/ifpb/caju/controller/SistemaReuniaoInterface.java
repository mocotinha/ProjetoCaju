package br.edu.ifpb.caju.controller;

import java.util.List;

import br.edu.ifpb.caju.model.Reuniao;


public interface SistemaReuniaoInterface {
	
	public void cadastraReuniao(Reuniao reuniao);
	public void removeReuniao(Reuniao reuniao);
	public void editaReuniao(Reuniao reuniao	);
	public List<Reuniao> getAllReunioes();

}
