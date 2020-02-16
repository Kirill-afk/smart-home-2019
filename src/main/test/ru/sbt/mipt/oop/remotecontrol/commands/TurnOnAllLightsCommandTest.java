package ru.sbt.mipt.oop.remotecontrol.commands;

import org.junit.Test;
import ru.sbt.mipt.oop.homedevices.Door;
import ru.sbt.mipt.oop.homedevices.Light;
import ru.sbt.mipt.oop.homeparts.Room;
import ru.sbt.mipt.oop.homeparts.SmartHome;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TurnOnAllLightsCommandTest {

    @Test
    public void executeTest() {
        Light light1 = new Light("1", true);
        Light light2 = new Light("2", true);
        Light light3 = new Light("3", true);
        Light light4 = new Light("4", true);

        Door door1 = new Door(true, "1");
        Door door2 = new Door(true, "2");

        Collection<Light> lights1 = new ArrayList<>();
        lights1.add(light1);
        lights1.add(light2);
        Collection<Light> lights2 = new ArrayList<>();
        lights2.add(light3);
        lights2.add(light4);

        Collection<Door> doors1 = new ArrayList<>();
        doors1.add(door1);
        Collection<Door> doors2 = new ArrayList<>();
        doors2.add(door2);

        Room room1 = new Room(lights1, doors1, "hall");
        Room room2 = new Room(lights2, doors2, "kitchen");

        SmartHome testHome = new SmartHome();
        testHome.addRoom(room1);
        testHome.addRoom(room2);


        TurnOnAllLightsCommand turnOnAllLightsCommand = new TurnOnAllLightsCommand(testHome);
        turnOnAllLightsCommand.execute();

        for (Light light : lights1) {
            assertTrue(light.isOn());
        }
    }
}