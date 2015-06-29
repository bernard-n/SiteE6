package com.test;

import java.util.List;

import com.metier.Etat;
import com.metier.FicheSituation;
import com.metier.ListeActivite;
import com.metier.ListeTache;
import com.persistance.AccesData;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(AccesData.getFicheSituation(1).getListeDocumentation().get(0).getHref());
	}
	

}
