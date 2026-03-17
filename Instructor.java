public class Instructor extends Person{
    private String department;

    public Instructor(String name, String id, String email, String department){

        super(name, id, email);
        this.department = department;

    }

}
