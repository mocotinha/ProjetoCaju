package br.edu.ifpb.caju.dao;

import java.util.List;

import javax.persistence.Query;

import br.edu.ifpb.caju.model.Ata;

public class DAOAta extends DAO<Ata>{
	@SuppressWarnings("unchecked")
	
	public List<Ata> findByAtribute(String text) {
		Query q = getManager().createQuery("select a from Ata c where a.texto like :texto");
		q.setParameter("%" + "texto", text + "%");
		return q.getResultList();
	}	

}
