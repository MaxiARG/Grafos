package com.main;

import java.io.IOException;

import com.dijk.Dijkstra;
import com.dijk.Grafo;
import com.grafos.GrafoNDP;
import com.grafos.Kruskal;

public class Main {

	public static void main(String[] args) {
		try {
			Grafo grafo= new Grafo("entrada.in");
			Dijkstra f= new Dijkstra(grafo,0);
			f.ejecutar();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
