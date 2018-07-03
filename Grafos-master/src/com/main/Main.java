package com.main;

import java.io.File;
import java.io.IOException;

import com.dijk.Dijkstra;
import com.dijk.Grafo;

public class Main {

	public static void main(String[] args) {
	
			Grafo grafo= new Grafo();
			grafo.leerArchivo(new File("entrada.in"));
			Dijkstra s= new Dijkstra(grafo,0);
			s.resolver();
			s.mostrarResultadoEnConsola();
	

	}

}
