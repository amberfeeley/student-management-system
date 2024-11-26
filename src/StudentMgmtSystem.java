import java.util.Scanner;

public class StudentMgmtSystem
{
    private Student[] students;
    private int numOfStudents;

    /** No arg Constructor for StudentMgmtSystem
     * Allows a maximum of 100 students
     * initializes student count to 0
    */
    public StudentMgmtSystem()
    {
        students = new Student[100];
        numOfStudents = 0;
    }

    public void AddStudent(String name)
    {
        students[numOfStudents] = new Student();
    }
    public void AddStudent(int id, String studentName, String subjectName, int grade)
    {
        students[numOfStudents] = new Student(id, studentName, subjectName, grade);
    }
    public void RemoveStudent(String name)
    {
        for (int i = 0; i < numOfStudents; i++)
        {
            if (students[i].getName() == name)
            {
                for (int j = i+1; j < numOfStudents; j++)
                {
                    students[i] = students[j];
                }
                numOfStudents--;
                break;
            }
            else if (i >= numOfStudents)
            {
                System.out.println("Unable to locate student to remove.");
            }
        }
    }
    public void UpdateStudentRecords()
    {
        ;
    }
    public void TrackStudentGrades()
    {
        ;
    }
    public void CalculateAvgGrades()
    {
        ;
    }
    public void GenerateReports()
    {
        ;
    }
}
