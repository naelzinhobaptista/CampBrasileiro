package controller;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Partida;
import model.Time;
import model.Torcedor;
import model.Jogador;

/**
 * @author Elizio e Nael
 * Classe responsável por gravar, formatar, recuperar e remontar os dados do sistema.
 */

public class GerenteArquivo {
	
	/**
	 * @author Elizio e Nael
	 * 
	 */
	public void escrever(ArrayList<String> conteudo, String nomeDoArquivo){
		try{
			FileOutputStream arquivo = new FileOutputStream(nomeDoArquivo);
			PrintWriter pr = new PrintWriter(arquivo);
			for(int i = 0; i<conteudo.size();i++){
				pr.println(conteudo.get(i));
			}
			pr.close();
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Erro ao salvar o arquivo");
		}
	}
	public ArrayList<String> ler(String nomeDoArquivo){
		ArrayList<String> lista = new ArrayList<>();
		try{
			FileInputStream arquivo = new FileInputStream(nomeDoArquivo);
			InputStreamReader input = new InputStreamReader(arquivo);
			BufferedReader br = new BufferedReader(input);
			String linha;
			do{
				linha = br.readLine();
				if (linha != null){
					lista.add(linha);
					
				}
			}while (linha != null);
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Erro ao carregar o arquivo");
		}
		return lista;
	}
	
	public ArrayList<String> formatarTimeEscrever(ArrayList<Time> times){
		ArrayList<String> timesSalvar = new ArrayList<String>();
		for(int i =0;i<times.size();i++){
			String time = new String();
			time =times.get(i).getNome()+"/";
			
			for(int e = 0;e<times.get(i).getEscalacao().size();e++){
				time+=(times.get(i).getEscalacao().get(e).getNome()
						+","+times.get(i).getEscalacao().get(e).getNumero()
						+","+times.get(i).getEscalacao().get(e).getPosicao()+";");
			}
			timesSalvar.add(time);
								
		}	
		return timesSalvar;
	}
	public ArrayList<Time> formartarTimesLer(ArrayList<String> linha){
		ArrayList<Time> times = new ArrayList<Time>();
		for(int i = 0; i< linha.size(); i++){
			String[] atributos = linha.get(i).split("/");
			Time time = new Time(atributos[0]);
			if(atributos.length > 1){
				String[] escalacao = atributos[1].split(";");
				for(int e = 0; e<escalacao.length;e++){
					String[] esctime = escalacao[e].split(",");
					time.getEscalacao().add(new Jogador(esctime[0], esctime[1], esctime[2]));
					
				}
			}
			
			times.add(time);
			}
		return times;
		}
	
	public ArrayList<String> formatarPartidasEscreve(ArrayList<Partida> partidas){
		ArrayList<String> textoParaSalvar = new ArrayList<String>();
		for(int i = 0;i<partidas.size();i++){
			textoParaSalvar.add(partidas.get(i).getTime_da_casa().getNome()+" ; "+
					partidas.get(i).getGols_casa()
					+" ; "+partidas.get(i).getTime_visitante().getNome()
					+" ; "+partidas.get(i).getGols_visitante());
		}return textoParaSalvar;
	}
	
	public ArrayList<Partida> formatarPartidasLer(ArrayList<String> linha){
		ArrayList<Partida> partidas = new ArrayList<Partida>();
		for(int i=0;i<linha.size();i++){
			String[] atributos = linha.get(i).split(" ; ");
			Partida partida = new Partida(new Time(atributos[0]),new Time(atributos[2]), Integer.parseInt(atributos[1]),Integer.parseInt(atributos[3]));
			partidas.add(partida);
		}
		return partidas;
		
	}
	
	public ArrayList<String> formatarUsuariosEscrever(ArrayList<Torcedor> torce){
		ArrayList<String> torcedores = new ArrayList<String>();
		for(int i = 0; i<torce.size();i++){
			torcedores.add(torce.get(i).getNome()+" ; "+torce.get(i).getLogin()+" ; "+torce.get(i).getSenha()+" ; "
			+torce.get(i).getTime().getNome());
		}return torcedores;
	}
	
	public ArrayList<Torcedor> formatarUsuariosLer(ArrayList<String> linha){
		ArrayList<Torcedor> torcedores = new ArrayList<Torcedor>();
		for(int i=0;i<linha.size();i++){
			String[] atributos = linha.get(i).split(" ; ");
			torcedores.add(new Torcedor(atributos[0], atributos[1], atributos[2], new Time(atributos[3])));
		}return torcedores;
		
	}

}
