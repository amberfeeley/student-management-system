public class Student
{
    private int studentID;
    private String name;
    private int grade;

    /**
     * no arg constructor initializes student fields to be empty
     */
    public Student()
    {
        studentID = 0;
        name = "";
        grade = 0;
    }
    /**
     * Constructor with arguments to initialize student
     * @param id stores studentID
     * @param n stores student's name
     * @param g stores student's grade
     */
    public Student(int id, String n, int g)
    {
        studentID = id;
        name = n;
        grade = g;
    }

    public void setID(int id)
    {
        studentID = id;
    }
    public void setName(String n)
    {
        name = n;
    }
    public void setGrade(int g)
    {
        grade = g;
    }
    public int getID(int id)
    {
        return studentID;
    }
    public String setName()
    {
        return name;
    }
    public int setGrade()
    {
        return grade;
    }
}