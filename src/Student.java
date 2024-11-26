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
        subject[numOfSubjects] = addSubject(subjectName, grade);
    }

    public void setID(int id)
    {
        studentID = id;
    }
    public void setName(String n)
    {
        name = n;
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
            if (this.subject[i].getName() == subjectName)
            {
                this.subject[i].setGrade(grade);
                break;
            }
            else if (i >= numOfSubjects)
            {
                System.out.println("Subject not found for " + name + ". Please verify student enrollment in " + subjectName);
            }
        }
    }
    /**
     * Adds subject to student and maintains number of subjects count
     * @param subjectName sets subject name
     * @param grade stores student's grade in subject
     */
    public Subject addSubject(String subjectName, int grade)
    {
        numOfSubjects++;
        return new Subject(subjectName, grade);
    }
    public int getID(int id)
    {
        return studentID;
    }
    public String getName()
    {
        return name;
    }
}