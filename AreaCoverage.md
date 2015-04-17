# Contents #




---


# Summary #

  * Model        : Area Coverage
  * Platform     : [RepastS ReLogo](RepastSReLogo.md)
  * Source Code  : https://cscs-repast-demos.googlecode.com/svn/mudit/areaCoverage/
  * Documentation: http://code.google.com/p/cscs-repast-demos/wiki/areaCoverageDescription
  * Mentor       : Dr. Eric Tatara
  * Author       : [Mudit Raj Gupta](Mudit.md)


---


# 1. Description #

Each mote tries to move in an area where there are less number of motes. This results in expansions. The initial positioning of the motes can be selected by choosing any of the preset regular shapes - Circle, Square, Line and Hexagon.

Model can be used to study the density of motes at different region, the effect of initial geometry on the spread and rate at which the expansion is taking place.

https://cscs-repast-demos.googlecode.com/svn/wiki/AreaCoverage/AreaCovrage%28main%29.JPG


---


# 2. User Control #

User can select the initial geometry (from Line, Circle, Square and Hexagon) in which the motes are deployed. The parameters of the geometry can also be changed by the user. The user can also control the population of the motes and the step size. Standard Setup, Go and Go Once Options are also present. User Panel looks like this :

https://cscs-repast-demos.googlecode.com/svn/wiki/AreaCoverage/AreaCovrage%28panel%29.JPG



---


# 3. Output #

Model Outputter is also added. The added model outputter is comma separated values of "Time" and "Number of Motes" (Outside 14 units radius). One of the sample output file can be checked [here](https://code.google.com/p/cscs-repast-demos/source/browse/wiki/AreaCoverage/Model%20Output.txt)

**Note:**

  1. This Output can be fed into various external plug-ins available with RepastS like MATLAB and spreadsheet.

  1. The number 14 used in the model has no relevance, it was chosen to get a good output. The user can modify the source code and set it to some other value.


---


# 4. Analysis #

Various analysis could be carried out with the model, but for demonstration purpose a graph between, "Number of Motes" (outside 14 units radius from the center) on y-axis and "Time" on x-axis is plotted.

![https://cscs-repast-demos.googlecode.com/svn/wiki/AreaCoverage/AreaCoverage%28plot%29.png](https://cscs-repast-demos.googlecode.com/svn/wiki/AreaCoverage/AreaCoverage%28plot%29.png)

For the plot it can be concluded that the number of motes outside a given radius grow exponentially. _Check with many test runs_


---


# 5. Extending #

## 5.1 Adding Initial Geometry ##

The model can be extended to give mote density of different area(shapes) and even the user can add an irregular geometry. _(see description)_

## 5.2 Distributed Area Coverage ##

The Motes can be given more specific properties and the indivisual behavior can be changed slightly to see observable change in the colonial behavior. _Try decreasing the speed of all the motes after they have traveled a specific distance (Assuming battery level falls)_


---


# 6. Applications #

## 6.1 Swarm Robotics and Mobile Wireless Sensor Networks ##

This model can be used in swarm robotics application for studying optimum number of agents for a given area coverage in a given time frame. It can also be used for calculating robot density at a given time in a given radius and deciding initial geometry. Each "Mote" or agent will decide its' movement on a local basis so no global communication
between the robots is required and they can move and cover the area based on their neighbors.

## 6.2 Other Application ##

It will be useful for social simulation. It can be used to study the behavior of colonies when each individual is given such a characteristic.


---


**Note :** For detailed explanation of the model, how various features are added and guiding algorithm and code refer to [this](http://code.google.com/p/cscs-repast-demos/wiki/areaCoverageDescription)