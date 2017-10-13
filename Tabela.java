package model;

import java.util.ArrayList;

public class Tabela {
	
	/** @author Elizio e Nael
	 * Classe responsavel armazenar as informações relacionadas a tabela do campeonato(Partidas e times participantes)
	 * 
	 */
	private ArrayList<Partida> partidas = new ArrayList<Partida>();
	private ArrayList<Time> timesRegistrados = new ArrayList<Time>();
	
	/** @author Elizio e Nael
	 *  Método construtor da Tabela
	 */
	public Tabela() {
		
	}
	
	public ArrayList<Partida> getPartidas() {
		return partidas;
	}

	public void setPartidas(ArrayList<Partida> partidas) {
		this.partidas = partidas;
	}

	public void adicionar_partida(Partida partida) {
		this.partidas.add(partida);
	}

	public ArrayList<Time> getTimesRegistrados() {
		return timesRegistrados;
	}

	public void setTimesRegistrados(ArrayList<Time> timesRegistrados) {
		this.timesRegistrados = timesRegistrados;
	}

}
