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

import FileHandling.FileHandler;
import Sensors.MoistSensor;
import Sensors.PulseSensor;
import Sensors.TempatureSensor;
import Sensors.SpeedSensor;
import Sensors.Sensor;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Simulator with the purpose of simulate voltage levels from a ADC. Bluetooth
 * is missing,(will be added soon) but should not be a problem to add. Just set
 * up as a bluetooth server and push to client.
 *
 * @author Christian Bodelsson <bodelsson@gmail.com>
 */
public class Simulator {

    /**
     * Main method loop the sensors value and print to stdout Example practical
     * use with SensorHooks interface: Sensor sen = new <X>Sensor(5000, 10);
     * sen.generateValue(); System.out.println(sen.getValue()); or
     * list.add(sen.getValue()); or Store to text file on disk
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Date date = new Date();
        //SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
       // File file = new File(dateFormat.format(date) + ".txt");
        FileHandler fh = new FileHandler();
        ArrayList<Sensor> li;
        li = collectionOfSensors();
        /*Forever*/

        while (true) {
            try {
                li.stream().forEach((sensor) -> {
                    sensor.generateValue();
                });

                li.stream().forEach((sensor) -> {
                    if (sensor instanceof TempatureSensor) {
                        System.out.println("Temp value: " + sensor.getValue());
                    } else if (sensor instanceof SpeedSensor) {
                        System.out.println("Speed value: " + sensor.getValue());
                    } else if (sensor instanceof MoistSensor) {
                        System.out.println("Moist value: " + sensor.getValue());
                    } else if (sensor instanceof PulseSensor) {
                        System.out.println("Pulse value: " + sensor.getValue());
                    }
                    /*Add more if-else here, for every extended new sensor*/
                });
                fh.appendToFile(li);
                System.out.println("");
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Simulator.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    /*Add sensor objects in collectionOfSensors*/
    public static ArrayList<Sensor> collectionOfSensors() {
        ArrayList<Sensor> sensorList = new ArrayList();
        sensorList.add(new TempatureSensor(65500, 65450));
        sensorList.add(new SpeedSensor(200, 0));
        sensorList.add(new MoistSensor(150, 0));
        sensorList.add(new PulseSensor(1000, 500));
        //add
        return sensorList;
    }

}
