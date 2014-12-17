package br.edu.ifpb.caju.application;

import br.edu.ifpb.caju.controller.SistemaMembro;
import br.edu.ifpb.caju.dao.DAO;
import br.edu.ifpb.caju.dao.DAOPresidente;
import br.edu.ifpb.caju.model.Presidente;
/*
 * Apllication 1 - Cadastro e Login de Presidente de Colegiado
 */
public class ApplicationLogin {

	public static void main(String[] args) {
		
		SistemaMembro sm = new SistemaMembro();
		Presidente p = new Presidente();
		p.setNome("Jozias");
		p.setLogin("admin");
		p.setSenha(sm.criptografarSenha("123"));
		
//		Cadastro de Presidente - Usuarios Autenticados
//		sm.cadastraMembro(p);
		
//		
		DAO.open();
		DAO.begin();
		Presidente membro = sm.getMembroPorLogin("admin");
		if(membro.getSenha().equals(sm.criptografarSenha("123"))){
			System.out.println("Logado Com Sucesso!");
		}else{
			System.out.println("Login ou Senha Inválida");
		}
		DAO.close();
		
		

	}

}
