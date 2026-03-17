//subclass that extends from person
public class Instructor extends Person{

    //private field
    //added private string department
    private String department;

    //super constructor
    public Instructor(String name, String id, String email, String department){

        super(name, id, email);
        if (department == null || department.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid department.");
        } 
        else {
            this.department = department;
        }

    }

    //overriding person class info details from subclass instructor 
    @Override
    public String getDetails() {
        return "Instructor: " + getName() + " ID: " + getId() + " Email: " + getEmail() + " Department: " + department;
    }

    public void setDepartment(String department) {
        if(department != null && !department.trim().isEmpty()){
            this.department = department;
        }
        else {
            System.out.println("Invalid department.");
        }
    }
}
