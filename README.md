# TicketingSystem

This is a very simple ticketing system that is developed using Angular JS, Play Framework and MongoDB using RESTful services.

One can create tickets, view, update, assign and delete them.

The landing page of the site has three buttons to Add a ticket, View/Update/Delete a ticket and Assign a ticket. Based on the button you click, some set of fields are shown on which you can take actions.

# Add ticket:
* Contains list of fields to add Customer Info, Comments, Created by

* Any new ticket's state is by default NEW and this cannot be edited

* The list of users under the created by field are queried from a different collection named 'users'

* The tickets created are added in a collection named 'tickets'. Both collections mentioned will be stored in a DB named ticketsDB

# View/Update/Delete a ticket:
* Shows a list of tickets in tabular format, having two actions for each of them: Delete and Update/Delete

* Table shows all the data in a ticket, per column

* Clicking on Delete ticket asks for confirmation before deleting it

* Clicking on Update ticket shows all the fields of the ticket. One can update all items of the ticket, except for who created it. The ticket state can also be changed to Open or Close. The ID and Created By fields are disabled. One can close this view by clicking on Cancel. More comments can be added to the ticket using the Comments section.

* This view shows all tickets that are NEW, OPEN and CLOSED

* Once the ticket is in CLOSE state, all the fields in the update view are disable and hence cannot be edited

# Assign Ticket:
* Show a list of tickets in tabular format, having one actions for each of them: Assign

* Table shows all the data in a ticket, per column

* Clicking on Assign This Ticket shows all the fields of the ticket. One can update all items of the ticket, except for who created it, before assigning it. By default, the ticket state is set to OPEN in this view. The ID and Created By fields are disabled. One can close this view by clicking on Cancel. More comments can be added to the ticket using the Comments section.

* Currently, the list of users shown in the Assign field are queried from another collection named 'users'

There is no authentication mechanism as of now.

# Set-up Details:
* First you need MongoDB as your data store. Download MongoDB and install it (https://www.mongodb.org/downloads)

* Create the folder structure "C:\data\db" (on windows), which is the default location where your data will be stored

* Go to the bin directory within the installation directory of MongoDB and start the "mongod.exe"

* Open another command prompt and start the mongo.exe file and type the following commands in the console:
**	use ticketsDB		-> creates the required DB
**	db.createCollection("users")		-> created the 'users' table/collection
**	db.post.insert([{userName: "John"}, {userName: "Tom"}, {userName: "Gary"}, {userName: "Scott"}, {userName: "Paul"}])		-> creates 5 documents/rows with the given names

* Clone the repository or download the code as a ZIP file

* Go to the directory of the code using command prompt and type: "activator eclipse" (if you are looking to work with Eclipse)

* Once all the dependencies are resolved, then type "activator run" to start the server

* Open your browser, once the server is up, and go to http://localhost:9000/

* You should now be able to see the application
