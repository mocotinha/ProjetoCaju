package br.edu.ifpb.caju.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class DAO<T> implements DAOInterface<T> {
	protected static EntityManager manager;

	public DAO(){}

	public static void open(){
		getManager();
	}
	public static void close(){
		if(manager != null)
			manager = null;
	}
	
	protected static EntityManager getManager(){
		if(manager==null){
			EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory("caju");
			manager = factory.createEntityManager();
		}
		return manager;
	}

	public void persist(T obj){
		manager.persist(obj);
	}
	public void remove(T obj) {
		manager.remove(obj);
	}
	public T merge(T obj){
		return manager.merge(obj);
	}
	public void refresh(T obj){
		 manager.refresh(obj);
	}

	
	@SuppressWarnings("unchecked")
	public T find(Object chave){
		Class<T> type = (Class<T>) ((ParameterizedType) this.getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
		return manager.find(type, chave);
	}
	
	@SuppressWarnings("unchecked")
	public List<T> findAll(){
		Class<T> type = (Class<T>) ((ParameterizedType) this.getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
		Query query = manager.createQuery("select x from " + type.getSimpleName() + " x");
		return (List<T>) query.getResultList();

	}

	@SuppressWarnings("unchecked")
	protected List<T> findByField(String campo, String valor) 	{
		Class<T> type = (Class<T>) ((ParameterizedType) this.getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
		Query query = manager.createQuery("select x from " + type.getSimpleName() + " x " +
				"where x." +campo+ " = \"" +valor+ "\"");
		return (List<T>) query.getResultList();
	}
	

	//----------------------------------------------------------
	//----------------------- TRANSAÇÃO   ----------------------
	//----------------------------------------------------------

	public static void begin(){
		if(!manager.getTransaction().isActive())
			manager.getTransaction().begin();
	}
	public static void commit(){
		if(manager.getTransaction().isActive()){
			manager.getTransaction().commit();
			manager.clear();		// esvaziar o cache de objetos
		}
	}
	public static void flush(){
		manager.flush();
	}
	public static void rollback(){
		if(manager.getTransaction().isActive())
			manager.getTransaction().rollback();
	}


	
	//----------------------------------------------------------
	//----------------------- USO DE JPQL ----------------------
	//----------------------------------------------------------
	public  Object findByQuery(String consultaJPQL){		
		try{
			Query q = manager.createQuery(consultaJPQL);
			return (Object) q.getSingleResult();
		}
		catch(NoResultException e){
			return null;
		}
		catch(NonUniqueResultException e){
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public  List<T> findAllByQuery(String consulta){		
		try{
			Query q = manager.createQuery(consulta);
			return q.getResultList();
		}
		catch(NoResultException e){
			return null;
		}
		catch(NonUniqueResultException e){
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public  List<T> findAgregateByQuery(String consulta){
		Query q = manager.createQuery(consulta);
		return q.getResultList();
	}
		
	public int executeUpdate(String consulta) {
		Query q = manager.createQuery(consulta);
		int linhas = q.executeUpdate();
		return linhas;
	}
	
}

