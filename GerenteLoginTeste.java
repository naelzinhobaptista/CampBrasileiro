package controller.teste;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import controller.GerenteLogin;
import model.Time;
import model.Torcedor;

public class GerenteLoginTeste {
	GerenteLogin g;
	@Before
	public void setUp() throws Exception {
		g = new GerenteLogin();
	}

	@Test
	public void testVerificaLogin() {
		Torcedor torc = new Torcedor("x", "x", "x", new Time("x"));
		ArrayList<Torcedor> usuarios = new ArrayList<Torcedor>();
		usuarios.add(torc);
		int n = g.verificaLogin(torc.getLogin(), torc.getSenha(), usuarios);
		assertEquals(0, n);
	}

	@Test
	public void testLogar() {
		Torcedor torc = new Torcedor("x", "x", "x", new Time("x"));
		g.logar(torc);
		assertEquals(torc, g.getUsuarioLogado());
	}

}
