package controller;

import java.util.ArrayList;

import model.Time;
import model.Torcedor;
import model.Usuario;

/**
 * @author Elizio e Nael
 * Classe repons�vel por gerenciar o sistema de login
 */

public class GerenteLogin {
	
	private Usuario usuarioLogado;
	private boolean logado;
	private Time timeUsando;
	
	/**
	 * @author Elizio e Nael
	 * Construtor da classe
	 */
	public GerenteLogin(){
	}
	
	/**
	 * @author Elizio e Nael
	 * M�todo que recebe login, senha, lista com os usu�rios cadastrados e verifica se ele consta na lista,
	 * caso conste retorna o �ndice em que ele se encontra, caso contr�rio retorna -1
	 */
	public int verificaLogin(String login, String senha, ArrayList<Torcedor> usuarios){
		for(int i= 0; i< usuarios.size();i++){
			if(usuarios.get(i).getLogin().equals(login) && usuarios.get(i).getSenha().equals(senha)){
				return i;
			}
		}return -1;
	}
	
	/**
	 * @author Elizio e Nael
	 * M�todo que recebe um torcedor e insere em usu�rio logado que representa o usu�rio que 
	 * est� usando o sistema naquele momento
	 */
	public void logar(Torcedor user){
		setUsuarioLogado(user);
	}
	
	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}
	
	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	public boolean isLogado() {
		return logado;
	}

	public void setLogado(boolean logado) {
		this.logado = logado;
	}

	public Time getTimeUsando() {
		return timeUsando;
	}

	public void setTimeUsando(Time timeUsando) {
		this.timeUsando = timeUsando;
	}

}
