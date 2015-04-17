# Contents #




---


# Summary #

  * Model        : Follow The Leader
  * Platform     : [RepastS ReLogo](RepastSReLogo.md)
  * Source Code  : https://cscs-repast-demos.googlecode.com/svn/mudit/followTheLeader/
  * Documentation: http://code.google.com/p/cscs-repast-demos/wiki/followTheLeaderTutorial
  * Mentor       : Dr. Eric Tatara
  * Author       : [Mudit Raj Gupta](Mudit.md)


---


# 1. Description #

> The model is a simple multi agent model which demonstrates how the ant lines become short as time passes. The model basically has an ant "nest"  and the "food". The ants are moving from the nest to the food source.

An Ant can be either a "Leader"(first Ant coming out of the nest) or a "Follower" (rest all Ants) (refer to Fig. 2)

**Leader Ant**
  1. It moves towards the food scent
  1. It turns at random angles and moves forward and stops on finding food.

**Follower Ants**
  1. They start moving after a specified time delay (refer to Fig.
  1. They follow the ant infront of them by facing it and moving forward and stops on finding food.

Initially, ants take a longer route from nest to food. The following ants take smaller routes and finally the last ant takes
the smallest route

https://cscs-repast-demos.googlecode.com/svn/wiki/followTheLeader/followTheLeader%28main%29.JPG


---


# 2. User Control #

The user can select the population of the ants and the deviation angle. The user has the option of switching between with gradient and without gradient. The user is also provided with a switch to turn ON/OFF random deviation. The standard Setup, Go and Go Once buttons are also present.
The user panel looks like this :

https://cscs-repast-demos.googlecode.com/svn/wiki/followTheLeader/followTheLeader%28panel%29.JPG



---


# 3. Output #

Model Outputter is also added. The added model outputter is comma separated values of "Time" and "Route Length" (of the recent "food" reaching ant). One of the sample output file can be checked

[here](https://cscs-repast-demos.googlecode.com/svn/wiki/followTheLeader/Model%20Output.txt)

**Note:**

  1. This Output can be fed into various external plug-ins available with RepastS like MATLAB and spreadsheet.


---


# 4. Analysis #

Various analysis could be carried out with the model, but for demonstration purpose a graph between, "Route Length" (for the recent "food" reaching ant) on y-axis and "Time" on x-axis is plotted.

![https://cscs-repast-demos.googlecode.com/svn/wiki/followTheLeader/followTheLeader%28plot%29.png](https://cscs-repast-demos.googlecode.com/svn/wiki/followTheLeader/followTheLeader%28plot%29.png)

For the plot it can be concluded that the first ant takes the longest route and the route length decreases with subsequent ants. _Check with many test runs_


---


# 5. Extending #


---


# 6. Applications #


---


**Note :** For detailed explanation of the model, how various features are added and guiding algorithm and code refer to [this](http://code.google.com/p/cscs-repast-demos/wiki/followTheLeaderTutorial)