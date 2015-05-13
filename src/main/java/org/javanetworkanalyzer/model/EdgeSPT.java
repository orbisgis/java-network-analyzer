package org.javanetworkanalyzer.model;

/**
 * Interface for edges to be used in a
 * {@link org.javanetworkanalyzer.alg.TraversalAlg}.
 *
 * @author Adam Gouge
 * @author Olivier Bonin
 */
public interface EdgeSPT<E extends EdgeSPT> {

    E getBaseGraphEdge();

    void setBaseGraphEdge(E e);
    
    /**
     * The dead weight is specified here, as it is an extension of the jGraphT
     * data structure.
     */
    double getDeadWeight();
}
