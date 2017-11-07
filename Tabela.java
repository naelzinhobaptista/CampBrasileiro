package model;

import java.util.ArrayList;

/**
 * @author Elizio e Nael
 * Classe que representa uma tabela e armazena as partidas
 */
public class Tabela {
	private ArrayList<Partida> partidas;
	private Time time;
	private ArrayList<Time> timesAcompanhados;
	
	/**
	 * @author Elizio e Nael
	 * Construtor da classe
	 */
	public Tabela(){
		partidas = new ArrayList<Partida>();
		setTimesAcompanhados(new ArrayList<Time>());
	}
	
	/**
	 * @author Elizio e Nael
	 * Método que recebe um time, caso ele não conste em timeAcompanhados, retorna false
	 */
	public void adicionarTime(Time time){
		boolean tem = false;
		for (int i = 0; i< timesAcompanhados.size();i++){
			if (time.equals(timesAcompanhados.get(i))){
				tem = true;
			}
		}if (!tem){
			timesAcompanhados.add(time);
		}
	}
	
	/**
	 * @author Elizio e Nael
	 * Método que recebe uma partida e adiciona na lista de partidas
	 */
	public void adicionarPartida(Partida partida){
		partidas.add(partida);
	}
	
	/**
	 * @author Elizio e Nael
	 * Método que recebe um nome de time e busca esse nome na lista de times cadastrados,
	 * caso encontre, retorna o time, caso contrário retorna um time vazio
	 */
	public Time buscarTimeNome(String nome){
		for (int i = 0; i < timesAcompanhados.size(); i++){
			if (nome.equals(timesAcompanhados.get(i).getNome())){
				return timesAcompanhados.get(i);
			}
		}return new Time("");
	}
	
	public ArrayList<Partida> getPartidas() {
		return partidas;
	}


	public void setPartidas(ArrayList<Partida> partidas) {
		this.partidas = partidas;
	}
	
	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public ArrayList<Time> getTimesAcompanhados() {
		return timesAcompanhados;
	}

	public void setTimesAcompanhados(ArrayList<Time> timesAcompanhados) {
		this.timesAcompanhados = timesAcompanhados;
	}

}
