package n_bodies.relogo

import repast.simphony.relogo.factories.AbstractReLogoGlobalsAndPanelFactory

public class UserGlobalsAndPanelFactory extends AbstractReLogoGlobalsAndPanelFactory{
	public void addGlobalsAndPanelComponents(){
		addReLogoTickCountDisplay()
		addButtonWL("setupRandomBodies","Generate Random Bodies")
		addButtonWL("setupSolarSystem","Generate Solar System")
		addButtonWL("go","Go Once")
		addToggleButtonWL("go","Go")
		addSliderWL("numBodies","Number of Bodies",0,1,10,3)
		addSliderWL("bodiesVelocityAdd","Random Bodies Velocity Minimum",0.0,0.01,5.0,1.0)
		addSliderWL("bodiesMaxVelocity","Random Bodies Velocity Random Range",0,0.01,5.0,2.0)
		addSliderWL("maxBodiesMass","Max Mass of Bodies (not sun)",0.0,0.01,10.0,0.5)
		addSliderWL("timeConstant","Time Multiple (for slowing or speeding time)",0.01,0.01,10.0,1.0)
		addSliderWL("g","Gravitational Constant (g)",0.01,0.01,1.0,0.5)
		addSliderWL("massOfSun","Mass of Sun",1,1,1000,200)
		addSliderWL("planetSunDist","Approximate Distance of Planet(s) from Sun",0,0.01,10.0,7.5)
		addSliderWL("planetDistanceVariation","Planet Distance from Sun Variation",0.01,0.01,1.0,0.5)
	}
}