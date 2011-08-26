package sugarmarket.relogo

import static repast.simphony.relogo.Utility.*;
import static repast.simphony.relogo.UtilityG.*;
import repast.simphony.relogo.BaseObserver;
import repast.simphony.relogo.Stop;
import repast.simphony.relogo.Utility;
import repast.simphony.relogo.UtilityG;

/**
* Model attempting to replicate the unpredictability of resource trading markets.
*  
* @author Z. Rowan Copley
*/

class UserObserver extends BaseObserver{
	SugarPrice sp = new SugarPrice()
	
	def setup(){
		clearAll()
		sp.setup()
		createSugarTraders(numTraders){
			setup(sp)
			sugar = 10
			money = 100
			setxy(randomXcor(),randomYcor())
		}
	}
	
	/**
	 * Tells the Sugar Traders to run their step() methods, as well as updating Sugar prices and the demand total.
	 * @return
	 */
	def go(){
		ask(sugarTraders()){
			step()
		}
		if(getBuyers()==0){
			sp.newSugarPrice(getPriceOfSugar()-0.1)
		}else{
			sp.newSugarPrice(getPriceOfSugar())
		}
		sp.newDemandCount(getBuyers()-sp.totalSugarSoldThisTick)
		sp.totalTicks++
		Thread.sleep(50)
	}
	
	/**
	 * Returns the average price that Sugar sold for, on the last tick that Sugar was sold.
	 * @return
	 */
	def getPriceOfSugar(){
		def sugarSold = 0
		def price = 0
		def priceOfSugar = sp.lastSugarPrice
		ask(sugarTraders()){
			if(soldThisTick){
				sugarSold++
				price += sellPrice
			}
		}
		sp.totalSugarSoldThisTick = sugarSold
		if(sugarSold > 0){
			priceOfSugar = price / sugarSold
		}
		return priceOfSugar
	}
	
	/**
	 * Returns the number of Sugar Traders selling Sugar this tick. 
	 * @return
	 */
	def getSellers(){
		def total = 0
		ask(sugarTraders()){if(it.selling)total++}
		return total
	}
	
	/**
	 * Returns the number of Sugar Traders buying Sugar this tick.
	 * @return
	 */
	def getBuyers(){
		def total = 0
		ask(sugarTraders()){if(it.buying)total++}
		return total
	}
	
	/**
	 * Returns the average price for which Sugar Traders are offering to sell Sugar.
	 * @return
	 */
	def averageSellPrice(){
		def total = 0
		def traders = 0
		ask(sugarTraders()){
			if(it.selling){
				total = total + it.sellPrice
				traders++
			}
		}
		if(traders == 0) return 0
		else return total/traders
	}

	/**
	 * Returns the amount of money that the poorest Sugar Trader has.
	 * @return
	 */
	def poorestTraderMoney(){
		def poorest = minOneOf(sugarTraders()){getMoney()}
		return poorest.getMoney()
	}
	
	/**
	 * Returns the amount of money that the richest Sugar Trader has.
	 * @return
	 */
	def richestTraderMoney(){
		def richest = maxOneOf(sugarTraders()){getMoney()}
		return richest.getMoney()
	}
	
	/**
	 * Returns the largest amount of Sugar that any Sugar Trader has amassed. 
	 * @return
	 */
	def largestSugarStockpile(){
		def richest = maxOneOf(sugarTraders()){getSugar()}
		return richest.getSugar()
	}
	
	/**
	 * Returns the smallest amount of Sugar that any Sugar Trader has left.
	 * @return
	 */
	def smallestSugarStockpile(){
		def poorest = minOneOf(sugarTraders()){getSugar()}
		return poorest.getSugar()
	}
	def demand(){
		return sp.demandLastTick
	}
	
	/**
	 * Returns the number of Sugar that was exchanged this tick.
	 * @return
	 */
	def sugarSoldThisTick(){
		return sp.totalSugarSoldThisTick
	}
}