# Summary #

  * Source Code   : https://cscs-repast-demos.googlecode.com/svn/tim/Mousetraps/
  * Platform      : [Repast Simphony ReLogo](RepastSReLogo.md)
  * Documentation
    * Wiki: http://code.google.com/p/cscs-repast-demos/wiki/Mousetraps
    * PDF: https://cscs-repast-demos.googlecode.com/svn/tim/Mousetraps/docs/mousetraps.pdf
  * Author: [Tim Sweda](Tim.md)

![https://cscs-repast-demos.googlecode.com/svn/tim/Mousetraps/docs/mousetraps.png](https://cscs-repast-demos.googlecode.com/svn/tim/Mousetraps/docs/mousetraps.png)

# Contents #



---


# Introduction #

This model replicates a common classroom experiment for demonstrating nuclear fission.  In the experiment, mousetraps are set in a grid arrangement with a ping pong ball on top of each one.  Another ball is dropped onto one of the traps, causing it to snap and throw both balls (the one on it and the one that was dropped) into the air.  These two balls then land on other mousetraps, and the process repeats until there are no more balls in the air.

In the model, snapped traps are represented by red patches and unsnapped traps are represented by tan patches.  When a mousetrap snaps, it sends the ball that landed on it and the balls that were on it traveling random distances in random directions.  Because this is a simulation, up to 10 balls are permitted to sit on each mousetrap.

# Usage #

First select values for **# Balls Per Trap** and **Max. Distance**, the maximum distance that a ball may travel per time step.  Then click the **Setup** button to initialize and the **Go** button to run the model.  The value of **pctSnapped** keeps track of the percentage of mousetraps that have been snapped.  When there are no more balls in the air, the simulation stops.

# Exercises #

  * Modify the model so that when balls reach the edge of the grid, they bounce back toward the grid of mousetraps rather than disappear.

  * Modify the model so that a ball can snap two traps if it lands on an edge between two patches.

# ReLogo Features #

The **stop** method is useful for terminating a simulation after certain criteria are satisfied.  In this model, it is called when there are no more balls remaining since no additional mousetraps can be snapped, and thus it makes no sense to continue running the simulation when nothing is happening.  Other possible reasons for wanting to terminate a simulation may include reaching a fixed number of time steps, having the number of turtles exceed a threshold value (since the turtle population may be tending towards infinity), or achieving equilibrium in the modeled system.