//created abstract class easier to override from other subclasses
public abstract class Person {
    
    //Private field of Strings name, id, email
    private String name;
    private String id;
    private String email;

    //constructor assigning strings name, id, email 
    public Person(String name, String id, String email){
        //validate name, id, and email inputs and throw exceptions if invalid
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid name.");
        } else {
            this.name = name;
        }
        if (id == null || !id.matches("\\d{1,6}")) {
            throw new IllegalArgumentException("Invalid ID - Needs to be 6 numbers.");
        } else {
            this.id = id;
        }
        if (email == null || !email.contains("@") || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid email.");
        } else {
            this.email = email;
        }
    }

    //setter for name that validate if empty and spaces and will send invalid
    public void setName(String name) {
        if(name != null && !name.trim().isEmpty()){
            this.name = name;
        }
        else {
            System.out.println("Invalid name.");
        }
    }

    //setter for ID that validate if empty and 6 nums and will send invalid
    public void setId(String id) {
        if(id != null && id.matches("\\d{1,6}")){
            this.id = id;
        }
        else {
            System.out.println("Invalid ID - Needs to be 6 nums.");
        }
    }

    //setter for email that validate if empty and spaces and needs to contain @ if not will send invalid
    public void setEmail(String email) {
        if(email != null && email.contains("@") && !email.trim().isEmpty()){
            this.email = email;
        }
        else {
            System.out.println("Invalid email.");
        }
    }

    //getters return Name value
    public String getName() {
    return name;
}
    //getters return ID value
    public String getId() {
        return id;
    }

    //getters return Email value
    public String getEmail() {
        return email;
    }

    //return detail info about strings 
    public abstract String getDetails();
}
