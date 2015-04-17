# Summary #

  * Source Code   : https://cscs-repast-demos.googlecode.com/svn/tim/Ethnocentrism/
  * Platform      : [Repast Simphony ReLogo](RepastSReLogo.md)
  * Documentation
    * Wiki: http://code.google.com/p/cscs-repast-demos/wiki/Ethnocentrism
    * PDF: https://cscs-repast-demos.googlecode.com/svn/tim/Ethnocentrism/docs/ethnocentrism.pdf
  * Author: [Tim Sweda](Tim.md)

![https://cscs-repast-demos.googlecode.com/svn/tim/Ethnocentrism/docs/ethnocentrism.png](https://cscs-repast-demos.googlecode.com/svn/tim/Ethnocentrism/docs/ethnocentrism.png)

# Contents #



---


# Introduction #

This is an implementation of the ethnocentrism model proposed by Ross A. Hammond and Robert Axelrod.  It shows how ethnocentric behavior can become widespread under a variety of conditions.

Each agent has three traits:  color, whether or not it cooperates with agents of the same color, and whether or not it cooperates with agents of a different color.  Agents are classified based on the last two traits as follows:

  * **Altruists**:  cooperate with everyone (circle on gray background)
  * **Ethnocentrists**:  cooperate only with agents of the same color (circle on black background)
  * **Xenocentrists**:  cooperate only with agents of a different color (square on gray background)
  * **Egoists**:  cooperate with no one (square on black background)

In each time step, the following sequence of events takes place:

  1. New agents immigrate and settle on unoccupied patches.
  1. Agents are assigned an initial potential to reproduce (PTR) and interact with their neighbors in one-move prisoner's dilemma games to give and receive PTR.  Agents donate PTR to others with which they cooperate.
  1. Agents with empty neighboring patches have a chance of reproducing based on their PTR, and the traits of an offspring are inherited from the parent but have a chance of mutating.
  1. Some agents die.

# Usage #

Begin by selecting the **Cost** of giving help and the **Benefit** of receiving help (both in terms of PTR) as well as the **Base PTR** value assigned to each agent at the beginning of each time step (after immigration).  Also select the **Mutation Rate** for inherited traits, the **Death Rate** of agents after each time step, and the **Immigration Rate** in terms of the number of new agents at the beginning of each time step.  To determine the distribution of behaviors of immigrating agents, select values for the **In-group Cooperation Probability** and **Out-group Cooperation Probability**.

Once the parameters have been chosen, click the **Setup** button to initialize and the **Go** button to run the model.  At any time during the simulation, click the **Statistics** button to see the distribution of agents by behavior type and also the percentage of interactions that are cooperative.  The reported values are moving averages of the last 100 time steps.

# Exercises #

  * Implement experiments _e_, _h_, _j_, and _l_ from Table 1 on pg. 930 of [Hammond and Axelrod's paper](http://www.artisresearch.com/articles/Axelrod_Evolution_of_Ethnocentrism.pdf).

  * In their experiments, Hammond and Axelrod only varied one parameter at a time.  Choose two parameters to vary simultaneously and see if you can detect an interaction effect.

  * Suppose the different colors are not equally represented by immigrating agents (e.g., with probabilities {0.4 0.2 0.2 0.2} instead of {0.25 0.25 0.25 0.25}).  Implement this in the model and run some experiments varying the probabilities.

# ReLogo Features #

Combining the **lput** and **butFirst** methods provides a convenient way for keeping track of data from the last 100 time steps to calculate moving averages.  The **lput** method appends an item at the end of a list, and the **butFirst** method returns the list minus the first item.  Alternatively, the list items could be pushed the other way by using the **fput** and **butLast** methods instead.

# References #

  * Hammond, R. A., & Axelrod, R. (2006). The Evolution of Ethnocentrism. _Journal of Conflict Resolution, 50_, 926-936. http://www.artisresearch.com/articles/Axelrod_Evolution_of_Ethnocentrism.pdf