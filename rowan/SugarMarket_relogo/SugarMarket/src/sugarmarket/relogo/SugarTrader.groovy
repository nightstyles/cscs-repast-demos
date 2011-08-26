package sugarmarket.relogo

import static repast.simphony.relogo.Utility.*;
import static repast.simphony.relogo.UtilityG.*;
import repast.simphony.relogo.BasePatch;
import repast.simphony.relogo.BaseTurtle;
import repast.simphony.relogo.Plural;
import repast.simphony.relogo.Stop;
import repast.simphony.relogo.Utility;
import repast.simphony.relogo.UtilityG;

class SugarTrader extends BaseTurtle {
	
	double sellPrice = randomFloat(10);
	double sugar = 0;
	double money = 0;
	double cheapThreshold = randomFloat(5.0)+2.5
	boolean soldThisTick = false
	boolean boughtThisTick = false
	boolean selling = true
	boolean buying = true
	int ticksSinceLastPurchase = 0
	int ticksSinceLastSell = 0
	int preferredPurchaseFrequency = random(5)+2
	int lookBackNTicks = random(2)+5
	SugarPrice sugarPrice
	
	def setup(SugarPrice sp){
		sugarPrice = sp
	}
	
	def step(){
		soldThisTick = false
		buying = buying()
		rollDice()
		if(buying){
			checkMarket()
		}
		if(selling)decideSellPrice()
		if(!boughtThisTick){ticksSinceLastPurchase++}
		else{ticksSinceLastPurchase = 0}
		if(!soldThisTick){ticksSinceLastSell++}
		else{ticksSinceLastSell = 0}
		
	}
	
	/**
	 * Randomly generates new random values for the variables selling and cheapThreshold. 
	 * @return
	 */
	def rollDice(){
		if(randomFloat(sugarPrice.lastSugarPrice) > 5.0){
			selling = false
		}else{ 
			selling = true
		}
		def cheapestTrader = minOneOf(sugarTraders()){cheapThreshold}
		cheapThreshold = cheapestTrader.cheapThreshold
		if(random(20)==0){
			cheapThreshold = sugarPrice.lastSugarPrice
		}
		if(random(100)==0){
			cheapThreshold = randomFloat(7.5)
		}
		if(random(50)==0){
			cheapThreshold = randomFloat(5.0) + 2.5
		}
		cheapThreshold += 0.1
	}
	
	/**
	 * Decides if the agent is buying Sugar this tick or not.
	 * @return
	 */
	boolean buying(){
		if(ticksSinceLastPurchase > preferredPurchaseFrequency){
			return true
		}else{
			if(randomFloat(sugarPrice.lastSugarPrice) > cheapThreshold) return false
			else return true
		}
	}
	
	/**
	 * Sees if there are sellers selling at the rate at which the buyer is willing to buy.
	 * @return
	 */
	def checkMarket(){
		if(sugarTradersWithSugar().size() > 0){
			def lowestSeller = minOneOf(sugarTradersWithSugar()){sellPrice}
			if(money >= lowestSeller.sellPrice){
				buy(lowestSeller)
			}
		}
	}
	
	/**
	 * Decides what the SugarTrader is willing to sell a unit of sugar for.
	 * @return
	 */
	def decideSellPrice(){
		def cheapestTrader = minOneOf(sugarTraders()){cheapThreshold}
		if(random(2)==0){
			sellPrice = (sugarPrice.lastSugarPrice + cheapestTrader.cheapThreshold)/2
		}else{ 
			sellPrice = (sugarPrice.lastSugarPrice*2 + cheapestTrader.cheapThreshold)/3
		}
		sellPrice += randomFloat(sugarPrice.demandLastTick/2)
		if(buying){
			sellPrice += randomFloat(2.0)
		}
		if(pricesGoingUp()){
			sellPrice += randomFloat(1.0)
		}
		if(sellPrice > 10.0){
			sellPrice = 10.0
		}
	}

	/**
	 * Compares the price of Sugar now to the price of Sugar some predetermined ticks back in time.
	 * @return
	 */
	boolean pricesGoingUp(){
		if(sugarPrice.getNetChangeOverNTicks(lookBackNTicks) > 0){
			return true
		}else return false
	}
	
	/**
	 * Buys Sugar from the specified Sugar Trader.
	 * @param trader
	 * @return
	 */
	def buy(trader){
		trader.sugar--
		sugar++
		money = money - trader.sellPrice
		trader.money = trader.money + trader.sellPrice
		trader.soldThisTick = true
		boughtThisTick = true
	}
	
	/**
	 * Returns a list of all Sugar Traders that are selling but have not yet sold Sugar this tick.
	 * @return
	 */
	def sugarTradersWithSugar(){
		def traders = sugarTraders()
		traders.clear()
		for(SugarTrader trader : sugarTraders()){
			if(trader.selling && !trader.soldThisTick && trader.sugar > 0){
				traders.add(trader)
			}
		}
		traders?.remove(this)
		return traders
	}
}