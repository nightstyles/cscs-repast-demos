# still editing #
# Summary #
  * Source Code  :
    * Download at X
    * Most up to date is here: https://cscs-repast-demos.googlecode.com/svn/mark/Automata/
  * Platform     : [Repast Simphony Java](RepastSJava.md)
  * Mentor       : Rick Riolo
  * Author       : [Mark Champe](Mark.md)



# Contents #



---


# Introduction #
This tutorial will provide a thorough walkthrough of building cellular automata models using the Repast Simphony agent-based-modeling platform. The guide is intended for a beginner audience that may be new to either a) cellular automata or b) implementing models with Repast. A basic understanding of programming in Java is assumed. We will start with a "barebones" model, adding features and complexity as we progress. Once finished, you will not only know more about cellular automata, but will also be comfortable tackling similar models on your own in Repast Simphony.

While it is possible (and sometimes useful) to directly copy-paste code from this document into Repast/Eclipse, it is much more beneficial to type the code as you see it. There are several reasons for this, the first is understanding what everything does. The other reason is (for those who may not know) the Eclipse editor will give you pop-up messages for auto-completion when it recognizes certain things (such as import statements or function calls). Auto complete (`Cntrl + Space`) will save lots of time.

As always with programming, save work often so that if something closes you may continue unhindered.

