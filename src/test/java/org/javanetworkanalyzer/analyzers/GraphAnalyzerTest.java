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
package org.javanetworkanalyzer.analyzers;

import org.javanetworkanalyzer.data.VCent;
import org.javanetworkanalyzer.data.VUCent;
import org.javanetworkanalyzer.data.VWCent;
import org.javanetworkanalyzer.model.*;
import org.javanetworkanalyzer.graphcreators.GraphCreator;
import org.javanetworkanalyzer.graphcreators.WeightedGraphCreator;
import org.javanetworkanalyzer.progress.ProgressMonitor;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests weighted and unweighted graph analysis.
 *
 * @author Adam Gouge
 */
public abstract class GraphAnalyzerTest
        extends CentralityTest {

    private static final String WEIGHTED = "Weighted";
    private static final String UNWEIGHTED = "Unweighted";
    private static final String DIRECTED = "Directed";
    private static final String REVERSED = "Reversed";
    private static final String UNDIRECTED = "Undirected";
    /**
     * A logger.
     */
    private static final Logger LOGGER =
            LoggerFactory.getLogger(GraphAnalyzerTest.class);

    /**
     * Does unweighted graph analysis on the given graph.
     *
     * @param graph       The graph.
     *
     * @param orientation The orientation.
     *
     * @return The graph.
     */
    protected KeyedGraph<VUCent, EdgeCent> doUnweightedAnalysis(
            KeyedGraph<VUCent, EdgeCent> graph,
            String orientation) {
        try {
            doAnalysis(new UnweightedGraphAnalyzer(graph, progressMonitor()),
                       UNWEIGHTED + " " + orientation);
        } catch (Exception ex) {
        }
        if (printsResults()) {
            printResults(graph);
            System.out.println("");
        }
        return graph;
    }

    /**
     * Does weighted graph analysis on the given graph.
     *
     * @param graph       The graph.
     *
     * @param orientation The orientation.
     *
     * @return The graph.
     */
    protected WeightedKeyedGraph<VWCent, EdgeCent> doWeightedAnalysis(
            WeightedKeyedGraph<VWCent, EdgeCent> graph,
            String orientation) {
        try {
            doAnalysis(new WeightedGraphAnalyzer(graph, progressMonitor()),
                       WEIGHTED + " " + orientation);
        } catch (Exception ex) {
        }
        if (printsResults()) {
            printResults(graph);
            System.out.println("");
        }
        return graph;
    }

    /**
     * Executes {@link GraphAnalyzer#computeAll()}.
     *
     * @param analyzer     The {@link GraphAnalyzer}.
     * @param analysisType Describes the type of analysis.
     */
    private void doAnalysis(
            GraphAnalyzer<?, ?, ?> analyzer,
            String analysisType) {
        long start = System.currentTimeMillis();
        try {
            analyzer.computeAll();
        } catch (Exception ex) {
        }
        printTime(System.currentTimeMillis() - start, analysisType);
    }

    /**
     * Does unweighted graph analysis on the directed graph loaded by
     * {@link GraphAnalyzerTest#unweightedGraph(int)}.
     *
     * @return The graph.
     */
    public DirectedG<VUCent, EdgeCent> unweightedDirectedAnalysis() {
        try {
            return (DirectedG) doUnweightedAnalysis(unweightedGraph(
                    GraphCreator.DIRECTED), DIRECTED);
        } catch (Exception ex) {
        }
        return null;
    }

    /**
     * Does unweighted graph analysis on the edge reversed graph loaded by
     * {@link GraphAnalyzerTest#unweightedGraph(int)}.
     *
     * @return The graph.
     */
    public DirectedG<VUCent, EdgeCent> unweightedReversedAnalysis() {
        try {
            return (DirectedG) doUnweightedAnalysis(unweightedGraph(
                    GraphCreator.REVERSED), REVERSED);
        } catch (Exception ex) {
        }
        return null;
    }

    /**
     * Does unweighted graph analysis on the undirected graph loaded by
     * {@link GraphAnalyzerTest#unweightedGraph(int)}.
     *
     * @return The graph.
     */
    public UndirectedG<VUCent, EdgeCent> unweightedUndirectedAnalysis() {
        try {
            return (UndirectedG) doUnweightedAnalysis(unweightedGraph(
                    GraphCreator.UNDIRECTED), UNDIRECTED);
        } catch (Exception ex) {
        }
        return null;
    }

    /**
     * Does weighted graph analysis on the directed graph loaded by
     * {@link GraphAnalyzerTest#weightedGraph(int)}.
     *
     * @return The graph.
     */
    public DirectedG<VWCent, EdgeCent> weightedDirectedAnalysis() {
        try {
            return (DirectedG) doWeightedAnalysis(weightedGraph(
                    GraphCreator.DIRECTED), DIRECTED);
        } catch (Exception ex) {
        }
        return null;
    }

    /**
     * Does weighted graph analysis on the edge reversed graph loaded by
     * {@link GraphAnalyzerTest#weightedGraph(int)}.
     *
     * @return The graph.
     */
    public DirectedG<VWCent, EdgeCent> weightedReversedAnalysis() {
        try {
            return (DirectedG) doWeightedAnalysis(weightedGraph(
                    GraphCreator.REVERSED), REVERSED);
        } catch (Exception ex) {
        }
        return null;
    }

    /**
     * Does weighted graph analysis on the undirected graph loaded by
     * {@link GraphAnalyzerTest#weightedGraph(int)}.
     *
     * @return The graph.
     */
    public UndirectedG<VWCent, EdgeCent> weightedUndirectedAnalysis() {
        try {
            return (UndirectedG) doWeightedAnalysis(weightedGraph(
                    GraphCreator.UNDIRECTED), UNDIRECTED);
        } catch (Exception ex) {
        }
        return null;
    }

    /**
     * Does unweighted analysis on an unweighted graph (loaded by
     * {@link GraphAnalyzerTest#unweightedGraph(int)} and weighted analysis on a
     * weighted graph WITH ALL WEIGHTS EQUAL TO 1.0 (loaded by
     * {@link GraphAnalyzerTest#weightedGraph(int)}) and makes sure the results
     * are the same.
     */
    // TODO: Implement this method.
    @Test
    public void undirectedComparison() {
//        int orientation = GraphCreator.UNDIRECTED;
//        
//        Map<UnweightedNodeBetweennessInfo, Edge> unweightedResults = 
//                doUnweightedAnalysis(unweightedGraph(orientation));
//        Map<WeightedNodeBetweennessInfo, Ege> weightedResults = 
//                doWeightedAnalysis(weightedGraph(orientation));
    }

    /**
     * Loads an unweighted graph with the given orientation from
     * {@link GraphAnalyzerTest#getFilename()}.
     *
     * @param orientation The orientation.
     *
     * @return The graph.
     *
     */
    protected KeyedGraph<VUCent, EdgeCent> unweightedGraph(
            int orientation) {
        try {
            return new GraphCreator(getFilename(),
                                    orientation,
                                    VUCent.class,
                                    EdgeCent.class).loadGraph();
        } catch (Exception ex) {
        }
        return null;
    }

    /**
     * Loads a weighted graph with the given orientation from
     * {@link GraphAnalyzerTest#getFilename()}.
     *
     * @param orientation The orientation.
     *
     * @return The graph.
     *
     */
    protected WeightedKeyedGraph<VWCent, EdgeCent> weightedGraph(
            int orientation) {
        try {
            return new WeightedGraphCreator(getFilename(),
                                            orientation,
                                            VWCent.class,
                                            EdgeCent.class,
                                            getWeightColumnName()).loadGraph();
        } catch (Exception ex) {
        }
        return null;
    }

    /**
     * Checks the betweenness values of the given vertices against the given
     * expected betweenness values.
     *
     * @param graph               The graph
     * @param expectedBetweenness The expected betweenness values
     */
    protected void checkBetweenness(
            double[] expectedBetweenness,
            KeyedGraph<? extends VCent, ? extends DefaultWeightedEdge> graph) {
        if (graph != null) {
            VCent vertex;
            for (int i = 0; i < getNumberOfNodes(); i++) {
                vertex = graph.getVertex(i + 1);
                if (vertex != null) {
                    assertEquals(expectedBetweenness[i],
                                 vertex.getBetweenness(),
                                 TOLERANCE);
                } else {
                    throw new IllegalStateException("Null vertex " + (i + 1));
                }
            }
        } else {
            throw new IllegalStateException("Null graph");
        }
    }

    /**
     * Checks the closeness values of the given vertices against the given
     * expected closeness values.
     *
     * @param graph             The graph
     * @param expectedCloseness The expected closeness values
     */
    protected void checkCloseness(
            double[] expectedCloseness,
            KeyedGraph<? extends VCent, ? extends DefaultWeightedEdge> graph) {
        if (graph != null) {
            VCent vertex;
            for (int i = 0; i < getNumberOfNodes(); i++) {
                vertex = graph.getVertex(i + 1);
                if (vertex != null) {
                    assertEquals(expectedCloseness[i],
                                 vertex.getCloseness(),
                                 TOLERANCE);
                } else {
                    throw new IllegalStateException("Null vertex " + (i + 1));
                }
            }
        } else {
            throw new IllegalStateException("Null graph");
        }
    }

    /**
     * Returns a boolean indicating whether the results should be printed.
     *
     * @return A boolean indicating whether the results should be printed.
     */
    protected abstract boolean printsResults();

    /**
     * Returns a {@link ProgressMonitor} to be used during graph analysis.
     *
     * @return
     */
    protected abstract ProgressMonitor progressMonitor();

    /**
     * Returns the filename from which the graph edges should be loaded.
     *
     * @return The filename from which the graph edges should be loaded.
     */
    protected abstract String getFilename();

    /**
     * Returns the weight column name.
     *
     * @return The weight column name.
     */
    protected abstract String getWeightColumnName();

    /**
     * Returns the number of nodes in this graph.
     *
     * @return The number of nodes in this graph.
     */
    protected abstract int getNumberOfNodes();

    /**
     * Prints the amount of time graph analysis took.
     *
     * @param time The time.
     * @param analysisType analysis type
     */
    protected void printTime(double time, String analysisType) {
        LOGGER.info("({} ms) {} {} Graph Analysis",
                    time, getName(), analysisType);
    }
}
