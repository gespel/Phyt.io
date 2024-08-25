package de.heimbrodt.sten.phytio;

import de.heimbrodt.sten.phytio.backend.StensWateringBackend;
import de.heimbrodt.sten.phytio.frontend.StensWateringFrontend;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //I love it simple
        StensWateringBackend swb = new StensWateringBackend();
        StensWateringFrontend swf = new StensWateringFrontend();
        swb.start();
	    swf.start();
    }
}
