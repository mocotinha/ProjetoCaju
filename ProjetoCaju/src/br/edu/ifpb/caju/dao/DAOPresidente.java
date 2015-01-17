package br.edu.ifpb.caju.dao;

import javax.persistence.Query;

import br.edu.ifpb.caju.model.Presidente;

public class DAOPresidente extends DAO<Presidente>{
	
	public Presidente findByLogin(String text) {
		Query q = getManager().createQuery("select m from Presidente m where m.login like :atributo" );
		q.setParameter("atributo", text);
		return (Presidente) q.getSingleResult();
	}
	

}
