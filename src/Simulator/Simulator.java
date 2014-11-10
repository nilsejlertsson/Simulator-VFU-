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
import Sensors.PulseSensor;
import Sensors.TempatureSensor;
import Sensors.SpeedSensor;
import Sensors.Sensor;
import java.util.ArrayList;
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
     * Main method loop the sensors value and print to stdout
     * Example practical use with SensorHooks interface:
     * Sensor sen = new <X>Sensor(5000, 10);
     * sen.generateValue();
     * System.out.println(sen.getValue());
     * or
     * list.add(sen.getValue());
     * or 
     * Store to text file on disk
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*Forever*/
   
       
        while(true){

            try {
                collectionOfSensors().stream().map((sensor) -> {//new java 8 lambda :-)
                    sensor.generateValue();
                    
                    return sensor;
                }).forEach((sensor) -> {
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
              
                Thread.sleep(1000);
                System.out.println("");
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Simulator.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        
    }

    /*Add sensor objects in collectionOfSensors*/
    public static ArrayList<Sensor> collectionOfSensors() {
        ArrayList<Sensor> sensorList = new ArrayList();
        sensorList.add(new TempatureSensor(65500, 35000));
        sensorList.add(new SpeedSensor(10000, 5000));
        sensorList.add(new MoistSensor(15000, 10000));
        sensorList.add(new PulseSensor(65531,0));
        //add
        return sensorList;
    }

}
