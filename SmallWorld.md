# Summary #

  * Source Code   : https://cscs-repast-demos.googlecode.com/svn/tim/SmallWorld/
  * Platform      : [Repast Simphony ReLogo](RepastSReLogo.md)
  * Documentation
    * Wiki: http://code.google.com/p/cscs-repast-demos/wiki/SmallWorld
    * PDF: https://cscs-repast-demos.googlecode.com/svn/tim/SmallWorld/docs/smallworld.pdf
  * Author: [Tim Sweda](Tim.md)

![https://cscs-repast-demos.googlecode.com/svn/tim/SmallWorld/docs/smallworld.png](https://cscs-repast-demos.googlecode.com/svn/tim/SmallWorld/docs/smallworld.png)

# Contents #



---


# Introduction #

In this model, the random graph generation algorithm proposed by Duncan Watts and Steven Strogatz for producing small-world networks is implemented.  Typical characteristics of a small-world network include a small average path length between pairs of nodes (measured in terms of degrees of separation) and a large average clustering coefficient (a measure of how connected a node's neighbors are to each other).

The model begins with a set of nodes in a ring lattice arrangement.  Nodes can be rewired one at a time or all at once, changing in color from white to green as they are rewired.  When a node is rewired, each link connected to it has a chance of its other endpoint being connected to a different node.  Links that have already been rewired or considered for rewiring cannot be considered again.

# Usage #

Begin by selecting values for **# Nodes** and **Initial Node Degree** to determine the structure of the initial graph.  Also select the **Rewiring Probability** to determine how many links will be rewired.  Click the **Setup** button to initialize the model, and decide whether to **Rewire One Node** at a time or **Rewire All Nodes** by clicking the appropriate button.  Clicking the **Statistics** button will return the average path length and clustering coefficient of the current graph, along with the ratios of these statistics to those of the original graph in parentheses.  A small-world network will have a low ratio for the average path length and a high ratio for the clustering coefficient.

# Exercises #

  * Determine which parameter settings tend to yield small-world networks and which ones do not.  (Remember, small-world networks have a lower average path length but a higher clustering coefficient.)  Start by varying only the rewiring probability, and then try adjusting the number of nodes and initial node degree.

  * Determine which parameter settings tend to yield disconnected graphs.  Modify the model to ensure that a rewired graph is always connected.

# ReLogo Features #

This model makes use of several methods for working with links, including **createLinksWith** for creating new links, **linkNeighbors** for getting a node's neighbors, and **linkNeighborQ** for determining whether or not two nodes are neighbors.  These methods can only be used with undirected links, however.  To query whether there is a directed link from one node to another, for example, either **inLinkNeighborQ** or **outLinkNeighborQ** must be used, depending on which node is asking.

# References #

  * Watts, D. J., & Strogatz, S. H. (1998). Collective dynamics of ‘small-world’ networks. _Nature, 393_, 440–442.