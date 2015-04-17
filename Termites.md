# Summary #

  * Source Code   : https://cscs-repast-demos.googlecode.com/svn/grace/Termites/
  * Platform      : [Repast Simphony Java](RepastSJava.md)
  * Documentation
    * Wiki: http://code.google.com/p/cscs-repast-demos/wiki/Termites
    * Readme: https://cscs-repast-demos.googlecode.com/svn/grace/Termites/docs/ReadMe.txt

# Contents #



---


# Introduction #

The termites model simulates termites pick up and drop off wood chips.  There are different ways to model such behavior, and this version works as follow.  The carrying of a chip is indicated by the termite's state: NO\_CHIP, HAS\_CHIP.  Each termite finds "empty sites" within its eight directions, counting locations with chip as empty sites as well.  It picks a random location from the list and tires to move there.  If the location contains a chip, and the termite already carries a chip, then drop the chip nearby.  If the termite does not carry a chip, then pick up the chip and move to the new location.  On the other hand, if the location really is empty (no chip), then simply move the termite to the new location.

Since initially all termites and chips are scattered randomly, we will see clusters of chips as time goes on.  The initial model looks like the following figure:

![https://cscs-repast-demos.googlecode.com/svn/grace/Termites/docs/latex_files/Images/termite_before.png](https://cscs-repast-demos.googlecode.com/svn/grace/Termites/docs/latex_files/Images/termite_before.png)

After some time, we would see some clusters starting to form, as shown below:

![https://cscs-repast-demos.googlecode.com/svn/grace/Termites/docs/latex_files/Images/termite_after.png](https://cscs-repast-demos.googlecode.com/svn/grace/Termites/docs/latex_files/Images/termite_after.png)

Note that since every termite can carry one chip, if the number of chips is less than the number of termites, then it is possible that no clusters will occur.  Depending on the ratio of chips to termites, we would see the forming of clusters at various time.  The larger the ratio, the slower the formation of clusters, as it takes more time for termites to move around all the chips.

The chip class is pretty much unused, but it is left in for possible expansions later.

# Prerequisites #

Proper installation of Repast Simphony (version 2.0 Beta, released 12/3/2010 or later).

# Model Parameters #

Termites are blue, and chips are yellow.  There are only a few parameters for the model:

  * **Grid Height**:  Number of rows.
  * **Grid Width**:  Number of columns.
  * **Initial Chips**:  Number of chips to populate initially.
  * **Initial Termites**:  Number of termites to populate initially.

# References #

  * NetLogo termites model: http://ccl.northwestern.edu/netlogo/models/Termites