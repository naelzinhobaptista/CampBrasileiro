package model;

public interface Usuario {
	
	/**
	 * @author Elizio e Nael
	 * Interface usada para representar um usuário genérico
	 */
	public String getNome();
	public void setNome(String nome);
	public String getLogin();
	public void setLogin(String login);
	public String getSenha();
	public void setSenha(String senha);
	public int getTipo();
	public void setTipo(int tipo);

}
