package br.edu.ifpb.caju.application;

import java.time.LocalDate;

import br.edu.ifpb.caju.dao.DAO;
import br.edu.ifpb.caju.dao.DAOColegiado;
import br.edu.ifpb.caju.dao.DAOMembro;
import br.edu.ifpb.caju.dao.DAOProcesso;
import br.edu.ifpb.caju.dao.DAOReuniao;
import br.edu.ifpb.caju.model.Ata;
import br.edu.ifpb.caju.model.Colegiado;
import br.edu.ifpb.caju.model.Membro;
import br.edu.ifpb.caju.model.Processo;
import br.edu.ifpb.caju.model.Reuniao;

/*
 * Apllication 2 - Cadastro de Reunião Junto com seus respectivos Atributos
 */
public class ApplicationReuniao {
	public static void main(String[] args) {
		DAOReuniao dao = new DAOReuniao();
		DAOColegiado daoC = new DAOColegiado();
		DAOMembro daoM = new DAOMembro();
		DAOProcesso daoP = new DAOProcesso();
		
		DAO.open();
		DAO.begin();
		
		/*Cadastro de Reunião
		 * Reuniao r = new Reuniao();
		
		//Componentes da Reunião
		Ata a = new Ata();
		a.setTexto("Ata da Reunião");
		r.setAta(a);
		
		Colegiado c = new Colegiado();
		c.addReuniao(r);
		daoC.persist(c);
		
		r.setDataAgenda(LocalDate.of(2014, 1, 22));
		r.setDataReunicao(LocalDate.of(2014	, 1, 31));
		r.setPauta("Foi Discutido ...");
		
		Membro m = new Membro();
		m.setNome("Membro 1");
		r.addMembro(m);
		daoM.persist(m);
		
		Processo p = new Processo();
		p.setAssunto("");
		r.addProcesso(p);
		daoP.persist(p);
		
		dao.persist(r);*/
		
		
		
		
		
		
		DAO.commit();
		DAO.close();
		
	}

}
