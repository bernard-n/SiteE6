package com.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.metier.Etat;

public class EtatTest {
	private Etat etat;
	@Before
	public void setUp() throws Exception {
		etat = new Etat(1,"En Cours");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetIdEtat() {
		assertEquals(etat.getIdEtat(), 1);
	}

	@Test
	public void testSetIdEtat() {
		etat.setIdEtat(2);
		assertEquals(etat.getIdEtat(), 2);
	}

	@Test
	public void testGetLibelleEtat() {
		assertEquals(etat.getLibelleEtat(), "En Cours");
	}

	@Test
	public void testSetLibelleEtat() {
		etat.setLibelleEtat("Test");
		assertEquals(etat.getLibelleEtat(),"Test");
	}

}
