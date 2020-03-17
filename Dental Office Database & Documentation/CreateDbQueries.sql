--CREATE DATABASE DentalOffice

--USE DentalOffice

CREATE TABLE Dentist
(
Dentist_ID int NOT NULL primary key,
Dentist_FirstName varchar(15) NOT NULL,
Dentist_LastName varchar(15) NOT NULL,
Dentist_Email varchar(30) NOT NULL,
Dentist_Contact varchar(15) NOT NULL
);

CREATE TABLE Dentist_Specialization
(
Dentist_ID int NOT NULL,
Specialization_ID int NOT NULL
);

CREATE TABLE License
(
License_Number int NOT NULL primary key,
Activation_Date date NOT NULL,
Expiry_Date date NOT NULL,
Dentist_ID int NOT NULL
);

CREATE TABLE Specialization
(
Specialization_ID int NOT NULL primary key,
Specialization_Name varchar(20) NOT NULL
);

CREATE TABLE Appointment
(
Patient_ID int NOT NULL,
Dentist_ID int NOT NULL,
Appointment_ID int NOT NULL primary key,
Start_Time datetime NOT NULL,
End_Time datetime NOT NULL,
Status char(1) NOT NULL,
Room_ID int
);

CREATE TABLE Treatment
(
Treatment_ID int NOT NULL,
--Patient_ID int NOT NULL,
--Dentist_ID int NOT NULL,
Appointment_ID int NOT NULL,
--Invoice_ID int NOT NULL
);

CREATE TABLE Treatment_Catalog
(
Treatment_ID int NOT NULL primary key,
Treatment_Name varchar(30) NOT NULL,
Cost Money NOT NULL
);

CREATE TABLE Invoice
(
Invoice_ID int NOT NULL primary key,
Amount Money NOT NULL,
Date date NOT NULL,
/*Treatment_ID int NOT NULL,
Patient_ID int NOT NULL,
Dentist_ID int NOT NULL,*/
Appointment_ID int NOT NULL UNIQUE FOREIGN KEY REFERENCES Appointment(Appointment_ID)
);

CREATE TABLE Prescription
(
Prescription_ID int NOT NULL primary key,
Date date NOT NULL,
Details varchar(500) NOT NULL,
--Patient_ID int NOT NULL,
--Dentist_ID int NOT NULL,
Appointment_ID int NOT NULL
);

CREATE TABLE Payment
(
Payment_ID int NOT NULL primary key,
Payment_Mode char(1) NOT NULL,
Payment_Amount int NOT NULL,
Date_of_Payment date NOT NULL,
Payer char(1) NOT NULL,
Invoice_ID int NOT NULL,
Patient_ID int NOT NULL,
Insurance_Number varchar(25)
);

CREATE TABLE Supplies
(
Supply_Item_ID int NOT NULL primary key,
Supply_Item_Name varchar(15) NOT NULL,
Quantity int NOT NULL,
Last_Order_Date date NOT NULL,
Price Money NOT NULL
);

CREATE TABLE Supplies_Inventory
(
Location_ID smallint NOT NULL,
Supply_Item_ID int NOT NULL,
Quantity_Available int NOT NULL
);

CREATE TABLE Location
(
Location_ID smallint NOT NULL primary key,
Address varchar(50) NOT NULL,
ZipCode int NOT NULL,
State char(5) NOT NULL
);

CREATE TABLE Room
(
Room_ID int NOT NULL primary key,
Room_Number char(4) NOT NULL,
Is_Room_Available char(1) NOT NULL,
Location_ID smallint
);

CREATE TABLE Equipment
(
Equipment_ID int NOT NULL primary key,
Equipment_Name varchar(30) NOT NULL,
Purchase_Date date NOT NULL,
Warranty int NOT NULL,
Last_Maintenance_Date date NOT NULL,
Price Money NOT NULL,
isPortable char(1) NOT NULL
);

CREATE TABLE Equipment_Location_History
(
Last_Moved_Date date NOT NULL,
Location_ID smallint NOT NULL,
Room_ID int NOT NULL,
Equipment_ID int NOT NULL
);

CREATE TABLE Patient
(
Patient_ID int NOT NULL primary key,
First_Name varchar(15) NOT NULL,
Last_Name varchar(15) NOT NULL,
Date_of_birth date NOT NULL,
Contact varchar(15) NOT NULL,
Email_ID Varchar(30) NOT NULL,
Patient_Type Char(1) NOT NULL
);

