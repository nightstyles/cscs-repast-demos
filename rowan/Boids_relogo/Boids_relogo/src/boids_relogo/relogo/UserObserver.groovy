package boids_relogo.relogo

import static repast.simphony.relogo.Utility.*;
import static repast.simphony.relogo.UtilityG.*;
import repast.simphony.relogo.BaseObserver;
import repast.simphony.relogo.Stop;
import repast.simphony.relogo.Utility;
import repast.simphony.relogo.UtilityG;

/**
 * ReLogo implementation of Craig Reynolds' Boids algorithm.
 * see http://www.red3d.com/cwr/boids/
 * 
 * @author Z. Rowan Copley
 */
class UserObserver extends BaseObserver{


		def setup(){
			clearAll()
			setDefaultShape(Boid,"arrow")
			createBoids(numBoids){
				setxy(randomXcor(),randomYcor())
			}
		}
	
		def go(){
			ask(boids()){
				step()
			}
		}
}