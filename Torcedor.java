package model;

/**
 * @author Elizio e Nael
 * Classe reponsável por representar um torcedor
 */

public class Torcedor extends Cliente {
	
	private Time time;

	/**
	 * @author Elizio e Nael
	 * Construtor da classe
	 */
	public Torcedor (String nome,String login, String senha, Time time){
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.time = time;
		setTipo(0);
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}


}
