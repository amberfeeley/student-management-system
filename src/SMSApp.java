import java.util.Scanner;
import java.io.*;

public class SMSApp
{
    private static Scanner keyboard = new Scanner(System.in);
    private static StudentMgmtSystem sms = new StudentMgmtSystem();
    public static void main(String[] args) throws IOException
    {
        int input = -1;
        System.out.println("Welcome to the Student Management System!");
        
        do
        {
            NavMenu();
            try
            {
                input = keyboard.nextInt();
                keyboard.nextLine();

                switch(input)
                {   
                    case 1:
                        AddStudent();
                        break;
                    case 2:
                        RemoveStudent();
                        break;
                    case 3:
                        UpdateStudentRecords();
                        break;
                    case 4: 
                        TrackStudentGrades();
                        break;
                    case 5:
                        GenerateReports();
                        break;
                    case 6:
                        ImportStudentsFromFile();
                        break;
                    default:
                        ExitMessage();
                        break;
                } //end switch statement
            }
            catch (Exception e)
            {
                System.out.println("Invalid input, please try again.");
                keyboard.nextLine();
            }
        } while (input >=1 && input <=6);
} //end  main

    public static void NavMenu()
    {
        System.out.println("Navigate by entering the corresponding key.");
        System.out.println("1: Add Student");
        System.out.println("2: Remove Student");
        System.out.println("3: Update Student Records");
        System.out.println("4: Track Student Grades");
        System.out.println("5: Generate Student Reports");
        System.out.println("6: Import Student Data From File");
        System.out.println("Enter any other key to exit.");
    }

    public static void ExitMessage()
    {
        System.out.println("Thank you for exiting the Student Management System.");
    }

    // Temp holders for methods
    public static void AddStudent()
    {
        //Display message
        System.out.println("You have chosen to add a student.");
        System.out.println("Select an option:");
        System.out.println("1: Add a student without grades.");
        System.out.println("2: Add a student with grades.");

        try
        {
            // get user input
            int input = keyboard.nextInt();
            keyboard.nextLine();
            System.out.println("Enter student name: ");
            String name = keyboard.nextLine(); //Used nextLine in case there are spaces in the name
            System.out.println("Enter student ID: ");
            int id = keyboard.nextInt();
            keyboard.nextLine(); // Clears buffer

            //Switch statement to determine which method to use
            switch(input)
            { 
                case 1: //student without grades
                    sms.AddStudent(id, name); //calling the AddStudent Method from Student Mgmt System file.
                    break;
                case 2: //student with grades
                    try
                    {
                        System.out.println("Enter subject: ");
                        String subject = keyboard.nextLine();
                        System.out.println("Enter grade: ");
                        int grade = keyboard.nextInt();

                        //calling method to add student with all them parameters
                        sms.AddStudent(id, name, subject, grade);
                        break;
                    }
                    catch (Exception e)
                    {
                        System.out.println("Invalid input, please try again.");
                        keyboard.nextLine();
                    }

                default:
                    System.out.println("Invalid option. Returning to main menu.");
                    break;
            }
        }
        catch (Exception e)
        {
            System.out.println("Invalid input, please try again.");
            keyboard.nextLine();
            return; // Exits method given invalid input
        }
      
    }

    public static void RemoveStudent()
    { 
        try
        {
            System.out.println("Enter student name: ");
            String name = keyboard.nextLine();

            sms.RemoveStudent(name);
        }
        catch (Exception e)
        {
            System.out.println("Invalid input, please try again.");
            keyboard.nextLine();
        }
    }

    public static void UpdateStudentRecords()
    {
        try
        {
            System.out.println("You have chosen to update a student's records.");
            System.out.println("Select an option:");
            System.out.println("1: Add a subject and grade");
            System.out.println("2: Update a grade in a subject");
            System.out.println("3: Update a student's name, ID, and grade in a subject");

            // input
            int input = keyboard.nextInt();
            keyboard.nextLine();
            System.out.println("Enter student name: ");
            String studentName = keyboard.nextLine();
            String subjectName;
            int grade;

            switch(input)
            {
                case 1:
                    System.out.println("Enter subject name: ");
                    subjectName = keyboard.nextLine();
                    System.out.println("Enter grade: ");
                    grade = keyboard.nextInt();
                    keyboard.nextLine();
                    sms.AddSubjectAndGrade(studentName, subjectName, grade);
                    break;
                case 2:
                    System.out.println("Enter subject name: ");
                    subjectName = keyboard.nextLine();
                    System.out.println("Enter grade: ");
                    grade = keyboard.nextInt();
                    keyboard.nextLine();
                    sms.UpdateGrade(studentName, subjectName, grade);
                    break;
                case 3:
                    // get updated info
                    System.out.println("Enter updated student name: ");
                    String updatedName = keyboard.nextLine();
                    System.out.println("Enter updated student ID: ");
                    int id = keyboard.nextInt();
                    keyboard.nextLine();
                    System.out.println("Enter student subject to update: ");
                    subjectName = keyboard.nextLine();
                    System.out.println("Enter updated student grade: ");
                    grade = keyboard.nextInt();
                    keyboard.nextLine();

                    // update Student's records
                    sms.UpdateStudentRecords(id, studentName, subjectName, grade, updatedName);
                    break;
                default:
                    System.out.println("Invalid option. Returning to main menu.");
                    break;
            }
        }
        catch (Exception e)
        {
            System.out.println("Invalid input, please try again.");
            keyboard.nextLine();
            return; // Exits method given invalid input
        }
    }

    public static void TrackStudentGrades()
    {
        try
        {
            System.out.println("Enter student name: ");
            String name = keyboard.nextLine();

            sms.TrackStudentGrades(name);
        }
        catch (Exception e)
        {
            System.out.println("Invalid input, please try again.");
            keyboard.nextLine();
        }
    }

    // Generates report with Avg class grade and highest/lowest performers
    public static void GenerateReports() throws FileNotFoundException
    {
        sms.GenerateReports();
    }

    // Imports students from a file
    public static void ImportStudentsFromFile()
    {
        System.out.println("Data must be in order of student ID, student name, subject, grade");
        System.out.println("Enter the file path to import student data from:");

        try
        {
            String filePath = keyboard.nextLine();
            File file = new File(filePath);
            Scanner fileScanner = new Scanner(file);
            
            while (fileScanner.hasNextLine())
            {
                // first line is id
                int id = Integer.parseInt(fileScanner.nextLine());
                // second line is name
                String studentName = fileScanner.nextLine();
                // third line is subject
                String subjectName = fileScanner.nextLine();
                // fourth line is grade
                int grade = Integer.parseInt(fileScanner.nextLine());

                sms.AddStudent(id, studentName, subjectName, grade);
                System.out.println("Added student " + studentName);
            }
            fileScanner.close();
        } 
        catch (FileNotFoundException e)
        {
            System.out.println("File not found: ");
        } 
        catch (Exception e)
        {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
