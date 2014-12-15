package br.edu.ifpb.caju.controller;

import java.util.List;

import br.edu.ifpb.caju.dao.DAO;
import br.edu.ifpb.caju.dao.DAOAta;
import br.edu.ifpb.caju.model.Ata;

public class SistemaAta implements SistemaAtaInterface {

	@Override
	public void cadastraAta(String text) {
		Ata ata = new Ata();
		ata.setTexto(text);
		DAOAta dao = new DAOAta();
		DAO.open();
		DAO.begin();
		dao.persist(ata);
		DAO.commit();
		DAO.close();
	}

	@Override
	public void removeAta(Ata ata) {
		DAOAta dao = new DAOAta();
		DAO.open();
		DAO.begin();
		dao.remove(ata);
		DAO.commit();
		DAO.close();
	}

	@Override
	public void editaAta(Ata ata) {
		DAOAta dao = new DAOAta();
		DAO.open();
		DAO.begin();
		dao.merge(ata);
		DAO.commit();
		DAO.close();
	}

	@Override
	public List<Ata> getAllAta() {
		List<Ata> ata;
		DAOAta dao = new DAOAta();
		DAO.open();
		DAO.begin();
		ata = dao.findAll();
		DAO.commit();
		DAO.close();
		return ata;
	}

	@Override
	public List<Ata> getAtaPorAtributo(String text) {
		List<Ata> ata;
		DAOAta dao = new DAOAta();
		DAO.open();
		DAO.begin();
		ata = dao.findByAtribute(text);
		DAO.commit();
		DAO.close();
		return ata;
	}

}
