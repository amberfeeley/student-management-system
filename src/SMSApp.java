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
        // get user input for switch
            // option to add student with grades
            // option to add student without grades
            // call sms.AddStudent(method with correct number of parameters)
        // get name/id and possibly subject/grade
    }
    public static void RemoveStudent()
    {
        ;
        // get user input for student to remove
        // sms.remove(student);
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
