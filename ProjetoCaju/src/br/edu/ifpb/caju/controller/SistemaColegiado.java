package br.edu.ifpb.caju.controller;

import java.util.List;

import br.edu.ifpb.caju.dao.DAO;
import br.edu.ifpb.caju.dao.DAOColegiado;
import br.edu.ifpb.caju.model.Colegiado;


public class SistemaColegiado implements SistemaColegiadoInterface {

	private DAOColegiado dao;
	
	public SistemaColegiado() {
		this.dao = new DAOColegiado();
	}
	
	@Override
	public void cadastraColegiado(Colegiado colegiado) {
		DAO.open();
		DAO.begin();
		this.dao.persist(colegiado);
		DAO.commit();
		DAO.close();
		
	}

	@Override
	public void removeColegiado(Colegiado colegiado) {
		colegiado.setAtivo(false);
		DAO.open();
		DAO.begin();
		this.dao.merge(colegiado);
		DAO.commit();
		DAO.close();
		
	}

	@Override
	public void editaColegiado(Colegiado colegiado) {
	
		DAO.open();
		DAO.begin();
		this.dao.merge(colegiado);
		DAO.commit();
		DAO.close();
		
	}

	@Override
	public List<Colegiado> getAllColegiado() {

		DAO.open();
		DAO.begin();
		List<Colegiado> colegiados = this.dao.findAll();
		DAO.commit();
		DAO.close();
		return colegiados;
	}



	

}
