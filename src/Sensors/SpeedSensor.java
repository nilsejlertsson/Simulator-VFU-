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
package Sensors;

import Generator.GenerateNumbers;
import Generator.Generator;

/**
 *
 * @author Christian Bodelsson <bodelsson@gmail.com>
 */
public class SpeedSensor extends Sensor{
    
    public SpeedSensor(int max,int min){
        super(max, min);
        sensorType = SensorType.SPEED;
        
    }

    @Override
    public int getValue() {
        return value;
    }
    
    @Override
    public void generateValue() {
        GenerateNumbers gen = new Generator(max, min);
        value = gen.getRandom();
    }

    @Override
    public Enum getSensorType() {
        return sensorType;
    }
    
    
}
