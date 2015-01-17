package br.edu.ifpb.caju.controller;

import java.util.HashMap;
import java.util.List;

import br.edu.ifpb.caju.model.Processo;

public interface SistemaProcessoInterface {
	
	public void cadastraProcesso(Processo processo);
	public void removeProcesso(Processo processo);
	public void editaProcesso(Processo processo	);
	public List<Processo> getAllProcessos();
	public List<Processo> getProcessosByAtributes(HashMap<String, String> dados);

}
