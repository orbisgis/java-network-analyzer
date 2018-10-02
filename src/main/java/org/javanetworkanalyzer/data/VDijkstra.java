/*
 * Java Network Analyzer provides a collection of graph theory and social
 * network analysis algorithms implemented on mathematical graphs using the
 * <a href="http://www.jgrapht.org/">JGraphT</a> library.
 *
 * Java Network Analyzer is developed by the GIS group of the DECIDE team of the 
 * Lab-STICC CNRS laboratory, see <http://www.lab-sticc.fr/>.
 * It is part of the OrbisGIS tool ecosystem.
 *
 * The GIS group of the DECIDE team is located at :
 *
 * Laboratoire Lab-STICC – CNRS UMR 6285
 * Equipe DECIDE
 * UNIVERSITÉ DE BRETAGNE-SUD
 * Institut Universitaire de Technologie de Vannes
 * 8, Rue Montaigne - BP 561 56017 Vannes Cedex
 * 
 * Java Network Analyzer is distributed under LGPL 3 license.
 *
 * Copyright (C) 2012-2014 CNRS (IRSTV CNRS FR 2488)
 * Copyright (C) 2015-2018 CNRS (Lab-STICC CNRS UMR 6285)
 *
 * Java Network Analyzer is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or (at your option) any
 * later version.
 *
 * Java Network Analyzer is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 *
 * You should have received a copy of the GNU Lesser General Public License along with
 * Java Network Analyzer. If not, see <http://www.gnu.org/licenses/>.
 * 
 * For more information, please consult: <http://www.orbisgis.org/>
 * or contact directly:
 * info_at_ orbisgis.org
 */
package org.javanetworkanalyzer.data;

/**
 * Vertex to be used in the Dijkstra algorithm.
 *
 * @param <V> Vertex
 *
 * @author Adam Gouge
 */
public class VDijkstra<V extends VDijkstra, E>
        extends VPredImpl<V, E>
        implements VDist<Double> {

    /**
     * The default distance assigned to all nodes at the beginning of the
     * Dijkstra algorithm.
     */
    public static final Double DEFAULT_DISTANCE = Double.POSITIVE_INFINITY;
    /**
     * Length of a shortest path starting from a certain source leading to this
     * node (Dijkstra).
     */
    private double distance = DEFAULT_DISTANCE;

    /**
     * Constructor: Sets the id.
     *
     * @param id Id
     */
    public VDijkstra(Integer id) {
        super(id);
    }

    @Override
    public Double getDistance() {
        return distance;
    }

    @Override
    public void setDistance(Double newDistance) {
        distance = newDistance;
    }

    /**
     * Clears the predecessor list and resets the distance to the default
     * distance.
     */
    @Override
    public void reset() {
        // Clear the predecessor list.
        super.clear();
        // Reset the distance to the default distance.
        distance = DEFAULT_DISTANCE;
    }

    /**
     * Clears the predecessor list and sets the distance to zero.
     */
    @Override
    public void setSource() {
        // Clear the predecessor list.
        super.clear();
        // Set the distance to zero.
        distance = 0.0;
    }
}
