package br.edu.ifpb.caju.controller;

import java.util.Date;
import java.util.List;

import br.edu.ifpb.caju.dao.DAO;
import br.edu.ifpb.caju.dao.DAOColegiado;
import br.edu.ifpb.caju.dao.DAOModelo;
import br.edu.ifpb.caju.model.Colegiado;


public class SistemaColegiado implements SistemaColegiadoInterface {

	@Override
	public void cadastraColegiado(Date dataIni, Date dataFim, boolean ativo) {
		Colegiado colegiado = new Colegiado();
		colegiado.setDataIni(dataIni);
		colegiado.setDataFim(dataFim);
		colegiado.setAtivo(ativo);
		DAOColegiado dao = new DAOColegiado();
		DAO.open();
		DAO.begin();
		dao.persist(colegiado);
		DAO.commit();
		DAO.close();
		
	}

	@Override
	public void removeModelo(Colegiado colegiado) {
		DAOColegiado dao = new DAOColegiado();
		DAO.open();
		DAO.begin();
		// não pode remover
		//dao.remove(colegiado);
		colegiado.setAtivo(false);
		dao.persist(colegiado);
		DAO.commit();
		DAO.close();
		
	}

	@Override
	public void editaModelo(Colegiado colegiado) {
		DAOColegiado dao = new DAOColegiado();
		DAO.open();
		DAO.begin();
		dao.merge(colegiado);
		DAO.commit();
		DAO.close();
		
	}

	@Override
	public List<Colegiado> getAllColegiado() {
		List<Colegiado> colegiados;
		DAOColegiado dao = new DAOColegiado();
		DAO.open();
		DAO.begin();
		colegiados = dao.findAll();
		DAO.commit();
		DAO.close();
		return colegiados;
	}

	@Override
	public List<Colegiado> getColegiadoPorAtributo(String text) {
		List<Colegiado> colegiados;
		DAOColegiado dao = new DAOColegiado();
		DAO.open();
		DAO.begin();
		colegiados = dao.findByAtribute(text);
		DAO.commit();
		DAO.close();
		return colegiados;
	}

	

}
