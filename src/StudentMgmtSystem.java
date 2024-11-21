import java.util.Scanner;

public class StudentMgmtSystem
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
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
                TrackStudentGrades();
                break;
            case 3:
                CalculateAvgGrades();
                break;
            case 4:
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
        System.out.println("2: Track Student Grades");
        System.out.println("3: Calculate Student Grade Averages");
        System.out.println("4: Generate Highest and Lowest Grade Student Reports");
        System.out.println("Enter any other key to exit.");
    }

    public static void ExitMessage()
    {
        System.out.println("Thank you for exiting the Student Management System.");
    }

    // Temp holders for methods
    public static void AddStudent()
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
