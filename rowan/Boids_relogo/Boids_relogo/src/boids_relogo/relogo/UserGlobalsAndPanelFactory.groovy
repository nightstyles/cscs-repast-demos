package boids_relogo.relogo

import static repast.simphony.relogo.Utility.*;
import static repast.simphony.relogo.UtilityG.*;
import repast.simphony.relogo.BasePatch;
import repast.simphony.relogo.BaseTurtle;
import repast.simphony.relogo.Plural;
import repast.simphony.relogo.Stop;
import repast.simphony.relogo.Utility;
import repast.simphony.relogo.UtilityG;

import repast.simphony.relogo.factories.AbstractReLogoGlobalsAndPanelFactory

public class UserGlobalsAndPanelFactory extends AbstractReLogoGlobalsAndPanelFactory{
	public void addGlobalsAndPanelComponents(){

		  		addButtonWL("setup","Setup") 	// Button with label ( method name, button label )
			    addButtonWL("go","Go Once") 	// Button with label ( method name, button label )
		  		addToggleButtonWL("go","Go")	// Toggle Button with label ( method name, button label )
		  		// Slider with label ( variable name, slider label, minimum value, increment, maximum value, initial value )
		        addSliderWL("numBoids", "Number of Boids", 2, 2, 200, 50)
				
	}
}