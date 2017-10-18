package model;

/**
 * @author Elizio e Nael
 * Classe que representa um jogador
 * 
 */

public class Jogador {
	private String nome;
	private String numero;
	private String posicao;
	/**
	 * @author Elizio e Noel
	 * Construtor da classe
	 */
	public Jogador(String nome, String numero, String posicao){
		this.nome = nome;
		this.numero = numero;
		this.posicao = posicao;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getPosicao() {
		return posicao;
	}
	public void setPosicao(String posicao) {
		this.posicao = posicao;
	}

}
