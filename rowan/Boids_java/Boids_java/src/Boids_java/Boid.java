package Boids_java;

import java.util.ArrayList;
import java.util.Iterator;

import repast.simphony.engine.schedule.ScheduledMethod;
import repast.simphony.query.space.grid.MooreQuery;
import repast.simphony.random.RandomHelper;
import repast.simphony.space.SpatialMath;
import repast.simphony.space.continuous.ContinuousSpace;
import repast.simphony.space.continuous.NdPoint;
import repast.simphony.space.grid.Grid;
import repast.simphony.util.SimUtilities;
import java.lang.Iterable;

public class Boid {
	ContinuousSpace<Object> space;
	Grid<Object> grid;
	double heading;
	final double turnSpeed = 0.4;			
	final double DESIRED_DISTANCE = 0.5;
	final double separationWeight = RandomHelper.nextDoubleFromTo(0.4, 0.6);
	final double cohesionWeight = 1.0 - separationWeight;
	final double distance = 0.2;
	
	public Boid(ContinuousSpace<Object> space, Grid<Object> grid){
		this.space = space;
		this.grid = grid;
		heading = randomRadian();
	}
	
	/**
	 * The method that every Boid runs every tick.
	 */
	@ScheduledMethod(start = 1, interval = 1)
	public void step(){
		forward();
		double heading1 = averageTwoDirections(cohesionDirection(),separationDirection());
		heading1 = averageTwoDirections(heading1,heading);
		double deviation = averageTwoDirections(heading,randomRadian());
		double heading2 = averageTwoDirections(alignmentDirection(),deviation);
		heading2 = averageTwoDirections(heading2,heading);
		heading = averageTwoDirections(heading1,heading2);
		
	}
	
	/**
	 * This method returns a direction in which this Boid should travel in order to follow the Cohesion steering method
	 * @return heading--the new direction in radians
	 */
	public double cohesionDirection(){
		ArrayList<Boid> boidSet = neighborhood();
		if(boidSet.size() > 0){
			double avgBoidDirection = boidSet.get(0).getHeading();
			double avgBoidDistance = DESIRED_DISTANCE;
			for(Boid boid : boidSet){
				avgBoidDirection = averageTwoDirections(boid.getHeading(),avgBoidDirection);
				avgBoidDistance = (avgBoidDistance + distance(boid)) / 2;
			}
			if(avgBoidDistance > DESIRED_DISTANCE){
				moveTowards(avgBoidDirection,0.2*cohesionWeight);
			}
			return avgBoidDirection;
		}else{
			return heading;
		}
	}
	
	/**
	 * This method returns a direction in which this Boid should travel in order to follow the Separation steering method
	 * @return heading--the direction in radians
	 */
	public double separationDirection(){
		ArrayList<Boid> boidSet = neighborhood();
		ArrayList<Boid> boidsTooClose = new ArrayList<Boid>();
		for(Boid boid : boidSet){
			if(distance(boid) < DESIRED_DISTANCE*0.5){
				boidsTooClose.add(boid);
			}
		}
		if(boidsTooClose.size() > 0){
			double avgBoidDirection = heading;
			for(Boid boid : boidsTooClose){
				avgBoidDirection = averageTwoDirections(boid.getHeading(),avgBoidDirection);
			}
			double distanceToClosestBoid = Double.MAX_VALUE;
			for(Boid boid : boidsTooClose){
				if(distance(boid) < distanceToClosestBoid){
					distanceToClosestBoid = distance(boid);
				}
			}
			if(distanceToClosestBoid < DESIRED_DISTANCE*0.5){
				moveTowards(oppositeDirection(avgBoidDirection), 0.2*separationWeight);
			}
			if(toMyLeft(avgBoidDirection)){
				return (heading+turnSpeed)%Math.PI*2;
			}else{
				double newHeading = heading-turnSpeed;
				if(newHeading < 0)newHeading += Math.PI*2;
				return newHeading%Math.PI*2;
			}
		}
		return heading;
	}
	
	/**
	 * This method returns a direction in which this Boid should travel in order to follow the Separation steering method
	 * @return averageHeading--the direction in radians
	 */
	public double alignmentDirection(){
		ArrayList<Boid> boidSet = neighborhood();
		
		double averageHeading = heading;
		for(Boid boid : boidSet){
			averageHeading = averageTwoDirections(averageHeading,boid.getHeading());
		}
		return averageHeading;
	}

