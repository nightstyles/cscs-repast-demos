# Contents #




---


# Summary #

  * Model        : BiasedRandomWalk
  * Platform     : [RepastS ReLogo](RepastSReLogo.md)
  * Source Code  : https://cscs-repast-demos.googlecode.com/svn/mudit/BiasedRandomWalk/
  * Documentation: http://code.google.com/p/cscs-repast-demos/wiki/BiasedRandomWalkDescription
  * Mentor       : Dr. Eric Tatara
  * Author       : [Mudit Raj Gupta](Mudit.md)


---


# 1. Description #

The model demonstrates a two biased dimensional Random Walk.
The Walkers are all created at one corner of the world (-9,0). They then start performing a two dimensional biased random walk. Each walker can only move in it'e Moore's neighborhood. As the ticks increase the walker move towards the other side (line: x=9). Although the walk of the walker is purely random, still they manage to reach a final destination, because of a biased introduced in their walk. Once they reach the biased region (lines : x=7 and x=11), they tend to revisit the patches in the region. The revisited region is dependent on the step sizes of the walkers.

https://cscs-repast-demos.googlecode.com/svn/wiki/BiasedRandomWalk/BiasedRandomWalk%28main%29.JPG


---


# 2. User Control #

The user can assign a maximum "Energy Value", all walkers will have a random value of energy, less than the specified.User can also change the step size of the walkers. The number of walker are also adjustable. Standard Setup, Go and Go Once Options are also present. User Panel looks like this :

https://cscs-repast-demos.googlecode.com/svn/wiki/BiasedRandomWalk/BiasedRandomWalk%28panel%29.JPG



---


# 3. Output #

Model Outputter is also added. The added model outputter is comma separated values of "Time" and "Number of revisits of the Biased Region (C)". One of the sample output file can be checked [here](https://code.google.com/p/cscs-repast-demos/source/browse/wiki/BiasedRandomWalk/ModelOutput.txt)

**Note:**

  1. This Output can be fed into various external plug-ins available with RepastS like MATLAB and spreadsheet.


---


# 4. Analysis #

Various analysis could be carried out with the model, but for demonstration purpose a graph between, "Number of Visits (C)" on y-axis and "Time" on x-axis is plotted.

![https://cscs-repast-demos.googlecode.com/svn/wiki/BiasedRandomWalk/BiasedRandomWalk%28plot%29.png](https://cscs-repast-demos.googlecode.com/svn/wiki/BiasedRandomWalk/BiasedRandomWalk%28plot%29.png)

Run the model with the same parameters and observe the nature of the plot. The maximum value although changes, is always above a thresh hold for a given set of model parameters.


---


# 5. Extending #

## 5.1 Two dimensional Bias ##

Go through the source code and try to add a two dimensional bias to the walkers. They should all try to converge at a point, rather than a moving towards a line.

## 5.2 Making Follow the Leader ##

Check out the [FollowTheLeader](FollowTheLeader.md) model and try to use a Biased Random Walk to make the model. The model uses a different algorithms, since ants cannot move in any of their Moore's Neighborhood due to physical constrains.


---


# 6. Applications #

## 6.1 Path planning in Robotics ##

A Biased Random Walk model can be used in various search based robotic missions, in which the search value's position is known. The robots do a random walk towards the biased area in order to find the value.

## 6.2 Predicting the Stock Market ##

Stock prizes change a little with time. The Random Walk can be used for predicting such changes and predicting the average prize after a given time interval. Biased Random walk is normally observed in a "Bull" or a "Bear" market. A stable market is more or less a Random Walk with out a bias. A book which covers the topic extensively is - "A Random Walk down the Wallstreet."

## 6.3 Other Applications ##

Random Walk is used by researchers in the field by Biology, Chemistry, Mathematics, Social Science, Physics and various other fields.


---


**Note :** For detailed explanation of the model, how various features are added and guiding algorithm and code refer to [this](http://code.google.com/p/cscs-repast-demos/wiki/BiasedRandomWalkDescription)