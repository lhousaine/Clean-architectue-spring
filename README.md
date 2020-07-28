# Clean-architectue-spring
this project is a result of applying Uncle Bob's Clean architecture.
### Present Project Layers :
So, to the project architecture is divided into three main layers and a Core layer for everything shared between all the three layers :
Core Layer : present all configuration including BeansConfigs, security, Data Validation, Swagger Configuration
Presentation Layer: presents data to a screen and handle user interactions.
Domain Layer: this layer implements the business logic of the applciation, 
Data or Persistence Layer :a layer to present the data, by configuring entities, used databases, repositories.

 ### Runing and testing project :
 1. use can use IDE buttons to facilitate project runing and testing functionnalities..
 2. Using maven Commands : </br>
*Compile* </br>
mvn clean install

*Run* </br>
mvn spring-boot:run
