package de.heimbrodt.sten.phytio;

import de.heimbrodt.sten.phytio.backend.PhytioBackend;
import de.heimbrodt.sten.phytio.api.PhytioAPI;

public class Main {
    public static void main(String[] args) {
        //I love it simple
        PhytioBackend be = new PhytioBackend();
        PhytioAPI api = new PhytioAPI();
        be.start();
	    api.start();
    }
}
