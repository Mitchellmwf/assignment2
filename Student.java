public class Student extends Person {

    //private field
    //added private string program 
    private String program;

    //super constructor 
    public Student(String name, String id, String email, String program) {
        super(name, id, email);
        if (program == null || program.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid program name.");
        } else {
            this.program = program;
        }
    }


    //overriding person class info details from subclass student 
    @Override
    public String getDetails() {
        return "Student: " + getName() + " ID: " + getId() + " Email: " + getEmail() + " Program: " + program;
    }

    public void setProgram(String program) {
        if(program != null && !program.trim().isEmpty()){
            this.program = program;
        }
        else {
            System.out.println("Invalid program name.");
        }
    }
}
