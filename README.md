# TicketingSystem

This is a very simple ticketing system that is developed using Angular JS, Play Framework and MongoDB using RESTful services.

One can create tickets, view, update, assign and delete them.

The landing page of the site has a login for where the user has to login with their credentials. The home page has four buttons to Add a ticket, View/Update/Delete a ticket that has been assigned to or created by the logged in user and view all tickets in the sytem, a text field to search a ticket by ID and a logout button. Based on the button you click, some set of fields are shown on which you can take additional actions.

# Add ticket:
* Contains list of fields to add Customer Info, Comments, Created by

* Any new ticket's state is by default NEW and this cannot be edited

* The list of users under the created by field are queried from a different collection named 'users'

* The tickets created are added in a collection named 'tickets'. Both collections mentioned will be stored in a DB named ticketsDB

# View/Update/Delete a ticket:
* Shows a list of tickets in tabular format, having three actions for each of them: Delete, View/Update and Assign

* Table shows all the data in a ticket, per column, that has been assigned to or created by the user who's logged in.

* Clicking on Delete ticket asks for confirmation before deleting it

* Clicking on "View" shows all the fields of the ticket. One can update all items of the ticket, except for who created it. The ticket state can also be changed to Open or Close. The ID and Created By fields are disabled. One can close this view by clicking on Cancel. More comments can be added to the ticket using the Comments section.

* This view shows all tickets that are NEW, OPEN and CLOSED

* Once the ticket is in CLOSE state, all the fields in the update view are disabled and hence cannot be edited

# Assign Ticket:
* Clicking on "Assign" in the view above, shows all the fields of the ticket. One can update all items of the ticket, except for who created it, before assigning it. By default, the ticket state is set to OPEN in this view. The ID and Created By fields are disabled. One can close this view by clicking on Cancel. More comments can be added to the ticket using the Comments section.

* Currently, the list of users shown in the Assign field are queried from another collection named 'users'

* There is a simple authentication mechanism as of now, which does not use any techniques like hashing or anything for password security. I've kept it really really simple.

# Search Ticket by ID
* If the user already knows the ticket id they want to see, they could use the ticket ID and search for it in the newly added search box

* Upon hitting search, the data is queried through an HTTP request and then displayed using the Update ticket view.

# View all tickets
* This view shows all the tickets that are there in the system. Its a simple view and the user cannot take any actions here.

# Set-up Details:
* First you need MongoDB as your data store. Download MongoDB and install it (https://www.mongodb.org/downloads)

* Create the folder structure "C:\data\db" (on windows), which is the default location where your data will be stored

* Go to the bin directory within the installation directory of MongoDB and start the "mongod.exe"

* Open another command prompt and start the mongo.exe file and type the following commands in the console:
*    use ticketsDB		-> creates the required DB
*    db.createCollection("users")		-> created the 'users' table/collection'''
*    db.post.insert([{userName: "John", password: "John"}, {userName: "Tom", password: "Tom"}, {userName: "Gary", passowrd: "Gary"}, {userName: "Scott", passowrd: "Scott"}, {userName: "Paul", password: "Paul"}])		-> creates 5 documents/rows with the given names and passwords

* Clone the repository or download the code as a ZIP file

* Go to the directory of the code using command prompt and type: "activator eclipse" (if you are looking to work with Eclipse)

* Once all the dependencies are resolved, then type "activator run" to start the server

* Open your browser, once the server is up, and go to http://localhost:9000/

* You should now be able to see the application

# Plans for future
* User registration
* Secure authentication
* Upload attachments to tickets
* Mail server to the system so that users are notified when tickets are assigned to them or are updated by them/someone else.
