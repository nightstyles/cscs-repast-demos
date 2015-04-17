# **Summary** #

  * Model        : Guiding Bots
  * Source Code  : https://cscs-repast-demos.googlecode.com/svn/mudit/GuidingBots/
  * Platform     : [RepastS ReLogo](RepastSReLogo.md)
  * Mentor       : Dr. Eric Tatara
  * Author       : [Mudit Raj Gupta](Mudit.md)

https://cscs-repast-demos.googlecode.com/svn/wiki/GuidingBots/GuidingBots%28main%29.JPG


---


# **Contents** #




---


# 1. Before Getting Started #


Before trying to use the model, make sure that Repast Simphony is installed properly (version 2.0 Beta, released on 12/3/2010 or later) is available to use.

Instructions on downloading and installing Repast Simphony on various platforms can be found on the [Repast download website](http://repast.sourceforge.net/download.html).

RepastS models can be created with [Flowcharts](http://repast.sourceforge.net/docs/RepastFlowGettingStarted.pdf), a Logo-like language called [ReLogo](http://repast.sourceforge.net/docs/ReLogoGettingStarted.pdf), or
purely in [Java and/or Groovy](http://repast.sourceforge.net/docs/RepastJavaGettingStarted.pdf), and even C++ with [Repast HPC](http://repast.sourceforge.net/docs/RepastHPCManual.pdf).

ReLogo was used to create the model. The documentations and other demo models on the same platform can be found [here](http://code.google.com/p/cscs-repast-demos/wiki/RepastSReLogo).

It is suggested that you go through the following model also, as the guiding algorithm is quite similar and it is also related to swarm robotics.

  1. [BugCatcher](BugCatcher.md)
  1. [followTheLeader](followTheLeader.md)
  1. [Ant](Ant.md)
  1. [AreaCoverage](AreaCoverage.md)

# 2. Introduction #

This model is designed keeping in mind a very important problem in the Mobile Wireless Sensor Network Domain - Localization. This model is inspired by the work:


- **[" A RSSI based localization algorithm for multiple mobile robots" by Qingxin Zhang, Qinglong Di, Guangyan Xu, Xiaoyan Qiu; Computer, Mechatronics, Control and Electronic Engineering (CMCE), 2010 International Conference on 24-26 Aug. 2010; 190 - 193, IEEE 2010](http://ieeexplore.ieee.org/xpl/freeabs_all.jsp?arnumber=5610184)**

The model basic implementation of the localization strategy based on RSSI (Received Signal Strength Indicator) and a simple algorithm _(Please check the description section)_

A similar method is used in the project demonstrated in the video. The difference is that the Guiding Robot (Poles) are stationary and Daughter Robot (Car) is moving.

<a href='http://www.youtube.com/watch?feature=player_embedded&v=xMDsKiTxD8g' target='_blank'><img src='http://img.youtube.com/vi/xMDsKiTxD8g/0.jpg' width='425' height=344 /></a>

The following behavior is modeled in the final model.

The model is set up with some daughter agents in an unknown area. The guiding agents will move around the area and transfer information to the daughter agents and once the daughter agents receive the information they move to cover the given area and transferring information further. The daughter can pass the information only to a specified number of agents because of the error introduced due to each information transfers. All daughter motes have to reach at the center of the world, where they die. They do not have good positioning instruments, so they rely on guiding motes. Model also has links. These links basically point to the mote which have guided the present motes.


---


# 3. Description #


## User Panel ##

https://cscs-repast-demos.googlecode.com/svn/wiki/GuidingBots/GuidingBots%28panel%29.JPG

The section briefly describes the elements of the User Panel and the parameters they control.

  * **Push Buttons (that rebounds)**

> - Set Up : For setting up the motes in the area according to the selected options and settings.

> - Go Once : For running the simulation for one clock tick.

  * **Toggle Button**

> - Go : For running the model unless the button is toggled again

  * **Sliders**

> - Number of Guiding Motes : self explainatory

> - Number of Daughter Motes : self explainatory

> - Step Size :Distance moved by the motes in a given direction

> - Error Tolerance : The steps a daughterMote can move before stopping.


## Data Sets, Outputters and External Plugin ##

Model Outputter is added. The added model outputter is comma separated values of "Time" and "Alive daughter Motes". One of the sample output file can be checked [here](https://code.google.com/p/cscs-repast-demos/source/browse/wiki/GuidingBots/Model%20Output.txt). This outputter takes values from a similar preset data set.

This Model Outputter values can be fed in other available external plug-ins.

## Plots ##

Various analysis could be carried out with the model, but for demonstration purpose a graph between, "Alive Daughter Motes" on y-axis and "Time" on x-axis is plotted.

![https://cscs-repast-demos.googlecode.com/svn/wiki/GuidingBots/GuidingBots%28plot%29.png](https://cscs-repast-demos.googlecode.com/svn/wiki/GuidingBots/GuidingBots%28plot%29.png)

For the plot it can be concluded that the death rate of the daughter motes follows an exponential function. _Check with many test runs_


---


# 4. Applications #

## Swarm Robotics and Mobile Wireless Sensor Networks ##

It is a simulation of a strategy that is used in Localization of Swarm of Robots or Mobile Wireless Sensor Networks. Large number of daughter robots with low-cost instruments to record local positions are left in an unknown area and few robots with high precision Global positioning Instruments are left there (guiding robots). Depending of the value of received signal strength indication (RSSI) the global position is transferred to the daughter robots (when guiding robots come near them) and they are also aware of the same and can navigate in the area.

The daughter bots now are somewhat capable of guiding other bors. This is avoided or restricted, since there is an error in position transferred to the daughter bots _(since the guiding bot and the daughter bots are both at different positions when the RSSI is matched and guiding bot is not capable of transmitting the position of the daughter it just transfers it's position. So , it has an error)_ this error is propagated. So, they can guide but with the error range also.

## Other Application ##

Such colonial behavior is observed in various social models.


---


# 5. Extending the Model #

## Adding RSSI value ##

The model can be extended by adding a RSSI value slider. This will control from how much distance a guiding mote can guide a daughter mote.

## Adding different Daughter Behavior ##

The guiding motes can guide the daughter motes to do some other task, like search for a shelter. The selection of the behavior is left purely to the imagination of the user.

## Addition of Plots and Outputters ##

Application specific graphs, outputters and plug in can be incorporated in the given model.


---


# 6. References #

**http://en.wikipedia.org/wiki/Swarm_robotics**

