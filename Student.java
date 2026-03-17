import java.util.ArrayList;

public class Student extends Person {

    //private field
    //added private string program 
    private String program;
    private ArrayList<String> courses = new ArrayList<>();

    //super constructor 
    public Student(String name, String id, String email, String program) {
        super(name, id, email);
        // Validate program input
        if (program == null || program.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid program name.");
        } else {
            this.program = program;
        }
        this.courses = new ArrayList<>();
    }


    //overriding person class info details from subclass student 
    @Override
    public String getDetails() {
        return "Student: " + getName() + ", ID: " + getId() + ", Email: " + getEmail() + ", Program: " + program + ", Courses: " + (courses.isEmpty() ? "None" : String.join(", ", courses));   
    }

    //setter for program with validation
    public void setProgram(String program) {
        if(program != null && !program.trim().isEmpty()){
            this.program = program;
        }
        else {
            System.out.println("Invalid program name.");
        }
    }

    public void addCourse(String course) {
        course = course.toUpperCase();
        if (course == null || course.trim().isEmpty() || !course.matches("\\D{4}\\d{4}")) {
            System.out.println("Invalid course code.");
            return;
        }
        else if (courses.contains(course)) {
            System.out.println("Course already added.");
            return;
        }
        this.courses.add(course.toUpperCase());
        System.out.println("Course added: " + course);
    }

    public void removeCourse(String course) {
        course = course.toUpperCase();
        if (course == null || course.trim().isEmpty()) {
            System.out.println("Invalid course code.");
            return;
        }
        else if (!courses.contains(course)) {
            System.out.println("Course not found.");
            return;
        }
        this.courses.remove(course);
        System.out.println("Course removed: " + course);
    }

    public void displayCourses() {
        if (this.courses.isEmpty()) {
            System.out.println("No courses enrolled.");
            return;
        }
        System.out.println("Enrolled courses:");
        for (String course : this.courses) {
            System.out.println(course);
        }
    }
}
