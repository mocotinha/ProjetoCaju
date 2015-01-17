package br.edu.ifpb.caju.controller;

import java.util.List;

import br.edu.ifpb.caju.dao.DAO;
import br.edu.ifpb.caju.dao.DAOAta;
import br.edu.ifpb.caju.model.Ata;

public class SistemaAta implements SistemaAtaInterface {

	private DAOAta dao;
	
	public SistemaAta() {
		this.dao = new DAOAta();
	}
	@Override
	public void cadastraAta(Ata ata) {
		
		DAO.open();
		DAO.begin();
		this.dao.persist(ata);
		DAO.commit();
		DAO.close();
	}

	@Override
	public void removeAta(Ata ata) {
	
		DAO.open();
		DAO.begin();
		this.dao.remove(ata);
		DAO.commit();
		DAO.close();
	}

	@Override
	public void editaAta(Ata ata) {
		
		DAO.open();
		DAO.begin();
		this.dao.merge(ata);
		DAO.commit();
		DAO.close();
	}

	@Override
	public List<Ata> getAllAta() {
		List<Ata> ata;
		DAO.open();
		DAO.begin();
		ata = this.dao.findAll();
		DAO.commit();
		DAO.close();
		return ata;
	}



}
