# General Information #

## Introduction ##

My name is Richard Oliver Legendi, I'm in my second year at Eötvös Loránd University as a PhD student, at the Dept. of Programming Languages and Compilers. I've participated in the development of some other ABM tools (like [MASS](http://mass.aitia.ai/), [Fables](http://mass.aitia.ai/fables/), and [GridABM](http://gridabm.sourceforge.net/)).

It is a great pleasure to be on board and to be able to participate in the project.

I would like to create simple models and tutorials about how to link Repast with other commonly used tools (like [R](http://www.r-project.org/), [Matlab](http://www.mathworks.com), [Octave](http://www.gnu.org/software/octave/) and [Maple](http://www.maplesoft.com/products/maple/)), I believe this may help modelers and make [Repast S](http://repast.sourceforge.net/) a more widely used tool.

  * Mentor: [Eric R. Tatara PhD, PE](http://mypages.iit.edu/~tataeri/)
  * Location: Budapest, Hungary
  * Time Zone: GMT+01:00
  * University:
    * [Eötvös Loránd University](http://www.elte.hu/en)
    * [Faculty of Informatics](http://www.inf.elte.hu/english)
    * [Dept. of Programming Languages and Compilers](http://plcportal.inf.elte.hu/en)

## Contact ##
  * E-mail: [mailto:richard.legendi@gmail.com](mailto:richard.legendi@gmail.com)
  * Google: richard.legendi
  * Skype: rlegendi
  * IRC: legendi, roante
  * Web: http://people.inf.elte.hu/legendi/


---


# Planned Models #
You can find the descriptions of the models I plan to create during the summer.

## Implementation of the StupidModel ##

I am sure the [StupidModel](http://condor.depaul.edu/slytinen/abm/StupidModelFormulation.pdf) (1) considered a relevant learning /comparison tool for agent-based modelling. In the last half-a-year I saw it appearing several places, like in the tutorial of gama-platform (2), and in a JASSS publication (3) with a Python API. I've also used it for comparing platforms in one of my publications with different software metrics.

There was a [NetLogo](http://ccl.northwestern.edu/netlogo/) implementation from the beginning, and as I see it is accessible for [Mason](http://www.cs.gmu.edu/~eclab/projects/mason/) (4). It seems I'm a bit drop behind with [MetaABM](http://metaabm.org/), however, I made a bit of search and saw it is also accessible for this platform (5).

I believe it would worth implementing this tool, and improve the comparability with other platforms.

## Using External Tools with Repast S ##

I would like to create simple models and tutorials about how to link Repast with other commonly used tools (like R for statistics, Matlab for learning, Octave for some differential equations, and so on).

I believe such demo models and detailed descriptions may help modelers and make [Repast S](http://repast.sourceforge.net/) a more widely used tool.

### Tools ###
I would like to create several smaller models, link them with some of the following tools and write detailed tutorials how to use them.

  * Matlab/Maple/Octave
  * ORA
  * R
  * Spreadsheets
  * JUNG
  * Terracotta
  * Weka
  * Pajek

### Models ###
I am thinking of smaller models, because i) they could be better for tutorial and demo reasons, and ii) the emphasis is on how to use external tools with Repast S, not on the models. For this reason I thought to implement simple known models, like the following ones.

#### Statistics ####
I think a major contribution would be if we could link Repast S with R. Several messages come to the [repast-interest](https://lists.sourceforge.net/lists/listinfo/repast-interest) mailing list about R (6-7), and I also found a blog (8) stating:

> _"I thought  Repast Simphony was the way to go, since the website claims about capabilities to work along with R, but then I was disappointed to find out that it was only storing the output in a data.frame class object (and besides it does not work on a  Mac...). Then after switching (at this stage almost completely) to NetLogo, I found this awesome extension, currently in beta stage (and alas, still not working on yet on a Mac...) but as far as I've seen it works perfectly fine."_

I do not have any particular model in mind right know, any suggestions are more than welcome where we can use some of the features of R.

#### Population Dynamics ####
A simple population dynamics model, like Lotka–Volterra (9) would be good to use with any of the mathematical tools (Matlab, Maple, Octave).

They can handle and approximate the solutions of the differential equation systems without any problem (i.e. we don't have to deal with implementing a method like Runge-Kutta).

#### El Farol ####
Another simple model famous because it is one of the first models related to minority games (10). One version of the model uses genetic algorithm (11), this could be a good opportunity to use any Java-based GA library (like JGAP), or use any of the mathematical tools since they usually have built-in support for such optimization problems (Matlab, Maple, Octave).


---


# Created Models #

## El Farol ##
For the details, please refer to the [El Farol](ElFarol.md) page (Demo Model).

## Stupid Model ##
For the details, please refer to the [StupidModel](StupidModel.md) page (Tutorial).

# References #

  1. http://condor.depaul.edu/slytinen/abm/StupidModelFormulation.pdf
  1. http://code.google.com/p/gama-platform/wiki/Stupid_Tutorial_Model1
  1. http://jasss.soc.surrey.ac.uk/14/2/5.html
  1. http://condor.depaul.edu/slytinen/abm/
  1. http://metaabm.org/docs/designing_model.html
  1. [Using the R-Plugin](http://sourceforge.net/mailarchive/forum.php?thread_name=C4CF3FB80A756643BE25F5F55CAC3ABC1075F727%40ERD-ML1ERD.erd.ds.usace.army.mil&forum_name=repast-interest)
  1. [About sensitivity analysis in Repast](http://sourceforge.net/mailarchive/forum.php?thread_name=A4E4FC10-E5AF-49D0-AE24-B8C41309B617%40ed.ac.uk&forum_name=repast-interest)
  1. http://evolvingspaces.blogspot.com/2010/03/netlogo-r-extension.html
  1. Lotka, A.J., "Contribution to the Theory of Periodic Reaction", J. Phys. Chem., 14 (3), pp 271–274 (1910)
  1. W. Brian Arthur. "Inductive Reasoning and Bounded Rationality", The American Economic Review, v84n2, p406-411 (1994)
  1. Fogel, D.B.; Chellapilla, K.; Angeline, P.J., "Inductive reasoning and bounded rationality reconsidered", IEEE Transactions on Evolutionary Computation, v3n2, p142-146 (1999)