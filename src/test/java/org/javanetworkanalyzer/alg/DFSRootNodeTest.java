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
package org.javanetworkanalyzer.alg;

import org.javanetworkanalyzer.data.VDFS;
import org.javanetworkanalyzer.model.Edge;
import org.javanetworkanalyzer.model.TraversalGraph;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests the DFS algorithm from all possible start vertices on a directed graph.
 *
 * @author Adam Gouge
 */
// TODO: Write the tests for undirected graphs as well.
public class DFSRootNodeTest extends DFSTest {

    private TraversalGraph<VDFS, Edge> traverse;

    @Test
    public void testDFSDirectedFromVertexOne() {
        dfs.calculate(v1);
        assertEquals(1, v1.getDiscoveryTime());
        assertEquals(8, v1.getFinishingTime());
        assertEquals(2, v2.getDiscoveryTime());
        assertEquals(7, v2.getFinishingTime());
        assertEquals(3, v3.getDiscoveryTime());
        assertEquals(6, v3.getFinishingTime());
        assertEquals(4, v4.getDiscoveryTime());
        assertEquals(5, v4.getFinishingTime());
        assertEquals(v5.getDiscoveryTime(), -1);
        assertEquals(v5.getFinishingTime(), -1);
        assertEquals(v6.getDiscoveryTime(), -1);
        assertEquals(v6.getFinishingTime(), -1);
        traverse = dfs.reconstructTraversalGraph();
        assertEquals(traverse.getRoot(), v1);
        assertEquals(3, traverse.edgeSet().size());
        assertTrue(traverse.containsEdge(v1, v2));
        assertTrue(traverse.containsEdge(v2, v3));
        assertTrue(traverse.containsEdge(v3, v4));
    }

    @Test
    public void testDFSDirectedFromVertexTwo() {
        dfs.calculate(v2);
        assertEquals(v1.getDiscoveryTime(), -1);
        assertEquals(v1.getFinishingTime(), -1);
        assertEquals(1, v2.getDiscoveryTime());
        assertEquals(6, v2.getFinishingTime());
        assertEquals(2, v3.getDiscoveryTime());
        assertEquals(5, v3.getFinishingTime());
        assertEquals(3, v4.getDiscoveryTime());
        assertEquals(4, v4.getFinishingTime());
        assertEquals(v5.getDiscoveryTime(), -1);
        assertEquals(v5.getFinishingTime(), -1);
        assertEquals(v6.getDiscoveryTime(), -1);
        assertEquals(v6.getFinishingTime(), -1);
        traverse = dfs.reconstructTraversalGraph();
        assertEquals(traverse.getRoot(), v2);
        assertEquals(2, traverse.edgeSet().size());
        assertTrue(traverse.containsEdge(v2, v3));
        assertTrue(traverse.containsEdge(v3, v4));
    }

    @Test
    public void testDFSDirectedFromVertexThree() {
        dfs.calculate(v3);
        assertEquals(v1.getDiscoveryTime(), -1);
        assertEquals(v1.getFinishingTime(), -1);
        assertEquals(3, v2.getDiscoveryTime());
        assertEquals(4, v2.getFinishingTime());
        assertEquals(1, v3.getDiscoveryTime());
        assertEquals(6, v3.getFinishingTime());
        assertEquals(2, v4.getDiscoveryTime());
        assertEquals(5, v4.getFinishingTime());
        assertEquals(v5.getDiscoveryTime(), -1);
        assertEquals(v5.getFinishingTime(), -1);
        assertEquals(v6.getDiscoveryTime(), -1);
        assertEquals(v6.getFinishingTime(), -1);
        traverse = dfs.reconstructTraversalGraph();
        assertEquals(traverse.getRoot(), v3);
        assertEquals(2, traverse.edgeSet().size());
        assertTrue(traverse.containsEdge(v3, v4));
        assertTrue(traverse.containsEdge(v4, v2));
    }

    @Test
    public void testDFSDirectedFromVertexFour() {
        dfs.calculate(v4);
        assertEquals(v1.getDiscoveryTime(), -1);
        assertEquals(v1.getFinishingTime(), -1);
        assertEquals(2, v2.getDiscoveryTime());
        assertEquals(5, v2.getFinishingTime());
        assertEquals(3, v3.getDiscoveryTime());
        assertEquals(4, v3.getFinishingTime());
        assertEquals(1, v4.getDiscoveryTime());
        assertEquals(6, v4.getFinishingTime());
        assertEquals(v5.getDiscoveryTime(), -1);
        assertEquals(v5.getFinishingTime(), -1);
        assertEquals(v6.getDiscoveryTime(), -1);
        assertEquals(v6.getFinishingTime(), -1);
        traverse = dfs.reconstructTraversalGraph();
        assertEquals(traverse.getRoot(), v4);
        assertEquals(2, traverse.edgeSet().size());
        assertTrue(traverse.containsEdge(v4, v2));
        assertTrue(traverse.containsEdge(v2, v3));
    }

    @Test
    public void testDFSDirectedFromVertexFive() {
        dfs.calculate(v5);
        assertEquals(v1.getDiscoveryTime(), -1);
        assertEquals(v1.getFinishingTime(), -1);
        assertEquals(3, v2.getDiscoveryTime());
        assertEquals(6, v2.getFinishingTime());
        assertEquals(4, v3.getDiscoveryTime());
        assertEquals(5, v3.getFinishingTime());
        assertEquals(2, v4.getDiscoveryTime());
        assertEquals(7, v4.getFinishingTime());
        assertEquals(1, v5.getDiscoveryTime());
        assertEquals(10, v5.getFinishingTime());
        assertEquals(8, v6.getDiscoveryTime());
        assertEquals(9, v6.getFinishingTime());
        traverse = dfs.reconstructTraversalGraph();
        assertEquals(traverse.getRoot(), v5);
        assertEquals(4, traverse.edgeSet().size());
        assertTrue(traverse.containsEdge(v5, v4));
        assertTrue(traverse.containsEdge(v4, v2));
        assertTrue(traverse.containsEdge(v2, v3));
        assertTrue(traverse.containsEdge(v5, v6));
    }

    @Test
    public void testDFSDirectedFromVertexSix() {
        dfs.calculate(v6);
        assertEquals(v1.getDiscoveryTime(), -1);
        assertEquals(v1.getFinishingTime(), -1);
        assertEquals(v2.getDiscoveryTime(), -1);
        assertEquals(v2.getFinishingTime(), -1);
        assertEquals(v3.getDiscoveryTime(), -1);
        assertEquals(v3.getFinishingTime(), -1);
        assertEquals(v4.getDiscoveryTime(), -1);
        assertEquals(v4.getFinishingTime(), -1);
        assertEquals(v5.getDiscoveryTime(), -1);
        assertEquals(v5.getFinishingTime(), -1);
        assertEquals(1, v6.getDiscoveryTime());
        assertEquals(2, v6.getFinishingTime());
        traverse = dfs.reconstructTraversalGraph();
        assertEquals(traverse.getRoot(), v6);
        assertEquals(0, traverse.edgeSet().size());
    }
}
