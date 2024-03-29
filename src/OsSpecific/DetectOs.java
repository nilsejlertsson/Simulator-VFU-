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
package OsSpecific;

/**
 * For future use...
 *
 * @author Christian Bodelsson <bodelsson@gmail.com>
 *
 */
public class DetectOs {

    private enum Os {

        WINDOWS, LINUX, MAC;

    }

    public static Enum getOsType() {
        String os = System.getProperty("os.name").toLowerCase();

        switch (os) {
            case "windows":
                return Os.WINDOWS;
            case "mac":
                return Os.MAC;
            case "linux":
                return Os.LINUX;
            default:
                return null;

        }
    }

}
