package sugarmarket.relogo

import repast.simphony.relogo.factories.AbstractReLogoGlobalsAndPanelFactory

public class UserGlobalsAndPanelFactory extends AbstractReLogoGlobalsAndPanelFactory{
	public void addGlobalsAndPanelComponents(){
	  		addButtonWL("setup","Setup") 	// Button with label ( method name, button label )
			addButtonWL("go","Go Once")
	  		addToggleButtonWL("go","Go")	// Toggle Button with label ( method name, button label )
 		    addSliderWL("numTraders", "Number of Sugar Traders", 0, 1, 100, 25)
			addMonitorWL("averageSellPrice","av sell price",1)
			addMonitorWL("getBuyers","get buyers",1)
			addMonitorWL("getSellers","get sellers",1)
//			addMonitorWL("averageBuyPrice","avg buy price",1)
//			addMonitorWL("richestTraderMoney","Richest Trader's Money",1)
//			addMonitorWL("poorestTraderMoney","Poorest Trader's Money",1)
			addMonitor("demand",1)
			addMonitor("largestSugarStockpile",1)
			addMonitor("smallestSugarStockpile",1)
			addMonitor("sugarSoldThisTick",1)
				
	}
}