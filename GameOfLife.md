# Summary #

  * Source Code   : https://cscs-repast-demos.googlecode.com/svn/tim/GameOfLife/
  * Platform      : [Repast Simphony ReLogo](RepastSReLogo.md)
  * Documentation
    * Wiki: http://code.google.com/p/cscs-repast-demos/wiki/GameOfLife
    * PDF: https://cscs-repast-demos.googlecode.com/svn/tim/GameOfLife/docs/gameoflife.pdf
  * Author: [Tim Sweda](Tim.md)

![https://cscs-repast-demos.googlecode.com/svn/tim/GameOfLife/docs/gameoflife.png](https://cscs-repast-demos.googlecode.com/svn/tim/GameOfLife/docs/gameoflife.png)

# Contents #



---


# Introduction #

This is an implementation of _Life_, a cellular automaton developed by John Horton Conway in 1970.  It is one of the earliest known examples of an agent-based model.  In the model, cells live and die according to some simple rules:

  * A living cell with exactly 2 or 3 living neighbors remains alive (where a cell's neighbors are the 8 surrounding cells); otherwise, it dies.
  * A dead cell with exactly 3 living neighbors becomes alive.

# Usage #

Select the **Initial Density** of living cells, then click the **Setup** button to initialize and the **Go** button to run the model.  The value for **currentDensity** tracks the proportion of living cells while the model runs.

# Exercises #

  * As you run the model, you may notice objects that exhibit common behaviors such as stills (objects that do not change), oscillators (objects that repeatedly cycle through a series of patterns), and gliders (objects that travel across the screen).  Identify some other interesting behaviors and create your own objects that exhibit these behaviors.

  * Modify the rules that govern how cells live and die to create your own cellular automaton.  Note any patterns that you observe.

  * Implement this model using turtles instead of patches.

# ReLogo Features #

In this simple model, it is tempting to oversimplify the code by using only one **ask** block to update the cells.  This causes the cells to update sequentially rather than simultaneously, which can lead to certain patterns not behaving as expected.  Instead, a second **ask** block is needed beforehand to gather information about each cell's neighbors, and the cells are then updated in a separate **ask** block.

# References #

  * Gardner, M. (1970). Mathematical Games: The Fantastic Combinations of John Conway's New Solitaire Game "Life." _Scientific American, 223_, 120-123. http://ddi.cs.uni-potsdam.de/HyFISCH/Produzieren/lis_projekt/proj_gamelife/ConwayScientificAmerican.htm