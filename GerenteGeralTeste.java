package controller.teste;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import controller.GerenteGeral;
import model.Jogador;
import model.Time;
import model.Torcedor;

public class GerenteGeralTeste {
	GerenteGeral g;
	@Before
	public void setUp() throws Exception {
		g = new GerenteGeral();
	}

	@Test
	public void testCadastrarUsuario() {
		Torcedor torc = new Torcedor("x", "x", "x", new Time("x"));
		g.cadastrarUsuario(torc);
		assertEquals(torc, g.getGerenteCad().getUsuarios().get(0));
	}

	

	@Test
	public void testCadastrarTime() {
		Time t = new Time("x");
		g.cadastrarTime(t);
		assertEquals(t, g.getGerentecamp().getTimesCadastrados().get(0));
	}
}
