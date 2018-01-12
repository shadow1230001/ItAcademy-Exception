package by.lyubin.exceptionProject.runner;

import by.lyubin.exceptionProject.bean.Continent;
import by.lyubin.exceptionProject.bean.Island;
import by.lyubin.exceptionProject.bean.Planet;

public class PlaneMain {
    public static void main(String[] args) {
        Planet planet = new Planet();
        planet.removeIsland(2);
        planet.removeContinent(1);
        System.out.println(planet);
        planet.addIsland(new Island("Caribbean Island", 123.5));
        System.out.println(planet);
        try {
            planet.removeOcean(5);
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Something goes wrong with removing ocean! " + e);
        }
        Continent cont1 = null;
        try {
            planet.addContinent(cont1);
        } catch (IllegalArgumentException e) {
            System.err.println(e);
        }
    }
}

