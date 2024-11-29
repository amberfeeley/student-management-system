public class Subject {
    private String name;
    private int grade;

    /**
     * Constructor requires subject name
     */
    public Subject(String name)
    {
        this.name = name;
        grade = 0;
    }

    /**
     * Constructor with arguments to initialize subject
     * @param name stores the subject name
     * @param grade stores the subject grade
     */
   // Constructor
    public Subject(String name, int grade) {
        setSubjectName(name);
        setGrade(grade);
    }

    // Setter and getter methods
    public void setSubjectName(String name) {
        this.name = name;
    }

    // Setter for grade with validation
    public void setGrade(int grade) {
        if (grade >= 0 && grade <= 100) {
            this.grade = grade;
        } else {
            System.out.println("Invalid grdae. Please eneter a grade between 0 and 100.");
        }
    }

    public String getSubjectName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }

    // toString Method
    public String toString() {
        return "Subject: " + name + ", Grade: " + grade;
    }
}