	/**
	 * 
	 * @param boid--A Boid object
	 * @return a double value denoting the distance in spatial units between the passed Boid object and the calling Boid object
	 */
	public double towards(Boid boid){
		NdPoint myPoint = space.getLocation(this);
		NdPoint otherPoint = space.getLocation(boid);
		
		return SpatialMath.calcAngleFor2DMovement(space, myPoint, otherPoint);
	}
	
	/**
	 * Returns the distance in spatial units between the calling Boid and the Boid passed as an argument.
	 * @param boid--a Boid object
	 * @return double value denoting distance
	 */
	public double distance(Boid boid) {
		NdPoint myPoint = space.getLocation(this);
		NdPoint otherPoint = space.getLocation(boid);
		double differenceX = Math.abs(myPoint.getX() - otherPoint.getX());
		double differenceY = Math.abs(myPoint.getY() - otherPoint.getY());
		return Math.hypot(differenceX, differenceY);
	}

	public double getHeading(){
		return heading;
	}
	
	public void setHeading(double heading){
		this.heading = heading;
	}
	
	/**
	 * Returns the direction halfway between one direction and another.
	 * @param dir1--first angle in radians
	 * @param dir2--second angle in radians
	 * @return a double value between 0 and 2*PI representing a direction
	 */
	public double averageTwoDirections(double angle1, double angle2){
		assert(angle1 <= Math.PI*2);
		assert(angle2 <= Math.PI*2);
		if(Math.abs(angle1-angle2) < Math.PI){
			return (angle1+angle2)/2;
		}
		else return oppositeDirection( (oppositeDirection(angle1) + oppositeDirection(angle2)) / 2 );
	}
	
	/**
	 * Returns the direction opposite to the one passed it, in radians.
	 * @param angle--a direction in radians
	 * @return the opposite direction as angle in radians
	 */
	public double oppositeDirection(double angle){
		assert(angle <= Math.PI*2);	
		angle = Math.toDegrees(angle);
		return Math.toRadians((angle + 180) % 360);
	}
	
	/**
	 * Moves the calling Boid some amount in a direction.
	 * @param direction--the direction to move the Boid
	 * @param dist--the amount to move the Boid
	 */
	public void moveTowards(double direction, double dist){
		assert(direction <= Math.PI*2);
		NdPoint pt = space.getLocation(this);
		double moveX = pt.getX() + Math.cos(heading)*dist;
		double moveY = pt.getY() + Math.sin(heading)*dist;
		space.moveTo(this, moveX, moveY);
	}
	
	/**
	 * Returns a double between 0 and 2*PI
	 * @return a radian between 0 and 2*PI
	 */
	public double randomRadian(){
		return Math.random()*(2*Math.PI);
	}
	
	/**
	 * Moves the calling Boid object an amount (defined by the Class-wide variable distance) 
	 * in the direction of the Boid's current heading.
	 */
	public void forward(){
		NdPoint pt = space.getLocation(this);
		double moveX = pt.getX() + Math.cos(heading)*distance;
		double moveY = pt.getY() + Math.sin(heading)*distance;
		space.moveTo(this, moveX, moveY);
		grid.moveTo(this, (int)moveX, (int)moveY);
	}
	
	/**
	 * Returns all Boid objects not farther than 1 units away from the calling Boid, not including the calling Boid.
	 * @return circularNeighborhood--an ArrayList of Boid objects
	 */
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
		SimUtilities.shuffle(boidSet,RandomHelper.getUniform());
		boidSet.remove(this);
		ArrayList<Boid> circularNeighborhood = new ArrayList<Boid>();
		for(Boid boid : boidSet){
			if(distance(boid) <= 1.0){
				circularNeighborhood.add(boid);
			}
		}
		return circularNeighborhood;
	}
	
	/**
	 * @return a count of all neighbors
	 */
	public int neighborCount(){
		ArrayList<Boid> boidSet = neighborhood();
		return boidSet.size();
	}
	
	/**
	 * @param angle--a direction in radians
	 * @return boolean value denoting whether the angle passed as argument is on the left-hand side of the calling Boid.
	 */
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
	
	/**
	 * @return distance--the average distance of all neighboring Boids.
	 */
	public double avgBoidDistance(){
		double distance = DESIRED_DISTANCE;
		for(Boid boid : neighborhood()){
			distance = (distance(boid)+distance)/2;
		}
		return distance;
	}
}