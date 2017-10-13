package controller;

import model.Tabela;
import model.Time;
import model.Jogador;
import model.Partida;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Partida;

/**@author Elizio e Nael
 * Classe reponsável por gerenciar a tabela e fazer o processamento dos dados
 */
public class GerentePartidas {
	private Tabela tabela;
	
	/**@author Elzio e Nael
	 * Método construtor do GerenrentePartidas
	 * 
	 */
	public GerentePartidas(Tabela tabela) {
		this.tabela = tabela;
	}
	
	/**@author Elizio e Nael
	 * Método que recebe o nome do time e busca as partidas jogadas por ele e as exibe.
	 * 
	 */
	public void listarPartidas(String nome) {
		for (int i = 0; i<tabela.getPartidas().size(); i++) {
			if(tabela.getPartidas().get(i).getTime_da_casa().getNome().equals(nome)) {
				Time ganhador;
				if(tabela.getPartidas().get(i).getGols_da_da_casa() > tabela.getPartidas().get(i).getGols_do_visitabte()) {
					ganhador = tabela.getPartidas().get(i).getTime_da_casa();
				}else {
					ganhador = tabela.getPartidas().get(i).getTime_visitande();
				}
				JOptionPane.showMessageDialog(null,"Vitoria do "+ganhador.getNome()+"\n Placar da Partida:\n "
				+tabela.getPartidas().get(i).getTime_da_casa().getNome()+" "+tabela.getPartidas().get(i).getGols_da_da_casa()
				+" x "+ tabela.getPartidas().get(i).getGols_do_visitabte()+" "+tabela.getPartidas().get(i).getTime_visitande().getNome());
				JOptionPane.showInputDialog(null,"Pressione OK para seguir com o gerenciamento ou ver mais resultados!");
				
			}
		}
		
	}
	
	/**@author Elizio e Nael
	 * Método que recebe um partida e a adiciona a lista de partidas
	 * 
	 */
	public void adicionarPartida(Partida partida){
		tabela.adicionar_partida(partida);
	}
	
	/**@author Elizio e Nael
	 * Metodo em fase de construção, será emplementado em mudanças futuras
	 * 
	 */
	public void adicionarEscalacao(Tabela tabela, Time time){
		boolean cont = true;
		while (cont) {
			Jogador jogador = new Jogador(JOptionPane.showInputDialog("Digite o nome do jogador: "),
					JOptionPane.showInputDialog("Digite o numero do jogador"),
					JOptionPane.showInputDialog("Digite a função: "));
			time.adicionarJogar(jogador);
		}
	
	}	
	
	/**@author Elizio e Nael
	 * Método que recebe uma String com o nome do time e busca todas as suas 
	 * aparições na tabela, ligadas a e partidas somando as estatisticas
	 * 
	 */
	public void mostrarStatistica(String nome) {
		int vitoria = 0;
		int empate = 0;
		int derrota = 0;
		for (int i = 0; i<tabela.getPartidas().size(); i++){
			if(tabela.getPartidas().get(i).getTime_da_casa().getNome().equals(nome)) {
				if (tabela.getPartidas().get(i).getGols_da_da_casa() > tabela.getPartidas().get(i).getGols_do_visitabte()) {
					vitoria++;
				}
				else if(tabela.getPartidas().get(i).getGols_da_da_casa() == tabela.getPartidas().get(i).getGols_do_visitabte()) {
					empate++;
				}
				else if(tabela.getPartidas().get(i).getGols_da_da_casa() < tabela.getPartidas().get(i).getGols_do_visitabte()) {
					derrota++;
				}
			}
		}
		
		JOptionPane.showMessageDialog(null,"Time: "+ nome+"\nVitorias: "+ vitoria+"\nEmpates: "+ empate+ "\nDerrotas: "+ derrota);
	}
	
	/**@author Elizio e Nael
	 * Mostra os pontos do time.
	 * 
	 */
	public void mostrarPontos(String nome){
		int vitoria = 0;
		int impat = 0;
		int derrota = 0;
		int pontos = 0;
		
		for (int i = 0; i<tabela.getPartidas().size(); i++){
			if(tabela.getPartidas().get(i).getTime_da_casa().getNome().equals(nome)) {
				if (tabela.getPartidas().get(i).getGols_da_da_casa() > tabela.getPartidas().get(i).getGols_do_visitabte()) {
					pontos = pontos + 3;
				}else if(tabela.getPartidas().get(i).getGols_da_da_casa() == tabela.getPartidas().get(i).getGols_do_visitabte()) {
					pontos = pontos + 1;
				}
			}
		}
		JOptionPane.showMessageDialog(null,"Time: "+nome+ "\nPontos: "+ pontos);

	}
	
	/**@author Elizio e Nael
	 * Método em construção, será implementado em mudanças futuras.
	 * 
	 */
	public Time mostrarEscalacao(String nome) {
		Time time = null;
		for (int i = 0;i<tabela.getTimesRegistrados().size(); i++) {
			if(tabela.getTimesRegistrados().get(i).getNome().equals(nome)) {
				time = tabela.getTimesRegistrados().get(i);
			}
		}return time;
	}
	
	/**@author Elizio e Nael
	 * Método em construção, será implementado em mudanças futuras.
	 * 
	 */
	public void cadastrarEscalacao(Jogador jogador, String nome){
		for (int i = 0; i<tabela.getTimesRegistrados().size();i++) {
			if(nome.equals(tabela.getTimesRegistrados().get(i).getNome())) {
				tabela.getTimesRegistrados().get(i).getJogadores().add(jogador);
			}
		}
	}
	
}
