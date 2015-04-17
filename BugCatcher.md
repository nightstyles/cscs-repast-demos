# Contents #




---


# Summary #

  * Model        : BugCatcher
  * Platform     : [RepastS ReLogo](RepastSReLogo.md)
  * Source Code  : https://cscs-repast-demos.googlecode.com/svn/mudit/BugCatcher/
  * Documentation: http://code.google.com/p/cscs-repast-demos/wiki/BugCatcherDescription
  * Mentor       : Dr. Eric Tatara
  * Author       : [Mudit Raj Gupta](Mudit.md)


---


# 1. Description #

Each Bug moves moves randomly in a given area. If a bug encounters a Bug Catching Machine in it's Moore neighborhood it gets caught in the machine. The bug dies after a specified time in the bug catching machine.


https://cscs-repast-demos.googlecode.com/svn/wiki/BugCatcher/BugCatcher%28main%29.JPG


---


# 2. User Control #

The user can control the population of the bugs and the machines.User can also control the time lapse between getting caught and death of a bug and bug speed. Standard Setup, Go and Go Once Options are also present. User Panel looks like this :

https://cscs-repast-demos.googlecode.com/svn/wiki/BugCatcher/BugCatcher%28panel%29.JPG



---


# 3. Output #

Model Outputter is also added. The added model outputter is comma separated values of "Time" and "Bugs Alive". One of the sample output file can be checked [here](https://code.google.com/p/cscs-repast-demos/source/browse/wiki/BugCatcher/Model%20Output.txt)

**Note:**

  1. This Output can be fed into various external plug-ins available with RepastS like MATLAB and spreadsheet.


---


# 4. Analysis #

Various analysis could be carried out with the model, but for demonstration purpose a graph between, "Bugs Alive" on y-axis and "Time" on x-axis is plotted.

![https://cscs-repast-demos.googlecode.com/svn/wiki/BugCatcher/BugCatcher%28plot%29.png](https://cscs-repast-demos.googlecode.com/svn/wiki/BugCatcher/BugCatcher%28plot%29.png)

For the plot it can be concluded that the bug death is an exponential function. Other plots can also be added, one such example could be an overlay of the graphs showing which machine has killed how many bugs. _Check with many test runs_


---


# 5. Extending #

## 5. 1 Increasing the Range ##

A slider for increasing the catching distance of the bug catcher can be incorporated. In this model the machine only catches bugs in the Moore's neighborhood.

## 5. 2 Surrounding Forbidden Area ##

An interesting feature that can be added to this model is the surrounding forbidden area. In food joints whenever a zapper or a bug catcher is used it is placed where there are no food items. This is done so that the dead bugs or some particles does not fall in food items. The user can add an interesting feature of breaking the bug into small dead particles instead of killing it.


---


# 6. Applications #

## 6.1 Mobile WSN and Swarm Robotics ##

The model can be used as reference and a multi-robot de mining simulation can be made on it. The bugs can be replaced by robots and they first find the mines and cluster around them and then drag the mines to a safe area. Go through the [AreaCoverage](AreaCoverage.md) model for more swarm robotics application.

## 6.2 Social Simulation ##

This model can be useful in studying social behavior. It is also useful in studying what could be most suitable position for placing a sink (machine). The model can be extended to fix the position of machines and can be used to find the optimal time for catching bugs.


---


**Note :** For detailed explanation of the model, how various features are added and guiding algorithm and code refer to [this](http://code.google.com/p/cscs-repast-demos/wiki/BugCatcherDescription)