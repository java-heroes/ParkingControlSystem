# :tada: Parking Control System :red_car:
![Ekran görüntüsü 2021-08-06 141619-04-01](https://user-images.githubusercontent.com/64933639/128504801-19ebb14f-a1f5-495b-9f70-06ecf7762a81.jpeg)
:star: This repository includes the backend of the parking control system. <br/>

[![CodeFactor](https://www.codefactor.io/repository/github/java-heroes/parkingcontrolsystem/badge)](https://www.codefactor.io/repository/github/java-heroes/parkingcontrolsystem)
![GitHub issues](https://img.shields.io/github/issues/java-heroes/ParkingControlSystem)
![GitHub closed issues](https://img.shields.io/github/issues-closed/java-heroes/ParkingControlSystem)
![GitHub pull requests](https://img.shields.io/github/issues-pr/java-heroes/ParkingControlSystem)
![GitHub closed pull requests](https://img.shields.io/github/issues-pr-closed/java-heroes/ParkingControlSystem)
![GitHub commit activity](https://img.shields.io/github/commit-activity/y/java-heroes/ParkingControlSystem)
![GitHub last commit](https://img.shields.io/github/last-commit/java-heroes/ParkingControlSystem)
![GitHub top language](https://img.shields.io/github/languages/top/java-heroes/ParkingControlSystem)
![GitHub code size in bytes](https://img.shields.io/github/languages/code-size/java-heroes/ParkingControlSystem)
![GitHub repo size](https://img.shields.io/github/repo-size/java-heroes/ParkingControlSystem)
![Lines of code](https://img.shields.io/tokei/lines/github/java-heroes/ParkingControlSystem)

## :tada: Getting Started
The project was developed in Java with Spring Boot in accordance with multi-layer architecture and SOLID principles. PostgreSQL was used for database in the project. 
The project includes CRUD operations for car park, owner, park layout, user, park rental, rental detail.

There are two types of users in the parking control system. Parking lot owners can define their businesses to the system. Users can rent parking spaces for their vehicles by registering with the system. The system, performs all operations related to the "user, the owner of the parking lot, the parking lot, the arrangement of the parking lot and the rental". Parking lot identification is done according to certain business rules. The owner of the car park must provide a valid capacity information when registering his car park in the system. According to the given capacity information, the system automatically creates the parking lot as A1, A2, ... , A10, B1, B2, ... , B10, ... and saves it to the parking layout table in the database. Parking lot rental is also carried out according to certain business rules. The system allows renting after checking whether the desired parking lot is occupied or not. When exiting the parking lot after the rental ends, the end date for the rental is updated. The system calculates the total amount according to the end date of the lease and records it in the rental detail table.

<img src="https://user-images.githubusercontent.com/64933639/128505845-d8b8a46d-1f8e-433a-ad4d-c80fd22ab5fb.jpg" alt="drawing" width="300"/>

#### Our Goals
Features such as payment service, reporting of an owner's car parks, rental reporting for businesses will be included in the project.

### Technologies
- Java
- Spring Framework
- PostgreSql

### Techniques
- Layered Architecture Design Pattern
- AOP
- JWT
- IOC

## :books: Layers
![Ekran görüntüsü 2021-08-06 133321](https://user-images.githubusercontent.com/64933639/128497830-00a3e1d5-5b13-4175-a099-9d509a425a4d.png)

N-tier application architecture provides a flexible and reusable application model. For this reason, Layered Architecture Design Pattern was used in the parking control system.

### :orange_book: [Entities Layer](https://github.com/java-heroes/ParkingControlSystem/tree/master/ParkingControlSystem/src/main/java/kodluyoruz/ParkingControlSystem/entities)
In this layer, the main classes to be used in the project are specified, that is, it is where the real objects are specified. <br/>
:open_file_folder: **Concrete folder:** Each of the classes in the concrete folder corresponds to a table in the database. <br/>
:open_file_folder: **DTOs folder:** Each of the classes in the DTOs folder contains DTO (Data Transfer Object) classes into which data from different tables are combined. <br/>
![Ekran görüntüsü 2021-08-06 134203](https://user-images.githubusercontent.com/64933639/128498718-1d83d7de-9fb0-417d-bd49-035c30c23352.png)

### :green_book: [Data Access Layer](https://github.com/java-heroes/ParkingControlSystem/tree/master/ParkingControlSystem/src/main/java/kodluyoruz/ParkingControlSystem/dataAccess/abstracts)
In this layer, database operations are performed. The task of this layer is to perform database CRUD operations. <br/>
:open_file_folder: **Abstract folder:** Abstract objects are found <br/>
![Ekran görüntüsü 2021-08-06 134549](https://user-images.githubusercontent.com/64933639/128499119-a0a9bd16-87d0-46c4-963a-12c9582bf099.png)

### :blue_book: [Business Layer](https://github.com/java-heroes/ParkingControlSystem/tree/master/ParkingControlSystem/src/main/java/kodluyoruz/ParkingControlSystem/business)
It is the layer where business rules are defined and controlled,  that will take the data taken into the project by Data Access and process it. When a command comes to the program, what actions it should perform and which set of rules it should pass through are defined here. The data from the user first goes to the Business layer, and then processed and transferred to the Data Access layer. Business layer also specifies who will access these data. <br/>
:open_file_folder: **Abstract folder:** Services have abstract objects <br/>
:open_file_folder: **Concrete folder:** There are concrete service objects <br/>
![Ekran görüntüsü 2021-08-06 134901](https://user-images.githubusercontent.com/64933639/128499521-9efc3c68-7035-4672-8a7b-4353f561578e.png)

### :closed_book: [Core Layer](https://github.com/java-heroes/ParkingControlSystem/tree/master/ParkingControlSystem/src/main/java/kodluyoruz/ParkingControlSystem/core/utilities/results)
It is a universal layer with common codes. The core layer does not reference other layers, it is independent of the project. Items to be used in the core layer are classified according to other layers and their intended use. <br/>
:open_file_folder: **Utilities folder:** <br/>
![Ekran görüntüsü 2021-08-06 135244](https://user-images.githubusercontent.com/64933639/128499896-edc4d7b1-de20-42a4-a917-bf2942509259.png)

### :open_book: [Web API](https://github.com/java-heroes/ParkingControlSystem/tree/master/ParkingControlSystem/src/main/java/kodluyoruz/ParkingControlSystem/api/controllers)
It is the part where the services that enable the Front-End part and other platforms to communicate with the program and perform operations are written.

![Ekran görüntüsü 2021-08-06 135408](https://user-images.githubusercontent.com/64933639/128500069-dc21b511-55ca-463f-a2ac-ba310084e326.png)


## :floppy_disk: Database
![db43ff1b-73e0-4935-91ea-974fd4be135f](https://user-images.githubusercontent.com/64933639/128505417-7861dae4-855c-4d21-b6f9-1b6547a07a68.jpg)

### :floppy_disk: Entity Relationship Diagram (ERD)
![git_parking_ERD](https://user-images.githubusercontent.com/64933639/126882064-d7876c1d-4ad2-486e-b62f-45ffa674582e.png)

## :package: Prerequisites
```
Java 11
Springframework 2.5.2
Spring Boot DevTools
Lombok
Spring Web 
Spring Data JPA
PostgreSQL Driver
Swagger 3.0.0
```

---------------------------------------------------

### 	:woman_technologist: Team Leader
Seda Nur Gülocak
### 	:woman_technologist: Team Members
Eda Dener <br>
Kübra Daşkın <br>
Merve Erkuş <br>
