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
        if (numOfStudents < 100)
        {
            students[numOfStudents] = new Student();
            numOfStudents++;
        }
        else
        {
            System.out.println("Unable to add more students.");
        }
    }
    public void AddStudent(int id, String studentName, String subjectName, int grade)
    {
        if (numOfStudents < 100)
        {
            students[numOfStudents] = new Student(id, studentName, subjectName, grade);
            numOfStudents++;
        }
        else
        {
            System.out.println("Unable to add more students.");
        }
    }
    public void RemoveStudent(String name)
    {
        for (int i = 0; i < numOfStudents; i++)
        {
            if (students[i].getName().equals(name))
            {
                // shift array over by one
                for (int j = i+1; j < numOfStudents; j++)
                {
                    students[j-1] = students[j];
                }
                // clear last spot
                students[numOfStudents - 1] = null;
                numOfStudents--;
                System.out.println("Student " + name + " has been removed.");
                return;
            }
        }
        System.out.println("Unable to locate " + name + " to delete.");
    }
    public void UpdateStudentRecords(String name)
    {
        for (int i = 0; i < numOfStudents; i++)
        {
            if (students[i].getName().equals(name))
            {
                // get input from SMSapp about what to update
                // pass choice into here
                // switch statement about updating name, id, grades, or all
            }
        }
        System.out.println("Unable to locate " + name + " to update records.");
    }
    public void TrackStudentGrades(String name)
    {
        for (int i = 0; i < numOfStudents; i++)
        {
            if (students[i].getName().equals(name))
            {
                System.out.println(students[i].toString());
            }
        }
        System.out.println("Unable to locate " + name + ".");
    }
    public void GenerateReports()
    {
        if (numOfStudents == 0)
        {
            System.out.println("Unable to calculate average. No students in the system.");
            return;
        }
        else 
        {
            double highestGrade = students[0].CalculateAvgGrade();
            Student highestPerformer = students[0];
            double lowest = students[0].CalculateAvgGrade();
            Student lowestPerformer = students[0];
            double current;
            double avg;
            double sum = 0;

            for (int i = 0; i < numOfStudents; i++)
            {
                current = students[i].CalculateAvgGrade();
                sum += current;
                if (highestGrade < current)
                {
                    highestGrade = current;
                    highestPerformer = students[i];
                }
                else if (lowest > current)
                {
                    lowest = current;
                    lowestPerformer = students[i];
                }
            };
            avg = sum / numOfStudents;

            // This should be output in a file
            System.out.println("Class Report:");
            System.out.println("Average grade: " + avg);
            System.out.println("The highest performer is " + highestPerformer.toString());
            System.out.println("The lowest performer is " + lowestPerformer.toString());
        }
    }
}
