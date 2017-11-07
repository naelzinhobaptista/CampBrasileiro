package controller;

import java.util.ArrayList;

import model.Jogador;
import model.Partida;
import model.Tabela;
import model.Time;
import model.Torcedor;

/**
 * @author Elizio e Nael
 * Classe reponsável por armazenar os métodos e as variáveis nessesárias 
 * para gerir as partidas do campeonato
 */
public class GerenteCampeonato {
	
	private Tabela tabela;
	private ArrayList<Time> timesCadastrados;
	
	public Tabela getTabela() {
		return tabela;
	}
	
	/**
	 * @author Elizio e Nael
	 * Construtor da classe
	 */
	public GerenteCampeonato(){
		tabela = new Tabela();
		timesCadastrados = new ArrayList<Time>();
	}
	
	/**
	 * @author Elizio e Nael
	 * Método que recebe um time e o insere na lista de times cadastrados
	 */
	public void adicionarTime(Time time){
		timesCadastrados.add(time);
	}
	
	/**
	 * @author Elizio e Nael
	 * Método que recebe uma string com o nome do time e faz uma busca por este na lista de times
	 * cadastrados, caso encontre retorna o índice em que o time se encontra na lista, caso contrário 
	 * retorna -1
	 */
	public int buscarTimeNome(String nome){
		for(int i = 0; i<timesCadastrados.size();i++){
			if(timesCadastrados.get(i).getNome().equals(nome)){
				return i;
			}
		}return -1;
	}
	
	/**
	 * @author Elizio e Nael
	 * Método que recebe um jogador e um torcedor e faz uma busca na escalação do time do torcedor,
	 * caso encontre retorna o índice da lista em que o jogador se encontra caso contrário retorna -1
	 */
	public int buscarJogador(Jogador jogador, Torcedor user){
		for(int i = 0; i<user.getTime().getEscalacao().size();i++){
			if(user.getTime().getEscalacao().get(i).equals(jogador)){
				return i;
			}
		}return -1;
	}
	
	/**
	 * @author Elizio e Nael
	 * Método que recebe um jogador e um torcedor e adiciona o jogador na escalação do time do torcedor
	 */
	public void adicionarJogador(Jogador jogador, Torcedor user){

			user.getTime().getEscalacao().add(jogador);	
	}
	
	/**
	 * @author Elizio e Nael
	 * Método que recebe o nome do time e procura por partidas deste time na lista de partidas depois 
	 * computa a quantidade de vitórias, empates e derrotas, retorna-os na forma de um array 
	 * com 3 posições
	 */
	public int[] calcularScore(String nome){
		int v = 0;
		int p = 0;
		int d = 0;
		Time time = timesCadastrados.get(buscarTimeNome(nome));
		for (int i = 0;i<tabela.getPartidas().size();i++){
			if(tabela.getPartidas().get(i).getTime_da_casa().getNome().equals(nome)){
				if(tabela.getPartidas().get(i).getGols_casa() > tabela.getPartidas().get(i).getGols_visitante()){
					v++;
				}else if(tabela.getPartidas().get(i).getGols_casa() < tabela.getPartidas().get(i).getGols_visitante()){
					d++;
				}else{
					p++;
				}
				
			}else if(tabela.getPartidas().get(i).getTime_visitante().getNome().equals(nome)){
				if(tabela.getPartidas().get(i).getGols_casa() > tabela.getPartidas().get(i).getGols_visitante()){
					d++;
				}else if(tabela.getPartidas().get(i).getGols_casa() < tabela.getPartidas().get(i).getGols_visitante()){
					v++;
				}else{
					p++;
				}
				
			}
		}int[] resultado = new int[4];
		resultado[0]=v;
		resultado[1]=p;
		resultado[2]=d;
		return  resultado;
		
	}
	
	public String[] gerarTabela(String nome, ArrayList<Partida> partidas){
		ArrayList<String> partidasTime = new ArrayList<String>();
		for(int i = 0; i<partidas.size();i++){
			if(partidas.get(i).getTime_da_casa().getNome().equals(nome) | partidas.get(i).getTime_visitante().getNome().equals(nome)){
				partidasTime.add(partidas.get(i).getTime_da_casa().getNome()+" "+partidas.get(i).getGols_casa()+
						" x "+partidas.get(i).getGols_visitante()+" "+partidas.get(i).getTime_visitante().getNome());
			}
			
		}String[] listaFinal = new String[partidasTime.size()];
		for(int e = 0; e<partidasTime.size();e++){
			listaFinal[e] = partidasTime.get(e);
		}return listaFinal;
	}
	
	public void adicionarJogador(String nometime){
		
	}
	
	public void setTabela(Tabela tabela) {
		this.tabela = tabela;
	}

	public ArrayList<Time> getTimesCadastrados() {
		return timesCadastrados;
	}

	public void setTimesCadastrados(ArrayList<Time> timesCadastrados) {
		this.timesCadastrados = timesCadastrados;
	}

}
