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
import org.javanetworkanalyzer.model.AsUndirectedG;
import org.javanetworkanalyzer.model.DirectedPseudoG;
import org.javanetworkanalyzer.model.Edge;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests the DFS algorithm on a(n) (un)directed graph. Note: Both the choice of
 * start vertex and the order in which neighbors are visited depend on the
 * underlying graph structure. (In the below examples, the start node seems to
 * be the first node added to the graph when the graph is created.) To specify
 * the start vertex, use {@link DFS#calculate(org.javanetworkanalyzer.data.VDFS)}.
 *
 * @author Adam Gouge
 */
public class DFSTest {

    protected DirectedPseudoG<VDFS, Edge> graph;
    protected DFS<VDFS, Edge> dfs;
    protected VDFS v1;
    protected VDFS v2;
    protected VDFS v3;
    protected VDFS v4;
    protected VDFS v5;
    protected VDFS v6;

    @Test
    public void testDFSDirected() {
        dfs.calculate();
        assertEquals(1, v1.getDiscoveryTime());
        assertEquals(8, v1.getFinishingTime());
        assertEquals(v2.getDiscoveryTime(), 2);
        assertEquals(7, v2.getFinishingTime());
        assertEquals(3, v3.getDiscoveryTime());
        assertEquals(6, v3.getFinishingTime());
        assertEquals(4, v4.getDiscoveryTime());
        assertEquals(5, v4.getFinishingTime());
        assertEquals(9, v5.getDiscoveryTime());
        assertEquals(12, v5.getFinishingTime());
        assertEquals(10, v6.getDiscoveryTime());
        assertEquals(11, v6.getFinishingTime());
    }

    @Test
    public void testDFSUndirected() throws NoSuchMethodException {
        dfs = new DFS<VDFS, Edge>(new AsUndirectedG<VDFS, Edge>(graph));
        dfs.calculate();
        assertEquals(1, v1.getDiscoveryTime());
        assertEquals(12, v1.getFinishingTime());
        assertEquals(2, v2.getDiscoveryTime());
        assertEquals(11, v2.getFinishingTime());
        assertEquals(4, v3.getDiscoveryTime());
        assertEquals(5, v3.getFinishingTime());
        assertEquals(3, v4.getDiscoveryTime());
        assertEquals(10, v4.getFinishingTime());
        assertEquals(6, v5.getDiscoveryTime());
        assertEquals(9, v5.getFinishingTime());
        assertEquals(7, v6.getDiscoveryTime());
        assertEquals(8, v6.getFinishingTime());
    }

    @BeforeEach
    public void setUp() {
        graph = new DirectedPseudoG<VDFS, Edge>(VDFS.class, Edge.class);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 2);
        graph.addEdge(5, 4);
        graph.addEdge(5, 6);
        graph.addEdge(6, 6);
        v1 = graph.getVertex(1);
        v2 = graph.getVertex(2);
        v3 = graph.getVertex(3);
        v4 = graph.getVertex(4);
        v5 = graph.getVertex(5);
        v6 = graph.getVertex(6);
        dfs = new DFS<VDFS, Edge>(graph);
    }
}
