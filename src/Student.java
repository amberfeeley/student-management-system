public class Student
{
    private int studentID;
    private String name;
    private Subject[] subjects;
    private int numOfSubjects;

    /**
     * Constructor with arguments to initialize student
     * @param id stores studentID
     * @param name stores student's name
     * with no values for subjects and grades
     */
    public Student(int id, String name)
    {
        studentID = id;
        this.name = name;
        subjects = new Subject[100];
        numOfSubjects = 0;
    }

    /**
     * Constructor with arguments to initialize student
     * @param id stores studentID
     * @param name stores student's name
     * @param subjectName stores subject's name
     * @param grade stores student's grade
     */
    public Student(int id, String name, String subjectName, int grade)
    {
        studentID = id;
        this.name = name;
        subjects = new Subject[100];
        numOfSubjects = 0;
        addSubject(subjectName, grade);
    }

    public void setID(int id)
    {
        studentID = id;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Adds subject to student and maintains number of subjects count
     * @param subjectName sets subject name
     * @param grade stores student's grade in subject
     */
    public void addSubject(String subjectName)
    {
        if (numOfSubjects < 100)
        {
            subjects[numOfSubjects] = new Subject(subjectName);
            numOfSubjects++;
        }
        else
        {
            System.out.println("Unable to add subject. Student cannot have more than 100 subjects.");
        }
    }

    /**
     * Adds subject to student and maintains number of subjects count
     * @param subjectName sets subject name
     * @param grade stores student's grade in subject
     */
    public void addSubject(String subjectName, int grade)
    {
        if (numOfSubjects < 100)
        {
            subjects[numOfSubjects] = new Subject(subjectName, grade);
            numOfSubjects++;
        }
        else
        {
            System.out.println("Unable to add subject. Student cannot have more than 100 subjects.");
        }
    }
  
    /**
     * sets student grade by a given subject
     * @param subjectName used to locate subject
     * @param grade stores student's grade in subject
     */
    public void setSubjectGrade(String subjectName, int grade)
    {
        for (int i = 0; i < numOfSubjects; i++)
        {
            if (subjects[i].getSubjectName().equals(subjectName))
            {
                subjects[i].setGrade(grade);
                return;
            }
        }
        System.out.println("Subject not found for " + name + ". Please verify student enrollment in " + subjectName);
    }

    public int getID()
    {
        return studentID;
    }
    public String getName()
    {
        return name;
    }

    // Get the number of subjects
    public int getNumOfSubjects()
    {
        return numOfSubjects; // Returns the total number of subjects
    }

    // Get the name of a specific subject by index
    public String getSubjectName(int index)
    {
        if (index >= 0 && index < numOfSubjects)
        {
            return subjects[index].getSubjectName();
        }
        return null; // Returns null if the index is invalid
    }

    // 🔵 Added Method: Get the grade of a specific subject by index
    public int getSubjectGrade(int index)
    {
        if (index >= 0 && index < numOfSubjects)
        {
            return subjects[index].getGrade();
        }
        return -1; // Returns -1 if the index is invalid
    }
  
    public double CalculateAvgGrade()
    {
        if (numOfSubjects == 0)
        {
            System.out.println(" Unable to calculate " + name + " average. No grades entered.");
            return 0;
        }
        else 
        {
            int sum = 0;
            for (int i = 0; i < numOfSubjects; i++)
            {
                sum += subjects[i].getGrade();
            }

            return (double)sum / numOfSubjects;
        }
    }

    // toString Method
    public String toString() {
        StringBuilder studentInfo = new StringBuilder();
        studentInfo.append("Student Name: ").append(name).append("\n");
        studentInfo.append("Student ID: ").append(studentID).append("\n");

        for (int i = 0; i < numOfSubjects; i++) {
            studentInfo.append(subjects[i].toString()).append("\n");
        }

        return studentInfo.toString();
    }
}