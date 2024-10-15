package by.samova.roachsim._main;

import by.samova.roachsim.entity.Roach;
import by.samova.roachsim.util.EventSimulator;

public class _Main {

    public static void main(String[] args) {
        Roach roach = new Roach();
        EventSimulator eventSimulator = new EventSimulator();
        eventSimulator.startSimulation(roach);
    }
}