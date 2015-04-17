# Summary #
  * Source Code  : https://cscs-repast-demos.googlecode.com/svn/richard/ElFarol/trunk/
  * Platform     : [Repast Simphony Java](RepastSJava.md)
  * Mentor       : Dr. Eric Tatara
  * Author       : [Richard Oliver Legendi](Richard.md)



# Contents #



---


# Introduction #
The El Farol bar problem is a problem in game theory. Based on a bar in Santa Fe, New Mexico, it was created in 1994 by W. Brian Arthur. [Details](http://en.wikipedia.org/wiki/El_Farol_Bar_problem)

![https://cscs-repast-demos.googlecode.com/svn/wiki/ElFarol/simulation.png](https://cscs-repast-demos.googlecode.com/svn/wiki/ElFarol/simulation.png)

# Rick's Suggestions #
Most of my ideas of what would be ideal, tho maybe not doable, are listed below:

  * I'd like to see done sometime is an El Farol and/or Minority Game demo. It might be possible to put them both in the same program. The key differences are:


|           |        **Minority Game**   | **El Farol**              |
|:----------|:---------------------------|:--------------------------|
| signal    |    minority go/not       |  attend                 |
| threshold |     .50x                 |  0.60 (or other values) |
| strategy  |  m-history/Go-Not rules  |  Various                |

> So it might be possible to make it easy to select various options to get El Farol or Minority Game and it would be great if it was structured so its easy to add/switch in/out new types of strategy representation.

> It would be really cool if it was set up so that users could specify, say in an initialization file, strategies for some agents to use (built-in agents could have some default rules, which might even evolve/learn).

> So if any of you are thinking of doing things not on your current list, I'd sure like to see something along these lines, even a simple demo to start (e.g., see the NetLogo one that implements the Fogel et al.).

  * It might be interesting to have 2 people working on this, or at least to have one person make the basic demo and then someone extend it, including documenting what had to be done to extend it. Sort of a demo of _"how to extend a repasts model."_.

# References #
  * W. Brian Arthur, “Inductive Reasoning and Bounded Rationality”, American Economic Review (Papers and Proceedings), 84,406–411, 1994. [Online copy here.](http://www.santafe.edu/arthur/Papers/El_Farol.html)
  * Fogel etal. "Inductive Reasoning and Bounded Rationality Reconsidered." IEEE Trans. on Evolutionary Computation 3(2):  142-146, July. 1999.
  * Rand, W. and Wilensky, U. (2007). NetLogo El Farol model. http://ccl.northwestern.edu/netlogo/models/ElFarol. Center for Connected Learning and Computer-Based Modeling, Northwestern University, Evanston, IL.