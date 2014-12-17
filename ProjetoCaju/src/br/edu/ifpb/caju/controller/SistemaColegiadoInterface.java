package br.edu.ifpb.caju.controller;

import java.util.List;

import br.edu.ifpb.caju.model.Colegiado;

public interface SistemaColegiadoInterface {
	
	public void cadastraColegiado(Colegiado colegiado);

	public void removeColegiado(Colegiado colegiado);

	public void editaColegiado(Colegiado colegiado);

	public List<Colegiado> getAllColegiado();
}
