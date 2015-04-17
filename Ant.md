# Contents #




---


# Summary #

  * Model        : Ant
  * Platform     : [RepastS ReLogo](RepastSReLogo.md)
  * Source Code  : https://cscs-repast-demos.googlecode.com/svn/mudit/Ant/
  * Documentation: http://code.google.com/p/cscs-repast-demos/wiki/AntDescription
  * Mentor       : Dr. Eric Tatara
  * Author       : [Mudit Raj Gupta](Mudit.md)


---


# 1. Description #


This is a bio-inspired model. The model is a simulation of Ant and their behavior. The model demonstrates how ants move away from their nests in search for food and then come back to the nest with food.This behavior is used in computational intelligence and various other fields.

Ant only move a given distance away from their nest. This is because they have to come back to their nest. The ant return to their nest depending on the nest smell, they do so when the nest scent starts dying. If an ant finds food, it carries it back to its nest leaving a chemical trail which evaporates with time. The chemical is also diffused in the Moore's neighborhood, although the "level" is less. If an ant sniffs Chemical it moves in the direction where the chemical is for a large number of time. The ants reach the food pile, following the chemical and finally the come back to the nest reinforcing the chemical
trail.

https://cscs-repast-demos.googlecode.com/svn/wiki/Ants/Ant%28main%29.JPG


---


# 2. User Control #

The user can control the population of the ants and the amount of food in each food pile. Standard Setup, Go and Go Once Options are also present. User Panel looks like this :

https://cscs-repast-demos.googlecode.com/svn/wiki/Ants/Ant%28panel%29.JPG



---


# 3. Output #

Model Outputter is also added. The added model outputter is comma separated values of "Time" and "Food" (in each pile). One of the sample output file can be checked [here](https://code.google.com/p/cscs-repast-demos/source/browse/wiki/Ants/Model%20Output.txt)

**Note:**

  1. This Output can be fed into various external plug-ins available with RepastS like MATLAB and spreadsheet.


---


# 4. Analysis #

Various analysis could be carried out with the model, but for demonstration purpose a graph between, "Food" (in each pile) on y-axis and "Time" on x-axis is plotted. It is an overlay of the graph for each food pile.

![https://cscs-repast-demos.googlecode.com/svn/wiki/Ants/Ants%28pllot%29.png](https://cscs-repast-demos.googlecode.com/svn/wiki/Ants/Ants%28pllot%29.png)

For the plot it can be concluded that the ants exploit the food source which is closest to the nest first. _Check with many test runs_


---


# 5. Extending #

## 5.1 Variable Evaporation and Diffusion Rates ##

A slider can be added for giving the control for controlling the rate of evaporation of chemical tails. A slider controlling the spread of the neighboring area, till where the chemical is spread would also be useful.

## 5.2 Changing the Ant Behavior ##

The ants presently move in the direction where food will be found first _(if they sniff the chemical)_. Change this behavior. Make the ants follow the ants which are carrying food. The [FollowTheLeader](FollowTheLeader.md) model might be useful.

---


# 6. Applications #

## 6.1 Data Routing ##

Ant behavior or algorithms inspired by such a behavior like Ane Colony Oprimization are used in data routing between nodes. Although they face a problem of high overhead delay in case of ACO application in Mobile Wireless Sensor networks data routing.

## 6.2 Multi variable Optimizations ##

Algorithms inspired from such a behavior are used in multi variable optimization and solving various problems like the _Traveling Salesman Problem_

## 6.3 Other Applications ##

Ant behavior is significant to researchers form various fields and the application differs from subject to subject.


---


**Note :** For detailed explanation of the model, how various features are added and guiding algorithm and code refer to [this](http://code.google.com/p/cscs-repast-demos/wiki/AntDescription)