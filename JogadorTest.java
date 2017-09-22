package br.ufpb.sistime;

import static org.junit.Assert.*;

import org.junit.Test;

public class JogadorTest {

	@Test
	public void testJogadorStringIntPosicao() {
		Jogador j = new Jogador("Mart�n Silva", 1, Posicao.GOLEIRO);
		assertTrue(j.getNome().equals("Mart�n Silva"));
		assertTrue(j.getNumero() == 1);
	}

}
