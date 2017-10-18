package controller;

import java.lang.reflect.Array;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Jogador;
import model.Partida;
import model.Time;
import model.Torcedor;
import model.Usuario;

/**
 * @author Elizio e Nael
 * Classe em que é implementado o padrão facade
 * ele instacia as classes e faz uso dos metodo de todas as outras classes do pacote controler
 */

public class GerenteGeral {
	
	private GerenteCadastro gerenteCad;
	private GerenteCampeonato gerentecamp;
	private GerenteLogin gerenteLog;
	/*private GerenteArquivo geremteArq;
*/	
	/**
	 * @author Elizio e Noel
	 * Construtor da classe
	 */
	public GerenteGeral(){
		gerenteCad = new GerenteCadastro();
		gerentecamp = new GerenteCampeonato();
		gerenteLog = new GerenteLogin();
		/*setGeremteArq(new GerenteArquivo());*/
	}
	/**
	 * @author Elizio e Noel
	 * Metodo que recebe um torcedor e chama os metodos buscarUsuario e adicionar usuario da classe GerenteCadastro
	 * e tambem chama o proprio metodo cadastrarTime
	 */
	public void cadastrarUsuario(Torcedor user){
		if(gerenteCad.buscarUsuario(user.getNome()) == -1){
			gerenteCad.adicionarUsuario(user);
			cadastrarTime(user.getTime());
		}
	}
	/**
	 * @author Elizio e Noel
	 * Metodo que recebe um login e uma senha, ele chama os metodos verifica login para verificar para verificar se
	 * a senha/login batem com alguma das senha e logins que estão cadastradas, caso bata, ele insere o usuario correspondente
	 * a senha/login em usuario logado que esta na classe login, depois, masca a booleana logado como true e adiciona o time do usuario
	 * depois disto retona true, caso a senha/login não batam retorna false
	 */
	public boolean logar(String login, String senha){
		int user = gerenteLog.verificaLogin(login, senha, gerenteCad.getUsuarios());
		if(user > -1){
			gerenteLog.setUsuarioLogado((Torcedor)gerenteCad.getUsuarios().get(user));
			gerenteLog.setLogado(true);
			gerentecamp.getTabela().setTime(((Torcedor) gerenteLog.getUsuarioLogado()).getTime());
			return true;
		}else{
			return false;
		}
	}
	/**
	 * @author Elizio e Noel
	 * Metodo que recebe um jogador e um torcedo, ele chama o metodo de GerenteCampeonato buscarJogador e caso ele
	 * não encontre nenhum jogador este nome ele adiciona a lista de jogadores que esta no time do ususario
	 */
	public boolean adicionarJogador(Jogador jogador, Torcedor user){
		int jogadorNumero = gerentecamp.buscarJogador(jogador, user);
		if(jogadorNumero == -1){
			gerentecamp.adicionarJogador(jogador, user);
			return true;
		}else{
			return false;
		}
	}
	/**
	 * @author Elizio e Nael
	 * Metodo que apenas retorna o resultado do metodo calcularScore da classe GerenteCampeonato
	 * gerando o score de vitoria, empates e derrotas do time com aquele nome
	 */
	public int[] gerarScore(String nome){
		return gerentecamp.calcularScore(nome);
	}
	/**
	 * @author Elizio e Nael
	 * Método que recebe um time, caso ele não exista na lista de times cadastrados o adiciona
	 */
	public void cadastrarTime(Time time){
		if(gerentecamp.buscarTimeNome(time.getNome()) == -1){
			gerentecamp.adicionarTime(time);
		}
	}
	
	/*public void salvarTimes(ArrayList<Time> times){
		ArrayList<String> timesEscrever = geremteArq.formatarTimeEscrever(times);
		geremteArq.escrever(timesEscrever, "Times.txt");
	}
	public ArrayList<Time> carregarTimes(){
		ArrayList<Time> times = geremteArq.formartarTimesLer(geremteArq.ler("Times.txt"));
		System.out.println(times.size());
		return times;
	}
	public void salvarPartidas(ArrayList<Partida> partidas){
		ArrayList<String> partidasEscrever = geremteArq.formatarPartidasEscreve(partidas);
		geremteArq.escrever(partidasEscrever, "Partida.txt");
	}
	public ArrayList<Partida> carregarPartidas(){
		ArrayList<Partida> partidas = geremteArq.formatarPartidasLer(geremteArq.ler("Partida.txt"));
		return partidas;
	}*/
	public GerenteCadastro getGerenteCad(){
		return gerenteCad;
	}

	public void setGerenteCad(GerenteCadastro gerenteCad) {
		this.gerenteCad = gerenteCad;
	}

	public GerenteCampeonato getGerenteCamp() {
		return gerentecamp;
	}

	public void setGerentecamp(GerenteCampeonato gerentecamp) {
		this.gerentecamp = gerentecamp;
	}
	public GerenteLogin getGerenteLog() {
		return gerenteLog;
	}

	public void setGerenteLog(GerenteLogin gerenteLog) {
		this.gerenteLog = gerenteLog;
	}

	/**public GerenteArquivo getGeremteArq() {
		return geremteArq;
	}

	public void setGeremteArq(GerenteArquivo geremteArq) {
		this.geremteArq = geremteArq;
	}
**/

}
