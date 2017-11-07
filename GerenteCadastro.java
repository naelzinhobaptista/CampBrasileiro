package controller;

import java.util.ArrayList;
import model.Torcedor;

/**
 * @author Elizio e Nael
 * Classe responsável por gerenciar os cadastros
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
	 * Método que recebe um nome e faz a busca pelo nome na lista de usuários caso 
	 * encontre retorna o índice do usuário na lista, caso contrário retorna -1
	 */
	public int buscarUsuario(String nome){
		for(int i = 0; i<usuarios.size(); i++){
			if(nome.equals(usuarios.get(i).getNome().equals(nome))){
				System.out.println("aqui");
				return i;
			}
		}return -1;
	}
	
	public int buscarLogin(String login){
		for(int i = 0; i<usuarios.size(); i++){
			if(login.equals(usuarios.get(i).getLogin())){
				return i;
			}
		}return -1;
	}
	/**
	 * @author Elizio e Nael
	 * Método que recebe um usuário e o adiciona na lista de usuários
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
