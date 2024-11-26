public class Subject {
    private String name;
    private int grade;

    /**
     * No-arg constructor initializes subject fields to be empty
     */
    public Subject() {
        name = "";
        grade = 0;
    }

    /**
     * Constructor with arguments to initialize subject
     * @param name stores the subject name
     * @param grade stores the subject grade
     */
   // Constructor
    public Subject(String name, int grade) {
        this.name = name;
        setGrade(grade);
    }

    // Setter and getter methods
    public void setName(String name) {
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

    public String getName() {
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
