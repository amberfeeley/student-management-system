# CIS 3332-110 Java Programming
# Amber Feeley, Rachel Wimbley, Alexandria Cabading, Liberty Saikemal
# [GitHub Link]( https://github.com/amberfeeley/student-management-system)

## Documentation for SMSApp Software
This document provides an overview and user guide for the SMSApp software, which is a Student Management System designed to manage student records, grades, and reports. The system allows users to add, remove, update, and track student information. The system generates reports based, writes the report to a text file, and imports student data from external files.

## Overview
### Purpose
The SMSApp provides functionality to manage student data, including:
•	Adding and removing students.
•	Updating student records and grades.
•	Tracking student grades.
•	Generating performance reports.
•	Importing student data from external files.

### Main Components
The SMS is composed of four classes:
1.	SMSApp Class: The entry point of the program, handles the user interface and interaction with the StudentMgmtSystem.
2.	Student Class: Represents individual students and their associated information such as ID, name, subjects, and grades.
3.	Subject Class: Represents subjects and the grades associated with students in those subjects.
4.	StudentMgmtSystem Class: Manages the students, including adding, removing, and updating student records.

## Class Descriptions
### SMS App Class
The SMSApp class serves as the main interface for interacting with the Student Management System. It provides a menu-driven interface for the user to select actions.
Key Methods:
•	main(String[] args): The main method that initiates the application. It runs a loop displaying the navigation menu, accepts user input, and executes corresponding actions.
•	NavMenu(): Displays the main menu options to the user for navigating the application.
•	ExitMessage(): Displays a message when the user chooses to exit the application.
•	AddStudent(): Allows the user to add a new student to the system. The user can choose to add a student with or without grades.
•	RemoveStudent(): Uses student name to remove them from the system.
•	UpdateStudentRecords():  Update a student's records, such as adding a subject and grade, updating a grade, or updating a student's name, ID, and grade.
•	TrackStudentGrades(): Displays the grades of a student given the student name.
•	GenerateReports(): Generates a class report showing average grades, highest/lowest performers, and details of all students. The report is saved to a file named StudentGrades.txt.
•	ImportStudentsFromFile(): Imports student data from an external file. The file should contain student ID and name data, with one student per line.

### Student Class
The Student class represents a student with personal information, subject data, and associated grades.
Key Methods:
•	Constructor:
o	Student(int id, String name): Initializes a student with an ID and name, but no subjects or grades.
o	Student(int id, String name, String subjectName, int grade): Initializes a student with ID, name, a subject, and an initial grade.
•	addSubject(String subjectName): Adds a subject to the student's record.
•	addSubject(String subjectName, int grade): Adds a subject with a specific grade to the student's record.
•	setSubjectGrade(String subjectName, int grade): Updates the grade of a specific subject.
•	getNumOfSubjects(): Returns the number of subjects the student is enrolled in.
•	CalculateAvgGrade(): Calculates and returns the student's average grade across all subjects.
•	toString(): Returns a string representation of the student, including their name, ID, and grades for all subjects.


### Subject Class
The Subject class represents a subject that a student is enrolled in, along with the grade the student has earned in that subject.
Key Methods:
•	Constructor:
o	Subject(String name): Initializes a subject with a given name and a default grade of 0.
o	Subject(String name, int grade): Initializes a subject with a name and a specific grade.
•	setGrade(int grade): Sets the grade for the subject. It ensures the grade is between 0 and 100.
•	getGrade(): Returns the grade for the subject.
•	toString(): Returns a string representation of the subject, including the name and grade.

### StudentMgmtSystem Class

The StudentMgmtSystem class manages the collection of students, providing functionality to add, remove, update, and retrieve student records.
Key Methods:
•	AddStudent(int id, String name): Adds a student with the given ID and name to the system.
•	AddStudent(int id, String studentName, String subjectName, int grade): Adds a student with the given ID, name, subject, and grade.
•	RemoveStudent(String name): Removes a student by their name from the system.
•	UpdateStudentRecords(int id, String studentName, String subjectName, int grade, String updatedName): Updates the student’s records, including ID, name, and grades.
•	TrackStudentGrades(String name): Displays the grades of a student by name.
•	GenerateReports(): Generates a report showing the class average, highest and lowest performers, and lists all students with their grades. The report is written to a file StudentGrades.txt.
•	SortStudentsByGrade(): Sorts the students by their average grade. (Currently not functional.)

## Using the Program
### Running the program
When the program is executed, the user is presented with the following menu options:
1: Add Student
2: Remove Student
3: Update Student Records
4: Track Student Grades
5: Generate Student Reports
6: Import Student Data From File
Enter any other key to exit.

The user can enter the corresponding number to perform an action. The system will then prompt for further input, depending on the selected option.

## Error Handling
•	Invalid inputs are caught in try-catch blocks and error messages are displayed.
•	The system ensures that students cannot have more than 100 subjects, and grades must be between 0 and 100.
•	If a file cannot be found or read, an error message is displayed.

