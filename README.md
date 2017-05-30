# Marine-Mammal-Stranding-Network-Client
The client side code for a volunteer Marine Mammal Stranding network. 
The code is focused on the San Juan Islands Marine Mammal Stranding network. 
This code allows reports to be generated and to keep track of volunteers hours and information.

http://www.sjcmmsn.com/

## Setup

### Install ant
brew install ant

### install java
brew cast install java

### install gwt v2.8.1

http://www.gwtproject.org/versions.html
Download and add the folder to your path in the ~/.profile

## Develop locally

Change the src/com/mmsn/reportgen/client/GUIBuilder.java file to use the TestServiceLocations instead of the ReleaseServiceLocations. 
This allows the code to call the fake local backend. 

Complie the code with `ant build` and then run `ant devmode`. Then goto http://127.0.0.1:8888/MarineMammalSN.html


## Deploy 

To deploy the code change the src/com/mmsn/reportgen/client/GUIBuilder.java to use the ReleaseServiceLocations.
Then `ant zip` to package up the output files. This will create a client.zip file in the root directory. 
Take that file and unzip it in the root of the Marine-Mammal-Stranding-Network-Server deployed project.
