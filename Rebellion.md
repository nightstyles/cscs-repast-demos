# Summary #

  * Source Code   : https://cscs-repast-demos.googlecode.com/svn/grace/Rebellion/
  * Platform      : [Repast Simphony Java](RepastSJava.md)
  * Documentation
    * Wiki: http://code.google.com/p/cscs-repast-demos/wiki/Rebellion
    * Readme: https://cscs-repast-demos.googlecode.com/svn/grace/Rebellion/docs/ReadMe.txt

# Contents #



---


# Prerequisites #

Proper installation of Repast Simphony (version 2.0 Beta, released 12/3/2010 or later).

# Description #

The rebellion model simulates how a group of people rebels against the authority (cops).  An example of the running model looks like the following figure:

![http://cscs-repast-demos.googlecode.com/svn/grace/Rebellion/docs/latex_files/images/rebellion.png](http://cscs-repast-demos.googlecode.com/svn/grace/Rebellion/docs/latex_files/images/rebellion.png)

Each person is in one of the three states:

  * **active**: red color; person decides to rebel (see calculation below for becoming an active person)
  * **jailed**: black color; active person arrested by cops; remain in jail until jail term expires
  * **quiet**: green color; neither active nor jailed
\end{itemize}

The cops (blue color) will randomly arrest active people within the visibility area.  To become an active (rebel), the person calculates his/her level of grievance and arrest probability:
  * _grievance = perceived hardship x (1 - government legitimacy)_
  * _arrest probability = 1 - exp(-k x floor(num of cops / num of active people))_
  * _**rebel** if (grievance - risk aversion x arrest probability) > threshold_

where
  * _perceived hardship_ = 1.0 (fixed for lifetime)
  * _government legitimacy_ = between 0 and 1; user specified
  * _k_ = constant for one cop and one person within vision = 2.3
  * _risk aversion_ = 1.0 (fixed for lifetime)
  * _threshold_ = 0.1

# Files and GUI #

Source files and description:

  * src/rebellion/**Constants.java** : list of constants
  * src/rebellion/**Cop.java** : class for cop
  * src/rebellion/**CoverageCounter.java** : counts number of people in different states; used for data sets and charts in GUI Scenario Tree
  * src/rebellion/**Person.java** : class for person
  * src/rebellion/**RebellionContextBuilder.java** : set up environment initially
  * src/rebellion/**SMUtils.java** : miscellaneous functions
  * src/rebellion.observer/**PersonStyleOLG2D.java** : color assignment for cop/person

Remember to setup the grid and space projections in the resource folder "Rebellion.rs": in context node, add projection for type=continuous space and id=space, and add projection for type=grid and id=grid.  The id's can be found in the file Constants.java.  Once we run the Rebellion model, set up the Scenario Tree as follow:

  * **Data Loaders** : Use RebellionContextBuilder
  * **Display**: Projection with grid, agents are Person and Cop, and agent style is  rebellion.observer.PersonStyleOLG2D for both Person and Cop
  * **Data Sets**: One for each active, quiet, and jailed people count from CoverageCounter.  Include a Title column for each data set so the chart will treat the counts in each data set as one series.  For example for active people, the Agent Class is CoverageCounter, agent mappings have column name Tick, ActivePeopleCount (source is getActivePeopleCount()), and Title (use Add $\rightarrow$ Add Using Wizards, and set value="Number of Active People")
  * **Charts**: One for each active, quiet, and jailed people data sets.  For example for active people count, X-Axis is Tick, Y-Axis Value is ActivePeopleCount with Series Name as Title.

# Model Parameters #

![http://cscs-repast-demos.googlecode.com/svn/grace/Rebellion/docs/latex_files/images/rebellion_param.png](http://cscs-repast-demos.googlecode.com/svn/grace/Rebellion/docs/latex_files/images/rebellion_param.png)

User-specified parameters are as follow:

  * **Government Legitimacy**:  Number of rows.
  * **Grid Height**:  Number of columns.
  * **Grid Width**:  Number of rows.
  * **Initial Cops Density**:  Percentage of grid size populated by cops.
  * **Initial People Density**:  Percentage of grid size populated by people.
  * **Max Jail Term**:  Maximum turns for people who are jailed.
  * **Neighbors Visibility Radius**:  Radius of area that the agent can see.

# References #

  * NetLogo termites model: http://ccl.northwestern.edu/netlogo/models/Rebellion
  * Modeling civil violence: An agent-based computational approach (http://www.pnas.org/content/99/suppl.3/7243.full)