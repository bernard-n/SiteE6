package com.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.metier.*;

public class FicheSituationTest {

	private FicheSituation fiche;
	private List<ListeActivite> listeActivite;
	private List<ListeActivite> listeActivite2;

	private ListeActivite activite1;
	private ListeActivite activite2;
	private ListeActivite activite3;
	private TypeSituation type1;
	private TypeSituation type2;

	@Before
	public void setUp() throws Exception {
		type1 = new TypeSituation(1,"Cours");
		type2 = new TypeSituation(1,"Entreprise");

		listeActivite = new ArrayList<ListeActivite>();
		listeActivite.add(activite1);
		listeActivite2 = new ArrayList<ListeActivite>();
		listeActivite2.add(activite2);
		listeActivite2 = new ArrayList<ListeActivite>();
		listeActivite2.add(activite3);
		//fiche = new FicheSituation(1,"Fiche n°1", type1, "test","test","test",listeActivite);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFicheSituation() {
		fail("Not yet implemented");
	}

	@Test
	public void testFicheSituationIntStringTypeSituationStringStringStringListOfListeActivite() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetIdFiche() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetIdFiche() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetLibelleFiche() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetLibelleFiche() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetLeType() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetLeType() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetOrganisation() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetOrganisation() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetEnvironnement() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetEnvironnement() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetBesoin() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetBesoin() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetListeActivite() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetListeActivite() {
		fail("Not yet implemented");
	}

}
