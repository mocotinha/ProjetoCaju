package br.edu.ifpb.caju.dao;

import java.util.HashMap;
import java.util.List;

import javax.persistence.Query;

import br.edu.ifpb.caju.model.Processo;

public class DAOProcesso extends DAO<Processo>{

	@SuppressWarnings("unchecked")
	public List<Processo> findByAtributes(HashMap<String, String> dados) {
		Query q = getManager().createQuery("select p from Processo p where p.nomeRequerente like :nomeRequerente AND p.relator.nome like :nomeRelator AND"+
	"p.dataDoc = :data" );
		if(dados.containsKey("requerente")){
			q.setParameter("nomeRequerente", dados.get("requerente")+"%");
		}else{
			q.setParameter("nomeRequerente", "%");
		}
		
		if(dados.containsKey("relator")){
			q.setParameter("nomeRelator", dados.get("relator")+"%");
		}else{
			q.setParameter("nomeRelator", "%");
		}
		
		//TODO Precisa Ver como vai ser essa data
		if(dados.containsKey("data")){
			q.setParameter("data", "%");
		}else{
			q.setParameter("data", "%");
		}
		
		
		return  q.getResultList();
		
	}

}
