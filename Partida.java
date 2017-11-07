package model;

/**
 * @author Elizio e Nael
 * Classe que representa uma partida
 */

public class Partida {
	private Time time_da_casa;
	private Time time_visitante;
	private int gols_casa;
	private int gols_visitante;
	private String resultado;
	
	/**
	 * @author Elizio e Nael
	 * Construtor da clsse
	 */
	public Partida(Time timec, Time timev, int gc, int gv){
		this.time_da_casa = timec;
		this.time_visitante = timev;
		this.gols_casa = gc;
		this.gols_visitante = gv;
		
		if (gc > gv){
			this.resultado = "Vitória de: "+gc;
		}
		else if(gc == gv){
			this.resultado = "Empate";
		}
		else if(gc < gv){
			this.resultado = "Vitória de: "+gv;
		}
	}
	
	public Time getTime_da_casa() {
		return time_da_casa;
	}

	public void setTime_da_casa(Time time_da_casa) {
		this.time_da_casa = time_da_casa;
	}

	public Time getTime_visitante() {
		return time_visitante;
	}

	public void setTime_visitante(Time time_visitante) {
		this.time_visitante = time_visitante;
	}

	public int getGols_casa() {
		return gols_casa;
	}

	public void setGols_casa(int gols_casa) {
		this.gols_casa = gols_casa;
	}

	public int getGols_visitante() {
		return gols_visitante;
	}

	public void setGols_visitante(int gols_visitante) {
		this.gols_visitante = gols_visitante;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

}
