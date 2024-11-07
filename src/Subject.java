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
    public Subject(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    // Setter and getter methods
    public void setName(String name) {
        this.name = name;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }
}
