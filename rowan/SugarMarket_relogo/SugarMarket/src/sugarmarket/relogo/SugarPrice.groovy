package sugarmarket.relogo

import static repast.simphony.relogo.Utility.*;
import static repast.simphony.relogo.UtilityG.*;
import repast.simphony.relogo.BasePatch;
import repast.simphony.relogo.BaseTurtle;
import repast.simphony.relogo.Plural;
import repast.simphony.relogo.Stop;
import repast.simphony.relogo.Utility;
import repast.simphony.relogo.UtilityG;
import repast.simphony.relogo.ReLogoModel;

class SugarPrice {
	double lastSugarPrice
	def prices = new ArrayList<Double>()
	int totalTicks
	int totalSugarSoldThisTick
	int demandLastTick
	boolean demandUp
	
	def setup(){
		lastSugarPrice = randomFloat(8.0)+1.0
		prices.clear()
		prices.add(0)
		totalTicks = 0
		totalSugarSoldThisTick = 0
		demandLastTick = 0
		demandUp = false
	}
	
	/**
	 * Makes price the new current price of Sugar, and stores the old value of price in the ArrayList of historic prices.
	 * @param price
	 * @return
	 */
	def newSugarPrice(double price){
		lastSugarPrice = price
		prices.add(price)
	}
	
	/**
	 * Stores the current demand for Sugar, and whether demand has gone up over the past tick.
	 * @param demand
	 * @return
	 */
	def newDemandCount(int demand){
		if(demand > demandLastTick) demandUp = true
		else demandUp = false
		demandLastTick = demand
	}
	
	/**
	 * Returns the price of Sugar at the specified tick.
	 * @param tick
	 * @return
	 */
	def getPriceAtTick(int tick){
		return prices.get(tick)
	}
	
	/**
	 * Compares the price of Sugar at the current tick to the price of Sugar a number of ticks in the past, specified by ticks.
	 * @param ticks
	 * @return
	 */
	def getNetChangeOverNTicks(int ticks){
		if(ticks >= prices.size()){
			return lastSugarPrice
		}else{
			return lastSugarPrice - prices.get((int)(totalTicks - ticks))
		}
	}
}
