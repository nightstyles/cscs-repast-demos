# 0. Before Beginning #
Before we can do anything with Repast Simphony, we need to make sure that we have a proper installation of Repast Simphony 2.0. Instructions on downloading and installing Repast Simphony on various platforms can be found on the Repast website.

This tutorial will assume a familiarity with Java. The structure will be as follows: an introduction to the model; getting a framework for the model written in Java; adding the three main rules as functions; synthesizing the outputs of each rule in a useful way, and finally ideas for further extending the model.

# 1. What is Boids? #
Boids is an agent-based model which simulates the steering behavior of flocking birds using simple to understand rules. Applications of the model range from studying Artificial Life to implementing the algorithm in a flock of robots. The advantage of Boids is the bottom-up approach to flocking, rather than the top-down approach: each individual Boid need only follow a few simple rules and flocks will emerge naturally.
The overall design of the Boids algorithm is based on [Craig Reynold's original Boids](http://www.red3d.com/cwr/boids/) algorithm consists of three rules:
  * Alignment: Each Boid steers itself to align its heading with that of its neighbors
  * Cohesion: Each Boid steers itself to the average position of its flockmates
  * Separation: Each Boid steers itself in order not to crowd its neighbors

These three rules can conflict with each other, as we will see, the way that we deal with those conflicts will influence the final behavior of the flocks of Boids.

Boids is a study of the kind of algorithm that starlings might follow in order to create these spectacular clouds of birds:
<a href='http://www.youtube.com/watch?feature=player_embedded&v=eakKfY5aHmY' target='_blank'><img src='http://img.youtube.com/vi/eakKfY5aHmY/0.jpg' width='425' height=344 /></a>

# 2. Setting up the framework #

Open Repast and switch to the Java perspective by clicking the Java button in the upper. Next, we need to create a new Java project for Repast. To do this properly, click File, go to New, and click Other. Find Repast Simphony Project in the Wizard selection box and click it, then click Next. Nname your project Boids and click Finish.

We now have a new Repast Java project. The only files we're going to create for now are in the /src subfolder, so the rest of the project files can safely be ignored. Click on the arrow to the left of the /src subfolder. A subfolder with your project's name will drop down underneath /src. The two files inside of this subfolder can safely be deleted. In their place we can make a new Java file called Boid. To do this, right-click on the folder called Boids inside /src and click New, then click Class. Name it Boid and click Finish.

Your project's hierarchy should look like Fig. xxx. Next, add in code to your Boid class so it looks like this:

```
package Boids;

public class Boid {
   double distance;
   double heading;
   public Boid(){
      distance = 0.3;
      heading = randomRadian();
   }
	
   @ScheduledMethod(start = 1, interval = 1)
   public void step(){
		
   }
}
```

The method named Boid will be a constructor that we'll return to when we create the Context Builder for Boids. The step() method is a method that will be called at every tick, or time step, of the simulation.

You'll notice that the @ScheduledMethod command is underlined in red. This is because we haven't made the necessary import for the command. There are two ways of doing this; either hover over the command until a popup window appears and click on "Import ScheduledMethod." The second way is to click on Source in the top menu and click on Organize Imports. As we add more code, you should automatically check for an import any time a command is underlined in red.

## step() and forward() methods ##

Here is the code we'll use for now for step():

```
public void step(){
   forward();
}
```

Now create the forward method below step():

```
public void forward(){
   NdPoint pt = space.getLocation(this);
   double moveX = pt.getX() + Math.cos(heading)*distance;
   double moveY = pt.getY() + Math.sin(heading)*distance;
   space.moveTo(this, moveX, moveY);
   grid.moveTo(this, (int)moveX, (int)moveY);
}
```

In order to understand this block of code, you must first understand the underlying representations of space that Repast uses. In this particular model, we use both kinds: we use a grid, where each object has a location on a grid of discrete cells defined by two integers; and we use a continuous space, where each object has a location defined by two doubles. If we were making a three-dimensional model, we would have three integers and three doubles for the grid and the continuous space, respectively. Both the grid representation of space and the continuous space representation of space are called projections. We will see later why we use both projections.

Whenever an object moves itself and we are using these two projections, we need to update both in order for them to make sense. This means that we will need to convert between one projection's co-ordinates and another's. So the first line of code in the method creates an object of type NdPoint which contains a representation of the Boid's current co-ordinates in the continuous space. The second and third lines in the method take the Boid's current co-ordinates and change them so that the Boid has moved by a total of 0.3, the value in distance, in the direction of the variable heading.

## Context Builder ##

Create a new class in the Boids package and name it BoidsContextBuilder. Let's do the simple stuff first:

```
public Context build(Context<Object> context) {
   context.setId("Boids");
   int width = 16;
   int height = 16;
   int numBoids = 20;
		
   //placeholder

   return context;
}
```

Next, we need to create the two space projections, our grid and our continuous space. This will go where our placeholder comment is right now. Here is the code:

```
   ContinuousSpaceFactory spaceFactory = ContinuousSpaceFactoryFinder.createContinuousSpaceFactory(null);
   ContinuousSpace<Object> space = spaceFactory.createContinuousSpace
("space",context,new RandomCartesianAdder<Object>(), new 
repast.simphony.space.continuous.WrapAroundBorders(), width,height);
		
   Grid<Object> grid = GridFactoryFinder.createGridFactory(null).createGrid("Grid", 
context, new GridBuilderParameters<Object>(new repast.simphony.space.grid.WrapAroundBorders(), new
 SimpleGridAdder<Object>(),true, width,height));
```

This complicated-looking snippet of code creates two objects, called factories, which in turn create two more objects, our projections. The parameters that the create methods take amount to the following:
  * name: an arbitrary ID that we assign to this projection to refer to it elsewhere
  * context: this is the object that contains all the objects that we are dealing with in this simulation
  * method of adding objects to the space projections: defines whether the Boid object is added automatically to the projection and how it is added.
  * size of dimensional axes: defines how many dimensions the projections represent and how far those dimensions extend.
  * for the grid object, a boolean parameter is used to define whether each grid cell can contain multiple objects

Let's go over the commands we used for the method of adding objects to our two projections. For the continuous space, we have defined a Random Cartesian Adder, which means that whenever we add a Boid to the context with the command context.add(boid) as we do in the next step, the Boid automatically gets added to the continuous space at a random location. For the grid, the Boid will not be physically located on the grid until we manually put it somewhere.

The other point of confusion here is that there is another object being created in the parameters for the method createGrid(), GridBuilderParameters. We can think of this as merely a carrier or wrapper for the parameters inside of it. For a better understanding of the commands being invoked, refer to the Repast Java API, specifically the pages GridBuilderParameters, ContinuousSpace and Grid.

The last thing we need to add to the method is creation of the Boid objects and the addition of them to the context. We do that with this code snippet, which goes right underneath the last snippet of code:

```
for(int i = 0; i < numBoids; i++){
   Boid boid = new Boid(space, grid);
   context.add(boid);
   NdPoint pt = space.getLocation(boid);
   grid.moveTo(boid, (int)pt.getX(), (int)pt.getY());
}
```

Lastly, we modify the Boid constructor.

## Boid() ##

This is how the constructor in the Boid class should look:

```
public Boid(ContinuousSpace<Object> space, Grid<Object> grid){
   this.space = space;
   this.grid = grid;
   heading = randomRadian();
}
```

## Set up a display ##

Click on the arrow to the right of the green play button to see the popup menu of all the run options for your models. Find "Boids Model" and click it. In a minute, a Java window will appear.

Make sure the menu to the left is on the Scenario Tree tab. Find Display and right-click on it, and click Add Display. Name it something like 'Boids Display' and move 'space' from the left-hand box to the left-hand box. You can do this by clicking on 'space' and then clicking on the green arrow that is pointing to the right.

Make sure that the 'Type' drop-down menu is set to 2D. If the default is GIS, then there is something wrong with your BoidsContextBuilder.

Click next. This menu lets you tell the program which class(es) will be the agents in the simulation. Move Boid to the right-hand box and click next.

This menu lets you define how the Boids look. If you click the far-right button (the one to the right of the Style Class text box) you can customize the look of your agent. Go ahead and click on it. The default is a blue circle, and that's good for now. Click okay, and then click next twice, and finally click finish.

Your model should now run! Click on the blue power button, and then click on either the blue next button or the blue play button to step the simulation forward by one step or many steps, respectively.

# 3. Alignment #

This method needs to average the heading of all Boids within a certain distance (referred to as its 'neighborhood'). This average is then returned by the alignmentDirection() method as a measurement of radians.

But first, we need a method to actually create the neighborhood.

## neighborhood() method ##
```
public ArrayList<Boid> neighborhood(){
   MooreQuery<Boid> query = new MooreQuery(grid,this);
   Iterator<Boid> iter = query.query().iterator();
   ArrayList<Boid> boidSet = new ArrayList<Boid>();
   while(iter.hasNext()){
      boidSet.add(iter.next());
   }
   Iterable<Object> list = grid.getObjectsAt(grid.getLocation(this).getX(),grid.getLocation(this).getY());
   for(Object boid : list){
      boidSet.add((Boid) boid);
   }
   boidSet.remove(this);
   SimUtilities.shuffle(boidSet,RandomHelper.getUniform());
   return boidSet;
}
```

Lines 2-3 declare an object that can iterate through all Boids in the Moore neighborhood of the calling Boid. In 5-7 we add these all to an ArrayList. However, since the Boids on the same cell as the calling Boid aren't included in the Moore neighborhood, we need to add those too, which is done in 8-11. Finally, we need to remove the calling Boid so it doesn't count itself.

## alignmentDirection() method ##

```
public double alignmentDirection(){
   ArrayList<Boid> boidSet = neighborhood();
   double averageHeading = heading;
   for(Boid boid : boidSet){
      averageHeading = averageTwoDirections(averageHeading,towards(boid));
   }
   return averageHeading;
}
```

You'll notice that we call on the method, averageTwoDirections(). Here is the code for that method.

## averageTwoDirections() ##

```
public double averageTwoDirections(double angle1, double angle2){
   assert(angle1 <= Math.PI*2);
   assert(angle2 <= Math.PI*2);
   angle1 = Math.toDegrees(angle1);
   angle2 = Math.toDegrees(angle2);
   if(Math.abs(angle1-angle2) < 180){
      return Math.toRadians((angle1+angle2)/2);
   }
   else return oppositeDirection( (oppositeDirection(angle1) + oppositeDirection(angle2)) / 2 );
}
```

The astute reader may have noticed that, as it currently stands, the alignmentDirection() method won't give a very accurate average; the average will be weighted towards the boids it averages last. However, in order to keep things as simple as possible, we'll omit this from our model for now and leave the solution up to the reader to figure out. Since we've added in the line to shuffle the neighborhood ArrayList, this won't bias the Boids to travel in a certain direction.

If you want to see your model run using just the alignmentDirection() steering method, add this line of code to the end of step():
```
heading = alignmentDirection();
```

# 4. Cohesion #

In order for a group of birds to be labeled a flock, or a group of fish to be labeled a school, they need to have a certain proximity to each other. The direction that the Boid should turn in order to get closer to its neighboring Boids is returned by the method cohesionDirection().

## cohesionDirection() method ##
```
public double cohesionDirection(){
   ArrayList<Boid> boidSet = neighborhood();	
   if(boidSet.size() > 0){
      double avgBoidDirection = heading;
      double avgBoidDistance = DESIRED_DISTANCE;
      for(Boid boid : boidSet){
         avgBoidDirection = averageTwoDirections(boid.getHeading(),avgBoidDirection);
         avgBoidDistance = avgBoidDistance + distance(boid)/ 2;
      }
      if(avgBoidDistance > DESIRED_DISTANCE){		  
         moveTowards(avgBoidDirection,0.2);
         return avgBoidDirection;
      }else{
         return heading;
      }
   }else{
      return heading;
   }
}
```

In order to fly close to their flockmates, each Boid takes all its neighboring Boids using the neighborhood() method and determines the average direction they are travelling in lines 6-9. Also in lines 6-9 it determines the average distance of all the Boids currently in its neighborhood. If the neighboring Boids are too far away from this particular Boid, then it shifts its course to face the average direction of its neighboring Boids in 12-14.


We rely on the methods distance() and moveTowards(), shown below.

## moveTowards() ##

```
public void moveTowards(double direction, double dist){
   NdPoint pt = space.getLocation(this);
   double moveX = pt.getX() + Math.cos(heading)*dist;
   double moveY = pt.getY() + Math.sin(heading)*dist;
   space.moveTo(this, moveX, moveY);
}
```

## distance() ##

```
public double distance(Boid boid) {
   NdPoint myPoint = space.getLocation(this);
   NdPoint otherPoint = space.getLocation(boid);
   double differenceX = Math.abs(myPoint.getX() - otherPoint.getX());
   double differenceY = Math.abs(myPoint.getY() - otherPoint.getY());
   return Math.hypot(differenceX, differenceY);
}
```

As before, if you want to see your model run using just the cohesionDirection() steering method, add this line of code to the end of step():
```
heading = cohesionDirection();
```

If you want to see both methods in action together, try adding this instead:
```
heading = averageTwoDirections(cohesionDirection(),alignmentDirection());
```

# 5. Separation #

Real flocks have another key trait: the units comprising them are fairly evenly spaced, and no one unit is crowded out.

## separationDirection() method ##
```
public double separationDirection(){
   ArrayList<Boid> boidSet = neighborhood();
   ArrayList<Boid> boidsTooClose = new ArrayList<Boid>();
   for(Boid boid : boidSet){
      if(distance(boid) < DESIRED_DISTANCE){
         boidsTooClose.add(boid);
      }
   }
   if(boidsTooClose.size() > 0){
      double avgBoidDirection = heading;
      double distanceToClosestBoid = Double.MAX_VALUE;
      for(Boid boid : boidsTooClose){
         avgBoidDirection = averageTwoDirections(boid.getHeading(),avgBoidDirection);
         if(distance(boid) < distanceToClosestBoid){
            distanceToClosestBoid = distance(boid);
         }
      }
      if(distanceToClosestBoid < DESIRED_DISTANCE*0.5){
         moveAwayFrom(avgBoidDirection, 0.2);
      }
      if(toMyLeft(avgBoidDirection)){
         return (heading+turnSpeed)%Math.PI*2;
      }else{
         return (heading-turnSpeed)%Math.PI*2;
      }
   }
   return heading;
}
```

In this method, all neighboring Boids which are not too close can be ignored. In this method, we define 'too close' as being closer than the desired distance. In order for the Boids to not get tangled up, we allow a little lateral movement--if there is a Boid that is far too close (defined as being within half the desired distance) then we move directly away from it using moveAwayFrom().

No matter what, if there are any too-close Boids, the current Boid needs to turn away from them by some amount, which we'll call turnSpeed.

Below is the method moveAwayFrom() and toMyLeft().

## moveAwayFrom() ##

```
public void moveAwayFrom(double direction, double dist){
   NdPoint pt = space.getLocation(this);
   double moveX = pt.getX() - Math.cos(heading)*dist;
   double moveY = pt.getY() - Math.sin(heading)*dist;
   space.moveTo(this, moveX, moveY);
}
```

## toMyLeft() method ##

```
public boolean toMyLeft(double angle){
   double angleDegrees = Math.toDegrees(angle);
   double headingDegrees = Math.toDegrees(heading);
   if(Math.abs(angleDegrees - headingDegrees) < 180){
      if(angleDegrees < headingDegrees){
         return true;
      }else return false;
   }else{
      if(angleDegrees < headingDegrees){
         return false;
      }else return true;
   }
}
```

# 6. Putting it all together #

Now let's combine the three steering methods we established above into the single method, step().

## step() ##

```
public void step(){
   assert(heading <= Math.PI*2);
   forward();
   heading = averageTwoDirections(averageTwoDirections(averageTwoDirections(cohesionDirection(),heading),averageTwoDirections(separationDirection(),heading)),alignmentDirection());
}
```

The rather bulky line 4 is in effect averaging together five different directions. This implementation lets the result of alignmentDirection() have much greater bearing on the outcome than the other methods because it causes the Boids to move more smoothly. Try other implementations and see if they are more to your liking.

## Adding random weights ##

To make this model look more lifelike, we can add random weighting to the three steering methods. First, declare two doubles named cohesionWeight and separationWeight inside the Boid class.

```
private final double separationWeight = RandomHelper.nextDoubleFromTo(0.0, 1.0);
private final double cohesionWeight = 1.0 - separationWeight;
```

Now find the following line in cohesionDirection():

```
moveTowards(avgBoidDirection,0.2);
```

Change that to this:

```
moveTowards(avgBoidDirection,0.2*cohesionWeight);
```

Do the same for separationDirection. Now the Boids won't all behave exactly alike.

# 7. Extending the model #

You're now done with the basics of this model. If you want to continue to work on it, here are some suggestions:
  * the separation and cohesion steering methods are weighted, but the alignment is not. Find a way to vary how influential that steering method is on a Boid.
  * Create a new class, BoidOfPrey. Objects of this class will prey on Boids, and Boids will do their best to avoid them. You'll have to figure out how to weight the new steering method to avoid the predator well when the Boid can see it, but also ignore the predator when it's far enough away.

### Sources ###

Craig Reynold's webpage on Boids: http://www.red3d.com/cwr/boids/