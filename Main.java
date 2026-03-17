

public class Main {

    //s and i are Person references pointing to Student and Instructor objects
    public static void main(String[] args) {
        Person s = new Student("Peter", "123456", "puterpeanut@email.com", "Culinary Arts");
        Person i = new Instructor("Professor. Victor", "658432", "victornation@email.com", "Science");
        
        //output the details of information added from the polymorph
        System.out.println(s.getDetails());
        System.out.println(i.getDetails());
    }
    
}

