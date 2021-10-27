# NaincyDemo
* Which Tool you picked for the job and why ?
- Framework Demo Overview–Using Page Object Model with Page Factory framework
Used POM because it has many advantages :
All possible functionality or operations that can be performed on a page can be defined and contained within the same class created for each page. This allows for clear definition and scope of each page's functionality.
Object Repository of the fields can be created segmented wise which reducy the redundancy of locators.

Project/Application: SalesChamp  
No. of Test Cases: 1
Functional Tests: Apply for Role

Automation Tools: Selenium Web Driver, TestNG framework and Java
Different Components:
-Selenium Webdriver is being used as the core automation engine.
-Eclipse IDE is used to develop the automated scripts. 
-TestNG framework is used for organizing the scripts.
-Page Factory are created to store the element definitions.
-Language - JAVA
-Build Tool - Using standardized maven project for build, execution & dependency management.
-Logging Mechanism - Using log4j library to maintain logging of our project. Using all kinds of logging statements like INFO,ERROR etc, which is an exceptional assistent in debugging the program execution issues and failures.
-Reporting - Using Extent Report for reporting purpose. It is a third party report.
-Git and Github is used for version control management.



* How would you present the output of automated test ?
I have used two things to represent an output:
- Extent Reports is being used for reporting purpose as it provides many advantages like stepwise report generation ,pie chart representation, adding screenshots etc. 
Even we can track how much time it took.
- Log4j are an exceptional assistant in debugging the program execution issues and failures.It displays information in console.Information could be any detail depends upon the purpose.


* Which user actions and page element you have decided to test and why ?
- I was supposed to automate Career Page where user finds the vacancy for specific role and apply for same, so my approach was to check whether that role is available or not.
Thus, to check I took data from Config file but yes, this could be done through Excel as well but as we did not have more data so I opted config file and pass the data as a parameter in one of the methods and if role finds ,click on Apply.
Basically used Selenium method like :
* Click
* Send Keys
* Scrolling through Javascript Executor
* Accepting an alert through Action Class
* iFrame to locate an element in iframe
* Screenshot to capture an image

Page Element : 
Decided to locate an element through xpath and css
Basic Xpath which I used :
Text(): In this expression, with text function, we find the element with exact text match.
Contains() -  used when the value of any attribute changes dynamically or text is long.
Using Basic Attributes like  ID , Name etc.
Preceding::Sibling & Following::sibling
Parent
Basically used Relative xpath to identify an element fast.



How do you run the test cases.
As I am using TestNG which helps to organize the scripts besides provide many advantages as well like :
* Helps to segregate the Test Cases based on groups ( Smoke, Regression.)
* Test Cases can be prioritized.
* No need of static main method
* Same TCs can be executed multiple times without using loop by using keyword called 'invocation count'.
* Multiple test cases can be grouped more easily by converting them into testng.xml file.
* Test Cases  can be run parallel using textng.xml
* Cross browser testing can be done using testng.xml

If its on local then we can directly run using testng.xml by simply rught click on it and selecting Test NG Suite in Run As.
If want to run central repository directly where many people working together then Jenkins which is a Continuous Integration tool will be a good option to run.





