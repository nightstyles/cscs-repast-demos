package n_bodies.relogo

import static repast.simphony.relogo.Utility.*;
import static repast.simphony.relogo.UtilityG.*;
import repast.simphony.relogo.BasePatch;
import repast.simphony.relogo.BaseTurtle;
import repast.simphony.relogo.Plural;
import repast.simphony.relogo.Stop;
import repast.simphony.relogo.Utility;
import repast.simphony.relogo.UtilityG;
/**
 * Transposed and modified from NetLogo N-Bodies model. 
 * see: http://ccl.northwestern.edu/netlogo/models/N-Bodies
 * @author Rowan Copley
 *
 */
@Plural("Bodies")
class Body extends BaseTurtle {
	def fx  //x-component of force vector
	def fy  //y-component of force vector
	def vx  //x-component of velocity vector
	def vy  //y-component of velocity vector
	def xc  //real x-coordinate (in case particle leaves world)
	def yc  //real y-coordinate 
	def mass
	
	/**
	 * Function for setting up a non-solar system body.
	 */
	def setup(){
		setxy(randomXcor()/2,randomYcor()/2)
		vx = (Utility.randomFloat(bodiesMaxVelocity))+bodiesVelocityAdd
		vy = (Utility.randomFloat(bodiesMaxVelocity))+bodiesVelocityAdd
		xc = getXcor()
		yc = getYcor()
		fx = 0
		fy = 0
	}
	
	/**
	 * Funtion for setting up a body in a solar system.
	 * @param xcor
	 * @param ycor
	 * @param xvel
	 * @param yvel
	 * @return
	 */
	def setup(def xcor, def ycor, def xvel, def yvel){
		def distanceMultiple = randomFloat(planetDistanceVariation)+(1.0-(planetDistanceVariation/2))
		setxy(xcor*distanceMultiple,ycor*distanceMultiple)
		vx = xvel
		vy = yvel
		xc = getXcor()
		yc = getYcor()
		fx = 0
		fy = 0
	}
	
	/**
	 * Runs every tick.
	 * @return
	 */
	def step(){
		update_force()
		update_velocity()
		update_position()
	}
	
	/**
	 * Calculates the vector of gravitational force being exerted on it; but in two parts--x and y axes.
	 * @return
	 */
	def update_force(){
		for(Body body : other(bodies())){
			def xd = xc - body.xc
			def yd = yc - body.yc
			def distance = Math.sqrt((xd * xd) + (yd * yd))
			def angle = Math.toRadians(towards(body))
			fx = fx + Math.sin(angle)*((mass * body.mass) / (distance*distance))
			fy = fy + Math.cos(angle)*((mass * body.mass) / (distance*distance))			
		}
	}
	
	/**
	 * Uses the force variables to update the body's instant velocity.
	 * @return
	 */
	def update_velocity(){
		vx = vx + (fx * g / mass)
		vy = vy + (fy * g / mass)
		fx = 0
		fy = 0
		label = (int)(Math.sqrt(vx*vx+vy*vy)*100)
	}
	
	/**
	 * Changes the body's position variables according to the instant velocity.
	 * @return
	 */
	def update_position(){
		xc = xc + vx
		yc = yc + vy
		adjustPosition()	
	}
	
	/**
	 * Uses the body's position variables to update its actual position.
	 * @return
	 */
	def adjustPosition(){
		if(xc > getMinPxcor() && xc < getMaxPxcor() && 
		   yc > getMinPycor() && yc < getMaxPycor()){
			setxy(xc,yc)
			showTurtle()
		}else{
			hideTurtle()
		}
	}
}
