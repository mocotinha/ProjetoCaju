package br.edu.ifpb.caju.controller;

import java.util.List;

import br.edu.ifpb.caju.dao.DAO;
import br.edu.ifpb.caju.dao.DAOModelo;
import br.edu.ifpb.caju.model.Modelo;

public class SistemaModelo implements SistemaModeloInterface{

	
	
	@Override
	public void cadastraModelo(String atributos) {
		Modelo modelo = new Modelo();
		modelo.setAtributo(atributos);
		DAOModelo dao = new DAOModelo();
		DAO.open();
		DAO.begin();
		dao.persist(modelo);
		DAO.commit();
		DAO.close();
		
	}

	@Override
	public void removeModelo(Modelo modelo) {
		DAOModelo dao = new DAOModelo();
		DAO.open();
		DAO.begin();
		dao.remove(modelo);
		DAO.commit();
		DAO.close();
		
	}

	@Override
	public void editaModelo(Modelo modelo) {
		DAOModelo dao = new DAOModelo();
		DAO.open();
		DAO.begin();
		dao.merge(modelo);
		DAO.commit();
		DAO.close();
		
	}

	@Override
	public List<Modelo> getAllModelos() {
		List<Modelo> modelos;
		DAOModelo dao = new DAOModelo();
		DAO.open();
		DAO.begin();
		modelos = dao.findAll();
		DAO.commit();
		DAO.close();
		return modelos;
		
	}

	public List<Modelo> getModeloPorAtributo(String text) {
		List<Modelo> modelos;
		DAOModelo dao = new DAOModelo();
		DAO.open();
		DAO.begin();
		modelos = dao.findByAtribute(text);
		DAO.commit();
		DAO.close();
		return modelos;
	}

}
