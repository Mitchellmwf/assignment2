//subclass that extends from person
public class Instructor extends Person{

    //private field
    //added private string department
    private String department;

    //super constructor
    public Instructor(String name, String id, String email, String department){

        super(name, id, email);
        this.department = department;

    }

    //overriding person class info details from subclass instructor 
    @Override
    public String getDetails() {
        return "Instructor: " + getName() + " ID: " + getId() + " Email: " + getEmail() + " Department: " + department;
    }

}
