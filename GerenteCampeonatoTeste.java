package controller.teste;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import controller.GerenteCampeonato;
import model.Jogador;
import model.Time;
import model.Torcedor;

public class GerenteCampeonatoTeste {
	GerenteCampeonato g;
	@Before
	public void setUp() throws Exception {
		g = new GerenteCampeonato();
	}

	@Test
	public void testBuscarTimeNome() {
		Time t = new Time("x");
		g.getTimesCadastrados().add(t);
		int n = g.buscarTimeNome("x");
		assertEquals(0, n);
	}

	@Test
	public void testBuscarJogador() {
		Jogador jogador = new Jogador("zé", "Goleiro", "01");
		Torcedor torc = new Torcedor("x", "x", "x", new Time("x"));
		torc.getTime().getEscalacao().add(jogador);
		assertEquals(0, g.buscarJogador(jogador, torc));
	}

}
