public class Student extends Person {

    private String program;

    public Student(String name, String id, String email, String program) {
        super(name, id, email);
        this.program = program;
    }

    @Override
    public String getDetails() {
        return "Student: " + getName() + " ID: " + getId() + " Email: " + getEmail() + " Program: " + program;
    }

}
