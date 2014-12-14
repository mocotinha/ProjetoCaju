package br.edu.ifpb.caju.controller;

import java.util.Date;
import java.util.List;

import br.edu.ifpb.caju.model.Colegiado;

public interface SistemaColegiadoInterface {
	public void cadastraColegiado(Date dataIni, Date dataFim, boolean ativo);

	public void removeColegiado(Colegiado colegiado);

	public void editaColegiado(Colegiado colegiado);

	public List<Colegiado> getAllColegiado();

	public List<Colegiado> getColegiadoPorAtributo(String text);
}
