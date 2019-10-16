To setup the application, You need the appropriate java ide(such as netbeans or eclipse) and jdk version 1.8 installed. Please follow the following steps:

Step 1: Create a mysql database and name it "Loans". You do not need to create any tables or insert any data.
Step 2: Import the maven project into your workspace.
Step 3: Start the microservice. It will start on port 1996. If that port is already in use on your system, then change it to whatever port you desire in the "application.yml" file.
Step 4: Open the browser and navigate to the service url. i.e http://localhost:1996/

Using the application:

1. Once you navigate to the home page i.e. http://localhost:1996, you will be shown the form to enter the appropriate data in order to calculate the loan monthly payments. 
Fill in the form and press calculate to see the results. On the results page, you will see the monthly payment and all additional calculations, as well as the appropriate graphical representation of data.
2. The home page also shows a list of previous calculations that are stored temporarily in memory if, and only if a name is entered on the form.
3.To view the a list of records stored in the database, enter the following URL: http://localhost:1996/persistence.

I have attached screenshots of the application running for extra convenience.

Application that is deployed on Heroku does not work correctly as heroku requires credit card for mysql databases. But here is the link anyway if that changes in the future:
https://mortgagecalculatorvishay.herokuapp.com/
