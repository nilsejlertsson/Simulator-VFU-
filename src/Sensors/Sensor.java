/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sensors;

import Generator.GenerateNumbers;
import Generator.Generator;
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

/**
 * Abstract parent sensor, enforce the use of a constructor on the children :-).
 * 
 *
 * @author Christian Bodelsson <bodelsson@gmail.com>
 */
public abstract class Sensor {

     /*Future indentification, can be removed if not desired*/
    protected enum SensorType {

        TEMPATURE, PRESSURE, MOIST, SPEED;
    }

    protected int max, min;
    protected SensorType sensorType;
    protected int value;

    public Sensor(int max, int min) {
        this.max = max;
        this.min = min;
    }
    
    /*Children Must implement*/
    public abstract int getValue();
    public abstract Enum getSensorType();
    
    /*Not enforced but can be overriden by the children*/
    public void generateValue() {

        GenerateNumbers gen = new Generator(max, min);
        value = gen.getRandom();
    }
}
