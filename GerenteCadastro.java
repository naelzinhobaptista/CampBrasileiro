package controller;

import java.util.ArrayList;
import model.Torcedor;

/**
 * @author Elizio e Nael
 * Classe respons�vel por gerenciar os cadastros
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
	 * M�todo que recebe um nome e faz a busca pelo nome na lista de usu�rios caso 
	 * encontre retorna o �ndice do usu�rio na lista, caso contr�rio retorna -1
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
	 * M�todo que recebe um usu�rio e o adiciona na lista de usu�rios
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
