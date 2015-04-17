# FAQ Sections #
This page contains some Frequently Asked Questions and Hints/Tips for the projects.




---


# Tutorials #
Some notes on the tutorials we have to create during the summer.

## What kind of tutorials should we create? ##
A sample tutorial is accessible in the SVN at the following link:

https://cscs-repast-demos.googlecode.com/svn/common/tutorials/sample

Note as it stands that kind of tutorial is more about _"here is how to create this model from scratch"_.

A more interesting task is creating documentation like [NetLogo](http://ccl.northwestern.edu/netlogo/) models all have, i.e., an explanation of the model, how to use it, interesting features of th e model as a system, and notes about interesting programming features, etc.

If you are not familiar with those NetLogo style demos and docs, take a look at them at the [NetLogo Model Library](http://ccl.northwestern.edu/netlogo/models/).

If we get a couple of the JZombies style tutorials thats good, but we don't expect that for every demo. But we do expect to have NetLogo style documentation for every one.


---


# Subversion FAQ #
Common SVN problems.

## Why am I unable to commit to the Repository? ##
  * **Question:** I was wondering how you created the folders and did your initial import of files?  I was able to see the SVN repositories in Simphony and was able to checkout.  But when I tried to create a a directory or upload anything, it always fails. I was hoping to at least create a directory like you did.
  * **Answer:**  The commit may fail because of the password: Google Code uses a different generated password for the Subversion repository than your usual Google account password. This generated password is accessible through the web interface. Login to the project site and click on the [Source](http://code.google.com/p/cscs-repast-demos/source/checkout) tab. See section _"When prompted, enter your generated googlecode.com [password](http://code.google.com/hosting/settings)."_ You can always regenerate that password there.

## 502 Bad Gateway problems ##
  * **Question:** I am keep getting some `502 Bad Gateway` errors while using the SVN server. What am I doing wrong?
  * **Answer:** There are some minor problems with the Subversion server at Google Code (e.g., see issues [here](http://code.google.com/p/support/issues/detail?id=730), [here](http://code.google.com/p/support/issues/detail?id=1409) or [here](http://code.google.com/p/support/issues/detail?id=1427)). It seems there is no ultimate solution for the issue, the only one is to keep trying: 1 out of 4 or 5 commits should work...

## 405 Method Not Allowed ##
  * **Question:** This error occurs when you try to commit: _"Server sent unexpected return value (405 Method Not Allowed) in response to MKACTIVITY request for '/svn/!svn/act/_random hex characters_."_
  * **Possible Solution:** This occurs when you try to make anonymous commits to the repository. Check to make sure that your repository URL starts with `https` instead of `http`.

## Publish HTML on Google Code ##
  * **Question:** I would like to make an HTML file accessible with direct link from the Google Code SVN (e.g., generated Javadoc). Is it possible to do it?
  * **Answer:** Sure, just make sure you set the `svn:mime-type=text/html` SVN property. To make it automatically, [set a default auto enabled property for new HTML files](http://stuffthathappens.com/blog/2007/11/09/howto-publish-javadoc-on-google-code/) (see the details [here for Subclipse](http://islandlinux.org/howto/enable-auto-properties-auto-props-subversion-subclipse-eclipse)), or [create a small script](http://stackoverflow.com/questions/1764521/recursive-svn-propset) that sets the required properties for existing files from the command line. See an example [here](http://cscs-repast-demos.googlecode.com/svn/richard/StupidModel/trunk/docs/cobertura/index.html).


---


# Wiki FAQ #
## How do I add a sidebar to a page like the other pages have? ##
If you create a new page, you can add the sidebar to it by using the following pragma definition:

```
#sidebar TableOfContents
```

## How do I add a table of contents to a page like the other pages have? ##
If you create a new page, you can add the table of content to it by using the following pragma definition:

```
<wiki:toc max_depth="2" />
```

The table of contents will be made from the headings you include in your Wiki page. You can change the depth by changing the value in `""`.

## How do I add pictures to the Wiki pages? ##
First, find a proper place in the SVN to upload it, and then put the URL of it directly into the Wiki page, e.g.:

```
https://cscs-repast-demos.googlecode.com/svn/common/test/Funny-Panda.jpg
```

It will display a Funny Panda:

![https://cscs-repast-demos.googlecode.com/svn/common/test/Funny-Panda.jpg](https://cscs-repast-demos.googlecode.com/svn/common/test/Funny-Panda.jpg)

For further info, please refer to the [WikiSyntax](http://code.google.com/p/support/wiki/WikiSyntax#Links_to_external_pages) documentation.

## Export GoogleCode Wiki to other formats ##
There are several tools for available, but some of them is [not mature enough](http://chrisroos.co.uk/blog/2008-07-30-converting-google-code-wiki-content-to-html), some of them is good but there are minor differences (e.g., pictures with with [wikiwym](http://fossil.wanderinghorse.net/demos/wikiwym/GoCoWi-previewer.html)).

We created a simple page that does some URL magic and asks the GoogleCode server to render specific things only as described in the officiall [Wiki FAQ](http://code.google.com/p/support/wiki/WikiFAQ#Can_I_download_wiki_content_as_HTML?):

> https://cscs-repast-demos.googlecode.com/svn/common/tools/SimplifyWikiPage/SimplifyWikiPage.html

Just enter the name of the Wiki page you would like to see without the other components (e.g., the navbar) and press _Show_. We added some checkboxes for the components we were able to figure out how to render or not, you can play with them easily.

They mentioned [another project](http://code.google.com/p/google-code-wiki-to-html/) which downloads the full Wiki as it is.

So that was the best solution we were able to come up with for this issue. It has still some minor problems (e.g., it does not resize images as the Wiki and somehow it doesn't includes syntax highlighting), but it is good enough to put next to the sources to read it offline.

We have also encountered some tools that can [convert MoinMoin Wiki text](http://moinmo.in/FormatterMarket?highlight=%28moin2rst%29) (the GoogleCode Wiki Syntax is a derivative of that) to other formats automatically (e.g., to LaTeX, which may be useful in the future), but we weren't able to use them so far successfully.


---


# GSoC 2011 #
## Where to Upload the Created Models? ##
At the end of GSoC 2011 we have to upload the created materials (documentation, models, etc.) to the official GSoC site of the project which can be found at the following link:

> http://code.google.com/p/google-summer-of-code-2011-cscs/