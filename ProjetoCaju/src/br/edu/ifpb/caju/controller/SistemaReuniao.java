package br.edu.ifpb.caju.controller;

import java.util.List;

import br.edu.ifpb.caju.dao.DAO;
import br.edu.ifpb.caju.dao.DAOReuniao;
import br.edu.ifpb.caju.model.Reuniao;

public class SistemaReuniao implements SistemaReuniaoInterface{

	private DAOReuniao dao;
	
	public SistemaReuniao() {
		this.dao = new DAOReuniao();
	}
	
	@Override
	public void cadastraReuniao(Reuniao reuniao) {
		DAO.open();
		DAO.begin();
		this.dao.persist(reuniao);
		DAO.commit();
		DAO.close();
		
	}

	@Override
	public void removeReuniao(Reuniao reuniao) {
		DAO.open();
		DAO.begin();
		this.dao.remove(reuniao);
		DAO.commit();
		DAO.close();
		
	}

	@Override
	public void editaReuniao(Reuniao reuniao) {
		DAO.open();
		DAO.begin();
		this.dao.merge(reuniao);
		DAO.commit();
		DAO.close();
		
	}

	@Override
	public List<Reuniao> getAllReunioes() {
		DAO.open();
		DAO.begin();
		List<Reuniao> reunioes = this.dao.findAll();
		DAO.commit();
		DAO.close();
		return reunioes;
	}

}
