# Contents #




---


# Summary #

  * Model        : RandomWalk
  * Platform     : [RepastS ReLogo](RepastSReLogo.md)
  * Source Code  : https://cscs-repast-demos.googlecode.com/svn/mudit/RandomWalk/
  * Documentation: http://code.google.com/p/cscs-repast-demos/wiki/RandomWalkDescription
  * Mentor       : Dr. Eric Tatara
  * Author       : [Mudit Raj Gupta](Mudit.md)


---


# 1. Description #

The model demonstrates a two dimensional Random Walk.
The Walkers are all created at the center of the world. They then start performing a two dimensional random walk. Each walker can only move at right angle. As the ticks increase the walker move to cover a given area. The pattern of area coverage is different, but using the guiding equations of a random walk, the average area coverage and average displacement can be calculated.

![https://cscs-repast-demos.googlecode.com/svn/wiki/RandomWalk/RandomWalk%28main%29.png](https://cscs-repast-demos.googlecode.com/svn/wiki/RandomWalk/RandomWalk%28main%29.png)


---


# 2. User Control #

The user can assign Energy Values to the walkers and the user can also change the step size of the walkers. User can also run the model in area coverage mode by selecting _Area Coverage_.The number of walker are also adjustable. Standard Setup, Go and Go Once Options are also present. User Panel looks like this :

https://cscs-repast-demos.googlecode.com/svn/wiki/RandomWalk/RandomWalk%28panel%29.JPG



---


# 3. Output #

Model Outputter is also added. The added model outputter is comma separated values of "Time" and "Area Covered". One of the sample output file can be checked [here](https://code.google.com/p/cscs-repast-demos/source/browse/wiki/RandomWalk/ModelOutput.txt)

**Note:**

  1. This Output can be fed into various external plug-ins available with RepastS like MATLAB and spreadsheet.


---


# 4. Analysis #

Various analysis could be carried out with the model, but for demonstration purpose a graph between, "Area Coverage" on y-axis and "Time" on x-axis is plotted.

![https://cscs-repast-demos.googlecode.com/svn/wiki/RandomWalk/RandomWalk%28plot%29.png](https://cscs-repast-demos.googlecode.com/svn/wiki/RandomWalk/RandomWalk%28plot%29.png)

Run the model with the same parameters and observe the nature of the plot. You will notice that the walker although cover different areas for different run but they cover a given area with 99% confidence.


---


# 5. Extending #

## 5.1 Change in area coverage ##

Go through the source code and try to add a slider for cut-off area. At present the cut-off area is 200. After the walkers have covered 200 different patches the color changes to green (of the remaining covered patches and walker trail)

## 5.2 Self Avoiding Random Walk ##

Think of a strategy to implement a Self Avoiding Random Walk. In a self avoiding random walk, a walker tries not to move in a region it has already visited. Try with one walker first and then try to extend it.

---


# 6. Applications #

## 6.1 Path planning in Robotics ##

A Random Walk model can be used in various search based robotic missions, in which the search value's position is unknown. The algorithm is optimized by adding various features like -"Bias", "Restrictions" and "Self-Avoidance"

## 6.2 Predicting the Stock Market ##

Stock prizes change a little with time. The Random Walk can be used for predicting such changes and predicting the average prize after a given time interval. A book which covers the topic extensively is - "A Random Walk down the Wallstreet."

## 6.3 Other Applications ##

Random Walk is used by researchers in the field by Biology, Chemistry, Mathematics, Social Science, Physics and various other fields.


---


**Note :** For detailed explanation of the model, how various features are added and guiding algorithm and code refer to [this](http://code.google.com/p/cscs-repast-demos/wiki/RandomWalkDescription)