package n_bodies.relogo

import static repast.simphony.relogo.Utility.*;
import static repast.simphony.relogo.UtilityG.*;
import repast.simphony.relogo.BaseObserver;
import repast.simphony.relogo.Stop;
import repast.simphony.relogo.Utility;
import repast.simphony.relogo.UtilityG;

/**
 * N-Bodies gravitational simulator. Based on the model found at http://ccl.northwestern.edu/netlogo/models/N-Bodies
 * 
 * @author Z. Rowan Copley
 */
class UserObserver extends BaseObserver{

		def setupRandomBodies(){
			clearAll()
			setDefaultShape(Body,"circle")
			createBodies(numBodies){
				setup()
				mass = Utility.randomFloat(1.0)+0.01
				size = Math.sqrt(mass)*2
			}
		}
		
		def setupSolarSystem(){
			clearAll()
			setDefaultShape(Body,"circle")
			createBodies(1){
				setup(0,0,0,0)
				size = 4
				mass = massOfSun
				setColor(orange())
			}
			createBodies(numBodies){
				mass = randomFloat(maxBodiesMass)
				def vx = randomFloat(bodiesMaxVelocity)+bodiesVelocityAdd
				setup(0,planetSunDist,vx,0)
				size = Math.sqrt(mass)+0.25
			}
		}
	
		def go(){
			Thread.sleep((int)33/timeConstant)
			ask(bodies()){
				step()
			}
		}

}