# Architecture Testing
Singleton Design Pattern
The Singleton pattern encapsulates a shared resource within a single unique class instance.
This instance arbitrates access to the resource and storage-related state information.
A class method provides the reference to this instance, so there is no need to pass the reference around.
Any object that has access to the Singleton’s class header can use the Singleton.



![alt text](https://cdn-media-1.freecodecamp.org/images/1*GOAK3XdRvjrcpX9dq0fUrQ.png)


The Singleton Design Pattern can be used in the automation tests to build up easier access to page objects and facades.
Its usage can speed up the tests writing process dramatically.

I’ve covered the basic mechanics of the Singleton pattern, but why should we use it? Isn’t this just making our code more verbose and confusing? And what does all of this have to do with testing anyway?!

We should only apply patterns when we really need them, not just because some writer on the internet tells you to use it.

In the case of testing, here are some problems we may encounter:

1. Our classes and their dependencies can get very complex, and we don’t want to do end-to-end testing for every class, especially controllers.
2. We can’t always test at specific dates or times. What about bugs that happen only on the last day of the month, or 11:59PM GMT?
3. We can’t (or don’t want to) create specific data, such as custom settings, objects, or permissions.


![alt text](https://www.freecodecamp.org/news/content/images/2021/04/MVC3.png)


How do we solve these problems with this pattern?

Stub it out!

The Singleton pattern allows us to stub out the data we’re expecting, and test one method at a time (as a good test should). We can return “data” from downstream methods that we haven’t actually inserted, or specific dates and times.

For those of you intimately familiar with Apex development, this all might seem eerily similar to the Stub API — and it is! However, this is a fully customizable solution that allows you to stub out everything that you want without worrying about platform limitations.

  #reference article
  https://www.automatetheplanet.com/category/series/designpatterns/
  https://engineering.salesforce.com/simplify-testing-with-the-singleton-pattern-1a53ba5c2c50/
  https://www.freecodecamp.org/news/singleton-design-pattern-pros-and-cons-e10f98e23d63/