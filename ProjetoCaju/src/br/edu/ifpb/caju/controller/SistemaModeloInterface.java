package br.edu.ifpb.caju.controller;

import java.util.List;

import br.edu.ifpb.caju.model.Modelo;

public interface SistemaModeloInterface {
	
	public void cadastraModelo(String atributos);
	public void removeModelo(Modelo modelo);
	public void editaModelo(Modelo modelo);
	public List<Modelo> getAllModelos();
	public List<Modelo> getModeloPorAtributo(String text);

}
