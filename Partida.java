package model;

/**@author Elizio e Nael
 * Classe responsável por guardar os dados das partidas
 * 
 */
public class Partida {
	private Time time_da_casa;
	private Time time_visitande;
	private int gols_da_da_casa, gols_do_visitabte;
	
	/**@author Elizio e nael
	 * Método construtor da classe partida
	 * 
	 */
	public Partida(Time timec, Time timev, int gc, int gv) {
		this.time_da_casa = timec;
		this.time_visitande = timev;
		this.setGols_da_da_casa(gc);
		this.gols_do_visitabte = gv;
	}
	
	/**@author Elizio e nael
	 * Métodos getters e setters
	 * 
	 */
	public Time getTime_da_casa() {
		return time_da_casa;
	}
	public void setTime_da_casa(Time time_da_casa) {
		this.time_da_casa = time_da_casa;
	}
	public Time getTime_visitande() {
		return time_visitande;
	}
	public void setTime_visitande(Time time_visitande) {
		this.time_visitande = time_visitande;
	}
	public int getGols_do_visitabte() {
		return gols_do_visitabte;
	}
	public void setGols_do_visitabte(int gols_do_visitabte) {
		this.gols_do_visitabte = gols_do_visitabte;
	}
	public int getGols_da_da_casa() {
		return gols_da_da_casa;
	}
	public void setGols_da_da_casa(int gols_da_da_casa) {
		this.gols_da_da_casa = gols_da_da_casa;
	}

}
