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
package org.javanetworkanalyzer.model;

import org.javanetworkanalyzer.data.VId;
import org.jgrapht.graph.AsUnweightedGraph;

/**
 * An unweighted view of the backing weighted graph specified in the
 * constructor.
 *
 * @author Adam Gouge
 */
public class AsUnweightedG<V extends VId, E extends EdgeID>
        //        extends GraphDelegator<V, E>
        //        implements Serializable 
        extends AsUnweightedGraph<V, E>
        implements UndirectedG<V, E> {

    /**
     * The graph to which operations are delegated.
     */
    private KeyedGraph<V, E> delegate;

    public AsUnweightedG(KeyedGraph<V, E> g)
            throws NoSuchMethodException {
        super(g);
        this.delegate = g;
    }

    @Override
    public boolean addVertex(int id) {
        throw new UnsupportedOperationException(
                "Adding vertices to an as-unweighted graph is not "
                + "supported.");
    }

    @Override
    public V getVertex(int id) {
        return delegate.getVertex(id);
    }

    @Override
    public E addEdge(int source, int target) {
        throw new UnsupportedOperationException(
                "Adding edges to an as-unweighted graph is not "
                + "supported.");
    }

    @Override
    public E addEdge(int source, int target, int edgeID) {
        throw new UnsupportedOperationException(
                "Adding edges to an as-unweighted graph is not "
                        + "supported.");
    }
}
