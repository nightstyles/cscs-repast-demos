# **Summary** #

  * Model        : Moth Advance
  * Source Code  : https://cscs-repast-demos.googlecode.com/svn/mudit/Moth_Advance/
  * Platform     : [RepastS ReLogo](RepastSReLogo.md)
  * Mentor       : Dr. Eric Tatara
  * Author       : [Mudit Raj Gupta](Mudit.md)

https://cscs-repast-demos.googlecode.com/svn/wiki/Images_Mudit/Moth_Advance(Index).JPG


---


# **Contents** #




---


# 1. Before Getting Started #


Before trying to use the model, make sure that Repast Simphony is installed properly (version 2.0 Beta, released on 12/3/2010 or later) is available to use.

Instructions on downloading and installing Repast Simphony on various platforms can be found on the [Repast download website](http://repast.sourceforge.net/download.html).

RepastS models can be created with [Flowcharts](http://repast.sourceforge.net/docs/RepastFlowGettingStarted.pdf), a Logo-like language called [ReLogo](http://repast.sourceforge.net/docs/ReLogoGettingStarted.pdf), or purely in [Java and/or Groovy](http://repast.sourceforge.net/docs/RepastJavaGettingStarted.pdf), and even C++ with [Repast HPC](http://repast.sourceforge.net/docs/RepastHPCManual.pdf).

ReLogo was used to create the model. The documentations and other demo models on the same platform can be found [here](http://code.google.com/p/cscs-repast-demos/wiki/RepastSReLogo).

It is suggested that you go through the following models also, as the guiding algorithm is quite similar, although the implementation is entirely different.

  1. [BugCatcher](BugCatcher.md)
  1. [Moth\_Advance](Moth_Advance.md)



---


# 2. Introduction #

This is a Bio-inspired model. The behavior of Moths and their fascination towards light make them an excellent subject to study agent base analysis. The following page gives an introduction about the behavior and the hypothesis about the attraction of Moths towards light. For more details you can check out the following  [page](http://en.wikipedia.org/wiki/Moth)

The following video gives you a visual picture of the Moths' behavior towards light.

<a href='http://www.youtube.com/watch?feature=player_embedded&v=s_Wgukkj-cg' target='_blank'><img src='http://img.youtube.com/vi/s_Wgukkj-cg/0.jpg' width='425' height=344 /></a>


## Moth (A bit of Biology) ##

Moth is an insect closely related to the butterfly, both being of the order Lepidoptera. Moths form the majority of this order; there are thought to be 150,000 to 250,000 different species of moth (about ten times the number of species of butterfly), with thousands of species yet to be described.Most species of moth are nocturnal, but there are crepuscular and diurnal species.[1](1.md)


## Moth and Light Source ##

Moths are frequently found to circle artificial lights, although the reason for this behavior remains unknown. One hypothesis advanced to explain this behavior is that moths use a technique of celestial navigation called transverse orientation. By maintaining a constant angular relationship to a bright celestial light, such as the Moon, they can fly in a straight line. Celestial objects are so far away, that even after traveling great distances, the change in angle between the moth and the light source is negligible; further, the moon will always be in the upper part of the visual field or on the horizon. When a moth encounters a much closer artificial light and uses it for navigation, the angle changes noticeably after only a short distance, in addition to being often below the horizon.[2](2.md)


---


# Description #

The basic algorithm used in the following model is an amalgamation of the BugCatcher model algorithm and the Moth\_Basic Algorithm. Although the in this model the implementation approach is quite different.

In the Moth\_Basic model we created moths and gave them a few features. Like the are attracted to light and various parameters were adjustable by the user. Please refer to the documentation of Moth\_Basic for details.

The only assumption in the model was that, it was for a single light source at the center of the model.

The second model which catches bugs in the Moore's Neighborhood has some borrowed concept from this model. Please refer to the BugCatcher documentation for detail.

## Algorithm and Implementation ##

The guiding algorithm is fairly simple, the model has two different types of motes:

  1. Moths (Dynamic)
  1. Lights (Static)

The moths wander aimlessly in the area, as soon as a moth senses light intensity, it tries to move to a point where there is light intensity. The light source size and the intensity are both adjustable by the user. The population of the moth's can be changed by the user. Initial version does not have a turn angle control but you can add one. Check out Extending the model section for helps, tips and hints on the same. The number of light source are also adjustable. Please refer to the User Panel description for details.

**Note:** The complete source code of the model can be found [here](https://cscs-repast-demos.googlecode.com/svn/mudit/Moth_Advance/). The explanation of certain code segments (from the source code) is available here to make the reader understand the basic concept and design.

Let us first start by talking about [moth.groovy](https://cscs-repast-demos.googlecode.com/svn/mudit/Moth_Advance/src/moth_advance/relogo/Moth.groovy). This defines the characteristics of a moth.

The first thing that we need to check is weather the mote is in the vicinity on any light source or not. This is done by checking weather the there is a light source in radius of (size of the source + intensity) from the moth. This is checked by the following code segment.

```

def N = count(inRadius(lights(),(source+intensity))

```

The functions used here are [inRadius()](file:///C:/RepastSimphony-2.0-beta/docs/ReLogoDocs/repast/simphony/relogo/Turtle.html#inRadius%28List,%20Number%29) and [count()](file:///C:/RepastSimphony-2.0-beta/docs/ReLogoDocs/repast/simphony/relogo/Utility.html#count%28List%29). You can check out the links. inRadius returns an agent set which is a subset of the parameter 1 (lights()) and is in the distance (source+intensity) from the caller.
count() returns the number of agents in that agent set.

Depending on the value of N the behavior of the moths is decided. If there is a light source in vicinity.

```
                if(N>0)	
		{
                        //generate random values within source+intensity radius

			x = (random((source+intensity)))
			y = random(sqrt(((source+intensity)*    (source+intensity))-(x*x)))

                        //randomly assign signs

			if(random(2))
			{
				x=(-1)*x
			}
			if(random(2))
			{
				y=(-1)*y
			}
                      
                        //Shift the coordinates

			x = x + oneOf(inRadius(lights(),(source+intensity))).x 
			y = y + oneOf(inRadius(lights(),(source+intensity))).y 

                        //face the coordinates and move 
			facexy(x,y)
			fd(exSpeed*0.5)
		
		}
```

A random coordinate in a given radius is generated and then the value is shifted according to the position of the light source. The moth will face a point in the illuminated region then and move forward according to the selected excited speed.

The code is self explanatory (and well commented, just in case of doubts).

If the condition is false then the moth can move randomly in any direction (distance <200). A random point is generated where the moth faces and moves forward with normal speed.

Code is self explanatory. Check out the [facexy()](file:///C:/RepastSimphony-2.0-beta/docs/ReLogoDocs/repast/simphony/relogo/Turtle.html#facexy%28Number,%20Number%29), [fd()](file:///C:/RepastSimphony-2.0-beta/docs/ReLogoDocs/repast/simphony/relogo/Turtle.html#fd%28Number%29) and [random()](file:///C:/RepastSimphony-2.0-beta/docs/ReLogoDocs/repast/simphony/relogo/Utility.html#random%28Number%29) function from the documentation.

Next we move on to the static motes i.e. light. There isn't much in lights behavior and thus it is skipped in this description section. This is followed by [UserObserver.groovy](https://cscs-repast-demos.googlecode.com/svn/mudit/Moth_Advance/src/moth_advance/relogo/UserObserver.groovy). In this we have two basic functions **setup()** and **go()**. In the setup() function [clearAll()](file:///C:/RepastSimphony-2.0-beta/docs/ReLogoDocs/repast/simphony/relogo/Observer.html#clearAll%28%29). To clear the space. A user-entered number of Moths of default shape are created at random X and Y coordinates.

```

                //Given number of Moths created at random X and Y coordinates

                setDefaultShape(Moth,"default")

		createMoths(numMoths)
                {
			setxy(randomXcor(),randomYcor())
		}


```

You can check out the documentation of Relogo, to check out the functions (built-in) used in the following block. The details of [setDefaultShape()](file:///C:/RepastSimphony-2.0-beta/docs/ReLogoDocs/repast/simphony/relogo/Observer.html#setDefaultShape%28Class,%20String%29), [createMoths()](file:///C:/RepastSimphony-2.0-beta/docs/ReLogoDocs/repast/simphony/relogo/Observer.html#createTurtles%28int%29), [setxy()](file:///C:/RepastSimphony-2.0-beta/docs/ReLogoDocs/repast/simphony/relogo/Turtle.html#setxy%28Number,%20Number%29) and other functions can be found [here](file:///C:/RepastSimphony-2.0-beta/docs/ReLogoDocs/ReLogoPrimitives.html)

If you find the concept of shapes abstract, check out the shapes folder in your project explorer task bar. You will find the details of the shapes that are already made for you. You can also add your custom made shapes. These shapes can be applied to your agents just by using their names. An example of the same is in the code segment above. "default" is one of the shapes in the shape folder.

Similarly, a user defined number of lights are created.

Ask() function (in the code segment below) is also used. Ask takes two parameters, the first one is a List, which is moths() in the given case. The other one is a closure i.e. an operation. Like we intend to call the step() function of each mote and then same for the lights(). This is accomplished by the following code segment of the project.

```

               ask(moths())
               {
                        //Calls the step() function of moths 
                        
			step()
	       }


```

Rest of the code is either unedited or self - explanatory. Although [UserPanelFacrory.groovy](http://cscs-repast-demos.googlecode.com/svn/mudit/Moth_Advance/src/moth_advance/relogo/UserGlobalsAndPanelFactory.groovy) is dealt with in the next section.

## User Panel ##

https://cscs-repast-demos.googlecode.com/svn/wiki/Images_Mudit/Moth_Advance(Usr).JPG


  * **Push Button (that rebounds)**

> - Set Up : For setting up the motes in the area according to the selected options and settings.

  * **Toggle Button**

> - Go : For running the model unless the button is toggled again

  * **Sliders**

> - Number of Moths : Population

> - Normal Speed : Distance moved per tick when in non-illuminated region

> - Excited Speed : Distance moved per tick when in illuminated region

> - Intensity : The region which is illuminated (size)

> - Number of Lights : Number of Light sources

> - Source : Size of the source

## Data Sets, Outputters and External Plugins ##

_to be added soon_

## Plots ##

_to be added soon_


---


# 4. Applications #

## Moth Like Behavior ##

The moth like behavior can be found in various places. The same behavior is observed in various philosophical hypothesis and social colonies. Various other processes can be simulated using the same basic model. One such example is creation of whirlpools.

## Swarm Robotics and Mobile WSN ##

This model can be used as a basic block for swarm surveillance robots. The robots hover in a given radius of a target. The robots initially move aimlessly and as soon as they find a target they hover aimlessly around the target.


---


# 5. Extending the Model #

## Plots, Plug-ins, DataSets and Outputters ##

The model can be extended by adding various other plots and linking to various plugins. The various tutorials on plugins will be available soon. The other plots that can be incorporated are - A histogram of values of number of turtles in various regions. The user can think about different such plots.

## Moth Like Behavior ##

The present model has a behavior in which the moth tries to move to a point which has light intensity. Although the turn angle is not taken into account. The user can try to add another parameter i.e. the turn angle. The moth will only move with that angle towards the light source.

## Variable Intensity ##

Users can also try to have a intensity function dependent on the distance. The probability of moth leaving an illuminated region (given proper step size) is 0. User can modify this and assign fuzzy probability, depending on the distance.


## The "Ancient" Implementation ##

User can try implementing the initial hypothesis about moth locomotion. The details can be found [here](http://en.wikipedia.org/wiki/Moth). This can be useful for studying the "Ancient" moth locomotion.


---


# 6. References #


[1](1.md) http://en.wikipedia.org/wiki/Moth

[2](2.md) [Why Moths are attracted to flames?](http://www.npr.org/templates/story/story.php?storyId=12903572)

[3](3.md) http://ccl.northwestern.edu/netlogo/models/Moths