CREATE TABLE Patient_History
(
Patient_ID int NOT NULL,
Last_Updated date NOT NULL,
Medical_Condition varchar(200),
Allergies char(1) NOT NULL,
Teeth_condition char(1) NOT NULL,
Inflammation char(1),
Plaque char(1),
Palate_Condition char(1),
Teeth_Color varchar(20)
);

CREATE TABLE Patient_Cards
(
Card_Number Bigint NOT NULL primary key,
Valid_through date NOT NULL,
Patient_ID int NOT NULL
);

CREATE TABLE Patient_Address
(
Address_ID int NOT NULL primary key,
Address varchar(150) NOT NULL,
City varchar(15) NOT NULL,
State char(2) NOT NULL,
ZipCode int NOT NULL,
Patient_ID int NOT NULL
);

CREATE TABLE Patient_Insurance
(
Insurance_Number varchar(25) NOT NULL primary key,
Insurance_ID int NOT NULL,
Expiry_date date NOT NULL,
Patient_ID int NOT NULL
);

CREATE TABLE Insurance_Catalog
(
Insurance_ID int NOT NULL primary key,
Insurance_Provider_Name varchar(30) NOT NULL,
Description varchar(500)
);

/*CREATE TABLE Patient_Clinical_Data
(
Patient_ID int NOT NULL,
Dentist_ID int NOT NULL,
Appointment_ID int NOT NULL,
Teeth_condition char(1) NOT NULL,
Inflammation char(1),
Plaque char(1),
Palate_Condition char(1),
Teeth_Color varchar(10)
);*/

CREATE TABLE Patient_Tooth_Treatment
(
Tooth_Label char(3) NOT NULL,
Treatment_ID int NOT NULL,
--Patient_ID int NOT NULL,
--Dentist_ID int NOT NULL,
Appointment_ID int NOT NULL
);

CREATE TABLE Tooth_Catalog
(
Tooth_Label char(3) NOT NULL primary key,
Tooth_Quarter char(2) NOT NULL,
Adult_or_Child_tooth char(1) NOT NULL,
Tooth_name varchar(20) NOT NULL
);

CREATE TABLE Patient_Tooth_History
(
Patient_ID int NOT NULL,
Tooth_Label char(3) NOT NULL,
is_Present char(1) NOT NULL,
Last_updated Date NOT NULL
);

ALTER TABLE Dentist_Specialization
add foreign key(Specialization_ID) references Specialization(Specialization_ID)

ALTER TABLE Dentist_Specialization
add foreign key(Dentist_ID) references Dentist(Dentist_ID)

ALTER TABLE License
add foreign key(Dentist_ID) references Dentist(Dentist_ID)

ALTER TABLE Dentist_Specialization
ADD CONSTRAINT PK_Dentist_Specialization PRIMARY KEY (Dentist_ID,Specialization_ID);

ALTER TABLE Appointment
add foreign key(Dentist_ID) references Dentist(Dentist_ID)

ALTER TABLE Appointment
add foreign key(Patient_ID) references Patient(Patient_ID)

ALTER TABLE Appointment
add foreign key(Room_ID) references Room(Room_ID)

ALTER TABLE Treatment
add foreign key(Treatment_ID) references Treatment_Catalog(Treatment_ID)

/*ALTER TABLE Treatment
add foreign key(Patient_ID) references Patient(Patient_ID)

ALTER TABLE Treatment
add foreign key(Dentist_ID) references Dentist(Dentist_ID)*/

ALTER TABLE Treatment
add foreign key(Appointment_ID) references Appointment(Appointment_ID)

/*ALTER TABLE Treatment
add foreign key(Invoice_ID) references Invoice(Invoice_ID)

ALTER TABLE Prescription
add foreign key(Patient_ID) references Patient(Patient_ID)

ALTER TABLE Prescription
add foreign key(Dentist_ID) references Dentist(Dentist_ID)*/	

ALTER TABLE Prescription
add foreign key(Appointment_ID) references Appointment(Appointment_ID)

/*ALTER TABLE Invoice
add foreign key(Appointment_ID) references Appointment(Appointment_ID)

ALTER TABLE Invoice
add foreign key(Dentist_ID) references Dentist(Dentist_ID)

ALTER TABLE Invoice
add foreign key(Patient_ID) references Patient(Patient_ID)

ALTER TABLE Invoice
add foreign key(Treatment_ID) references Treatment_Catalog(Treatment_ID)

ALTER TABLE Invoice_Treatments
add foreign key(Treatment_ID) references Treatment_Catalog(Treatment_ID)

ALTER TABLE Invoice_Treatments
add foreign key(Invoice_ID) references Invoice(Invoice_ID)*/

