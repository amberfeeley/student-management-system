import java.io.*;
import java.util.ArrayList;

public class StudentMgmtSystem
{
    private ArrayList<Student> students;

    /** 
     * No arg Constructor for StudentMgmtSystem
     * Fliexible 
     * initializes student count to 0
    */
    public StudentMgmtSystem() 
    {
        students = new ArrayList<>();
    }

    // Add a student without grades
    public void AddStudent(int id, String name) 
    {
        students.add(new Student(id, name));
        System.out.println("Student " + name + " has been added.");
    }
    
    // Add a student with grades
    public void AddStudent(int id, String name, String subjectName, int grade) 
    {
        students.add(new Student(id, name, subjectName, grade));
        System.out.println("Student " + name + " with subject " + subjectName + " has been added.");
    }

    // Remove a student by name
    public void RemoveStudent(String name) 
    {
        for (int i = 0; i < students.size(); i++) 
        {
            if (students.get(i).getName().equalsIgnoreCase(name)) 
            {
                students.remove(i);
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
    public void UpdateStudentRecords(int id, String oldName, String subjectName, int grade, String newName) 
    {
        for (Student student : students) 
        {
            if (student.getName().equalsIgnoreCase(oldName)) 
            {
                student.setID(id);
                student.setName(newName);
                student.setSubjectGrade(subjectName, grade);
                System.out.println("Student " + oldName + " has been updated.");
                return;
            }
        }
        System.out.println("Unable to locate student with name " + oldName);
    }

    // Add a subject for a student
    public void AddSubject(String studentName, String subjectName) 
    {
        for (Student student : students) 
        {
            if (student.getName().equalsIgnoreCase(studentName)) 
            {
                student.addSubject(subjectName);
                System.out.println("Subject " + subjectName + " has been added for " + studentName);
                return;
            }
        }
        System.out.println("Unable to locate student with name " + studentName);
    }

    // Add a subject and grade for a student
    public void AddSubjectAndGrade(String studentName, String subjectName, int grade) {
        for (Student student : students) 
        {
            if (student.getName().equalsIgnoreCase(studentName)) 
            {
                student.addSubject(subjectName, grade);
                System.out.println("Subject " + subjectName + " with grade " + grade + " has been added for " + studentName);
                return;
            }
        }
        System.out.println("Unable to locate student with name " + studentName);
    }

    // Track student grades
    public void TrackStudentGrades(String name) 
    {
        for (Student student : students) 
        {
            if (student.getName().equalsIgnoreCase(name)) 
            {
                System.out.println(student);
                return;
            }
        }
        System.out.println("Unable to locate student with name " + name);
    }
    
    // Generate reports
    public void GenerateReports() throws FileNotFoundException 
    {
        if (students.isEmpty())
        {
            System.out.println("Unable to calculate average. No students in the system.");
            return;
        }

        double avg = 0.0;
        Student highestPerformer = students.get(0);
        Student lowestPerformer = students.get(0);

        for (Student student : students) 
        {
            double average = student.CalculateAvgGrade();
            avg += average;

            if (average > highestPerformer.CalculateAvgGrade()) 
            {
                highestPerformer = student;
            }
            if (average < lowestPerformer.CalculateAvgGrade()) 
            {
                lowestPerformer = student;
            }
        }

        avg /= students.size();

        // Create output File
        try 
        {
            File reportFile = new File("StudentGrades.txt");
            PrintWriter outputFile = new PrintWriter((reportFile));

            outputFile.write("Class Report\n");
            outputFile.write("\nClass average grade: " + avg);
            outputFile.write("\nThe highest performer is " + highestPerformer.toString());
            outputFile.write("\nThe lowest performer is " + lowestPerformer.toString());

            outputFile.write("\nStudents sorted by average grade:");
            SortStudentsByGrade();
            for (Student student : students) 
            {
                outputFile.write(student.toString() + "\n");
            }
            outputFile.close();
            System.out.println("Report has been generated and saved to 'StudentGrades.txt'.");
        }
        catch(Exception e)
        {
            System.out.println("Unable to generate student report.");
        }
    }


    // Sorts students by their average grades using binary insertion sort.
    public void SortStudentsByGrade() 
    {
        for (int i = 1; i < students.size(); i++) 
        {
            Student key = students.get(i);
            double keyAvg = key.CalculateAvgGrade();
    
            // Find the position to insert using binary search
            int low = 0;
            int high = i - 1;
    
            while (low <= high) 
            {
                int mid = low + (high - low) / 2;
                if (students.get(mid).CalculateAvgGrade() > keyAvg) 
                {
                    low = mid + 1;
                } 
                else 
                {
                    high = mid - 1;
                }
            }
    
            // Shift elements to make space for the key
            for (int j = i - 1; j >= low; j--) 
            {
                students.set(j + 1, students.get(j));
            }
    
            // Insert the key at the correct position
            students.set(low, key);
        }
    
        System.out.println("Students have been sorted by average grade in ascending order.");
    }

    // Method to update a specific student's grade for a specific subject
    public void UpdateGrade(String studentName, String subjectName, int grade)
    {
        for (Student student : students) 
        {
            if (student.getName().equalsIgnoreCase(studentName)) 
            {
                try
                {
                    student.setSubjectGrade(subjectName, grade);
                }
                catch (Exception e)
                {
                    System.out.println("Unable to locate "+ subjectName + "for " + studentName);
                }
            }
        }
        System.out.println("Unable to locate " + studentName);
    }
}
