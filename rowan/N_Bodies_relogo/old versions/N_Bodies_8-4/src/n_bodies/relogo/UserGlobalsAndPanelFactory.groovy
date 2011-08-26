package n_bodies.relogo

import repast.simphony.relogo.factories.AbstractReLogoGlobalsAndPanelFactory

public class UserGlobalsAndPanelFactory extends AbstractReLogoGlobalsAndPanelFactory{
	public void addGlobalsAndPanelComponents(){
	
		/**
		 * Uncomment by removing "//" below to include ReLogo Tick Display
		 */
		//addReLogoTickCountDisplay()
		addButtonWL("setupRandomBodies","Generate Random Bodies")
		addButtonWL("setupSolarSystem","Generate Solar System")
		addButtonWL("go","Go Once")
		addToggleButtonWL("go","Go")
		addSliderWL("numBodies","Number of Bodies",0,1,10,5)
		addSliderWL("bodiesVelocityAdd","Random Bodies Velocity Minimum",0.0,0.01,5.0,1.0)
		addSliderWL("bodiesMaxVelocity","Random Bodies Velocity Maximum",0,0.01,5.0,1.0)
		addSliderWL("maxBodiesMass","Max Mass of Bodies (not sun)",0.0,0.01,10.0,1.0)
		addSliderWL("timeConstant","Time Multiple (for slowing or speeding time)",0.01,0.01,10.0,1.0)
		addSliderWL("g","Gravitational Constant (g)",0.01,0.01,1.0,0.5)
		addSliderWL("massOfSun","Mass of Solar System's Sun",1,1,1000,200)
		addSliderWL("planetSunDist","Max Distance of Solar System's Planet(s) from Sun",0,0.01,15.0,7.5)
		
		/**
		 * Place custom panels and globals below, for example:
		 * 
		  		addButtonWL("setup","Setup") 	// Button with label ( method name, button label )
		  		addButton("action1")			// Button without label ( method name )
		  		addToggleButtonWL("go","Go")	// Toggle Button with label ( method name, button label )
		  		addToggleButton("action2")		// Toggle Button without label  ( method name )
		  		addGlobal("globalVariable1")	// Globally accessible variable ( variable name)
		  		// Slider with label ( variable name, slider label, minimum value, increment, maximum value, initial value )
		        addSliderWL("sliderVariable", "Slider Variable", 0, 1, 10, 5)
		        // Slider without label ( variable name, minimum value, increment, maximum value, initial value )
		        addSlider("sliderVariable2", 0.2, 0.1, 0.8, 0.5)
		        // Chooser with label  ( variable name, chooser label, list of choices , zero-based index of initial value )
		        addChooserWL("chooserVariable", "Chooser Variable", ["yes","no","maybe"], 2)
		        // Chooser without label  ( variable name, list of choices , zero-based index of initial value )
		        addChooser("chooserVariable2", [1, 66, "seven"], 0)
		 */

	}
}