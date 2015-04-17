# **Summary** #

  * Model        : followTheLeader
  * Source Code  : https://cscs-repast-demos.googlecode.com/svn/mudit/followTheLeader/
  * Platform     : [RepastS ReLogo](RepastSReLogo.md)
  * Mentor       : Dr. Eric Tatara
  * Author       : [Mudit Raj Gupta](Mudit.md)

![https://cscs-repast-demos.googlecode.com/svn/wiki/Tutorial/Index.jpg](https://cscs-repast-demos.googlecode.com/svn/wiki/Tutorial/Index.jpg)


---


# Contents #



# What is this tutorial for? #

## How to use this tutorial? ##

This How-To/What-Is guide basically will help you learn how to model using RepastS with Relogo Platform. This guide does not assume any pre-requisites apart from the mentioned ones, although it is advisable to go through each question in the order in which they are given. Please
don't skip questions if you are a new user. Each question builds on to the other. Although, this guide tells you how to make a model from scratch, but you can also try other documents (_a list can be found in What other such documents are available?_).

Some part of the code is not dealt with in this tutorial. That code is mostly feature extension and does not affect the overall behavior of the
system.

Most of the figures in tutorial are numbered and the text before it explains the numbering. This numbering could be different methods, screen elements, or steps etc.

Hope you'll find this guide fun and easy to learn.

Cheers !!!

## Where is this model and who wrote this? ##

The complete commented source code of the model can be found [here](https://cscs-repast-demos.googlecode.com/svn/mudit/followTheLeader). This tutorial and model was written by [Mudit Raj Gupta](Mudit.md) under the guidance of [Dr. Eric Tatara](http://mypages.iit.edu/~tataeri/). The model is fully commented and each class and function has a description attached. The part of the code which is not explained in the tutorial is either self - explanatory or is irrelevant to the system behavior. Let us first understand a bit about multi-agent modeling.

# What to know and do before getting started? #

## What is Multi-Agent Modelling? ##

Agent-based modelling and simulation (ABMS) is a relatively new approach
to modelling complex systems composed of interacting, autonomous agents? Agents have behaviours, often described by simple rules, and nteractions with other agents, which in turn influence their behaviours. By modelling agents individually, the full effects of the diversity that exists among agents in their attributes and behaviours can be observed
as it gives rise to the behavior of the system as a whole. [1](1.md)

We are infact doing the same for this model. We are modeling artificial
ants. These ants have relatively simple behaviour, described by simple rules (which will be talked about in the nest question). This behavior is influenced by other ants and environment in which the ant is. When all ants are left to interact with  each other  in a given environment, a complex overall behavior is noticed. Let us first figure out What are we modelling?

## What are We Modelling? ##

The model is a simple multi agent model which demonstrates how the ant
lines become short as time passes.The model basically has an ant "nest"  and the "food"(refer to Fig. 1). The ants are moving from the nest to the food source.

https://cscs-repast-demos.googlecode.com/svn/wiki/Images_Mudit/Fig.%201.JPG

_Fig. 1_

Ants are guided by a set of simple rules, which are as follows :

An Ant can be either a "Leader"(first Ant coming out of the nest) or a
"Follower" (rest all Ants) (refer to Fig. 2)

**Leader Ant**
  1. It moves towards the food scent
  1. It turns at random angles and moves forward and stops on finding
food.

**Follower Ants**
  1. They start moving after a specified time delay (refer to Fig. 2
  1. They follow the ant infront of them by facing it and moving forward and stops on finding food.

https://cscs-repast-demos.googlecode.com/svn/wiki/Images_Mudit/Fig.%202.JPG

_Fig. 2_

Initially, ants take a longer route from nest to food. (refer to Fig. 3,
denoted by red line). The following ants take smaller routes (refer to
Fig. 4, denoted by blue lines) and finally the last ant takes the smallest route (refer to Fig 5, denoted by green line).

https://cscs-repast-demos.googlecode.com/svn/wiki/Images_Mudit/Fig.%203.JPG

_Fig. 3_

https://cscs-repast-demos.googlecode.com/svn/wiki/Images_Mudit/Fig.%204.JPG

_Fig. 4_

https://cscs-repast-demos.googlecode.com/svn/wiki/Images_Mudit/Fig.%205.JPG

_Fig. 5_

Keep on reading to find the prerequisites in the next section to make
this model. You also check out the analysis in _What are the observations?_ (Although I would suggest making the model first and then
reading the question, again go sequentially.)

## What are the Prerequisites? ##

Before we can do anything with ReLogo, we need to make sure that we have
a proper installation of Repast Simphony (version 2.0 Beta, released on
12/3/2010 or later). Instructions on downloading and installing Repast
Simphony on various platforms can be found [here](http://repast.sourceforge.net/download.html). After installing go
to the default/recommended setting for relogo. After installing the software open it.

If you are opening RepastS for the first time, it asks for a default
workspace (refer to Fig. 6). The workspace is a directory used to store
the models which you create, along with several settings. Do the
following:
  1. Select a desired workspace, using the Browse.
  1. Check on _Use this as default and do not ask again_
  1. Click on OK

https://cscs-repast-demos.googlecode.com/svn/wiki/Images_Mudit/Fig.%206.JPG

_Fig. 6_

and switch to Relogo prospective using the following step:

  1. Go to the extreme top right corner and select relogo prospective (refer to Fig. 7)
  1. If it  is not available, click  on the double arrow to get a drop down menu (refer to Fig. 8)
  1. Select Relogo prospective by clicking it (refer to Fig. 8)

![http://cscs-repast-demos.googlecode.com/svn/wiki/Images_Mudit/Fig.%207.jpg](http://cscs-repast-demos.googlecode.com/svn/wiki/Images_Mudit/Fig.%207.jpg)

_Fig. 7_

![http://cscs-repast-demos.googlecode.com/svn/wiki/Images_Mudit/Fig.%208.jpg](http://cscs-repast-demos.googlecode.com/svn/wiki/Images_Mudit/Fig.%208.jpg)

_Fig. 8_

Now let us have a look at various elements on your screen (Windows 7 screenshots). The figure mentions various blocks which are either self -
explanatory or will be dealt later in the guide(refer to Fig. 9). Since
it is an introductory guide, some parts are left unmarked, to be
explored by the user

![http://cscs-repast-demos.googlecode.com/svn/wiki/Images_Mudit/Fig.%209.jpg](http://cscs-repast-demos.googlecode.com/svn/wiki/Images_Mudit/Fig.%209.jpg)

_Fig. 9_

The Elements are as follows:

  1. New, Save, Save All, Print (Left to Right)
  1. Bug, Run (Left to Right)
  1. New Relogo Project, Turtle, Link Patch Observer (Left to Right)
  1. Prospective
  1. Project Explorer
  1. Working Space
  1. Console

Note : The elements can be customized according to user requirements.
Let us look at various steps in making this model.

# How to make the model? #

## How to make a new project? ##

The first thing you need to do while making a model is make a new
project. This can be done by various means :

  1. _File >> New >> Relogo Project_ (refer to Fig. 10)
  1. _New Project Button >> Relogo Project_ (refer to Fig. 11)
  1. Click on the _New Relogo Project_ icon (refer to Fig.11)

http://cscs-repast-demos.googlecode.com/svn/wiki/Images_Mudit/Fig.%2010.JPG

_Fig. 10_

http://cscs-repast-demos.googlecode.com/svn/wiki/Images_Mudit/Fig.%2011.JPG

_Fig. 11_

After any of the mentioned options a New Project _wizard_ appears on the screen. Do the following (refer to Fig. 12):

  1. Enter the name of the project "followTheLeader" in the Project Name Field.
  1. Click on _Next_

![http://cscs-repast-demos.googlecode.com/svn/wiki/Images_Mudit/Fig.%2012.jpg](http://cscs-repast-demos.googlecode.com/svn/wiki/Images_Mudit/Fig.%2012.jpg)

_Fig. 12_

After clicking the _Next_ button the wizard should look like Fig. 13. Click on the _Finish_ button

http://cscs-repast-demos.googlecode.com/svn/wiki/Images_Mudit/Fig.%2013.JPG

_Fig. 13_

After _Finish_ the wizard will create a tree structure of the new
project, and once it is done you can view your project in the project explorer. Click on the small arrow to view the sub directories. In the source folder you will find default classes. The structure should look like Fig. 14

http://cscs-repast-demos.googlecode.com/svn/wiki/Images_Mudit/Fig.%2014.JPG

_Fig. 14_

Let us see what is a turtle and how can we add one in our project.

## How to add Turtle behavior? ##

"Turtles" or "Agents" are the basic building blocks of a multi-agent model. We also need "Ant" type turtles. We will first define the behavior of these ants using simple rules which were explained above and in further sections we will see how to create them and change their behaviors.

Let us first see how to add a turtle class to your project.
Select _project explorer >> followTheLEader >> src >> followtheleader.relogo then you can follow any of the two methods:_

  1. _Right Click on followtheleader.relogo >> New >> Turtle_ (refer to Fig. 15)
  1. Click on the _New Turtle_ button. (refer to Fig. 15)

![http://cscs-repast-demos.googlecode.com/svn/wiki/Images_Mudit/Fig.%2015.jpg](http://cscs-repast-demos.googlecode.com/svn/wiki/Images_Mudit/Fig.%2015.jpg)

_Fig. 15_

After the above command a new turtle dialog box appears on the screen. Follow the given steps (refer to Fig. 16):

  1. Click on the _Name_ field and enter name. "Ant" for our project.
  1. Click on _Generate Comments_ to automatically generate comments. (It might be useful)
  1. Click on _Finish_

![http://cscs-repast-demos.googlecode.com/svn/wiki/Images_Mudit/Fig.%2016.jpg](http://cscs-repast-demos.googlecode.com/svn/wiki/Images_Mudit/Fig.%2016.jpg)

_Fig. 16_

After doing this, check your project's Directory structure, it will have a new class in the _followTheLeader >> src >>
followtheleader.relogo_ with the name "Ant.groovy" (refer to Fig. 17)

![http://cscs-repast-demos.googlecode.com/svn/wiki/Images_Mudit/Fig.%2017.jpg](http://cscs-repast-demos.googlecode.com/svn/wiki/Images_Mudit/Fig.%2017.jpg)

_Fig. 17_

Double click on Ant.groovy and you will be able to see the file. It
should look like Fig. 18

![http://cscs-repast-demos.googlecode.com/svn/wiki/Images_Mudit/Fig.%2018.jpg](http://cscs-repast-demos.googlecode.com/svn/wiki/Images_Mudit/Fig.%2018.jpg)

_Fig. 18_

Now we will start writing the code for describing the behavior of an Ant. The behavior and variables described and used in this are with all the ants. Let us first look at few variables that are used in "Ant.groovy" and why.

```
	def leader=0    //Is Set if the Ant is a Leader
	def follower=0  //Is Set if the Ant is a Follower
	def moved = 0   //Counts the number of steps moved
	def enable = 0  //Is Set if the Ant is ready to go from nest to food
	def disable=0   //Is Set if the Ant reaches the food pile 
```

So, an Ant at all times will be aware of the number of steps it took, using the "moved" variable and weather it is a "leader" or a "follower". Using "enable" and "disable" the Ant can figure out weather it is in the nest or in a food pile.

Now let us see how these variables will be guiding an ant's behavior

Note: Both _leader-follower_ and _enable-disable_ could have been
clubbed into two variables, but they are taken separately for
explanation sake.

First we look at the step() function that is present in all the _Ants_ and is called at periodic interval of time.

```

def step()
	{
		if(!disable)//if not in nest 
		{
			if(leader)//if ant is a leader ant
				moveLeader()
				
			
			else//if follower ant
				moveFollower()

		if(enable||leader)//If moving from nest to food update various 
parameters
			update()				
		}
	}

```

If an ant is not in nest and if it the leader then moveLeader() is
called, else if it is a follower ant moveFollower() is called. We will look into these function after a while. If an Ant is moving from nest to food (i.e it is an "enable" follower or leader.) it should update few parameters. Let us look at these functions one-by-one.

```

def moveLeader()
{

        //Face the center of the food pile
	facexy(8,0)

	//randomly face any direction
	if(random(2))
		left(random(dev))
	else
		left(-1*random(dev))
}

```

If a "Leader" ant has to move, it will face the center of the food pile, using the function _facexy(8,0)_. facexy(x,y) will make the turtle face towards a point given by (x,y) coordinates. For other such functions and details, view
[this](http://repast.sourceforge.net/docs/api/relogo/index.html), infact it is advisable that is you are reading the tutorial online open the above mentioned link and
[this](http://repast.sourceforge.net/docs/api/relogo/ReLogoPrimitives.html)

Similarly, _random(2)_ is used to generate random number 0 or 1.
_random(n)_ generates random numbers in the interval (0,n]. Similarly, _random(dev)_ will generate random numbers less than "dev". We will get back on to how the variable "dev" is set later.

So, an ant can randomly move to it's right(there is a (-)ve sign) or left. The function _left()_ used in the code is used turn the turtle at a given angle to it's left. The turtle will turn at random angles also.

Similarly let us look at the moveFollower()

```

def moveFollower()
{
	//If the turtle in front has taken a given number of steps
	if(turtle(getWho()-1).moved>lapse)
	{
		enable=1
		st()	
		face(turtle(getWho()-1))
	}
}
```


This part of code might look a bit tricky, but lets analyze it from the starting.

First of all the getWho() function used will give the ID of the ant
which is calling it. Each ant when created will have an ID given to it by default. So, getWho()-1 will be the ant with ID 1 less than the present. So, if the (getWho()-1).moved > lapse, i.e. if the "moved" variable of the ant just before the present one has a higher value than "lapse" then the following block will be executed."Lapse" is again a variable about which we will talk about in the coming sections. It is basically a time delay between two ants.

If it is so, the ant is enabled. _st()_ is also a pre-defined function, it just makes the turtle visible. _turtle(n)_ is another function that is used, it returns the turtle corresponding to ID number  = n. So, _face(turtle(getWho()-1))_ is quite self explanatory.

So, basically if a turtle is a follower turtle, it will face the
turtle which is in front of it, provided the turtle in front have been moving for greater than "lapse" period of time.

Once the ants are facing where they have to, let us look at the
_update()_ function. This will be called for all those ants who are
enabled and also for the leader, i.e. all those ants which are moving from the "nest" to the "food".

```
def update()
{
	moved++
	forward(0.5)
	
	//If it finds food
	if(patchHere().food)
	{
		ht()
		disable=1
	}
}
```

"moved" gets updated. _forward(n)_ function is used to move the ant forward, in the direction in which it was facing for a specified number of steps.

If the ant finds food in it's new position, it will be disabled. The _patchHere()_ function used here will give the patch on which the ant is on. "food" is a variable in the UserPatch class _(More on this later)_.
But what exactly are patches. Well, lets first look at a small piece of code before answering this question.

```

//sets leader to 1
def setLeader()
{
	leader=1
}

//sets follower to 1
def setFollower()
{
	if(!leader)
	{
		ht()
		follower=1
	}
}
```

The code is quite self explanatory, but the importance of this segment is, when are these functions called? Well, they are called from the "UserObserver.groovy" at the time of creation of ants. We will get back to that later.

Now we have defined the behavior of an ant, check out the [] marked section in the above question for the overall behavior. This is quite similar to the one we described in Whar are we modeling?

The overall "Ant.groovy" code should look like this :
```

class Ant extends BaseTurtle 
{
	def leader=0    //Is Set if the Ant is a Leader
	def follower=0  //Is Set if the Ant is a Follower
	def moved = 0   //Counts the number of steps moved
	def enable = 0  //Is Set if the Ant is ready to go from nest to food
	def disable=0   //Is Set if the Ant reaches the food pile
	
	def step()
	{
		if(!disable)//if not in nest 
		{
			if(leader)//if ant is a leader ant
				moveLeader()
				
			
			else//if follower ant
				moveFollower()

		if(enable||leader)//If moving from nest to food update various 
parameters
			update()				
		}
	}
}

def moveLeader()
{
	facexy(8,0)//Face the center of the food pile

	//randomly face any direction
	if(random(2))
		left(random(dev))
	else
		left(-1*random(dev))
}

def moveFollower()
{
	//If the turtle in front has taken a given number of steps
	if(turtle(getWho()-1).moved>lapse)
	{
		enable=1
		st()	
		face(turtle(getWho()-1))
	}
}

def update()
{
	moved++
	forward(0.5)
	
	//If it finds food
	if(patchHere().food)
	{
		ht()
		disable=1
	}
}
	
	
def setLeader()
{
	leader=1
}

def setFollower()
{
	if(!leader)
	{
		ht()
		follower=1
	}
}

}

```

**Note:** The terms "turtle" and "ant" are used interchangeably through out the guide. Both refer to "agents", turtle is a general term related to modeling using Relogo, whereas, ant is specific to this model.

Comment:You can have more than one type of turtles in your models.
[GuidingBots](GuidingBots.md) and Zombies are two such models. You can add a new turtle type following the steps mentioned above. You can then add a behavior and you can even make turtles interact and change each others' behavior. Go through the [GuidingBots](GuidingBots.md) documentation of Relogo getting started guide [Zombies](http://repast.sourceforge.net/docs/ReLogoGettingStarted.pdf) for details.

Let us now look at what are patches?

## How to add Patch behavior? ##

In the above section we saw how we can give behavior to turtles. But we
know that the behavior of the turtles is not only dependent on other
turtles but also on the environment. Turtles move in the environment and
thus change or modify their behavior. So, how do we do that? There
comes patches. Although, you will explore many other uses of Patches as
you continue to play with multi agent modeling. For, now lets define
patch properties for different parts of a simple environment.

We can add patches in a similar way we added turtles. But we will be
using the default _UserPatch.groovy_ that was created when we created
our project. You can find it in the project explorer (Fig. 19). Double
click on it to open and work with it.

![http://cscs-repast-demos.googlecode.com/svn/wiki/Images_Mudit/Fig.%2019.jpg](http://cscs-repast-demos.googlecode.com/svn/wiki/Images_Mudit/Fig.%2019.jpg)

_Fig. 19_

Although we can add the a new patch (refer to Fig. 15 & 16 ant try
finding a new patch button). The steps after that are similar, till you
get a your patch in the Project Explorer.

To start with lets look at the variable description first.

```
        @Diffusible
	def food=0 //Is set if it is a food patch
	def nest=0 // Is set if it is a nest patch
```

The two variables are not only visible in UserPatch.groovy, but can also
be modified by other classes. This is so because they are declared as
@Diffusible. This annotation is used to make a variable modifiable by turtles.

Now let's see how to set properties of a patch to a "Food Patch"

```
//Sets a patch as a Food patch
	def setFood()
	{
		if(getPxcor()==8&&getPycor()==0)
		{
			food=1
			setPcolor(green())
		}
	}
```

This function is used to set a patch a "Food Patch". We will call this
function from "UserObserver.groovy" _(More on that later)_

The functions used here are getPxcor() and getPyCor(). It gives the x
and y coordinate of the patch. If it is same as the food location, i.e.
(8,0) then the following code is executed.

**Note :** Scroll to the patch section in the quick reference which you
opened in the other tab to know more patch related functions. You can
also try the [Ant](Ant.md) model in which the patches are used extensively.

You can also compare the coordinates to a range of values to make bigger
nests and food piles. You can also go through the [areaCoverage](areaCoverage.md) model
to arrange the patches in different shapes.

Similarly, we can add a makeNest() function. This will convert the patch
into a Nest patch. So, the overall UserPatch.groovy should look like
this :

```

class UserPatch extends BasePatch
{
	@Diffusible
	def food=0
	def nest=0
	
	//Sets a patch as a Food patch
	def setFood()
	{
		if(getPxcor()==8&&getPycor()==0)
		{
			food=1
			setPcolor(green())
		}
	}
	
	//Sets a patch as a Nest Patch
	def setNest()
	{
		if(getPxcor()==-8&&getPycor()==0)
		{
			nest=1
			setPcolor(yellow())
		}
	}
}
```

So, we have created agents and environment, now lets look at how to
create simple links.

## How to add link behavior? ##

Although we have not added any Links in this model, but adding a link is
useful in networking models and models imitating social behavior. You
can do so by modifying _UserLink.groovy_ (Fig. 20) or adding a new link.


![http://cscs-repast-demos.googlecode.com/svn/wiki/Images_Mudit/Fig.%2020.jpg](http://cscs-repast-demos.googlecode.com/svn/wiki/Images_Mudit/Fig.%2020.jpg)

_Fig. 20_

For adding a new link, follow the same steps as those for adding a new
turtle, but select _new link_ in place of _new turtle_. A model which
has an extensive use of links is the [GuidingBots](GuidingBots.md) model.

## How to add Observers? ##

Now, we have defined the behavior of ants and links and properties of
patches. Next we will modify the "UserObserver.groovy" (refer to fig.
21) file and create ants, links and patches. We will also call some
functions of these classes, either iteratively or once.

![http://cscs-repast-demos.googlecode.com/svn/wiki/Images_Mudit/Fig.%2021.jpg](http://cscs-repast-demos.googlecode.com/svn/wiki/Images_Mudit/Fig.%2021.jpg)

_Fig. 21_

You can also make a new observer. Follow the similar steps as that of
making a new turtle but select the _new observer_ button instead.
(Search in Fig.15)

Let us first begin by making a _setup()_ function

```
	def setup(){
			clearAll()
			ask(patches())
			{
				setFood()
				setNest()
			}
					
```

First we will Clear everything by using _claerAll()_. The next thing we
have to do is setup "Nest" and "Food". For doing this we query all the
patches by using _ask(patches())_ function. We then call _setFood()_ and
_setNest()_ function for all the patches(). The _setFood()_ and
_setNest()_ functions are defined in _How to add patch behavior?_.

Next we will create both leader and follower ants.

```
setDefaultShape(Ant,"turtle")
			createAnts(1)
			{
				setxy(-8,0)
				setColor(red())
			}
			ask(ants()){
				setLeader()
			}
			createAnts((numAnts-1))
			{
				setxy(-8,0)
				setColor(red())
			}
			ask(ants()){
				setFollower()
			}

```

For creating ants we first fixed a default shape. You can do so by using
a function _setDefaultShape(Turtle Type, "shape")_
Turtle Type is same as your class name and "shape" is an image file
saved in the _followTheLeader >> shapes_ directory. We have used
one of the shapes available, i.e. "turtle" (refers to turtle.svg).
(refer to Fig. 22 for details)

![http://cscs-repast-demos.googlecode.com/svn/wiki/Images_Mudit/Fig.%2022.jpg](http://cscs-repast-demos.googlecode.com/svn/wiki/Images_Mudit/Fig.%2022.jpg)

_Fig. 22_

Once you have set the default shape, you can create turtles.
_createAnts(number)_ is used. This function creates the specified
"number" of ants. "numAnts" is again an adjustable variable and we will
deal with it later. _setxy(x,y)_ is used to create the ant at a
specified (x,y) location. _setColor(num)_ function is used to set the
color of the ant equivalent to the color represented by "num"._red()_
returns the number corresponding to red color.

So, we are basically making one ant at (-8,0), i.e. in nest, of red
color and calling the _setLeader()_ function of this ant using the
_ask()_. Then we are creating "numAnts"-1 number of ants and calling the
_setFollower()_ function. So basically we have created leader and
follower ants.

Next we make a _go()_ function to call the _step()_ function of all the
ants. The complete code for UserObserver.groovy would look like this :

```
class UserObserver extends BaseObserver{

	
	def setup(){
			clearAll()
			
			ask(patches())
			{
				setFood()
				setNest()
			}
			
			setDefaultShape(Ant,"turtle")
			createAnts(1)
			{
				setxy(-8,0)
				setColor(red())
			}
			ask(ants()){
				setLeader()
			}
			createAnts((numAnts-1))
			{
				setxy(-8,0)
				setColor(red())
			}
			ask(ants()){
				setFollower()
			}
		}
			
		def go()
		{
			ask(ants())
			{
				step()
			}
		}
	}	

```

Now we have done everything i.e. defined the behavior of ants, set up
the environment using Userpatch, defined links and finally created
links, turtles and environment and the overall guiding functions in the
UserObserver. Our model is almost ready to run.

Did we forget anything? Well, yes we did. Remember those variables which
we left - "numAnts", "dev" etc. Well the next section talks about the
same.

## How to add User Panel? ##

Let us now look at how we can change the various parameters of our model
for different runs, without modifying the code. For this we have to
modify the UserGlobalPanelFactory.groovy. This you can find in
_followTheLeader >> src >> followtheleader >> UserGlobalFactory.groovy_ (refer to Fig. 23)

http://cscs-repast-demos.googlecode.com/svn/wiki/Images_Mudit/Fig.%2023.JPG

_Fig. 23_

Let us first look at the code

```


public class UserGlobalsAndPanelFactory extends 
AbstractReLogoGlobalsAndPanelFactory{
	public void addGlobalsAndPanelComponents(){
	
		addButtonWL("setup", "Setup")
		addButtonWL("go","Go Once")
		addToggleButtonWL("go", "Go")
		addSliderWL("numAnts", "Population", 50,1,400,100)
		addSliderWL("lapse", "Time Delay", 1,1,5,2)
		addSliderWL("dev", "Deviation", 1,1,140,90)
		
		}
}
```

We made two functions _setup()_ and _go()_ in our _UserObserver.groovy_
class. We can call these functions on button clicks. So we added two
buttons with label using _addButtonWL("function", "Label")_. When
pressed they will call the function with the same name as the first
parameter once.

Next we added a toggle button. Once this button is pressed, it will call
the "go" function iteratively till it's toggled again.
This is followed by sliders with labels. The three sliders with label to
set the three variables which we have already used, i.e. "numAnts",
"lapse", "dev".

Now out followTheLeader model complete and ready to run. Lets see how to
run this model.

# How to run the model and what all I can do during run time? #

## How to run the model? ##

You can run your model by clicking at the drop down arrow (green box)
along with the run button (red box) (refer to Fig. 24).

http://cscs-repast-demos.googlecode.com/svn/wiki/Tutorial/Fig.%2024.JPG

_Fig. 24_

Select your model name, i.e. "followTheLeader". (refer to Fig. 25)

http://cscs-repast-demos.googlecode.com/svn/wiki/Tutorial/Fig.%2025.JPG

_Fig. 25_

Once you selected your model, you will get a new window like the one
shown in Fig. 26._(It might take few seconds for your model to load)_

![http://cscs-repast-demos.googlecode.com/svn/wiki/Tutorial/Fig.%2026.jpg](http://cscs-repast-demos.googlecode.com/svn/wiki/Tutorial/Fig.%2026.jpg)

_Fig. 26_

In this you will find the following elements :

  1. Save
  1. Initialize, play, forward and reset (from Left to right)
  1. External Plug-ins
  1. Tick Counter
  1. User Panel
  1. Model
  1. Scenario Tree/Run Options/ Simulation Parameters

**Note:**
  1. Click on _Initialize >> setup_ to setup the model
  1. Do not press the setup button before initializing the model or your
tick counter will keep on running.

Most of the parts are self explanatory and rest will be dealt in future.

## How to use the User Panel? ##

So, one of the elements mentioned above was a User Panel. We already
wrote the code for the User Panel in _UserGlobalFactory.groovy_. The
user panel will look like this :

http://cscs-repast-demos.googlecode.com/svn/wiki/Tutorial/Fig.%2027.JPG

_Fig. 27_

You can change various parameters of the model using these controls. The
changes take place in real time.

## How to add Data Sets? ##

So, we have made Follow The Leader model. Now once the model is running
you might want to know how to monitor various parameters or may be
visualize the changes on a graph. Well, for doing so, we need to create
data sets. Data Sets are nothing but the value of various variables,
sampled at a given instance of time.

For adding a data set to your model follow the following steps:

When your model is loaded, go to the scenario tree and search for _DataSets_. Right click on the the option and the select _Add Data Set_ (refer to Fig. 28)

http://cscs-repast-demos.googlecode.com/svn/wiki/Tutorial/Fig.%2028.JPG

_Fig. 28_

On clicking this a _Data Set Editor_ pops up. Follow these steps : (refer to Fig. 29)

http://cscs-repast-demos.googlecode.com/svn/wiki/Tutorial/Fig.%2029.JPG

_Fig. 29_

  1. Give a name to your Dataset by filling the _Data Set ID_ field. Let's call it "Difference"

  1. Select the _Agent Class_ from which you want the dataset. Click on the scroll down button to see a list of all classes.

  1. Let's select (by clicking) _UsereObserver_ class for this.

  1. Click on _Next_

On clicking you will be given _Agent Mapping_ options. (refer to Fig. 30)


http://cscs-repast-demos.googlecode.com/svn/wiki/Tutorial/Fig.%2030.JPG

_Fig. 30_

  1. Click on _Add_ and a new column (4) and Source (2) appears.
  1. Click on small drop down arrow to see a list of sources available.
  1. Scroll down and select _timestamp():Object_ from the list. Remember making a _timestamp()_ function in the _UserObserver_ class earlier in this section.
  1. Give a nice name to this value, say "Time". Just click on the present name and you can edit it then. Repeat Steps (1-4) for _getFr():Object_ **and _getPr()_** Object with names _Steps taken by first Ant_ and _Steps taken by present Ant_ respectively.
  1. **IF** you added an extra data set you can delete it using this.
  1. Now lets tell RepastS about the number of series. For doing this click on a drop down button and select _add using wizard_ (refer to Fig. 31)


http://cscs-repast-demos.googlecode.com/svn/wiki/Tutorial/Fig.%2031.JPG

_Fig. 31_

> 7


http://cscs-repast-demos.googlecode.com/svn/wiki/Tutorial/Fig.%2032.JPG

_Fig. 32_

> 8


http://cscs-repast-demos.googlecode.com/svn/wiki/Tutorial/Fig.%2033.JPG

_Fig. 33_

> 9

  1. 
  1. 
  1. 

Your agent mapping should look like this(refer to Fig. 35) :


http://cscs-repast-demos.googlecode.com/svn/wiki/Tutorial/Fig.%2049.JPG

_Fig. 34_

click on Next and you will get optiosn to change the scheduling parameters. (refer to Fig. 35)


http://cscs-repast-demos.googlecode.com/svn/wiki/Tutorial/Fig.%2034.JPG

_Fig. 35_

Let us keep these parameters as they are and click on _Finish_

Now, it's the **Most Important** part. Do not forget to save the changes using the _Save Button_ (refer to Fig. 36)

![http://cscs-repast-demos.googlecode.com/svn/wiki/Tutorial/Fig.%2035.jpg](http://cscs-repast-demos.googlecode.com/svn/wiki/Tutorial/Fig.%2035.jpg)

_Fig. 35_

We have successfully added a Data Set _(Check the Scenario Tree)_. Let's see how we can use it. So, lets try to create a chart using this data set.

## How to add Charts? ##

So for adding a Chart.

Go to _Scenario Tree >> Charts(right click) >> Add Chart(click)_ (refer to Fig. 36)

http://cscs-repast-demos.googlecode.com/svn/wiki/Tutorial/Fig.%2036.JPG

_Fig. 36_

You will be given an option to select Data Source (refer to Fig. 37)

http://cscs-repast-demos.googlecode.com/svn/wiki/Tutorial/Fig.%2037.JPG

_Fig. 37_

  1. Select _XY Line or Bar Chart, or  Scatterplot_
  1. Select _Next_

You will be asked to set the _Chart Data Mapping_ (refer to Fig. 38)

![http://cscs-repast-demos.googlecode.com/svn/wiki/Tutorial/Fig.%2038.jpg](http://cscs-repast-demos.googlecode.com/svn/wiki/Tutorial/Fig.%2038.jpg)

_Fig. 38_

  1. Give a Name, say "Difference between first and present ant"
  1. Select _DataSet_ i.e. _Difference_

Now you have to set the x axis values : (refer to Fig. 39)

![http://cscs-repast-demos.googlecode.com/svn/wiki/Tutorial/Fig.%2039.jpg](http://cscs-repast-demos.googlecode.com/svn/wiki/Tutorial/Fig.%2039.jpg)

_Fig. 39_

Go to the _X-Axis Column_  and click on the small drop down button to get a list. Select _Time_ (Remember we gave the name time to an object while making data set "Difference")

Let us now set y-axis values :

http://cscs-repast-demos.googlecode.com/svn/wiki/Tutorial/Fig.%2040.JPG

_Fig. 40_

  1. Click on _Add_
  1. A new _Series_ will be added
  1. Click on the small drop down button to get a list of options available.
  1. Select _Steps taken by present Ant_ (Remember adding the same while making "Difference" Data Set. In the _Series Name_ section select _Mapping0_, so that to tell RepastS that is the first series. Do the same for _Steps taken by present Ant_ and add _Mapping1_
  1. **IF** you add an extra Series, just select it and click on _Remove_

Your _Chart Data Mapping_ should look like this (refer to Fig. 41)

![http://cscs-repast-demos.googlecode.com/svn/wiki/Tutorial/Fig.%2041.jpg](http://cscs-repast-demos.googlecode.com/svn/wiki/Tutorial/Fig.%2041.jpg)

_Fig. 41_

Click on _Next_  and you will be given the options of _Visual Settings_ (refer to Fig. 42)

http://cscs-repast-demos.googlecode.com/svn/wiki/Tutorial/Fig.%2042.JPG

_Fig. 42_

You have many options here, like the highlighted one is about _Type of Chart_. We will select a _Line Chart_

If you look around, you will find the options to change X-axis properties, Y-axis properties and general properties. Let us change some:

_X-Axis Properties >> Auto range(deselect)  >> Fixed minimum (enter value **0.0**) >> Fixed maximum (enter value **500.0**)_

Rest options are left for the user to explore. _(Let them be as they are i.e. Default for this run)_

Your Final _Visual Settings_ should look like this

![http://cscs-repast-demos.googlecode.com/svn/wiki/Tutorial/Fig.%2043.jpg](http://cscs-repast-demos.googlecode.com/svn/wiki/Tutorial/Fig.%2043.jpg)

_Fig. 43_

Click on _Next_ an then _Finish_ (refer to Fig. 44)

http://cscs-repast-demos.googlecode.com/svn/wiki/Tutorial/Fig.%2044.JPG

_Fig. 44_

Do not forget to save your setting.
Go to the scenario tree and check under charts, you will see the chart "Difference between first and present ant" there. Now to see this chart you need to (refer to Fig. 45):

![http://cscs-repast-demos.googlecode.com/svn/wiki/Tutorial/Fig.%2045.jpg](http://cscs-repast-demos.googlecode.com/svn/wiki/Tutorial/Fig.%2045.jpg)

_Fig. 45_

  1. Refresh
  1. Initialize
  1. Change Parameters (if you want)
  1. Setup
  1. Go

**Note :** Some screen shorts are taken after adding the code described in How to extend the model? So some paramenters in the User Panel may differ.

You will see your model running. Click on the _Difference between first and present ant_ at the bottom to view the chart. (refer to Fig. 46)

![http://cscs-repast-demos.googlecode.com/svn/wiki/Tutorial/Fig.%2046.jpg](http://cscs-repast-demos.googlecode.com/svn/wiki/Tutorial/Fig.%2046.jpg)

_Fig. 46_

We have successfully added a chart to our mode. Let us look at how we can change it's appearance during run time.

Right click anywhere on the chart a pop up menu will appear. Select _Properties_. Rest options are self - explanatory. (refer to Fig. 47)

http://cscs-repast-demos.googlecode.com/svn/wiki/Tutorial/Fig.%2047.JPG

_Fig. 47_

You will get options to change the Title, Plot properties or other. (refer to Fig 48).

http://cscs-repast-demos.googlecode.com/svn/wiki/Tutorial/Fig.%2048.JPG

_Fig. 48_


Let us change the background from white to black. To do so  Select _Plot_ from the three tabs. The window now will look like this (refer to Fig. 49):


  1. Go to _Appearance_
  1. In the background paint section _Select..._
  1. A new window pops up. Select the color and click _OK_
  1. Click _OK_

You have successfully changed the color of the background. (refer to fig 50)

![http://cscs-repast-demos.googlecode.com/svn/wiki/Tutorial/Fig.%2050.png](http://cscs-repast-demos.googlecode.com/svn/wiki/Tutorial/Fig.%2050.png)

_Fig. 50_

You can change other properties like color of the axes and font. This is left to the user to explore. Now let us see how to add outputters.

## How to add outputters? ##

Outputters are nothing but a .txt file that stores your data set in comma separated values (or what you specify) format. Adding these outputers can help you analyze your data after run and find out different possibilities.

Go to the Scenario Tree and right click on _Outputters_ (you might have to scroll down a bit) and select _Add File Outputter_ (refer to Fig. 53)

http://cscs-repast-demos.googlecode.com/svn/wiki/Tutorial/Fig.%2053.JPG

_Fig. 53_

This will open a _File Outputter Wizard_ (refer to Fig. 54).

http://cscs-repast-demos.googlecode.com/svn/wiki/Tutorial/Fig.%2054.JPG

_Fig. 54_

  1. Give a name to your Outputter. Let us call it "Difference Out"
  1. Set the Data Set. _Difference_
  1. Select Delimiter. We are using the default, i.e. comma (,)
  1. Select the values which you want in the output
  1. Click on this button to add the selected value. Repeat (4) and (5) for all the values.

After the above steps the window should look like this (refer to Fig. 55):

http://cscs-repast-demos.googlecode.com/svn/wiki/Tutorial/Fig.%2055.JPG

_Fig. 55_

Click on _Next_. In the new window you can change the name of the Output File. We are using the default "ModelOutput.txt". (refer to Fig. 56)

http://cscs-repast-demos.googlecode.com/svn/wiki/Tutorial/Fig.%2056.JPG

_Fig. 56_

Click _Finish_

You have successfully added an outputter to your model. You can check that it is created in _Scenario Tree >> Outputters  >> DifferenceOut_

If you do a test run. (refer to Fig. 57) and then check your followTheLeader folder in the Project Explorer (refresh it by right clicking on followTheLeader and selecting refresh or just ctrl + F5) you will see a text file with the same name you gave. (refer to Fig. 57)

http://cscs-repast-demos.googlecode.com/svn/wiki/Tutorial/Fig.%2057.JPG

_Fig. 57_

Click on the file to see the values of the last run. Now lets see an interesting feature of RepastS, adding external plug-ins.

## How to add external plug-ins? ##

There are many external plug-ins available with RepastS. They are useful as you can analyse your data in any of these software. Different software are better for different purposes. Adding a pugin means running the program in parallel to your model. Let us see how to add a spreadsheet plug-in in your model.

Go to the plug-ins section which has icons for different plug-ins. Select _Spreadsheet_

http://cscs-repast-demos.googlecode.com/svn/wiki/Tutorial/Fig.%2056.JPG

_Fig. 56_

A _Spreadsheet's licence_ will be displayed since it is an external tool and has a different license. (refer to Fig. 57)

http://cscs-repast-demos.googlecode.com/svn/wiki/Tutorial/Fig.%2057.JPG

_Fig. 57_

Click _Next_. Now set the path to the .exe file. (refer to Fig. 58)

http://cscs-repast-demos.googlecode.com/svn/wiki/Tutorial/Fig.%2058.JPG

_Fig. 58_

Click _Next_. Now select the outputter(s) that you want to add to the spreadsheet. Select _Difference Out_ in our case.
(refer to Fig. 59)

http://cscs-repast-demos.googlecode.com/svn/wiki/Tutorial/Fig.%2059.JPG

_Fig. 59_

Click _Finish_. You have successfully added a spreadsheet plug-in to your model.

# What are the Outcomes and how can I have further control? #

## What are the observations? ##

The model which we made had some interesting outputs, two of them were
studied and rest are left to the user.

**Relationship between the length of the path and population**

The parameters "Time Delay" and "Deviation" were kept constant and four
different runs were conducted for varying population.

| Run |Population| Fig. No |
|:----|:---------|:--------|
| 1   |    50    |   (i)   |
| 2   |    100   |   (ii)  |
| 3   |    200   |   (iii) |
| 4   |    400   |   (iv)  |

http://cscs-repast-demos.googlecode.com/svn/wiki/Images_Mudit/Population50.JPG

_Population
> Fig. (i)_

http://cscs-repast-demos.googlecode.com/svn/wiki/Images_Mudit/Population100.JPG

_Population
> Fig. (ii)_

http://cscs-repast-demos.googlecode.com/svn/wiki/Images_Mudit/Population200.JPG

_Population
> Fig. (iii)_

http://cscs-repast-demos.googlecode.com/svn/wiki/Images_Mudit/Population200.JPG

_Population
> Fig. (iv)_

**Note:** Red Line is the path foe the first ant, Blue lines are the path
traced by every 15th follower ant and Green Line is the path of the last
> ant.

Although, all the runs were random, but a  general trend is observed. As
> the population increases the final path becomes smoother and shorter.
Although in this case the deviation was kept constant but if the
deviation is "High" you will need a large population to obtain a smooth
final path. Similarly, if
in the deviation is "Low" then you need less population of ants. The
influence of time delay is checked using the following test runs.

| Run |Time Delay| Fig. No |
|:----|:---------|:--------|
| 1   |    1     |   (i)   |
| 2   |    2     |   (ii)  |
| 3   |    3     |   (iii) |
| 4   |    4     |   (iv)  |

http://cscs-repast-demos.googlecode.com/svn/wiki/Images_Mudit/Delay1.JPG

_Delay
> Fig. (i)_

http://cscs-repast-demos.googlecode.com/svn/wiki/Images_Mudit/Delay2.JPG

_Delay
> Fig. (ii)_

http://cscs-repast-demos.googlecode.com/svn/wiki/Images_Mudit/Delay3.JPG

_Delay
> Fig. (iii)_

http://cscs-repast-demos.googlecode.com/svn/wiki/Images_Mudit/Delay4.JPG

_Delay
> Fig. (iv)_

So, from the above runs it is quite clear that if the time delay is
increased the path becomes smoother and shorter in a small population.
It can be put the other way round, on increasing the delay the path
becomes smoother and shorter.

**Note :** "Population" and "Deviation" were kept constant for the test
runs.

The user can try and do test runs to check the relationship of
"Deviation" with other parameters.

## How to change Run Options? ##

http://cscs-repast-demos.googlecode.com/svn/wiki/Tutorial/Fig.%0260

## How to add Parameters of Simulation? ##

http://cscs-repast-demos.googlecode.com/svn/wiki/Tutorial/Fig.%0261

## How to extend the model? ##

# Where to look for after this? #

## What other such documents are available? ##

You can check out the Relogo Getting Started guide
[here](http://repast.sourceforge.net/docs/ReLogoGettingStarted.pdf). It
is an excellent piece of text for starting with relogo. You can also
check other Relogo models and their Model Description and documentation
[here](http://code.google.com/p/cscs-repast-demos/wiki/RepastSReLogo).

## Where to learn more about RepastS? ##


# References #

[1](1.md) "Tutorial on agent-based modelling and simulation", CM Macal and MJ
North, Journal of Simulation (2010) 4, 151?162, 2010 Operations Research

> Society