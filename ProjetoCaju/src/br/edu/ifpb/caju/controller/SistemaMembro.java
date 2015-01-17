package br.edu.ifpb.caju.controller;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import br.edu.ifpb.caju.dao.DAO;
import br.edu.ifpb.caju.dao.DAOMembro;
import br.edu.ifpb.caju.dao.DAOPresidente;
import br.edu.ifpb.caju.model.Membro;
import br.edu.ifpb.caju.model.Presidente;

public  class SistemaMembro implements SistemaMembroInterface{

	private static final String METODO_CRIPTOGRAFIA = "MD5";
	private DAOMembro dao;
	private DAOPresidente daoP;
	
	public SistemaMembro() {
		this.dao = new DAOMembro();
		this.daoP =  new DAOPresidente();
	}
	
	@Override
	public String criptografarSenha(String senha) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance(METODO_CRIPTOGRAFIA);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	        md.update(senha.getBytes());
	        BigInteger hash = new BigInteger(1, md.digest());
	        return hash.toString(16);
	}

	@Override
	public Membro verificarLogin(String login, String senha) {
		String pass = new String(senha);
		
		Membro user = null;
		DAO.open();
		DAO.begin();
		try{
			user = (Presidente) daoP.findByLogin(login);
			DAO.close();
			if(((Presidente)user).getSenha().equals(criptografarSenha(pass))){
				
				return user;
				
			}
		}catch(Exception e){
			return null;
		}
		DAO.close();
		return null;
	}

	@Override
	public void cadastraMembro(Membro membro) {
		DAO.open();
		DAO.begin();
		this.dao.persist(membro);
		DAO.commit();
		DAO.close();
		
	}

	@Override
	public void removeMembro(Membro membro) {
		DAO.open();
		DAO.begin();
		this.dao.remove(membro);
		DAO.commit();
		DAO.close();
		
		
	}

	@Override
	public void editaMembro(Membro membro) {
		DAO.open();
		DAO.begin();
		this.dao.merge(membro);
		DAO.commit();
		DAO.close();
		
	}

	@Override
	public List<Membro> getAllMembros() {
		DAO.open();
		DAO.begin();
		List<Membro> r = this.dao.findAll();
		DAO.close();
		return r;
	}

	@Override
	public Membro getMembroPorNome(String text) {
		DAO.open();
		DAO.begin();
		Membro m = this.dao.findByNome(text);
		DAO.close();
		return m;
	}

	public Presidente getMembroPorLogin(String login) {
		DAO.open();
		DAO.begin();
		Presidente m = this.daoP.findByLogin(login);
		DAO.close();
		return m;
	}

}
