package com.main;

import java.io.IOException;

import com.grafos.DijstraDP;
import com.grafos.GrafoDP;

public class Main {

	public static void main(String[] args) {
		try {
			GrafoDP grafo= new GrafoDP("entrada.in");
		        DijstraDP t = new DijstraDP(grafo,0);
		        t.dijkstra();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
