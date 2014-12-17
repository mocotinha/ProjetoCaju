package br.edu.ifpb.caju.application;

import javax.swing.JOptionPane;

import br.edu.ifpb.caju.controller.SistemaMembro;
import br.edu.ifpb.caju.dao.DAO;
import br.edu.ifpb.caju.model.Presidente;
import br.edu.ifpb.caju.view.TelaMenu;
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
		try{
			sm.getMembroPorLogin("admin");
		}catch(Exception e){
			sm.cadastraMembro(p);
		}
		
		
	
		DAO.open();
		DAO.begin();
		Presidente membro = sm.getMembroPorLogin("admin");
		if(membro.getSenha().equals(sm.criptografarSenha("123"))){
			JOptionPane.showMessageDialog(null, "Logado com sucesso!");
			TelaMenu tm = new TelaMenu();
			tm.setVisible(true);
		}else{
			JOptionPane.showMessageDialog(null, "Login ou Senha Inválidos");
		}
		DAO.close();
		
		

	}

}
