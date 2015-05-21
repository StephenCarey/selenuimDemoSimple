selenuimDemoSimple
==================

A simple selenium demo

You will require [Maven](https://maven.apache.org/) and your IDE of choice.

Once you have pulled down the repo and installed maven then simply run the following in the selenuimDemoSimple folder

On your first run use:
##### mvn site
This will generate all of your reporting assets. These assets can be found in *target\site* the html file you are most interesting in will be surefire-report.html however open the index.html and see what other information is generated.

Once this is done you can use the following command for subsequent runs.
##### mvn surefire-report:report
