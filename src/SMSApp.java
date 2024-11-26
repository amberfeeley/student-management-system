import java.util.Scanner;

public class SMSApp {
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        StudentMgmtSystem sms = new StudentMgmtSystem();
        int input;

        NavMenu();

        // Add in try catch blocks for input handling
        input = keyboard.nextInt();
        switch(input)
        {   
            // These methods may be part of other objects
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
                CalculateAvgGrades();
                break;
            case 6:
                GenerateReports();
                break;
            default:
                ExitMessage();
                break;
        }
    }

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
        System.out.println("You have chosen to add a student.");
        // option to add student with grades
        // sms.AddStudent();
        // option to add student without grades
        // ???
    }
    public static void RemoveStudent()
    {
        ;
    }
    public static void UpdateStudentRecords()
    {
        ;
    }
    public static void TrackStudentGrades()
    {
        ;
    }
    public static void CalculateAvgGrades()
    {
        ;
    }
    public static void GenerateReports()
    {
        ;
    }
}
