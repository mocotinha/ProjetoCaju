package br.edu.ifpb.caju.model;

import javax.persistence.Entity;

@Entity
public class Presidente extends Membro{
	private String login;
	private String senha;
	
	public Presidente(){}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		
		this.senha = senha;
	}
	
	
}
