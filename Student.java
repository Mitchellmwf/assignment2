import java.util.ArrayList;

public class Student extends Person {

    //private field
    //added private string program 
    private String program;
    private static ArrayList<String> courses = new ArrayList<>();

    //super constructor 
    public Student(String name, String id, String email, String program) {
        super(name, id, email);
        // Validate program input
        if (program == null || program.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid program name.");
        } else {
            this.program = program;
        }
        courses = new ArrayList<>();
    }


    //overriding person class info details from subclass student 
    @Override
    public String getDetails() {
        return "Student: " + getName() + " ID: " + getId() + " Email: " + getEmail() + " Program: " + program + " Courses: " + (courses.isEmpty() ? "None" : String.join(", ", courses));   
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
        if (course == null || course.trim().isEmpty()) {
            System.out.println("Invalid course name.");
            return;
        }
        else if (courses.contains(course)) {
            System.out.println("Course already added.");
            return;
        }
        courses.add(course);
        System.out.println("Course added: " + course);
    }

    public void removeCourse(String course) {
        if (course == null || course.trim().isEmpty()) {
            System.out.println("Invalid course name.");
            return;
        }
        else if (!courses.contains(course)) {
            System.out.println("Course not found.");
            return;
        }
        courses.remove(course);
        System.out.println("Course removed: " + course);
    }

    public void displayCourses() {
        if (courses.isEmpty()) {
            System.out.println("No courses enrolled.");
            return;
        }
        System.out.println("Enrolled courses:");
        for (String course : courses) {
            System.out.println(course);
        }
    }
}
