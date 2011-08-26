package Boids_java;

import repast.simphony.context.Context;
import repast.simphony.context.space.continuous.ContinuousSpaceFactory;
import repast.simphony.context.space.continuous.ContinuousSpaceFactoryFinder;
import repast.simphony.context.space.grid.GridFactoryFinder;
import repast.simphony.dataLoader.ContextBuilder;
import repast.simphony.engine.environment.RunEnvironment;
import repast.simphony.engine.schedule.ScheduledMethod;
import repast.simphony.parameter.Parameters;
import repast.simphony.space.continuous.ContinuousSpace;
import repast.simphony.space.continuous.NdPoint;
import repast.simphony.space.continuous.RandomCartesianAdder;
import repast.simphony.space.grid.Grid;
import repast.simphony.space.grid.GridBuilderParameters;
import repast.simphony.space.grid.SimpleGridAdder;
import repast.simphony.space.grid.WrapAroundBorders;

/**
 * Repast Java implementation of Craig Reynolds' Boids algorithm.
 * see http://www.red3d.com/cwr/boids/
 * 
 * @author Z. Rowan Copley
 */
public class BoidsContextBuilder implements ContextBuilder<Object>{
	
	/**
	 * Adds the necessary projections and agents to the simulation's Context.
	 */
	public Context build(Context<Object> context) {
		context.setId("Boids_java");
		Parameters p = RunEnvironment.getInstance().getParameters();
		int gridDimension = (Integer) p.getValue("gridDimensions");
		int numBoids = (Integer) p.getValue("numBoids"); 
		ContinuousSpaceFactory spaceFactory = ContinuousSpaceFactoryFinder.createContinuousSpaceFactory(null);
		ContinuousSpace<Object> space = spaceFactory.createContinuousSpace("space",context,
				new RandomCartesianAdder<Object>(), 
				new repast.simphony.space.continuous.WrapAroundBorders(),
				gridDimension,gridDimension);
		Grid<Object> grid = GridFactoryFinder.createGridFactory(null).createGrid
		   ("grid", context, new GridBuilderParameters<Object>(
				   new WrapAroundBorders(),
				   new SimpleGridAdder<Object>(),true,
				   gridDimension,gridDimension));
		for(int i = 0; i < numBoids; i++){
			Boid boid = new Boid(space, grid);
			context.add(boid);
			NdPoint pt = space.getLocation(boid);
			grid.moveTo(boid, (int)pt.getX(), (int)pt.getY());
		}
		return context;
	}
	
	/**
	 * Slows down the simulation to a maximum of 30 ticks per second.
	 */
	@ScheduledMethod(start = 1, interval = 1)
	public static void sleep(){
		try {
			Thread.sleep(33);
		} catch (InterruptedException e){
			e.printStackTrace();
		}
	}
}
