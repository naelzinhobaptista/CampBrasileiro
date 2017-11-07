		package controller;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import model.Cliente;
import model.Jogador;
import model.Partida;
import model.Time;
import model.Torcedor;

/**
 * @author Elizio e Nael
 * Classe em que � implementado o padr�o facade, ele instancia as classes
 * e faz uso dos m�todos de todas as outras do pacote controler
 */
public class GerenteGeral implements Observer{
	
	private GerenteCadastro gerenteCad;
	private GerenteCampeonato gerentecamp;
	private GerenteLogin gerenteLog;
	private GerenteArquivo gerenteArq;
	
	/**
	 * @author Elizio e Nael
	 * Construtor da classe
	 */
	public GerenteGeral(){
		gerenteCad = new GerenteCadastro();
		gerentecamp = new GerenteCampeonato();
		gerenteLog = new GerenteLogin();
		gerenteArq = new GerenteArquivo();
	}
	/**
	 * @author Elizio e Nael
	 * M�todo que recebe um torcedor e chama os m�todos buscarUsuario e adicionarUsuario da classe
	 * GerenteCadastro, chamando tamb�m o pr�prio m�todo cadastrarTime
	 */
	public void cadastrarUsuario(Torcedor user){
		if(gerenteCad.buscarUsuario(user.getNome()) == -1){
			gerenteCad.adicionarUsuario(user);
			cadastrarTime(user.getTime());
		}
	}
	
	/**
	 * @author Elizio e Nael
	 * M�todo que recebe um login e uma senha, chama os m�todos verificaLogin para verificar se a senha e login
	 * batem com algumas j� cadastradas, caso existam, ele insere o usu�rio correspondente a senha e login
	 * em usu�rio logado que est� na classe login, depois, masca a booleana logado como true e adiciona 
	 * o time do usuario, em seguida retona true, caso a senha e login n�o batam retorna false
	 */
	public boolean logar(String login, String senha){
		int user = gerenteLog.verificaLogin(login, senha, gerenteCad.getUsuarios());
		if(user > -1){
			gerenteLog.setUsuarioLogado((Torcedor)gerenteCad.getUsuarios().get(user));
			((Torcedor) gerenteLog.getUsuarioLogado()).adicionarObservador(this);
			gerenteLog.setLogado(true);
			gerentecamp.setTimesCadastrados(carregarTimes());
			int timeint = gerentecamp.buscarTimeNome(gerenteCad.getUsuarios().get(user).getTime().getNome());
			System.out.println(timeint);
			((Torcedor) gerenteLog.getUsuarioLogado()).getTime().setEscalacao(gerentecamp.getTimesCadastrados().get(timeint).getEscalacao());
			//gerentecamp.getTimesCadastrados().add((((Torcedor) gerenteLog.getUsuarioLogado()).getTime()));
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * @author Elizio e Nael
	 * M�todo que recebe um jogador e um torcedor, chama o m�todo da classe GerenteCampeonato, buscarJogador e 
	 * caso ele n�o encontre nenhum jogador com este nome, ele adiciona a lista de jogadores que est� 
	 * no time do usu�rio
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
	 * M�todo respo�vel por retornar o resultado do m�todo calcularScore da classe GerenteCampeonato
	 * gerando o score de vit�ria, empates e derrotas do time com aquele nome
	 */
	public int[] gerarScore(String nome){
		return gerentecamp.calcularScore(nome);
	}
	
	/**
	 * @author Elizio e Nael
	 * M�todo que recebe um time, caso ele n�o exista na lista de times cadastrados, o adiciona
	 */
	public void cadastrarTime(Time time){
		if(gerentecamp.buscarTimeNome(time.getNome()) == -1){
			gerentecamp.adicionarTime(time);
		}
	}
	
	public void salvarTimes(ArrayList<Time> times){
		ArrayList<String> timesEscrever = gerenteArq.formatarTimeEscrever(times);
		//System.out.println(timesEscrever.toString());
		gerenteArq.escrever(timesEscrever, "Times.txt");
	}
	
	public ArrayList<Time> carregarTimes(){
		ArrayList<Time> times = gerenteArq.formartarTimesLer(gerenteArq.ler("Times.txt"));
		return times;
	}
	
	public void salvarTorcedor(ArrayList<Torcedor> usuarios){
		ArrayList<String> userEscrever = gerenteArq.formatarUsuariosEscrever(usuarios);
		gerenteArq.escrever(userEscrever, "Usuarios.txt");
	}
	
	public ArrayList<Torcedor> carregarTorcedor(){
		ArrayList<Torcedor> torcedores = gerenteArq.formatarUsuariosLer(gerenteArq.ler("Usuarios.txt"));
		return torcedores;
	}
	
	public void salvarPartidas(ArrayList<Partida> partidas){
		ArrayList<String> partidasEscrever = gerenteArq.formatarPartidasEscreve(partidas);
		gerenteArq.escrever(partidasEscrever, "Partida.txt");
	}
	
	public ArrayList<Partida> carregarPartidas(){
		ArrayList<Partida> partidas = gerenteArq.formatarPartidasLer(gerenteArq.ler("Partida.txt"));
		return partidas;
	}
	
	public void deslogar(){
		//System.out.println(gerentecamp.getTimesCadastrados().get(0).getNome());
		int timeIndex = gerentecamp.buscarTimeNome(((Torcedor) gerenteLog.getUsuarioLogado()).getTime().getNome());
		//System.out.println(gerentecamp.getTimesCadastrados().size());
		if(timeIndex > -1){
			gerentecamp.getTimesCadastrados().get(timeIndex).setEscalacao(((Torcedor) gerenteLog.getUsuarioLogado()).getTime().getEscalacao());;
			salvarTimes(gerentecamp.getTimesCadastrados());
		}
		
	}
	public String[] imprimeTabela(String nome){
		return gerentecamp.gerarTabela(nome, gerentecamp.getTabela().getPartidas());
	}
	
	public GerenteCadastro getGerenteCad(){
		return gerenteCad;
	}

	public void setGerenteCad(GerenteCadastro gerenteCad) {
		this.gerenteCad = gerenteCad;
	}

	public GerenteCampeonato getGerentecamp() {
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

	public GerenteArquivo getGerenteArq() {
		return gerenteArq;
	}

	public void setGerenteArq(GerenteArquivo geremteArq) {
		this.gerenteArq = geremteArq;
	}
	
	public void update(Observable torceInfSubject, Object arg1) {
		if(torceInfSubject instanceof Cliente){
			Torcedor torcedor = (Torcedor) torceInfSubject;
			gerenteCad.getUsuarios().remove(gerenteCad.buscarLogin(torcedor.getLogin()));
			gerenteCad.getUsuarios().add(torcedor);
			salvarTorcedor(gerenteCad.getUsuarios());
			
		}
		
	}

}
