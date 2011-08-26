package n_bodies.relogo

import static repast.simphony.relogo.Utility.*;
import static repast.simphony.relogo.UtilityG.*;
import repast.simphony.relogo.BaseObserver;
import repast.simphony.relogo.Stop;
import repast.simphony.relogo.Utility;
import repast.simphony.relogo.UtilityG;

class UserObserver extends BaseObserver{

		def setupRandomBodies(){
			clearAll()
			setDefaultShape(Body,"circle")
			createBodies(numBodies){
				setup()
				mass = Utility.randomFloat(25.0)+1
				size = Math.sqrt(mass)*0.5
			}
		}
		
		def setupSolarSystem(){
			clearAll()
			setDefaultShape(Body,"circle")
			createBodies(1){
				setup(0,0,0,0)
				size = 4
				mass = massOfSun/10
				setColor(orange())
			}
			createBodies(1){
				setup(0,planetSunDist,planetXVel,0)
				size = 0.5
				mass = 0.1
				setColor(blue())
			}
		}
	
		def go(){
			ask(bodies()){
				step()
			}
		}

}