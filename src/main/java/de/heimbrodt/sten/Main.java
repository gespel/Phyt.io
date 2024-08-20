package de.heimbrodt.sten;

import de.heimbrodt.sten.backend.StensWateringBackend;
import de.heimbrodt.sten.frontend.StensWateringFrontend;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //I love it simple
        StensWateringBackend swb = new StensWateringBackend();
        StensWateringFrontend swf = new StensWateringFrontend();
        swb.start();
	    swf.start();
    }
}
