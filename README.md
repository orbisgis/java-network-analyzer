# Java Network Analyzer [![GitHub](https://img.shields.io/github/license/orbisgis/java-network-analyzer.svg)](https://github.com/orbisgis/java-network-analyzer/blob/master/LICENSE)[![Build Status](https://travis-ci.org/orbisgis/java-network-analyzer.png)](https://travis-ci.org/orbisgis/java-network-analyzer)[![GitHub release](https://img.shields.io/github/release/orbisgis/java-network-analyzer.svg)](https://github.com/orbisgis/java-network-analyzer/releases)

Java Network Analyzer (JNA) provides a collection of [graph
theory](http://en.wikipedia.org/wiki/Graph_theory) and [social network
analysis](http://en.wikipedia.org/wiki/Social_network_analysis) algorithms.
These algorithms are implemented on mathematical graphs using the
[JGraphT](https://github.com/jgrapht/jgrapht) library.

#### Currently supported

Augmented [BFS](http://en.wikipedia.org/wiki/Breadth-first_search),
[DFS](http://en.wikipedia.org/wiki/Depth-first_search) and
[Dijkstra](http://en.wikipedia.org/wiki/Dijkstra%27s_algorithm) algorithms are
used to compute:

* [Betweenness centrality](http://en.wikipedia.org/wiki/Betweenness_centrality)
* [Closeness centrality](http://en.wikipedia.org/wiki/Centrality#Closeness_centrality)
* [Strahler stream order](http://en.wikipedia.org/wiki/Strahler_number) (for
  mathematical trees)

#### Graph types
The underlying graph may be directed, edge-reversed or undirected, and edges may
or may not have weights.


#### Declaring project dependencies

You can include JNA in your project thanks to Sonatype repository.

Check https://search.maven.org/artifact/org.orbisgis/java-network-analyzer/0.4.0/bundle

To use the current snapshot add in the pom

```xml
<repository>
  <id>orbisgis-snapshot</id>
  <name>OrbisGIS sonatype snapshot repository</name>
  <url>https://oss.sonatype.org/content/repositories/snapshots/</url>
</repository>
```

and the following dependency

```xml
<dependency>
    <groupId>org.orbisgis</groupId>
    <version>0.5.0-SNAPSHOT</version>  
    <artifactId>java-network-analyzer</artifactId>
</dependency>
```
