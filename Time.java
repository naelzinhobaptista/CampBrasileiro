package model;

import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * @author Elizio e Nael
 * Classe que representa um time
 */
public class Time implements Serializable{
	private String nome;
	private ArrayList<Jogador> escalacao;
	
	public Time(String nome){
		this.nome = nome;
		setEscalacao(new ArrayList<Jogador>());
	}
	
	/**
	 * @author Elizio e Nael
	 * Método que recebe um jogador e verifica se ele já existe na lista,
	 * caso exista, retorna o índice da lista em que ele se encontra
	 */
	public int encontrarJogador(Jogador jogador){
		for (int i = 0; i < escalacao.size();i++){
			if(escalacao.get(i).equals(jogador)){
				return  i;
			}
		}return -1;
	}
	
	/**
	 * @author Elizio e Nael
	 * Método que recebe um jogador, caso ainda não esteja na lista, adiciona-o,
	 * caso contrario exibe uma mensagem
	 */
	public void adicionarJogador(Jogador jogador){
		if(encontrarJogador(jogador) == -1){
			JOptionPane.showMessageDialog(null, "Este jogador j� existe!");
		}else{
			escalacao.add(jogador);
		}
	}

	public ArrayList<Jogador> getEscalacao() {
		return escalacao;
	}

	public void setEscalacao(ArrayList<Jogador> escalacao) {
		this.escalacao = escalacao;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
