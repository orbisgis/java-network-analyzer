/*
 * Copyright (C) 2015 obonin
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
package org.javanetworkanalyzer.alg;

/**
 * Helper class for the results of shortest paths computations on weighted
 * graphs.
 * By convention, the "distance" of a path is computed with the weight, and
 * the "length" is computed with the dead weight (the dead weight is simply
 * accumulated along the path but not used in the search). 
 * 
 * 
 * @author obonin
 */
public class DistanceLength {
    private double distance = 0;
    private double length = 0;
    
    /**
     * @param d distance (sum of weights)
     * @param l length (sum of dead weights)
     */
    public DistanceLength(double d, double l) {
        distance = d;
        length = l;
    }
    
    public double getDistance(){
        return distance;
    }
    
    public double getLength(){
        return length;
    }
}
