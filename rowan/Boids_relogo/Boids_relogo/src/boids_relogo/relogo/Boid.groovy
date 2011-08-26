package boids_relogo.relogo


import static repast.simphony.relogo.Utility.*;
import static repast.simphony.relogo.UtilityG.*;
import repast.simphony.relogo.BasePatch;
import repast.simphony.relogo.BaseTurtle;
import repast.simphony.relogo.Plural;
import repast.simphony.relogo.Stop;
import repast.simphony.relogo.Utility;
import repast.simphony.relogo.UtilityG;
import repast.simphony.relogo.*;

class Boid extends BaseTurtle {
	def neighborhoodRadius = 4
	def desiredDistance = 2
	def cohesionWeight = Utility.randomFloat(0.2) + 0.4 
	def separationWeight = 1.0 - cohesionWeight
	def turnSpeed = Utility.random(5) + 5
	
	/**
	* The method that every Boid runs every tick.
	*/
	def step(){
		forward(0.3)
		def heading = getHeading()
		setHeading(averageTwoDirections( 
			averageTwoDirections( averageTwoDirections(cohesionDirection(), getHeading()), averageTwoDirections(getHeading(),separationDirection()) ), 
			alignmentDirection()) 
			)
	}
	
	/**
	 * This method returns a direction in which this Boid should travel in order to follow the Separation steering method
	 * @return heading--the direction in degrees
	 */
	def separationDirection(){
		def boidsTooClose = inRadius(turtles(), desiredDistance)
		boidsTooClose = other(boidsTooClose)
		
		if(boidsTooClose.size() > 0){
			def boidsTooCloseSize = boidsTooClose.size()
			def closestBoid = minOneOf( boidsTooClose, {distance(it)} )
			def avgDirectionOfTooCloseBoids = towards(closestBoid)
			boidsTooClose.remove(closestBoid)
			if(boidsTooClose.size() > 0){
				for(Boid boid: boidsTooClose){
				avgDirectionOfTooCloseBoids = averageTwoDirections( avgDirectionOfTooCloseBoids, towards(boid) )
				}
			}
//			if(distance(closestBoid) < desiredDistance*0.5){
				moveAwayFrom(avgDirectionOfTooCloseBoids,(0.2*separationWeight))
//			}
			if(toMyLeft(avgDirectionOfTooCloseBoids)){
				return (getHeading() + turnSpeed*separationWeight)
			}else{
				return (getHeading() - turnSpeed*separationWeight)
			}
		}else{
		   return getHeading()
		}
	}
	
	/**
	* This method returns a direction in which this Boid should travel in order to follow the Cohesion steering method
	* @return heading--the new direction in degrees
	*/
	def cohesionDirection(){
		def boidSet = inRadius(turtles(),neighborhoodRadius)
		boidSet = other(boidSet)
		if(boidSet.size() > 0){
			def avgBoidDirection = getHeading()
			for(Boid boid : boidSet){
				avgBoidDirection = averageTwoDirections(towards(boid),avgBoidDirection)
			}
			def avgBoidDistance = desiredDistance
			for(Boid boid : boidSet){
				avgBoidDistance = (avgBoidDistance + distance(boid)) / 2
			}
			if(avgBoidDistance > desiredDistance){
				return avgBoidDirection
			}else{
			   return getHeading()
			}
		}else{
			return getHeading()
		}
	}
	
	/**
	* This method returns a direction in which this Boid should travel in order to follow the Separation steering method
	* @return averageHeading--the direction in radians
	*/
	def alignmentDirection(){
		def boidSet = inRadius(turtles(),neighborhoodRadius)
		boidSet = other(boidSet)
		def heading = getHeading()
		for(Boid boid : boidSet){
			heading = averageTwoDirections( heading, boid.getHeading() )
		}
		return heading
	}
	
	/**
	* Returns the direction halfway between one direction and another.
	* @param dir1--first angle in degrees
	* @param dir2--second angle in degrees
	* @return a double value between 0 and 360 representing a direction
	*/
	def averageTwoDirections(double dir1, double dir2){
		if(Math.abs(dir1-dir2) < 180){
			return (dir1+dir2)/2
		}
		else return oppositeDirection( (oppositeDirection(dir1) + oppositeDirection(dir2)) / 2 )
	}
	
	/**
	* Returns the direction opposite to the one passed it, in radians.
	* @param angle--a direction in radians
	* @return the opposite direction as angle in radians
	*/
	def oppositeDirection(double dir){
		return (dir + 180) % 360
	}
	
	/**
	* @param angle--a direction in radians
	* @return boolean value denoting whether the angle passed as argument is on the left-hand side of the calling Boid.
	*/
	def toMyLeft(double dir){
		if(Math.abs(dir - getHeading()) < 180){
			if(dir < getHeading())
				return true
			else return false
		}else{
			if(dir < getHeading())
				return false
			else return true
		}
	}
	
	/**
	* Moves the calling Boid some amount in a direction.
	* @param direction--the direction to move the Boid
	* @param dist--the amount to move the Boid
	*/
	def moveTowards(double dir, double amt){
		def heading = getHeading()
		setHeading(dir)
		forward(amt)
		setHeading(heading)
	}
	
	/**
	* Moves the calling Boid some amount in the opposite of a direction.
	* @param direction--the opposite of the direction to move the Boid
	* @param dist--the amount to move the Boid
	*/
	def moveAwayFrom(double dir, double amt){
		def heading = getHeading()
		setHeading( oppositeDirection(dir) )
		forward(amt)
		setHeading(heading)
	}
}