ALTER TABLE Payment
add foreign key(Patient_ID) references Patient(Patient_ID)

ALTER TABLE Payment
add foreign key(Invoice_ID) references Invoice(Invoice_ID)

ALTER TABLE Payment
add foreign key(Insurance_Number) references Patient_Insurance(Insurance_Number)

ALTER TABLE Room
add foreign key(Location_ID) references Location(Location_ID)

ALTER TABLE Equipment_Location_History
add foreign key(Location_ID) references Location(Location_ID)

ALTER TABLE Equipment_Location_History
add foreign key(Room_ID) references Room(Room_ID)

ALTER TABLE Equipment_Location_History
add foreign key(Equipment_ID) references Equipment(Equipment_ID)

ALTER TABLE Supplies_Inventory
add foreign key(Location_ID) references Location(Location_ID)

ALTER TABLE Supplies_Inventory
add foreign key(Supply_Item_ID) references Supplies(Supply_Item_ID)

ALTER TABLE Supplies_Inventory
ADD CONSTRAINT PK_Supplies_Inventory PRIMARY KEY (Location_ID,Supply_Item_ID);

/*ALTER TABLE Patient_Clinical_Data
add foreign key(Patient_ID) references Patient(Patient_ID)

ALTER TABLE Patient_Clinical_Data
add foreign key(Dentist_ID) references Dentist(Dentist_ID)

ALTER TABLE Patient_Clinical_Data
add foreign key(Appointment_ID) references Appointment(Appointment_ID)

ALTER TABLE Patient_Tooth_Treatment_History
add foreign key(Patient_ID) references Patient(Patient_ID)*/

ALTER TABLE Patient_Tooth_Treatment
add foreign key(Appointment_ID) references Appointment(Appointment_ID)

--ALTER TABLE Patient_Tooth_Treatment
--add foreign key(Dentist_ID) references Dentist(Dentist_ID)

ALTER TABLE Patient_Tooth_Treatment
add foreign key(Treatment_ID) references Treatment_Catalog(Treatment_ID)

ALTER TABLE Patient_Tooth_Treatment
add foreign key(Tooth_Label) references Tooth_Catalog(Tooth_Label)

ALTER TABLE Patient_Tooth_History
add foreign key(Patient_ID) references Patient(Patient_ID)

ALTER TABLE Patient_Tooth_History
add foreign key(Tooth_Label) references Tooth_Catalog(Tooth_Label)

ALTER TABLE Patient_Insurance
add foreign key(Patient_ID) references Patient(Patient_ID)

ALTER TABLE Patient_Insurance
add foreign key(Insurance_ID) references Insurance_Catalog(Insurance_ID)

ALTER TABLE Patient_Address
add foreign key(Patient_ID) references Patient(Patient_ID)

ALTER TABLE Patient_Cards
add foreign key(Patient_ID) references Patient(Patient_ID)

ALTER TABLE Patient_History
add foreign key(Patient_ID) references Patient(Patient_ID)

--ALTER TABLE Patient_Clinical_Data
--ADD CONSTRAINT PK_Patient_Clinical_Data PRIMARY KEY (Dentist_ID,Patient_ID,Appointment_ID);

ALTER TABLE Patient_History
ADD PRIMARY KEY (Patient_ID);

ALTER TABLE Patient_Tooth_History
ADD CONSTRAINT PK_Patient_Tooth PRIMARY KEY (Patient_ID,Tooth_Label);

ALTER TABLE Patient_Tooth_Treatment
ADD CONSTRAINT PK_Patient_Tooth_Treatment_History PRIMARY KEY (Tooth_Label,Treatment_ID,/*Patient_ID,Dentist_ID,*/Appointment_ID);

ALTER TABLE Treatment
ADD CONSTRAINT PK_Treatment PRIMARY KEY (Treatment_ID,/*Patient_ID,Dentist_ID,*/Appointment_ID);

ALTER TABLE Equipment_Location_History
ADD CONSTRAINT PK_Equipment_Location_History PRIMARY KEY (Equipment_ID, Last_Moved_Date);