## Why use Cellular Automata? ##
Cellular Automata (CA) are a classic way to study complexity. The discrete nature of grid based agent-based-models (ABM's) allows a relatively short program to demonstrate extremely complex behavior at execution. CA are a cornerstone of the study of complex systems. Understanding how their implementation in Repast will provide a framework for other models to take shape.

## Prerequisites ##

A working installation of Repast Simphony is necessary for all further steps. This is not an installation guide, but if you are a first time user, all the information you will need can be found on the [Repast download website](http://repast.sourceforge.net/download.html) (Be sure to read through the [documentation](http://repast.sourceforge.net/docs.html) as well).

Repast offers several methods to create ABM's including a Logo implementation ([ReLogo](http://repast.sourceforge.net/docs/ReLogoGettingStarted.pdf)), Java/Groovy, and even [Flowcharts](http://repast.sourceforge.net/docs/RepastFlowGettingStarted.pdf). Since we will be using Java, the [Java API](http://repast.sourceforge.net/docs/api/repastjava/index.html) might be a handy reference for detailed informatioion.


# Conventions used #


# Model List #

  1. [Basic CA](#Basic_CA.md)
  1. [1-D CA](#1-D_CA.md)
  1. [2-D CA Parity](#2-D_CA_Parity.md)
  1. [Game of Life](#Game_of_Life.md)


## Basic CA ##

Summary:
At the most elementary level, a CA consists of cells arranged on a grid. Each cell exists in one state, which we can call "on" or "off" (also commonly called "alive" or "dead"). The grid can be in any finite number of dimensions, most often one or two. A grid can be either infinite or finite (simulating on a computer naturally implies the grid is finite). The common solution for solving this finite grid problem is to fold the grid in on itself into a torus, by wrapping the edges around to touch one another. More on this later.

Each cell lives in a "neighborhood", which is the set of cells in a defined region relative to itself. Two types are the [Moore](http://mathworld.wolfram.com/MooreNeighborhood.html) and [von Neumann](http://mathworld.wolfram.com/vonNeumannNeighborhood.html) neighborhoods (N.B. neighborhood selection produces drastically different outcomes).

At each time step, all the cells in the space follow a set of defined rules which determine how the state is modified for the next tick. This process is what makes CA configurations "animated".


### Template ###

Writing the layout for a general CA is quite straightforward, but often when coding it can be difficult to follow where each section of code goes in the program. To help clarify this, comments are used to break the program down into several functional blocks of code, which also helps one understand the purpose for each. This will be revisited shortly.


### Starting a new project ###

  * Go ahead and initialize Repast Simphony. If this is the first time running the program, you will need to choose an Eclispe workspace from in a pop-up notification. This is where Eclipse will keep all of the important source files and data.
  * In the top right corner of the window, set the perspective by pressing the "Java" button
  * Click on _File --> New --> Other..._ in the menu bar. This will start a new project wizard
  * Select _Repast Simphony Project_ under the Repast folder
  * Click next, and enter the project name as "Automata" then hit finish. Repast will load the necessary files and you will see a new project in the Package explorer window.
  * Since we are not using Groovy, go ahead and delete the files "ModelInitializer.groovy" and "ModelInitializer.agent" in the dir Automata/src/Automata/. These files are unneccessary for the project.

### Creating a class ###
Repast offers a neat way to create classes for your model. All you have to do is right-click on your project in the package-explorer pane then do: _New --> Class_

**You will see a window titled "New Java Class". In the _Name_ field enter "CA" and then _Finish_**

Now you see a file called CA.java in the "src" directory, and the file is automatically opened for editing.
It will look like this:

```
package Automata;

public class CA {

}
```

# Please copy the following comments and past them into the body of the CA class:

```
	/**************
	 * Scheduling *
	 **************
	 */
	
		/*********
		 * Query *
		 *********
		 */
	
		/********
		 * Rule *
		 ********
		 */
	
	
	/************
	 * Function *
	 ************
	 */
```

As you can see, these blocks are:
  * Scheduling
  * Query
  * Rule
  * Function

You will see how each section of code comes into play as we go along.

Ok, since we know that since each cell must keep track of what it's state was, and what its state will be, we should give the CA class two variables to store this information.
Add the following above the scheduling block comment:
```
	public int state;
	public int oldState;
```
These are pretty self explanatory. The int _oldState_ saves the previous state as a 1 or 0, and _state_ is used to set the state of cell when the grid is updated at the next tick.

Therefore, it would be nice if we had some simple functions to get and set these variables. Within the Function block, we will put the getters and setters.
Getters are easy enough
```
	public int getState() {
		return state;
	}	
	public int getOldState() {
		return oldState;
	}
```

And for the setters we just use Java's _this_ method to access the data members of the class from which it is being called
```
	public void setOldState(int oldState) {
		this.oldState = oldState;
	}

	public void setState(int state) {
		this.state = state;
		
	}
```

So we have a way to change the state of a given cell - nice. But we also want each cell to _remember_ its previous state. This is essential because once we start applying rules and changing cell states, we don't want to influence what the original state of the grid looked like to the other cells. This is what allows us to apply a ruleset to each cell, without each cell "recognizing" the new states until it is all over.

### Giving the cells memory ###
In the scheduling block, we will use Repasts available scheduling methods. These methods execute code at specific intervals as the model is running. If we want the cell to remember it's state, the following line does the trick

```
	// Maintain the history of the state for one time interval
	@ScheduledMethod(start=1, interval=1, priority=ScheduleParameters.FIRST_PRIORITY)
	public void setOldState(){
		oldState = state;
	}
```
But wait, there is a squiggle line under one of the lines! It looks like an error, oh no! No worries, this is just Eclipse reminding you that the code is missing an import statement for something called "ScheduledMethod". If you hover over the line, a window will pop up giving you optional import statements. You should click on the one that is from repast.simphony, or alternatively, you could manually write the import line at the top of the CA file, but this takes more time. Auto-completion using `Ctrl + Space` is a time saver here.

```
import repast.simphony.engine.schedule.ScheduledMethod;
```
Each time we reference a predefined Repast function, we need to have the correct import statement at the top of the code. How it gets there is up to you.

The @ScheduledMethod annotation provides an easy way to execute code on each time step. The parameters it accepts defines when the scheduled code starts, the interval, and its priority. Here, we gave cells memory of their "last" configuration. Not unsurprisingly, "memory" is one of the requirements that seperates _agents_ from _objects_ in programming.

But we are not done yet! We still need to make another schedule for all the other code we want to run each time the program "ticks". This is what is called a `step()` function, and this part generally contains almost all of the interesting code that makes a model unique.
Our `step()` action will start out like this:

```
	@ScheduledMethod(start=1, interval=1)
	public void step(){
		Context<CA> context = ContextUtils.getContext(this);
		Grid<CA> grid = (Grid)context.getProjection("Grid");

	}

```
The closing curly brace should enclose both the query and rule blocks. The code declares a new _Context_ and _Grid_ for the CA. All classes in Repast belong to a context, which associates them with similar objects.


Now that we have the basics set up for the CA, we are going to create a new class. Specificically, it will be our "context builder", serving the purpose of a) building the grid and b) setting the initial configuration. Follow the same procedure as before for creating a new class, this time named _CAContextBuilder_.
You should have a file `CAContextBuilder.java` under /src/Automata with the contents

```
package Automata;

public class CAContextBuilder implements ContextBuilder<CA> {

		return context;
	}
}

```


Now, to actually build the context, add the following
```
	public Context<CA> build(Context<CA> context) {

		return context;
	}
```



Paste the comments above `return context`, for the sake of future reference.
```
	public Context<CA> build(Context<CA> context) {

		/*********
		 * Build *
		 *********
		 */


		/********
		 * Fill *
		 ********
		 */


		return context;
	}

```

The context builder is where we are going to get the parameters for the model. We can put a few lines of code right above the "build block" to do exactly this
```
		Parameters parm = RunEnvironment.getInstance().getParameters();
		int gridWidth = (Integer)parm.getValue("gridWidth");
		int gridHeight = (Integer)parm.getValue("gridHeight");
		int seedWidth = (Integer)parm.getValue("centerSeedWidth");
```
Each parameter will be grabbed from the corresponding field during execution. And hopefully you haven't forgotten important steps yet... (If you have little red flags popping up in Eclipse, that means you haven't been adding the import statements!).

Now we are going to complete the Build block of code. Enter each segment of code in this section. First up is creating a grid for the CAs to be placed on
```
		// Create the grid for the CAs
		Grid<CA> grid = GridFactoryFinder.createGridFactory(null).createGrid("Grid", context, 
				new GridBuilderParameters<CA>(new WrapAroundBorders(), 
						new RandomGridAdder<CA>(), false, gridWidth, gridHeight));
```
Most of these parameters are coherent and self-explanatory. If something is confusing, hover your mouse over it for relevant Repast documentation.

Next up is to create what is called a "value layer". One way to understand this is imagining a transparent sheet, laid on top of the grid space, on which values can be written on.
```
		// Create a value layer to store the state for each CA
		GridValueLayer valueLayer = new GridValueLayer("State",true,
				new WrapAroundBorders(), gridWidth, gridHeight);

		// Add the value layers to the context 
		context.addValueLayer(valueLayer);
```
If it isn't already obvious, value layers are a very useful way for storing information in an organized way.


It is time to place our CAs on the grid we just created. This can be done by adding the following code
```
		// Create and place a new CA in each grid location.
		for (int j=0; j<gridHeight; j++){
			for (int i=0; i<gridWidth; i++){
				CA ca = new CA();
				context.add(ca);
				grid.moveTo(ca, i, j);
			}
		}
```
This is the final step in "building" the space on which the cells operate.

Since we don't want to have a grid of all dead cells (that's boring!), we will initialize values for a region of the grid. This is done in what can be called the "fill" block, since we are "filling" the CAs with their initial values.

In the Fill block, we are going to loop over each grid location as when placing the CAs, except now we are using the extra parameters we grabbed earlier. The "seedWidth" and "seedHeight" will determine the region where live CAs are randomly placed.
```
		// "Seed" the the center CA.
		RandomHelper.init();
		for (int j=gridHeight/2-seedWidth/2; j<gridHeight/2+seedWidth/2; j++){
			for (int i=gridWidth/2-seedWidth/2; i<gridWidth/2+seedWidth/2; i++){
				ScheduleParameters scheduleParams = ScheduleParameters.createOneTime(0);
				CA ca = grid.getObjectAt(i,j);
				int rand = RandomHelper.nextIntFromTo(0, 1);
				RunEnvironment.getInstance().getCurrentSchedule().schedule(scheduleParams, 
						ca, "setState", rand);
			}
		}
```
As you can see, we employ a pseduo-random number generator to assign values of either 0 or 1 to each cell in the seeding region.

If you have not done so already, save the whole project. We are switching back to the CA class for one last piece of code.

Remember those getters and setters we wrote in the previous section? We need to modify `setState` in order for the graphical projection to update at each tick. This is done by storing the state in the value layer for animation.
```
	public void setState(int state) {
		this.state = state;

		// also store the state in the value layer for animation
		Context<CA> context = ContextUtils.getContext(this);
		Grid<CA> grid = (Grid)context.getProjection("Grid");
		GridValueLayer vl = (GridValueLayer)context.getValueLayer("State");
		vl.set(state, grid.getLocation(this).getX(), grid.getLocation(this).getY());
	}
```
This is what the setState function looks like with the new additions. Notice, we first get the context and grid, then the value layer. Therefore, each cell updates its state to the value layer for its given position.

Checkpoints:
Save the model
Build the model
You should see a grid with a region seeded with random cells
FIG

The classes now have the following

CA.java
```
package Automata;

// Import declarations here 
import java.util.Iterator;
import repast.simphony.context.Context;
import repast.simphony.engine.schedule.ScheduleParameters;
import repast.simphony.engine.schedule.ScheduledMethod;
import repast.simphony.query.space.grid.VNQuery;
import repast.simphony.space.grid.Grid;
import repast.simphony.util.ContextUtils;
import repast.simphony.valueLayer.GridValueLayer;

// Defining the class for cellular automata (CA)
public class CA {
	
	public int state;
	public int oldState;

	/**************
	 * Scheduling *
	 **************
	 */

	// Maintain the history of the state for one time interval
	@ScheduledMethod(start=1, interval=1, priority=ScheduleParameters.FIRST_PRIORITY)
	public void setOldState(){
		oldState = state;
	}
	
	@ScheduledMethod(start=1, interval=1)
	public void step(){
		Context<CA> context = ContextUtils.getContext(this);
		Grid<CA> grid = (Grid)context.getProjection("Grid");

		/*********
		 * Query *
		 *********
		 */
	
	
		/********
		 * Rule *
		 ********
		 */

	}

	/************
	 * Function *
	 ************
	 */
	
	public int getState() {
		return state;
	}	
	public int getOldState() {
		return oldState;
	}
	public void setOldState(int oldState) {
		this.oldState = oldState;
	}

	public void setState(int state) {
		this.state = state;
		
		// also store the state in the value layer for animation
		Context<CA> context = ContextUtils.getContext(this);
		Grid<CA> grid = (Grid)context.getProjection("Grid");
    GridValueLayer vl = (GridValueLayer)context.getValueLayer("State");
    vl.set(state, grid.getLocation(this).getX(), grid.getLocation(this).getY());
	}

}
```

CAContextBuilder.java
```
package Automata;

import repast.simphony.context.Context;
import repast.simphony.context.space.grid.GridFactoryFinder;
import repast.simphony.dataLoader.ContextBuilder;
import repast.simphony.space.grid.Grid;
import repast.simphony.space.grid.GridBuilderParameters;
import repast.simphony.space.grid.RandomGridAdder;
import repast.simphony.space.grid.WrapAroundBorders;
import repast.simphony.valueLayer.GridValueLayer;
import repast.simphony.engine.environment.RunEnvironment;
import repast.simphony.engine.schedule.ScheduleParameters;
import repast.simphony.parameter.Parameters;
import repast.simphony.random.RandomHelper;


public class CAContextBuilder implements ContextBuilder<CA> {

	public Context<CA> build(Context<CA> context) {

		Parameters parm = RunEnvironment.getInstance().getParameters();
		int gridWidth = (Integer)parm.getValue("gridWidth");
		int gridHeight = (Integer)parm.getValue("gridHeight");
		int seedWidth = (Integer)parm.getValue("centerSeedWidth");

		/*********
		 * Build *
		 *********
		 */

		// Create the grid for the CAs
		Grid<CA> grid = GridFactoryFinder.createGridFactory(null).createGrid("Grid", context, 
				new GridBuilderParameters<CA>(new WrapAroundBorders(), 
						new RandomGridAdder<CA>(), false, gridWidth, gridHeight));

		// Create a value layer to store the state for each CA
		GridValueLayer valueLayer = new GridValueLayer("State",true,
				new WrapAroundBorders(), gridWidth, gridHeight);

		// Add the value layers to the context 
		context.addValueLayer(valueLayer);

		// Create and place a new CA in each grid location.
		for (int j=0; j<gridHeight; j++){
			for (int i=0; i<gridWidth; i++){
				CA ca = new CA();
				context.add(ca);
				grid.moveTo(ca, i, j);
			}
		}


		/********
		 * Fill *
		 ********
		 */

		// "Seed" the the center CA.
		RandomHelper.init();
		for (int j=gridHeight/2-seedWidth/2; j<gridHeight/2+seedWidth/2; j++){
			for (int i=gridWidth/2-seedWidth/2; i<gridWidth/2+seedWidth/2; i++){
				ScheduleParameters scheduleParams = ScheduleParameters.createOneTime(0);
				CA ca = grid.getObjectAt(i,j);
				int rand = RandomHelper.nextIntFromTo(0, 1);
				RunEnvironment.getInstance().getCurrentSchedule().schedule(scheduleParams, 
						ca, "setState", rand);
			}
		}

		
		return context;
	}
}
```

End of section.



## 1-D CA ##
Now that we have written the basic template for a given CA, we will begin applying rules, shaping the possible outcomes.

Even though we have a grid space for our CA, we will start out implementing the most basic of all CA: 1-dimensional CA. 1-D CA exist in a row of a given length, and follow rules based on their neighborhood of the cell to the left and right of them (2<sup>3 = 8 possible). The rule determines if the next generation will be alive or dead, therefore there are 2</sup>8 = 256 possible rules in 1-D CA. Rules follow a naming convention based on this nomenclature, it is called the [Wolfram Code](http://en.wikipedia.org/wiki/Wolfram_code) of the CA rule. The next generation of cells is displayed beneath the previous, therefore parents sit "on top" of their offspring.




## 2-D CA Parity ##
Moving up from 1-dimensional CA, 2-D CA exist on a grid instead of just being "printed" row by row. This implies cell neighborhoods are different, and are queried in a new way as well. For the parity rule, we will be modifing code in the query and rule block.

Lets start by changing how the cell looks up its neighborhood. We want to query the von Neumann neighborhood, then get the states of the four nearest neighbors.

```
		/*********
		 * Query *
		 *********
		 */

		// Query the von Neumann neighborhood
		VNQuery<CA> query = new VNQuery(grid,this);
		Iterator<CA> iter = query.query().iterator();
				
		// Get the states of the four neighbors;
		int a =	iter.next().getOldState();
		int b =	iter.next().getOldState();
		int c =	iter.next().getOldState();
		int d =	iter.next().getOldState();
```
The `VNQuery` function returns a list of cells. So we declare an iterator variable `iter` to store the list. Four variables (a->d) are declared to save elements from the list. Their values will be used in the rule block.

The Parity rule says that a cell will be set to the result of a<sup>b</sup>c^d where a through d are the four nearest neighbor state values. This is easy to put into code, it is just
```
		// set the state according to the parity rule.
		setState(a^b^c^d);
```

Save work to push changes through. Try running the model. Is this the result you expected? Does it suprise you that this simple rule generates this animation?

Let your curiosity get the best of you here. Try changing the parity rule to something else of your own creation. Remember, the mathematical formula you substitute should only be able to produce 0 or 1. This could be accomplished using `ceil()` or `floor()` functions.


## Game of Life ##
We have arrived at John Conway's Game of Life. This is one of the quintessential examples of CA, and is found in many different implementations all over the place. It brought much attention to the field due to the interesting behavior of the model.



Again, we are going to change the code inside the query block for this version of the model. Instead of using the von Neumann neighborhood, we will employ the Moore neighborhood. We also want to get the states of the eight Moore neighbors.

Therefore, we should replace the section of code in the Query block with the following
```
		// Query the Moore neighborhood
		MooreQuery<CA> query = new MooreQuery(grid,this);
		Iterator<CA> iter = query.query().iterator();	

		// Get the states of the eight Moore neighbors;
		int a =	iter.next().getOldState();
		int b =	iter.next().getOldState();
		int c =	iter.next().getOldState();
		int d =	iter.next().getOldState();
		int e =	iter.next().getOldState();
		int f =	iter.next().getOldState();
		int g =	iter.next().getOldState();
		int h =	iter.next().getOldState();
```
We use the same steps as before. We use variables named a->h in order to store values from the iter object.


The rule block is the most interesting part of the Game of Life. This is where Conway had to meticulously balance values so that cells would not die off to quickly, nor reach rapid growth. The rules according to Conway are:
  * A living cell with exactly 2 or 3 live neighbors stays alive. Otherwise, it dies.
  * A dead cell with exactly 3 living neighbors becomes alive (via "reproduction")

In code, one could summarize these rules with the following

```
		// Count the neighbors and calculate life or death based on Conway's rules
		int count = a+b+c+d+e+f+g+h;
		if (this.state == 1){
			if ((count != 2) && (count != 3)){
				setState(0);	// Cell is killed - "overcrowding"
			}
		}
		else {  // square is dead
			if (count == 3){
				setState(1);	// Cell is revived - "reproduction"
			}
		}
```
And that is precisely what we will use in the rule block section of our model for the game of life.k


At this point you should be able to successfully run the model and see the evolution of the randomly seeded region of cells.

How quickly do they die off? Does increasing the region necessarily imply that the model will take longer to achieve a stable state? How would you know that?

This model could be expanded upon by implementing a method where a user can select which cells should be initialized as "living" before the model is started.
Being able to load/save configurations from a file is another feature that would provide more thorough testing of the automata in _Life_.


# Conclusion #
Building the template for a CA ABM is not very challenging once you have done it once. Even easier is modifing the code in what we termed the "Query block" and "Rule block" to get vastly different end behavior from the model. This is characteristic of all complex systems. Changing the underlying, simple rules makes the simulation unpredicatable, and hopefully interesting.


This has been a general introduction to both CA and using the basic features of Repast Simphony. From this point you should be able to reproduce a wide range of grid based ABM's, whether they are categorized as "cellular automata" or not. Remember to consult the Repast documentation and user guides for more information.

# Resources #


# References #