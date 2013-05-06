/**
 * GraphHopper-SNA implements a collection of social network analysis
 * algorithms. It is based on the <a
 * href="http://graphhopper.com/">GraphHopper</a> library.
 *
 * GraphHopper-SNA is distributed under the GPL 3 license. It is produced by the
 * "Atelier SIG" team of the <a href="http://www.irstv.fr">IRSTV Institute</a>,
 * CNRS FR 2488.
 *
 * Copyright 2012 IRSTV (CNRS FR 2488)
 *
 * GraphHopper-SNA is free software: you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or (at your option) any
 * later version.
 *
 * GraphHopper-SNA is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * GraphHopper-SNA. If not, see <http://www.gnu.org/licenses/>.
 */
package org.javanetworkanalyzer.graphcreators;

import org.javanetworkanalyzer.data.VId;
import org.javanetworkanalyzer.model.Edge;

/**
 * Creates unweighted JGraphT graphs from a csv file produced by OrbisGIS.
 *
 * @author Adam Gouge
 */
public class UnweightedGraphCreator<V extends VId, E extends Edge>
        extends GraphCreator<V, E> {

    /**
     * Initializes a new {@link UnweightedGraphCreator}.
     *
     * @param csvFile     CSV file containing the edge information.
     * @param orientation The desired graph orientation.
     */
    public UnweightedGraphCreator(String csvFile,
                                  int orientation,
                                  Class<? extends V> vertexClass,
                                  Class<? extends E> edgeClass) {
        super(csvFile, orientation, vertexClass, edgeClass);
    }
}
