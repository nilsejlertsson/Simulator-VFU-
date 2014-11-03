/*
 * Copyright (C) 2014 Christian Bodelsson <bodelsson@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package Simulator;

import Sensors.MoistSensor;
import Sensors.TempatureSensor;
import Sensors.SpeedSensor;
import Sensors.Sensor;
import java.util.ArrayList;
/**
 * Simulator with the purpose of simulate voltage levels from a ADC. Bluetooth
 * is missing,(will be added soon) but should not be a problem to add. Just set
 * up as a bluetooth server and push to client.
 *
 * @author Christian Bodelsson <bodelsson@gmail.com>
 */
public class Simulator {

    /**
     * Main method loop the sensors value and print to stdout
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("hello");
        for (int i = 0; i < 10; i++) {

            collectionOfSensors().stream().map((sensor) -> {
                sensor.generateValue();
                return sensor;
            }).forEach((sensor) -> {
                if (sensor instanceof TempatureSensor) {
                    System.out.println("Temp value: " + sensor.getValue());
                } else if (sensor instanceof SpeedSensor) {
                    System.out.println("Speed value: " + sensor.getValue());
                } else if (sensor instanceof MoistSensor) {
                    System.out.println("Moist value: " + sensor.getValue());
                }
                /*Add more options here, only for debug.*/
            });
            System.out.println("");

        }
        System.out.println("");
    }

    /*Add sensor objects in collectionOfSensors*/
    public static ArrayList<Sensor> collectionOfSensors() {
        ArrayList<Sensor> sensorList = new ArrayList();
        sensorList.add(new TempatureSensor(1023, 0));
        sensorList.add(new SpeedSensor(1023, 0));
        sensorList.add(new MoistSensor(1023, 0));
        //add
        return sensorList;
    }

}
