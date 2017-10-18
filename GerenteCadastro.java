package controller;

import java.util.ArrayList;
import model.Torcedor;

/**
 * @author Elizio e Nael
 * Classe respons�vel por gerenciar todos os cadastros
 */

public class GerenteCadastro {
	
private ArrayList<Torcedor> usuarios;
	
	/**
	 * @author Elizio e Nael
	 * Construtor da classe
	 */
	public GerenteCadastro(){
		usuarios = new ArrayList<Torcedor>();
	}
	/**
	 * @author Elizio e Nael
	 * M�todo que recebe um nome e faz uma busca pelo nome na lista de usuarios
	 * caso encontre retorna o �ndice do usuario na lista
	 * caso contr�rio retorna -1
	 */
	public int buscarUsuario(String nome){
		for(int i = 0; i<usuarios.size(); i++){
			if(nome.equals(usuarios.get(i).getNome().equals(nome))){
				return i;
			}
		}return -1;
	}
	/**
	 * @author Elizio e Nael
	 * M�todo que recebe um usuario e o adiciona na lista de usu�rio
	 */
	public void adicionarUsuario(Torcedor usuario){
		usuarios.add(usuario);
	}
	public ArrayList<Torcedor> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayList<Torcedor> usuarios) {
		this.usuarios = usuarios;
	}

}
