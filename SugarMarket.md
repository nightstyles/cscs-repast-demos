# Intro #
Sugar Market is an experiment attempting to create a realistic-looking chart of the value of a hypothetical resource (Sugar) with regards to a currency (Money) using Agent-Based Modeling. The model has seemingly unpredictable spikes in the value of Sugar, and likewise unpredictable drops.
The model is composed of some number of Sugar Traders, each with a randomly weighted set of rules on exchanging Sugar for Money. The Sugar Traders also make use of randomness for making decisions about buying to reduce complexity of the model.
The Sugar Market is a centralized location, so the geographical location of each Sugar Trader has no effect on that Sugar Trader's buying habits.
During this trading process, the Sugar Price class acts as a data bank that is accessible to all Sugar Traders, keeping track of the current and former value of Sugar.

# How to Use #
For this version of Sugar Market, there are no sliders to change values of variables while running the simulation. Just press 'Setup' and then 'Go.' The main area of interest is the chart of the value of Sugar.
However, changing the variables in the code or adding your own sliders is simple (try reading Jonathan Ozik's excellent ReLogo Getting Started Guide if you don't have experience with modifying ReLogo code).

# Things to Try #
Try changing these variables in the Sugar Trader class to change the nature of the simulation:
  * cheapThreshold: delineates the Sugar Trader's threshold of what is 'cheap', influencing when they will buy
  * preferredPurchaseFrequency: each sugar trader will try to buy after their ticksSinceLastPurchase counter becomes larger than this variable
  * lookBackNTicks: the amount of ticks that each Sugar Trader looks back when making comparisons is current price to historic price

# Possible Extensions #
  * create a Sugar Farm by putting methods inside the UserObserver and   SugarTrader classes and adding a slider for the value of Sugar and a button to sell the Sugar. The Sugar Farm can sell Sugar to the Sugar Traders at any price, which could have an enormous impact on the value of sugar.
  * create a Sugar User by similar methods as the Sugar Farm which will buy and consume Sugar, possibly at a premium, and thus increase demand for Sugar.
  * Remove the use of random() from the Sugar Trader methods while still maintaining the unpredictable fluctuations in the value of Sugar. random() can still be used to randomly weight starting variables like cheapThreshold.