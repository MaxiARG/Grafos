package com.main;

import java.io.IOException;

import com.grafos.GrafoDP;
import com.grafos.GrafoNDP;
import com.grafos.Kruskal;

public class Main {

	public static void main(String[] args) {
		try {
			GrafoNDP grafo= new GrafoNDP("entrada.in");
			Kruskal f= new Kruskal(grafo);
			f.ejecutar();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
