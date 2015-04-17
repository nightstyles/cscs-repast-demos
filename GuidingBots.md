# Contents #




---


# Summary #

  * Model        : Guiding Bots
  * Platform     : [RepastS ReLogo](RepastSReLogo.md)
  * Source Code  : https://cscs-repast-demos.googlecode.com/svn/mudit/GuidingBots/
  * Documentation: http://code.google.com/p/cscs-repast-demos/wiki/GuidingBotsDescription
  * Mentor       : Dr. Eric Tatara
  * Author       : [Mudit Raj Gupta](Mudit.md)


---


# 1. Description #

Guiding Motes are more sophisticated agents in the environment and are supposed to guide other daughter mote. They can transfer data to a daughter mote. A daughter mote can hatch into a guiding mote and can further guide other daughter motes, although these motes will have an error due to lack of sophisticated instruments. So, they will again convert back to daughter motes. If such motes guide other daughter motes, the error is also propagated.  All daughter motes have to reach at the center of the world, where they die. They do not have good positioning instruments, so they rely on guiding motes.These links basically point to the mote which have guided the present motes.

Such a scenario is likely to happen in Mobile Wireless Sensor Networks. Only few nodes will be equipped with GPS positioning systems, other nodes rely on them or motor feedback systems, which are normally in accurate.

https://cscs-repast-demos.googlecode.com/svn/wiki/GuidingBots/GuidingBots%28main%29.JPG


---


# 2. User Control #

The user can control the population of both daughter motes and guiding motes.Further, user can control the step size and error tolerance also. Standard Setup, Go and Go Once Options are also present. User Panel looks like this :

https://cscs-repast-demos.googlecode.com/svn/wiki/GuidingBots/GuidingBots%28panel%29.JPG



---


# 3. Output #

Model Outputter is also added. The added model outputter is comma separated values of "Time" and "Alive daughter Motes". One of the sample output file can be checked [here](https://code.google.com/p/cscs-repast-demos/source/browse/wiki/GuidingBots/Model%20Output.txt)

**Note:**

  1. This Output can be fed into various external plug-ins available with RepastS like MATLAB and spreadsheet.


---


# 4. Analysis #

Various analysis could be carried out with the model, but for demonstration purpose a graph between, "Alive Daughter Motes" on y-axis and "Time" on x-axis is plotted.

![https://cscs-repast-demos.googlecode.com/svn/wiki/GuidingBots/GuidingBots%28plot%29.png](https://cscs-repast-demos.googlecode.com/svn/wiki/GuidingBots/GuidingBots%28plot%29.png)

For the plot it can be concluded that the death rate of the daughter motes follows an exponential function. _Check with many test runs_


---


# 5. Applications #

## 5.1 Swarm Robotics and Mobile Wireless Sensor Networks ##

It is a simulation of a strategy that is used in Localization of Swarm of Robots or Mobile Wireless Sensor Networks. Large number of daughter robots with low-cost instruments to record local positions are left in an unknown area and few robots with high precision Global positioning Instruments are left there (guiding robots). Depending of the value of received signal strength indication (RSSI) the global position is transferred to the daughter robots (when guiding robots come near them) and they are also aware of the same and can navigate in the area.

## 5.2 Other Application ##

Such colonial behavior is observed in various social models.


---


# 6. Extending the Model #

## 6.1 Adding RSSI value ##

The model can be extended by adding a RSSI value slider. This will control from how much distance a guiding mote can guide a daughter mote.

## 6.2 Adding different Daughter Behavior ##

The guiding motes can guide the daughter motes to do some other task, like search for a shelter. The selection of the behavior is left purely to the imagination of the user.


---


**Note :** For detailed explanation of the model, how various features are added and guiding algorithm and code refer to [this](http://code.google.com/p/cscs-repast-demos/wiki/GuidingBotsDescription)