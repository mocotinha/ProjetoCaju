package br.edu.ifpb.caju.dao;

import java.util.List;

import javax.persistence.Query;

import br.edu.ifpb.caju.model.Modelo;

public class DAOModelo extends DAO<Modelo>{

	@SuppressWarnings("unchecked")
	public List<Modelo> findByAtribute(String text) {
		Query q = getManager().createQuery("select m from Modelo m where m.atributo like :atributo" );
		q.setParameter("atributo", text+"%");
		return q.getResultList();
	}

	

}
