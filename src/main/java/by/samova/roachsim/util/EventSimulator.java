package by.samova.roachsim.util;

import by.samova.roachsim.entity.Roach;
import by.samova.roachsim.service.AnimalStateValidator;

public class EventSimulator {

    public void startSimulation(Roach roach) throws InterruptedException {
        while (AnimalStateValidator.checkStatus(roach)) {
            int eventNumber = (int) (Math.random() * 100);
            if (eventNumber >= 0 && eventNumber < 10) {
                sleepEvent(roach);
            } else if (eventNumber >= 10 && eventNumber < 20) {
                roachEat(roach);
            } else if (eventNumber >= 20 && eventNumber < 30) {
                roachDrink(roach);
            } else if (eventNumber >= 30 && eventNumber < 40) {
                moveEvent(roach);
            } else if (eventNumber >= 40 && eventNumber < 50) {
                runHuman(roach);
            } else if (eventNumber >= 50 && eventNumber < 60) {
                runCat(roach);
            } else if (eventNumber >= 60 && eventNumber < 70) {
                slipperSlam(roach);
            } else if (eventNumber >= 70 && eventNumber < 80) {
                attackCat(roach);
            } else if (eventNumber >= 80 && eventNumber < 90) {
                eatPoison(roach);
            } else if (eventNumber >= 90 && eventNumber < 100) {
                searchFood(roach);
            }
            Thread.sleep(1000);
        }
        System.out.println("Наконец-то! Таракан умер! The end!");
    }

    // 1. Таракан поспал в укрытии... +30 энергии +30 здоровья
    private void sleepEvent(Roach roach) {
        int energy = roach.getEnergy();
        int health = roach.getHealth();
        energy = energy + 30;
        health = health + (int) (roach.getPAWS() * 12);
        roach.setEnergy(energy);
        roach.setHealth(health);
        AnimalStateValidator.checkEnergy(roach);
        AnimalStateValidator.checkHealth(roach);
        System.out.println("Таракан поспал в укрытии... +30 энергии +30 здоровья");
    }

    // 2. Таракан съел крошки) +30 энергии +30 здоровья
    private void roachEat(Roach roach) {
        int energy = roach.getEnergy();
        int health = roach.getHealth();
        energy = energy + 30;
        health = health + (int) (roach.getPAWS() * 12);
        roach.setEnergy(energy);
        roach.setHealth(health);
        AnimalStateValidator.checkEnergy(roach);
        AnimalStateValidator.checkHealth(roach);
        System.out.println("Таракан съел крошки) +30 энергии +30 здоровья");
    }

    // 3. Таракан попил воды) +30 энергии +30 здоровья
    private void roachDrink(Roach roach) {
        int energy = roach.getEnergy();
        int health = roach.getHealth();
        energy = energy + 30;
        health = health + (int) (roach.getPAWS() * 12);
        roach.setEnergy(energy);
        roach.setHealth(health);
        AnimalStateValidator.checkEnergy(roach);
        AnimalStateValidator.checkHealth(roach);
        System.out.println("Таракан попил воды) +30 энергии +30 здоровья");
    }

    // 4. Таракан бежал от включённого света! -20 энергии
    private void moveEvent(Roach roach) {
        int energy = roach.getEnergy();
        energy = energy - 20;
        roach.setEnergy(energy);
        AnimalStateValidator.checkEnergy(roach);
        AnimalStateValidator.checkHealth(roach);
        AnimalStateValidator.checkHealthForEnergy(roach);
        System.out.println("Таракан бежал от включённого света! -20 энергии");
    }

    // 5. Таракан убегал от человека! -25 энергии -5 здоровья
    private void runHuman(Roach roach) {
        int energy = roach.getEnergy();
        int health = roach.getHealth();
        energy = energy - 25;
        health = health - (int) (roach.getPAWS() * 2);
        roach.setEnergy(energy);
        roach.setHealth(health);
        AnimalStateValidator.checkEnergy(roach);
        AnimalStateValidator.checkHealth(roach);
        AnimalStateValidator.checkHealthForEnergy(roach);
        System.out.println("Таракан убегал от человека! -25 энергии -5 здоровья");
    }

    // 6. Таракан убегал от кота! -25 энергии -5 здоровья
    private void runCat(Roach roach) {
        int energy = roach.getEnergy();
        int health = roach.getHealth();
        energy = energy - 25;
        health = health - (int) (roach.getPAWS() * 2);
        roach.setEnergy(energy);
        roach.setHealth(health);
        AnimalStateValidator.checkEnergy(roach);
        AnimalStateValidator.checkHealth(roach);
        AnimalStateValidator.checkHealthForEnergy(roach);
        System.out.println("Таракан убегал от кота! -25 энергии -5 здоровья");
    }

    // 7. Человек ударил таракана тапком! -25 здоровья
    private void slipperSlam(Roach roach) {
        int health = roach.getHealth();
        health = health - (int) (roach.getPAWS() * 10);
        roach.setHealth(health);
        AnimalStateValidator.checkHealth(roach);
        System.out.println("Человек ударил таракана тапком! -25 здоровья");
    }

    // 8. На таракана напал кот! -25 здоровья
    private void attackCat(Roach roach) {
        int health = roach.getHealth();
        health = health - (int) (roach.getPAWS() * 10);
        roach.setHealth(health);
        AnimalStateValidator.checkHealth(roach);
        System.out.println("На таракана напал кот! -25 здоровья");
    }

    // 9. Таракан съел отраву( -25 здоровья
    private void eatPoison(Roach roach) {
        int health = roach.getHealth();
        health = health - (int) (roach.getPAWS() * 10);
        roach.setHealth(health);
        AnimalStateValidator.checkHealth(roach);
        System.out.println("Таракан съел отраву( -25 здоровья");
    }

    // 10. Таракан искал еду... -10 энергии
    private void searchFood(Roach roach) {
        int energy = roach.getEnergy();
        energy = energy - 10;
        roach.setEnergy(energy);
        AnimalStateValidator.checkEnergy(roach);
        AnimalStateValidator.checkHealth(roach);
        AnimalStateValidator.checkHealthForEnergy(roach);
        System.out.println("Таракан искал еду... -10 энергии");
    }
}