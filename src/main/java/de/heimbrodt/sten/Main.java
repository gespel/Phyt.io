package de.heimbrodt.sten;

import de.heimbrodt.sten.backend.StensWateringBackend;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //I love it simple
        StensWateringBackend swb = new StensWateringBackend("");
        swb.run();
    }
}