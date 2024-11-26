public class Student
{
    private int studentID;
    private String name;
    private Subject[] subject;
    private int numOfSubjects;

    /**
     * no arg constructor initializes student fields to be empty
     */
    public Student()
    {
        studentID = 0;
        name = "";
        numOfSubjects = 0;
        subject = new Subject[100]; // Student cannot have more than 100 classes
    }
    /**
     * Constructor with arguments to initialize student
     * @param id stores studentID
     * @param n stores student's name
     * @param g stores student's grade
     */
    public Student(int id, String name, String subjectName, int grade)
    {
        studentID = id;
        this.name = name;
        subject = new Subject[100];
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
     * sets student grade by a given subject
     * @param subjectName used to locate subject
     * @param grade stores student's grade in subject
     */
    public void setSubjectGrade(String subjectName, int grade)
    {
        for (int i = 0; i < numOfSubjects; i++)
        {
            if (subject[i].getName().equals(subjectName))
            {
                subject[i].setGrade(grade);
                return;
            }
        }
        
        System.out.println("Subject not found for " + name + ". Please verify student enrollment in " + subjectName);
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
            subject[numOfSubjects] = new Subject(subjectName, grade);

            numOfSubjects++;
        }
        else
        {
            System.out.println("Unable to add subject. Student cannot have more than 100 subjects.");
        }
    }
    public int getID(int id)
    {
        return studentID;
    }
    public String getName()
    {
        return name;
    }

    public double CalculateAvgGrade()
    {
        int sum = 0;
        for (int i = 0; i < numOfSubjects; i++)
        {
            sum += subject[i].getGrade();
        }

        return (double)sum / numOfSubjects;
    }
}