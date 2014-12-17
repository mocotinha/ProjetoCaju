package br.edu.ifpb.caju.controller;

import java.util.List;

import br.edu.ifpb.caju.model.Ata;

public interface SistemaAtaInterface {
	public void cadastraAta(Ata ata);

	public void removeAta(Ata ata);

	public void editaAta(Ata ata);

	public List<Ata> getAllAta();

}
