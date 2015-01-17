package br.edu.ifpb.caju.controller;

import java.util.List;

import br.edu.ifpb.caju.model.Membro;

public interface SistemaMembroInterface {
	
	public String criptografarSenha(String senha);
	public Membro verificarLogin(String login, String senha);
	public void cadastraMembro(Membro membro);
	public void removeMembro(Membro membro);
	public void editaMembro(Membro membro);
	public List<Membro> getAllMembros();
	public Membro getMembroPorNome(String text);
	

}
