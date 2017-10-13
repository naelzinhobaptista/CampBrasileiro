package model;

import java.util.ArrayList;

public class Time {
	
	/**
	 * @author Elizio e Nael 
	 * Classe resposs�vel por armazenar as informa��es dos times
	 * 
	 */
	private String nome;
	private ArrayList<Jogador> jogadores = new ArrayList<Jogador>();
	
	/**
	 * @author Elizio e Nael
	 * 
	 * M�todo construtor de Time
	 */
	public Time(String nome) {
		this.nome = nome;
	}
	
	/**
	 * @author Elizio e Nael
	 * 
	 * M�todo que recebe uma inst�ncia de um jogador e adiciona ele a lista de jogadores
	 */
	public void adicionarJogar(Jogador jogador) {
		jogadores.add(jogador);
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public ArrayList<Jogador> getJogadores() {
		return jogadores;
	}
	public void setJogadores(ArrayList<Jogador> jogadores) {
		this.jogadores = jogadores;
	}
	

}
