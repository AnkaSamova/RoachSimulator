package by.samova.roachsim.service;

import by.samova.roachsim.entity.Roach;

public class AnimalStateValidator {

    public static void checkEnergy(Roach roach) {
        int energy = roach.getEnergy();
        if (energy > 100) {
            energy = 100;
        }
        if (energy < 0) {
            energy = 0;
        }
        roach.setEnergy(energy);
    }

    public static void checkHealth(Roach roach) {
        int health = roach.getHealth();
        if (health > 100) {
            health = 100;
        }
        if (health < 0) {
            health = 0;
        }
        roach.setHealth(health);
    }

    public static void checkHealthForEnergy(Roach roach) {
        int health = roach.getHealth();
        if (roach.getEnergy() <= 0) {
            health = health - 5;
            if (health < 0) {
                health = 0;
            }
        }
        roach.setHealth(health);
    }

    public static boolean checkStatus(Roach roach) {
        System.out.println("Энергия: " + roach.getEnergy() + " Здоровье: " + roach.getHealth());
        System.out.println();
        return roach.getHealth() > 0;
    }
}