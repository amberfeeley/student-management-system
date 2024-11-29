import java.io.*;

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

    public void AddStudent(int id, String name)
    {
        if (numOfStudents < 100)
        {
            students[numOfStudents] = new Student(id, name);
            numOfStudents++;
            System.out.println("Student " + name + " has been added.");
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
            System.out.println("Student " + studentName + " has been added.");
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

    /**
     * Updates student records
     * @param name finds student by name
     * @param choice to choose choice in switch
     */
    public void UpdateStudentRecords(int id, String studentName, String subjectName, int grade, String updatedName)
    {
        for (int i = 0; i < numOfStudents; i++)
        {
            if (students[i].getName().equals(studentName))
            {
                students[i].setID(id);
                students[i].setName(updatedName);
                students[i].setSubjectGrade(subjectName, grade);
                return;
            }
        }
        System.out.println("Unable to locate " + studentName + " to update records.");
    }

    public void TrackStudentGrades(String name)
    {
        for (int i = 0; i < numOfStudents; i++)
        {
            if (students[i].getName().equals(name))
            {
                System.out.println(students[i].toString());
                return;
            }
        }
        System.out.println("Unable to locate " + name + ".");
    }
    
    public void GenerateReports() throws FileNotFoundException
    {
        if (numOfStudents == 0)
        {
            System.out.println("Unable to calculate average. No students in the system.");
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

            try
            {
                // Create output File
                File reportFile = new File("StudentGrades.txt");
                PrintWriter outputFile = new PrintWriter((reportFile));

                outputFile.write("Student Report\n");
                outputFile.write("Class Report");
                outputFile.write("\nClass average grade: " + avg);
                outputFile.write("\nThe highest performer is " + highestPerformer.toString());
                outputFile.write("\nThe lowest performer is " + lowestPerformer.toString());
                SortStudentsByGrade();
                for (Student student : students)
                {
                    student.toString();
                    outputFile.write("\n");
                }

                outputFile.close();
            }
            catch (FileNotFoundException e)
            {
                System.out.println(e);
            }
        }
    }

    // DOES NOT WORK YET
    public void SortStudentsByGrade()
    {
        // Selection sort method
        for (int i = 0; i < numOfStudents - 1; i++)
        {
            // Assume current index is highest grade
            int maxIndex = i;
            // compare current student to next in array
            for (int j = i + 1; j < numOfStudents; j++)
            {
                // Compare the average grades of the students
                if (students[j].CalculateAvgGrade() > students[maxIndex].CalculateAvgGrade())
                {
                    // If student j has a higher grade, update maxIndex
                    maxIndex = j;
                }
            }
            // If maxIndex is different from current, swap the students
            if (maxIndex != i) {
                Student temp = students[i];
                students[i] = students[maxIndex];
                students[maxIndex] = temp;
            }
        }
    }

    public void AddSubject(String studentName, String subjectName)
    {
        for (int i = 0; i < numOfStudents; i++)
        {
            if (students[i].getName().equals(studentName))
            {
                students[i].addSubject(subjectName);
            }
        }
    }

    public void AddSubjectAndGrade(String studentName, String subjectName, int grade)
    {
        for (int i = 0; i < numOfStudents; i++)
        {
            if (students[i].getName().equals(studentName))
            {
                students[i].addSubject(subjectName, grade);
            }
        }
    }

    public void UpdateGrade(String studentName, String subjectName, int grade)
    {
        // TODO
        // find student
        // find subject
        // change grade
    }
}
