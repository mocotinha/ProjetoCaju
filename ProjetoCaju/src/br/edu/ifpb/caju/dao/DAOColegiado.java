package br.edu.ifpb.caju.dao;

import java.util.List;

import javax.persistence.Query;

import br.edu.ifpb.caju.model.Colegiado;

public class DAOColegiado extends DAO<Colegiado> {
	@SuppressWarnings("unchecked")
	public List<Colegiado> findAtivos() {
		Query q = getManager().createQuery("select c from Colegiado c where c.ativo = :ativo");
		q.setParameter("ativo", true);
		return q.getResultList();
	}

}
