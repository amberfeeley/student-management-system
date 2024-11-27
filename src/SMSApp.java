import java.util.Scanner;

public class SMSApp {

    private static Scanner keyboard = new Scanner(System.in);
    private static StudentMgmtSystem sms = new StudentMgmtSystem();
    public static void main(String[] args)
    {
        int input = -1;

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
        System.out.println("Welcome to the Student Management System!");
        System.out.println("Navigate by entering the corresponding key.");
        System.out.println("1: Add Student");
        System.out.println("2: Remove Student");
        System.out.println("3: Update Student Records");
        System.out.println("4: Track Student Grades");
        System.out.println("5: Calculate Student Grade Averages");
        System.out.println("6: Generate Highest and Lowest Grade Student Reports");
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

        // get user input
        int input = keyboard.nextInt();
        keyboard.nextLine();
        String name = "";
        int id = 0;

        try
        {
            System.out.println("Enter student name:");
            name = keyboard.nextLine(); //Used nextLine in case there are spaces in the name
            keyboard.nextLine();
            id = keyboard.nextInt();
            keyboard.nextLine(); //I read its a good idea to add an extra nextline after a nextInt. Something about clearing some sort of buffer to avoid issues.
        }
        catch (Exception e)
        {
            System.out.println("Invalid input, please try again.");
            keyboard.nextLine();
            return; // Exits method given invalid input
        }

        //Switch statement to determine which method to use
        switch(input)
        { 
            case 1: //student without grades
                sms.AddStudent(id, name); //calling the AddStudent Method from Student Mgmt System file.
                System.out.println("Student added without grades.");
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
                    System.out.println("Student entered with grades.");
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
    
    public static void RemoveStudent()
    { 
        try
        {
            System.out.println("Enter student name: ");
            String name = keyboard.nextLine();

            sms.RemoveStudent(name);
            System.out.println("Student has been removed.");
        }
        catch (Exception e)
        {
            System.out.println("Invalid input, please try again.");
            keyboard.nextLine();
        }
    }

    public static void UpdateStudentRecords()
    {
        ;
    }
    public static void TrackStudentGrades()
    {
        ; // I still dont know what this is supposed to do
        // maybe just the student's toString?????
    }

    // Generates report with Avg class grade and highest/lowest performers
    public static void GenerateReports()
    {
        // add outfile?
        sms.GenerateReports();
    }
}
