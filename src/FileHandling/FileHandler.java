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
package FileHandling;

import Sensors.Sensor;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Christian Bodelsson <bodelsson@gmail.com>
 */
public class FileHandler {

    private String fileNameOrPath;
    private PrintWriter writer;
    private BufferedWriter bw;

    public FileHandler(String fileNameOrPath, int x) {
        this.fileNameOrPath = fileNameOrPath;
    }

    public FileHandler(String fileNameOrPath) {
        this.fileNameOrPath = fileNameOrPath;
        try {
            writer = new PrintWriter(this.fileNameOrPath, "UTF-8");
        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
            Logger.getLogger(FileHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void appendToFile(ArrayList<Sensor> list) {
        
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileNameOrPath, true)))) {
            for(Sensor x:list){
                out.println(Integer.toString(x.getValue()));
            }
            
        } catch (IOException ex) {
            Logger.getLogger(FileHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
