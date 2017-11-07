package model;

import java.util.Observable;

/**
 * @author Elizio e Nael
 * Classe que representa um cliente
 * 
 */
public class Cliente extends Observable implements Usuario{ 
	protected String nome;
	protected String login;
	protected String senha;
	protected int tipo;
	
	public int getTipo() {
		return tipo;
	}
	
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
		setChanged();
		notifyObservers();
	}
	
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
		setChanged();
		notifyObservers();
		
	}
	
	

}
