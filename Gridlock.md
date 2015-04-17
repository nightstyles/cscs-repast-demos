# Summary #

  * Source Code   : https://cscs-repast-demos.googlecode.com/svn/tim/Gridlock/
  * Platform      : [Repast Simphony ReLogo](RepastSReLogo.md)
  * Documentation
    * Wiki: http://code.google.com/p/cscs-repast-demos/wiki/Gridlock
    * PDF: https://cscs-repast-demos.googlecode.com/svn/tim/Gridlock/docs/gridlock.pdf
  * Author: [Tim Sweda](Tim.md)

![https://cscs-repast-demos.googlecode.com/svn/tim/Gridlock/docs/gridlock.png](https://cscs-repast-demos.googlecode.com/svn/tim/Gridlock/docs/gridlock.png)

# Contents #



---


# Introduction #

This model is an adaptation of [Traffic Grid](http://ccl.northwestern.edu/netlogo/models/TrafficGrid) from the NetLogo models library, and is a traffic simulator for understanding how gridlock occurs.  Gridlock is defined as the state in which a queue of cars traveling in one direction blocks an intersection, thereby impeding the progress of cars traveling in the other direction.  While gridlock can sometimes be localized and temporary, it has a tendency to spread to other intersections, possibly causing traffic in the entire network to come to a halt.  This model is intended to help explore the circumstances that lead to such outcomes.

In the model, cars move forward if not at a red light or behind another stopped car.  If there are no other cars ahead, they accelerate up to the speed limit; otherwise, the slow down to match the speed of the cars in front of them.

The traffic signals can be configured at the beginning of the simulation to determine the flow of traffic.  The user can also cut and restore power to the intersections at any time to observe the effect of removing the signals.

# Usage #

Specify the number of roads in each direction by selecting values for **# N/S Roads** and **# E/W Roads**.  Also select a value for **# Cars** to specify the total number of cars on the road network.  (This value must not be greater than the total number of road patches.)  To determine how the traffic signals are coordinated, select one of the following **Signal Configuration\*s:**

  * **AllSync**:  all signals are the same
  * **NSAltEWSync**:  signal colors alternate in the N/S direction but are the same in the E/W direction
  * **NSAltEWAlt**:  signal colors alternate in both directions
  * **AllRandom**:  signal settings are randomized at each intersection

Next, click the **Setup** button to initialize and the **Go** button to run the model.

The remaining parameters can be adjusted as the simulation runs.  The value for **Speed Limit** determines the maximum speed at which cars can travel, and **Acceleration** is the rate per time step that cars can increase their speed.  The traffic signals can be turned off by unchecking **powerQ** and restored by rechecking **powerQ**.  To change the number of time steps between signal changes, adjust the **Ticks Per Cycle** value.

# Exercises #

  * Identify some parameter settings that cause the entire traffic network to come to a halt.  Also identify settings that ensure that gridlock rarely occurs.

  * In the real world, when the power goes out at an intersection, it is treated as an [all-way stop](http://en.wikipedia.org/wiki/All-way_stop).  Implement this in the model.

  * Modify the model so that cars disappear once they reach the end of a road (rather than reappear at the beginning of the road), and new cars arrive randomly at the beginnings of roads.

# ReLogo Features #

Although ReLogo makes it possible to create custom patch types in addition to the **UserPatch** class, it is much easier to declare each patch type as a subset of **patches()** (or of another patch type) using the **with** command.  This is because patches cannot be created or destroyed during simulation, unlike turtles and links, which can be transient.  Custom turtle and link types can be declared in a similar manner as well, but one must be careful to update the member lists as agents are created and destroyed.  For example, in the Gridlock model, if the AgentSet **EWCars** is defined as the set of cars traveling in the E/W direction, then any cars created after **EWCars** is declared that travel in the E/W direction must be added separately (or **EWCars** must be redeclared).

# References #

  * Wilensky, U. (2003). NetLogo Traffic Grid model. http://ccl.northwestern.edu/netlogo/models/TrafficGrid. Center for Connected Learning and Computer-Based Modeling, Northwestern University, Evanston, IL.