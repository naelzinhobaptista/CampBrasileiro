package model;

/**@author Elizio Nael
 * Classe responsável por guardar as informações de um jogador
 * 
 */
public class Jogador {
	private String nome;
	private String numero;
	private String posicao;
	
	/**@author Elizio e Nael
	 * Método construtor da classe Jogador
	 *  
	 */
	public Jogador(String nome, String numero, String posicao) {
		this.nome = nome;
		this.numero = numero;
		this.posicao = posicao;
	}
	
	/**@author Elizio e nael
	 * Métodos getters e setters
	 * 
	 */
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
