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
package Generator;

import java.util.Random;

/**
 *
 * @author Christian Bodelsson <bodelsson@gmail.com>
 */
public class Generator implements GenerateNumbers{

    private final Random randomSeed;
    private final int min;
    private final int max;

    public Generator(int max, int min) {
        randomSeed = new Random();
        this.min = min;
        this.max = max;
    }

    @Override
    public int getRandom() {
        return randomSeed.nextInt(max) + min;
    }

}
