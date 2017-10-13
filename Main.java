package view;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import controller.GerentePartidas;
import model.Jogador;
import model.Partida;
import model.Tabela;
import model.Time;

public class Main {
	
	/**@autor Elizio e Nael
	 * Classe principal
	 * 
	 */
	private static GerentePartidas gerente = new GerentePartidas(new Tabela());
	
	/**@autor Elizio e Nael
	 * Método principal
	 * 
	 */
	public static void main(String args[]){
		
		boolean continua = true;
		while (continua) {
			
			String menu = JOptionPane.showInputDialog("1- Adicionar Partida\n2- Ver Resultado das partidas\n"
					+ "3- Estatísticas do time\n4- Quantidade de pontos\n5- Sair");
			
			if(menu.equals("1")) {
				String timeDaCasa = JOptionPane.showInputDialog("Informe seu time: ");
				int golsc = Integer.parseInt(JOptionPane.showInputDialog("Quantos gols o "+timeDaCasa+" marcou?"));
				String timeVisitante = JOptionPane.showInputDialog("Informe o time adversário: ");
				int golsv = Integer.parseInt(JOptionPane.showInputDialog("Quantos gols o "+timeVisitante+" marcou?"));
				Partida partida = new Partida(new Time(timeDaCasa), new Time(timeVisitante), golsc, golsv);
				gerente.adicionarPartida(partida);
			}
			
			else if(menu.equals("2")) {
				gerente.listarPartidas(JOptionPane.showInputDialog("Digite o nome do time: "));
			}
			
			else if(menu.endsWith("3")) {
				gerente.mostrarStatistica(JOptionPane.showInputDialog("Digite o nome do time: "));
			}
			
			else if(menu.equals("4")){
				gerente.mostrarPontos(JOptionPane.showInputDialog("Digite o nome do time: "));
			}
			
			else if(menu.equals("5")){
				JOptionPane.showMessageDialog(null, "Obrigado por utilizar o sistema de gerenciamento"
						+ " de estatísticas do seu time no Brasileirão, volte sempre!");
				
				continua = false;
			}
			
			//else if(menu.equals("aaaaaa")) {
			//  String nomeTime = JOptionPane.showInputDialog("Digite o nome do time");
			//  for (int i=0;i<11;i++) {
		    //  	Jogador jogador = new Jogador(JOptionPane.showInputDialog("Digite o nome do jogador"),
			//			JOptionPane.showInputDialog("Digite o numero"),
			//				JOptionPane.showInputDialog("Digite a posição: "));
			//				gerente.cadastrarEscalacao(jogador, nomeTime);
			// }
		    // else if(menu.equals("aaaaaa")) {
			// 	String nomeTime = JOptionPane.showInputDialog("Digite o nome do time");
			//	Time time = gerente.mostrarEscalacao(nomeTime);
			//	for (int i = 0; i<11; i++) {
			//  JOptionPane.showInputDialog("Jogadores: "+ time.getJogadores().get(0).getNome()+ "Numero: "+ time.getJogadores().get(0).getNumero()+ "Psição: "+ time.getJogadores().get(0)
	        //				+time.getJogadores().get(1).getNome()+ "Numero: "+ time.getJogadores().get(1).getNumero()+ "Psição: "+ time.getJogadores().get(1)
	        //				+time.getJogadores().get(2).getNome()+ "Numero: "+ time.getJogadores().get(2).getNumero()+ "Psição: "+ time.getJogadores().get(2)
	        //				+time.getJogadores().get(3).getNome()+ "Numero: "+ time.getJogadores().get(3).getNumero()+ "Psição: "+ time.getJogadores().get(3)
	        //				+time.getJogadores().get(4).getNome()+ "Numero: "+ time.getJogadores().get(4).getNumero()+ "Psição: "+ time.getJogadores().get(4)
	        //				+time.getJogadores().get(5).getNome()+ "Numero: "+ time.getJogadores().get(5).getNumero()+ "Psição: "+ time.getJogadores().get(5)
	        //				+time.getJogadores().get(6).getNome()+ "Numero: "+ time.getJogadores().get(6).getNumero()+ "Psição: "+ time.getJogadores().get(6)
	        //				+time.getJogadores().get(7).getNome()+ "Numero: "+ time.getJogadores().get(7).getNumero()+ "Psição: "+ time.getJogadores().get(7)
	        //				+time.getJogadores().get(8).getNome()+ "Numero: "+ time.getJogadores().get(8).getNumero()+ "Psição: "+ time.getJogadores().get(8)
	        //				+time.getJogadores().get(9).getNome()+ "Numero: "+ time.getJogadores().get(9).getNumero()+ "Psição: "+ time.getJogadores().get(9)
	        //				+time.getJogadores().get(10).getNome()+ "Numero: "+ time.getJogadores().get(10).getNumero()+ "Psição: "+ time.getJogadores().get(10));
	        //	}
	        //}
		}
	}

}
